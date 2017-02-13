package mainProject.practise;

import java.sql.Connection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DBConnectorTest extends TestCase {
	
	public DBConnectorTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
		return new TestSuite(DBConnectorTest.class);
	}
	
	public void testDBConnection() throws Exception{
		Connection con = null;
		try{
			con = DBConnector.CONNECTION;
			assertNotNull(con);
		}finally{
			
			if(con != null){
				con.close();
			}
		}		
	}
}
