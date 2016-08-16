package edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empno")
public class EmployeeOutput extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		ArrayList<EmployeeVO> list = (ArrayList<EmployeeVO>)req.getAttribute("list");
		PrintWriter out = resp.getWriter();
		out.println("empno"+"\t"+"ename"+"\t"+"job"+"\t"+"mgr"+"\t"+
		"hiredate"+"\t"+"sal"+"\t"+"comm"+"\t"+"deptno"+"<br>");
		out.println("========================================="+"<br>");
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				EmployeeVO vo = list.get(i);
				out.println(vo.getEmpno()+"\t"+vo.getEname()+"\t"+vo.getJob()+"\t"+vo.getMgr()
				+"\t"+vo.getHiredate()+"\t"+vo.getSal()+"\t"+vo.getComm()+"\t"+vo.getDeptno()+"<br>");
			}
		}
		else{
			out.println("검색된 값이 없습니다.");
		}
		out.close();
		
	}
	
}
