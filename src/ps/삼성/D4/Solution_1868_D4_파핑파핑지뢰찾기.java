package ps.삼성.D4;
/**
 * @since 2021. 3. 18.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_1868_D4_파핑파핑지뢰찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
	}

	static String src = "10\r\n" + "5 16\r\n" + "3 1 3 5 6\r\n" + "2 10\r\n" + "7 7\r\n" + "3 120\r\n" + "83 64 36\r\n"
			+ "4 416\r\n" + "299 239 116 128\r\n" + "5 1535\r\n" + "351 228 300 623 954\r\n" + "10 2780\r\n"
			+ "268 61 201 535 464 168 491 275 578 153\r\n" + "10 1162\r\n"
			+ "73 857 502 826 923 653 168 396 353 874\r\n" + "15 8855\r\n"
			+ "3711 576 9081 3280 1413 6818 5142 2981 1266 484 5757 2451 6961 4862 2086\r\n" + "15 57209\r\n"
			+ "8903 5737 3749 8960 724 6295 1240 4325 8023 3640 2223 639 4161 5330 4260\r\n" + "20 78988\r\n"
			+ "3811 2307 3935 5052 4936 3473 6432 7032 1560 1992 5332 7000 4020 9344 2732 8815 9924 8998 9540 4640\r\n";
}
