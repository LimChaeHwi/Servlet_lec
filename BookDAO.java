package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import edu.MemberDAO;

public class BookDAO {
	
	
	public void insertBook(BookVO vo){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			BookDAO dao = new BookDAO();
			con = dao.getConnection();
			//시퀀스 사용해서 bookno 입력 create sequence book_ seq increment by 1 start with 100;
			pstmt = con.prepareStatement("insert into book values(book_seq.nextval,?,?,?)");
			// ?에 순서대로 값을 대입.
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			
			pstmt.executeUpdate();
			// DB에 입력이 완료 되었는지 확인.
			System.out.println("도서 등록 완료");
			System.out.println("도서 등록 정보");
			System.out.println("bookno : "+vo.getBookno());
			System.out.println("title : "+vo.getTitle());
			System.out.println("author : "+vo.getAuthor());
			System.out.println("pubdate : "+vo.getPubdate());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null) try{pstmt.close();}catch(Exception e){e.getMessage();}
			if(con!=null) try{con.close();}catch(Exception e){e.getMessage();}
		}
	}
	public ArrayList<BookVO> searchBook(String title){
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		ResultSet rs = null;
		
		try{
			BookDAO dao = new BookDAO();
			con = dao.getConnection();
			pstmt = con.prepareStatement("select bookno, title, author, pubdate from book where title=?");
			
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			System.out.println("도서 목록 보기");
			System.out.println("도서 정보");
			
			if(rs==null){
				return null;
			}
			while(rs.next()){
				list.add(new BookVO(rs.getInt("bookno"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getTimestamp("pubdate")));
				System.out.println("bookno : "+rs.getInt(1));
				System.out.println("title : "+rs.getString(2));
				System.out.println("author : "+rs.getString(3));
				System.out.println("pubdate : "+rs.getTimestamp(4));
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null) try{pstmt.close();}catch(Exception e){e.getMessage();}
			if(con!=null) try{con.close();}catch(Exception e){e.getMessage();}
			if(rs!=null) try{rs.close();}catch(Exception e){e.getMessage();}
		}
		return list;
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return con;
	}
}
