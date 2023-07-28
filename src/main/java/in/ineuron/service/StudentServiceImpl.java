package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentdaoFactory;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao;
	@Override
	public String save(Student student) {
		studentDao=StudentdaoFactory.getStudentDao();
		return studentDao.save(student);
	}

	@Override
	public Student findByID(Integer sid) {
		studentDao=StudentdaoFactory.getStudentDao();
		return studentDao.findByID(sid);
	}

	@Override
	public String updateById(Student student) {
		studentDao=StudentdaoFactory.getStudentDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		studentDao=StudentdaoFactory.getStudentDao();
		return studentDao.deleteById(sid);
	}

}
