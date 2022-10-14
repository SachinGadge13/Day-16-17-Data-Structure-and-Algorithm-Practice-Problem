package com.bridgelabz.DataStructureAlgorithm;

import java.util.Scanner;

public class BalancedParenthisis<T> 
{
	/*  class to create node in linked list*/
	class Node
	{
		Object data;
		Node next;
		
		public Node(Object data)
		{
			this.data=data;
		}
	}
	
	
	 Node head;
	
	/* Method to add new-node at the end of Linked List*/
	boolean addLast(Object obj)
	{
		Node n=new Node(obj); 
	
		if(head==null)
		{
			head=n;    
			System.out.println("Pushed: "+n.data);
			System.out.println();
			return true;
		}
		
		Node t=head;
		
		while(t.next!=null)
		{
			t=t.next;  //Traversing linked-list till end
		}
		t.next=n;     // adding new-node at end of linked-list 
		System.out.println("Pushed: "+n.data);
		System.out.println();
		return true;
	}
	
	
	/* Method to remove node at the end of Linked List*/
	boolean deleteLast(char bracket)
	{
		char toBePopped=0;
	
		switch (bracket) 
		{

			case ')':
				toBePopped = '(';
				break;
	
			case ']':
				toBePopped = '[';
				break;
	
			case '}':
				toBePopped = '{';
		}
		
		System.out.println("To be popped: "+toBePopped);
		Node t=head;
		
		if(t==null)
		{
			System.out.println("Stack empty");  
			System.out.println();
			return false;
		}
		
		if(t.next==null && (char)t.data==toBePopped)
		{
			System.out.println("Popped: "+t.data);  //head.next=null means only one element exist so remove it
			System.out.println();
			head=null;
			return true;
		}
		else if( t.next==null && (char)t.data!=toBePopped)
		{
			return false;
		}
		
		while(t.next.next!=null)
		{
			t=t.next;    //Traversing linked-list till end
		}
		
		if((char)t.data==toBePopped)
		{
			System.out.println("popped: "+t.data);
			t.next=null;    //Removing last node
			return true;
		}
		
			return false;
	}
	
	public static void main(String[] args) 
	{
		BalancedParenthisis<Character>  stack=new BalancedParenthisis<Character> ();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the expression to check if balanced: ");
		String exp=scanner.nextLine();

		char re[]=exp.toCharArray();
		
		for (int i = 0; i < re.length; i++)
		{
			if(re[i]=='(' || re[i]=='[' || re[i]=='{')
				stack.addLast(re[i]);  //pushing "("  or "[" or "{" to stack
			else
				if(re[i]==')' || re[i]==']' || re[i]=='}')
				{
					char bracket=re[i];
					System.out.println("Found "+re[i]);
					System.out.println();
					
					boolean pop=stack.deleteLast(bracket);	 //Popping ")" from stack
					
					if(!pop) //If no element to pop i.e no "(" or '[' or '{' in stack
					{
						System.out.println("Expression Not Balanced:::::::::::");
						return;
					}
				}
		}
		
		if(stack.head==null) //Matched ")" for every "("
			System.out.println("Expression Balanced with parenthisis");
		else
			System.out.println("Expression Not Balanced");
		
	}
}