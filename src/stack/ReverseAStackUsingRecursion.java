package stack;

import java.util.Stack;

public class ReverseAStackUsingRecursion {
	public static Stack<Integer> reverseStack(Stack<Integer> s, boolean poping, Integer value){
		if(!s.empty() && poping){
			int a = s.pop();
			if(!s.empty()){
				s = reverseStack(s, true, a);
				s = reverseStack(s, false, a);
			}
			if(s.empty()){
				s = reverseStack(s,false, a);
			}
		}
		if(!poping){
			if(!s.empty()){
				int a = s.pop();
				s = reverseStack(s, false, value);
				s.push(a);
			}
			if(s.empty()){
				s.push(value);
			}
		}
		return s;
	}
	public static void display(Stack<Integer> s){
		System.out.println(s.toString());
	}
	public static void main(String[] args){
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		display(s);
		display(reverseStack(s, true, s.peek()));	
	}
}
