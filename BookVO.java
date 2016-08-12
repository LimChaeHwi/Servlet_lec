package edu;

import java.sql.Timestamp;

public class BookVO {
	private int bookno;
	private String title;
	private String author;
	private Timestamp pubdate;

	public BookVO(int bookno, String title, String author, Timestamp pubdate) {
		super();
		this.bookno = bookno;
		this.title = title;
		this.author = author;
		this.pubdate = pubdate;
	}

	public int getBookno() {
		return bookno;
	}

	public void setBookno(int bookno) {
		this.bookno = bookno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getPubdate() {
		return pubdate;
	}

	public void setPubdate(Timestamp pubdate) {
		this.pubdate = pubdate;
	}
}
