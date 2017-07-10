package dao;
import java.sql.*;
public class Dao {
	Connection con = null ;
	Statement stat = null ;
	ResultSet rs = null ;
	public void close(){
		try {
			stat.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Dao(){
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      con = DriverManager.getConnection("jdbc:sqlite:Manager.db");
	      System.out.println("Opened database successfully");

	      stat = con.createStatement();
	      ResultSet rs = stat.executeQuery("select name from sqlite_master where name='Tb_kc'"); 
	      if(!rs.next()){
	    	  String sql ="CREATE TABLE Tb_kc " +
	                   "(id INTEGER             PRIMARY KEY          AUTOINCREMENT," +
	                   " tb_title       char(50)   NOT NULL, " + 
	                   " tb_mark         char(50)    , " + 
	                   " tb_style        CHAR(50), " + 
	                   " tb_value         REAL ,"+
	                   "tb_nums INT )"; 
	    	  stat.execute(sql) ;
	      }//else System.out.println("h33");
	      rs = stat.executeQuery("select name from sqlite_master where name='Tb_Sale'") ;
	      if(!rs.next()){
	    	  String sql ="CREATE TABLE Tb_Sale " +
	                   "(id INTEGER             PRIMARY KEY          AUTOINCREMENT, " +
	                   " tb_title       char(50)   NOT NULL, " +  
	                   " tb_value         REAL ,"+
	                   "tb_nums INT ,"+
	                   "tb_date TEXT)"; 
	    	  stat.execute(sql) ;
	      }//else System.out.println("h33");
	      rs = stat.executeQuery("select name from sqlite_master where name='Login_info'") ;
	      if(!rs.next()){
	    	  String sql ="CREATE TABLE Login_info " +
	                   "(username char(50) NOT NULL," +
	                   "password char(50) NOT NULL)"; 
	    	  stat.execute(sql) ;
	    	  String sql1 = "insert into Login_info(username,password) values('root','123456')" ;
	    	  stat.execute(sql1) ;

	      }//else System.out.println("h33");
	     
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
		/*
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Manager" ;
		try{
			Class.forName(JDriver) ;
			con = DriverManager.getConnection(connectDB, "sa", "112578") ;
			stat = con.createStatement() ;
			//System.out.println("OK");
		}catch(Exception e){
			System.out.println("数据库加载失败！");
			e.printStackTrace();
			con = null ;
			
		}*/
		
	}
	public ResultSet executeQuery(String sql){
		try{
			rs = stat.executeQuery(sql) ;
			//System.out.println("OK");
		
		}catch(Exception e){
			System.out.println("数据库链接错误！");
			rs = null ;
		}
		return rs ;
	}
	public void execute(String sql){
		try {
			stat.execute(sql) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("GG");
			e.printStackTrace();
		}
	}

	
	/*public static void main(String args[]){
		Dao dao = new Dao() ;
		ResultSet rs = dao.executeQuery("select *from Tb_kc") ;
		try{
			while(rs.next()){
				System.out.println(rs.getString("tb_title").trim());
				System.out.println(rs.getString("tb_mark"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}*/
	
	
}
