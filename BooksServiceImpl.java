package com.deloitte.library.services;

import java.util.*;

import com.deloitte.library.model.Books;
import com.library.dao.BooksDAO;

public class BooksServiceImpl implements BooksInterfaceServices {

	@Override
	public void createBooks(String name1, float price) {
		// TODO Auto-generated method stub
		Books obj = new Books();
		obj.setBookName(name1);
		obj.setBookPrice(price);
		BooksDAO.addBook(obj);
	}

	@Override
	public List<Books> displayBooks() {
		// TODO Auto-generated method stub
		return BooksDAO.displayBooks();
	}

	@Override
	public List<Books> searchBooks(String name1) {
		// TODO Auto-generated method stub
		return BooksDAO.searchBooks(name1);
	}

	@Override
	public boolean deleteBooks(int id) {
		// TODO Auto-generated method stub
		return BooksDAO.deleteBooks(id);
	}

}
