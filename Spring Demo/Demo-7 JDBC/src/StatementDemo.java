import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		Statement st=null;
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");//jar
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			st=con.createStatement();
			String sql="select * from emp";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println("id : "+rs.getInt("id")+ " ,  name  : "+rs.getString("email"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			con.close();
			st.close();
			
		}

	}

}
