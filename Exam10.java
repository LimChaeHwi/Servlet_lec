package edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Exam10 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ��Ű ����
		Cookie c1 = new Cookie("id","guest");
		// ��Ű ����
		resp.addCookie(c1);
	//	System.out.println(c1.getPath());
		Cookie c2 = new Cookie("code","0001");
		// ��Ű ��ȿ�ð� ���� , 0 - ��Ű ����,
		//�ð� �������� ������ ������ ����� �ٷ� ����
		c2.setMaxAge(60*60*3); //3�ð� ����
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("subject","java");
		c3.setMaxAge(60*60*24*10); //10�� ����
		resp.addCookie(c3);
		
		System.out.println("��Ű ���� �Ϸ�");
	}
	
}
