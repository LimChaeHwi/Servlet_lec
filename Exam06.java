package edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exam06 extends HttpServlet{
	String id ;
	String pwd;
	@Override
	public void init(ServletConfig sc) throws ServletException {
		// TODO Auto-generated method stub
		id=sc.getInitParameter("id");
		pwd=sc.getInitParameter("pwd");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		out.print("<h1>Result</h1>");
		out.println(id);
		out.println(pwd);
		out.close();
	}
}
