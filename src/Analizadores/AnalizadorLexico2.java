/* The following code was generated by JFlex 1.7.0 */

/* codigo de usuario */
package Analizadores;

import java_cup.runtime.*;
import java.util.Date;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>/home/jcsr/Desktop/ArchivosAnalizadores/jflexBaseDatos.flex</tt>
 */
public class AnalizadorLexico2 implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\1\1\0\1\1\1\1\22\0\1\1\2\0\1\2"+
    "\1\2\10\0\1\2\1\2\1\6\12\2\1\42\1\0\1\4\1\0"+
    "\1\5\2\0\1\14\1\34\1\17\1\11\1\20\1\22\1\30\1\23"+
    "\1\10\1\2\1\32\1\26\1\24\1\21\1\16\1\27\1\31\1\15"+
    "\1\13\1\25\1\12\1\2\1\33\1\35\2\2\4\0\1\3\1\0"+
    "\7\2\1\36\7\2\1\40\2\2\1\41\1\37\6\2\1\0\1\7"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff93\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\3\14\0"+
    "\1\3\31\0\1\3\16\0\1\5\20\0\1\3\1\6"+
    "\40\0\1\3\36\0\1\7\20\0\1\10\4\0\1\11"+
    "\1\12\4\0\1\13\1\14\3\0\1\15\1\16\1\0"+
    "\1\3\2\0\1\17\1\20\4\0\1\21\1\22\3\0"+
    "\1\23\1\24\4\0\1\25\1\26\5\0\1\27\1\0"+
    "\1\30\3\0\1\31\1\32\5\0\1\33\1\0\1\34"+
    "\27\0\1\35\12\0\1\36\7\0\1\37\2\0\1\40"+
    "\6\0\1\41\2\0\1\42\6\0\1\43\1\44\3\0"+
    "\1\45\2\0\1\46\1\47\3\0\1\50\30\0\1\51"+
    "\4\0\1\52\2\0\1\53\3\0\1\54\7\0\1\55"+
    "\2\0\1\56\7\0\1\57\1\0\1\60\2\0\1\61"+
    "\1\62";

  private static int [] zzUnpackAction() {
    int [] result = new int[359];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\43\0\43\0\106\0\151\0\43\0\214\0\257"+
    "\0\322\0\365\0\u0118\0\u013b\0\u015e\0\u0181\0\u01a4\0\u01c7"+
    "\0\u01ea\0\u020d\0\u0230\0\u0253\0\u0276\0\u0299\0\u02bc\0\u02df"+
    "\0\u0302\0\u0325\0\u0348\0\u036b\0\u038e\0\u03b1\0\u03d4\0\u03f7"+
    "\0\u041a\0\u043d\0\u0460\0\u0483\0\u04a6\0\u04c9\0\u04ec\0\u050f"+
    "\0\u0532\0\u0555\0\u0578\0\u059b\0\u05be\0\u05e1\0\u0604\0\u0627"+
    "\0\u064a\0\u066d\0\u0690\0\u06b3\0\u06d6\0\u06f9\0\u071c\0\u073f"+
    "\0\u0762\0\u0785\0\u07a8\0\u07cb\0\43\0\u07ee\0\u0811\0\u0834"+
    "\0\u0857\0\u087a\0\u089d\0\u08c0\0\u08e3\0\u0906\0\u0929\0\u094c"+
    "\0\u096f\0\u0992\0\u09b5\0\u09d8\0\u09fb\0\u0a1e\0\43\0\u0a41"+
    "\0\u0a64\0\u0a87\0\u0aaa\0\u0acd\0\u0af0\0\u0b13\0\u0b36\0\u0b59"+
    "\0\u0b7c\0\u0b9f\0\u0bc2\0\u0be5\0\u0c08\0\u0c2b\0\u0c4e\0\u0c71"+
    "\0\u0c94\0\u0cb7\0\u0cda\0\u0cfd\0\u0d20\0\u0d43\0\u0d66\0\u0d89"+
    "\0\u0dac\0\u0dcf\0\u0df2\0\u0e15\0\u0e38\0\u0e5b\0\u0e7e\0\u0ea1"+
    "\0\u0ec4\0\u0ee7\0\u0f0a\0\u0f2d\0\u0f50\0\u0f73\0\u0f96\0\u0fb9"+
    "\0\u0fdc\0\u0fff\0\u1022\0\u1045\0\u1068\0\u108b\0\u10ae\0\u10d1"+
    "\0\u10f4\0\u1117\0\u113a\0\u115d\0\u1180\0\u11a3\0\u11c6\0\u11e9"+
    "\0\u120c\0\u122f\0\u1252\0\u1275\0\u1298\0\u12bb\0\43\0\u12de"+
    "\0\u1301\0\u1324\0\u1347\0\u136a\0\u138d\0\u13b0\0\u13d3\0\u13f6"+
    "\0\u1419\0\u143c\0\u145f\0\u1482\0\u14a5\0\u14c8\0\u14eb\0\43"+
    "\0\u150e\0\u1531\0\u1554\0\u1577\0\43\0\43\0\u159a\0\u15bd"+
    "\0\u15e0\0\u1603\0\43\0\43\0\u1626\0\u1649\0\u166c\0\43"+
    "\0\43\0\u168f\0\u16b2\0\u16d5\0\u16f8\0\43\0\43\0\u171b"+
    "\0\u173e\0\u1761\0\u1784\0\43\0\43\0\u17a7\0\u17ca\0\u17ed"+
    "\0\43\0\43\0\u1810\0\u1833\0\u1856\0\u1879\0\43\0\43"+
    "\0\u189c\0\u18bf\0\u18e2\0\u1905\0\u1928\0\43\0\u194b\0\43"+
    "\0\u196e\0\u1991\0\u19b4\0\43\0\43\0\u19d7\0\u19fa\0\u1a1d"+
    "\0\u1a40\0\u1a63\0\43\0\u1a86\0\43\0\u1aa9\0\u1acc\0\u1aef"+
    "\0\u1b12\0\u1b35\0\u1b58\0\u1b7b\0\u1b9e\0\u1bc1\0\u1be4\0\u1c07"+
    "\0\u1c2a\0\u1c4d\0\u1c70\0\u1c93\0\u1cb6\0\u1cd9\0\u1cfc\0\u1d1f"+
    "\0\u1d42\0\u1d65\0\u1d88\0\u1dab\0\43\0\u1dce\0\u1df1\0\u1e14"+
    "\0\u1e37\0\u1e5a\0\u1e7d\0\u1ea0\0\u1ec3\0\u1ee6\0\u1f09\0\43"+
    "\0\u1f2c\0\u1f4f\0\u1f72\0\u1f95\0\u1fb8\0\u1fdb\0\u1ffe\0\43"+
    "\0\u2021\0\u2044\0\43\0\u2067\0\u208a\0\u20ad\0\u20d0\0\u20f3"+
    "\0\u2116\0\43\0\u2139\0\u215c\0\43\0\u217f\0\u21a2\0\u21c5"+
    "\0\u21e8\0\u220b\0\u222e\0\43\0\43\0\u2251\0\u2274\0\u2297"+
    "\0\43\0\u22ba\0\u22dd\0\43\0\43\0\u2300\0\u2323\0\u2346"+
    "\0\43\0\u2369\0\u238c\0\u23af\0\u23d2\0\u23f5\0\u2418\0\u243b"+
    "\0\u245e\0\u2481\0\u24a4\0\u24c7\0\u24ea\0\u250d\0\u2530\0\u2553"+
    "\0\u2576\0\u2599\0\u25bc\0\u25df\0\u2602\0\u2625\0\u2648\0\u266b"+
    "\0\u268e\0\43\0\u26b1\0\u26d4\0\u26f7\0\u271a\0\43\0\u273d"+
    "\0\u2760\0\43\0\u2783\0\u27a6\0\u27c9\0\43\0\u27ec\0\u280f"+
    "\0\u2832\0\u2855\0\u2878\0\u289b\0\u28be\0\43\0\u28e1\0\u2904"+
    "\0\43\0\u2927\0\u294a\0\u296d\0\u2990\0\u29b3\0\u29d6\0\u29f9"+
    "\0\43\0\u2a1c\0\43\0\u2a3f\0\u2a62\0\43\0\43";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[359];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\2\1\4\1\6\26\4"+
    "\1\7\3\4\1\2\45\0\2\4\2\0\1\4\1\0"+
    "\32\4\7\0\1\10\1\0\1\11\1\0\1\12\1\13"+
    "\1\14\1\0\1\15\1\16\1\17\1\0\1\20\2\0"+
    "\1\21\1\22\1\23\15\0\2\4\2\0\1\4\1\0"+
    "\27\4\1\24\2\4\11\0\1\25\1\0\1\26\1\27"+
    "\1\30\1\0\1\31\1\32\1\33\1\0\1\34\2\0"+
    "\1\35\1\36\1\37\24\0\1\40\44\0\1\41\37\0"+
    "\1\42\53\0\1\43\4\0\1\44\31\0\1\45\43\0"+
    "\1\46\7\0\1\47\41\0\1\50\35\0\1\51\32\0"+
    "\1\52\7\0\1\53\32\0\1\54\46\0\1\55\30\0"+
    "\2\4\2\0\1\4\1\0\27\4\1\56\2\4\12\0"+
    "\1\57\44\0\1\60\37\0\1\61\53\0\1\62\4\0"+
    "\1\63\31\0\1\64\43\0\1\65\7\0\1\66\41\0"+
    "\1\67\35\0\1\70\32\0\1\71\7\0\1\72\32\0"+
    "\1\73\46\0\1\74\33\0\1\75\47\0\1\76\55\0"+
    "\1\77\34\0\1\100\33\0\1\101\14\0\1\102\25\0"+
    "\1\103\56\0\1\104\1\0\1\105\30\0\1\106\36\0"+
    "\1\107\51\0\1\110\50\0\1\111\52\0\1\112\26\0"+
    "\1\113\32\0\1\114\16\0\1\115\14\0\2\4\2\0"+
    "\1\4\1\0\30\4\1\116\1\4\6\0\1\117\47\0"+
    "\1\120\55\0\1\121\34\0\1\122\33\0\1\123\14\0"+
    "\1\124\25\0\1\125\56\0\1\126\1\0\1\127\30\0"+
    "\1\130\36\0\1\131\51\0\1\132\50\0\1\133\52\0"+
    "\1\134\26\0\1\135\32\0\1\136\16\0\1\137\26\0"+
    "\1\140\36\0\1\141\55\0\1\142\40\0\1\143\33\0"+
    "\1\144\60\0\1\145\41\0\1\146\31\0\1\147\37\0"+
    "\1\150\60\0\1\151\34\0\1\152\31\0\1\153\55\0"+
    "\1\154\47\0\1\155\25\0\1\156\35\0\1\157\34\0"+
    "\2\4\2\0\1\4\1\0\31\4\1\160\1\161\14\0"+
    "\1\162\36\0\1\163\55\0\1\164\40\0\1\165\33\0"+
    "\1\166\60\0\1\167\41\0\1\170\31\0\1\171\37\0"+
    "\1\172\60\0\1\173\34\0\1\174\31\0\1\175\55\0"+
    "\1\176\47\0\1\177\25\0\1\200\35\0\1\201\47\0"+
    "\1\202\43\0\1\203\42\0\1\204\44\0\1\205\37\0"+
    "\1\206\45\0\1\207\40\0\1\210\41\0\1\211\45\0"+
    "\1\212\34\0\1\213\44\0\1\214\54\0\1\215\32\0"+
    "\1\216\31\0\1\217\55\0\1\220\43\0\1\221\23\0"+
    "\2\4\2\0\1\4\1\0\32\4\1\161\6\0\1\222"+
    "\51\0\1\223\43\0\1\224\42\0\1\225\44\0\1\226"+
    "\37\0\1\227\45\0\1\230\40\0\1\231\41\0\1\232"+
    "\45\0\1\233\34\0\1\234\44\0\1\235\54\0\1\236"+
    "\32\0\1\237\31\0\1\240\55\0\1\241\43\0\1\242"+
    "\31\0\1\243\35\0\1\244\1\0\1\245\42\0\1\246"+
    "\51\0\1\247\42\0\1\250\47\0\1\251\42\0\1\252"+
    "\26\0\1\253\42\0\1\254\55\0\1\255\25\0\1\256"+
    "\55\0\1\257\31\0\1\260\42\0\1\261\51\0\1\262"+
    "\34\0\1\263\44\0\1\264\35\0\1\265\1\0\1\266"+
    "\42\0\1\267\51\0\1\270\42\0\1\271\47\0\1\272"+
    "\42\0\1\273\26\0\1\274\42\0\1\275\55\0\1\276"+
    "\25\0\1\277\55\0\1\300\31\0\1\301\42\0\1\302"+
    "\51\0\1\303\44\0\1\304\57\0\1\305\26\0\1\306"+
    "\30\0\1\307\42\0\1\310\55\0\1\311\47\0\1\312"+
    "\34\0\1\313\4\0\1\314\21\0\1\315\1\0\1\316"+
    "\40\0\1\317\1\0\1\320\35\0\4\263\1\0\36\263"+
    "\16\0\1\321\57\0\1\322\26\0\1\323\30\0\1\324"+
    "\42\0\1\325\55\0\1\326\47\0\1\327\34\0\1\330"+
    "\4\0\1\331\21\0\1\332\1\0\1\333\40\0\1\334"+
    "\1\0\1\335\40\0\1\336\57\0\1\337\32\0\1\340"+
    "\53\0\1\341\35\0\1\342\43\0\1\343\43\0\1\344"+
    "\53\0\1\345\46\0\1\346\12\0\1\347\57\0\1\350"+
    "\32\0\1\351\53\0\1\352\35\0\1\353\43\0\1\354"+
    "\43\0\1\355\53\0\1\356\46\0\1\357\26\0\1\360"+
    "\4\0\1\361\52\0\1\362\24\0\1\363\51\0\1\364"+
    "\22\0\1\365\5\0\1\366\47\0\1\367\33\0\1\370"+
    "\45\0\1\371\46\0\1\372\41\0\1\373\4\0\1\374"+
    "\52\0\1\375\24\0\1\376\51\0\1\377\22\0\1\u0100"+
    "\5\0\1\u0101\47\0\1\u0102\33\0\1\u0103\45\0\1\u0104"+
    "\46\0\1\u0105\37\0\1\u0106\43\0\1\u0107\31\0\1\u0108"+
    "\56\0\1\u0109\41\0\1\u010a\27\0\1\u010b\51\0\1\u010c"+
    "\36\0\1\u010d\62\0\1\u010e\46\0\1\u010f\23\0\1\u0110"+
    "\43\0\1\u0111\31\0\1\u0112\56\0\1\u0113\41\0\1\u0114"+
    "\27\0\1\u0115\51\0\1\u0116\36\0\1\u0117\62\0\1\u0118"+
    "\46\0\1\u0119\26\0\1\u011a\33\0\1\u011b\36\0\1\u011c"+
    "\42\0\1\u011d\54\0\1\u011e\45\0\1\u011f\30\0\1\u0120"+
    "\37\0\1\u0121\55\0\1\u0122\33\0\1\u0123\36\0\1\u0124"+
    "\42\0\1\u0125\54\0\1\u0126\45\0\1\u0127\30\0\1\u0128"+
    "\37\0\1\u0129\51\0\1\u012a\36\0\1\u012b\42\0\1\u012c"+
    "\42\0\1\u012d\53\0\1\u012e\35\0\1\u012f\36\0\1\u0130"+
    "\42\0\1\u0131\42\0\1\u0132\53\0\1\u0133\40\0\1\u0134"+
    "\45\0\1\u0135\36\0\1\u0136\43\0\1\u0137\37\0\1\u0138"+
    "\45\0\1\u0139\45\0\1\u013a\36\0\1\u013b\43\0\1\u013c"+
    "\37\0\1\u013d\36\0\1\u013e\42\0\1\u013f\53\0\1\u0140"+
    "\35\0\1\u0141\33\0\1\u0142\45\0\1\u0143\42\0\1\u0144"+
    "\53\0\1\u0145\35\0\1\u0146\33\0\1\u0147\53\0\1\u0148"+
    "\43\0\1\u0149\30\0\1\u014a\54\0\1\u014b\41\0\1\u014c"+
    "\43\0\1\u014d\30\0\1\u014e\54\0\1\u014f\44\0\1\u0150"+
    "\35\0\1\u0151\36\0\1\u0152\53\0\1\u0153\35\0\1\u0154"+
    "\36\0\1\u0155\37\0\1\u0156\54\0\1\u0157\41\0\1\u0158"+
    "\31\0\1\u0159\54\0\1\u015a\41\0\1\u015b\34\0\1\u015c"+
    "\53\0\1\u015d\31\0\1\u015e\53\0\1\u015f\37\0\1\u0160"+
    "\31\0\1\u0161\53\0\1\u0162\31\0\1\u0163\56\0\1\u0164"+
    "\42\0\1\u0165\26\0\1\u0166\42\0\1\u0167\35\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[10885];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\2\1\1\11\1\1\14\0\1\1\31\0"+
    "\1\1\16\0\1\11\20\0\1\1\1\11\40\0\1\1"+
    "\36\0\1\11\20\0\1\11\4\0\2\11\4\0\2\11"+
    "\3\0\2\11\1\0\1\1\2\0\2\11\4\0\2\11"+
    "\3\0\2\11\4\0\2\11\5\0\1\11\1\0\1\11"+
    "\3\0\2\11\5\0\1\11\1\0\1\11\27\0\1\11"+
    "\12\0\1\11\7\0\1\11\2\0\1\11\6\0\1\11"+
    "\2\0\1\11\6\0\2\11\3\0\1\11\2\0\2\11"+
    "\3\0\1\11\30\0\1\11\4\0\1\11\2\0\1\11"+
    "\3\0\1\11\7\0\1\11\2\0\1\11\7\0\1\11"+
    "\1\0\1\11\2\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[359];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico2(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 154) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym2.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { error("Simbolo invalido <"+ yytext()+">");
            } 
            // fall through
          case 51: break;
          case 2: 
            { /* IGNORAR */
            } 
            // fall through
          case 52: break;
          case 3: 
            { return symbol(sym2.IDD,yytext());
            } 
            // fall through
          case 53: break;
          case 4: 
            { return symbol(sym2.PIPE);
            } 
            // fall through
          case 54: break;
          case 5: 
            { return symbol(sym2.INICIO_ID);
            } 
            // fall through
          case 55: break;
          case 6: 
            { return symbol(sym2.FIN_ID);
            } 
            // fall through
          case 56: break;
          case 7: 
            { return symbol(sym2.INICIO_LINK);
            } 
            // fall through
          case 57: break;
          case 8: 
            { return symbol(sym2.FIN_LINK);
            } 
            // fall through
          case 58: break;
          case 9: 
            { return symbol(sym2.INICIO_SITIO);
            } 
            // fall through
          case 59: break;
          case 10: 
            { return symbol(sym2.INICIO_ANCHO);
            } 
            // fall through
          case 60: break;
          case 11: 
            { return symbol(sym2.INICIO_COLOR);
            } 
            // fall through
          case 61: break;
          case 12: 
            { return symbol(sym2.INICIO_CLASE);
            } 
            // fall through
          case 62: break;
          case 13: 
            { return symbol(sym2.INICIO_TEXTO);
            } 
            // fall through
          case 63: break;
          case 14: 
            { return symbol(sym2.INICIO_PADRE);
            } 
            // fall through
          case 64: break;
          case 15: 
            { return symbol(sym2.FIN_SITIO);
            } 
            // fall through
          case 65: break;
          case 16: 
            { return symbol(sym2.FIN_ANCHO);
            } 
            // fall through
          case 66: break;
          case 17: 
            { return symbol(sym2.FIN_COLOR);
            } 
            // fall through
          case 67: break;
          case 18: 
            { return symbol(sym2.FIN_CLASE);
            } 
            // fall through
          case 68: break;
          case 19: 
            { return symbol(sym2.FIN_TEXTO);
            } 
            // fall through
          case 69: break;
          case 20: 
            { return symbol(sym2.FIN_PADRE);
            } 
            // fall through
          case 70: break;
          case 21: 
            { return symbol(sym2.INICIO_ALTURA);
            } 
            // fall through
          case 71: break;
          case 22: 
            { return symbol(sym2.INICIO_ORIGEN);
            } 
            // fall through
          case 72: break;
          case 23: 
            { return symbol(sym2.INICIO_TITULO);
            } 
            // fall through
          case 73: break;
          case 24: 
            { return symbol(sym2.INICIO_PAGINA);
            } 
            // fall through
          case 74: break;
          case 25: 
            { return symbol(sym2.FIN_ALTURA);
            } 
            // fall through
          case 75: break;
          case 26: 
            { return symbol(sym2.FIN_ORIGEN);
            } 
            // fall through
          case 76: break;
          case 27: 
            { return symbol(sym2.FIN_TITULO);
            } 
            // fall through
          case 77: break;
          case 28: 
            { return symbol(sym2.FIN_PAGINA);
            } 
            // fall through
          case 78: break;
          case 29: 
            { return symbol(sym2.INICIO_ETIQUETA);
            } 
            // fall through
          case 79: break;
          case 30: 
            { return symbol(sym2.FIN_ETIQUETA);
            } 
            // fall through
          case 80: break;
          case 31: 
            { return symbol(sym2.INICIO_SITIO_WEB);
            } 
            // fall through
          case 81: break;
          case 32: 
            { return symbol(sym2.INICIO_ETIQUETAS);
            } 
            // fall through
          case 82: break;
          case 33: 
            { return symbol(sym2.FIN_SITIO_WEB);
            } 
            // fall through
          case 83: break;
          case 34: 
            { return symbol(sym2.FIN_ETIQUETAS);
            } 
            // fall through
          case 84: break;
          case 35: 
            { return symbol(sym2.INICIO_ALINEACION);
            } 
            // fall through
          case 85: break;
          case 36: 
            { return symbol(sym2.INICIO_COMPONENTE);
            } 
            // fall through
          case 86: break;
          case 37: 
            { return symbol(sym2.INICIO_PAGINA_WEB);
            } 
            // fall through
          case 87: break;
          case 38: 
            { return symbol(sym2.FIN_ALINEACION);
            } 
            // fall through
          case 88: break;
          case 39: 
            { return symbol(sym2.FIN_COMPONENTE);
            } 
            // fall through
          case 89: break;
          case 40: 
            { return symbol(sym2.FIN_PAGINA_WEB);
            } 
            // fall through
          case 90: break;
          case 41: 
            { return symbol(sym2.INICIO_TITULO_PAGINA);
            } 
            // fall through
          case 91: break;
          case 42: 
            { return symbol(sym2.FIN_TITULO_PAGINA);
            } 
            // fall through
          case 92: break;
          case 43: 
            { return symbol(sym2.INICIO_FECHA_CREACION);
            } 
            // fall through
          case 93: break;
          case 44: 
            { return symbol(sym2.FIN_FECHA_CREACION);
            } 
            // fall through
          case 94: break;
          case 45: 
            { return symbol(sym2.INICIO_USUARIO_CREACION);
            } 
            // fall through
          case 95: break;
          case 46: 
            { return symbol(sym2.FIN_USUARIO_CREACION);
            } 
            // fall through
          case 96: break;
          case 47: 
            { return symbol(sym2.INICIO_FECHA_MODIFICACION);
            } 
            // fall through
          case 97: break;
          case 48: 
            { return symbol(sym2.FIN_FECHA_MODIFICACION);
            } 
            // fall through
          case 98: break;
          case 49: 
            { return symbol(sym2.INICIO_USUARIO_MODIFICACION);
            } 
            // fall through
          case 99: break;
          case 50: 
            { return symbol(sym2.FIN_USUARIO_MODIFICACION);
            } 
            // fall through
          case 100: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface sym
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  private String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java AnalizadorLexico2 [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        AnalizadorLexico2 scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new AnalizadorLexico2(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
