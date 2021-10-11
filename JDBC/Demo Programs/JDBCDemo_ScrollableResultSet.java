/*
	1. Import java.sql package
	2. Load & register the database driver (MySQL Connector)
	3. Establish a connection with the database
	4. Create and Execute SQL statements
	5. Process the result 
	6. close the database connection  
*/
package jdbcDemo;
import java.sql.*;	// step 1
import java.util.Scanner;
public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// Step2: Load and Register the database driver 
		Class.forName("com.mysql.cj.jdbc.Driver");	
		
		String url = "jdbc:mysql://localhost:3306/ewa_ncu";
		String username = "root";
		String pass = "Admin@12345";
		
		// step3: Establish a connection with the database
		Connection con = DriverManager.getConnection(url, username, pass);
		
		if(con != null) {
			System.out.println("Connection established successfully!!");
		}
		
		// step4: Create and execute SQL statements/queries
		String query = "select * from citizen";
		
		// Insertion/Creation
		Scanner sc = new Scanner(System.in);
		
		  System.out.println("Enter the citizen id: "); int citi_id = sc.nextInt();
		  
		  System.out.println("Enter the citizen name: "); String citi_name = sc.next();
		  
		  System.out.println("Enter the DOB: "); String citi_dob = sc.next();
		  
		  sc.nextLine(); System.out.println("Enter the address: "); String citi_add =
		  sc.nextLine();
		  
		  String insert_query =
		  "insert into citizen(id, name, dob, address) values("+citi_id+",'"+citi_name+
		  "','"+citi_dob+"','"+citi_add+"')";
		 
		
		  System.out.println("Enter the citizen id whose address you want to update: "
		  ); int new_id = sc.nextInt();
		  
		  sc.nextLine(); System.out.println("Enter the new address: "); String new_add
		  = sc.nextLine();
		  
		  String update_query =
		  "update citizen set address='"+new_add+"' WHERE id="+new_id;
		 
		String update_query2 = "update citizen set name = ? where id = ?";
		
		PreparedStatement pstmt = con.prepareStatement(update_query2);
		
		pstmt.setString(1, "Ravish");
		
		pstmt.setInt(2, 104);
		
		String select_query2 = "select id, name, address from citizen where id = ?";
		
		
		
		int  records = pstmt.executeUpdate();
		
		if(records == 1) {
			System.out.println("Records updated successfully!!");
		}
		else {
			System.out.println("Failed to execute update!!!");
		}
		
PreparedStatement pstmt2 = con.prepareStatement(select_query2);
		
		pstmt2.setInt(1, 104);
		
		ResultSet rst = pstmt2.executeQuery();
		
		rst.next();
		
		int id2 = rst.getInt(1);
		String name2 = rst.getString(2);
		String address2 = rst.getString(3);
		
		System.out.println("Citizen id: "+id2+" Citizen name: "+name2+" Citizen Address: "+address2);
		
		
		System.out.println("Enter the citizen id you want to delete: ");
		int delete_id = sc.nextInt();
		
		String delete_query = "delete from citizen where id = "+delete_id;
		
		// Forward only && Read only ResultSet 
		 //Statement stmt = con.createStatement();
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		/*
		 * int record = stmt.executeUpdate(insert_query);
		 * 
		 * if(record == 1) { System.out.println("Record inserted successfully!!!");
		 * }else { System.out.println("Failed to insert any record!!!!"); }
		 * 
		 * int rows = stmt.executeUpdate(update_query); if(rows == 1)
		 * System.out.println("Record updated successfully!!!"); else
		 * System.out.println("Failed to update any record!!!");
		 * 
		 * int deleteCount = stmt.executeUpdate(delete_query);
		 * 
		 * if(deleteCount == 1) { System.out.println("Record deleted successfully!!!");
		 * }else System.out.println("Failed to delete any record!!!");
		 */
		/*
		 * result.next(); String name = result.getString("name");
		 * 
		 * System.out.println("Record fetched: "+name);
		 */
		
		// Step5: Process the result 
			
		System.out.println("-------Forward---------");
		ResultSet result = stmt.executeQuery(query);
		int count = 0;
		while(result.next()) {
			int id = result.getInt(1);
			String name = result.getString(2);
			String gender = result.getString(3);
			Date dob = result.getDate(4);
			String mother_tongue = result.getString(5);
			String address = result.getString(6);
			boolean is_nri = result.getBoolean(7);
			System.out.println("Citizen ID: "+id+" Name: "+name+" Gender:"+gender+" dob: "+dob+" mother_tongue: "+mother_tongue+" Address: "+address+" Is-NRI: "+is_nri);
			count++;
			// Update the name of second record 
			if(count == 2) {
				result.updateString(2, "Sammy");
				result.updateRow();
			}
		}
		
		
		System.out.println("----- Reverse --------");
		System.out.println("Moving ResultSet in reverse directoin - Bottom to Top");
		
		while(result.previous()) {
			int id = result.getInt(1);
			String name = result.getString(2);
			String gender = result.getString(3);
			Date dob = result.getDate(4);
			String mother_tongue = result.getString(5);
			String address = result.getString(6);
			boolean is_nri = result.getBoolean(7);
			System.out.println("Citizen ID: "+id+" Name: "+name+" Gender:"+gender+" dob: "+dob+" mother_tongue: "+mother_tongue+" Address: "+address+" Is-NRI: "+is_nri);
	
		}
		
		// Step6: close the database connection
		con.close();
	}

}
