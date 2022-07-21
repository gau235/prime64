package lgpl3.eqDiv;

/**
 * To solve.<br/>
 * To solve.
 *
 * @version 2019/06/01_09:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=XyzSolver" >XyzSolver.java</a>
 *
 */
public abstract class XyzSolver {

	// private static final Class<?> THIS = XyzSolver.class;

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64 delta2(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// a1X+a2Y=a3
		// b1X+b2Y=b3

		Fr64 slash = datForFr64ToSolveXyz.a1.mul(datForFr64ToSolveXyz.b2);
		Fr64 backslash = datForFr64ToSolveXyz.a2.mul(datForFr64ToSolveXyz.b1);

		return slash.sub(backslash);

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64 deltaX2(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// a1X+a2Y=a3
		// b1X+b2Y=b3

		Fr64 slash = datForFr64ToSolveXyz.a3.mul(datForFr64ToSolveXyz.b2);
		Fr64 backslash = datForFr64ToSolveXyz.a2.mul(datForFr64ToSolveXyz.b3);

		return slash.sub(backslash);

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64 deltaY2(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// a1X+a2Y=a3
		// b1X+b2Y=b3

		Fr64 slash = datForFr64ToSolveXyz.a1.mul(datForFr64ToSolveXyz.b3);
		Fr64 backslash = datForFr64ToSolveXyz.a3.mul(datForFr64ToSolveXyz.b1);

		return slash.sub(backslash);

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64[] solve2(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// y1 X + y2 Y + a3 Z = a4
		// b1 X + b2 Y + b3 Z = b4
		// c1 X + c2 Y + c3 Z = c4

		Fr64 delta2 = delta2(datForFr64ToSolveXyz);

		return new Fr64[] { deltaX2(datForFr64ToSolveXyz).div(delta2), deltaY2(datForFr64ToSolveXyz).div(delta2) };

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64 delta3(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// y1 X + y2 Y + a3 Z = a4
		// b1 X + b2 Y + b3 Z = b4
		// c1 X + c2 Y + c3 Z = c4

		Fr64 slash1 = datForFr64ToSolveXyz.a1.mul(datForFr64ToSolveXyz.b2).mul(datForFr64ToSolveXyz.c3);
		Fr64 slash2 = datForFr64ToSolveXyz.b1.mul(datForFr64ToSolveXyz.c2).mul(datForFr64ToSolveXyz.a3);
		Fr64 slash3 = datForFr64ToSolveXyz.c1.mul(datForFr64ToSolveXyz.a2).mul(datForFr64ToSolveXyz.b3);

		Fr64 backslash1 = datForFr64ToSolveXyz.a3.mul(datForFr64ToSolveXyz.b2).mul(datForFr64ToSolveXyz.c1);
		Fr64 backslash2 = datForFr64ToSolveXyz.b3.mul(datForFr64ToSolveXyz.c2).mul(datForFr64ToSolveXyz.a1);
		Fr64 backslash3 = datForFr64ToSolveXyz.c3.mul(datForFr64ToSolveXyz.a2).mul(datForFr64ToSolveXyz.b1);

		return slash1.add(slash2).add(slash3).sub(backslash1).sub(backslash2).sub(backslash3);

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64 deltaX3(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// y1 X + y2 Y + a3 Z = a4
		// b1 X + b2 Y + b3 Z = b4
		// c1 X + c2 Y + c3 Z = c4

		Fr64 slash1 = datForFr64ToSolveXyz.a4.mul(datForFr64ToSolveXyz.b2).mul(datForFr64ToSolveXyz.c3);
		Fr64 slash2 = datForFr64ToSolveXyz.b4.mul(datForFr64ToSolveXyz.c2).mul(datForFr64ToSolveXyz.a3);
		Fr64 slash3 = datForFr64ToSolveXyz.c4.mul(datForFr64ToSolveXyz.a2).mul(datForFr64ToSolveXyz.b3);

		Fr64 backslash1 = datForFr64ToSolveXyz.a3.mul(datForFr64ToSolveXyz.b2).mul(datForFr64ToSolveXyz.c4);
		Fr64 backslash2 = datForFr64ToSolveXyz.b3.mul(datForFr64ToSolveXyz.c2).mul(datForFr64ToSolveXyz.a4);
		Fr64 backslash3 = datForFr64ToSolveXyz.c3.mul(datForFr64ToSolveXyz.a2).mul(datForFr64ToSolveXyz.b4);

		return slash1.add(slash2).add(slash3).sub(backslash1).sub(backslash2).sub(backslash3);

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64 deltaY3(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// y1 X + y2 Y + a3 Z = a4
		// b1 X + b2 Y + b3 Z = b4
		// c1 X + c2 Y + c3 Z = c4

		Fr64 slash1 = datForFr64ToSolveXyz.a1.mul(datForFr64ToSolveXyz.b4).mul(datForFr64ToSolveXyz.c3);
		Fr64 slash2 = datForFr64ToSolveXyz.b1.mul(datForFr64ToSolveXyz.c4).mul(datForFr64ToSolveXyz.a3);
		Fr64 slash3 = datForFr64ToSolveXyz.c1.mul(datForFr64ToSolveXyz.a4).mul(datForFr64ToSolveXyz.b3);

		Fr64 backslash1 = datForFr64ToSolveXyz.a3.mul(datForFr64ToSolveXyz.b4).mul(datForFr64ToSolveXyz.c1);
		Fr64 backslash2 = datForFr64ToSolveXyz.b3.mul(datForFr64ToSolveXyz.c4).mul(datForFr64ToSolveXyz.a1);
		Fr64 backslash3 = datForFr64ToSolveXyz.c3.mul(datForFr64ToSolveXyz.a4).mul(datForFr64ToSolveXyz.b1);

		return slash1.add(slash2).add(slash3).sub(backslash1).sub(backslash2).sub(backslash3);

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64 deltaZ3(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// y1 X + y2 Y + a3 Z = a4
		// b1 X + b2 Y + b3 Z = b4
		// c1 X + c2 Y + c3 Z = c4

		Fr64 slash1 = datForFr64ToSolveXyz.a1.mul(datForFr64ToSolveXyz.b2).mul(datForFr64ToSolveXyz.c4);
		Fr64 slash2 = datForFr64ToSolveXyz.b1.mul(datForFr64ToSolveXyz.c2).mul(datForFr64ToSolveXyz.a4);
		Fr64 slash3 = datForFr64ToSolveXyz.c1.mul(datForFr64ToSolveXyz.a2).mul(datForFr64ToSolveXyz.b4);

		Fr64 backslash1 = datForFr64ToSolveXyz.a4.mul(datForFr64ToSolveXyz.b2).mul(datForFr64ToSolveXyz.c1);
		Fr64 backslash2 = datForFr64ToSolveXyz.b4.mul(datForFr64ToSolveXyz.c2).mul(datForFr64ToSolveXyz.a1);
		Fr64 backslash3 = datForFr64ToSolveXyz.c4.mul(datForFr64ToSolveXyz.a2).mul(datForFr64ToSolveXyz.b1);

		return slash1.add(slash2).add(slash3).sub(backslash1).sub(backslash2).sub(backslash3);

	}

	/**
	 * delta.<br/>
	 * delta.
	 */
	public static Fr64[] solve3(DatForFr64ToSolveXyz datForFr64ToSolveXyz) {

		// y1 X + y2 Y + a3 Z = a4
		// b1 X + b2 Y + b3 Z = b4
		// c1 X + c2 Y + c3 Z = c4

		Fr64 delta3 = delta3(datForFr64ToSolveXyz);

		return new Fr64[] { deltaX3(datForFr64ToSolveXyz).div(delta3), deltaY3(datForFr64ToSolveXyz).div(delta3),
				deltaZ3(datForFr64ToSolveXyz).div(delta3) };

	}

}
