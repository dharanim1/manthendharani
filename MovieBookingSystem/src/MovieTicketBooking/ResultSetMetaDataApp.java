package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
 
 
public class ResultSetMetaDataApp {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection conn = DataBaseConnection.getConnection();
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("select * from shows")){
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			System.out.println(colCount);
			for(int i=1;i<=colCount;i++) {
				System.out.println("Column : " + i);
				System.out.println("Column Name : " + rsmd.getColumnName(i));
				System.out.println("Column Lable : " + rsmd.getColumnLabel(i));
				System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
				System.out.println("Column Type Name: " + rsmd.getColumnClassName(i));
				System.out.println("Column isNullable : " + rsmd.isNullable(i));
				System.out.println("Column isAutoIncrement : " + rsmd.isAutoIncrement(i));
				System.out.println("Column getPrecision : " + rsmd.getPrecision(i));
				System.out.println("Column getColumnDisplaySize : " + rsmd.getColumnDisplaySize(i));
				System.out.println("Column getTableName : " + rsmd.getTableName(i));
				System.out.println("Column getSchemaName : " + rsmd.getSchemaName(i));


				System.out.println("------------------------------------------");
			}


		}catch(SQLException e) {
			e.printStackTrace();
		}
 
	}
 
}