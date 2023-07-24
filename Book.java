package Library;



import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Book extends DataHandling{
	private String bookname, author, id;
	public Book() {
		this.bookname = this.author = this.id = "";
	}
	public Book(String bookname, String author, String id)
	{
		this.bookname = bookname;
		this.author = author;
		this.id = id;
	}
	String getBookName() {
		return this.bookname;
	}
	String getAuthor() {
		return this.author;
	}
	String getId() {
		return this.id;
	}
	public Book getBookDetails() {
		return null;
	}
	
	public static void viewBookList() { //Same like searchbooks() but all book objects are added to ArrayList instead of searching for a key and adding
		ArrayList<Book> foundbooks = new ArrayList<>();
		DataHandling dh = new DataHandling();
		try {
			File f = new File("BookList.txt");
			if(f.createNewFile());
			Scanner iobj = new Scanner(f);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = dh.splitData(data);
				Book b = new Book(info[1],info[2],info[0]);
				foundbooks.add(b);
			}
			iobj.close();
			dh.printFoundBooks(foundbooks);
		}catch(Exception e) {
			System.out.println("Exception..."+e);
		}
	}
	public static ArrayList<Book> searchBook(String key) {
		ArrayList<Book> foundbooks = new ArrayList<>();
		DataHandling dh = new DataHandling();
		try {
			File f = new File("BookList.txt");
			if(f.createNewFile());
			Scanner iobj = new Scanner(f);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = dh.splitData(data);
				if(key.equalsIgnoreCase(info[0]) || key.equalsIgnoreCase(info[1]) || key.equalsIgnoreCase(info[2]))
				{
					Book b = new Book(info[1],info[2],info[0]);
					foundbooks.add(b);
				}
			}
			iobj.close();
			return foundbooks;
		}catch(Exception e) {
			System.out.println("Exception..."+e);
			return foundbooks;
		}
		
		
	}
	public static void addBook() {
		Scanner in = new Scanner(System.in);
		String bname, aname, bid;
		System.out.println("-----Add a Book-----");
		System.out.println("\nEnter Book ID");
		bid = in.nextLine();
		System.out.println("\nEnter Book Name");
		bname = in.nextLine();
		System.out.println("\nEnter Author Name");
		aname = in.nextLine();
		Book b = new Book(bname, aname, bid);
		b.updateBookList(1);
		in.close();
	}
	public static void delBook() {
		String bid;
		Scanner in = new Scanner(System.in);
		System.out.println("-----Delete a Book-----");
		System.out.println("\nEnter Book ID");
		bid = in.nextLine();
		ArrayList<Book> foundbooks = searchBook(bid);
		//Take only first object because each book has a unique BID
		foundbooks.get(0).updateBookList(2);
		in.close();
	}
	public void updateBookList(int flag) {
		if(flag == 1)
		{
			try {
            // Create a FileWriter object with append=true
            FileWriter fileWriter = new FileWriter("BookList.txt", true);
            // Create a BufferedWriter object to write to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Write some data to the file
            bufferedWriter.write("\n"+id+"/"+bookname+"/"+author+"/");
            bufferedWriter.close();
            fileWriter.close();
         
        } catch (Exception e) {
        	System.out.println("Exception...");
            e.printStackTrace();
        }
		}
		else if(flag == 2)
		{
			try {
				File f = new File("BookList.txt");
				File f1 = new File("Temp.txt");
				if(f1.createNewFile());
				Scanner iobj = new Scanner(f);
				FileWriter fw = new FileWriter("Temp.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				while(iobj.hasNextLine())
				{
					String data = iobj.nextLine();
					String[] info = splitData(data);
					System.out.println(id);
					if(id.equals(info[0]))
					{
						//skip that line
						System.out.println("Found 'em");
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
				File f2 = new File("BookList.txt");
				if(f1.renameTo(f2)) {
					
				}
				else {
					System.out.println("Couldnt rename");
				}
				
			}catch(Exception e) {
				System.out.println("ExceptionAB..."+e);
			}
		}
		
	}
}
