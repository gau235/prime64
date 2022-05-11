package lgpl3.prime64.sample;

import lgpl3.prime64.Miner;

/**
 * 找質數.<br/>
 * To mine prime.
 * 
 * @version 2017/10/14_12:53:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex01_MinePrime" >Ex01_MinePrime</a>
 * 
 */
public class Ex01_MinePrime {

	public static void main(String[] sAry) {

		long[] ary = Miner.mineNRetAry(20, 30); // 叫找质数的人去找 20 到 30 的质数

		System.out.println(ary[0]); // 显示找到的质数
		System.out.println(ary[1]); // 显示找到的质数

	}
}
