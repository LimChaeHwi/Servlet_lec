package edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Exam10 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 쿠키 생성
		Cookie c1 = new Cookie("id","guest");
		// 쿠키 전송
		resp.addCookie(c1);
	//	System.out.println(c1.getPath());
		Cookie c2 = new Cookie("code","0001");
		// 쿠키 유효시간 지정 , 0 - 쿠키 삭제,
		//시간 지정하지 않으면 브라우저 종료시 바로 삭제
		c2.setMaxAge(60*60*3); //3시간 설정
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("subject","java");
		c3.setMaxAge(60*60*24*10); //10일 설정
		resp.addCookie(c3);
		
		System.out.println("쿠키 전송 완료");
	}
	
}
