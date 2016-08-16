package edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie02")
public class Exam11 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���� ���� ��Ű�� �о�鿩��, �� �� ����.
		Cookie[] list = req.getCookies();
		
		for (int i = 0; list!=null && i < list.length; i++) {
			System.out.println(list[i].getName()+" : "+list[i].getValue());
		}
	}
}
