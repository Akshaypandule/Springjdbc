package Com.springJdbc.DAO;

import java.util.List;

import Com.springJdbc.Student;

public interface StudentDao {
	
	
	public int insert(Student studebt);
	
	public int change(Student student);
	
	public int remove(int id);
	
	public Student getStudent(int studentID);// For single row
	
	public List<Student> getAllStudents();// for all record
	
	

}
