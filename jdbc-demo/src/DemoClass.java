import java.sql.*;
public class DemoClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/jdbc_demo";
		String uname="root";
		String pass="@Kshatha123";
		String query="select city from student where studid=3";
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();
		String name =rs.getString("city");
		System.out.print(name);
        
		st.close();
		con.close();
	}

}
