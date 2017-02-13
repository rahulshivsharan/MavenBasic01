package mainProject.practise;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DBConnector {
	
	public static final  Connection CONNECTION = ConnectionHolder.getConnection();
	
	public static class Employee{
		private Integer employeeId;
		private String employeeName;
		private Integer salary;
		
		public Employee(Integer employeeId, String employeeName, Integer salary){
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.salary = salary;
		}
		
		@Override
		public String toString(){			
			StringBuffer strb = new StringBuffer();
			
			strb.append("Employee Id \"")
				.append(this.employeeId)
				.append("\", Employee name \"")
				.append(this.employeeName)
				.append("\", Salary \"")
				.append(this.salary).append("\";");
			
			return strb.toString();	
		}
	}
	
	private static class ConnectionHolder{
		
		private static Connection getConnection(){
			Connection con = null;
			String url = "jdbc:mysql://127.0.0.1:3306/testDb";
			String driverString = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "rahul";
			try{
				
				Class.forName(driverString);
				con = DriverManager.getConnection(url, userName, password);			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return con;
		}
	}
	
	public static List<DBConnector.Employee> getEmloyees() throws Exception{
		List<DBConnector.Employee> list = new ArrayList<DBConnector.Employee>();
		String query = "select employeeId as empid, employeeName as empName, salary as salary from employeeTbl_1";
		PreparedStatement ps = CONNECTION.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			DBConnector.Employee emp = new DBConnector.Employee(rs.getInt("empid"),
																rs.getString("empName"), 
																rs.getInt("salary"));
			
			list.add(emp);
		}
		return list;
	}
	
	public static void main(String [] args){
		List<DBConnector.Employee> list = null;
		Iterator<DBConnector.Employee> itr = null;
		try{
			list = getEmloyees();
			itr = list.iterator();
			
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
