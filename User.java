package Library;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class User extends DataHandling{
	private String uname, password;
	private String libid1, s1, libid2, s2;
	private String phno;
	private int fine;
	Scanner sc = new Scanner(System.in);
	public User() {
		
	}
	public User(String uname, String password, String phno, String libid1, String s1, String libid2, String s2, int fine)
	{
		this.uname = uname;
		this.password = password;
		this.phno = phno;
		this.libid1 = libid1;
		this.s1 = s1;
		this.libid2 = libid2;
		this.s2 = s2;
		this.fine = fine;
	}
	public void user() {
		System.out.println("\n\nHi "+uname);
		System.out.println("What would you like to do today?");
		System.out.println("Enter:\n1. To Pay Due Fine\n2. To Search a Book\n3. To View Profile\n0. To Log out\nPress any key to exit app\n");
		char ch = sc.next().charAt(0);
		LibraryManagement temp = new LibraryManagement();
		switch(ch) {
		case '1': 
            payFine(); //done
            user();
            break;
        case '2':
        	ArrayList<Book> foundbooks = getDetailsofBook();
			printFoundBooks(foundbooks); //done
            user();
            break;
        case '3':
            viewProfile(); //done
            user();
            break;
        case '0':
            temp.homepage(); //done
            break;
        default:
            temp.close(); //done
		}
	}
	public void issueBook() {
		System.out.println("Student Found!");
		System.out.println("\n-------User Profile-------\n");
		System.out.println("Name:"+uname+"\n"+"Phone Number:"+phno+"\nLibrary Card 1:"+libid1+"\tStatus:"+(s1.equals("0")?"Active":"In use")+"\nLibrary Card 2:"+libid2+"\tStatus:"+(s2.equals("0")?"Active":"In use"));
		System.out.println("Due Fine: Rs."+fine);
		System.out.println();
		if(s1.equals("0") || s2.equals("0"))
		{
			System.out.println("Enter Book ID to borrow");
			String bid = sc.next();
			ArrayList<Book> foundbooks = Book.searchBook(bid);
			if(foundbooks.size() == 0 )
			{
				System.out.println("Entered Book ID does not Exist! Please retry!!");
				LibraryManagement l1 = new LibraryManagement();
				l1.admin();
			}
			else
			{
				System.out.println("\nBook Issued Successfully!");
				System.out.println("-----Issue Details-----");
				printFoundBooks(foundbooks);
				System.out.println("Issued to:");
				System.out.println("Student Name: "+uname);
				if(s1.equals("0"))
				{
					System.out.println("Library Card: "+libid1);
					s1 = bid;
					updateUserProfile('i',getFormattedDate(),libid1,bid);
				}
				else
				{
					System.out.println("Library Card: "+libid1);
					s1 = bid;
					updateUserProfile('i',getFormattedDate(),libid2,bid);
				}
				updateUserDetails();
				
			}
		}
		else
		{
			System.out.println("\n-----Cannot Issue Books! Both Library Cards are in Use!!-----\n\n");
		}
	}
	public void returnBook() {
		System.out.println("Student Found!");
		System.out.println("\n-------User Profile-------\n");
		System.out.println("Name:"+uname+"\n"+"Phone Number:"+phno+"\nLibrary Card 1:"+libid1+"\tStatus:"+(s1.equals("0")?"Active":"In use")+"\nLibrary Card 2:"+libid2+"\tStatus:"+(s2.equals("0")?"Active":"In use"));
		System.out.println("Due Fine: Rs."+fine);
		System.out.println();
		if(s1.equals("0") && s2.equals("0"))
		{
			System.out.println("\n-----No Books Borrowed to return!!-----\n\n");
		}
		else
		{
			String bid, lid = "";
			if(!s1.equals("0") && !s2.equals("0"))
			{
				System.out.println("\nMultiple Books Borrowed!!");
				System.out.println(s1 + " issued to " + libid1);
				System.out.println(s2 + " issued to " + libid2);
				System.out.println("Enter Book ID to return");
				bid = sc.next();
				if(!bid.equals(s1) && !bid.equals(s2))
				{
					System.out.println("Book ID doesnt match!Please retry!");
					returnBook();
					return;
				}
				else
				{
					if(bid.equals(s1))
					{
						s1 = "0";lid = libid1;
					}
						
					else {lid = libid2;  s2 = "0";}
						
				}
			}
			else
			{
				if(s1.equals("0"))
				{
					bid=s2;
					lid = libid2;
					s2 = "0";
				}
					
				else
				{
					bid = s1;
					lid = libid1;
					s1 = "0";
				}
					
			}
			ArrayList<Book> foundbooks = Book.searchBook(bid);
			System.out.println("\nBook Returned Successfully!");
			System.out.println("-----Return Details-----");
			printFoundBooks(foundbooks);
			System.out.println("Returned From:");
			System.out.println("Student Name: "+uname);
			System.out.println("Library Card: "+ lid);
			System.out.println("\nEnter Fine amount");
			int tfine = sc.nextInt();
			fine+=tfine;
			updateUserDetails();
			updateUserProfile('r',getFormattedDate(),lid, bid);
		}
	}
	public void payFine() {
		System.out.println("-------Pay Due Fines-------\n");
		if(fine==0)
		{
			System.out.println("----You have no more pending fines----");
			user();
		}
		else
		{
			System.out.println("Due Fine: Rs."+fine);
			System.out.println("\nEnter\n 1 to confirm payment\n 0 to Go Back");
			char ch = sc.next().charAt(0);
			if(ch == '1')
			{
				System.out.println("Payment Succesful! No more pending fines\n");
				updateUserProfile('f',getFormattedDate(), String.valueOf(fine), "");
				fine = 0;
				updateUserDetails();
			}
				user();
		}
	}
	public void writeToFile() {
		try {
            // Create a FileWriter object with append=true
            FileWriter fileWriter = new FileWriter("UserDetails.txt", true);
            FileWriter fileWriter2 = new FileWriter("UserLogin.txt", true);
            // Create a BufferedWriter object to write to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            // Write some data to the file
            bufferedWriter.write("\n"+uname+"/"+password+"/"+phno+"/"+libid1+"/"+s1+"/"+libid2+"/"+s2+"/"+fine+"/");
            bufferedWriter2.write("\n"+uname+"/"+password+"/");
            
            //Create a seperate file for each user
            // Create a File object
            File file = new File(uname + ".txt");

            // Create a new file
            if (file.createNewFile());
            updateUserProfile('a',getFormattedDate(),"","");
            // Close the output stream
            bufferedWriter.close();
            bufferedWriter2.close();
            
            fileWriter.close();
            fileWriter2.close();
           
            
        } catch (Exception e) {
        	System.out.println("Exception...");
            e.printStackTrace();
        }
	}
	
	public void updateUserDetails() {
		try {
			File f = new File("UserDetails.txt");
			File f1 = new File("Temp.txt");
			if(f1.createNewFile());
			Scanner iobj = new Scanner(f);
			FileWriter fw = new FileWriter("Temp.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = splitData(data);
				if(uname.equals(info[0]) && password.equals(info[1]))
				{
					data = uname+"/"+password+"/"+phno+"/"+libid1+"/"+s1+"/"+libid2+"/"+s2+"/"+fine+"/";
					bw.write(data+"\n");
				}
				else
				{
					bw.write(data+"\n");
				}
			}
			iobj.close();
			bw.close();
			fw.close();
			if(f.delete()) {
				
			}
			else {
				System.out.println("Couldnt Delete");
			}
			File f2 = new File("UserDetails.txt");
			if(f1.renameTo(f2)) {
				
			}
			else {
				System.out.println("Couldnt rename");
			}
			
		}catch(Exception e) {
			System.out.println("ExceptionAB..."+e);
		}
	}
	public void updateUserProfile(char ch, String date, String s1, String s2) {
		try {
			FileWriter fw = new FileWriter(uname+".txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			switch(ch) {
			case 'a': 
				bw.write("a/"+date+"/"+"\n");
				break;
			case 'f':
				bw.write("f/"+s1+"/"+date+"/"+"\n");
				break;
			case 'i':
				bw.write("i/"+s1+"/"+s2+"/"+date+"/"+"\n");
				break;
			case 'r':
				bw.write("r/"+s1+"/"+s2+"/"+date+"/"+"\n");
				break;
			}
			bw.close();
			fw.close();
		}catch(Exception e) {
			System.out.println("Exception..."+e);
		}
	}
	public void viewProfile() {
		System.out.println("\n-------User Profile-------\n");
		System.out.println("Name:"+uname+"\n"+"Phone Number:"+phno+"\nLibrary Card 1:"+libid1+"\tStatus:"+(s1.equals("0")?"Active":"In use")+"\nLibrary Card 2:"+libid2+"\tStatus:"+(s2.equals("0")?"Active":"In use"));
		System.out.println("Due Fine: Rs."+fine);
		System.out.println();
		System.out.println("-------User History-------\n");
		System.out.printf("%-10s%-50s%-20s\n", "Sl. No","Action Performed","Date");
		try {
			File f = new File(uname+".txt");
			Scanner iobj = new Scanner(f);
			int i = 1;
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = splitData(data);
				if(info[0].equals("a"))
				{
					System.out.printf("%-10s%-50s%-20s\n", i++,"Account Created Succesfully!",info[1]);
				}
				else if(info[0].equals("f"))
				{
					System.out.printf("%-10s%-50s%-20s\n", i++,"Fine Paid of Rs."+info[1],info[2]);
				}
				else if(info[0].equals("i"))
				{
					System.out.printf("%-10s%-50s%-20s\n", i++,"Book Issue - "+info[2] +" to "+info[1],info[3]);

				}
				else
				{
					System.out.printf("%-10s%-50s%-20s\n", i++,"Book Returned - "+info[2] + " from "+info[1],info[3]);
				}
				
			}
			iobj.close();
		}catch(Exception e) {
			System.out.println("Exception...");
		}
	}
	public String getuname() {
		return this.uname;
	}
	public String getpw() {
		return this.password;
	}
	public int getFine() {
		return this.fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	 String getFormattedDate()
	{
		LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
	}
	 
	
}