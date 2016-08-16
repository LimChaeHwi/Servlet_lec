package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

	
	public ArrayList<EmployeeVO> searchEmployee(int empno){
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		ResultSet rs = null;
		
		try{
			con = new EmployeeDAO().getConnection();
			pstmt = con.prepareStatement("select * from emp where empno =?");
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			if(rs==null){
				return null;
			}
			while(rs.next()){
				list.add(new EmployeeVO(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getDate(5),rs.getDouble(6),rs.getDouble(7),
						rs.getInt(8)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){e.getMessage();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.getMessage();}}
			if(con!=null){try{con.close();}catch(Exception e){e.getMessage();}}
		}
		return list;		
		
		
	}
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
		return con;
	}
}
