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

// $ANTLR 3.0.1 /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g 2014-03-19 22:16:25

package com.cetus.jengine.orm.core.model.multi.parser;


import org.antlr.runtime.*;

public class ExprLexer extends Lexer {
    public static final int MODEL_EXPRESSION=4;
    public static final int LEFT_JOIN=12;
    public static final int FULL_JOIN=14;
    public static final int CHAR=17;
    public static final int INNER_JOIN=15;
    public static final int ATOM=8;
    public static final int AND=16;
    public static final int EOF=-1;
    public static final int Tokens=19;
    public static final int RIGHT_JOIN=13;
    public static final int LPAREN=10;
    public static final int GROUP=6;
    public static final int RPAREN=11;
    public static final int WS=9;
    public static final int IDENTIFIER=18;
    public static final int MODEL_NAME=5;
    public static final int OPERATION=7;
    public ExprLexer() {;} 
    public ExprLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g"; }

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:25:5: ( ( ' ' | '\\t' | '\\r' '\\n' | '\\n' | '\\r' ) )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:26:5: ( ' ' | '\\t' | '\\r' '\\n' | '\\n' | '\\r' )
            {
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:26:5: ( ' ' | '\\t' | '\\r' '\\n' | '\\n' | '\\r' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt1=1;
                }
                break;
            case '\t':
                {
                alt1=2;
                }
                break;
            case '\r':
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3=='\n') ) {
                    alt1=3;
                }
                else {
                    alt1=5;}
                }
                break;
            case '\n':
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("26:5: ( ' ' | '\\t' | '\\r' '\\n' | '\\n' | '\\r' )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:26:8: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:26:15: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:26:24: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 4 :
                    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:26:37: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 5 :
                    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:26:45: '\\r'
                    {
                    match('\r'); 

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

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:30:13: ( '(' )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:30:16: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:31:13: ( ')' )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:31:16: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start LEFT_JOIN
    public final void mLEFT_JOIN() throws RecognitionException {
        try {
            int _type = LEFT_JOIN;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:32:13: ( '<<' )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:32:16: '<<'
            {
            match("<<"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LEFT_JOIN

    // $ANTLR start RIGHT_JOIN
    public final void mRIGHT_JOIN() throws RecognitionException {
        try {
            int _type = RIGHT_JOIN;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:33:13: ( '>>' )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:33:16: '>>'
            {
            match(">>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RIGHT_JOIN

    // $ANTLR start FULL_JOIN
    public final void mFULL_JOIN() throws RecognitionException {
        try {
            int _type = FULL_JOIN;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:34:13: ( '^' )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:34:16: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FULL_JOIN

    // $ANTLR start INNER_JOIN
    public final void mINNER_JOIN() throws RecognitionException {
        try {
            int _type = INNER_JOIN;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:35:13: ( '&&' )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:35:16: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INNER_JOIN

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:36:13: ( ',' )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:36:16: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start CHAR
    public final void mCHAR() throws RecognitionException {
        try {
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:38:15: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:39:5: ( 'a' .. 'z' | 'A' .. 'Z' )
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

    // $ANTLR start IDENTIFIER
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:41:12: ( CHAR ( CHAR | '0' .. '9' | '_' | '$' | '#' )* )
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:42:6: CHAR ( CHAR | '0' .. '9' | '_' | '$' | '#' )*
            {
            mCHAR(); 
            // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:42:11: ( CHAR | '0' .. '9' | '_' | '$' | '#' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='#' && LA2_0<='$')||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:
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
            	    break loop2;
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
        // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:8: ( WS | LPAREN | RPAREN | LEFT_JOIN | RIGHT_JOIN | FULL_JOIN | INNER_JOIN | AND | IDENTIFIER )
        int alt3=9;
        switch ( input.LA(1) ) {
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=1;
            }
            break;
        case '(':
            {
            alt3=2;
            }
            break;
        case ')':
            {
            alt3=3;
            }
            break;
        case '<':
            {
            alt3=4;
            }
            break;
        case '>':
            {
            alt3=5;
            }
            break;
        case '^':
            {
            alt3=6;
            }
            break;
        case '&':
            {
            alt3=7;
            }
            break;
        case ',':
            {
            alt3=8;
            }
            break;
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
            alt3=9;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( WS | LPAREN | RPAREN | LEFT_JOIN | RIGHT_JOIN | FULL_JOIN | INNER_JOIN | AND | IDENTIFIER );", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:10: WS
                {
                mWS(); 

                }
                break;
            case 2 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:13: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 3 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:20: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 4 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:27: LEFT_JOIN
                {
                mLEFT_JOIN(); 

                }
                break;
            case 5 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:37: RIGHT_JOIN
                {
                mRIGHT_JOIN(); 

                }
                break;
            case 6 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:48: FULL_JOIN
                {
                mFULL_JOIN(); 

                }
                break;
            case 7 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:58: INNER_JOIN
                {
                mINNER_JOIN(); 

                }
                break;
            case 8 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:69: AND
                {
                mAND(); 

                }
                break;
            case 9 :
                // /home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g:1:73: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;

        }

    }


 

}