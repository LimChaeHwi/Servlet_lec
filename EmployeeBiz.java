package edu;

import java.util.ArrayList;

public class EmployeeBiz {

	public ArrayList<EmployeeVO> searchEmployee(int empno){
		ArrayList<EmployeeVO> list = new EmployeeDAO().searchEmployee(empno);
		return list;
	}
	
}
