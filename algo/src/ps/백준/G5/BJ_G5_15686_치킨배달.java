package ps.백준.G5;
/**
 * @since 2021. 2. 17.
 * @author Jaewon
 * @see https://www.acmicpc.net/problem/15686
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_15686_치킨배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M;

	// 일반 집과 치킨집을 관리하자.
	static List<Point> stores, homes;
	// 찾을 값
	static int MinCityChickenDist = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken()) + 1;// 지도의 크기 : 1부터 시작한다.
		M = Integer.parseInt(tokens.nextToken());// 남길 치킨집 수

		stores = new ArrayList<>();
		homes = new ArrayList<>();

		for (int r = 1; r < N; r++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for (int c = 1; c < N; c++) {
				String info = tokens.nextToken();
				if (info.equals("1")) {
					homes.add(new Point(r, c));
				} else if (info.equals("2")) {
					stores.add(new Point(r, c));
				}
			}
		}
		System.out.println(homes);
		System.out.println(stores);
		
		// 입력 완료
		// stores에서 M 개 골라보기.
		combi(M, new Point[M], 0);
		// 정답 출력
		System.out.println(MinCityChickenDist);
	}

	static void combi(int toChoose, Point[] choosed, int startIdx) {
		if (toChoose == 0) {
			// System.out.println(Arrays.toString(choosed));
			// 이렇게 조합되었을 때.... 최소 치킨거리?
			check(choosed);
			return;
		}
		for (int i = startIdx; i < stores.size(); i++) {
			choosed[choosed.length - toChoose] = stores.get(i);
			combi(toChoose - 1, choosed, i + 1);
		}
	}
	
	static void check(Point [] temp) {
		// 현재의 조합(temp)이 결정되었을 때 각 집과의 도시 치킨 거리를 찾아보자.
		int cityChickenDist = 0;
		for(Point home: homes) {
			//home에서의 최소 치킨 거리를 찾아보자.
			int chickenDist = Integer.MAX_VALUE;
			for(Point chicken: temp) {
				int dist = home.getDist(chicken);
				chickenDist = Math.min(dist, chickenDist);
			}
			cityChickenDist +=chickenDist;
		}
		// 이 도시 치킨거리가 최소 도시 치킨거리인가?
		MinCityChickenDist = Math.min(MinCityChickenDist, cityChickenDist);
	}

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

		// 두 지점 간의 거리 계산
		public int getDist(Point other) {
			return Math.abs(this.row - other.row) + Math.abs(this.col - other.col);
		}

	}

	private static String src = "5 1\r\n" +
			"1 2 0 2 1\r\n" +
			"1 2 0 2 1\r\n" +
			"1 2 0 2 1\r\n" +
			"1 2 0 2 1\r\n" +
			"1 2 0 2 1";
}
