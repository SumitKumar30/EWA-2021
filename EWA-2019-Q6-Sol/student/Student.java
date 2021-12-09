package student;

public class Student {
	int s_id;
	String name;
	String department;
	
	/*
	 * public Student(int id, String name, String department) { this.s_id = id;
	 * this.name = name; this.department = department; }
	 */

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
