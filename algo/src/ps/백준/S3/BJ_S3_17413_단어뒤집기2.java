package ps.백준.S3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S3_17413_단어뒤집기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output= new StringBuilder();
	static StringTokenizer tokens;
	static Stack<Character> stack;
	public static void main(String[] args) {
		stack = new Stack<>();
		< :in flag ㅇ로 바꾸고 stack 모두 pop해서 출력
		공백 && in flag x 면 모두 pop해서 출력 
		> : stack 비우기 flag x로 
		그외 다 담기
	}
}
