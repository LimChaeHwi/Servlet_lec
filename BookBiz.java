package edu;

import java.util.ArrayList;

public class BookBiz {
	BookDAO dao = new BookDAO();
	public void joinBook(BookVO vo){
		dao.insertBook(vo);
	}
	public ArrayList searchBook(String title){
		ArrayList list = new ArrayList();
		list = dao.searchBook(title);
		return list;
	}
}
