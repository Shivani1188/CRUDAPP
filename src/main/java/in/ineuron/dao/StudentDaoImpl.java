package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
//import in.ineuron.util.JdbcUtil;
import in.ineuron.util.JdbcUtil1;


public class StudentDaoImpl implements IStudentDao {

	Connection connection=null;
	
	@Override
	public String save(Student student) {
		String sqlInsertQuery="insert into student(`sname`,`sage`,`saddr`) values(?,?,?)";
		PreparedStatement psmt=null;
		String status=null;
		try
		{
			connection=JdbcUtil1.getJdbcConnection();
			if(connection!=null)
				psmt=connection.prepareStatement(sqlInsertQuery);
			if(psmt!=null)
			{
				psmt.setString(1, student.getSname());
				psmt.setInt(2, student.getSage());
				psmt.setString(3, student.getSaddr());
			}
			if(psmt!=null)
			{
				int rowAffected=psmt.executeUpdate();
				if(rowAffected==1)
				{
					status="success";
				}
				else
				{
					status="failure";
				}
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			status="failure";
		}
		catch(IOException e)
		{
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public Student findByID(Integer sid) {
		String sqlSelectQuery="select sid,sname,sage,saddr from student where sid=?";
		PreparedStatement psmt=null;
		Student student=null;
		try
		{
			connection=JdbcUtil1.getJdbcConnection();
			if(connection!=null)
				psmt=connection.prepareStatement(sqlSelectQuery);
			if(psmt!=null)
			{
				psmt.setInt(1, sid);
			}
			if(psmt!=null)
			{
				ResultSet resultSet=psmt.executeQuery();
				if(resultSet.next())
				{
					//copy the resultset data to StudentDTO and transfer to the view
					student=new Student();
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSaddr(resultSet.getString(4));
				}
				
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		return student;
	}

	@Override
	public String updateById(Student student) {
		String sqlUpdateQuery="update student set sname=?,sage=?,saddr=? where sid=?";
		PreparedStatement psmt=null;
		String status=null;
		try {
			connection=JdbcUtil1.getJdbcConnection();
			if(connection!=null)
				psmt=connection.prepareStatement(sqlUpdateQuery);
			if(psmt!=null)
			{
				psmt.setString(1, student.getSname());
				psmt.setInt(2, student.getSage());
				psmt.setString(3, student.getSaddr());
				psmt.setInt(4, student.getSid());
			}
			if(psmt!=null)
			{
				int rowAffected=psmt.executeUpdate();
				if(rowAffected==1)
				{
					status="success";
				}
				else
				{
					status="failure";
				}
			}
		}catch(SQLException | IOException e)
		{
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		String sqlDeleteQuery="delete from student where sid= ? ";
		PreparedStatement psmt=null;
		String status=null;
		try
		{
			Student student =findByID(sid);
			if(student!=null)
			{
				connection=JdbcUtil1.getJdbcConnection();
				if(connection!=null)
					psmt=connection.prepareStatement(sqlDeleteQuery);
				if(psmt!=null)
					psmt.setInt(1, sid);
				if(psmt!=null)
				{
					int rowAffected=psmt.executeUpdate();
					if(rowAffected==1)
						status="success";
				}
			}
			else
			{
				status="not available";
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

}
