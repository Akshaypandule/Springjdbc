package Com.springJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Com.springJdbc.DAO.StudentDao;

public class App 
{
	public static void main(String args[])
	{
	
	
	ApplicationContext context=new ClassPathXmlApplicationContext("Com/springJdbc/config.xml");
	StudentDao studentdao=context.getBean("studentDao",StudentDao.class);
	
	/*Student student=new Student();
	student.setId(1455);
	student.setName("Akshay");
	student.setCity("Kanpur");
	int result=studentdao.insert(student);
	System.out.println("Data insert Successfully"+result);*/
	
	/*Student student=studentdao.getStudent(855);
	System.out.println(student);*/
	
	List<Student> student=studentdao.getAllStudents();
	for(Student s:student)
	{
		System.out.println(s);
	}
	
	
	}
	
    
	
}
