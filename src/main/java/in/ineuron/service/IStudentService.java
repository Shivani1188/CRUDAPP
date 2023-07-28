package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {

	    //Creating a record
		String save(Student student);
		
		//Reading a record
		Student findByID(Integer sid);
		
		//Updating a record
		String updateById(Student student);
		
		//Deleting a record 
		String deleteById(Integer sid);
}
