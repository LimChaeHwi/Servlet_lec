package edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exam07 extends HttpServlet{
	String charset;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//설정되는 값을 사용할 때
		charset = config.getInitParameter("charset");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		charset = this.getInitParameter("charset");
		req.setCharacterEncoding(charset);
		resp.setContentType("text/html;charset="+charset);
		
		PrintWriter out = resp.getWriter();
		out.print("<h1>Exam07</h1>");
		out.print(charset);
		out.print("<h1>"+req.getParameter("name")+"</h1>");
		out.close();
	}
	
}
