package com.deloitte.library.model;

public class Books {
	private int bookId;
	private String bookName;
	private float bookPrice;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int i) {
		this.bookId = i;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}

}
