package com.bridgelabz.DataStructureAlgorithm;

import java.util.Scanner;

/* to store transaction info token-no & amount*/
class Transaction
{
	int tokenNo;
	double amount;
	
	public Transaction(int tokenNo,double amount)
	{
		this.tokenNo=tokenNo;
		this.amount=amount;
	}
}

public class BankingCashCounter 
{
	/*  to create node in linked-list*/
	class Node
	{
		Node next;
		Object data;
		
		public Node(Object data)
		{
			this.data=data;
		}
	}
	
	/* Maintaining Outstanding balance in head-node*/
	Node head=new Node(10000.00);  //Initial bank balance 1000
	
	/*Method to add new transaction to queue*/
	boolean add(Transaction data)
	{
		Node n=new Node(data); //Creating new-node for new transaction
		
		if(head.next==null) //No people in queue so add person
		{
			head.next=n;
			Transaction t1=(Transaction)n.data;
			
			if(t1.amount>0)  //amount positive means deposit
			{
				 System.out.println("Token No:"+t1.tokenNo+" deposited amount:Rs."+t1.amount);
				 System.out.println(head.data+"  + "+t1.amount);
				 double am=(double)head.data;
				 am=am+t1.amount;  
				 head.data=am;  //adding deposited amount to bank-balance
			}
			else //amount negative means withdrawal
			{
				System.out.println("Token No:"+t1.tokenNo+" withdrawn amount:Rs."+(-1*t1.amount));
				System.out.println(head.data+"  - "+t1.amount);
				double am=(double)head.data;
				am=am+t1.amount;
				head.data=am; //subtracting withdrawal amount from bank-balance
			}
			
			return true;
		}
		
				
		
		Node t=head.next;
		while(t.next!=null)
		{
			t=t.next; //Traversing queue till end
		}
		
		t.next=n; //adding person at end of queue
		Transaction t1=(Transaction)n.data;
	
		if(t1.amount>0)
		{
			System.out.println("Token No:"+t1.tokenNo+" deposited amount:Rs."+t1.amount);
			System.out.println(head.data+"  + "+t1.amount);
			double am=(double)head.data;
			am=am+t1.amount; //adding deposited amount to bank-balance
			head.data=am;
		}
		else
		{
			System.out.println("Token No:"+t1.tokenNo+" withdrawn amount:Rs."+(-1*t1.amount));
			System.out.println(head.data+"  - "+t1.amount);
			double am=(double)head.data;
			am=am+t1.amount; //subtracting withdrawal amount from bank-balance
			head.data=am;
		}
	
		return true;
	}
	
	/*Method to get Outstanding bank balance*/
	double bankBalance()
	{
		return (double)head.data;
	}
	
	/*Method to display people in queue*/
	void display()
	{
		BankingCashCounter b= new BankingCashCounter();
		
		if(head.next==null)
			return;
			//System.out.println("No people in queue\n Outstanding bank balance: "+b.bankBalance());
		else
		{
			Node t=head.next;
			
			while(t!=null)
			{
				Transaction tr=(Transaction)t.data;
				if(t.next!=null)
				System.out.print("[ "+tr.tokenNo+","+tr.amount+"] --->" );
				else
					System.out.print("[ "+tr.tokenNo+","+tr.amount+"]\n");
					
				t=t.next;
			}
			
		}
	}
	
	/*Method to remove people from queue*/
	boolean dequeue()
	{
		if(head.next==null)
		{
			System.out.println("No people in Queue");
			return false;
			
		}
		Node t=head.next;
		
		while(head.next!=null) //More people exist
		{
			Transaction tran=(Transaction)head.next.data;
			
			System.out.println("Dequed: "+tran.tokenNo);
			head.next=t.next; //Removed person from queue
			t=head.next;
		}
			System.out.println("No people in queue");
		
		return true;	
	}
	
	
	public static void main(String[] args) 
	{
		BankingCashCounter b=new BankingCashCounter();
			int token=0;
			
			Scanner scanner=new Scanner(System.in);
			
			while(true)
			{
				System.out.println("More people in queue?");
				System.out.println("\nPress y if yess or n if not");
				char c=scanner.next().charAt(0);
				if(c=='n' || c=='N')  //No people
					break;
				
				System.out.println("\nPress 1 for deposit:\nPress 2 for withdraw");
				char ch1=scanner.next().charAt(0);
				
					if(ch1=='1')
					{
							token++;
							System.out.println("Enter amount: ");
							double amount=scanner.nextDouble();
							Transaction t1= new Transaction(token,amount);
							
							b.add(t1); //Adding new transaction
					}
					
					else if(ch1=='2')
					{
						token++;
						System.out.println("Enter amount: ");
						double amount=scanner.nextDouble();
						Transaction t2= new Transaction(token,-(amount));
						b.add(t2); //Adding new transaction
					}
			}
			
			b.display(); //displaying persons in queue
			b.dequeue(); //removing persons 
			System.out.println("Outstanding Bank balance: "+b.bankBalance()); //Displaying outstanding bank balance
	}

}