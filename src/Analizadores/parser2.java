
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import Analizadores.AnalizadorLexico2;
import Analizadores.sym2;
import Objetos.Componente;
import Objetos.Pagina;
import Objetos.Sitio;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser2 extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym2.class;
}

  /** Default constructor. */
  @Deprecated
  public parser2() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser2(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser2(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\031\000\002\002\004\000\002\002\003\000\002\004" +
    "\003\000\002\004\003\000\002\004\003\000\002\004\004" +
    "\000\002\004\004\000\002\004\004\000\002\005\011\000" +
    "\002\006\005\000\002\007\005\000\002\010\005\000\002" +
    "\011\005\000\002\012\005\000\002\013\015\000\002\014" +
    "\005\000\002\016\005\000\002\017\005\000\002\020\005" +
    "\000\002\020\004\000\002\021\005\000\002\021\006\000" +
    "\002\022\007\000\002\023\005\000\002\024\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\111\000\010\004\005\020\011\034\007\001\002\000" +
    "\012\002\uffff\004\uffff\020\uffff\034\uffff\001\002\000\004" +
    "\006\017\001\002\000\004\002\105\001\002\000\004\006" +
    "\017\001\002\000\012\002\ufffd\004\ufffd\020\ufffd\034\ufffd" +
    "\001\002\000\004\006\017\001\002\000\012\002\000\004" +
    "\005\020\011\034\007\001\002\000\012\002\ufffe\004\ufffe" +
    "\020\ufffe\034\ufffe\001\002\000\012\002\ufffc\004\ufffc\020" +
    "\ufffc\034\ufffc\001\002\000\012\002\ufffa\004\ufffa\020\ufffa" +
    "\034\ufffa\001\002\000\012\002\ufffb\004\ufffb\020\ufffb\034" +
    "\ufffb\001\002\000\004\040\071\001\002\000\004\022\021" +
    "\001\002\000\004\040\067\001\002\000\004\041\023\001" +
    "\002\000\004\040\065\001\002\000\004\026\025\001\002" +
    "\000\004\040\063\001\002\000\004\010\027\001\002\000" +
    "\004\040\061\001\002\000\004\012\032\001\002\000\004" +
    "\014\035\001\002\000\004\040\033\001\002\000\004\013" +
    "\034\001\002\000\004\014\ufff6\001\002\000\004\040\057" +
    "\001\002\000\004\016\040\001\002\000\004\030\043\001" +
    "\002\000\004\040\041\001\002\000\004\017\042\001\002" +
    "\000\006\005\ufff4\030\ufff4\001\002\000\006\031\047\032" +
    "\050\001\002\000\004\021\045\001\002\000\012\002\ufff3" +
    "\004\ufff3\020\ufff3\034\ufff3\001\002\000\006\031\053\032" +
    "\054\001\002\000\004\021\uffee\001\002\000\004\040\051" +
    "\001\002\000\004\033\052\001\002\000\006\031\uffed\032" +
    "\uffed\001\002\000\004\021\uffef\001\002\000\004\040\055" +
    "\001\002\000\004\033\056\001\002\000\006\031\uffec\032" +
    "\uffec\001\002\000\004\015\060\001\002\000\004\016\ufff5" +
    "\001\002\000\004\011\062\001\002\000\004\012\ufff7\001" +
    "\002\000\004\027\064\001\002\000\004\010\ufff0\001\002" +
    "\000\004\042\066\001\002\000\004\026\ufff1\001\002\000" +
    "\004\023\070\001\002\000\004\041\ufff2\001\002\000\004" +
    "\007\072\001\002\000\010\010\ufff8\022\ufff8\043\ufff8\001" +
    "\002\000\004\043\075\001\002\000\004\036\100\001\002" +
    "\000\004\040\076\001\002\000\004\044\077\001\002\000" +
    "\004\036\uffea\001\002\000\004\040\103\001\002\000\004" +
    "\035\102\001\002\000\012\002\uffeb\004\uffeb\020\uffeb\034" +
    "\uffeb\001\002\000\004\037\104\001\002\000\004\035\uffe9" +
    "\001\002\000\004\002\001\001\002\000\004\010\027\001" +
    "\002\000\004\012\032\001\002\000\004\014\035\001\002" +
    "\000\004\016\040\001\002\000\004\005\113\001\002\000" +
    "\012\002\ufff9\004\ufff9\020\ufff9\034\ufff9\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\111\000\014\002\005\004\011\005\003\013\012\022" +
    "\007\001\001\000\002\001\001\000\004\006\105\001\001" +
    "\000\002\001\001\000\004\006\072\001\001\000\002\001" +
    "\001\000\004\006\017\001\001\000\010\005\013\013\015" +
    "\022\014\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\014\021\001\001\000\002\001\001\000\004\016\023\001" +
    "\001\000\002\001\001\000\004\017\025\001\001\000\002" +
    "\001\001\000\004\007\027\001\001\000\002\001\001\000" +
    "\004\010\030\001\001\000\004\011\035\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\012\036\001\001\000\004\020\043\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\021\045\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\023\073\001\001\000" +
    "\004\024\100\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\007\106\001\001\000\004\010\107\001" +
    "\001\000\004\011\110\001\001\000\004\012\111\001\001" +
    "\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




	ArrayList<String> etiquetas = new ArrayList<>();
	
	// Connect this parser to a scanner!

	public parser2(AnalizadorLexico2 lex) {
		super(lex);
	}

        public void syntax_error(Symbol cur_token) {
            System.out.println("Error "+cur_token);
        }

	


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser2 parser;

  /** Constructor */
  CUP$parser$actions(parser2 parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= estructura_definitiva EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // estructura_definitiva ::= estructura_global2 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_definitiva",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // estructura_global2 ::= estructura_sitio 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_global2",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // estructura_global2 ::= estructura_pagina 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_global2",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // estructura_global2 ::= estructura_componente 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_global2",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // estructura_global2 ::= estructura_global2 estructura_sitio 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_global2",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // estructura_global2 ::= estructura_global2 estructura_pagina 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_global2",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // estructura_global2 ::= estructura_global2 estructura_componente 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_global2",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // estructura_sitio ::= INICIO_SITIO id usuario_creacion fecha_creacion fecha_modificacion usuario_modificacion FIN_SITIO 
            {
              Object RESULT =null;
		int e0left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int e0right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Object e0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object e2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object e3 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e4left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e4right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object e4 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
                Sitio sitio;
sitio = new Sitio(e0.toString(),e1.toString(),e2.toString(),e3.toString(),e4.toString());
System.out.println("Se encontro un sitio web");

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_sitio",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // id ::= INICIO_ID IDD FIN_ID 
            {
              Object RESULT =null;
		int e5left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e5right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e5 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e5.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("id",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // usuario_creacion ::= INICIO_USUARIO_CREACION IDD FIN_USUARIO_CREACION 
            {
              Object RESULT =null;
		int e6left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e6right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e6 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e6.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("usuario_creacion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // fecha_creacion ::= INICIO_FECHA_CREACION IDD FIN_FECHA_CREACION 
            {
              Object RESULT =null;
		int e7left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e7right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e7 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e7.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fecha_creacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // fecha_modificacion ::= INICIO_FECHA_MODIFICACION IDD FIN_FECHA_MODIFICACION 
            {
              Object RESULT =null;
		int e8left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e8right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e8 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e8.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fecha_modificacion",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // usuario_modificacion ::= INICIO_USUARIO_MODIFICACION IDD FIN_USUARIO_MODIFICACION 
            {
              Object RESULT =null;
		int e9left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e9right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e9 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e9.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("usuario_modificacion",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // estructura_pagina ::= INICIO_PAGINA id link sitio padre usuario_creacion fecha_creacion fecha_modificacion usuario_modificacion etiquetas FIN_PAGINA 
            {
              Object RESULT =null;
		int e10left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-9)).left;
		int e10right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-9)).right;
		Object e10 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-9)).value;
		int e11left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).left;
		int e11right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).right;
		Object e11 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-8)).value;
		int e12left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).left;
		int e12right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).right;
		Object e12 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-7)).value;
		int e13left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int e13right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Object e13 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int e14left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int e14right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Object e14 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int e15left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e15right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Object e15 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e31left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e31right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object e31 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e30left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e30right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object e30 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e16left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e16right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object e16 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		

                Pagina pagina;

pagina = new Pagina(e10.toString(),e11.toString(),e12.toString(),e13.toString(),e14.toString(),e15.toString(),e31.toString(),e30.toString(),etiquetas);
etiquetas= new ArrayList<>();
System.out.println("Se encontro una pagina");

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_pagina",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // link ::= INICIO_LINK IDD FIN_LINK 
            {
              Object RESULT =null;
		int e17left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e17right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e17 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e17.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("link",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // sitio ::= INICIO_SITIO_WEB IDD FIN_SITIO_WEB 
            {
              Object RESULT =null;
		int e19left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e19right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e19 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e19.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("sitio",12, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // padre ::= INICIO_PADRE IDD FIN_PADRE 
            {
              Object RESULT =null;
		int e20left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e20right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e20 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e20.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("padre",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // etiquetas ::= INICIO_ETIQUETAS etiqueta FIN_ETIQUETAS 
            {
              Object RESULT =null;
		int e21left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e21right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object e21 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("etiquetas",14, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // etiquetas ::= INICIO_ETIQUETAS FIN_ETIQUETAS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("etiquetas",14, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // etiqueta ::= INICIO_ETIQUETA IDD FIN_ETIQUETA 
            {
              Object RESULT =null;
		int e22left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e22right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e22 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		etiquetas.add(e22.toString());
              CUP$parser$result = parser.getSymbolFactory().newSymbol("etiqueta",15, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // etiqueta ::= etiqueta INICIO_ETIQUETA IDD FIN_ETIQUETA 
            {
              Object RESULT =null;
		int e23left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e23right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e23 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		etiquetas.add(e23.toString());
              CUP$parser$result = parser.getSymbolFactory().newSymbol("etiqueta",15, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // estructura_componente ::= INICIO_COMPONENTE id pagina clase FIN_COMPONENTE 
            {
              Object RESULT =null;
		int e24left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e24right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object e24 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e25left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e25right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object e25 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e26left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e26right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object e26 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
                Componente componente;
componente = new Componente(e24.toString(),e25.toString(),e26.toString());
System.out.println("Se encontro un componente");

              CUP$parser$result = parser.getSymbolFactory().newSymbol("estructura_componente",16, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // pagina ::= INICIO_PAGINA_WEB IDD FIN_PAGINA_WEB 
            {
              Object RESULT =null;
		int e27left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e27right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e27 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e27.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("pagina",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // clase ::= INICIO_CLASE IDD FIN_CLASE 
            {
              Object RESULT =null;
		int e28left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e28right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e28 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = e28.toString();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("clase",18, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}