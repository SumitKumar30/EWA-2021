package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRegister {
	private static Connection con = null;
	
	public StudentRegister() {
		con = getConnection();
	}
    public static Connection getConnection() {
        if (con != null)
            return con;
        else {
            try {
                
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/ewa_ncu";
                String user = "root";
                String password = "Admin@12345";
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
            } catch (SQLException sqe) {
                System.out.println(sqe);
            } 
            return con;
        }

    }
    public void addStudent(Student student) {
        try {
        	String sql = "INSERT INTO student(id, name,department)" +
    		" VALUES (?, ?, ? )";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, student.getS_id());
            ps.setString(2, student.getName());
            ps.setString(3, student.getDepartment());            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List getAllUsers() {
        List users = new ArrayList();
        try {
        	String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setS_id(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDepartment(rs.getString("department"));                             
                users.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public Student getUserById(int userId) {
    	Student std = new Student();
        try {
        	String sql = "SELECT * FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	std.setS_id(rs.getInt("id"));
            	std.setName(rs.getString("name"));
            	std.setDepartment(rs.getString("department"));                           
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return std;
    }
    public void removeUser(int userId) {
        try {
        	String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editUser(Student std) {    	
    	try {
    		String sql = "UPDATE student SET name=?, department=?" +
            " WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, std.getName());
            ps.setString(2, std.getDepartment());            
            ps.setInt(3, std.getS_id());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
