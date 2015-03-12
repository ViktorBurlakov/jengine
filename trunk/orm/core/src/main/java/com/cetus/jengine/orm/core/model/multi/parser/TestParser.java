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

package com.cetus.jengine.orm.core.model.multi.parser;

import com.cetus.jengine.orm.core.model.multi.MultiModel;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

class TestParser {
    private int level=0;
    private MultiModel multiModel = null;

    public static void main(String[] args) throws Exception {
        TestParser modelParser = new TestParser();
        modelParser.parse("A << B << C");
    }

    public void parse(String src) throws RecognitionException {
        ANTLRStringStream in = new ANTLRStringStream(src);
        ExprLexer lexer = new ExprLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        CommonTree tree = (CommonTree) parser.model_expression().getTree();
        visit(tree);
    }

    public void visit(Tree tree) {
        printNode(tree, level);
        for (int i=0; i < tree.getChildCount(); i++) {
            level++;
            visit(tree.getChild(i));
            level--;
        }
    }

    public void printNode(Tree tree, int level) {
        for (int i=0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.print(tree.getText());
//        System.out.print("  ---- " + tree.getType());
        System.out.println();

    }
}

