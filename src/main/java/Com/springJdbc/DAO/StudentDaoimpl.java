package Com.springJdbc.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Com.springJdbc.Student;

public class StudentDaoimpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate ;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student studebt) {
		
		String query="insert into student(id,name,city) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,studebt.getId(),studebt.getName(),studebt.getCity());
		return r;
	}

	@Override
	public int change(Student student) {
		
		// Updating 
		String query="update student set name=?, city=? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		return r;
	}

	@Override
	// Delete Query
	public int remove(int id) {
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query,id);
		return r;
	}

	@Override
	public Student getStudent(int studentID) {
		// Select query for Single row 
		
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperimpl();// RowMapper implementation class
		Student student=this.jdbcTemplate.queryForObject(query,rowMapper,studentID);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		//Selecting Multiple Students
		
		String query="select * from student";
		List<Student> student=this.jdbcTemplate.query(query,new RowMapperimpl());
		return student;
	}

}
