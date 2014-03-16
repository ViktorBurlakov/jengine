package com.jengine.orm.model.multi.parser;

import com.jengine.orm.model.multi.MultiModel;
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

