package edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/goWeb")
public class Exam12 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		String site = req.getParameter("site");
		Cookie c1 = new Cookie("item",site);
		c1.setMaxAge(60*60*24*10); //10일
		resp.addCookie(c1);	//쿠키 전송
		
		//화면 출력
		out.println("<a href=http://localhost:9090/edu/goWeb>이동</a>");
		
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] list = req.getCookies();
		for (int i = 0;list!=null && i < list.length; i++) {
			if(list[i].getName().equals("item")){
				String v = list[i].getValue();
				if(v.equals("naver")){
					//sendRedirect 는 같은 컨텍스트에 없고 완전히 다른 사이트로 이동할때
					resp.sendRedirect("http://www.naver.com");
				}else if(v.equals("daum")){
					resp.sendRedirect("http://www.daum.net");
				}else if(v.equals("google")){
					resp.sendRedirect("http://www.google.com");
				}else if(v.equals("nate")){
					resp.sendRedirect("http://www.nate.com");
				}
			}
		}
	}
}
