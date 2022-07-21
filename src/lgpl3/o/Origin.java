package lgpl3.o;

/**
 * 本類別原生人.<br/>
 * 提供每個類別一個識別數字.<br/>
 * <br/>
 * To identify the classes in program.<br/>
 * You need to compile this first.<br/>
 * <br/>
 * a: add; append<br/>
 * aft: after<br/>
 * ans: answer<br/>
 * app: application<br/>
 * ary: array or long[]<br/>
 * ary64: long[]<br/>
 * asc: ascend<br/>
 * attr: attribute<br/>
 * b32: the type int<br/>
 * b64: the type long; 64 bit integer<br/>
 * bef: before<br/>
 * calcu: calculate<br/>
 * carte: Cartesian<br/>
 * catag: catagorize<br/>
 * circ: circle; circular<br/>
 * col: collect<br/>
 * comb: combinatorics<br/>
 * compa: comparable; comparator<br/>
 * compo: composite<br/>
 * condi: condition<br/>
 * conj: conjecture<br/>
 * dat: datum<br/>
 * df: deformat<br/>
 * decompo: decompose<br/>
 * der:derange; deranger<br/>
 * dev: develop<br/>
 * dim: dimension<br/>
 * div: divisor; divide<br/>
 * dup: duplicate<br/>
 * dyna: dynamically<br/>
 * elem: element<br/>
 * eq: equal; equally<br/>
 * ex: exception; exclude<br/>
 * f32: the type float<br/>
 * f64: the type double<br/>
 * fac: factorial<br/>
 * fr64: a kind of fraction number<br/>
 * ident:identical<br/>
 * idx: index<br/>
 * in: include; input; internal<br/>
 * int32: the type int<br/>
 * int64: the type long; 64 bit integer<br/>
 * iter: iterative; iteration; iterator<br/>
 * lim: limit<br/>
 * l: left, list<br/>
 * lsnr: listener<br/>
 * n: nature number; and; then<br/>
 * nat: nature<br/>
 * o: origin<br/>
 * occur: occurrence<br/>
 * ori: origin<br/>
 * ov: over<br/>
 * prod: product<br/>
 * progr: progress<br/>
 * qty:quantity<br/>
 * r: right<br/>
 * rec: record<br/>
 * reg: regex<br/>
 * rmd: remained; remainder<br/>
 * rnd: random<br/>
 * regu:regularize<br/>
 * rev: reverse<br/>
 * scrl: scroll<br/>
 * seg: segment<br/>
 * seq: sequence; sequential<br/>
 * vandermonde convol: vandermonde convolution<br/>
 * w: with<br/>
 * wr: wrapper<br/>
 *
 * @version 2021/08/26_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Origin" >Origin.java</a>
 *
 * @see O_A
 */
public abstract class Origin {

	public static final char C0 = 0;
	public static final char C1 = 1;
	public static final char C2 = 2;
	public static final char C3 = 3;
	public static final char C4 = 4;
	public static final char C5 = 5;
	public static final char C6 = 6;
	public static final char C7 = 7;
	public static final char C8 = 8;
	public static final char C9 = 9;// \t

	public static final char C10 = 10;// \n
	public static final char C11 = 11;
	public static final char C12 = 12;
	public static final char C13 = 13;
	public static final char C14 = 14;
	public static final char C15 = 15;
	public static final char C16 = 16;
	public static final char C17 = 17;
	public static final char C18 = 18;
	public static final char C19 = 19;

	public static final char C20 = 20;
	public static final char C21 = 21;
	public static final char C22 = 22;
	public static final char C23 = 23;
	public static final char C24 = 24;
	public static final char C25 = 25;
	public static final char C26 = 26;
	public static final char C27 = 27;
	public static final char C28 = 28;
	public static final char C29 = 29;

	public static final char C30 = 30;
	public static final char C31 = 31;
	public static final char C32 = 32;//
	public static final char C33 = 33;// !
	public static final char C34 = 34;// "
	public static final char C35 = 35;// #
	public static final char C36 = 36;// $
	public static final char C37 = 37;// %
	public static final char C38 = 38;// &
	public static final char C39 = 39;// '

	public static final char C40 = 40;// (
	public static final char C41 = 41;// )
	public static final char C42 = 42;// *
	public static final char C43 = 43;// +
	public static final char C44 = 44;// ,
	public static final char C45 = 45;// -
	public static final char C46 = 46;// .
	public static final char C47 = 47;// /
	public static final char C48 = 48;// 0
	public static final char C49 = 49;// 1

	public static final char C50 = 50;// 2
	public static final char C51 = 51;// 3
	public static final char C52 = 52;// 4
	public static final char C53 = 53;// 5
	public static final char C54 = 54;// 6
	public static final char C55 = 55;// 7
	public static final char C56 = 56;// 8
	public static final char C57 = 57;// 9
	public static final char C58 = 58;// :
	public static final char C59 = 59;// ;

	public static final char C60 = 60;// <
	public static final char C61 = 61;// =
	public static final char C62 = 62;// >
	public static final char C63 = 63;// ?
	public static final char C64 = 64;// @
	public static final char C65 = 65;// A 英文 大寫先發明, 小寫後發明
	public static final char C66 = 66;// B
	public static final char C67 = 67;// C
	public static final char C68 = 68;// D
	public static final char C69 = 69;// E

	public static final char C70 = 70;// F
	public static final char C71 = 71;// G
	public static final char C72 = 72;// H
	public static final char C73 = 73;// I
	public static final char C74 = 74;// J
	public static final char C75 = 75;// K
	public static final char C76 = 76;// L
	public static final char C77 = 77;// M
	public static final char C78 = 78;// N
	public static final char C79 = 79;// O

	public static final char C80 = 80;// P
	public static final char C81 = 81;// Q
	public static final char C82 = 82;// R
	public static final char C83 = 83; // S
	public static final char C84 = 84;// T
	public static final char C85 = 85;// U
	public static final char C86 = 86;// V
	public static final char C87 = 87;// W
	public static final char C88 = 88;// X
	public static final char C89 = 89;// Y

	public static final char C90 = 90;// Z
	public static final char C91 = 91;// [
	public static final char C92 = 92;// \
	public static final char C93 = 93;// ]
	public static final char C94 = 94;// ^
	public static final char C95 = 95;// _
	public static final char C96 = 96;// `
	public static final char C97 = 97;// a
	public static final char C98 = 98;// b
	public static final char C99 = 99;// c

	public static final char C100 = 100;// d
	public static final char C101 = 101;// e
	public static final char C102 = 102;// f
	public static final char C103 = 103;// g
	public static final char C104 = 104;// h
	public static final char C105 = 105;// i
	public static final char C106 = 106;// j
	public static final char C107 = 107;// k
	public static final char C108 = 108;// l
	public static final char C109 = 109;// m

	public static final char C110 = 110;// m
	public static final char C111 = 111;// o
	public static final char C112 = 112;// p
	public static final char C113 = 113;// q
	public static final char C114 = 114;// r
	public static final char C115 = 115;// s
	public static final char C116 = 116;// t
	public static final char C117 = 117;// u
	public static final char C118 = 118;// v
	public static final char C119 = 119;// w

	public static final char C120 = 120;// x
	public static final char C121 = 121;// n
	public static final char C122 = 122;// z
	public static final char C123 = 123;// {
	public static final char C124 = 124;// |
	public static final char C125 = 125;// }
	public static final char C126 = 126;// ~
	public static final char C127 = 127;

	public static final String S0 = String.valueOf(C0);// Character.toString(C0);
	public static final String S1 = String.valueOf(C1);
	public static final String S2 = String.valueOf(C2);
	public static final String S3 = String.valueOf(C3);
	public static final String S4 = String.valueOf(C4);
	public static final String S5 = String.valueOf(C5);
	public static final String S6 = String.valueOf(C6);
	public static final String S7 = String.valueOf(C7);
	public static final String S8 = String.valueOf(C8);// BS
	public static final String S9 = String.valueOf(C9);// \t

	public static final String S10 = String.valueOf(C10);// \n
	public static final String S11 = String.valueOf(C11);
	public static final String S12 = String.valueOf(C12);// \r
	public static final String S13 = String.valueOf(C13);
	public static final String S14 = String.valueOf(C14);
	public static final String S15 = String.valueOf(C15);
	public static final String S16 = String.valueOf(C16);
	public static final String S17 = String.valueOf(C17);
	public static final String S18 = String.valueOf(C18);
	public static final String S19 = String.valueOf(C19);

	public static final String S20 = String.valueOf(C20);
	public static final String S21 = String.valueOf(C21);
	public static final String S22 = String.valueOf(C22);
	public static final String S23 = String.valueOf(C23);
	public static final String S24 = String.valueOf(C24);
	public static final String S25 = String.valueOf(C25);
	public static final String S26 = String.valueOf(C26);
	public static final String S27 = String.valueOf(C27);
	public static final String S28 = String.valueOf(C28);
	public static final String S29 = String.valueOf(C29);

	public static final String S30 = String.valueOf(C30);
	public static final String S31 = String.valueOf(C31);
	public static final String S32 = String.valueOf(C32);//
	public static final String S33 = String.valueOf(C33);// !
	public static final String S34 = String.valueOf(C34);// "
	public static final String S35 = String.valueOf(C35);// #
	public static final String S36 = String.valueOf(C36);// $
	public static final String S37 = String.valueOf(C37);// %
	public static final String S38 = String.valueOf(C38);// &
	public static final String S39 = String.valueOf(C39);// '

	public static final String S40 = String.valueOf(C40);// (
	public static final String S41 = String.valueOf(C41);// )
	public static final String S42 = String.valueOf(C42);// *
	public static final String S43 = String.valueOf(C43);// +
	public static final String S44 = String.valueOf(C44);// ,
	public static final String S45 = String.valueOf(C45);// -
	public static final String S46 = String.valueOf(C46);// .
	public static final String S47 = String.valueOf(C47);// /
	public static final String S48 = String.valueOf(C48);// 0
	public static final String S49 = String.valueOf(C49);// 1

	public static final String S50 = String.valueOf(C50);// 2
	public static final String S51 = String.valueOf(C51);// 3
	public static final String S52 = String.valueOf(C52);// 4
	public static final String S53 = String.valueOf(C53);// 5
	public static final String S54 = String.valueOf(C54);// 6
	public static final String S55 = String.valueOf(C55);// 7
	public static final String S56 = String.valueOf(C56);// 8
	public static final String S57 = String.valueOf(C57);// 9
	public static final String S58 = String.valueOf(C58);// :
	public static final String S59 = String.valueOf(C59);// ;

	public static final String S60 = String.valueOf(C60);// <
	public static final String S61 = String.valueOf(C61);// =
	public static final String S62 = String.valueOf(C62);// >
	public static final String S63 = String.valueOf(C63);// ?
	public static final String S64 = String.valueOf(C64); // @
	public static final String S65 = String.valueOf(C65); // A
	public static final String S66 = String.valueOf(C66);
	public static final String S67 = String.valueOf(C67);
	public static final String S68 = String.valueOf(C68);
	public static final String S69 = String.valueOf(C69); // E

	public static final String S70 = String.valueOf(C70);
	public static final String S71 = String.valueOf(C71);
	public static final String S72 = String.valueOf(C72);
	public static final String S73 = String.valueOf(C73);
	public static final String S74 = String.valueOf(C74); // J
	public static final String S75 = String.valueOf(C75);
	public static final String S76 = String.valueOf(C76);
	public static final String S77 = String.valueOf(C77);
	public static final String S78 = String.valueOf(C78);
	public static final String S79 = String.valueOf(C79);

	public static final String S80 = String.valueOf(C80);
	public static final String S81 = String.valueOf(C81);
	public static final String S82 = String.valueOf(C82);
	public static final String S83 = String.valueOf(C83); // S
	public static final String S84 = String.valueOf(C84);
	public static final String S85 = String.valueOf(C85); // U
	public static final String S86 = String.valueOf(C86);
	public static final String S87 = String.valueOf(C87);
	public static final String S88 = String.valueOf(C88);
	public static final String S89 = String.valueOf(C89);

	public static final String S90 = String.valueOf(C90);
	public static final String S91 = String.valueOf(C91); // ]
	public static final String S92 = String.valueOf(C92); // \
	public static final String S93 = String.valueOf(C93); // [
	public static final String S94 = String.valueOf(C94);
	public static final String S95 = String.valueOf(C95); // _
	public static final String S96 = String.valueOf(C96);
	public static final String S97 = String.valueOf(C97);
	public static final String S98 = String.valueOf(C98);
	public static final String S99 = String.valueOf(C99);

	public static final String S100 = String.valueOf(C100); // d
	public static final String S101 = String.valueOf(C101);
	public static final String S102 = String.valueOf(C102);
	public static final String S103 = String.valueOf(C103);
	public static final String S104 = String.valueOf(C104);
	public static final String S105 = String.valueOf(C105);
	public static final String S106 = String.valueOf(C106);
	public static final String S107 = String.valueOf(C107);
	public static final String S108 = String.valueOf(C108);
	public static final String S109 = String.valueOf(C109);

	public static final String S110 = String.valueOf(C110);
	public static final String S111 = String.valueOf(C111);
	public static final String S112 = String.valueOf(C112); // p
	public static final String S113 = String.valueOf(C113);
	public static final String S114 = String.valueOf(C114);
	public static final String S115 = String.valueOf(C115); // s
	public static final String S116 = String.valueOf(C116);
	public static final String S117 = String.valueOf(C117);
	public static final String S118 = String.valueOf(C118);
	public static final String S119 = String.valueOf(C119);

	public static final String S120 = String.valueOf(C120);
	public static final String S121 = String.valueOf(C121);
	public static final String S122 = String.valueOf(C122);
	public static final String S123 = String.valueOf(C123); // {
	public static final String S124 = String.valueOf(C124); // |
	public static final String S125 = String.valueOf(C125); // }
	public static final String S126 = String.valueOf(C126); // ~
	public static final String S127 = String.valueOf(C127);

	// priority: system great than char[], great than StringBuilder, great than String

	/**
	 * 換行符號.<br/>
	 * The line separator.
	 */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * 換行符號.<br/>
	 * The line separator.
	 */
	public static final char[] C_A_L = LINE_SEPARATOR.toCharArray(); // CHAR_ARY_AS_LINE_SEPERATOR

	/**
	 * 換行符號.<br/>
	 * The line separator.
	 */
	public static final StringBuilder L = new StringBuilder(LINE_SEPARATOR); // like \r\n

	/**
	 * 空字串.<br/>
	 * The empty String.
	 */
	public static final String Z = new String(); // empty string

	/**
	 * The empty thread.<br/>
	 * The empty thread.
	 */
	public static final Thread THR0 = new Thread("THR0 for test");

	/**
	 * 數字的格式, 如 1,993<br/>
	 * The regex for int64.
	 */
	public static final String REGEX_INT = "%,d";

	/**
	 * 長度 0 的 32 位元整數陣列.<br/>
	 * The int array which length is 0.
	 */
	public static final int[] INT32_ARY0 = new int[0];

	/**
	 * 長度 0 的 64 位元整數陣列.<br/>
	 * The long array which length is 0.
	 */
	public static final long[] ARY0 = new long[0];

	/**
	 * 長度 0 的 Object 陣列.<br/>
	 * The Object array which length is 0.
	 */
	public static final Object[] OBJ_ARY0 = new Object[0];

	/**
	 * C44 and C32.<br/>
	 * C44 and C32.
	 */
	public static final StringBuilder STR_C44C32 = new StringBuilder().append(C44).append(C32);

	/**
	 * The String UTF-8.<br/>
	 * The String UTF-8.
	 */
	public static final String S_UTF_8 = "UTF-8";

	/**
	 * toStr 的方法名稱.<br/>
	 * The name of toStr method.
	 */
	public static final String S_METHOD_TO_STR = "toStr";

	/**
	 * Default capacity for StringBuilder.<br/>
	 * Default capacity for StringBuilder.
	 */
	public static int defLenForStr = 96;

	/**
	 * The blank.<br/>
	 * The blank.
	 */
	public static StringBuilder strForIndent = new StringBuilder("    ");

}
