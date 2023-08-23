import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");

			System.out.println("Driver CLass Loaded");

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "admin");
			System.out.println("get the connection");

			Statement st = con.createStatement();
			String insert = "insert into Employee values(103,'Sourabh','Banglore')";
			String select = "select * from employee";
			String dynamic = "insert into employee values(?,?,?)";
			ResultSet rs = st.executeQuery(select);
			PreparedStatement ps = con.prepareStatement(dynamic);
			// while(rs.next())
			// {
			// System.out.println(rs.getInt(1) + " " + rs.getString(2)+" "+rs.getString(3));
			// }
			Scanner scanner = new Scanner(System.in);
			System.out.println("Id==");
			int eid = scanner.nextInt();
			System.out.println("Name==");
			String ename = scanner.nextLine();
			scanner.nextLine();
			System.out.println("Address");
			String eaddress = scanner.nextLine();
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setString(3, eaddress);
			ps.executeLargeUpdate();
			con.close();
			scanner.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
