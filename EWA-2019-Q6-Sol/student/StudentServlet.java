package student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static String INSERT = "/Register.jsp";
	private static String Edit = "/update.jsp";
    private static String UserRecord = "/list.jsp";
	private StudentRegister student;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
        student = new StudentRegister();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String redirect="";
        String uId = request.getParameter("userId");        
        String action = request.getParameter("action");
        if(!((uId)== null) && action.equalsIgnoreCase("insert"))
        {
        	int id = Integer.parseInt(uId);
        	Student std = new Student();
        	std.setS_id(id);
            std.setName(request.getParameter("Name"));
            std.setDepartment(request.getParameter("Department"));
        	student.addStudent(std);
        	redirect = UserRecord;
            request.setAttribute("users", student.getAllUsers()); 
           	System.out.println("Record Added Successfully");
        }else if (action.equalsIgnoreCase("delete")){
            String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);
            student.removeUser(uid);
            redirect = UserRecord;
            request.setAttribute("users", student.getAllUsers());
            System.out.println("Record Deleted Successfully");
        }else if (action.equalsIgnoreCase("editform")){        	
        	redirect = Edit;            
        } else if (action.equalsIgnoreCase("edit")){
        	String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);            
            Student user = new Student();
        	user.setS_id(uid);
            user.setName(request.getParameter("Name"));
            user.setDepartment(request.getParameter("Department"));
            student.editUser(user);
            request.setAttribute("user", user);
            redirect = UserRecord;
            System.out.println("Record updated Successfully");
         }else if (action.equalsIgnoreCase("listUser")){
            redirect = UserRecord;
            request.setAttribute("users", student.getAllUsers());
         }else {
            redirect = INSERT;
        }
        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
