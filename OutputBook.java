package edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookinfo")
public class OutputBook extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		list = (ArrayList<BookVO>)req.getAttribute("list");
		out.print("도서 정보 보기<br>");
		out.print("-------------------------<br>");
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				BookVO vo = (BookVO)list.get(i);
				out.print("도서번호 : "+vo.getBookno()+"<br>");
				out.print("도서제목 : "+vo.getTitle()+"<br>");
				out.print("작    가 : "+vo.getAuthor()+"<br>");
				out.print("등 록 일 : "+vo.getPubdate()+"<br>");
				out.print("-------------------------<br>");
			}
		}else{
			out.print("검색 되지 않았습니다.");
		}
	}
}
