package in.ineuron.factory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class StudentdaoFactory {

	private static IStudentDao studentDao=null;
	
	public StudentdaoFactory() {
		// TODO Auto-generated constructor stub
	}

	public static IStudentDao getStudentDao()
	{
		if(studentDao==null)
			studentDao=new StudentDaoImpl();
		return studentDao;
		
	}
}
