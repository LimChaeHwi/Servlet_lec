package edu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�ΰ��� ���� ��θ� ����
@WebServlet({"/insertbook","/searchbook"})
public class BookServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post��Ŀ����� request,response �Ѵ� ���ڵ��� �ʿ��ϴ�.
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//�ٷ� html�� ȭ���� ����ְ��� �Ѵٸ� PrintWriter�� ���.
	//	PrintWriter out = resp.getWriter();
		//HttpServletRequest�� ���۵Ǿ�� �Ķ���� ���� �����´�.
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		//BookVO��ü ���·� �����ؼ� ���� �Ѱ��ش�.
		BookVO vo = new BookVO(0,title,author,null);
		//BookBiz��� �б����� �������ְ� �� ��ü ���� �޼ҵ带 �����ؼ� Ȱ��.
		new BookBiz().joinBook(vo);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=utf-8");
		// title ����
		String title = req.getParameter("title");
		//BookBiz���� searchBook�޼��� ȣ��
		ArrayList<BookVO> list = new ArrayList<BookVO>(new BookBiz().searchBook(title));
		//HttpServletRequest��ü�� list��� �̸����� list���� ����.
		req.setAttribute("list", list);
		// BookBiz�� ȸ�� �˻� �ż��� ȣ��
		req.getRequestDispatcher("/bookinfo").forward(req, resp);
	}
	
}
