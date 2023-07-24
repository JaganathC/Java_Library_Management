package Library;


import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

import java.util.ArrayList;
public class LibraryManagement extends DataHandling {
	final String adminun = "admin";
	final String adminpw = "lib@ad123";
	Scanner sc = new Scanner(System.in);
	public void homepage() {
		System.out.println("\n=============Welcome to ABCS Library============= ");
		do
	    {
	        System.out.println("\nEnter:\n1.Admin Login\n2.Register New User\n3.Member Login\n0.Exit!\n");
	        char ch = sc.next().charAt(0);
	        switch(ch)
	        {
	            case '1':
	                //adminLogin();
	                break;
	            case '2':
	                newUser();
	                break;
	            case '3':
	                //userLogin();
	                break;
	            case '0':
	                close();
	                break;
	            default: continue;
	        }
	    } while (true);
	}
	public boolean adminLogin(String un, String pw) {
		if(un.equals(adminun) && pw.equals(adminpw))
		{
			System.out.println("Admin Login Succesfull!!\nRedirecting to Admin Homepage\n");
			return true;
		}
		else {
			System.out.println("Admin Credentials do not match\n");
			System.out.println("Enter:\n0. To go back to homepage\nPress any character to try again");
//			char temp = sc.next().charAt(0);
//			switch(temp)
//			{
//			case '0': 
//				homepage();
//				break;
//			
//			}
			return false;
		}
	}
	public void admin() {
		System.out.println("=======Welcome Admin!=======\n");
		System.out.println("\nEnter:\n1.Issue a book to student\n2.Return a book for student\n3.To View Book List\n4.To Add Book to collection\n5.To remove Book from collection\n6.To Search Book\n7.To View User Details\n0.Log Out\nPress Any Key to Exit App\n");
		//Book b1 = new Book();
		User u;
		char ch = sc.next().charAt(0);
		switch(ch) {
		case '1':
			System.out.println("\n-------Book Issue Portal-------\n");
			u = acceptNgetObj();
			if(u == null)
				admin();
			u.issueBook(); //done
			admin();
			break;
		case '2':
			System.out.println("\n-------Book Return Portal-------\n");
			u = acceptNgetObj();
			if(u == null)
				admin();
			u.returnBook(); //done
			admin();
			break;
		case '3':
			Book.viewBookList(); //done
			admin();
			break;
		case '4':
			Book.addBook();//done
			admin();
			break;
		case '5':
			Book.delBook(); //done
			admin();
			break;
		case '6':
			ArrayList<Book> foundbooks = getDetailsofBook(); //ArrayList where each item is a Book Object whose search is matched
			printFoundBooks(foundbooks); // Split the ArrayList properly and print in format
			admin(); //done
			break;
		case '7':
			viewUsers(); //done
			admin();
			break;
		case '0':
			homepage(); //done
			break;
		default: 
			close(); //done
		}
	}
	public void newUser()  {
		Random r = new Random();
		System.out.println("\n-----Registration Details!-----\n");
		String name, pw, id1, id2, no;
		System.out.println("Enter Name\n");
		sc.nextLine();
		name = sc.nextLine();
		do {
			System.out.println("Enter Valid Contact No");
			no = sc.next();
		}while(no.length()!=10);
		System.out.println("Set a Password");
		sc.nextLine();
		pw = sc.nextLine();
		id1 = "LIB00" + String.valueOf(r.nextInt(90) + 10) + String.valueOf(r.nextInt(90) + 10) + String.valueOf((char)(r.nextInt(26) + 65));
		id2 = "LIB01" + String.valueOf(r.nextInt(90) + 10) + String.valueOf(r.nextInt(90) + 10) + String.valueOf((char)(r.nextInt(26) + 65));
		User u = new User(name,pw,no,id1,"0",id2,"0",0);
		u.writeToFile();
		System.out.println("User Registration Succesfull!");
		System.out.println(name + " " + pw + " " + no);
		System.out.println(id1 + "\n" + id2);
		System.out.println("Redirecting back to home page");
		homepage();
	}
	public void userLogin(String un,String pw) {
		//System.out.println("\n----------User Login Page----------\n");
		
		int flag = 0;
		System.out.println("Enter Username\n");
		sc.nextLine();
		un = sc.nextLine();
		System.out.println("Enter Password");
		pw = sc.nextLine();
		System.out.println(un+"}"+"\n"+pw+"}");
		try {
			File obj = new File("UserLogin.txt");
			if(obj.createNewFile());
			Scanner iobj = new Scanner(obj);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				for(int i = 0; i<data.length(); i++)
				{
					if(data.charAt(i) == '/')
					{
						//System.out.println(data.substring(0, i)+"}" + "\n" + data.substring(i+1, data.length()-1)+"}");
						if(un.equals(data.substring(0, i)) && pw.equals(data.substring(i+1, data.length()-1)))
							flag = 1;
						break;
					}
				}
				if(flag == 1)
					break;
			}
			iobj.close();
			if(flag == 0)
			{
				System.out.println("Entered User Credentails does not exist in database!\nPlease Retry or Register as a new User!");
				System.out.println("Redirecting to Homepage\n");
				homepage();
			}
			else
			{
				System.out.println("\n-----User Login Succesfull!!-----\n");
				System.out.println("Welcome "+un);
				User u = getUserObject(un, pw);
				//System.out.println(u.fine);
				u.user();
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception...");
		}
	}
	void viewUsers() {
		try {
			File f = new File("UserDetails.txt");
			if(f.createNewFile());
			Scanner iobj = new Scanner(f);
			System.out.printf("%-10s%-30s%-20s%-20s%-15s%-20s%-15s%-15s\n","Sl no.","Username","Contact No.","LibCard 1","Card1-Status","LibCard 2","Card2-Status","Due Fines");
			int i = 1;
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = splitData(data);
				if(info[0] == null)
					continue;
				System.out.printf("%-10s%-30s%-20s%-20s%-15s%-20s%-15s%-15s\n",i++,info[0],info[2],info[3],info[4],info[5],info[6],info[7]);
			}
			iobj.close();
		}catch(Exception e) {
			System.out.println("Exception..."+e);
		}
		
		
	}
	User acceptNgetObj() {
		String un, pw;
		System.out.println("Enter Student Username\n");
		sc.nextLine();
		un = sc.nextLine();
		System.out.println("Enter Student Password");
		pw = sc.nextLine();
		User u = getUserObject(un, pw);
		if(u.getuname() == null)
		{
			System.out.println("Entered Student credentials do not match with our database! Please retry!\n");
			return null;
		}
		else
		{
			return u;
		}
	}
	User getUserObject(String un, String pw)
	{
		String[] details = new String[8];
		try {
			File obj = new File("UserDetails.txt");
			if(obj.createNewFile());
			Scanner iobj = new Scanner(obj);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				int curr = 0;
				int prev = 0;
				for(int i = 0; i<data.length(); i++)
				{
					if(data.charAt(i) == '/')
					{
						//System.out.println(data.substring(0, i)+"}" + "\n" + data.substring(i+1, data.length()-1)+"}");
						details[curr++] = data.substring(prev, i);
						prev = i+1;
						
					}
				}
				if(un.equals(details[0]) && pw.equals(details[1]))
					break;
				else
				{
					details = new String[8];
					details[7] = "0";
				}
			}
			iobj.close();
			User u = new User(details[0],details[1],details[2],details[3],details[4],details[5],details[6],(int)Integer.valueOf(details[7]));
			return u;
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Exception123...");
			return null;
		}
	}
	public void close() {
		System.out.println("\n-------See You Soon! Happy Reading!------\n");
		System.exit(0);
	}
	
}
