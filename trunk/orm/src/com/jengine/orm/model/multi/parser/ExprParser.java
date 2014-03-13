// $ANTLR 3.0.1 /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g 2014-03-13 11:07:56

package com.jengine.orm.model.multi.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ExprParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MODEL_EXPRESSION", "MODEL_NAME", "GROUP", "OPERATION", "ATOM", "WS", "LPAREN", "RPAREN", "LEFT_JOIN", "RIGHT_JOIN", "INNER_JOIN", "CHAR", "IDENTIFIER"
    };
    public static final int RPAREN=11;
    public static final int GROUP=6;
    public static final int MODEL_EXPRESSION=4;
    public static final int WS=9;
    public static final int LEFT_JOIN=12;
    public static final int IDENTIFIER=16;
    public static final int MODEL_NAME=5;
    public static final int CHAR=15;
    public static final int INNER_JOIN=14;
    public static final int ATOM=8;
    public static final int OPERATION=7;
    public static final int EOF=-1;
    public static final int RIGHT_JOIN=13;
    public static final int LPAREN=10;

        public ExprParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g"; }


    public static class model_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_name
    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:43:1: model_name : IDENTIFIER ;
    public final model_name_return model_name() throws RecognitionException {
        model_name_return retval = new model_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER1=null;

        Object IDENTIFIER1_tree=null;

        try {
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:43:12: ( IDENTIFIER )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:44:5: IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER1=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_model_name271); 
            IDENTIFIER1_tree = (Object)adaptor.create(IDENTIFIER1);
            adaptor.addChild(root_0, IDENTIFIER1_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end model_name

    public static class model_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_expression
    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:46:1: model_expression : ( atom ( operation atom )* )* ;
    public final model_expression_return model_expression() throws RecognitionException {
        model_expression_return retval = new model_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        atom_return atom2 = null;

        operation_return operation3 = null;

        atom_return atom4 = null;



        try {
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:46:17: ( ( atom ( operation atom )* )* )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:47:5: ( atom ( operation atom )* )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:47:5: ( atom ( operation atom )* )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==LPAREN||LA2_0==IDENTIFIER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:47:7: atom ( operation atom )*
            	    {
            	    pushFollow(FOLLOW_atom_in_model_expression285);
            	    atom2=atom();
            	    _fsp--;

            	    adaptor.addChild(root_0, atom2.getTree());
            	    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:47:12: ( operation atom )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( ((LA1_0>=LEFT_JOIN && LA1_0<=INNER_JOIN)) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:47:13: operation atom
            	    	    {
            	    	    pushFollow(FOLLOW_operation_in_model_expression288);
            	    	    operation3=operation();
            	    	    _fsp--;

            	    	    root_0 = (Object)adaptor.becomeRoot(operation3.getTree(), root_0);
            	    	    pushFollow(FOLLOW_atom_in_model_expression291);
            	    	    atom4=atom();
            	    	    _fsp--;

            	    	    adaptor.addChild(root_0, atom4.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end model_expression

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:49:1: atom : ( model_name | group );
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        model_name_return model_name5 = null;

        group_return group6 = null;



        try {
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:49:5: ( model_name | group )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            else if ( (LA3_0==LPAREN) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("49:1: atom : ( model_name | group );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:50:5: model_name
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_model_name_in_atom309);
                    model_name5=model_name();
                    _fsp--;

                    adaptor.addChild(root_0, model_name5.getTree());

                    }
                    break;
                case 2 :
                    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:50:18: group
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_group_in_atom313);
                    group6=group();
                    _fsp--;

                    adaptor.addChild(root_0, group6.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end atom

    public static class operation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operation
    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:52:1: operation : ( LEFT_JOIN | RIGHT_JOIN | INNER_JOIN ) ;
    public final operation_return operation() throws RecognitionException {
        operation_return retval = new operation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set7=null;

        Object set7_tree=null;

        try {
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:52:10: ( ( LEFT_JOIN | RIGHT_JOIN | INNER_JOIN ) )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:53:5: ( LEFT_JOIN | RIGHT_JOIN | INNER_JOIN )
            {
            root_0 = (Object)adaptor.nil();

            set7=(Token)input.LT(1);
            if ( (input.LA(1)>=LEFT_JOIN && input.LA(1)<=INNER_JOIN) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set7));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_operation326);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end operation

    public static class group_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start group
    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:55:1: group : LPAREN model_expression RPAREN -> ^( GROUP model_expression ) ;
    public final group_return group() throws RecognitionException {
        group_return retval = new group_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN8=null;
        Token RPAREN10=null;
        model_expression_return model_expression9 = null;


        Object LPAREN8_tree=null;
        Object RPAREN10_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_model_expression=new RewriteRuleSubtreeStream(adaptor,"rule model_expression");
        try {
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:55:6: ( LPAREN model_expression RPAREN -> ^( GROUP model_expression ) )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:56:5: LPAREN model_expression RPAREN
            {
            LPAREN8=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_group349); 
            stream_LPAREN.add(LPAREN8);

            pushFollow(FOLLOW_model_expression_in_group351);
            model_expression9=model_expression();
            _fsp--;

            stream_model_expression.add(model_expression9.getTree());
            RPAREN10=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_group353); 
            stream_RPAREN.add(RPAREN10);


            // AST REWRITE
            // elements: model_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 56:36: -> ^( GROUP model_expression )
            {
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:56:39: ^( GROUP model_expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(GROUP, "GROUP"), root_1);

                adaptor.addChild(root_1, stream_model_expression.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end group


 

    public static final BitSet FOLLOW_IDENTIFIER_in_model_name271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_model_expression285 = new BitSet(new long[]{0x0000000000017402L});
    public static final BitSet FOLLOW_operation_in_model_expression288 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_atom_in_model_expression291 = new BitSet(new long[]{0x0000000000017402L});
    public static final BitSet FOLLOW_model_name_in_atom309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_atom313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operation326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_group349 = new BitSet(new long[]{0x0000000000010C00L});
    public static final BitSet FOLLOW_model_expression_in_group351 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_group353 = new BitSet(new long[]{0x0000000000000002L});

}