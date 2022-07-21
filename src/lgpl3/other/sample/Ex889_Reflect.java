package lgpl3.other.sample;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lgpl3.o.O;
import lgpl3.prime64.Miner;

/**
 * To reflect.<br/>
 * <br/>
 * To reflect.
 *
 * @version 2017/06/14_21:45:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex889_Reflect" >Ex889_Reflect.java</a>
 *
 */
public class Ex889_Reflect {

	public static void main(String[] sAry) throws Throwable {

		Class<?> theClass = Miner.class;

		do {

			O.l(theClass.toString());

			Field[] aryOfField = theClass.getDeclaredFields();
			Method[] aryOfMethod = theClass.getDeclaredMethods();

			for (int i1 = 0; i1 != aryOfField.length; i1++) {

				O.l(O.S9 + aryOfField[i1].getName() + O.S32 + aryOfField[i1].getType());

			}

			O.l();

			for (int i1 = 0; i1 != aryOfMethod.length; i1++) {

				// O.l(O.S9 + aryOfMethod[i1].getName() + O.S58);
				//
				// Parameter[] aryOfParam = aryOfMethod[i1].getParameters();
				// for (int i2 = 0; i2 != aryOfParam.length; i2++) {
				//
				// O.l(O.S9 + aryOfParam[i2].getType() + O.S32 + aryOfParam[i2].getName());
				//
				// }

				O.l();

			}

			// O.l();

		} while ((theClass = theClass.getSuperclass()) != Object.class);

	}

}