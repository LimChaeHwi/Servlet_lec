package edu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//두가지 접속 경로를 만듦
@WebServlet({"/insertbook","/searchbook"})
public class BookServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post방식에서는 request,response 둘다 인코딩이 필요하다.
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//바로 html로 화면을 띄워주고자 한다면 PrintWriter를 사용.
	//	PrintWriter out = resp.getWriter();
		//HttpServletRequest로 전송되어온 파라미터 값을 가져온다.
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		//BookVO객체 형태로 생성해서 값을 넘겨준다.
		BookVO vo = new BookVO(0,title,author,null);
		//BookBiz라는 분기점을 지정해주고 그 객체 내의 메소드를 선언해서 활용.
		new BookBiz().joinBook(vo);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=utf-8");
		// title 추출
		String title = req.getParameter("title");
		//BookBiz에서 searchBook메서드 호출
		ArrayList<BookVO> list = new ArrayList<BookVO>(new BookBiz().searchBook(title));
		//HttpServletRequest객체에 list라는 이름으로 list값을 저장.
		req.setAttribute("list", list);
		// BookBiz의 회원 검색 매서드 호출
		req.getRequestDispatcher("/bookinfo").forward(req, resp);
	}
	
}
