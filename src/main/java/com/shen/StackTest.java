package com.shen;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackTest {
	
	private static Logger logger = LoggerFactory.getLogger(StackTest.class);
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		System.out.println("now the stack is " + isEmpty(stack));
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		System.out.println("now the stack is " + isEmpty(stack));
		System.out.println("top element ="+stack.peek());
		System.out.println("remove : "+stack.pop());
		System.out.println("remove : "+stack.pop());
		System.out.println("2 at the index of the stack ="+stack.search("2"));
		logger.debug("------------");
		StackTest.aaa();
	}

	public static String isEmpty(Stack<String> stack) {
		return stack.empty() ? "empty" : "not empty";
	}
	
	public static native void aaa();
}