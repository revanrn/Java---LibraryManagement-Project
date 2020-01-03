package com.deloitte.library.services;

import java.util.*;

import com.deloitte.library.model.Books;

public interface BooksInterfaceServices {
	public void createBooks(String name1, float price);

	public List<Books> displayBooks();

	public List<Books> searchBooks(String name1);

	public boolean deleteBooks(int id);
}
