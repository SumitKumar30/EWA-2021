package transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransaction {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/ewa_ncu";
		String user = "root";
		String password = "Admin@12345";
		Connection con = DriverManager.getConnection(url, user, password);
		con.setAutoCommit(false);
		if(con != null)
				System.out.println("Connection established successfully!!");
		
		String query = "insert into citizen (id, name, address) values (?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1, 227);
		pstmt.setString(2, "Howard");
		pstmt.setString(3, "Los Angeles");
		
		 int row = pstmt.executeUpdate();
		if(row == 1) {
			System.out.println("Record inserted successfully!!");
		}
		else {
			System.out.println("Transaction failed!!!");
		}
		
		// to save the changes permanently 
//		 con.commit();
		/*
		 * if(con == null) { con.rollback(); } else con.commit();
		 */
		con.commit();
		
		String update_query = "update citizen set name = ? where id = ?";
		PreparedStatement pstmt2 = con.prepareStatement(update_query);
		pstmt2.setString(1, "Amy");
		pstmt2.setInt(2, 221);
		pstmt2.executeUpdate();
		
		//con.rollback();
		con.commit();
		
		
		con.close();
	}

}
