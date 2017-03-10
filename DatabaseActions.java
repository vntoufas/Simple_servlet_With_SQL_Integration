import java.sql.*;

public class DatabaseActions {

	private static final String USERNAME = "root";
	private static final String PASS = "testpass";
	private static final String MYSQLURL = "jdbc:mysql://localhost/university?useSSL=false";
	private String toPrint = "";
	private Connection con = null;

	public DatabaseActions() throws SQLException {
	}

	public String SelectAllFromDB() throws SQLException {
		ConnectToDB();
		String sqlselect;
		try {

			sqlselect = "select * from student";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlselect);
			while (resultSet.next()) {
				int am = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String lastname = resultSet.getString(3);
				int age = resultSet.getInt(4);
				
				toPrint += " " + am + "  " + name+" "+lastname+" "+age+"\n";
			}
		} finally {
			CloseConnectionToDB();
			return toPrint;
		}

	}
	
	public boolean InsertToDB(String name,String surname, String age) throws SQLException{
		boolean didIt=false;
		ConnectToDB();
		//insert into student (firstname, lastname,Age) values ('vaa1','vas',23);
		String sqlInsert = "insert into student (firstname, lastname, Age) values ('"+name+"', '"+surname+"', '"+age+"')"; 
		Statement statement = con.createStatement();
		statement.executeUpdate(sqlInsert);
		
		
		
		CloseConnectionToDB();
		return didIt;
	}
	
		public int CountDB() throws SQLException{
			ConnectToDB();
			String sqlselect = "SELECT COUNT(AM) FROM student;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlselect);
			//int res = resultset.
			CloseConnectionToDB();
			return 0;
		}


	public boolean ConnectToDB() throws SQLException {
		boolean didIt = false;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con = DriverManager.getConnection(MYSQLURL, USERNAME, PASS);
		if (con.isClosed()) {
			return false;
		}

		else
			return true;
	}

	// ResultSet resultSet = null;
	public boolean CloseConnectionToDB() throws SQLException {
		this.con.close();
		if (con.isClosed()) {
			return true;
		} else
			return false;

	}

}
