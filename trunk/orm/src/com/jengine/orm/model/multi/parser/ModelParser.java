package com.jengine.orm.model.multi.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

class ModelParser {

    public static void main(String[] args) throws Exception{
	    ANTLRStringStream in = new ANTLRStringStream("((A << B) && (C >> D))");
	    ExprLexer lexer = new ExprLexer(in);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    ExprParser parser = new ExprParser(tokens);
        CommonTree tree = (CommonTree)parser.model_expression().getTree();
//        DOTTreeGenerator gen = new DOTTreeGenerator();
//        StringTemplate st = gen.toDOT(tree);
//        System.out.println(st);
	new ModelParser().visit(tree, 0);
    }

    public void visit(Tree tree, int level) {
        printNode(tree, level);
        for (int i=0; i < tree.getChildCount(); i++) {
            visit(tree.getChild(i), level+1);
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

