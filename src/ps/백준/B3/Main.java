package ps.백준.B3;

public class Main {
	public static void main(String[] args) {
		int a = 4;
		int b = 1;
		
		String a1 = Integer.toBinaryString(a);
		String a3 = Integer.toBinaryString(a ^ b);
		String result = a1+a3;
		System.out.println(a1);
		System.out.println(a3);
		
		System.out.println(result);
		
		System.out.println(result.substring(1, 3));
	}
		

}
