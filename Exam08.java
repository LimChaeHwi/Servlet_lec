package edu;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/exam08")
public class Exam08 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//ServletContext ����
		ServletContext sc = this.getServletContext();
		System.out.println(sc);
		System.out.println(sc.getContextPath());
		System.out.println(sc.getMajorVersion());
		System.out.println(sc.getMinorVersion());
		System.out.println(sc.getServerInfo());
		//ServletContext�� data ����
		//web application ���������� ��� ����
		sc.setAttribute("msg", "�׽�Ʈ�Դϴ�.");
		//msg�Ӽ��� �ٸ� �������� ��� ����
		System.out.println(sc.getAttribute("msg"));
	}
}
