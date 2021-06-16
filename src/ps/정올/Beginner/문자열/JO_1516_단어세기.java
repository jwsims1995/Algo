package ps.정올.Beginner.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class JO_1516_단어세기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output;
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		for (int t = 0; t < 30; t++) {
			String[] line = input.readLine().split(" ");
			if(line[0].equals("END"))System.exit(0);
			
			output = new StringBuilder();
			Arrays.sort(line);
			
//			for (String string : line) {
//				System.out.println(string);
//			}
			List<String> list = new ArrayList<>();
			list.add(line[0]);
			for (int l = 1; l < line.length; l++) {
				if(!line[l-1].equals(line[l]))list.add(line[l]);
			}
			
//			System.out.println(list);
			
			
			for (int i = 0; i < list.size(); i++) {
				output.append(list.get(i)).append(" : ");
				int cnt = 0;
				for (int l = 0; l < line.length; l++) {
					if(list.get(i).equals(line[l]))cnt++;
				}
				output.append(cnt).append("\n");
			}
			System.out.print(output);
			
		}
	}
}
