package com.bridgelabz.DataStructureAlgorithm;

import java.util.Scanner;

public class PalindromeChecker {/* create node in linked list*/
	class Node
	{
		Node next;
		Object data;
		public Node(Object data)
		{
			this.data=data;
		}
	}
	Node head;
	
	/*Method to display data of linked-list*/
	void display()
	{
		if(head==null)
		{
			System.out.println("No elements to display");
			return;
		}
		Node t=head;
		while(t!=null)
		{
			if(t.next!=null)
				System.out.print(t.data+"-->");   //Traversing linked-list till end and displaying data
			else
				System.out.print(t.data+"\n");
			
			t=t.next;
		}
		
	}
	
	/* Method to add new-node to Linked List*/
	boolean add(Object data)
	{
		Node n=new Node(data);
		
		if(head==null)
		{
			head=n;
			return true;
		}
		Node t=head;
		while(t.next!=null)
		{
			t=t.next;
		}
		t.next=n;
		return true;
	}
	
	/* Method to remove node at beginning of Linked List*/
	char deleteFirst()
	{
		Node t=head;
		char data=' ';
		
		if(head==null)
		{
			System.out.println("No elements to delete");
			return data;
		}
		
		if(t.next==null)
		{
			data=(char)t.data;
			head=null;
		}
		data=(char)t.data;
		head=t.next;
		return data;
	}
	
	/* Method to remove node at the end of Linked List*/
	char deleteLast()
	{
		Node t=head;
		
		char data=' ';
		
		if(head==null)
		{
			//System.out.println("No elements to delete");
			return data;
		}
		
		while(t.next!=null)
		{
			if(t.next.next==null)
			{
				data=(char)t.next.data;
				t.next=null;
				return data;
			}
			t=t.next;
		}
		
		data=(char)head.data;
		head=null;
		return data;
	}
	
	
	/* Method to return size of Linked List*/
	int size()
	{
		int count=0;
		Node t=head;
		while(t!=null)
		{
			count++;
			t=t.next;
		}
		return count;
	}
	
	/* Method to check if String is polindrome*/
	boolean isPolindrome(PalindromeChecker deque)
	{
		Node t=head;
		boolean polindrome=true;
		
		
		if(deque.size()%2==0 && deque.size()!=0)  //If string is of even length
		{
			while(t!=null&&deque.size()!=0)
			{
				char first=deque.deleteFirst();
				System.out.println("fetching: "+first+" from front end");
				char last=deque.deleteLast();
				System.out.println("fetching: "+last+" from rear end");
				System.out.println("Comparing "+first+" & "+last+"\n");
				
					if(first!=last)    //Comparing first node-data with last node-data
					{
						polindrome=false;
						System.out.println(first+" & "+last+" are not same\n");
						break;
					}
					else
						System.out.println(first+" & "+last+" are same\n");
				t=t.next;
			}
		}
		else  //If string is of odd length
		{
			int index=deque.size()/2;
			
			int i=0;
			
			while(i<index && deque.size()!=0)
			{
				char first=deque.deleteFirst();
				System.out.println("fetching: "+first+" from front end");
				char last=deque.deleteLast();
				System.out.println("fetching: "+last+" from rear end");
				System.out.println("Comparing "+first+" & "+last+"\n");
				
					if(first!=last)
					{
						System.out.println(first+" & "+last+" are not same\n");
						polindrome=false;
						break;
					}
					else
						System.out.println(first+" & "+last+" are same\n");
				i++;
			}
			
		}
		return polindrome;
		
	}
	
	public static void main(String[] args) 
	{
		PalindromeChecker deque=new PalindromeChecker();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the string to check if Polindrome: ");
			String string=scanner.next();
			
			char data[]=string.toCharArray();
			
			for (int i = 0; i < data.length; i++) 
			{
				deque.add(data[i]);
			}
			
		  System.out.println("No of elements in dequeue :"+deque.size());
		  
		  boolean check=deque.isPolindrome(deque);
		  
		  if(check)
			  System.out.println(string+" Polindrome"); 
		  else
			  System.out.println(string+" Not Polindrome");
	}
}