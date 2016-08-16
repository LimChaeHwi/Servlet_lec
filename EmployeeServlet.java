package edu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchEmpno")
public class EmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empno = Integer.parseInt(req.getParameter("empno"));
		ArrayList<EmployeeVO> list = new EmployeeBiz().searchEmployee(empno);
		req.setAttribute("list", list);
		req.getRequestDispatcher("empno").forward(req, resp);
	}
	
}
