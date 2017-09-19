package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;

import oracle.jdbc.OracleDriver;

//import dto.BankBean;
//import dto.ConnectionPoolManager;


public class BankDAO {

	
	
		public boolean createRecord(String userName,String dob,String email,String pass, String isAdmin)
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			//ConnectionPoolManager pool = null;
			try{
				
				

				//1. Load the Driver
				OracleDriver driverRef=new OracleDriver();
				DriverManager.registerDriver(driverRef);
				
				
				
//				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. Get the DB Connection via Driver
//				String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234";
//				String USER = "scott";
//				String PASS = "1234";
			     con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234");
				// String dbUrl = "jdbc:oracle:thin:@localhost:1521:orc";
				 //con = DriverManager.getConnection(dbUrl,"scott","1234");
				
				//3. Issue SQL Queries via Connection
				String query = " insert into customer values(userId.nextval,?,?,?,?,?) ";
			
				System.out.println("Query : "+query);
				
				pstmt = con.prepareStatement(query);
				//cstmt.setInt(1,userId);
				pstmt.setString(1, userName);
				pstmt.setString(2, dob);
				pstmt.setString(3, email);
				pstmt.setString(4, pass);
				pstmt.setString(5, isAdmin);	
			
				
				int count = pstmt.executeUpdate();
				System.out.println("CREATED PROFILE COUNT :"+count);
				
				if(count>0)
				{
					return true;
					
					
				}
				
				//4. Process 																																																																																																																																																																																																																																																																																																																																																																																																	the Results returned by SQL Queries
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			} finally{
				//5. Close ALL JDBC Objects
				try 
				{
					if(con!=null){
						con.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}//outer try-catch block
			return false;
		}//end of createRecord
		
		public BankBean authenticate(int userId, String password)
		{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int defaltMoney=100;
			//ConnectionPoolManager pool = null;
			try
			{
                     
				//1. Load the Driver
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				
				//2. Get the DB Connection via Driver
			     con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234");
				// con = DriverManager.getConnection(dbUrl,"scott","1234");
				 con.setAutoCommit(false);
						
			 String query = " select * from             "+  
						" customer         "+
						" where userId = ?         "+
						" and password = ?      ";
			
		 System.out.println("Query : "+query);
		 

		 System.out.println("Query : "+query);
		 pstmt =con.prepareStatement(query);
		 pstmt.setInt(1, userId);
			pstmt.setString(2, password);
		 rs = pstmt.executeQuery();
	             
		 System.out.println("ooo");
		 
		//4. Process the Results returned by SQL Queries
			if(rs.next())
			{
				
				   
				BankBean  bean=new BankBean();
				
				  bean.setUserId(Integer.parseInt(rs.getString("userId")));;
				  System.out.println();
				  bean.setUserName(rs.getString("userName")); 
				bean.setUserId(rs.getInt("userId"));
				bean.setIsAdmin(rs.getString("isAdmin"));
				bean.setPassword(rs.getString("password"));
				
			return bean;	
			}
			
				
			else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			//5. Close ALL JDBC Objects
			try 
			{
				if(rs!=null){
					con.close();
				}
				//pool.returnConnectionToPool(con);
				
				if(pstmt!=null){
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of authenticate
		
		public BankBean getDepositDetails()
		{
			Connection con = null;
		    Statement pstmt = null;
			ResultSet rs = null;
			//ConnectionPoolManager pool = null;
			try
			{
                     
				//1. Load the Driver
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				  
				//2. Get the DB Connection via Driver
			     con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234");
				// con = DriverManager.getConnection(dbUrl,"scott","1234");
				 
						
			    String query = " select * from deposit";
	
		        System.out.println("Query : "+query);
		        pstmt =con.createStatement();
		        rs = pstmt.executeQuery(query);
	             
		        System.out.println("ooo");
		 
		//4. Process the Results returned by SQL Queries
			if(rs.next())
			{
								   
				BankBean  bean=new BankBean();
				
				  bean.setUserId(rs.getInt("userId"));
				  
				  System.out.println();
				  bean.setDepoMoney(Integer.parseInt(rs.getString("depoMoney"))); 
//			
				
			return bean;	
			}
			
				
			else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			//5. Close ALL JDBC Objects
			try 
			{
				if(rs!=null){
					con.close();
				}
				//pool.returnConnectionToPool(con);
				
				if(pstmt!=null){
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of deposit details
	    public BankBean getDoposit(int userId)
			{
				BankBean bean=new BankBean();
				Connection con=null;
				PreparedStatement stmt1=null;
				ResultSet rs=null;
				//ConnectionPoolManager pool = null;
				try{
					
					

					//1. Load the Driver
					Class.forName("oracle.jdbc.driver.OracleDriver");
					

				     con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234");
					
					//3. Issue SQL Queries via Connection
					String query = " select * from deposit where userId=? ";
					System.out.println("Query : "+query);
					
					stmt1 = con.prepareStatement(query);
					stmt1.setInt(1, userId);
					rs=stmt1.executeQuery();
					
						if(rs.next())
						{
							bean.setUserId(rs.getInt("userId"));
							bean.setDepoMoney(Integer.parseInt(rs.getString("depoMoney")));
						
							
							return bean;
						}else {
							return null;
						}
									
					//4. Process 																																																																																																																																																																																																																																																																																																																																																																																																	the Results returned by SQL Queries
					
				} catch (Exception e) {
					
					e.printStackTrace();
					return null;
				} finally{
					//5. Close ALL JDBC Objects
					try 
					{
						if(con!=null){
							con.close();
						}
						if(stmt1!=null){
							stmt1.close();
						}
						if(rs!=null){
							rs.close();
						}
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}//outer try-catch block
				
			}//end of updateDeposit(userId)
		
	
		public boolean deposit(int userId,int m)
		{
			Connection con=null;
			PreparedStatement pstmt1=null;

			Statement stmt=null;
		
			//ConnectionPoolManager pool = null;
			try{
				//1. Load the Driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. Get the DB Connection via Driver
			     
				con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234");
			 
                 BankBean bean=getDoposit(userId);
                 BankDAO dao=new BankDAO();
                  dao.getDoposit(userId);
                   int userNo= bean.getUserId();
				
                   
					String query2 = "update deposit set depoMoney=? where userId=?";
					System.out.println(query2);
					pstmt1=con.prepareStatement(query2);
					pstmt1.setInt(1,m);
					pstmt1.setInt(2, userId);
					
				int updateCount1=pstmt1.executeUpdate();
				if(updateCount1>0)
				{
					System.out.println("updates your account money");
					return true;
				}
					
					
								
				} catch (Exception e) {
					
					e.printStackTrace();
					return false;
				} finally{
					//5. Close ALL JDBC Objects
					try 
					{
						if(con!=null){
							con.close();
						}
						if(pstmt1!=null){
							pstmt1.close();
						}
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}//outer try-catch block
				return false;
			}//end of method
		//111111111111111111111111111111111111111111111
		public boolean depositNew(int userId,int n)
		{
			Connection con=null;
			PreparedStatement pstmt1=null;
			
		
			//ConnectionPoolManager pool = null;
			try{
				//1. Load the Driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. Get the DB Connection via Driver
			     
				con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234");
			 
                 BankBean bean=getDoposit(userId);
                 BankDAO dao=new BankDAO();
                  dao.getDoposit(userId);
                  
					String query3="insert into deposit values(?,?)";
					System.out.println("Query : "+query3);
					
					pstmt1 = con.prepareStatement(query3);
					//cstmt.setInt(1,userId);
					pstmt1.setInt(1, userId);
					pstmt1.setInt(2, n);
					
					
					
					int count3 = pstmt1.executeUpdate();
					System.out.println(" First time you are inserting the money COUNT :"+count3);
					
					if(count3>0)
					{
						return true;
					}
					
				
					
				} catch (Exception e) {
					
					e.printStackTrace();
					return false;
				} finally{
					//5. Close ALL JDBC Objects
					try 
					{
						if(con!=null){
							con.close();
						}
						if(pstmt1!=null){
							pstmt1.close();
						}
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}//outer try-catch block
				return false;
			}//end of deposit(userId, n)
		//11111111111111111111111111111111111
					
		
	    public BankBean getUserInformation(String email)
		{
			BankBean bean=new BankBean();
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			//ConnectionPoolManager pool = null;
			try{
				
				

				//1. Load the Driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. Get the DB Connection via Driver

			     con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","1234");
	
				//3. Issue SQL Queries via Connection
				String query = " select * from customer where email=? ";
				
				System.out.println("Query : "+query);
				
				stmt = con.prepareStatement(query);
				stmt.setString(1, email);
				rs=stmt.executeQuery();
				
					if(rs.next())
					{
						bean.setUserId(rs.getInt("userId"));
						bean.setUserName(rs.getString("userName"));
						bean.setDob(rs.getString("dob"));
						bean.setEmail(rs.getString("email"));
						
						return bean;
					}else {
						return null;
					}
								
				//4. Process 																																																																																																																																																																																																																																																																																																																																																																																																	the Results returned by SQL Queries
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return null;
			} finally{
				//5. Close ALL JDBC Objects
				try 
				{
					if(con!=null){
						con.close();
					}
					if(stmt!=null){
						stmt.close();
					}
					if(rs!=null){
						rs.close();
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}//outer try-catch block
			
		}//end of getUserInformation 

	

}//end of bankDAO

		

	
