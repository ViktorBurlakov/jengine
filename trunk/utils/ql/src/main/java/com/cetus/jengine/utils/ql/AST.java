package com.cetus.jengine.utils.ql;


import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.*;

import com.cetus.jengine.utils.ql.QLParser;
import com.cetus.jengine.utils.ql.QLLexer;


public class AST {

    public static void run(String source) throws RecognitionException {
        //String src = "((Zoo << Animal ON x.c == t.v) & (Animal >> Food) ) <<>> City";
        //String src = "(a <<< 2 + b) = (c <<< 5 + d) > -44 AND t = 7 OR abs(a.b) OR b.g not like '%ddd%'";
        //String src = "a.b.c, sss.c, abs(-1 + c.h), max(Model.c)";
        String src = "select distinct a.b.c FROM A WHERE a.x = c.g AND c.e = o.t ORDER BY a.z desc, b.x ASC, c.f LIMIT 0, 5";
        ANTLRStringStream in = new ANTLRStringStream(src);
        QLLexer lexer = new QLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        for (Object token : tokens.getTokens()) {
            System.out.println((Token)token);
        }
        QLParser parser = new QLParser(tokens);
        CommonTree tree = (CommonTree) parser.select_query().getTree();
        System.out.println();
        System.out.println(src);
        System.out.println();
    }

}
