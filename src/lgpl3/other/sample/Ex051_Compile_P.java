package lgpl3.other.sample;

import java.nio.file.Paths;

import lgpl3.o.str.SW;
import lgpl3.other.iO.IOr;

/**
 * bit op.<br/>
 * bit op.
 *
 * @version 2020/03/09_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex051_Compile_P" >Ex051_Compile_P.java</a>
 *
 * @see Ex051_Compile_P
 *
 * @see Ex054_EasyC
 *
 * @see Ex056_EasyD
 */
public class Ex051_Compile_P {

	public static void main(String[] sAry) throws Throwable {

		int n = 10;
		SW sW = new SW();

		sW.l("import lgpl3.comb.b64WVCell.B64W6;");
		sW.l("import lgpl3.o.O;");
		sW.l("import lgpl3.o.ary.Seq;");
		sW.l("import lgpl3.o.time.T64;");

		sW.l("public class Test{");
		sW.l("public static void main(String[] sAry) throws Throwable {");

		sW.l("long t0 = T64.t64();");

		sW.l("int n = " + n + ";");

		for (int i = 1; i <= n; i++) {

			sW.l("int i" + i + ";");
		}

		for (int i = 1; i <= n; i++) {

			sW.l("long prefix" + i + " = 0b0L;");
		}

		sW.l("Seq seq = new Seq();");

		sW.l("for (i1 = 1; i1 <= n; i1++) {");

		sW.l("prefix1 = i1;");

		for (int i = 2; i <= n; i++) {

			sW.l("for (i" + i + " = 1; i" + i + "<= n; i" + i + "++) {");

			sW.l("if (B64W6.findIndex(prefix" + (i - 1) + ", i" + i + ") != Integer.MIN_VALUE) {continue;}");

			sW.l("prefix" + i + " = (prefix" + (i - 1) + " << B64W6.$6) | i" + i + ";");

		}

		sW.l("seq.a(prefix" + n + ");");

		for (int i = 1; i <= n; i++) {

			sW.l("}");
		}

		// s.l("StringBuilder str = B64W6.toStrByAryOfB64W6(seq.trim().ary, O.S_ARY_A_Z, O.L);");
		// s.l("O.l(str);");

		sW.l("O.l(\"t=\" +  T64.difInF32Sec(t0));");

		sW.l("}");
		sW.l("}");

		IOr.toUtf8FileAftNew(Paths.get("C:\\Users\\gau\\Desktop/Test.java"), sW.str);

	}
}
