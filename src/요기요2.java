import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class 요기요2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int cnt ;
	public static void main(String[] args) throws IOException, ParseException {
		input= new BufferedReader(new StringReader(src));
		List<String> list = new ArrayList<String>();
		for (int n = 0; n < 9; n++) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			
			String flag=  "1990-01-31";
			
			String[] file  = input.readLine().split("~");
	        for(int f = 0; f<file.length; f++){
	            System.out.println(file[f].trim());
	            String[] info = file[f].trim().split(" ");
	            System.out.println(Arrays.toString(info));
	            
	            if(info[0].endsWith(" ") ||info[0].endsWith("K") ||info[0].endsWith("M")) {
	            	
	            	if(info[0].endsWith("M") && Integer.parseInt(info[0].substring(0, info.length-1)) >= 14) {
	            		continue;
	            	}//크기로 필터링 된 것들 중
	            	
	    			Date day1 = sdf.parse(flag);
	    			Date day2 = sdf.parse(info[1]);
	    			
	            	//int compare = sdf.format(info[1]).compareTo(sdf.format(test));
	            	System.out.println(day1.compareTo(day2));
	            	if(day1.compareTo(day2) <= 0) { // 날짜로 필터링
	            		cnt++;
	            	}
	            }
	            else continue;
	            // 크기로 필터링
	            
	        }
			
		}
		System.out.println("답 : "+cnt);
	}
	
	static String src = "715K 2009-09-23 system.zip~\r\n" + 
			" 179K 2013-08-14 to-do-list.xml~\r\n" + 
			" 645K 2013-06-19 blockbuster.mpeg~\r\n" + 
			"  536 2010-12-12 notes.html\r\n" + 
			" 688M 1990-02-11 delete-this.zip~\r\n" + 
			"  23K 1987-05-24 setup.png~\r\n" + 
			" 616M 1965-06-06 important.html\r\n" + 
			"  14M 1992-05-31 crucial-module.java~\r\n" + 
			" 192K 1990-01-31 very-long-filename.dll~";
}
