// $ANTLR 3.0.1 /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g 2015-01-22 23:58:48

package com.jengine.utils.ql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MODEL_NAME", "MODEL_GROUP", "FUNCTION", "NOT_LIKE", "NOT_EQ", "IS_NULL", "IS_NOT_NULL", "IS_EMPTY", "IS_NOT_EMPTY", "NOT_IN", "NOT_BETWEEN", "FIELD", "GROUP", "TARGET", "TARGETS", "LIMIT", "GROUP_LIST", "GROUP_ITEM", "ORDER_LIST", "ORDER_ITEM", "LEFT_JOIN", "RIGHT_JOIN", "FULL_JOIN", "INNER_JOIN", "CROSS_JOIN", "SELECT_QUERY", "MODEL_EXPRESSION", "HAVING", "FROM_CLAUSE", "SELECT_CLAUSE", "WHERE_CLAUSE", "ORDER_BY_CLAUSE", "GROUP_BY_CLAUSE", "HAVING_CLAUSE", "LIMIT_CLAUSE", "EXPRESSION", "LINE_BREACK", "WS", "ML_COMMENT", "SEMI", "DOT", "COMMA", "OPEN_PAREN", "CLOSE_PAREN", "STAR", "AT_SIGN", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CHAR", "DIGIT", "STRING", "NUM", "PLUS", "MINUS", "NUMBER", "BOOLEAN", "DATETIME", "NULL", "DIVIDE", "VERTBAR", "EQ", "QUESTION", "GT", "LT", "LE", "GE", "NOT", "OR", "XOR", "AND", "MOD", "BITWISE_AND", "BITWISE_XOR", "BITWISE_LEFT", "BITWISE_RIGHT", "BIT_INVERSION", "ON", "IS", "IN", "LIKE", "ESCAPE", "EMPTY", "BETWEEN", "ASC", "DESC", "DISTINCT", "SELECT", "FROM", "WHERE", "ORDER", "BY", "LEFT", "JOIN", "OUTER", "RIGHT", "FULL", "INNER", "CROSS", "IDENTIFIER", "'<<'", "'>>'", "'^'", "'&'", "'<<>>'"
    };
    public static final int FUNCTION=6;
    public static final int ORDER_LIST=22;
    public static final int LT=91;
    public static final int STAR=48;
    public static final int MOD=98;
    public static final int FULL_JOIN=26;
    public static final int CHAR=76;
    public static final int GROUP_LIST=20;
    public static final int NOT=94;
    public static final int EOF=-1;
    public static final int IS_EMPTY=11;
    public static final int CROSS_JOIN=28;
    public static final int RIGHT_JOIN=25;
    public static final int BITWISE_RIGHT=102;
    public static final int ORDER_ITEM=23;
    public static final int FULL=123;
    public static final int LINE_BREACK=40;
    public static final int ESCAPE=108;
    public static final int IS_NULL=9;
    public static final int BITWISE_XOR=100;
    public static final int SELECT_CLAUSE=33;
    public static final int CLOSE_PAREN=47;
    public static final int EQ=88;
    public static final int SELECT=114;
    public static final int IS_NOT_EMPTY=12;
    public static final int DIVIDE=86;
    public static final int D=53;
    public static final int E=54;
    public static final int GE=93;
    public static final int F=55;
    public static final int G=56;
    public static final int A=50;
    public static final int B=51;
    public static final int ASC=111;
    public static final int C=52;
    public static final int L=61;
    public static final int M=62;
    public static final int N=63;
    public static final int O=64;
    public static final int H=57;
    public static final int I=58;
    public static final int NULL=85;
    public static final int J=59;
    public static final int K=60;
    public static final int NUMBER=82;
    public static final int U=70;
    public static final int ON=104;
    public static final int T=69;
    public static final int AT_SIGN=49;
    public static final int W=72;
    public static final int V=71;
    public static final int Q=66;
    public static final int P=65;
    public static final int INNER_JOIN=27;
    public static final int S=68;
    public static final int R=67;
    public static final int Y=74;
    public static final int X=73;
    public static final int EMPTY=109;
    public static final int Z=75;
    public static final int GROUP=16;
    public static final int GROUP_BY_CLAUSE=36;
    public static final int WS=41;
    public static final int GROUP_ITEM=21;
    public static final int ORDER_BY_CLAUSE=35;
    public static final int NOT_IN=13;
    public static final int OR=95;
    public static final int GT=90;
    public static final int FIELD=15;
    public static final int FROM=115;
    public static final int DISTINCT=113;
    public static final int LIMIT_CLAUSE=38;
    public static final int WHERE=116;
    public static final int BITWISE_AND=99;
    public static final int LEFT_JOIN=24;
    public static final int INNER=124;
    public static final int BIT_INVERSION=103;
    public static final int SELECT_QUERY=29;
    public static final int ORDER=117;
    public static final int LIMIT=19;
    public static final int AND=97;
    public static final int MODEL_GROUP=5;
    public static final int CROSS=125;
    public static final int FROM_CLAUSE=32;
    public static final int ML_COMMENT=42;
    public static final int WHERE_CLAUSE=34;
    public static final int BOOLEAN=83;
    public static final int IN=106;
    public static final int HAVING_CLAUSE=37;
    public static final int COMMA=45;
    public static final int IS=105;
    public static final int IDENTIFIER=126;
    public static final int LEFT=119;
    public static final int PLUS=80;
    public static final int DIGIT=77;
    public static final int DOT=44;
    public static final int EXPRESSION=39;
    public static final int LIKE=107;
    public static final int OUTER=121;
    public static final int BY=118;
    public static final int MODEL_EXPRESSION=30;
    public static final int XOR=96;
    public static final int DATETIME=84;
    public static final int NOT_LIKE=7;
    public static final int NOT_BETWEEN=14;
    public static final int OPEN_PAREN=46;
    public static final int RIGHT=122;
    public static final int BITWISE_LEFT=101;
    public static final int HAVING=31;
    public static final int TARGET=17;
    public static final int IS_NOT_NULL=10;
    public static final int MINUS=81;
    public static final int SEMI=43;
    public static final int JOIN=120;
    public static final int NOT_EQ=8;
    public static final int NUM=79;
    public static final int TARGETS=18;
    public static final int VERTBAR=87;
    public static final int QUESTION=89;
    public static final int MODEL_NAME=4;
    public static final int DESC=112;
    public static final int BETWEEN=110;
    public static final int LE=92;
    public static final int STRING=78;

        public QLParser(TokenStream input) {
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
    public String getGrammarFileName() { return "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g"; }


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start query
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:163:1: query : select_query ;
    public final query_return query() throws RecognitionException {
        query_return retval = new query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        select_query_return select_query1 = null;



        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:163:6: ( select_query )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:164:2: select_query
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_select_query_in_query2119);
            select_query1=select_query();
            _fsp--;

            adaptor.addChild(root_0, select_query1.getTree());

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
    // $ANTLR end query

    public static class select_query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start select_query
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:167:1: select_query : ( select_clause )? from_clause ( where_clause )? ( order_by_clause )? ( group_by_clause )? ( having_clause )? ( limit_clause )? -> ^( SELECT_QUERY ( select_clause )? from_clause ( where_clause )? ( order_by_clause )? ( group_by_clause )? ( having_clause )? ( limit_clause )? ) ;
    public final select_query_return select_query() throws RecognitionException {
        select_query_return retval = new select_query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        select_clause_return select_clause2 = null;

        from_clause_return from_clause3 = null;

        where_clause_return where_clause4 = null;

        order_by_clause_return order_by_clause5 = null;

        group_by_clause_return group_by_clause6 = null;

        having_clause_return having_clause7 = null;

        limit_clause_return limit_clause8 = null;


        RewriteRuleSubtreeStream stream_select_clause=new RewriteRuleSubtreeStream(adaptor,"rule select_clause");
        RewriteRuleSubtreeStream stream_from_clause=new RewriteRuleSubtreeStream(adaptor,"rule from_clause");
        RewriteRuleSubtreeStream stream_having_clause=new RewriteRuleSubtreeStream(adaptor,"rule having_clause");
        RewriteRuleSubtreeStream stream_limit_clause=new RewriteRuleSubtreeStream(adaptor,"rule limit_clause");
        RewriteRuleSubtreeStream stream_order_by_clause=new RewriteRuleSubtreeStream(adaptor,"rule order_by_clause");
        RewriteRuleSubtreeStream stream_where_clause=new RewriteRuleSubtreeStream(adaptor,"rule where_clause");
        RewriteRuleSubtreeStream stream_group_by_clause=new RewriteRuleSubtreeStream(adaptor,"rule group_by_clause");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:167:13: ( ( select_clause )? from_clause ( where_clause )? ( order_by_clause )? ( group_by_clause )? ( having_clause )? ( limit_clause )? -> ^( SELECT_QUERY ( select_clause )? from_clause ( where_clause )? ( order_by_clause )? ( group_by_clause )? ( having_clause )? ( limit_clause )? ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:2: ( select_clause )? from_clause ( where_clause )? ( order_by_clause )? ( group_by_clause )? ( having_clause )? ( limit_clause )?
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:2: ( select_clause )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SELECT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:2: select_clause
                    {
                    pushFollow(FOLLOW_select_clause_in_select_query2133);
                    select_clause2=select_clause();
                    _fsp--;

                    stream_select_clause.add(select_clause2.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_from_clause_in_select_query2136);
            from_clause3=from_clause();
            _fsp--;

            stream_from_clause.add(from_clause3.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:29: ( where_clause )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WHERE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:29: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_select_query2138);
                    where_clause4=where_clause();
                    _fsp--;

                    stream_where_clause.add(where_clause4.getTree());

                    }
                    break;

            }

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:43: ( order_by_clause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ORDER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:43: order_by_clause
                    {
                    pushFollow(FOLLOW_order_by_clause_in_select_query2141);
                    order_by_clause5=order_by_clause();
                    _fsp--;

                    stream_order_by_clause.add(order_by_clause5.getTree());

                    }
                    break;

            }

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:60: ( group_by_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GROUP) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:60: group_by_clause
                    {
                    pushFollow(FOLLOW_group_by_clause_in_select_query2144);
                    group_by_clause6=group_by_clause();
                    _fsp--;

                    stream_group_by_clause.add(group_by_clause6.getTree());

                    }
                    break;

            }

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:77: ( having_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==HAVING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:77: having_clause
                    {
                    pushFollow(FOLLOW_having_clause_in_select_query2147);
                    having_clause7=having_clause();
                    _fsp--;

                    stream_having_clause.add(having_clause7.getTree());

                    }
                    break;

            }

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:92: ( limit_clause )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LIMIT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:168:92: limit_clause
                    {
                    pushFollow(FOLLOW_limit_clause_in_select_query2150);
                    limit_clause8=limit_clause();
                    _fsp--;

                    stream_limit_clause.add(limit_clause8.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: order_by_clause, select_clause, group_by_clause, having_clause, from_clause, where_clause, limit_clause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 169:2: -> ^( SELECT_QUERY ( select_clause )? from_clause ( where_clause )? ( order_by_clause )? ( group_by_clause )? ( having_clause )? ( limit_clause )? )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:169:5: ^( SELECT_QUERY ( select_clause )? from_clause ( where_clause )? ( order_by_clause )? ( group_by_clause )? ( having_clause )? ( limit_clause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(SELECT_QUERY, "SELECT_QUERY"), root_1);

                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:169:20: ( select_clause )?
                if ( stream_select_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_select_clause.next());

                }
                stream_select_clause.reset();
                adaptor.addChild(root_1, stream_from_clause.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:169:47: ( where_clause )?
                if ( stream_where_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_where_clause.next());

                }
                stream_where_clause.reset();
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:169:61: ( order_by_clause )?
                if ( stream_order_by_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_order_by_clause.next());

                }
                stream_order_by_clause.reset();
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:169:78: ( group_by_clause )?
                if ( stream_group_by_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_group_by_clause.next());

                }
                stream_group_by_clause.reset();
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:169:95: ( having_clause )?
                if ( stream_having_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_having_clause.next());

                }
                stream_having_clause.reset();
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:169:110: ( limit_clause )?
                if ( stream_limit_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_limit_clause.next());

                }
                stream_limit_clause.reset();

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
    // $ANTLR end select_query

    public static class select_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start select_clause
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:172:1: select_clause : SELECT (d= DISTINCT )? targets -> ^( SELECT_CLAUSE targets ( $d)? ) ;
    public final select_clause_return select_clause() throws RecognitionException {
        select_clause_return retval = new select_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token d=null;
        Token SELECT9=null;
        targets_return targets10 = null;


        Object d_tree=null;
        Object SELECT9_tree=null;
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleTokenStream stream_DISTINCT=new RewriteRuleTokenStream(adaptor,"token DISTINCT");
        RewriteRuleSubtreeStream stream_targets=new RewriteRuleSubtreeStream(adaptor,"rule targets");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:172:14: ( SELECT (d= DISTINCT )? targets -> ^( SELECT_CLAUSE targets ( $d)? ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:173:2: SELECT (d= DISTINCT )? targets
            {
            SELECT9=(Token)input.LT(1);
            match(input,SELECT,FOLLOW_SELECT_in_select_clause2191); 
            stream_SELECT.add(SELECT9);

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:173:9: (d= DISTINCT )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DISTINCT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:173:10: d= DISTINCT
                    {
                    d=(Token)input.LT(1);
                    match(input,DISTINCT,FOLLOW_DISTINCT_in_select_clause2196); 
                    stream_DISTINCT.add(d);


                    }
                    break;

            }

            pushFollow(FOLLOW_targets_in_select_clause2200);
            targets10=targets();
            _fsp--;

            stream_targets.add(targets10.getTree());

            // AST REWRITE
            // elements: targets, d
            // token labels: d
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 173:31: -> ^( SELECT_CLAUSE targets ( $d)? )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:173:34: ^( SELECT_CLAUSE targets ( $d)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(SELECT_CLAUSE, "SELECT_CLAUSE"), root_1);

                adaptor.addChild(root_1, stream_targets.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:173:58: ( $d)?
                if ( stream_d.hasNext() ) {
                    adaptor.addChild(root_1, stream_d.next());

                }
                stream_d.reset();

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
    // $ANTLR end select_clause

    public static class from_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start from_clause
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:176:1: from_clause : FROM model_expression -> ^( FROM_CLAUSE model_expression ) ;
    public final from_clause_return from_clause() throws RecognitionException {
        from_clause_return retval = new from_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FROM11=null;
        model_expression_return model_expression12 = null;


        Object FROM11_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleSubtreeStream stream_model_expression=new RewriteRuleSubtreeStream(adaptor,"rule model_expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:176:12: ( FROM model_expression -> ^( FROM_CLAUSE model_expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:177:2: FROM model_expression
            {
            FROM11=(Token)input.LT(1);
            match(input,FROM,FOLLOW_FROM_in_from_clause2225); 
            stream_FROM.add(FROM11);

            pushFollow(FOLLOW_model_expression_in_from_clause2227);
            model_expression12=model_expression();
            _fsp--;

            stream_model_expression.add(model_expression12.getTree());

            // AST REWRITE
            // elements: model_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 177:24: -> ^( FROM_CLAUSE model_expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:177:27: ^( FROM_CLAUSE model_expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FROM_CLAUSE, "FROM_CLAUSE"), root_1);

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
    // $ANTLR end from_clause

    public static class where_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start where_clause
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:180:1: where_clause : WHERE expression -> ^( WHERE_CLAUSE expression ) ;
    public final where_clause_return where_clause() throws RecognitionException {
        where_clause_return retval = new where_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE13=null;
        expression_return expression14 = null;


        Object WHERE13_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:180:13: ( WHERE expression -> ^( WHERE_CLAUSE expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:181:2: WHERE expression
            {
            WHERE13=(Token)input.LT(1);
            match(input,WHERE,FOLLOW_WHERE_in_where_clause2248); 
            stream_WHERE.add(WHERE13);

            pushFollow(FOLLOW_expression_in_where_clause2250);
            expression14=expression();
            _fsp--;

            stream_expression.add(expression14.getTree());

            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 181:20: -> ^( WHERE_CLAUSE expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:181:23: ^( WHERE_CLAUSE expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WHERE_CLAUSE, "WHERE_CLAUSE"), root_1);

                adaptor.addChild(root_1, stream_expression.next());

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
    // $ANTLR end where_clause

    public static class order_by_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start order_by_clause
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:184:1: order_by_clause : ORDER BY order_item_list_expression -> ^( ORDER_BY_CLAUSE order_item_list_expression ) ;
    public final order_by_clause_return order_by_clause() throws RecognitionException {
        order_by_clause_return retval = new order_by_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER15=null;
        Token BY16=null;
        order_item_list_expression_return order_item_list_expression17 = null;


        Object ORDER15_tree=null;
        Object BY16_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleSubtreeStream stream_order_item_list_expression=new RewriteRuleSubtreeStream(adaptor,"rule order_item_list_expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:184:16: ( ORDER BY order_item_list_expression -> ^( ORDER_BY_CLAUSE order_item_list_expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:185:2: ORDER BY order_item_list_expression
            {
            ORDER15=(Token)input.LT(1);
            match(input,ORDER,FOLLOW_ORDER_in_order_by_clause2272); 
            stream_ORDER.add(ORDER15);

            BY16=(Token)input.LT(1);
            match(input,BY,FOLLOW_BY_in_order_by_clause2274); 
            stream_BY.add(BY16);

            pushFollow(FOLLOW_order_item_list_expression_in_order_by_clause2276);
            order_item_list_expression17=order_item_list_expression();
            _fsp--;

            stream_order_item_list_expression.add(order_item_list_expression17.getTree());

            // AST REWRITE
            // elements: order_item_list_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 185:38: -> ^( ORDER_BY_CLAUSE order_item_list_expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:185:41: ^( ORDER_BY_CLAUSE order_item_list_expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ORDER_BY_CLAUSE, "ORDER_BY_CLAUSE"), root_1);

                adaptor.addChild(root_1, stream_order_item_list_expression.next());

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
    // $ANTLR end order_by_clause

    public static class group_by_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start group_by_clause
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:188:1: group_by_clause : GROUP BY group_item_list_expression -> ^( GROUP_BY_CLAUSE group_item_list_expression ) ;
    public final group_by_clause_return group_by_clause() throws RecognitionException {
        group_by_clause_return retval = new group_by_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GROUP18=null;
        Token BY19=null;
        group_item_list_expression_return group_item_list_expression20 = null;


        Object GROUP18_tree=null;
        Object BY19_tree=null;
        RewriteRuleTokenStream stream_GROUP=new RewriteRuleTokenStream(adaptor,"token GROUP");
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleSubtreeStream stream_group_item_list_expression=new RewriteRuleSubtreeStream(adaptor,"rule group_item_list_expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:188:16: ( GROUP BY group_item_list_expression -> ^( GROUP_BY_CLAUSE group_item_list_expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:189:2: GROUP BY group_item_list_expression
            {
            GROUP18=(Token)input.LT(1);
            match(input,GROUP,FOLLOW_GROUP_in_group_by_clause2297); 
            stream_GROUP.add(GROUP18);

            BY19=(Token)input.LT(1);
            match(input,BY,FOLLOW_BY_in_group_by_clause2299); 
            stream_BY.add(BY19);

            pushFollow(FOLLOW_group_item_list_expression_in_group_by_clause2301);
            group_item_list_expression20=group_item_list_expression();
            _fsp--;

            stream_group_item_list_expression.add(group_item_list_expression20.getTree());

            // AST REWRITE
            // elements: group_item_list_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 189:38: -> ^( GROUP_BY_CLAUSE group_item_list_expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:189:41: ^( GROUP_BY_CLAUSE group_item_list_expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(GROUP_BY_CLAUSE, "GROUP_BY_CLAUSE"), root_1);

                adaptor.addChild(root_1, stream_group_item_list_expression.next());

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
    // $ANTLR end group_by_clause

    public static class having_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start having_clause
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:192:1: having_clause : HAVING having_expression -> ^( HAVING_CLAUSE having_expression ) ;
    public final having_clause_return having_clause() throws RecognitionException {
        having_clause_return retval = new having_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token HAVING21=null;
        having_expression_return having_expression22 = null;


        Object HAVING21_tree=null;
        RewriteRuleTokenStream stream_HAVING=new RewriteRuleTokenStream(adaptor,"token HAVING");
        RewriteRuleSubtreeStream stream_having_expression=new RewriteRuleSubtreeStream(adaptor,"rule having_expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:192:14: ( HAVING having_expression -> ^( HAVING_CLAUSE having_expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:193:2: HAVING having_expression
            {
            HAVING21=(Token)input.LT(1);
            match(input,HAVING,FOLLOW_HAVING_in_having_clause2322); 
            stream_HAVING.add(HAVING21);

            pushFollow(FOLLOW_having_expression_in_having_clause2324);
            having_expression22=having_expression();
            _fsp--;

            stream_having_expression.add(having_expression22.getTree());

            // AST REWRITE
            // elements: having_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 193:27: -> ^( HAVING_CLAUSE having_expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:193:30: ^( HAVING_CLAUSE having_expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(HAVING_CLAUSE, "HAVING_CLAUSE"), root_1);

                adaptor.addChild(root_1, stream_having_expression.next());

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
    // $ANTLR end having_clause

    public static class limit_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start limit_clause
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:196:1: limit_clause : LIMIT limit -> ^( LIMIT_CLAUSE limit ) ;
    public final limit_clause_return limit_clause() throws RecognitionException {
        limit_clause_return retval = new limit_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LIMIT23=null;
        limit_return limit24 = null;


        Object LIMIT23_tree=null;
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
        RewriteRuleSubtreeStream stream_limit=new RewriteRuleSubtreeStream(adaptor,"rule limit");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:196:13: ( LIMIT limit -> ^( LIMIT_CLAUSE limit ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:197:2: LIMIT limit
            {
            LIMIT23=(Token)input.LT(1);
            match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2345); 
            stream_LIMIT.add(LIMIT23);

            pushFollow(FOLLOW_limit_in_limit_clause2347);
            limit24=limit();
            _fsp--;

            stream_limit.add(limit24.getTree());

            // AST REWRITE
            // elements: limit
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 197:14: -> ^( LIMIT_CLAUSE limit )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:197:17: ^( LIMIT_CLAUSE limit )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(LIMIT_CLAUSE, "LIMIT_CLAUSE"), root_1);

                adaptor.addChild(root_1, stream_limit.next());

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
    // $ANTLR end limit_clause

    public static class targets_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start targets
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:203:1: targets : target ( COMMA target )* -> ^( TARGETS target ( target )* ) ;
    public final targets_return targets() throws RecognitionException {
        targets_return retval = new targets_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA26=null;
        target_return target25 = null;

        target_return target27 = null;


        Object COMMA26_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_target=new RewriteRuleSubtreeStream(adaptor,"rule target");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:203:8: ( target ( COMMA target )* -> ^( TARGETS target ( target )* ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:204:2: target ( COMMA target )*
            {
            pushFollow(FOLLOW_target_in_targets2372);
            target25=target();
            _fsp--;

            stream_target.add(target25.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:204:9: ( COMMA target )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:204:10: COMMA target
            	    {
            	    COMMA26=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_targets2375); 
            	    stream_COMMA.add(COMMA26);

            	    pushFollow(FOLLOW_target_in_targets2377);
            	    target27=target();
            	    _fsp--;

            	    stream_target.add(target27.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // AST REWRITE
            // elements: target, target
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 204:25: -> ^( TARGETS target ( target )* )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:204:28: ^( TARGETS target ( target )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TARGETS, "TARGETS"), root_1);

                adaptor.addChild(root_1, stream_target.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:204:45: ( target )*
                while ( stream_target.hasNext() ) {
                    adaptor.addChild(root_1, stream_target.next());

                }
                stream_target.reset();

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
    // $ANTLR end targets

    public static class target_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start target
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:207:1: target : expression -> ^( TARGET expression ) ;
    public final target_return target() throws RecognitionException {
        target_return retval = new target_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        expression_return expression28 = null;


        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:207:7: ( expression -> ^( TARGET expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:208:2: expression
            {
            pushFollow(FOLLOW_expression_in_target2405);
            expression28=expression();
            _fsp--;

            stream_expression.add(expression28.getTree());

            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 208:13: -> ^( TARGET expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:208:16: ^( TARGET expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TARGET, "TARGET"), root_1);

                adaptor.addChild(root_1, stream_expression.next());

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
    // $ANTLR end target

    public static class model_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_expression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:214:1: model_expression : ( model_expression_item )* -> ^( MODEL_EXPRESSION ( model_expression_item )* ) ;
    public final model_expression_return model_expression() throws RecognitionException {
        model_expression_return retval = new model_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        model_expression_item_return model_expression_item29 = null;


        RewriteRuleSubtreeStream stream_model_expression_item=new RewriteRuleSubtreeStream(adaptor,"rule model_expression_item");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:214:17: ( ( model_expression_item )* -> ^( MODEL_EXPRESSION ( model_expression_item )* ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:215:2: ( model_expression_item )*
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:215:2: ( model_expression_item )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==OPEN_PAREN||LA9_0==IDENTIFIER) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:215:2: model_expression_item
            	    {
            	    pushFollow(FOLLOW_model_expression_item_in_model_expression2429);
            	    model_expression_item29=model_expression_item();
            	    _fsp--;

            	    stream_model_expression_item.add(model_expression_item29.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // AST REWRITE
            // elements: model_expression_item
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 215:25: -> ^( MODEL_EXPRESSION ( model_expression_item )* )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:215:28: ^( MODEL_EXPRESSION ( model_expression_item )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(MODEL_EXPRESSION, "MODEL_EXPRESSION"), root_1);

                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:215:47: ( model_expression_item )*
                while ( stream_model_expression_item.hasNext() ) {
                    adaptor.addChild(root_1, stream_model_expression_item.next());

                }
                stream_model_expression_item.reset();

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
    // $ANTLR end model_expression

    public static class model_expression_item_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_expression_item
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:218:1: model_expression_item : model_expression_atom ( model_operation model_expression_atom ( ON logicalExpression )? )* ;
    public final model_expression_item_return model_expression_item() throws RecognitionException {
        model_expression_item_return retval = new model_expression_item_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ON33=null;
        model_expression_atom_return model_expression_atom30 = null;

        model_operation_return model_operation31 = null;

        model_expression_atom_return model_expression_atom32 = null;

        logicalExpression_return logicalExpression34 = null;


        Object ON33_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:218:22: ( model_expression_atom ( model_operation model_expression_atom ( ON logicalExpression )? )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:219:2: model_expression_atom ( model_operation model_expression_atom ( ON logicalExpression )? )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_model_expression_atom_in_model_expression_item2452);
            model_expression_atom30=model_expression_atom();
            _fsp--;

            adaptor.addChild(root_0, model_expression_atom30.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:219:24: ( model_operation model_expression_atom ( ON logicalExpression )? )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==LEFT||(LA11_0>=RIGHT && LA11_0<=CROSS)||(LA11_0>=127 && LA11_0<=131)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:219:25: model_operation model_expression_atom ( ON logicalExpression )?
            	    {
            	    pushFollow(FOLLOW_model_operation_in_model_expression_item2455);
            	    model_operation31=model_operation();
            	    _fsp--;

            	    root_0 = (Object)adaptor.becomeRoot(model_operation31.getTree(), root_0);
            	    pushFollow(FOLLOW_model_expression_atom_in_model_expression_item2458);
            	    model_expression_atom32=model_expression_atom();
            	    _fsp--;

            	    adaptor.addChild(root_0, model_expression_atom32.getTree());
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:219:64: ( ON logicalExpression )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==ON) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:219:65: ON logicalExpression
            	            {
            	            ON33=(Token)input.LT(1);
            	            match(input,ON,FOLLOW_ON_in_model_expression_item2461); 
            	            ON33_tree = (Object)adaptor.create(ON33);
            	            adaptor.addChild(root_0, ON33_tree);

            	            pushFollow(FOLLOW_logicalExpression_in_model_expression_item2463);
            	            logicalExpression34=logicalExpression();
            	            _fsp--;

            	            adaptor.addChild(root_0, logicalExpression34.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end model_expression_item

    public static class model_expression_atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_expression_atom
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:222:1: model_expression_atom : ( model_name | model_group );
    public final model_expression_atom_return model_expression_atom() throws RecognitionException {
        model_expression_atom_return retval = new model_expression_atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        model_name_return model_name35 = null;

        model_group_return model_group36 = null;



        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:222:22: ( model_name | model_group )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENTIFIER) ) {
                alt12=1;
            }
            else if ( (LA12_0==OPEN_PAREN) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("222:1: model_expression_atom : ( model_name | model_group );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:223:2: model_name
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_model_name_in_model_expression_atom2480);
                    model_name35=model_name();
                    _fsp--;

                    adaptor.addChild(root_0, model_name35.getTree());

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:223:15: model_group
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_model_group_in_model_expression_atom2484);
                    model_group36=model_group();
                    _fsp--;

                    adaptor.addChild(root_0, model_group36.getTree());

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
    // $ANTLR end model_expression_atom

    public static class model_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_name
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:226:1: model_name : IDENTIFIER ( DOT IDENTIFIER )* -> ^( MODEL_NAME IDENTIFIER ( DOT IDENTIFIER )* ) ;
    public final model_name_return model_name() throws RecognitionException {
        model_name_return retval = new model_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER37=null;
        Token DOT38=null;
        Token IDENTIFIER39=null;

        Object IDENTIFIER37_tree=null;
        Object DOT38_tree=null;
        Object IDENTIFIER39_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:226:12: ( IDENTIFIER ( DOT IDENTIFIER )* -> ^( MODEL_NAME IDENTIFIER ( DOT IDENTIFIER )* ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:227:2: IDENTIFIER ( DOT IDENTIFIER )*
            {
            IDENTIFIER37=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_model_name2499); 
            stream_IDENTIFIER.add(IDENTIFIER37);

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:227:13: ( DOT IDENTIFIER )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==DOT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:227:14: DOT IDENTIFIER
            	    {
            	    DOT38=(Token)input.LT(1);
            	    match(input,DOT,FOLLOW_DOT_in_model_name2502); 
            	    stream_DOT.add(DOT38);

            	    IDENTIFIER39=(Token)input.LT(1);
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_model_name2504); 
            	    stream_IDENTIFIER.add(IDENTIFIER39);


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            // AST REWRITE
            // elements: IDENTIFIER, IDENTIFIER, DOT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 227:31: -> ^( MODEL_NAME IDENTIFIER ( DOT IDENTIFIER )* )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:227:34: ^( MODEL_NAME IDENTIFIER ( DOT IDENTIFIER )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(MODEL_NAME, "MODEL_NAME"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:227:58: ( DOT IDENTIFIER )*
                while ( stream_IDENTIFIER.hasNext()||stream_DOT.hasNext() ) {
                    adaptor.addChild(root_1, stream_DOT.next());
                    adaptor.addChild(root_1, stream_IDENTIFIER.next());

                }
                stream_IDENTIFIER.reset();
                stream_DOT.reset();

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
    // $ANTLR end model_name

    public static class model_operation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_operation
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:230:1: model_operation : ( left_join | right_join | inner_join | full_join | cross_join );
    public final model_operation_return model_operation() throws RecognitionException {
        model_operation_return retval = new model_operation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        left_join_return left_join40 = null;

        right_join_return right_join41 = null;

        inner_join_return inner_join42 = null;

        full_join_return full_join43 = null;

        cross_join_return cross_join44 = null;



        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:230:16: ( left_join | right_join | inner_join | full_join | cross_join )
            int alt14=5;
            switch ( input.LA(1) ) {
            case LEFT:
            case 127:
                {
                alt14=1;
                }
                break;
            case RIGHT:
            case 128:
                {
                alt14=2;
                }
                break;
            case INNER:
            case 130:
                {
                alt14=3;
                }
                break;
            case FULL:
            case 129:
                {
                alt14=4;
                }
                break;
            case CROSS:
            case 131:
                {
                alt14=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("230:1: model_operation : ( left_join | right_join | inner_join | full_join | cross_join );", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:231:2: left_join
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_left_join_in_model_operation2534);
                    left_join40=left_join();
                    _fsp--;

                    adaptor.addChild(root_0, left_join40.getTree());

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:231:14: right_join
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_right_join_in_model_operation2538);
                    right_join41=right_join();
                    _fsp--;

                    adaptor.addChild(root_0, right_join41.getTree());

                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:231:27: inner_join
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inner_join_in_model_operation2542);
                    inner_join42=inner_join();
                    _fsp--;

                    adaptor.addChild(root_0, inner_join42.getTree());

                    }
                    break;
                case 4 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:231:40: full_join
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_full_join_in_model_operation2546);
                    full_join43=full_join();
                    _fsp--;

                    adaptor.addChild(root_0, full_join43.getTree());

                    }
                    break;
                case 5 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:231:52: cross_join
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cross_join_in_model_operation2550);
                    cross_join44=cross_join();
                    _fsp--;

                    adaptor.addChild(root_0, cross_join44.getTree());

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
    // $ANTLR end model_operation

    public static class left_join_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start left_join
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:234:1: left_join : ( '<<' | LEFT JOIN | LEFT OUTER JOIN ) -> ^( LEFT_JOIN ) ;
    public final left_join_return left_join() throws RecognitionException {
        left_join_return retval = new left_join_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal45=null;
        Token LEFT46=null;
        Token JOIN47=null;
        Token LEFT48=null;
        Token OUTER49=null;
        Token JOIN50=null;

        Object string_literal45_tree=null;
        Object LEFT46_tree=null;
        Object JOIN47_tree=null;
        Object LEFT48_tree=null;
        Object OUTER49_tree=null;
        Object JOIN50_tree=null;
        RewriteRuleTokenStream stream_OUTER=new RewriteRuleTokenStream(adaptor,"token OUTER");
        RewriteRuleTokenStream stream_127=new RewriteRuleTokenStream(adaptor,"token 127");
        RewriteRuleTokenStream stream_LEFT=new RewriteRuleTokenStream(adaptor,"token LEFT");
        RewriteRuleTokenStream stream_JOIN=new RewriteRuleTokenStream(adaptor,"token JOIN");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:234:10: ( ( '<<' | LEFT JOIN | LEFT OUTER JOIN ) -> ^( LEFT_JOIN ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:235:2: ( '<<' | LEFT JOIN | LEFT OUTER JOIN )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:235:2: ( '<<' | LEFT JOIN | LEFT OUTER JOIN )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==127) ) {
                alt15=1;
            }
            else if ( (LA15_0==LEFT) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==JOIN) ) {
                    alt15=2;
                }
                else if ( (LA15_2==OUTER) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("235:2: ( '<<' | LEFT JOIN | LEFT OUTER JOIN )", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("235:2: ( '<<' | LEFT JOIN | LEFT OUTER JOIN )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:235:3: '<<'
                    {
                    string_literal45=(Token)input.LT(1);
                    match(input,127,FOLLOW_127_in_left_join2564); 
                    stream_127.add(string_literal45);


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:235:10: LEFT JOIN
                    {
                    LEFT46=(Token)input.LT(1);
                    match(input,LEFT,FOLLOW_LEFT_in_left_join2568); 
                    stream_LEFT.add(LEFT46);

                    JOIN47=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_left_join2570); 
                    stream_JOIN.add(JOIN47);


                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:235:22: LEFT OUTER JOIN
                    {
                    LEFT48=(Token)input.LT(1);
                    match(input,LEFT,FOLLOW_LEFT_in_left_join2574); 
                    stream_LEFT.add(LEFT48);

                    OUTER49=(Token)input.LT(1);
                    match(input,OUTER,FOLLOW_OUTER_in_left_join2576); 
                    stream_OUTER.add(OUTER49);

                    JOIN50=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_left_join2578); 
                    stream_JOIN.add(JOIN50);


                    }
                    break;

            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 235:39: -> ^( LEFT_JOIN )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:235:42: ^( LEFT_JOIN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(LEFT_JOIN, "LEFT_JOIN"), root_1);

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
    // $ANTLR end left_join

    public static class right_join_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start right_join
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:238:1: right_join : ( '>>' | RIGHT JOIN | RIGHT OUTER JOIN ) -> ^( RIGHT_JOIN ) ;
    public final right_join_return right_join() throws RecognitionException {
        right_join_return retval = new right_join_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal51=null;
        Token RIGHT52=null;
        Token JOIN53=null;
        Token RIGHT54=null;
        Token OUTER55=null;
        Token JOIN56=null;

        Object string_literal51_tree=null;
        Object RIGHT52_tree=null;
        Object JOIN53_tree=null;
        Object RIGHT54_tree=null;
        Object OUTER55_tree=null;
        Object JOIN56_tree=null;
        RewriteRuleTokenStream stream_OUTER=new RewriteRuleTokenStream(adaptor,"token OUTER");
        RewriteRuleTokenStream stream_RIGHT=new RewriteRuleTokenStream(adaptor,"token RIGHT");
        RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
        RewriteRuleTokenStream stream_JOIN=new RewriteRuleTokenStream(adaptor,"token JOIN");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:238:11: ( ( '>>' | RIGHT JOIN | RIGHT OUTER JOIN ) -> ^( RIGHT_JOIN ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:239:2: ( '>>' | RIGHT JOIN | RIGHT OUTER JOIN )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:239:2: ( '>>' | RIGHT JOIN | RIGHT OUTER JOIN )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==128) ) {
                alt16=1;
            }
            else if ( (LA16_0==RIGHT) ) {
                int LA16_2 = input.LA(2);

                if ( (LA16_2==JOIN) ) {
                    alt16=2;
                }
                else if ( (LA16_2==OUTER) ) {
                    alt16=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("239:2: ( '>>' | RIGHT JOIN | RIGHT OUTER JOIN )", 16, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("239:2: ( '>>' | RIGHT JOIN | RIGHT OUTER JOIN )", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:239:3: '>>'
                    {
                    string_literal51=(Token)input.LT(1);
                    match(input,128,FOLLOW_128_in_right_join2599); 
                    stream_128.add(string_literal51);


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:239:9: RIGHT JOIN
                    {
                    RIGHT52=(Token)input.LT(1);
                    match(input,RIGHT,FOLLOW_RIGHT_in_right_join2602); 
                    stream_RIGHT.add(RIGHT52);

                    JOIN53=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_right_join2604); 
                    stream_JOIN.add(JOIN53);


                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:239:22: RIGHT OUTER JOIN
                    {
                    RIGHT54=(Token)input.LT(1);
                    match(input,RIGHT,FOLLOW_RIGHT_in_right_join2608); 
                    stream_RIGHT.add(RIGHT54);

                    OUTER55=(Token)input.LT(1);
                    match(input,OUTER,FOLLOW_OUTER_in_right_join2610); 
                    stream_OUTER.add(OUTER55);

                    JOIN56=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_right_join2612); 
                    stream_JOIN.add(JOIN56);


                    }
                    break;

            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 239:40: -> ^( RIGHT_JOIN )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:239:43: ^( RIGHT_JOIN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(RIGHT_JOIN, "RIGHT_JOIN"), root_1);

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
    // $ANTLR end right_join

    public static class full_join_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start full_join
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:242:1: full_join : ( '^' | FULL JOIN | FULL OUTER JOIN ) -> ^( FULL_JOIN ) ;
    public final full_join_return full_join() throws RecognitionException {
        full_join_return retval = new full_join_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal57=null;
        Token FULL58=null;
        Token JOIN59=null;
        Token FULL60=null;
        Token OUTER61=null;
        Token JOIN62=null;

        Object char_literal57_tree=null;
        Object FULL58_tree=null;
        Object JOIN59_tree=null;
        Object FULL60_tree=null;
        Object OUTER61_tree=null;
        Object JOIN62_tree=null;
        RewriteRuleTokenStream stream_OUTER=new RewriteRuleTokenStream(adaptor,"token OUTER");
        RewriteRuleTokenStream stream_FULL=new RewriteRuleTokenStream(adaptor,"token FULL");
        RewriteRuleTokenStream stream_JOIN=new RewriteRuleTokenStream(adaptor,"token JOIN");
        RewriteRuleTokenStream stream_129=new RewriteRuleTokenStream(adaptor,"token 129");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:242:10: ( ( '^' | FULL JOIN | FULL OUTER JOIN ) -> ^( FULL_JOIN ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:243:2: ( '^' | FULL JOIN | FULL OUTER JOIN )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:243:2: ( '^' | FULL JOIN | FULL OUTER JOIN )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==129) ) {
                alt17=1;
            }
            else if ( (LA17_0==FULL) ) {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==JOIN) ) {
                    alt17=2;
                }
                else if ( (LA17_2==OUTER) ) {
                    alt17=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("243:2: ( '^' | FULL JOIN | FULL OUTER JOIN )", 17, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("243:2: ( '^' | FULL JOIN | FULL OUTER JOIN )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:243:3: '^'
                    {
                    char_literal57=(Token)input.LT(1);
                    match(input,129,FOLLOW_129_in_full_join2633); 
                    stream_129.add(char_literal57);


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:243:9: FULL JOIN
                    {
                    FULL58=(Token)input.LT(1);
                    match(input,FULL,FOLLOW_FULL_in_full_join2637); 
                    stream_FULL.add(FULL58);

                    JOIN59=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_full_join2639); 
                    stream_JOIN.add(JOIN59);


                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:243:21: FULL OUTER JOIN
                    {
                    FULL60=(Token)input.LT(1);
                    match(input,FULL,FOLLOW_FULL_in_full_join2643); 
                    stream_FULL.add(FULL60);

                    OUTER61=(Token)input.LT(1);
                    match(input,OUTER,FOLLOW_OUTER_in_full_join2645); 
                    stream_OUTER.add(OUTER61);

                    JOIN62=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_full_join2647); 
                    stream_JOIN.add(JOIN62);


                    }
                    break;

            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 243:38: -> ^( FULL_JOIN )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:243:41: ^( FULL_JOIN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FULL_JOIN, "FULL_JOIN"), root_1);

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
    // $ANTLR end full_join

    public static class inner_join_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start inner_join
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:246:1: inner_join : ( '&' | INNER JOIN ) -> ^( INNER_JOIN ) ;
    public final inner_join_return inner_join() throws RecognitionException {
        inner_join_return retval = new inner_join_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal63=null;
        Token INNER64=null;
        Token JOIN65=null;

        Object char_literal63_tree=null;
        Object INNER64_tree=null;
        Object JOIN65_tree=null;
        RewriteRuleTokenStream stream_INNER=new RewriteRuleTokenStream(adaptor,"token INNER");
        RewriteRuleTokenStream stream_JOIN=new RewriteRuleTokenStream(adaptor,"token JOIN");
        RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:246:11: ( ( '&' | INNER JOIN ) -> ^( INNER_JOIN ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:247:2: ( '&' | INNER JOIN )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:247:2: ( '&' | INNER JOIN )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==130) ) {
                alt18=1;
            }
            else if ( (LA18_0==INNER) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("247:2: ( '&' | INNER JOIN )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:247:3: '&'
                    {
                    char_literal63=(Token)input.LT(1);
                    match(input,130,FOLLOW_130_in_inner_join2668); 
                    stream_130.add(char_literal63);


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:247:9: INNER JOIN
                    {
                    INNER64=(Token)input.LT(1);
                    match(input,INNER,FOLLOW_INNER_in_inner_join2672); 
                    stream_INNER.add(INNER64);

                    JOIN65=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_inner_join2674); 
                    stream_JOIN.add(JOIN65);


                    }
                    break;

            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 247:21: -> ^( INNER_JOIN )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:247:24: ^( INNER_JOIN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INNER_JOIN, "INNER_JOIN"), root_1);

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
    // $ANTLR end inner_join

    public static class cross_join_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cross_join
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:250:1: cross_join : ( '<<>>' | CROSS JOIN ) -> ^( CROSS_JOIN ) ;
    public final cross_join_return cross_join() throws RecognitionException {
        cross_join_return retval = new cross_join_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal66=null;
        Token CROSS67=null;
        Token JOIN68=null;

        Object string_literal66_tree=null;
        Object CROSS67_tree=null;
        Object JOIN68_tree=null;
        RewriteRuleTokenStream stream_CROSS=new RewriteRuleTokenStream(adaptor,"token CROSS");
        RewriteRuleTokenStream stream_JOIN=new RewriteRuleTokenStream(adaptor,"token JOIN");
        RewriteRuleTokenStream stream_131=new RewriteRuleTokenStream(adaptor,"token 131");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:250:11: ( ( '<<>>' | CROSS JOIN ) -> ^( CROSS_JOIN ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:251:2: ( '<<>>' | CROSS JOIN )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:251:2: ( '<<>>' | CROSS JOIN )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==131) ) {
                alt19=1;
            }
            else if ( (LA19_0==CROSS) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("251:2: ( '<<>>' | CROSS JOIN )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:251:3: '<<>>'
                    {
                    string_literal66=(Token)input.LT(1);
                    match(input,131,FOLLOW_131_in_cross_join2695); 
                    stream_131.add(string_literal66);


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:251:12: CROSS JOIN
                    {
                    CROSS67=(Token)input.LT(1);
                    match(input,CROSS,FOLLOW_CROSS_in_cross_join2699); 
                    stream_CROSS.add(CROSS67);

                    JOIN68=(Token)input.LT(1);
                    match(input,JOIN,FOLLOW_JOIN_in_cross_join2701); 
                    stream_JOIN.add(JOIN68);


                    }
                    break;

            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 251:24: -> ^( CROSS_JOIN )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:251:27: ^( CROSS_JOIN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(CROSS_JOIN, "CROSS_JOIN"), root_1);

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
    // $ANTLR end cross_join

    public static class model_group_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start model_group
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:254:1: model_group : OPEN_PAREN model_expression CLOSE_PAREN -> ^( MODEL_GROUP model_expression ) ;
    public final model_group_return model_group() throws RecognitionException {
        model_group_return retval = new model_group_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OPEN_PAREN69=null;
        Token CLOSE_PAREN71=null;
        model_expression_return model_expression70 = null;


        Object OPEN_PAREN69_tree=null;
        Object CLOSE_PAREN71_tree=null;
        RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
        RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
        RewriteRuleSubtreeStream stream_model_expression=new RewriteRuleSubtreeStream(adaptor,"rule model_expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:254:12: ( OPEN_PAREN model_expression CLOSE_PAREN -> ^( MODEL_GROUP model_expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:255:2: OPEN_PAREN model_expression CLOSE_PAREN
            {
            OPEN_PAREN69=(Token)input.LT(1);
            match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_model_group2721); 
            stream_OPEN_PAREN.add(OPEN_PAREN69);

            pushFollow(FOLLOW_model_expression_in_model_group2723);
            model_expression70=model_expression();
            _fsp--;

            stream_model_expression.add(model_expression70.getTree());
            CLOSE_PAREN71=(Token)input.LT(1);
            match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_model_group2725); 
            stream_CLOSE_PAREN.add(CLOSE_PAREN71);


            // AST REWRITE
            // elements: model_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 255:42: -> ^( MODEL_GROUP model_expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:255:45: ^( MODEL_GROUP model_expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(MODEL_GROUP, "MODEL_GROUP"), root_1);

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
    // $ANTLR end model_group

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:261:1: expression : logicalExpression -> ^( EXPRESSION logicalExpression ) ;
    public final expression_return expression() throws RecognitionException {
        expression_return retval = new expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicalExpression_return logicalExpression72 = null;


        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:261:11: ( logicalExpression -> ^( EXPRESSION logicalExpression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:262:2: logicalExpression
            {
            pushFollow(FOLLOW_logicalExpression_in_expression2749);
            logicalExpression72=logicalExpression();
            _fsp--;

            stream_logicalExpression.add(logicalExpression72.getTree());

            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 262:20: -> ^( EXPRESSION logicalExpression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:262:23: ^( EXPRESSION logicalExpression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(EXPRESSION, "EXPRESSION"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.next());

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
    // $ANTLR end expression

    public static class logicalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:264:1: logicalExpression : booleanXorExpression ( OR booleanXorExpression )* ;
    public final logicalExpression_return logicalExpression() throws RecognitionException {
        logicalExpression_return retval = new logicalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR74=null;
        booleanXorExpression_return booleanXorExpression73 = null;

        booleanXorExpression_return booleanXorExpression75 = null;


        Object OR74_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:264:18: ( booleanXorExpression ( OR booleanXorExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:265:2: booleanXorExpression ( OR booleanXorExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_booleanXorExpression_in_logicalExpression2765);
            booleanXorExpression73=booleanXorExpression();
            _fsp--;

            adaptor.addChild(root_0, booleanXorExpression73.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:265:23: ( OR booleanXorExpression )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==OR) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:265:25: OR booleanXorExpression
            	    {
            	    OR74=(Token)input.LT(1);
            	    match(input,OR,FOLLOW_OR_in_logicalExpression2769); 
            	    OR74_tree = (Object)adaptor.create(OR74);
            	    root_0 = (Object)adaptor.becomeRoot(OR74_tree, root_0);

            	    pushFollow(FOLLOW_booleanXorExpression_in_logicalExpression2772);
            	    booleanXorExpression75=booleanXorExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, booleanXorExpression75.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // $ANTLR end logicalExpression

    public static class booleanXorExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start booleanXorExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:267:1: booleanXorExpression : booleanAndExpression ( XOR booleanAndExpression )* ;
    public final booleanXorExpression_return booleanXorExpression() throws RecognitionException {
        booleanXorExpression_return retval = new booleanXorExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token XOR77=null;
        booleanAndExpression_return booleanAndExpression76 = null;

        booleanAndExpression_return booleanAndExpression78 = null;


        Object XOR77_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:267:21: ( booleanAndExpression ( XOR booleanAndExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:268:2: booleanAndExpression ( XOR booleanAndExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_booleanAndExpression_in_booleanXorExpression2783);
            booleanAndExpression76=booleanAndExpression();
            _fsp--;

            adaptor.addChild(root_0, booleanAndExpression76.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:268:23: ( XOR booleanAndExpression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==XOR) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:268:25: XOR booleanAndExpression
            	    {
            	    XOR77=(Token)input.LT(1);
            	    match(input,XOR,FOLLOW_XOR_in_booleanXorExpression2787); 
            	    XOR77_tree = (Object)adaptor.create(XOR77);
            	    root_0 = (Object)adaptor.becomeRoot(XOR77_tree, root_0);

            	    pushFollow(FOLLOW_booleanAndExpression_in_booleanXorExpression2790);
            	    booleanAndExpression78=booleanAndExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, booleanAndExpression78.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end booleanXorExpression

    public static class booleanAndExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start booleanAndExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:271:1: booleanAndExpression : booleanNotExpression ( AND booleanNotExpression )* ;
    public final booleanAndExpression_return booleanAndExpression() throws RecognitionException {
        booleanAndExpression_return retval = new booleanAndExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND80=null;
        booleanNotExpression_return booleanNotExpression79 = null;

        booleanNotExpression_return booleanNotExpression81 = null;


        Object AND80_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:271:21: ( booleanNotExpression ( AND booleanNotExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:272:2: booleanNotExpression ( AND booleanNotExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_booleanNotExpression_in_booleanAndExpression2806);
            booleanNotExpression79=booleanNotExpression();
            _fsp--;

            adaptor.addChild(root_0, booleanNotExpression79.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:272:23: ( AND booleanNotExpression )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==AND) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:272:25: AND booleanNotExpression
            	    {
            	    AND80=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_booleanAndExpression2810); 
            	    AND80_tree = (Object)adaptor.create(AND80);
            	    root_0 = (Object)adaptor.becomeRoot(AND80_tree, root_0);

            	    pushFollow(FOLLOW_booleanNotExpression_in_booleanAndExpression2813);
            	    booleanNotExpression81=booleanNotExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, booleanNotExpression81.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // $ANTLR end booleanAndExpression

    public static class booleanNotExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start booleanNotExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:275:1: booleanNotExpression : betweenExpression ( NOT betweenExpression )* ;
    public final booleanNotExpression_return booleanNotExpression() throws RecognitionException {
        booleanNotExpression_return retval = new booleanNotExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT83=null;
        betweenExpression_return betweenExpression82 = null;

        betweenExpression_return betweenExpression84 = null;


        Object NOT83_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:275:21: ( betweenExpression ( NOT betweenExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:276:2: betweenExpression ( NOT betweenExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_betweenExpression_in_booleanNotExpression2829);
            betweenExpression82=betweenExpression();
            _fsp--;

            adaptor.addChild(root_0, betweenExpression82.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:276:20: ( NOT betweenExpression )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==NOT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:276:22: NOT betweenExpression
            	    {
            	    NOT83=(Token)input.LT(1);
            	    match(input,NOT,FOLLOW_NOT_in_booleanNotExpression2833); 
            	    NOT83_tree = (Object)adaptor.create(NOT83);
            	    root_0 = (Object)adaptor.becomeRoot(NOT83_tree, root_0);

            	    pushFollow(FOLLOW_betweenExpression_in_booleanNotExpression2836);
            	    betweenExpression84=betweenExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, betweenExpression84.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end booleanNotExpression

    public static class betweenExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start betweenExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:279:1: betweenExpression : equalityExpression ( ( not_between | BETWEEN ) equalityExpression AND equalityExpression )* ;
    public final betweenExpression_return betweenExpression() throws RecognitionException {
        betweenExpression_return retval = new betweenExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BETWEEN87=null;
        Token AND89=null;
        equalityExpression_return equalityExpression85 = null;

        not_between_return not_between86 = null;

        equalityExpression_return equalityExpression88 = null;

        equalityExpression_return equalityExpression90 = null;


        Object BETWEEN87_tree=null;
        Object AND89_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:279:18: ( equalityExpression ( ( not_between | BETWEEN ) equalityExpression AND equalityExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:280:2: equalityExpression ( ( not_between | BETWEEN ) equalityExpression AND equalityExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpression_in_betweenExpression2852);
            equalityExpression85=equalityExpression();
            _fsp--;

            adaptor.addChild(root_0, equalityExpression85.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:280:21: ( ( not_between | BETWEEN ) equalityExpression AND equalityExpression )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==NOT) ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==BETWEEN) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==BETWEEN) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:280:23: ( not_between | BETWEEN ) equalityExpression AND equalityExpression
            	    {
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:280:23: ( not_between | BETWEEN )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==NOT) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==BETWEEN) ) {
            	        alt24=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("280:23: ( not_between | BETWEEN )", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:280:24: not_between
            	            {
            	            pushFollow(FOLLOW_not_between_in_betweenExpression2857);
            	            not_between86=not_between();
            	            _fsp--;

            	            root_0 = (Object)adaptor.becomeRoot(not_between86.getTree(), root_0);

            	            }
            	            break;
            	        case 2 :
            	            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:280:39: BETWEEN
            	            {
            	            BETWEEN87=(Token)input.LT(1);
            	            match(input,BETWEEN,FOLLOW_BETWEEN_in_betweenExpression2862); 
            	            BETWEEN87_tree = (Object)adaptor.create(BETWEEN87);
            	            root_0 = (Object)adaptor.becomeRoot(BETWEEN87_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_equalityExpression_in_betweenExpression2866);
            	    equalityExpression88=equalityExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, equalityExpression88.getTree());
            	    AND89=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_betweenExpression2868); 
            	    AND89_tree = (Object)adaptor.create(AND89);
            	    adaptor.addChild(root_0, AND89_tree);

            	    pushFollow(FOLLOW_equalityExpression_in_betweenExpression2870);
            	    equalityExpression90=equalityExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, equalityExpression90.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // $ANTLR end betweenExpression

    public static class not_between_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start not_between
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:283:1: not_between : NOT BETWEEN -> ^( NOT_BETWEEN ) ;
    public final not_between_return not_between() throws RecognitionException {
        not_between_return retval = new not_between_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT91=null;
        Token BETWEEN92=null;

        Object NOT91_tree=null;
        Object BETWEEN92_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:283:12: ( NOT BETWEEN -> ^( NOT_BETWEEN ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:284:2: NOT BETWEEN
            {
            NOT91=(Token)input.LT(1);
            match(input,NOT,FOLLOW_NOT_in_not_between2886); 
            stream_NOT.add(NOT91);

            BETWEEN92=(Token)input.LT(1);
            match(input,BETWEEN,FOLLOW_BETWEEN_in_not_between2888); 
            stream_BETWEEN.add(BETWEEN92);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 284:14: -> ^( NOT_BETWEEN )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:284:17: ^( NOT_BETWEEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(NOT_BETWEEN, "NOT_BETWEEN"), root_1);

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
    // $ANTLR end not_between

    public static class equalityExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start equalityExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:287:1: equalityExpression : relationalExpression ( ( EQ | NOT_EQ ) relationalExpression )* ;
    public final equalityExpression_return equalityExpression() throws RecognitionException {
        equalityExpression_return retval = new equalityExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set94=null;
        relationalExpression_return relationalExpression93 = null;

        relationalExpression_return relationalExpression95 = null;


        Object set94_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:287:19: ( relationalExpression ( ( EQ | NOT_EQ ) relationalExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:288:2: relationalExpression ( ( EQ | NOT_EQ ) relationalExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_equalityExpression2907);
            relationalExpression93=relationalExpression();
            _fsp--;

            adaptor.addChild(root_0, relationalExpression93.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:288:23: ( ( EQ | NOT_EQ ) relationalExpression )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==NOT_EQ||LA26_0==EQ) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:288:25: ( EQ | NOT_EQ ) relationalExpression
            	    {
            	    set94=(Token)input.LT(1);
            	    if ( input.LA(1)==NOT_EQ||input.LA(1)==EQ ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set94), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_equalityExpression2911);    throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression2920);
            	    relationalExpression95=relationalExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, relationalExpression95.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // $ANTLR end equalityExpression

    public static class not_eq_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start not_eq
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:291:1: not_eq : NOT EQ -> ^( NOT_EQ ) ;
    public final not_eq_return not_eq() throws RecognitionException {
        not_eq_return retval = new not_eq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT96=null;
        Token EQ97=null;

        Object NOT96_tree=null;
        Object EQ97_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:291:7: ( NOT EQ -> ^( NOT_EQ ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:292:2: NOT EQ
            {
            NOT96=(Token)input.LT(1);
            match(input,NOT,FOLLOW_NOT_in_not_eq2936); 
            stream_NOT.add(NOT96);

            EQ97=(Token)input.LT(1);
            match(input,EQ,FOLLOW_EQ_in_not_eq2938); 
            stream_EQ.add(EQ97);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 292:9: -> ^( NOT_EQ )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:292:12: ^( NOT_EQ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(NOT_EQ, "NOT_EQ"), root_1);

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
    // $ANTLR end not_eq

    public static class relationalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:295:1: relationalExpression : nullComparisonExpression ( ( LT | LE | GT | GE ) nullComparisonExpression )* ;
    public final relationalExpression_return relationalExpression() throws RecognitionException {
        relationalExpression_return retval = new relationalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set99=null;
        nullComparisonExpression_return nullComparisonExpression98 = null;

        nullComparisonExpression_return nullComparisonExpression100 = null;


        Object set99_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:295:21: ( nullComparisonExpression ( ( LT | LE | GT | GE ) nullComparisonExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:296:5: nullComparisonExpression ( ( LT | LE | GT | GE ) nullComparisonExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nullComparisonExpression_in_relationalExpression2960);
            nullComparisonExpression98=nullComparisonExpression();
            _fsp--;

            adaptor.addChild(root_0, nullComparisonExpression98.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:296:30: ( ( LT | LE | GT | GE ) nullComparisonExpression )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=GT && LA27_0<=GE)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:296:32: ( LT | LE | GT | GE ) nullComparisonExpression
            	    {
            	    set99=(Token)input.LT(1);
            	    if ( (input.LA(1)>=GT && input.LA(1)<=GE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set99), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_relationalExpression2964);    throw mse;
            	    }

            	    pushFollow(FOLLOW_nullComparisonExpression_in_relationalExpression2982);
            	    nullComparisonExpression100=nullComparisonExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, nullComparisonExpression100.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // $ANTLR end relationalExpression

    public static class nullComparisonExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nullComparisonExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:299:1: nullComparisonExpression : likeExpression ( ( is_not_null | is_null ) )? ;
    public final nullComparisonExpression_return nullComparisonExpression() throws RecognitionException {
        nullComparisonExpression_return retval = new nullComparisonExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        likeExpression_return likeExpression101 = null;

        is_not_null_return is_not_null102 = null;

        is_null_return is_null103 = null;



        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:299:25: ( likeExpression ( ( is_not_null | is_null ) )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:300:2: likeExpression ( ( is_not_null | is_null ) )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_likeExpression_in_nullComparisonExpression2997);
            likeExpression101=likeExpression();
            _fsp--;

            adaptor.addChild(root_0, likeExpression101.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:300:17: ( ( is_not_null | is_null ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IS) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:300:19: ( is_not_null | is_null )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:300:19: ( is_not_null | is_null )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==IS) ) {
                        int LA28_1 = input.LA(2);

                        if ( (LA28_1==NULL) ) {
                            alt28=2;
                        }
                        else if ( (LA28_1==NOT) ) {
                            alt28=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("300:19: ( is_not_null | is_null )", 28, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("300:19: ( is_not_null | is_null )", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:300:20: is_not_null
                            {
                            pushFollow(FOLLOW_is_not_null_in_nullComparisonExpression3002);
                            is_not_null102=is_not_null();
                            _fsp--;

                            root_0 = (Object)adaptor.becomeRoot(is_not_null102.getTree(), root_0);

                            }
                            break;
                        case 2 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:300:35: is_null
                            {
                            pushFollow(FOLLOW_is_null_in_nullComparisonExpression3007);
                            is_null103=is_null();
                            _fsp--;

                            root_0 = (Object)adaptor.becomeRoot(is_null103.getTree(), root_0);

                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end nullComparisonExpression

    public static class is_null_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start is_null
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:303:1: is_null : IS NULL -> ^( IS_NULL ) ;
    public final is_null_return is_null() throws RecognitionException {
        is_null_return retval = new is_null_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IS104=null;
        Token NULL105=null;

        Object IS104_tree=null;
        Object NULL105_tree=null;
        RewriteRuleTokenStream stream_IS=new RewriteRuleTokenStream(adaptor,"token IS");
        RewriteRuleTokenStream stream_NULL=new RewriteRuleTokenStream(adaptor,"token NULL");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:303:8: ( IS NULL -> ^( IS_NULL ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:304:5: IS NULL
            {
            IS104=(Token)input.LT(1);
            match(input,IS,FOLLOW_IS_in_is_null3028); 
            stream_IS.add(IS104);

            NULL105=(Token)input.LT(1);
            match(input,NULL,FOLLOW_NULL_in_is_null3030); 
            stream_NULL.add(NULL105);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 304:13: -> ^( IS_NULL )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:304:16: ^( IS_NULL )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(IS_NULL, "IS_NULL"), root_1);

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
    // $ANTLR end is_null

    public static class is_not_null_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start is_not_null
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:307:1: is_not_null : IS NOT NULL -> ^( IS_NOT_NULL ) ;
    public final is_not_null_return is_not_null() throws RecognitionException {
        is_not_null_return retval = new is_not_null_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IS106=null;
        Token NOT107=null;
        Token NULL108=null;

        Object IS106_tree=null;
        Object NOT107_tree=null;
        Object NULL108_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_IS=new RewriteRuleTokenStream(adaptor,"token IS");
        RewriteRuleTokenStream stream_NULL=new RewriteRuleTokenStream(adaptor,"token NULL");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:307:12: ( IS NOT NULL -> ^( IS_NOT_NULL ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:308:2: IS NOT NULL
            {
            IS106=(Token)input.LT(1);
            match(input,IS,FOLLOW_IS_in_is_not_null3049); 
            stream_IS.add(IS106);

            NOT107=(Token)input.LT(1);
            match(input,NOT,FOLLOW_NOT_in_is_not_null3051); 
            stream_NOT.add(NOT107);

            NULL108=(Token)input.LT(1);
            match(input,NULL,FOLLOW_NULL_in_is_not_null3053); 
            stream_NULL.add(NULL108);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 308:15: -> ^( IS_NOT_NULL )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:308:18: ^( IS_NOT_NULL )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(IS_NOT_NULL, "IS_NOT_NULL"), root_1);

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
    // $ANTLR end is_not_null

    public static class likeExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start likeExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:311:1: likeExpression : inExpression ( ( not_like | LIKE ) likePattern ( ESCAPE STRING )? )? ;
    public final likeExpression_return likeExpression() throws RecognitionException {
        likeExpression_return retval = new likeExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LIKE111=null;
        Token ESCAPE113=null;
        Token STRING114=null;
        inExpression_return inExpression109 = null;

        not_like_return not_like110 = null;

        likePattern_return likePattern112 = null;


        Object LIKE111_tree=null;
        Object ESCAPE113_tree=null;
        Object STRING114_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:311:15: ( inExpression ( ( not_like | LIKE ) likePattern ( ESCAPE STRING )? )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:2: inExpression ( ( not_like | LIKE ) likePattern ( ESCAPE STRING )? )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_inExpression_in_likeExpression3073);
            inExpression109=inExpression();
            _fsp--;

            adaptor.addChild(root_0, inExpression109.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:15: ( ( not_like | LIKE ) likePattern ( ESCAPE STRING )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==NOT) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==LIKE) ) {
                    alt32=1;
                }
            }
            else if ( (LA32_0==LIKE) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:17: ( not_like | LIKE ) likePattern ( ESCAPE STRING )?
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:17: ( not_like | LIKE )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==NOT) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==LIKE) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("312:17: ( not_like | LIKE )", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:18: not_like
                            {
                            pushFollow(FOLLOW_not_like_in_likeExpression3078);
                            not_like110=not_like();
                            _fsp--;

                            root_0 = (Object)adaptor.becomeRoot(not_like110.getTree(), root_0);

                            }
                            break;
                        case 2 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:30: LIKE
                            {
                            LIKE111=(Token)input.LT(1);
                            match(input,LIKE,FOLLOW_LIKE_in_likeExpression3083); 
                            LIKE111_tree = (Object)adaptor.create(LIKE111);
                            root_0 = (Object)adaptor.becomeRoot(LIKE111_tree, root_0);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_likePattern_in_likeExpression3087);
                    likePattern112=likePattern();
                    _fsp--;

                    adaptor.addChild(root_0, likePattern112.getTree());
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:49: ( ESCAPE STRING )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==ESCAPE) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:312:50: ESCAPE STRING
                            {
                            ESCAPE113=(Token)input.LT(1);
                            match(input,ESCAPE,FOLLOW_ESCAPE_in_likeExpression3090); 
                            ESCAPE113_tree = (Object)adaptor.create(ESCAPE113);
                            adaptor.addChild(root_0, ESCAPE113_tree);

                            STRING114=(Token)input.LT(1);
                            match(input,STRING,FOLLOW_STRING_in_likeExpression3092); 
                            STRING114_tree = (Object)adaptor.create(STRING114);
                            adaptor.addChild(root_0, STRING114_tree);


                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end likeExpression

    public static class not_like_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start not_like
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:315:1: not_like : NOT LIKE -> ^( NOT_LIKE ) ;
    public final not_like_return not_like() throws RecognitionException {
        not_like_return retval = new not_like_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT115=null;
        Token LIKE116=null;

        Object NOT115_tree=null;
        Object LIKE116_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_LIKE=new RewriteRuleTokenStream(adaptor,"token LIKE");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:315:9: ( NOT LIKE -> ^( NOT_LIKE ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:316:2: NOT LIKE
            {
            NOT115=(Token)input.LT(1);
            match(input,NOT,FOLLOW_NOT_in_not_like3110); 
            stream_NOT.add(NOT115);

            LIKE116=(Token)input.LT(1);
            match(input,LIKE,FOLLOW_LIKE_in_not_like3112); 
            stream_LIKE.add(LIKE116);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 316:11: -> ^( NOT_LIKE )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:316:14: ^( NOT_LIKE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(NOT_LIKE, "NOT_LIKE"), root_1);

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
    // $ANTLR end not_like

    public static class likePattern_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start likePattern
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:319:1: likePattern : ( STRING | param );
    public final likePattern_return likePattern() throws RecognitionException {
        likePattern_return retval = new likePattern_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING117=null;
        param_return param118 = null;


        Object STRING117_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:319:12: ( STRING | param )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==STRING) ) {
                alt33=1;
            }
            else if ( (LA33_0==QUESTION) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("319:1: likePattern : ( STRING | param );", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:320:2: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING117=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_likePattern3131); 
                    STRING117_tree = (Object)adaptor.create(STRING117);
                    adaptor.addChild(root_0, STRING117_tree);


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:320:11: param
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_param_in_likePattern3135);
                    param118=param();
                    _fsp--;

                    adaptor.addChild(root_0, param118.getTree());

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
    // $ANTLR end likePattern

    public static class inExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start inExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:323:1: inExpression : bitwiseOrExpression ( ( not_in | IN ) OPEN_PAREN atomList CLOSE_PAREN )? ;
    public final inExpression_return inExpression() throws RecognitionException {
        inExpression_return retval = new inExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IN121=null;
        Token OPEN_PAREN122=null;
        Token CLOSE_PAREN124=null;
        bitwiseOrExpression_return bitwiseOrExpression119 = null;

        not_in_return not_in120 = null;

        atomList_return atomList123 = null;


        Object IN121_tree=null;
        Object OPEN_PAREN122_tree=null;
        Object CLOSE_PAREN124_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:324:2: ( bitwiseOrExpression ( ( not_in | IN ) OPEN_PAREN atomList CLOSE_PAREN )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:324:4: bitwiseOrExpression ( ( not_in | IN ) OPEN_PAREN atomList CLOSE_PAREN )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseOrExpression_in_inExpression3149);
            bitwiseOrExpression119=bitwiseOrExpression();
            _fsp--;

            adaptor.addChild(root_0, bitwiseOrExpression119.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:324:24: ( ( not_in | IN ) OPEN_PAREN atomList CLOSE_PAREN )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==NOT) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==IN) ) {
                    alt35=1;
                }
            }
            else if ( (LA35_0==IN) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:324:26: ( not_in | IN ) OPEN_PAREN atomList CLOSE_PAREN
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:324:26: ( not_in | IN )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==NOT) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==IN) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("324:26: ( not_in | IN )", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:324:27: not_in
                            {
                            pushFollow(FOLLOW_not_in_in_inExpression3154);
                            not_in120=not_in();
                            _fsp--;

                            adaptor.addChild(root_0, not_in120.getTree());

                            }
                            break;
                        case 2 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:324:36: IN
                            {
                            IN121=(Token)input.LT(1);
                            match(input,IN,FOLLOW_IN_in_inExpression3158); 
                            IN121_tree = (Object)adaptor.create(IN121);
                            adaptor.addChild(root_0, IN121_tree);


                            }
                            break;

                    }

                    OPEN_PAREN122=(Token)input.LT(1);
                    match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_inExpression3162); 
                    OPEN_PAREN122_tree = (Object)adaptor.create(OPEN_PAREN122);
                    adaptor.addChild(root_0, OPEN_PAREN122_tree);

                    pushFollow(FOLLOW_atomList_in_inExpression3164);
                    atomList123=atomList();
                    _fsp--;

                    adaptor.addChild(root_0, atomList123.getTree());
                    CLOSE_PAREN124=(Token)input.LT(1);
                    match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_inExpression3166); 
                    CLOSE_PAREN124_tree = (Object)adaptor.create(CLOSE_PAREN124);
                    adaptor.addChild(root_0, CLOSE_PAREN124_tree);


                    }
                    break;

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
    // $ANTLR end inExpression

    public static class not_in_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start not_in
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:327:1: not_in : NOT IN -> ^( NOT_IN ) ;
    public final not_in_return not_in() throws RecognitionException {
        not_in_return retval = new not_in_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT125=null;
        Token IN126=null;

        Object NOT125_tree=null;
        Object IN126_tree=null;
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:327:7: ( NOT IN -> ^( NOT_IN ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:328:2: NOT IN
            {
            NOT125=(Token)input.LT(1);
            match(input,NOT,FOLLOW_NOT_in_not_in3182); 
            stream_NOT.add(NOT125);

            IN126=(Token)input.LT(1);
            match(input,IN,FOLLOW_IN_in_not_in3184); 
            stream_IN.add(IN126);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 328:9: -> ^( NOT_IN )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:328:12: ^( NOT_IN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(NOT_IN, "NOT_IN"), root_1);

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
    // $ANTLR end not_in

    public static class bitwiseOrExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseOrExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:349:1: bitwiseOrExpression : bitwiseAndExpression ( bitwiseOr bitwiseAndExpression )? ;
    public final bitwiseOrExpression_return bitwiseOrExpression() throws RecognitionException {
        bitwiseOrExpression_return retval = new bitwiseOrExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        bitwiseAndExpression_return bitwiseAndExpression127 = null;

        bitwiseOr_return bitwiseOr128 = null;

        bitwiseAndExpression_return bitwiseAndExpression129 = null;



        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:350:2: ( bitwiseAndExpression ( bitwiseOr bitwiseAndExpression )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:350:4: bitwiseAndExpression ( bitwiseOr bitwiseAndExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseAndExpression_in_bitwiseOrExpression3222);
            bitwiseAndExpression127=bitwiseAndExpression();
            _fsp--;

            adaptor.addChild(root_0, bitwiseAndExpression127.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:350:25: ( bitwiseOr bitwiseAndExpression )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==VERTBAR) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:350:27: bitwiseOr bitwiseAndExpression
                    {
                    pushFollow(FOLLOW_bitwiseOr_in_bitwiseOrExpression3226);
                    bitwiseOr128=bitwiseOr();
                    _fsp--;

                    root_0 = (Object)adaptor.becomeRoot(bitwiseOr128.getTree(), root_0);
                    pushFollow(FOLLOW_bitwiseAndExpression_in_bitwiseOrExpression3229);
                    bitwiseAndExpression129=bitwiseAndExpression();
                    _fsp--;

                    adaptor.addChild(root_0, bitwiseAndExpression129.getTree());

                    }
                    break;

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
    // $ANTLR end bitwiseOrExpression

    public static class bitwiseOr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseOr
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:353:1: bitwiseOr : VERTBAR ;
    public final bitwiseOr_return bitwiseOr() throws RecognitionException {
        bitwiseOr_return retval = new bitwiseOr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VERTBAR130=null;

        Object VERTBAR130_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:353:10: ( VERTBAR )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:354:2: VERTBAR
            {
            root_0 = (Object)adaptor.nil();

            VERTBAR130=(Token)input.LT(1);
            match(input,VERTBAR,FOLLOW_VERTBAR_in_bitwiseOr3245); 
            VERTBAR130_tree = (Object)adaptor.create(VERTBAR130);
            adaptor.addChild(root_0, VERTBAR130_tree);


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
    // $ANTLR end bitwiseOr

    public static class bitwiseAndExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseAndExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:357:1: bitwiseAndExpression : bitwiseLeftExpression ( BITWISE_AND bitwiseLeftExpression )? ;
    public final bitwiseAndExpression_return bitwiseAndExpression() throws RecognitionException {
        bitwiseAndExpression_return retval = new bitwiseAndExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BITWISE_AND132=null;
        bitwiseLeftExpression_return bitwiseLeftExpression131 = null;

        bitwiseLeftExpression_return bitwiseLeftExpression133 = null;


        Object BITWISE_AND132_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:357:21: ( bitwiseLeftExpression ( BITWISE_AND bitwiseLeftExpression )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:358:2: bitwiseLeftExpression ( BITWISE_AND bitwiseLeftExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseLeftExpression_in_bitwiseAndExpression3258);
            bitwiseLeftExpression131=bitwiseLeftExpression();
            _fsp--;

            adaptor.addChild(root_0, bitwiseLeftExpression131.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:358:24: ( BITWISE_AND bitwiseLeftExpression )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==BITWISE_AND) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:358:26: BITWISE_AND bitwiseLeftExpression
                    {
                    BITWISE_AND132=(Token)input.LT(1);
                    match(input,BITWISE_AND,FOLLOW_BITWISE_AND_in_bitwiseAndExpression3262); 
                    BITWISE_AND132_tree = (Object)adaptor.create(BITWISE_AND132);
                    root_0 = (Object)adaptor.becomeRoot(BITWISE_AND132_tree, root_0);

                    pushFollow(FOLLOW_bitwiseLeftExpression_in_bitwiseAndExpression3265);
                    bitwiseLeftExpression133=bitwiseLeftExpression();
                    _fsp--;

                    adaptor.addChild(root_0, bitwiseLeftExpression133.getTree());

                    }
                    break;

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
    // $ANTLR end bitwiseAndExpression

    public static class bitwiseLeftExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseLeftExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:361:1: bitwiseLeftExpression : bitwiseRightExpression ( BITWISE_LEFT bitwiseRightExpression )? ;
    public final bitwiseLeftExpression_return bitwiseLeftExpression() throws RecognitionException {
        bitwiseLeftExpression_return retval = new bitwiseLeftExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BITWISE_LEFT135=null;
        bitwiseRightExpression_return bitwiseRightExpression134 = null;

        bitwiseRightExpression_return bitwiseRightExpression136 = null;


        Object BITWISE_LEFT135_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:361:22: ( bitwiseRightExpression ( BITWISE_LEFT bitwiseRightExpression )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:362:2: bitwiseRightExpression ( BITWISE_LEFT bitwiseRightExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseRightExpression_in_bitwiseLeftExpression3281);
            bitwiseRightExpression134=bitwiseRightExpression();
            _fsp--;

            adaptor.addChild(root_0, bitwiseRightExpression134.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:362:25: ( BITWISE_LEFT bitwiseRightExpression )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==BITWISE_LEFT) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:362:27: BITWISE_LEFT bitwiseRightExpression
                    {
                    BITWISE_LEFT135=(Token)input.LT(1);
                    match(input,BITWISE_LEFT,FOLLOW_BITWISE_LEFT_in_bitwiseLeftExpression3285); 
                    BITWISE_LEFT135_tree = (Object)adaptor.create(BITWISE_LEFT135);
                    root_0 = (Object)adaptor.becomeRoot(BITWISE_LEFT135_tree, root_0);

                    pushFollow(FOLLOW_bitwiseRightExpression_in_bitwiseLeftExpression3288);
                    bitwiseRightExpression136=bitwiseRightExpression();
                    _fsp--;

                    adaptor.addChild(root_0, bitwiseRightExpression136.getTree());

                    }
                    break;

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
    // $ANTLR end bitwiseLeftExpression

    public static class bitwiseRightExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseRightExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:365:1: bitwiseRightExpression : additiveExpression ( BITWISE_RIGHT additiveExpression )? ;
    public final bitwiseRightExpression_return bitwiseRightExpression() throws RecognitionException {
        bitwiseRightExpression_return retval = new bitwiseRightExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BITWISE_RIGHT138=null;
        additiveExpression_return additiveExpression137 = null;

        additiveExpression_return additiveExpression139 = null;


        Object BITWISE_RIGHT138_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:365:23: ( additiveExpression ( BITWISE_RIGHT additiveExpression )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:366:2: additiveExpression ( BITWISE_RIGHT additiveExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_bitwiseRightExpression3304);
            additiveExpression137=additiveExpression();
            _fsp--;

            adaptor.addChild(root_0, additiveExpression137.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:366:21: ( BITWISE_RIGHT additiveExpression )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==BITWISE_RIGHT) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:366:23: BITWISE_RIGHT additiveExpression
                    {
                    BITWISE_RIGHT138=(Token)input.LT(1);
                    match(input,BITWISE_RIGHT,FOLLOW_BITWISE_RIGHT_in_bitwiseRightExpression3308); 
                    BITWISE_RIGHT138_tree = (Object)adaptor.create(BITWISE_RIGHT138);
                    root_0 = (Object)adaptor.becomeRoot(BITWISE_RIGHT138_tree, root_0);

                    pushFollow(FOLLOW_additiveExpression_in_bitwiseRightExpression3311);
                    additiveExpression139=additiveExpression();
                    _fsp--;

                    adaptor.addChild(root_0, additiveExpression139.getTree());

                    }
                    break;

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
    // $ANTLR end bitwiseRightExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:369:1: additiveExpression : multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )* ;
    public final additiveExpression_return additiveExpression() throws RecognitionException {
        additiveExpression_return retval = new additiveExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set141=null;
        multiplicativeExpression_return multiplicativeExpression140 = null;

        multiplicativeExpression_return multiplicativeExpression142 = null;


        Object set141_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:369:19: ( multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:370:2: multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression3327);
            multiplicativeExpression140=multiplicativeExpression();
            _fsp--;

            adaptor.addChild(root_0, multiplicativeExpression140.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:370:27: ( ( PLUS | MINUS ) multiplicativeExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=PLUS && LA40_0<=MINUS)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:370:29: ( PLUS | MINUS ) multiplicativeExpression
            	    {
            	    set141=(Token)input.LT(1);
            	    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set141), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_additiveExpression3331);    throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression3340);
            	    multiplicativeExpression142=multiplicativeExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, multiplicativeExpression142.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:373:1: multiplicativeExpression : unaryExpression ( ( STAR | DIVIDE | MOD ) unaryExpression )* ;
    public final multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        multiplicativeExpression_return retval = new multiplicativeExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set144=null;
        unaryExpression_return unaryExpression143 = null;

        unaryExpression_return unaryExpression145 = null;


        Object set144_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:373:25: ( unaryExpression ( ( STAR | DIVIDE | MOD ) unaryExpression )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:374:2: unaryExpression ( ( STAR | DIVIDE | MOD ) unaryExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression3356);
            unaryExpression143=unaryExpression();
            _fsp--;

            adaptor.addChild(root_0, unaryExpression143.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:374:18: ( ( STAR | DIVIDE | MOD ) unaryExpression )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==STAR||LA41_0==DIVIDE||LA41_0==MOD) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:374:20: ( STAR | DIVIDE | MOD ) unaryExpression
            	    {
            	    set144=(Token)input.LT(1);
            	    if ( input.LA(1)==STAR||input.LA(1)==DIVIDE||input.LA(1)==MOD ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set144), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_multiplicativeExpression3360);    throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression3373);
            	    unaryExpression145=unaryExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, unaryExpression145.getTree());

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // $ANTLR end multiplicativeExpression

    public static class unaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:377:1: unaryExpression : ( ( MINUS | BIT_INVERSION ) unaryExpression | atom | groupExpression );
    public final unaryExpression_return unaryExpression() throws RecognitionException {
        unaryExpression_return retval = new unaryExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set146=null;
        unaryExpression_return unaryExpression147 = null;

        atom_return atom148 = null;

        groupExpression_return groupExpression149 = null;


        Object set146_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:377:16: ( ( MINUS | BIT_INVERSION ) unaryExpression | atom | groupExpression )
            int alt42=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case BIT_INVERSION:
                {
                alt42=1;
                }
                break;
            case STRING:
            case NUMBER:
            case BOOLEAN:
            case DATETIME:
            case QUESTION:
            case IDENTIFIER:
                {
                alt42=2;
                }
                break;
            case OPEN_PAREN:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("377:1: unaryExpression : ( ( MINUS | BIT_INVERSION ) unaryExpression | atom | groupExpression );", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:378:2: ( MINUS | BIT_INVERSION ) unaryExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    set146=(Token)input.LT(1);
                    if ( input.LA(1)==MINUS||input.LA(1)==BIT_INVERSION ) {
                        input.consume();
                        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set146), root_0);
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_unaryExpression3388);    throw mse;
                    }

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression3397);
                    unaryExpression147=unaryExpression();
                    _fsp--;

                    adaptor.addChild(root_0, unaryExpression147.getTree());

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:378:45: atom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpression3401);
                    atom148=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom148.getTree());

                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:378:52: groupExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_groupExpression_in_unaryExpression3405);
                    groupExpression149=groupExpression();
                    _fsp--;

                    adaptor.addChild(root_0, groupExpression149.getTree());

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
    // $ANTLR end unaryExpression

    public static class groupExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start groupExpression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:381:1: groupExpression : OPEN_PAREN logicalExpression CLOSE_PAREN -> ^( GROUP logicalExpression ) ;
    public final groupExpression_return groupExpression() throws RecognitionException {
        groupExpression_return retval = new groupExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OPEN_PAREN150=null;
        Token CLOSE_PAREN152=null;
        logicalExpression_return logicalExpression151 = null;


        Object OPEN_PAREN150_tree=null;
        Object CLOSE_PAREN152_tree=null;
        RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
        RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:381:16: ( OPEN_PAREN logicalExpression CLOSE_PAREN -> ^( GROUP logicalExpression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:382:2: OPEN_PAREN logicalExpression CLOSE_PAREN
            {
            OPEN_PAREN150=(Token)input.LT(1);
            match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_groupExpression3418); 
            stream_OPEN_PAREN.add(OPEN_PAREN150);

            pushFollow(FOLLOW_logicalExpression_in_groupExpression3420);
            logicalExpression151=logicalExpression();
            _fsp--;

            stream_logicalExpression.add(logicalExpression151.getTree());
            CLOSE_PAREN152=(Token)input.LT(1);
            match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_groupExpression3422); 
            stream_CLOSE_PAREN.add(CLOSE_PAREN152);


            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 382:43: -> ^( GROUP logicalExpression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:382:46: ^( GROUP logicalExpression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(GROUP, "GROUP"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.next());

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
    // $ANTLR end groupExpression

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:385:1: atom : ( value | param | function | field );
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        value_return value153 = null;

        param_return param154 = null;

        function_return function155 = null;

        field_return field156 = null;



        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:385:5: ( value | param | function | field )
            int alt43=4;
            switch ( input.LA(1) ) {
            case STRING:
            case NUMBER:
            case BOOLEAN:
            case DATETIME:
                {
                alt43=1;
                }
                break;
            case QUESTION:
                {
                alt43=2;
                }
                break;
            case IDENTIFIER:
                {
                int LA43_3 = input.LA(2);

                if ( (LA43_3==OPEN_PAREN) ) {
                    int LA43_4 = input.LA(3);

                    if ( ( input.LA(2) == OPEN_PAREN ) ) {
                        alt43=3;
                    }
                    else if ( (true) ) {
                        alt43=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("385:1: atom : ( value | param | function | field );", 43, 4, input);

                        throw nvae;
                    }
                }
                else if ( (LA43_3==EOF||LA43_3==NOT_EQ||LA43_3==GROUP||LA43_3==LIMIT||LA43_3==HAVING||(LA43_3>=DOT && LA43_3<=COMMA)||(LA43_3>=CLOSE_PAREN && LA43_3<=STAR)||(LA43_3>=PLUS && LA43_3<=MINUS)||(LA43_3>=DIVIDE && LA43_3<=EQ)||(LA43_3>=GT && LA43_3<=BITWISE_AND)||(LA43_3>=BITWISE_LEFT && LA43_3<=BITWISE_RIGHT)||(LA43_3>=IS && LA43_3<=LIKE)||(LA43_3>=BETWEEN && LA43_3<=DESC)||(LA43_3>=FROM && LA43_3<=ORDER)||LA43_3==LEFT||(LA43_3>=RIGHT && LA43_3<=131)) ) {
                    alt43=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("385:1: atom : ( value | param | function | field );", 43, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("385:1: atom : ( value | param | function | field );", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:386:2: value
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_value_in_atom3443);
                    value153=value();
                    _fsp--;

                    adaptor.addChild(root_0, value153.getTree());

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:386:10: param
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_param_in_atom3447);
                    param154=param();
                    _fsp--;

                    adaptor.addChild(root_0, param154.getTree());

                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:386:18: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_atom3451);
                    function155=function();
                    _fsp--;

                    adaptor.addChild(root_0, function155.getTree());

                    }
                    break;
                case 4 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:386:29: field
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_field_in_atom3455);
                    field156=field();
                    _fsp--;

                    adaptor.addChild(root_0, field156.getTree());

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

    public static class atomList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atomList
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:389:1: atomList : atom ( COMMA atom )* ;
    public final atomList_return atomList() throws RecognitionException {
        atomList_return retval = new atomList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA158=null;
        atom_return atom157 = null;

        atom_return atom159 = null;


        Object COMMA158_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:389:9: ( atom ( COMMA atom )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:390:2: atom ( COMMA atom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_atomList3468);
            atom157=atom();
            _fsp--;

            adaptor.addChild(root_0, atom157.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:390:7: ( COMMA atom )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==COMMA) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:390:8: COMMA atom
            	    {
            	    COMMA158=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_atomList3471); 
            	    COMMA158_tree = (Object)adaptor.create(COMMA158);
            	    adaptor.addChild(root_0, COMMA158_tree);

            	    pushFollow(FOLLOW_atom_in_atomList3473);
            	    atom159=atom();
            	    _fsp--;

            	    adaptor.addChild(root_0, atom159.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // $ANTLR end atomList

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start value
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:393:1: value : ( NUMBER | STRING | DATETIME | BOOLEAN );
    public final value_return value() throws RecognitionException {
        value_return retval = new value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set160=null;

        Object set160_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:393:6: ( NUMBER | STRING | DATETIME | BOOLEAN )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:
            {
            root_0 = (Object)adaptor.nil();

            set160=(Token)input.LT(1);
            if ( input.LA(1)==STRING||(input.LA(1)>=NUMBER && input.LA(1)<=DATETIME) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set160));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_value0);    throw mse;
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
    // $ANTLR end value

    public static class param_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start param
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:397:1: param : QUESTION ;
    public final param_return param() throws RecognitionException {
        param_return retval = new param_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QUESTION161=null;

        Object QUESTION161_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:397:6: ( QUESTION )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:398:2: QUESTION
            {
            root_0 = (Object)adaptor.nil();

            QUESTION161=(Token)input.LT(1);
            match(input,QUESTION,FOLLOW_QUESTION_in_param3513); 
            QUESTION161_tree = (Object)adaptor.create(QUESTION161);
            adaptor.addChild(root_0, QUESTION161_tree);


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
    // $ANTLR end param

    public static class field_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start field
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:401:1: field : IDENTIFIER ( DOT IDENTIFIER )* -> ^( FIELD IDENTIFIER ( DOT IDENTIFIER )* ) ;
    public final field_return field() throws RecognitionException {
        field_return retval = new field_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER162=null;
        Token DOT163=null;
        Token IDENTIFIER164=null;

        Object IDENTIFIER162_tree=null;
        Object DOT163_tree=null;
        Object IDENTIFIER164_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:401:6: ( IDENTIFIER ( DOT IDENTIFIER )* -> ^( FIELD IDENTIFIER ( DOT IDENTIFIER )* ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:402:2: IDENTIFIER ( DOT IDENTIFIER )*
            {
            IDENTIFIER162=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field3526); 
            stream_IDENTIFIER.add(IDENTIFIER162);

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:402:13: ( DOT IDENTIFIER )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==DOT) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:402:14: DOT IDENTIFIER
            	    {
            	    DOT163=(Token)input.LT(1);
            	    match(input,DOT,FOLLOW_DOT_in_field3529); 
            	    stream_DOT.add(DOT163);

            	    IDENTIFIER164=(Token)input.LT(1);
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field3531); 
            	    stream_IDENTIFIER.add(IDENTIFIER164);


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            // AST REWRITE
            // elements: DOT, IDENTIFIER, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 402:31: -> ^( FIELD IDENTIFIER ( DOT IDENTIFIER )* )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:402:34: ^( FIELD IDENTIFIER ( DOT IDENTIFIER )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FIELD, "FIELD"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:402:53: ( DOT IDENTIFIER )*
                while ( stream_DOT.hasNext()||stream_IDENTIFIER.hasNext() ) {
                    adaptor.addChild(root_1, stream_DOT.next());
                    adaptor.addChild(root_1, stream_IDENTIFIER.next());

                }
                stream_DOT.reset();
                stream_IDENTIFIER.reset();

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
    // $ANTLR end field

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start function
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:405:1: function : {...}? IDENTIFIER OPEN_PAREN functionParameterList CLOSE_PAREN -> ^( FUNCTION IDENTIFIER functionParameterList ) ;
    public final function_return function() throws RecognitionException {
        function_return retval = new function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER165=null;
        Token OPEN_PAREN166=null;
        Token CLOSE_PAREN168=null;
        functionParameterList_return functionParameterList167 = null;


        Object IDENTIFIER165_tree=null;
        Object OPEN_PAREN166_tree=null;
        Object CLOSE_PAREN168_tree=null;
        RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
        RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_functionParameterList=new RewriteRuleSubtreeStream(adaptor,"rule functionParameterList");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:405:9: ({...}? IDENTIFIER OPEN_PAREN functionParameterList CLOSE_PAREN -> ^( FUNCTION IDENTIFIER functionParameterList ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:407:2: {...}? IDENTIFIER OPEN_PAREN functionParameterList CLOSE_PAREN
            {
            if ( !( input.LA(2) == OPEN_PAREN ) ) {
                throw new FailedPredicateException(input, "function", " input.LA(2) == OPEN_PAREN ");
            }
            IDENTIFIER165=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function3565); 
            stream_IDENTIFIER.add(IDENTIFIER165);

            OPEN_PAREN166=(Token)input.LT(1);
            match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_function3567); 
            stream_OPEN_PAREN.add(OPEN_PAREN166);

            pushFollow(FOLLOW_functionParameterList_in_function3569);
            functionParameterList167=functionParameterList();
            _fsp--;

            stream_functionParameterList.add(functionParameterList167.getTree());
            CLOSE_PAREN168=(Token)input.LT(1);
            match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_function3571); 
            stream_CLOSE_PAREN.add(CLOSE_PAREN168);


            // AST REWRITE
            // elements: IDENTIFIER, functionParameterList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 407:89: -> ^( FUNCTION IDENTIFIER functionParameterList )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:407:92: ^( FUNCTION IDENTIFIER functionParameterList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.next());
                adaptor.addChild(root_1, stream_functionParameterList.next());

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
    // $ANTLR end function

    public static class functionParameterList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start functionParameterList
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:410:1: functionParameterList : ( logicalExpression ( COMMA logicalExpression )* )? ;
    public final functionParameterList_return functionParameterList() throws RecognitionException {
        functionParameterList_return retval = new functionParameterList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA170=null;
        logicalExpression_return logicalExpression169 = null;

        logicalExpression_return logicalExpression171 = null;


        Object COMMA170_tree=null;

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:410:22: ( ( logicalExpression ( COMMA logicalExpression )* )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:411:2: ( logicalExpression ( COMMA logicalExpression )* )?
            {
            root_0 = (Object)adaptor.nil();

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:411:2: ( logicalExpression ( COMMA logicalExpression )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==OPEN_PAREN||LA47_0==STRING||(LA47_0>=MINUS && LA47_0<=DATETIME)||LA47_0==QUESTION||LA47_0==BIT_INVERSION||LA47_0==IDENTIFIER) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:411:4: logicalExpression ( COMMA logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_functionParameterList3597);
                    logicalExpression169=logicalExpression();
                    _fsp--;

                    adaptor.addChild(root_0, logicalExpression169.getTree());
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:411:22: ( COMMA logicalExpression )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==COMMA) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:411:23: COMMA logicalExpression
                    	    {
                    	    COMMA170=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_functionParameterList3600); 
                    	    COMMA170_tree = (Object)adaptor.create(COMMA170);
                    	    adaptor.addChild(root_0, COMMA170_tree);

                    	    pushFollow(FOLLOW_logicalExpression_in_functionParameterList3602);
                    	    logicalExpression171=logicalExpression();
                    	    _fsp--;

                    	    adaptor.addChild(root_0, logicalExpression171.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

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
    // $ANTLR end functionParameterList

    public static class is_empty_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start is_empty
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:414:1: is_empty : IS EMPTY -> ^( IS_EMPTY ) ;
    public final is_empty_return is_empty() throws RecognitionException {
        is_empty_return retval = new is_empty_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IS172=null;
        Token EMPTY173=null;

        Object IS172_tree=null;
        Object EMPTY173_tree=null;
        RewriteRuleTokenStream stream_IS=new RewriteRuleTokenStream(adaptor,"token IS");
        RewriteRuleTokenStream stream_EMPTY=new RewriteRuleTokenStream(adaptor,"token EMPTY");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:414:9: ( IS EMPTY -> ^( IS_EMPTY ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:415:2: IS EMPTY
            {
            IS172=(Token)input.LT(1);
            match(input,IS,FOLLOW_IS_in_is_empty3620); 
            stream_IS.add(IS172);

            EMPTY173=(Token)input.LT(1);
            match(input,EMPTY,FOLLOW_EMPTY_in_is_empty3622); 
            stream_EMPTY.add(EMPTY173);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 415:11: -> ^( IS_EMPTY )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:415:14: ^( IS_EMPTY )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(IS_EMPTY, "IS_EMPTY"), root_1);

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
    // $ANTLR end is_empty

    public static class is_not_empty_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start is_not_empty
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:418:1: is_not_empty : IS NOT EMPTY -> ^( IS_NOT_EMPTY ) ;
    public final is_not_empty_return is_not_empty() throws RecognitionException {
        is_not_empty_return retval = new is_not_empty_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IS174=null;
        Token NOT175=null;
        Token EMPTY176=null;

        Object IS174_tree=null;
        Object NOT175_tree=null;
        Object EMPTY176_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_IS=new RewriteRuleTokenStream(adaptor,"token IS");
        RewriteRuleTokenStream stream_EMPTY=new RewriteRuleTokenStream(adaptor,"token EMPTY");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:418:13: ( IS NOT EMPTY -> ^( IS_NOT_EMPTY ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:419:2: IS NOT EMPTY
            {
            IS174=(Token)input.LT(1);
            match(input,IS,FOLLOW_IS_in_is_not_empty3641); 
            stream_IS.add(IS174);

            NOT175=(Token)input.LT(1);
            match(input,NOT,FOLLOW_NOT_in_is_not_empty3643); 
            stream_NOT.add(NOT175);

            EMPTY176=(Token)input.LT(1);
            match(input,EMPTY,FOLLOW_EMPTY_in_is_not_empty3645); 
            stream_EMPTY.add(EMPTY176);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 419:15: -> ^( IS_NOT_EMPTY )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:419:18: ^( IS_NOT_EMPTY )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(IS_NOT_EMPTY, "IS_NOT_EMPTY"), root_1);

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
    // $ANTLR end is_not_empty

    public static class order_item_list_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start order_item_list_expression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:424:1: order_item_list_expression : order_item ( COMMA order_item )* -> ^( ORDER_LIST order_item ( order_item )* ) ;
    public final order_item_list_expression_return order_item_list_expression() throws RecognitionException {
        order_item_list_expression_return retval = new order_item_list_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA178=null;
        order_item_return order_item177 = null;

        order_item_return order_item179 = null;


        Object COMMA178_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_order_item=new RewriteRuleSubtreeStream(adaptor,"rule order_item");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:424:27: ( order_item ( COMMA order_item )* -> ^( ORDER_LIST order_item ( order_item )* ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:425:2: order_item ( COMMA order_item )*
            {
            pushFollow(FOLLOW_order_item_in_order_item_list_expression3666);
            order_item177=order_item();
            _fsp--;

            stream_order_item.add(order_item177.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:425:13: ( COMMA order_item )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==COMMA) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:425:14: COMMA order_item
            	    {
            	    COMMA178=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_order_item_list_expression3669); 
            	    stream_COMMA.add(COMMA178);

            	    pushFollow(FOLLOW_order_item_in_order_item_list_expression3671);
            	    order_item179=order_item();
            	    _fsp--;

            	    stream_order_item.add(order_item179.getTree());

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            // AST REWRITE
            // elements: order_item, order_item
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 425:33: -> ^( ORDER_LIST order_item ( order_item )* )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:425:36: ^( ORDER_LIST order_item ( order_item )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ORDER_LIST, "ORDER_LIST"), root_1);

                adaptor.addChild(root_1, stream_order_item.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:425:60: ( order_item )*
                while ( stream_order_item.hasNext() ) {
                    adaptor.addChild(root_1, stream_order_item.next());

                }
                stream_order_item.reset();

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
    // $ANTLR end order_item_list_expression

    public static class order_item_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start order_item
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:428:1: order_item : expression (a= ASC | a= DESC )? -> ^( ORDER_ITEM expression ( $a)? ) ;
    public final order_item_return order_item() throws RecognitionException {
        order_item_return retval = new order_item_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token a=null;
        expression_return expression180 = null;


        Object a_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:428:11: ( expression (a= ASC | a= DESC )? -> ^( ORDER_ITEM expression ( $a)? ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:429:2: expression (a= ASC | a= DESC )?
            {
            pushFollow(FOLLOW_expression_in_order_item3699);
            expression180=expression();
            _fsp--;

            stream_expression.add(expression180.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:429:13: (a= ASC | a= DESC )?
            int alt49=3;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==ASC) ) {
                alt49=1;
            }
            else if ( (LA49_0==DESC) ) {
                alt49=2;
            }
            switch (alt49) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:429:14: a= ASC
                    {
                    a=(Token)input.LT(1);
                    match(input,ASC,FOLLOW_ASC_in_order_item3704); 
                    stream_ASC.add(a);


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:429:22: a= DESC
                    {
                    a=(Token)input.LT(1);
                    match(input,DESC,FOLLOW_DESC_in_order_item3710); 
                    stream_DESC.add(a);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a, expression
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 429:31: -> ^( ORDER_ITEM expression ( $a)? )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:429:34: ^( ORDER_ITEM expression ( $a)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ORDER_ITEM, "ORDER_ITEM"), root_1);

                adaptor.addChild(root_1, stream_expression.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:429:58: ( $a)?
                if ( stream_a.hasNext() ) {
                    adaptor.addChild(root_1, stream_a.next());

                }
                stream_a.reset();

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
    // $ANTLR end order_item

    public static class group_item_list_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start group_item_list_expression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:434:1: group_item_list_expression : group_item ( COMMA group_item )* -> ^( GROUP_LIST group_item ( group_item )* ) ;
    public final group_item_list_expression_return group_item_list_expression() throws RecognitionException {
        group_item_list_expression_return retval = new group_item_list_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA182=null;
        group_item_return group_item181 = null;

        group_item_return group_item183 = null;


        Object COMMA182_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_group_item=new RewriteRuleSubtreeStream(adaptor,"rule group_item");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:434:27: ( group_item ( COMMA group_item )* -> ^( GROUP_LIST group_item ( group_item )* ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:435:2: group_item ( COMMA group_item )*
            {
            pushFollow(FOLLOW_group_item_in_group_item_list_expression3739);
            group_item181=group_item();
            _fsp--;

            stream_group_item.add(group_item181.getTree());
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:435:13: ( COMMA group_item )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==COMMA) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:435:14: COMMA group_item
            	    {
            	    COMMA182=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_group_item_list_expression3742); 
            	    stream_COMMA.add(COMMA182);

            	    pushFollow(FOLLOW_group_item_in_group_item_list_expression3744);
            	    group_item183=group_item();
            	    _fsp--;

            	    stream_group_item.add(group_item183.getTree());

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            // AST REWRITE
            // elements: group_item, group_item
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 435:33: -> ^( GROUP_LIST group_item ( group_item )* )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:435:36: ^( GROUP_LIST group_item ( group_item )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(GROUP_LIST, "GROUP_LIST"), root_1);

                adaptor.addChild(root_1, stream_group_item.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:435:60: ( group_item )*
                while ( stream_group_item.hasNext() ) {
                    adaptor.addChild(root_1, stream_group_item.next());

                }
                stream_group_item.reset();

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
    // $ANTLR end group_item_list_expression

    public static class group_item_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start group_item
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:438:1: group_item : expression -> ^( GROUP_ITEM expression ) ;
    public final group_item_return group_item() throws RecognitionException {
        group_item_return retval = new group_item_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        expression_return expression184 = null;


        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:438:11: ( expression -> ^( GROUP_ITEM expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:439:2: expression
            {
            pushFollow(FOLLOW_expression_in_group_item3772);
            expression184=expression();
            _fsp--;

            stream_expression.add(expression184.getTree());

            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 439:13: -> ^( GROUP_ITEM expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:439:16: ^( GROUP_ITEM expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(GROUP_ITEM, "GROUP_ITEM"), root_1);

                adaptor.addChild(root_1, stream_expression.next());

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
    // $ANTLR end group_item

    public static class having_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start having_expression
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:444:1: having_expression : expression -> ^( HAVING expression ) ;
    public final having_expression_return having_expression() throws RecognitionException {
        having_expression_return retval = new having_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        expression_return expression185 = null;


        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:444:18: ( expression -> ^( HAVING expression ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:445:2: expression
            {
            pushFollow(FOLLOW_expression_in_having_expression3795);
            expression185=expression();
            _fsp--;

            stream_expression.add(expression185.getTree());

            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 445:13: -> ^( HAVING expression )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:445:16: ^( HAVING expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(HAVING, "HAVING"), root_1);

                adaptor.addChild(root_1, stream_expression.next());

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
    // $ANTLR end having_expression

    public static class limit_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start limit
    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:450:1: limit : (a= NUMBER COMMA )? b= NUMBER -> ^( LIMIT $b ( $a)? ) ;
    public final limit_return limit() throws RecognitionException {
        limit_return retval = new limit_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token a=null;
        Token b=null;
        Token COMMA186=null;

        Object a_tree=null;
        Object b_tree=null;
        Object COMMA186_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:450:6: ( (a= NUMBER COMMA )? b= NUMBER -> ^( LIMIT $b ( $a)? ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:451:2: (a= NUMBER COMMA )? b= NUMBER
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:451:2: (a= NUMBER COMMA )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==NUMBER) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==COMMA) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:451:3: a= NUMBER COMMA
                    {
                    a=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_limit3821); 
                    stream_NUMBER.add(a);

                    COMMA186=(Token)input.LT(1);
                    match(input,COMMA,FOLLOW_COMMA_in_limit3823); 
                    stream_COMMA.add(COMMA186);


                    }
                    break;

            }

            b=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_limit3829); 
            stream_NUMBER.add(b);


            // AST REWRITE
            // elements: b, a
            // token labels: b, a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 451:29: -> ^( LIMIT $b ( $a)? )
            {
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:451:32: ^( LIMIT $b ( $a)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(LIMIT, "LIMIT"), root_1);

                adaptor.addChild(root_1, stream_b.next());
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:451:43: ( $a)?
                if ( stream_a.hasNext() ) {
                    adaptor.addChild(root_1, stream_a.next());

                }
                stream_a.reset();

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
    // $ANTLR end limit


 

    public static final BitSet FOLLOW_select_query_in_query2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_clause_in_select_query2133 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_from_clause_in_select_query2136 = new BitSet(new long[]{0x0000000080090002L,0x0030000000000000L});
    public static final BitSet FOLLOW_where_clause_in_select_query2138 = new BitSet(new long[]{0x0000000080090002L,0x0020000000000000L});
    public static final BitSet FOLLOW_order_by_clause_in_select_query2141 = new BitSet(new long[]{0x0000000080090002L});
    public static final BitSet FOLLOW_group_by_clause_in_select_query2144 = new BitSet(new long[]{0x0000000080080002L});
    public static final BitSet FOLLOW_having_clause_in_select_query2147 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_limit_clause_in_select_query2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_clause2191 = new BitSet(new long[]{0x0000400000000000L,0x40020080021E4000L});
    public static final BitSet FOLLOW_DISTINCT_in_select_clause2196 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_targets_in_select_clause2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_from_clause2225 = new BitSet(new long[]{0x0000400000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_model_expression_in_from_clause2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where_clause2248 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_expression_in_where_clause2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_by_clause2272 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_BY_in_order_by_clause2274 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_order_item_list_expression_in_order_by_clause2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_by_clause2297 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_BY_in_group_by_clause2299 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_group_item_list_expression_in_group_by_clause2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HAVING_in_having_clause2322 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_having_expression_in_having_clause2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2345 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_limit_in_limit_clause2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_target_in_targets2372 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_COMMA_in_targets2375 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_target_in_targets2377 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_expression_in_target2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_expression_item_in_model_expression2429 = new BitSet(new long[]{0x0000400000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_model_expression_atom_in_model_expression_item2452 = new BitSet(new long[]{0x0000000000000002L,0xBC80000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_model_operation_in_model_expression_item2455 = new BitSet(new long[]{0x0000400000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_model_expression_atom_in_model_expression_item2458 = new BitSet(new long[]{0x0000000000000002L,0xBC80010000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ON_in_model_expression_item2461 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_logicalExpression_in_model_expression_item2463 = new BitSet(new long[]{0x0000000000000002L,0xBC80000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_model_name_in_model_expression_atom2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_group_in_model_expression_atom2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_model_name2499 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_DOT_in_model_name2502 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_model_name2504 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_left_join_in_model_operation2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_right_join_in_model_operation2538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inner_join_in_model_operation2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_full_join_in_model_operation2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_join_in_model_operation2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_left_join2564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_left_join2568 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_left_join2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_left_join2574 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_OUTER_in_left_join2576 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_left_join2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_right_join2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_right_join2602 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_right_join2604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_right_join2608 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_OUTER_in_right_join2610 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_right_join2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_full_join2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_full_join2637 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_full_join2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_full_join2643 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_OUTER_in_full_join2645 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_full_join2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_inner_join2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_inner_join2672 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_inner_join2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_cross_join2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_cross_join2699 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_JOIN_in_cross_join2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_model_group2721 = new BitSet(new long[]{0x0000C00000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_model_expression_in_model_group2723 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_model_group2725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expression2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanXorExpression_in_logicalExpression2765 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_OR_in_logicalExpression2769 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_booleanXorExpression_in_logicalExpression2772 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_booleanAndExpression_in_booleanXorExpression2783 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_XOR_in_booleanXorExpression2787 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_booleanAndExpression_in_booleanXorExpression2790 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_booleanNotExpression_in_booleanAndExpression2806 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_AND_in_booleanAndExpression2810 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_booleanNotExpression_in_booleanAndExpression2813 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_betweenExpression_in_booleanNotExpression2829 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_NOT_in_booleanNotExpression2833 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_betweenExpression_in_booleanNotExpression2836 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_equalityExpression_in_betweenExpression2852 = new BitSet(new long[]{0x0000000000000002L,0x0000400040000000L});
    public static final BitSet FOLLOW_not_between_in_betweenExpression2857 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_BETWEEN_in_betweenExpression2862 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_equalityExpression_in_betweenExpression2866 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_AND_in_betweenExpression2868 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_equalityExpression_in_betweenExpression2870 = new BitSet(new long[]{0x0000000000000002L,0x0000400040000000L});
    public static final BitSet FOLLOW_NOT_in_not_between2886 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_not_between2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression2907 = new BitSet(new long[]{0x0000000000000102L,0x0000000001000000L});
    public static final BitSet FOLLOW_set_in_equalityExpression2911 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression2920 = new BitSet(new long[]{0x0000000000000102L,0x0000000001000000L});
    public static final BitSet FOLLOW_NOT_in_not_eq2936 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_EQ_in_not_eq2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nullComparisonExpression_in_relationalExpression2960 = new BitSet(new long[]{0x0000000000000002L,0x000000003C000000L});
    public static final BitSet FOLLOW_set_in_relationalExpression2964 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_nullComparisonExpression_in_relationalExpression2982 = new BitSet(new long[]{0x0000000000000002L,0x000000003C000000L});
    public static final BitSet FOLLOW_likeExpression_in_nullComparisonExpression2997 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_is_not_null_in_nullComparisonExpression3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_is_null_in_nullComparisonExpression3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_is_null3028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_is_null3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_is_not_null3049 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_NOT_in_is_not_null3051 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_is_not_null3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inExpression_in_likeExpression3073 = new BitSet(new long[]{0x0000000000000002L,0x0000080040000000L});
    public static final BitSet FOLLOW_not_like_in_likeExpression3078 = new BitSet(new long[]{0x0000000000000000L,0x0000000002004000L});
    public static final BitSet FOLLOW_LIKE_in_likeExpression3083 = new BitSet(new long[]{0x0000000000000000L,0x0000000002004000L});
    public static final BitSet FOLLOW_likePattern_in_likeExpression3087 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
    public static final BitSet FOLLOW_ESCAPE_in_likeExpression3090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_likeExpression3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not_like3110 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_LIKE_in_not_like3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_likePattern3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_likePattern3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitwiseOrExpression_in_inExpression3149 = new BitSet(new long[]{0x0000000000000002L,0x0000040040000000L});
    public static final BitSet FOLLOW_not_in_in_inExpression3154 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_IN_in_inExpression3158 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_inExpression3162 = new BitSet(new long[]{0x0000000000000000L,0x40000000021C4000L});
    public static final BitSet FOLLOW_atomList_in_inExpression3164 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_inExpression3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not_in3182 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_IN_in_not_in3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitwiseAndExpression_in_bitwiseOrExpression3222 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_bitwiseOr_in_bitwiseOrExpression3226 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_bitwiseAndExpression_in_bitwiseOrExpression3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERTBAR_in_bitwiseOr3245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitwiseLeftExpression_in_bitwiseAndExpression3258 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_BITWISE_AND_in_bitwiseAndExpression3262 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_bitwiseLeftExpression_in_bitwiseAndExpression3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitwiseRightExpression_in_bitwiseLeftExpression3281 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_BITWISE_LEFT_in_bitwiseLeftExpression3285 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_bitwiseRightExpression_in_bitwiseLeftExpression3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_bitwiseRightExpression3304 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_BITWISE_RIGHT_in_bitwiseRightExpression3308 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_additiveExpression_in_bitwiseRightExpression3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression3327 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_set_in_additiveExpression3331 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression3340 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression3356 = new BitSet(new long[]{0x0001000000000002L,0x0000000400400000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression3360 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression3373 = new BitSet(new long[]{0x0001000000000002L,0x0000000400400000L});
    public static final BitSet FOLLOW_set_in_unaryExpression3388 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpression3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_groupExpression_in_unaryExpression3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_groupExpression3418 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_logicalExpression_in_groupExpression3420 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_groupExpression3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_atom3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_atom3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_atom3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_atom3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_atomList3468 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_COMMA_in_atomList3471 = new BitSet(new long[]{0x0000000000000000L,0x40000000021C4000L});
    public static final BitSet FOLLOW_atom_in_atomList3473 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_set_in_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_param3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field3526 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_DOT_in_field3529 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field3531 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function3565 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_function3567 = new BitSet(new long[]{0x0000C00000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_functionParameterList_in_function3569 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_function3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_functionParameterList3597 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_COMMA_in_functionParameterList3600 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_logicalExpression_in_functionParameterList3602 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_IS_in_is_empty3620 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_EMPTY_in_is_empty3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_is_not_empty3641 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_NOT_in_is_not_empty3643 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_EMPTY_in_is_not_empty3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_item_in_order_item_list_expression3666 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_COMMA_in_order_item_list_expression3669 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_order_item_in_order_item_list_expression3671 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_expression_in_order_item3699 = new BitSet(new long[]{0x0000000000000002L,0x0001800000000000L});
    public static final BitSet FOLLOW_ASC_in_order_item3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_item3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_item_in_group_item_list_expression3739 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_COMMA_in_group_item_list_expression3742 = new BitSet(new long[]{0x0000400000000000L,0x40000080021E4000L});
    public static final BitSet FOLLOW_group_item_in_group_item_list_expression3744 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_expression_in_group_item3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_having_expression3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_limit3821 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COMMA_in_limit3823 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_NUMBER_in_limit3829 = new BitSet(new long[]{0x0000000000000002L});

}