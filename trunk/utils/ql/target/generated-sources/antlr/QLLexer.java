// $ANTLR 3.0.1 /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g 2015-03-12 20:18:33

package com.cetus.jengine.utils.ql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QLLexer extends Lexer {
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
    public static final int T127=127;
    public static final int T128=128;
    public static final int BITWISE_RIGHT=102;
    public static final int ORDER_ITEM=23;
    public static final int FULL=123;
    public static final int LINE_BREACK=40;
    public static final int T129=129;
    public static final int IS_NULL=9;
    public static final int ESCAPE=108;
    public static final int BITWISE_XOR=100;
    public static final int SELECT_CLAUSE=33;
    public static final int CLOSE_PAREN=47;
    public static final int EQ=88;
    public static final int T131=131;
    public static final int T130=130;
    public static final int SELECT=114;
    public static final int IS_NOT_EMPTY=12;
    public static final int DIVIDE=86;
    public static final int D=53;
    public static final int E=54;
    public static final int F=55;
    public static final int GE=93;
    public static final int G=56;
    public static final int A=50;
    public static final int B=51;
    public static final int C=52;
    public static final int ASC=111;
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
    public static final int LEFT=119;
    public static final int IDENTIFIER=126;
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
    public static final int OPEN_PAREN=46;
    public static final int NOT_BETWEEN=14;
    public static final int BITWISE_LEFT=101;
    public static final int RIGHT=122;
    public static final int HAVING=31;
    public static final int TARGET=17;
    public static final int MINUS=81;
    public static final int IS_NOT_NULL=10;
    public static final int Tokens=132;
    public static final int SEMI=43;
    public static final int JOIN=120;
    public static final int NUM=79;
    public static final int NOT_EQ=8;
    public static final int TARGETS=18;
    public static final int VERTBAR=87;
    public static final int QUESTION=89;
    public static final int MODEL_NAME=4;
    public static final int DESC=112;
    public static final int BETWEEN=110;
    public static final int LE=92;
    public static final int STRING=78;
    public QLLexer() {;} 
    public QLLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g"; }

    // $ANTLR start T127
    public final void mT127() throws RecognitionException {
        try {
            int _type = T127;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:6:6: ( '<<' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:6:8: '<<'
            {
            match("<<"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T127

    // $ANTLR start T128
    public final void mT128() throws RecognitionException {
        try {
            int _type = T128;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:7:6: ( '>>' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:7:8: '>>'
            {
            match(">>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T128

    // $ANTLR start T129
    public final void mT129() throws RecognitionException {
        try {
            int _type = T129;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:8:6: ( '^' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:8:8: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T129

    // $ANTLR start T130
    public final void mT130() throws RecognitionException {
        try {
            int _type = T130;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:9:6: ( '&' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:9:8: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T130

    // $ANTLR start T131
    public final void mT131() throws RecognitionException {
        try {
            int _type = T131;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:10:6: ( '<<>>' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:10:8: '<<>>'
            {
            match("<<>>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T131

    // $ANTLR start LINE_BREACK
    public final void mLINE_BREACK() throws RecognitionException {
        try {
            int _type = LINE_BREACK;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:15: ( ( ( '\\r' '\\n' ) | '\\n' | '\\r' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:17: ( ( '\\r' '\\n' ) | '\\n' | '\\r' )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:17: ( ( '\\r' '\\n' ) | '\\n' | '\\r' )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='\n') ) {
                    alt1=1;
                }
                else {
                    alt1=3;}
            }
            else if ( (LA1_0=='\n') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("58:17: ( ( '\\r' '\\n' ) | '\\n' | '\\r' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:19: ( '\\r' '\\n' )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:19: ( '\\r' '\\n' )
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:20: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:33: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:58:40: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LINE_BREACK

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:59:15: ( ( ' ' | '\\t' | LINE_BREACK ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:59:17: ( ' ' | '\\t' | LINE_BREACK )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:59:17: ( ' ' | '\\t' | LINE_BREACK )
            int alt2=3;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt2=1;
                }
                break;
            case '\t':
                {
                alt2=2;
                }
                break;
            case '\n':
            case '\r':
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("59:17: ( ' ' | '\\t' | LINE_BREACK )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:59:19: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:59:25: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:59:32: LINE_BREACK
                    {
                    mLINE_BREACK(); 

                    }
                    break;

            }

             skip(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:60:15: ( '/*' ({...}? '*' | LINE_BREACK | ~ ( '*' | '\\n' | '\\r' ) )* '*/' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:60:17: '/*' ({...}? '*' | LINE_BREACK | ~ ( '*' | '\\n' | '\\r' ) )* '*/'
            {
            match("/*"); 

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:60:22: ({...}? '*' | LINE_BREACK | ~ ( '*' | '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=4;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>='\u0000' && LA3_4<='\uFFFE')) ) {
                            alt3=1;
                        }


                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFE')) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                    alt3=2;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<=')')||(LA3_0>='+' && LA3_0<='\uFFFE')) ) {
                    alt3=3;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:60:24: {...}? '*'
            	    {
            	    if ( !( input.LA(2)!='/' ) ) {
            	        throw new FailedPredicateException(input, "ML_COMMENT", " input.LA(2)!='/' ");
            	    }
            	    match('*'); 

            	    }
            	    break;
            	case 2 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:60:53: LINE_BREACK
            	    {
            	    mLINE_BREACK(); 

            	    }
            	    break;
            	case 3 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:60:69: ~ ( '*' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("*/"); 

             skip(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start SEMI
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:61:15: ( ';' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:61:17: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start DOT
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:62:15: ( '.' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:62:17: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:63:15: ( ',' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:63:17: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start OPEN_PAREN
    public final void mOPEN_PAREN() throws RecognitionException {
        try {
            int _type = OPEN_PAREN;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:64:15: ( '(' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:64:17: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OPEN_PAREN

    // $ANTLR start CLOSE_PAREN
    public final void mCLOSE_PAREN() throws RecognitionException {
        try {
            int _type = CLOSE_PAREN;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:65:15: ( ')' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:65:17: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CLOSE_PAREN

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:66:15: ( '*' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:66:17: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start AT_SIGN
    public final void mAT_SIGN() throws RecognitionException {
        try {
            int _type = AT_SIGN;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:67:15: ( '@' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:67:17: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AT_SIGN

    // $ANTLR start A
    public final void mA() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:69:15: ( ( 'a' | 'A' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:69:17: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end A

    // $ANTLR start B
    public final void mB() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:70:15: ( ( 'b' | 'B' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:70:17: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end B

    // $ANTLR start C
    public final void mC() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:71:15: ( ( 'c' | 'C' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:71:17: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end C

    // $ANTLR start D
    public final void mD() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:72:15: ( ( 'd' | 'D' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:72:17: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end D

    // $ANTLR start E
    public final void mE() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:73:15: ( ( 'e' | 'E' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:73:17: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end E

    // $ANTLR start F
    public final void mF() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:74:15: ( ( 'f' | 'F' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:74:17: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end F

    // $ANTLR start G
    public final void mG() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:75:15: ( ( 'g' | 'G' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:75:17: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end G

    // $ANTLR start H
    public final void mH() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:76:15: ( ( 'h' | 'H' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:76:17: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end H

    // $ANTLR start I
    public final void mI() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:77:15: ( ( 'i' | 'I' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:77:17: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end I

    // $ANTLR start J
    public final void mJ() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:78:15: ( ( 'j' | 'J' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:78:17: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end J

    // $ANTLR start K
    public final void mK() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:79:15: ( ( 'k' | 'K' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:79:17: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end K

    // $ANTLR start L
    public final void mL() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:80:15: ( ( 'l' | 'L' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:80:17: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end L

    // $ANTLR start M
    public final void mM() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:81:15: ( ( 'm' | 'M' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:81:17: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end M

    // $ANTLR start N
    public final void mN() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:82:15: ( ( 'n' | 'N' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:82:17: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end N

    // $ANTLR start O
    public final void mO() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:83:15: ( ( 'o' | 'O' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:83:17: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end O

    // $ANTLR start P
    public final void mP() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:84:15: ( ( 'p' | 'P' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:84:17: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end P

    // $ANTLR start Q
    public final void mQ() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:85:15: ( ( 'q' | 'Q' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:85:17: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Q

    // $ANTLR start R
    public final void mR() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:86:15: ( ( 'r' | 'R' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:86:17: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end R

    // $ANTLR start S
    public final void mS() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:87:15: ( ( 's' | 'S' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:87:17: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end S

    // $ANTLR start T
    public final void mT() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:88:15: ( ( 't' | 'T' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:88:17: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end T

    // $ANTLR start U
    public final void mU() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:89:15: ( ( 'u' | 'U' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:89:17: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end U

    // $ANTLR start V
    public final void mV() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:90:15: ( ( 'v' | 'V' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:90:17: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end V

    // $ANTLR start W
    public final void mW() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:91:15: ( ( 'w' | 'W' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:91:17: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end W

    // $ANTLR start X
    public final void mX() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:92:15: ( ( 'x' | 'X' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:92:17: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end X

    // $ANTLR start Y
    public final void mY() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:93:15: ( ( 'y' | 'Y' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:93:17: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Y

    // $ANTLR start Z
    public final void mZ() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:94:15: ( ( 'z' | 'Z' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:94:17: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Z

    // $ANTLR start CHAR
    public final void mCHAR() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:97:15: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:97:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end CHAR

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:98:15: ( '0' .. '9' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:98:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:99:15: ( '\\'' (~ '\\'' )* '\\'' | '\\\"' (~ '\\\"' )* '\\\"' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\'') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\"') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("99:1: STRING : ( '\\'' (~ '\\'' )* '\\'' | '\\\"' (~ '\\\"' )* '\\\"' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:99:17: '\\'' (~ '\\'' )* '\\''
                    {
                    match('\''); 
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:99:22: (~ '\\'' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='\uFFFE')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:99:24: ~ '\\''
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:99:40: '\\\"' (~ '\\\"' )* '\\\"'
                    {
                    match('\"'); 
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:99:45: (~ '\\\"' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFE')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:99:47: ~ '\\\"'
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start NUM
    public final void mNUM() throws RecognitionException {
        try {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:100:15: ( DIGIT ( DIGIT )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:100:18: DIGIT ( DIGIT )*
            {
            mDIGIT(); 
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:100:24: ( DIGIT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:100:26: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end NUM

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:15: ( ( PLUS | MINUS )? ( ( NUM DOT NUM ) | DOT NUM | NUM ) ( 'e' ( PLUS | MINUS )? NUM )? )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:17: ( PLUS | MINUS )? ( ( NUM DOT NUM ) | DOT NUM | NUM ) ( 'e' ( PLUS | MINUS )? NUM )?
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:17: ( PLUS | MINUS )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='+'||LA8_0=='-') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:35: ( ( NUM DOT NUM ) | DOT NUM | NUM )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:37: ( NUM DOT NUM )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:37: ( NUM DOT NUM )
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:38: NUM DOT NUM
                    {
                    mNUM(); 
                    mDOT(); 
                    mNUM(); 

                    }


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:53: DOT NUM
                    {
                    mDOT(); 
                    mNUM(); 

                    }
                    break;
                case 3 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:63: NUM
                    {
                    mNUM(); 

                    }
                    break;

            }

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:69: ( 'e' ( PLUS | MINUS )? NUM )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:71: 'e' ( PLUS | MINUS )? NUM
                    {
                    match('e'); 
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:101:75: ( PLUS | MINUS )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='+'||LA10_0=='-') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }

                    mNUM(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    // $ANTLR start BOOLEAN
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:102:15: ( ( T R U E ) | ( F A L S E ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='T'||LA12_0=='t') ) {
                alt12=1;
            }
            else if ( (LA12_0=='F'||LA12_0=='f') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("102:1: BOOLEAN : ( ( T R U E ) | ( F A L S E ) );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:102:17: ( T R U E )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:102:17: ( T R U E )
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:102:18: T R U E
                    {
                    mT(); 
                    mR(); 
                    mU(); 
                    mE(); 

                    }


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:102:29: ( F A L S E )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:102:29: ( F A L S E )
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:102:30: F A L S E
                    {
                    mF(); 
                    mA(); 
                    mL(); 
                    mS(); 
                    mE(); 

                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOLEAN

    // $ANTLR start DATETIME
    public final void mDATETIME() throws RecognitionException {
        try {
            int _type = DATETIME;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:103:15: ( '#' (~ '#' )* '#' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:103:17: '#' (~ '#' )* '#'
            {
            match('#'); 
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:103:21: (~ '#' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\"')||(LA13_0>='$' && LA13_0<='\uFFFE')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:103:22: ~ '#'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match('#'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DATETIME

    // $ANTLR start NULL
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:104:15: ( N U L L )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:104:17: N U L L
            {
            mN(); 
            mU(); 
            mL(); 
            mL(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NULL

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:108:15: ( '+' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:108:17: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:109:15: ( '-' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:109:17: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start DIVIDE
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:110:15: ( '/' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:110:17: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIVIDE

    // $ANTLR start VERTBAR
    public final void mVERTBAR() throws RecognitionException {
        try {
            int _type = VERTBAR;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:111:15: ( '|' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:111:17: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end VERTBAR

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:112:15: ( '=' | '==' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='=') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='=') ) {
                    alt14=2;
                }
                else {
                    alt14=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("112:1: EQ : ( '=' | '==' );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:112:17: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:112:23: '=='
                    {
                    match("=="); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start QUESTION
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:113:15: ( '?' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:113:17: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUESTION

    // $ANTLR start NOT_EQ
    public final void mNOT_EQ() throws RecognitionException {
        try {
            int _type = NOT_EQ;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:114:15: ( '<>' | '!=' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='<') ) {
                alt15=1;
            }
            else if ( (LA15_0=='!') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("114:1: NOT_EQ : ( '<>' | '!=' );", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:114:17: '<>'
                    {
                    match("<>"); 


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:114:24: '!='
                    {
                    match("!="); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOT_EQ

    // $ANTLR start GT
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:115:15: ( '>' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:115:17: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GT

    // $ANTLR start LT
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:116:15: ( '<' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:116:17: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LT

    // $ANTLR start LE
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:117:15: ( '<=' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:117:17: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LE

    // $ANTLR start GE
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:118:15: ( '>=' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:118:17: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GE

    // $ANTLR start NOT
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:119:15: ( '!' | ( N O T ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='!') ) {
                alt16=1;
            }
            else if ( (LA16_0=='N'||LA16_0=='n') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("119:1: NOT : ( '!' | ( N O T ) );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:119:17: '!'
                    {
                    match('!'); 

                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:119:23: ( N O T )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:119:23: ( N O T )
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:119:24: N O T
                    {
                    mN(); 
                    mO(); 
                    mT(); 

                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOT

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:120:15: ( ( O R ) | '||' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='O'||LA17_0=='o') ) {
                alt17=1;
            }
            else if ( (LA17_0=='|') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("120:1: OR : ( ( O R ) | '||' );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:120:17: ( O R )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:120:17: ( O R )
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:120:18: O R
                    {
                    mO(); 
                    mR(); 

                    }


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:120:25: '||'
                    {
                    match("||"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OR

    // $ANTLR start XOR
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:121:15: ( ( X O R ) )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:121:17: ( X O R )
            {
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:121:17: ( X O R )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:121:18: X O R
            {
            mX(); 
            mO(); 
            mR(); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end XOR

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:122:15: ( ( A N D ) | '&&' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='A'||LA18_0=='a') ) {
                alt18=1;
            }
            else if ( (LA18_0=='&') ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("122:1: AND : ( ( A N D ) | '&&' );", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:122:17: ( A N D )
                    {
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:122:17: ( A N D )
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:122:18: A N D
                    {
                    mA(); 
                    mN(); 
                    mD(); 

                    }


                    }
                    break;
                case 2 :
                    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:122:26: '&&'
                    {
                    match("&&"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start MOD
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:123:15: ( '%' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:123:17: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MOD

    // $ANTLR start BITWISE_AND
    public final void mBITWISE_AND() throws RecognitionException {
        try {
            int _type = BITWISE_AND;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:124:15: ( '&&&' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:124:17: '&&&'
            {
            match("&&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BITWISE_AND

    // $ANTLR start BITWISE_XOR
    public final void mBITWISE_XOR() throws RecognitionException {
        try {
            int _type = BITWISE_XOR;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:125:15: ( '^^^' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:125:17: '^^^'
            {
            match("^^^"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BITWISE_XOR

    // $ANTLR start BITWISE_LEFT
    public final void mBITWISE_LEFT() throws RecognitionException {
        try {
            int _type = BITWISE_LEFT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:126:15: ( '<<<' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:126:17: '<<<'
            {
            match("<<<"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BITWISE_LEFT

    // $ANTLR start BITWISE_RIGHT
    public final void mBITWISE_RIGHT() throws RecognitionException {
        try {
            int _type = BITWISE_RIGHT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:127:15: ( '>>>' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:127:17: '>>>'
            {
            match(">>>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BITWISE_RIGHT

    // $ANTLR start BIT_INVERSION
    public final void mBIT_INVERSION() throws RecognitionException {
        try {
            int _type = BIT_INVERSION;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:128:15: ( '~' )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:128:17: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BIT_INVERSION

    // $ANTLR start ON
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:131:15: ( O N )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:131:17: O N
            {
            mO(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ON

    // $ANTLR start IS
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:132:15: ( I S )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:132:17: I S
            {
            mI(); 
            mS(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IS

    // $ANTLR start IN
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:133:15: ( I N )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:133:17: I N
            {
            mI(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IN

    // $ANTLR start LIKE
    public final void mLIKE() throws RecognitionException {
        try {
            int _type = LIKE;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:134:15: ( L I K E )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:134:17: L I K E
            {
            mL(); 
            mI(); 
            mK(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LIKE

    // $ANTLR start ESCAPE
    public final void mESCAPE() throws RecognitionException {
        try {
            int _type = ESCAPE;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:135:15: ( E S C A P E )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:135:17: E S C A P E
            {
            mE(); 
            mS(); 
            mC(); 
            mA(); 
            mP(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ESCAPE

    // $ANTLR start EMPTY
    public final void mEMPTY() throws RecognitionException {
        try {
            int _type = EMPTY;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:136:15: ( E M P T Y )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:136:17: E M P T Y
            {
            mE(); 
            mM(); 
            mP(); 
            mT(); 
            mY(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EMPTY

    // $ANTLR start BETWEEN
    public final void mBETWEEN() throws RecognitionException {
        try {
            int _type = BETWEEN;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:137:15: ( B E T W E E N )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:137:17: B E T W E E N
            {
            mB(); 
            mE(); 
            mT(); 
            mW(); 
            mE(); 
            mE(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BETWEEN

    // $ANTLR start ASC
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:139:15: ( A S C )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:139:17: A S C
            {
            mA(); 
            mS(); 
            mC(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ASC

    // $ANTLR start DESC
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:140:15: ( D E S C )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:140:17: D E S C
            {
            mD(); 
            mE(); 
            mS(); 
            mC(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DESC

    // $ANTLR start DISTINCT
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:141:15: ( D I S T I N C T )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:141:17: D I S T I N C T
            {
            mD(); 
            mI(); 
            mS(); 
            mT(); 
            mI(); 
            mN(); 
            mC(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DISTINCT

    // $ANTLR start SELECT
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:142:15: ( S E L E C T )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:142:17: S E L E C T
            {
            mS(); 
            mE(); 
            mL(); 
            mE(); 
            mC(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SELECT

    // $ANTLR start FROM
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:143:15: ( F R O M )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:143:17: F R O M
            {
            mF(); 
            mR(); 
            mO(); 
            mM(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FROM

    // $ANTLR start WHERE
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:144:15: ( W H E R E )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:144:17: W H E R E
            {
            mW(); 
            mH(); 
            mE(); 
            mR(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WHERE

    // $ANTLR start ORDER
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:145:15: ( O R D E R )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:145:17: O R D E R
            {
            mO(); 
            mR(); 
            mD(); 
            mE(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ORDER

    // $ANTLR start BY
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:146:15: ( B Y )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:146:17: B Y
            {
            mB(); 
            mY(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BY

    // $ANTLR start GROUP
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:147:15: ( G R O U P )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:147:17: G R O U P
            {
            mG(); 
            mR(); 
            mO(); 
            mU(); 
            mP(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GROUP

    // $ANTLR start HAVING
    public final void mHAVING() throws RecognitionException {
        try {
            int _type = HAVING;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:148:15: ( H A V I N G )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:148:17: H A V I N G
            {
            mH(); 
            mA(); 
            mV(); 
            mI(); 
            mN(); 
            mG(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end HAVING

    // $ANTLR start LIMIT
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:149:15: ( L I M I T )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:149:17: L I M I T
            {
            mL(); 
            mI(); 
            mM(); 
            mI(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LIMIT

    // $ANTLR start LEFT
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:150:15: ( L E F T )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:150:17: L E F T
            {
            mL(); 
            mE(); 
            mF(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LEFT

    // $ANTLR start JOIN
    public final void mJOIN() throws RecognitionException {
        try {
            int _type = JOIN;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:151:15: ( J O I N )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:151:17: J O I N
            {
            mJ(); 
            mO(); 
            mI(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end JOIN

    // $ANTLR start OUTER
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:152:15: ( O U T E R )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:152:17: O U T E R
            {
            mO(); 
            mU(); 
            mT(); 
            mE(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OUTER

    // $ANTLR start RIGHT
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:153:15: ( R I G H T )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:153:17: R I G H T
            {
            mR(); 
            mI(); 
            mG(); 
            mH(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RIGHT

    // $ANTLR start FULL
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:154:15: ( F U L L )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:154:17: F U L L
            {
            mF(); 
            mU(); 
            mL(); 
            mL(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FULL

    // $ANTLR start INNER
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:155:15: ( I N N E R )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:155:17: I N N E R
            {
            mI(); 
            mN(); 
            mN(); 
            mE(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INNER

    // $ANTLR start CROSS
    public final void mCROSS() throws RecognitionException {
        try {
            int _type = CROSS;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:156:15: ( C R O S S )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:156:17: C R O S S
            {
            mC(); 
            mR(); 
            mO(); 
            mS(); 
            mS(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CROSS

    // $ANTLR start IDENTIFIER
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:157:15: ( ( CHAR | '_' ) ( CHAR | DIGIT | '_' | '$' | '#' )* )
            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:157:17: ( CHAR | '_' ) ( CHAR | DIGIT | '_' | '$' | '#' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:157:30: ( CHAR | DIGIT | '_' | '$' | '#' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='#' && LA19_0<='$')||(LA19_0>='0' && LA19_0<='9')||(LA19_0>='A' && LA19_0<='Z')||LA19_0=='_'||(LA19_0>='a' && LA19_0<='z')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:
            	    {
            	    if ( (input.LA(1)>='#' && input.LA(1)<='$')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IDENTIFIER

    public void mTokens() throws RecognitionException {
        // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:8: ( T127 | T128 | T129 | T130 | T131 | LINE_BREACK | WS | ML_COMMENT | SEMI | DOT | COMMA | OPEN_PAREN | CLOSE_PAREN | STAR | AT_SIGN | STRING | NUMBER | BOOLEAN | DATETIME | NULL | PLUS | MINUS | DIVIDE | VERTBAR | EQ | QUESTION | NOT_EQ | GT | LT | LE | GE | NOT | OR | XOR | AND | MOD | BITWISE_AND | BITWISE_XOR | BITWISE_LEFT | BITWISE_RIGHT | BIT_INVERSION | ON | IS | IN | LIKE | ESCAPE | EMPTY | BETWEEN | ASC | DESC | DISTINCT | SELECT | FROM | WHERE | ORDER | BY | GROUP | HAVING | LIMIT | LEFT | JOIN | OUTER | RIGHT | FULL | INNER | CROSS | IDENTIFIER )
        int alt20=67;
        switch ( input.LA(1) ) {
        case '<':
            {
            switch ( input.LA(2) ) {
            case '<':
                {
                switch ( input.LA(3) ) {
                case '>':
                    {
                    alt20=5;
                    }
                    break;
                case '<':
                    {
                    alt20=39;
                    }
                    break;
                default:
                    alt20=1;}

                }
                break;
            case '>':
                {
                alt20=27;
                }
                break;
            case '=':
                {
                alt20=30;
                }
                break;
            default:
                alt20=29;}

            }
            break;
        case '>':
            {
            switch ( input.LA(2) ) {
            case '>':
                {
                int LA20_50 = input.LA(3);

                if ( (LA20_50=='>') ) {
                    alt20=40;
                }
                else {
                    alt20=2;}
                }
                break;
            case '=':
                {
                alt20=31;
                }
                break;
            default:
                alt20=28;}

            }
            break;
        case '^':
            {
            int LA20_3 = input.LA(2);

            if ( (LA20_3=='^') ) {
                alt20=38;
            }
            else {
                alt20=3;}
            }
            break;
        case '&':
            {
            int LA20_4 = input.LA(2);

            if ( (LA20_4=='&') ) {
                int LA20_55 = input.LA(3);

                if ( (LA20_55=='&') ) {
                    alt20=37;
                }
                else {
                    alt20=35;}
            }
            else {
                alt20=4;}
            }
            break;
        case '\r':
            {
            int LA20_5 = input.LA(2);

            if ( (LA20_5=='\n') ) {
                alt20=6;
            }
            else {
                alt20=6;}
            }
            break;
        case '\n':
            {
            alt20=6;
            }
            break;
        case '\t':
        case ' ':
            {
            alt20=7;
            }
            break;
        case '/':
            {
            int LA20_8 = input.LA(2);

            if ( (LA20_8=='*') ) {
                alt20=8;
            }
            else {
                alt20=23;}
            }
            break;
        case ';':
            {
            alt20=9;
            }
            break;
        case '.':
            {
            int LA20_10 = input.LA(2);

            if ( ((LA20_10>='0' && LA20_10<='9')) ) {
                alt20=17;
            }
            else {
                alt20=10;}
            }
            break;
        case ',':
            {
            alt20=11;
            }
            break;
        case '(':
            {
            alt20=12;
            }
            break;
        case ')':
            {
            alt20=13;
            }
            break;
        case '*':
            {
            alt20=14;
            }
            break;
        case '@':
            {
            alt20=15;
            }
            break;
        case '\"':
        case '\'':
            {
            alt20=16;
            }
            break;
        case '+':
            {
            int LA20_17 = input.LA(2);

            if ( (LA20_17=='.'||(LA20_17>='0' && LA20_17<='9')) ) {
                alt20=17;
            }
            else {
                alt20=21;}
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt20=17;
            }
            break;
        case 'T':
        case 't':
            {
            int LA20_19 = input.LA(2);

            if ( (LA20_19=='R'||LA20_19=='r') ) {
                int LA20_63 = input.LA(3);

                if ( (LA20_63=='U'||LA20_63=='u') ) {
                    int LA20_103 = input.LA(4);

                    if ( (LA20_103=='E'||LA20_103=='e') ) {
                        int LA20_134 = input.LA(5);

                        if ( ((LA20_134>='#' && LA20_134<='$')||(LA20_134>='0' && LA20_134<='9')||(LA20_134>='A' && LA20_134<='Z')||LA20_134=='_'||(LA20_134>='a' && LA20_134<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=18;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'F':
        case 'f':
            {
            switch ( input.LA(2) ) {
            case 'R':
            case 'r':
                {
                int LA20_64 = input.LA(3);

                if ( (LA20_64=='O'||LA20_64=='o') ) {
                    int LA20_104 = input.LA(4);

                    if ( (LA20_104=='M'||LA20_104=='m') ) {
                        int LA20_135 = input.LA(5);

                        if ( ((LA20_135>='#' && LA20_135<='$')||(LA20_135>='0' && LA20_135<='9')||(LA20_135>='A' && LA20_135<='Z')||LA20_135=='_'||(LA20_135>='a' && LA20_135<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=53;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'U':
            case 'u':
                {
                int LA20_65 = input.LA(3);

                if ( (LA20_65=='L'||LA20_65=='l') ) {
                    int LA20_105 = input.LA(4);

                    if ( (LA20_105=='L'||LA20_105=='l') ) {
                        int LA20_136 = input.LA(5);

                        if ( ((LA20_136>='#' && LA20_136<='$')||(LA20_136>='0' && LA20_136<='9')||(LA20_136>='A' && LA20_136<='Z')||LA20_136=='_'||(LA20_136>='a' && LA20_136<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=64;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'A':
            case 'a':
                {
                int LA20_66 = input.LA(3);

                if ( (LA20_66=='L'||LA20_66=='l') ) {
                    int LA20_106 = input.LA(4);

                    if ( (LA20_106=='S'||LA20_106=='s') ) {
                        int LA20_137 = input.LA(5);

                        if ( (LA20_137=='E'||LA20_137=='e') ) {
                            int LA20_162 = input.LA(6);

                            if ( ((LA20_162>='#' && LA20_162<='$')||(LA20_162>='0' && LA20_162<='9')||(LA20_162>='A' && LA20_162<='Z')||LA20_162=='_'||(LA20_162>='a' && LA20_162<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=18;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case '#':
            {
            alt20=19;
            }
            break;
        case 'N':
        case 'n':
            {
            switch ( input.LA(2) ) {
            case 'U':
            case 'u':
                {
                int LA20_67 = input.LA(3);

                if ( (LA20_67=='L'||LA20_67=='l') ) {
                    int LA20_107 = input.LA(4);

                    if ( (LA20_107=='L'||LA20_107=='l') ) {
                        int LA20_138 = input.LA(5);

                        if ( ((LA20_138>='#' && LA20_138<='$')||(LA20_138>='0' && LA20_138<='9')||(LA20_138>='A' && LA20_138<='Z')||LA20_138=='_'||(LA20_138>='a' && LA20_138<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=20;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'O':
            case 'o':
                {
                int LA20_68 = input.LA(3);

                if ( (LA20_68=='T'||LA20_68=='t') ) {
                    int LA20_108 = input.LA(4);

                    if ( ((LA20_108>='#' && LA20_108<='$')||(LA20_108>='0' && LA20_108<='9')||(LA20_108>='A' && LA20_108<='Z')||LA20_108=='_'||(LA20_108>='a' && LA20_108<='z')) ) {
                        alt20=67;
                    }
                    else {
                        alt20=32;}
                }
                else {
                    alt20=67;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case '-':
            {
            int LA20_23 = input.LA(2);

            if ( (LA20_23=='.'||(LA20_23>='0' && LA20_23<='9')) ) {
                alt20=17;
            }
            else {
                alt20=22;}
            }
            break;
        case '|':
            {
            int LA20_24 = input.LA(2);

            if ( (LA20_24=='|') ) {
                alt20=33;
            }
            else {
                alt20=24;}
            }
            break;
        case '=':
            {
            alt20=25;
            }
            break;
        case '?':
            {
            alt20=26;
            }
            break;
        case '!':
            {
            int LA20_27 = input.LA(2);

            if ( (LA20_27=='=') ) {
                alt20=27;
            }
            else {
                alt20=32;}
            }
            break;
        case 'O':
        case 'o':
            {
            switch ( input.LA(2) ) {
            case 'R':
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'D':
                case 'd':
                    {
                    int LA20_109 = input.LA(4);

                    if ( (LA20_109=='E'||LA20_109=='e') ) {
                        int LA20_139 = input.LA(5);

                        if ( (LA20_139=='R'||LA20_139=='r') ) {
                            int LA20_164 = input.LA(6);

                            if ( ((LA20_164>='#' && LA20_164<='$')||(LA20_164>='0' && LA20_164<='9')||(LA20_164>='A' && LA20_164<='Z')||LA20_164=='_'||(LA20_164>='a' && LA20_164<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=55;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                    }
                    break;
                case '#':
                case '$':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt20=67;
                    }
                    break;
                default:
                    alt20=33;}

                }
                break;
            case 'U':
            case 'u':
                {
                int LA20_74 = input.LA(3);

                if ( (LA20_74=='T'||LA20_74=='t') ) {
                    int LA20_110 = input.LA(4);

                    if ( (LA20_110=='E'||LA20_110=='e') ) {
                        int LA20_140 = input.LA(5);

                        if ( (LA20_140=='R'||LA20_140=='r') ) {
                            int LA20_165 = input.LA(6);

                            if ( ((LA20_165>='#' && LA20_165<='$')||(LA20_165>='0' && LA20_165<='9')||(LA20_165>='A' && LA20_165<='Z')||LA20_165=='_'||(LA20_165>='a' && LA20_165<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=62;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'N':
            case 'n':
                {
                int LA20_75 = input.LA(3);

                if ( ((LA20_75>='#' && LA20_75<='$')||(LA20_75>='0' && LA20_75<='9')||(LA20_75>='A' && LA20_75<='Z')||LA20_75=='_'||(LA20_75>='a' && LA20_75<='z')) ) {
                    alt20=67;
                }
                else {
                    alt20=42;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case 'X':
        case 'x':
            {
            int LA20_29 = input.LA(2);

            if ( (LA20_29=='O'||LA20_29=='o') ) {
                int LA20_76 = input.LA(3);

                if ( (LA20_76=='R'||LA20_76=='r') ) {
                    int LA20_112 = input.LA(4);

                    if ( ((LA20_112>='#' && LA20_112<='$')||(LA20_112>='0' && LA20_112<='9')||(LA20_112>='A' && LA20_112<='Z')||LA20_112=='_'||(LA20_112>='a' && LA20_112<='z')) ) {
                        alt20=67;
                    }
                    else {
                        alt20=34;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'A':
        case 'a':
            {
            switch ( input.LA(2) ) {
            case 'N':
            case 'n':
                {
                int LA20_77 = input.LA(3);

                if ( (LA20_77=='D'||LA20_77=='d') ) {
                    int LA20_113 = input.LA(4);

                    if ( ((LA20_113>='#' && LA20_113<='$')||(LA20_113>='0' && LA20_113<='9')||(LA20_113>='A' && LA20_113<='Z')||LA20_113=='_'||(LA20_113>='a' && LA20_113<='z')) ) {
                        alt20=67;
                    }
                    else {
                        alt20=35;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'S':
            case 's':
                {
                int LA20_78 = input.LA(3);

                if ( (LA20_78=='C'||LA20_78=='c') ) {
                    int LA20_114 = input.LA(4);

                    if ( ((LA20_114>='#' && LA20_114<='$')||(LA20_114>='0' && LA20_114<='9')||(LA20_114>='A' && LA20_114<='Z')||LA20_114=='_'||(LA20_114>='a' && LA20_114<='z')) ) {
                        alt20=67;
                    }
                    else {
                        alt20=49;}
                }
                else {
                    alt20=67;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case '%':
            {
            alt20=36;
            }
            break;
        case '~':
            {
            alt20=41;
            }
            break;
        case 'I':
        case 'i':
            {
            switch ( input.LA(2) ) {
            case 'N':
            case 'n':
                {
                switch ( input.LA(3) ) {
                case 'N':
                case 'n':
                    {
                    int LA20_116 = input.LA(4);

                    if ( (LA20_116=='E'||LA20_116=='e') ) {
                        int LA20_143 = input.LA(5);

                        if ( (LA20_143=='R'||LA20_143=='r') ) {
                            int LA20_166 = input.LA(6);

                            if ( ((LA20_166>='#' && LA20_166<='$')||(LA20_166>='0' && LA20_166<='9')||(LA20_166>='A' && LA20_166<='Z')||LA20_166=='_'||(LA20_166>='a' && LA20_166<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=65;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                    }
                    break;
                case '#':
                case '$':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt20=67;
                    }
                    break;
                default:
                    alt20=44;}

                }
                break;
            case 'S':
            case 's':
                {
                int LA20_80 = input.LA(3);

                if ( ((LA20_80>='#' && LA20_80<='$')||(LA20_80>='0' && LA20_80<='9')||(LA20_80>='A' && LA20_80<='Z')||LA20_80=='_'||(LA20_80>='a' && LA20_80<='z')) ) {
                    alt20=67;
                }
                else {
                    alt20=43;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case 'L':
        case 'l':
            {
            switch ( input.LA(2) ) {
            case 'E':
            case 'e':
                {
                int LA20_81 = input.LA(3);

                if ( (LA20_81=='F'||LA20_81=='f') ) {
                    int LA20_118 = input.LA(4);

                    if ( (LA20_118=='T'||LA20_118=='t') ) {
                        int LA20_144 = input.LA(5);

                        if ( ((LA20_144>='#' && LA20_144<='$')||(LA20_144>='0' && LA20_144<='9')||(LA20_144>='A' && LA20_144<='Z')||LA20_144=='_'||(LA20_144>='a' && LA20_144<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=60;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'I':
            case 'i':
                {
                switch ( input.LA(3) ) {
                case 'M':
                case 'm':
                    {
                    int LA20_119 = input.LA(4);

                    if ( (LA20_119=='I'||LA20_119=='i') ) {
                        int LA20_145 = input.LA(5);

                        if ( (LA20_145=='T'||LA20_145=='t') ) {
                            int LA20_168 = input.LA(6);

                            if ( ((LA20_168>='#' && LA20_168<='$')||(LA20_168>='0' && LA20_168<='9')||(LA20_168>='A' && LA20_168<='Z')||LA20_168=='_'||(LA20_168>='a' && LA20_168<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=59;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                    }
                    break;
                case 'K':
                case 'k':
                    {
                    int LA20_120 = input.LA(4);

                    if ( (LA20_120=='E'||LA20_120=='e') ) {
                        int LA20_146 = input.LA(5);

                        if ( ((LA20_146>='#' && LA20_146<='$')||(LA20_146>='0' && LA20_146<='9')||(LA20_146>='A' && LA20_146<='Z')||LA20_146=='_'||(LA20_146>='a' && LA20_146<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=45;}
                    }
                    else {
                        alt20=67;}
                    }
                    break;
                default:
                    alt20=67;}

                }
                break;
            default:
                alt20=67;}

            }
            break;
        case 'E':
        case 'e':
            {
            switch ( input.LA(2) ) {
            case 'M':
            case 'm':
                {
                int LA20_83 = input.LA(3);

                if ( (LA20_83=='P'||LA20_83=='p') ) {
                    int LA20_121 = input.LA(4);

                    if ( (LA20_121=='T'||LA20_121=='t') ) {
                        int LA20_147 = input.LA(5);

                        if ( (LA20_147=='Y'||LA20_147=='y') ) {
                            int LA20_170 = input.LA(6);

                            if ( ((LA20_170>='#' && LA20_170<='$')||(LA20_170>='0' && LA20_170<='9')||(LA20_170>='A' && LA20_170<='Z')||LA20_170=='_'||(LA20_170>='a' && LA20_170<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=47;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'S':
            case 's':
                {
                int LA20_84 = input.LA(3);

                if ( (LA20_84=='C'||LA20_84=='c') ) {
                    int LA20_122 = input.LA(4);

                    if ( (LA20_122=='A'||LA20_122=='a') ) {
                        int LA20_148 = input.LA(5);

                        if ( (LA20_148=='P'||LA20_148=='p') ) {
                            int LA20_171 = input.LA(6);

                            if ( (LA20_171=='E'||LA20_171=='e') ) {
                                int LA20_187 = input.LA(7);

                                if ( ((LA20_187>='#' && LA20_187<='$')||(LA20_187>='0' && LA20_187<='9')||(LA20_187>='A' && LA20_187<='Z')||LA20_187=='_'||(LA20_187>='a' && LA20_187<='z')) ) {
                                    alt20=67;
                                }
                                else {
                                    alt20=46;}
                            }
                            else {
                                alt20=67;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case 'B':
        case 'b':
            {
            switch ( input.LA(2) ) {
            case 'E':
            case 'e':
                {
                int LA20_85 = input.LA(3);

                if ( (LA20_85=='T'||LA20_85=='t') ) {
                    int LA20_123 = input.LA(4);

                    if ( (LA20_123=='W'||LA20_123=='w') ) {
                        int LA20_149 = input.LA(5);

                        if ( (LA20_149=='E'||LA20_149=='e') ) {
                            int LA20_172 = input.LA(6);

                            if ( (LA20_172=='E'||LA20_172=='e') ) {
                                int LA20_188 = input.LA(7);

                                if ( (LA20_188=='N'||LA20_188=='n') ) {
                                    int LA20_197 = input.LA(8);

                                    if ( ((LA20_197>='#' && LA20_197<='$')||(LA20_197>='0' && LA20_197<='9')||(LA20_197>='A' && LA20_197<='Z')||LA20_197=='_'||(LA20_197>='a' && LA20_197<='z')) ) {
                                        alt20=67;
                                    }
                                    else {
                                        alt20=48;}
                                }
                                else {
                                    alt20=67;}
                            }
                            else {
                                alt20=67;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'Y':
            case 'y':
                {
                int LA20_86 = input.LA(3);

                if ( ((LA20_86>='#' && LA20_86<='$')||(LA20_86>='0' && LA20_86<='9')||(LA20_86>='A' && LA20_86<='Z')||LA20_86=='_'||(LA20_86>='a' && LA20_86<='z')) ) {
                    alt20=67;
                }
                else {
                    alt20=56;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case 'D':
        case 'd':
            {
            switch ( input.LA(2) ) {
            case 'E':
            case 'e':
                {
                int LA20_87 = input.LA(3);

                if ( (LA20_87=='S'||LA20_87=='s') ) {
                    int LA20_125 = input.LA(4);

                    if ( (LA20_125=='C'||LA20_125=='c') ) {
                        int LA20_150 = input.LA(5);

                        if ( ((LA20_150>='#' && LA20_150<='$')||(LA20_150>='0' && LA20_150<='9')||(LA20_150>='A' && LA20_150<='Z')||LA20_150=='_'||(LA20_150>='a' && LA20_150<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=50;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            case 'I':
            case 'i':
                {
                int LA20_88 = input.LA(3);

                if ( (LA20_88=='S'||LA20_88=='s') ) {
                    int LA20_126 = input.LA(4);

                    if ( (LA20_126=='T'||LA20_126=='t') ) {
                        int LA20_151 = input.LA(5);

                        if ( (LA20_151=='I'||LA20_151=='i') ) {
                            int LA20_174 = input.LA(6);

                            if ( (LA20_174=='N'||LA20_174=='n') ) {
                                int LA20_189 = input.LA(7);

                                if ( (LA20_189=='C'||LA20_189=='c') ) {
                                    int LA20_198 = input.LA(8);

                                    if ( (LA20_198=='T'||LA20_198=='t') ) {
                                        int LA20_202 = input.LA(9);

                                        if ( ((LA20_202>='#' && LA20_202<='$')||(LA20_202>='0' && LA20_202<='9')||(LA20_202>='A' && LA20_202<='Z')||LA20_202=='_'||(LA20_202>='a' && LA20_202<='z')) ) {
                                            alt20=67;
                                        }
                                        else {
                                            alt20=51;}
                                    }
                                    else {
                                        alt20=67;}
                                }
                                else {
                                    alt20=67;}
                            }
                            else {
                                alt20=67;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
                }
                break;
            default:
                alt20=67;}

            }
            break;
        case 'S':
        case 's':
            {
            int LA20_38 = input.LA(2);

            if ( (LA20_38=='E'||LA20_38=='e') ) {
                int LA20_89 = input.LA(3);

                if ( (LA20_89=='L'||LA20_89=='l') ) {
                    int LA20_127 = input.LA(4);

                    if ( (LA20_127=='E'||LA20_127=='e') ) {
                        int LA20_152 = input.LA(5);

                        if ( (LA20_152=='C'||LA20_152=='c') ) {
                            int LA20_175 = input.LA(6);

                            if ( (LA20_175=='T'||LA20_175=='t') ) {
                                int LA20_190 = input.LA(7);

                                if ( ((LA20_190>='#' && LA20_190<='$')||(LA20_190>='0' && LA20_190<='9')||(LA20_190>='A' && LA20_190<='Z')||LA20_190=='_'||(LA20_190>='a' && LA20_190<='z')) ) {
                                    alt20=67;
                                }
                                else {
                                    alt20=52;}
                            }
                            else {
                                alt20=67;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'W':
        case 'w':
            {
            int LA20_39 = input.LA(2);

            if ( (LA20_39=='H'||LA20_39=='h') ) {
                int LA20_90 = input.LA(3);

                if ( (LA20_90=='E'||LA20_90=='e') ) {
                    int LA20_128 = input.LA(4);

                    if ( (LA20_128=='R'||LA20_128=='r') ) {
                        int LA20_153 = input.LA(5);

                        if ( (LA20_153=='E'||LA20_153=='e') ) {
                            int LA20_176 = input.LA(6);

                            if ( ((LA20_176>='#' && LA20_176<='$')||(LA20_176>='0' && LA20_176<='9')||(LA20_176>='A' && LA20_176<='Z')||LA20_176=='_'||(LA20_176>='a' && LA20_176<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=54;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'G':
        case 'g':
            {
            int LA20_40 = input.LA(2);

            if ( (LA20_40=='R'||LA20_40=='r') ) {
                int LA20_91 = input.LA(3);

                if ( (LA20_91=='O'||LA20_91=='o') ) {
                    int LA20_129 = input.LA(4);

                    if ( (LA20_129=='U'||LA20_129=='u') ) {
                        int LA20_154 = input.LA(5);

                        if ( (LA20_154=='P'||LA20_154=='p') ) {
                            int LA20_177 = input.LA(6);

                            if ( ((LA20_177>='#' && LA20_177<='$')||(LA20_177>='0' && LA20_177<='9')||(LA20_177>='A' && LA20_177<='Z')||LA20_177=='_'||(LA20_177>='a' && LA20_177<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=57;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'H':
        case 'h':
            {
            int LA20_41 = input.LA(2);

            if ( (LA20_41=='A'||LA20_41=='a') ) {
                int LA20_92 = input.LA(3);

                if ( (LA20_92=='V'||LA20_92=='v') ) {
                    int LA20_130 = input.LA(4);

                    if ( (LA20_130=='I'||LA20_130=='i') ) {
                        int LA20_155 = input.LA(5);

                        if ( (LA20_155=='N'||LA20_155=='n') ) {
                            int LA20_178 = input.LA(6);

                            if ( (LA20_178=='G'||LA20_178=='g') ) {
                                int LA20_193 = input.LA(7);

                                if ( ((LA20_193>='#' && LA20_193<='$')||(LA20_193>='0' && LA20_193<='9')||(LA20_193>='A' && LA20_193<='Z')||LA20_193=='_'||(LA20_193>='a' && LA20_193<='z')) ) {
                                    alt20=67;
                                }
                                else {
                                    alt20=58;}
                            }
                            else {
                                alt20=67;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'J':
        case 'j':
            {
            int LA20_42 = input.LA(2);

            if ( (LA20_42=='O'||LA20_42=='o') ) {
                int LA20_93 = input.LA(3);

                if ( (LA20_93=='I'||LA20_93=='i') ) {
                    int LA20_131 = input.LA(4);

                    if ( (LA20_131=='N'||LA20_131=='n') ) {
                        int LA20_156 = input.LA(5);

                        if ( ((LA20_156>='#' && LA20_156<='$')||(LA20_156>='0' && LA20_156<='9')||(LA20_156>='A' && LA20_156<='Z')||LA20_156=='_'||(LA20_156>='a' && LA20_156<='z')) ) {
                            alt20=67;
                        }
                        else {
                            alt20=61;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'R':
        case 'r':
            {
            int LA20_43 = input.LA(2);

            if ( (LA20_43=='I'||LA20_43=='i') ) {
                int LA20_94 = input.LA(3);

                if ( (LA20_94=='G'||LA20_94=='g') ) {
                    int LA20_132 = input.LA(4);

                    if ( (LA20_132=='H'||LA20_132=='h') ) {
                        int LA20_157 = input.LA(5);

                        if ( (LA20_157=='T'||LA20_157=='t') ) {
                            int LA20_180 = input.LA(6);

                            if ( ((LA20_180>='#' && LA20_180<='$')||(LA20_180>='0' && LA20_180<='9')||(LA20_180>='A' && LA20_180<='Z')||LA20_180=='_'||(LA20_180>='a' && LA20_180<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=63;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'C':
        case 'c':
            {
            int LA20_44 = input.LA(2);

            if ( (LA20_44=='R'||LA20_44=='r') ) {
                int LA20_95 = input.LA(3);

                if ( (LA20_95=='O'||LA20_95=='o') ) {
                    int LA20_133 = input.LA(4);

                    if ( (LA20_133=='S'||LA20_133=='s') ) {
                        int LA20_158 = input.LA(5);

                        if ( (LA20_158=='S'||LA20_158=='s') ) {
                            int LA20_181 = input.LA(6);

                            if ( ((LA20_181>='#' && LA20_181<='$')||(LA20_181>='0' && LA20_181<='9')||(LA20_181>='A' && LA20_181<='Z')||LA20_181=='_'||(LA20_181>='a' && LA20_181<='z')) ) {
                                alt20=67;
                            }
                            else {
                                alt20=66;}
                        }
                        else {
                            alt20=67;}
                    }
                    else {
                        alt20=67;}
                }
                else {
                    alt20=67;}
            }
            else {
                alt20=67;}
            }
            break;
        case 'K':
        case 'M':
        case 'P':
        case 'Q':
        case 'U':
        case 'V':
        case 'Y':
        case 'Z':
        case '_':
        case 'k':
        case 'm':
        case 'p':
        case 'q':
        case 'u':
        case 'v':
        case 'y':
        case 'z':
            {
            alt20=67;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T127 | T128 | T129 | T130 | T131 | LINE_BREACK | WS | ML_COMMENT | SEMI | DOT | COMMA | OPEN_PAREN | CLOSE_PAREN | STAR | AT_SIGN | STRING | NUMBER | BOOLEAN | DATETIME | NULL | PLUS | MINUS | DIVIDE | VERTBAR | EQ | QUESTION | NOT_EQ | GT | LT | LE | GE | NOT | OR | XOR | AND | MOD | BITWISE_AND | BITWISE_XOR | BITWISE_LEFT | BITWISE_RIGHT | BIT_INVERSION | ON | IS | IN | LIKE | ESCAPE | EMPTY | BETWEEN | ASC | DESC | DISTINCT | SELECT | FROM | WHERE | ORDER | BY | GROUP | HAVING | LIMIT | LEFT | JOIN | OUTER | RIGHT | FULL | INNER | CROSS | IDENTIFIER );", 20, 0, input);

            throw nvae;
        }

        switch (alt20) {
            case 1 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:10: T127
                {
                mT127(); 

                }
                break;
            case 2 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:15: T128
                {
                mT128(); 

                }
                break;
            case 3 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:20: T129
                {
                mT129(); 

                }
                break;
            case 4 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:25: T130
                {
                mT130(); 

                }
                break;
            case 5 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:30: T131
                {
                mT131(); 

                }
                break;
            case 6 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:35: LINE_BREACK
                {
                mLINE_BREACK(); 

                }
                break;
            case 7 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:47: WS
                {
                mWS(); 

                }
                break;
            case 8 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:50: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 9 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:61: SEMI
                {
                mSEMI(); 

                }
                break;
            case 10 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:66: DOT
                {
                mDOT(); 

                }
                break;
            case 11 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:70: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 12 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:76: OPEN_PAREN
                {
                mOPEN_PAREN(); 

                }
                break;
            case 13 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:87: CLOSE_PAREN
                {
                mCLOSE_PAREN(); 

                }
                break;
            case 14 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:99: STAR
                {
                mSTAR(); 

                }
                break;
            case 15 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:104: AT_SIGN
                {
                mAT_SIGN(); 

                }
                break;
            case 16 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:112: STRING
                {
                mSTRING(); 

                }
                break;
            case 17 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:119: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 18 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:126: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 19 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:134: DATETIME
                {
                mDATETIME(); 

                }
                break;
            case 20 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:143: NULL
                {
                mNULL(); 

                }
                break;
            case 21 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:148: PLUS
                {
                mPLUS(); 

                }
                break;
            case 22 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:153: MINUS
                {
                mMINUS(); 

                }
                break;
            case 23 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:159: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 24 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:166: VERTBAR
                {
                mVERTBAR(); 

                }
                break;
            case 25 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:174: EQ
                {
                mEQ(); 

                }
                break;
            case 26 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:177: QUESTION
                {
                mQUESTION(); 

                }
                break;
            case 27 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:186: NOT_EQ
                {
                mNOT_EQ(); 

                }
                break;
            case 28 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:193: GT
                {
                mGT(); 

                }
                break;
            case 29 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:196: LT
                {
                mLT(); 

                }
                break;
            case 30 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:199: LE
                {
                mLE(); 

                }
                break;
            case 31 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:202: GE
                {
                mGE(); 

                }
                break;
            case 32 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:205: NOT
                {
                mNOT(); 

                }
                break;
            case 33 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:209: OR
                {
                mOR(); 

                }
                break;
            case 34 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:212: XOR
                {
                mXOR(); 

                }
                break;
            case 35 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:216: AND
                {
                mAND(); 

                }
                break;
            case 36 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:220: MOD
                {
                mMOD(); 

                }
                break;
            case 37 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:224: BITWISE_AND
                {
                mBITWISE_AND(); 

                }
                break;
            case 38 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:236: BITWISE_XOR
                {
                mBITWISE_XOR(); 

                }
                break;
            case 39 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:248: BITWISE_LEFT
                {
                mBITWISE_LEFT(); 

                }
                break;
            case 40 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:261: BITWISE_RIGHT
                {
                mBITWISE_RIGHT(); 

                }
                break;
            case 41 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:275: BIT_INVERSION
                {
                mBIT_INVERSION(); 

                }
                break;
            case 42 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:289: ON
                {
                mON(); 

                }
                break;
            case 43 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:292: IS
                {
                mIS(); 

                }
                break;
            case 44 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:295: IN
                {
                mIN(); 

                }
                break;
            case 45 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:298: LIKE
                {
                mLIKE(); 

                }
                break;
            case 46 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:303: ESCAPE
                {
                mESCAPE(); 

                }
                break;
            case 47 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:310: EMPTY
                {
                mEMPTY(); 

                }
                break;
            case 48 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:316: BETWEEN
                {
                mBETWEEN(); 

                }
                break;
            case 49 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:324: ASC
                {
                mASC(); 

                }
                break;
            case 50 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:328: DESC
                {
                mDESC(); 

                }
                break;
            case 51 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:333: DISTINCT
                {
                mDISTINCT(); 

                }
                break;
            case 52 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:342: SELECT
                {
                mSELECT(); 

                }
                break;
            case 53 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:349: FROM
                {
                mFROM(); 

                }
                break;
            case 54 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:354: WHERE
                {
                mWHERE(); 

                }
                break;
            case 55 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:360: ORDER
                {
                mORDER(); 

                }
                break;
            case 56 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:366: BY
                {
                mBY(); 

                }
                break;
            case 57 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:369: GROUP
                {
                mGROUP(); 

                }
                break;
            case 58 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:375: HAVING
                {
                mHAVING(); 

                }
                break;
            case 59 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:382: LIMIT
                {
                mLIMIT(); 

                }
                break;
            case 60 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:388: LEFT
                {
                mLEFT(); 

                }
                break;
            case 61 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:393: JOIN
                {
                mJOIN(); 

                }
                break;
            case 62 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:398: OUTER
                {
                mOUTER(); 

                }
                break;
            case 63 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:404: RIGHT
                {
                mRIGHT(); 

                }
                break;
            case 64 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:410: FULL
                {
                mFULL(); 

                }
                break;
            case 65 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:415: INNER
                {
                mINNER(); 

                }
                break;
            case 66 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:421: CROSS
                {
                mCROSS(); 

                }
                break;
            case 67 :
                // /home/vmb/app/IdeaProjects/jengine/utils/ql/src/main/antlr/QL.g:1:427: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\3\2\uffff\1\3\1\uffff";
    static final String DFA9_eofS =
        "\6\uffff";
    static final String DFA9_minS =
        "\2\56\2\uffff\1\56\1\uffff";
    static final String DFA9_maxS =
        "\2\71\2\uffff\1\71\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\1";
    static final String DFA9_specialS =
        "\6\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\5\1\uffff\12\4",
            "",
            "",
            "\1\5\1\uffff\12\4",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "101:35: ( ( NUM DOT NUM ) | DOT NUM | NUM )";
        }
    }
 

}