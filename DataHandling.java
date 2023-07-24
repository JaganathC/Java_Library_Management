package Library;


import java.util.Scanner;
import java.util.ArrayList;
public class DataHandling {
	Scanner sc = new Scanner(System.in);
	String[] splitData(String data)
	 {
		 String[] info = new String[8];
		 int curr = 0;
			int prev = 0;
			for(int i = 0; i<data.length(); i++)
			{
				if(data.charAt(i) == '/')
				{
					info[curr++] = data.substring(prev, i);
					prev = i+1;
				}
			}
			return info;
	 }
	ArrayList<Book> getDetailsofBook() {
		String str;
		System.out.println("Enter the Book Name/ Author Name/ Book ID of the books you are looking for");
		str = sc.nextLine();
		ArrayList<Book> foundbooks = new ArrayList<Book>();
		foundbooks = Book.searchBook(str);
		return foundbooks;
	}
	void printFoundBooks(ArrayList<Book> foundbooks) {
		System.out.println("-----Found Books-----");
		if(foundbooks.size() == 0)
		{
			System.out.println("No Books Found which match your search\n\n");
			return;
		}
		else
		{
			System.out.printf("%-40s%-30s%-20s\n","Book Name", "Author Name", "Book ID");
			for(Book b: foundbooks)
			{
				System.out.printf("%-40s%-30s%-20s\n",b.getBookName(),b.getAuthor(),b.getId());
			}
			System.out.println("-----------------\n\n");
		}
	}
}