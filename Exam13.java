package edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 *  서버를 on/off해도 방문 횟수가 유지 될 수 있도록 만들어 보세요.
 */
@WebServlet("/visitCount")
public class Exam13 extends HttpServlet{
	
	int count;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		Cookie[] c2 = req.getCookies();
		for (int i = 0; c2!=null && i < c2.length; i++) {
			if(c2[i].getName().equals("visitcount")){
				count = Integer.parseInt(c2[i].getValue());
				System.out.println(count);
			}
		}
		System.out.println(count+"1");
		count++;
		Cookie c1 = new Cookie("visitcount",count+"");
		resp.addCookie(c1);
		out.println(c1.getName()+" : "+c1.getValue());
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		count++;
		Cookie c1 = new Cookie("visitcount",count+"");
		c1.setMaxAge(60*60*24*10);//10일
		resp.addCookie(c1);
		out.print(c1.getName()+" : "+c1.getValue());
		
	}
}
