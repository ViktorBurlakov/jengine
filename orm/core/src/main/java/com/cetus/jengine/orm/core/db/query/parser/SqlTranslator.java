/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cetus.jengine.orm.core.db.query.parser;

import antlr.ASTVisitor;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.collections.AST;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SqlTranslator implements ASTVisitor {
    private List<ResultPart> parts = new ArrayList<ResultPart>();
    private List<Column> columns = new ArrayList<Column>();
    private List<Param> params = new ArrayList<Param>();
    protected int level = 0;
    protected String source;
    private boolean debug = false;

    public SqlTranslator(String source) {
        this.source = source;
    }

    public static void main(String[] args) {
        try {
            String input = "(a.b.c = 1 AND c.s.c = ? ) OR (ab.c in (1,23,3))";
            SqlParser parser = getParser(input);
            parser.where_condition();
            SqlTranslator sqlTranslator = new SqlTranslator(input);
            sqlTranslator.visit(parser.getAST());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlParser getParser(String input) throws UnsupportedEncodingException, TokenStreamException, RecognitionException {
        InputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
        SqlLexer lexer = new SqlLexer(new DataInputStream(in));
        SqlParser parser = new SqlParser(lexer);
        parser.setASTNodeClass("com.cetus.jengine.orm.core.db.query.parser.SQLCommonAST");
        return parser;
    }

    public void visit(AST node) {
        printNode(node);

        switch (node.getType()) {
            case SqlTokenTypes.QUESTION: visitParam(node); break;
            case SqlTokenTypes.COLUMN_SPEC: visitColumn(node); break;
            default: {
                for (AST child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                    level++;
                    visit(child);
                    level--;
                }
            }
        }
    }

    protected void visitParam(AST node) {
        SQLCommonAST commonAST = (SQLCommonAST) node;
        int start = commonAST.getColumn()-1;
        int end = start + commonAST.getText().length() -1;
        ResultPart part = new ResultPart(start, end, source.substring(start, end+1));

        parts.add(part);
        params.add(new Param(part));
    }

    protected void visitColumn(AST node) {
        List<SQLCommonAST> fields = new ArrayList<SQLCommonAST>();
        List<String> fieldNames = new ArrayList<String>();
        int start = -1;
        int end = -1;
        level++;
        for (AST child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getType() == SqlTokenTypes.SQL_IDENTIFIER) {
                SQLCommonAST commonAST = (SQLCommonAST) child.getFirstChild();
                fields.add(commonAST);
                fieldNames.add(commonAST.getText());
                printNode(child.getFirstChild());
                start = start == -1 ? (commonAST.getColumn() - 1) : start;
                end = end == -1 ? start + commonAST.getText().length() - 1 : end + commonAST.getText().length();
            } else if (child.getType() == SqlTokenTypes.DOT) {
                end +=  child.getText().length();
                printNode(child);
            } else {
                printNode(child);
            }
        }
        level--;

        ResultPart part = new ResultPart(start, end, source.substring(start, end+1));
        parts.add(part);
        columns.add(new Column(fieldNames, part));
    }

    private void printNode(AST node) {
        if (!debug) {
            return;
        }
        for (int i=0; i < level; i++) {
            System.out.print(" ");
        }
        System.out.print(node.getText());
        System.out.println();

    }

    public StringBuffer getResult() {
        StringBuffer result = new StringBuffer();
        int currentIndex = 0;

        for (int i=0; i < parts.size(); i++) {
            result.append(source.substring(currentIndex, parts.get(i).getStart()));
            result.append(parts.get(i).getText());
            currentIndex = parts.get(i).getEnd() + 1;
        }
        if (currentIndex < source.length()) {
            result.append(source.substring(currentIndex));
        }

        return result;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Param> getParams() {
        return params;
    }

    /* private class */

    public class ResultPart {
        private int start;
        private int end;
        private String text;

        private ResultPart(int start, int end, String text) {
            this.start = start;
            this.end = end;
            this.text = text;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "ResultPart{" +
                    "start=" + start +
                    ", end=" + end +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    public class Column {
        private List<String> columnParts = new ArrayList<String>();
        private ResultPart part;

        public Column(List<String> columnParts, ResultPart part) {
            this.columnParts = columnParts;
            this.part = part;
        }

        public List<String> getColumnParts() {
            return columnParts;
        }

        public void setColumnParts(List<String> columnParts) {
            this.columnParts = columnParts;
        }

        public ResultPart getPart() {
            return part;
        }

        public void setText(String value) {
            this.part.setText(value);
        }

        public String getText() {
            return this.part.getText();
        }

        @Override
        public String toString() {
            return "Column{" +
                    "columnParts=" + columnParts +
                    ", part=" + part +
                    '}';
        }
    }

    public class Param {
        private ResultPart part;

        public Param(ResultPart part) {
            this.part = part;
        }

        public ResultPart getPart() {
            return part;
        }

        public void setText(String value) {
            this.part.setText(value);
        }

        public String getText() {
            return this.part.getText();
        }

        @Override
        public String toString() {
            return "Param{" + part + '}';
        }
    }
}
