package edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/exam05")
public class Exam05 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("Exam05 실행<br>");
		
		System.out.println("Exam05 실행");
		//HttpServletRequest에 저장된 데이터  추출
		String s = (String)req.getAttribute("msg");
		out.print("추출 데이타: "+s+"<br>");
		MemberVO t = (MemberVO)req.getAttribute("member");
		out.print("추출 데이타: "+t.getId()+" "+t.getPwd()+" "+t.getName()+" "+t.getAge()+" "+t.getAddress());
		out.close();
	}
	
}
