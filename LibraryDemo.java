package com.deloitte.library.main;

import java.util.*;

import com.deloitte.library.model.Books;
import com.deloitte.library.services.BooksServiceImpl;

public class LibraryDemo {
	public static void main(String atgs[]) {
		Scanner sc = new Scanner(System.in);
		List<Books> list = new ArrayList<Books>();
		while (true) {
			System.out.println("1.Add New Book.");
			System.out.println("2.Display Book Details.");
			System.out.println("3.Search Book by Bookname.");
			System.out.println("4.Delete Book by Bookid.");
			System.out.println("5.Exit.");
			System.out.println("Please Enter your choice : ");
			String choice = sc.next();
			BooksServiceImpl objmpl = new BooksServiceImpl();
			switch (Integer.parseInt(choice)) {
			case 1:
				System.out.println("Enter Book Name: ");
				String name = sc.next();
				System.out.println("Enter the Price of the Book : ");
				Float price = Float.parseFloat(sc.next());
				objmpl.createBooks(name, price);
				break;

			case 2:
				list = objmpl.displayBooks();
				for (Books obj : list) {
					System.out.println(obj);
				}
				break;

			case 3:
				System.out.println("Please enter the name of the book : ");
				String name1 = sc.next();
				list = objmpl.searchBooks(name1);
				System.out.println(list);
				break;

			case 4:
				System.out.println("Please enter the ID of the book : ");
				int id = sc.nextInt();
				boolean flag = objmpl.deleteBooks(id);
				if (flag) {
					System.out.println("One Book Deleted");
				} else
					System.out.println("No Books Found!!");

				break;

			case 5:
				sc.close();
				System.exit(0);
				break;
			}

		}
	}
}
