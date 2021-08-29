package 농협은행;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class no1{
	public static void main(String[] args) {
	    Stack<Character> stack = new Stack<>();
	    stack.push('1');
	    Set<String> set = new HashSet<>();
	    String src = "123";
	    char c1 = '1';
	    char c2 = '1';
	    int name = c1^c2;
	    src =String.valueOf(name);
	    System.out.println(src);
	    System.out.println(c1 ^ c2);
	    System.out.println(name);
	    System.out.println(stack.size());
	}
}