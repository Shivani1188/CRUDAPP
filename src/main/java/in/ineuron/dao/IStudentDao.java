package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {

	//Creating a record
		String save(Student student);
		
		//Reading a record
		Student findByID(Integer sid);
		
		//Updating a record
		String updateById(Student student);
		
		//Deleting a record 
		String deleteById(Integer sid);
}
