//This util class is used for simple method and for hikari cp use JdbcUtil1 and put JdbcUtil1 instaed JdbcUtil in 
//StudentDaoImpl class
package in.ineuron.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {

	private JdbcUtil()
	{}
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
//	public static Connection getJdbcConnection() throws SQLException,IOException
//	{
//		HikariConfig config=new HikariConfig("src\\main\\java\\in\\ineuron\\properties\\db.Properties");
//		
//		HikariDataSource dataSource=new HikariDataSource(config);
//		Connection connection=dataSource.getConnection();
//		return connection;
//		
//	}
//	
	
	public static Connection getJdbcConnection() throws FileNotFoundException,IOException,SQLException
	{
//		FileInputStream fis=new FileInputStream("\\JDBCCRUDAPP5\\src\\main\\java\\in\\ineuron\\properties\\db.properties");
//		Properties properties=new Properties();
//		properties.load(fis);
//		String url=properties.getProperty("url");
//		String username=properties.getProperty("user");
//		String password=properties.getProperty("password");
//		Connection connection=DriverManager.getConnection(url, username, password);
//		return connection;
		
		String dbLoc="I:\\EclipseLatestVersion\\JDBCCRUDAPP5\\src\\main\\java\\in\\ineuron\\properties\\db.properties";
		FileInputStream fis = new FileInputStream(dbLoc);
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
