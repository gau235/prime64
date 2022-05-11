package lgpl3.other.sample;

import java.lang.reflect.Method;

import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.prime64.PrimeAry2D;

/**
 * 列出 class 內所有方法名.<br/>
 * The sample to list all methods' names.
 *
 * @version 2020/02/23_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex105_ListAllMethodName" >
 *          Ex105_ListAllMethodName.java</a>
 *
 */
public class Ex105_ListAllMethodName {

	public static Arr<StringBuilder> listAllMethodName(Class<?> theClass) {

		Method[] aryOfMethod = theClass.getMethods();

		Arr<StringBuilder> retArrOfStr = new Arr<StringBuilder>(StringBuilder.class);

		for (int i = 0; i != aryOfMethod.length; i++) {

			retArrOfStr.a(new StringBuilder(aryOfMethod[i].toGenericString()));

		}

		return retArrOfStr;

	}

	public static void listAllMethodName(Class<?> theClass, String sIfContain) {

		Method[] aryOfMethod = theClass.getMethods();

		for (int idx = 0; idx != aryOfMethod.length; idx++) {

			if (aryOfMethod[idx].toGenericString().contains(sIfContain))
				O.l(aryOfMethod[idx].toGenericString());

		}
	}

	public static void main(String[] sAry) {

		listAllMethodName(PrimeAry2D.class, "sort");
	}
}
