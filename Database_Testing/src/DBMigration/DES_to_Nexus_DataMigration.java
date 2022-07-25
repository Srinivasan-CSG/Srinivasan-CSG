package DBMigration;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DES_to_Nexus_DataMigration {
	static String DES_username;
    static String DES_password;
    static String TBD_username;
    static String TBD_password;
    static String Nexus_username;
    static String Nexus_password;
  //  static String  DES_dbURL = "jdbc:mysql://ipAddress:portNumber/dbName";
    static String  DES_dbURL = "jdbc:postgresql://localhost:5432/Testing_DB";
    static String  TDB_dbURL = "jdbc:postgresql://testmigration.postgres.database.usgovcloudapi.net:5432/dev-desm-transformation";
    static String  Nexus_dbURL = "jdbc:mariadb://datamigration.mariadb.database.usgovcloudapi.net:3306/data_migration?useSSL=true";
    
    
	public static CommonUtilities commonUtil;
	public static String datasheetDBInput;
	public String DBPropertyFile;
	public String inputLine;
	public static String Inputfilepath=System.getProperty("user.dir")+File.separator+"resources"+File.separator+"Input"+File.separator+"DBInputTable.xls";
	public static String DES_DB_Input;
	public static String TDB_Input;
	public static String NexusDB_Input;
	public static String DES_DataValues;
	public static String TDB_DataValues;
	public static String Nexus_DataValues;
	public static int DES_ColumnCount;
	public static int TDB_ColumnCount;
	
	
	
    
public DES_to_Nexus_DataMigration()throws Exception{
		commonUtil = new CommonUtilities();
		Properties DBPropertyFile = new Properties();		
		DBPropertyFile.load(new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"properties"+File.separator+"DB.properties")));
		datasheetDBInput = DBPropertyFile.getProperty("excel.DB.datasheet");
		DES_username=DBPropertyFile.getProperty("DB_Username");	 
		DES_password=DBPropertyFile.getProperty("DB_Password");
		TBD_username=DBPropertyFile.getProperty("TDB_Username");	 
		TBD_password=DBPropertyFile.getProperty("TDB_Password");
		DES_DB_Input=DBPropertyFile.getProperty("excel.DB.DESDBInput");	 
		TDB_Input=DBPropertyFile.getProperty("excel.DB.TDBInput");	
		NexusDB_Input=DBPropertyFile.getProperty("excel.DB.NexusDBInput");	
		Nexus_username=DBPropertyFile.getProperty("NexusDB_Username");
		Nexus_password=DBPropertyFile.getProperty("NexusDB_Password");
    }

		@DataProvider(name ="DES_DB_Input")
public String[][] DBTesting() throws Exception {
		return commonUtil.fetchInputData(Inputfilepath,datasheetDBInput,DES_DB_Input);
		}
				
				@Test(dataProvider = "DES_DB_Input")
				@Parameters({"Runmode","TableName","Columns","DES_Query","TDB_Query"})
		public void selectQuery(String Runmode,String TableName,String Columns,String DES_DB_Query,String T_DB_Query) throws SQLException, ClassNotFoundException 
		{
				Class.forName("org.postgresql.Driver");
				//Class.forName("org.postgresql.Driver");
				Connection DES_con = DriverManager.getConnection(DES_dbURL,DES_username,DES_password);
				Connection TDB_con = DriverManager.getConnection(TDB_dbURL,TBD_username,TBD_password);
				//Creating statement object
				Statement DES_st = DES_con.createStatement();
				Statement TDB_st = TDB_con.createStatement();
				//Executing the SQL Query and store the results in ResultSet
				ResultSet DES_ResSet = DES_st.executeQuery(DES_DB_Query);
				ResultSet TDB_ResSet = TDB_st.executeQuery(T_DB_Query);
				//While loop to iterate through all data and print results
				ResultSetMetaData DES_metadata = DES_ResSet.getMetaData();
			    DES_ColumnCount = DES_metadata.getColumnCount();  
			    ResultSetMetaData TDB_metadata = TDB_ResSet.getMetaData();
			    TDB_ColumnCount = TDB_metadata.getColumnCount();  
			  //  for (int i = 1; i <= DES_ColumnCount; i++) {	    	
			  //      writeToFile(DES_metadata.getColumnName(i) + ", ");  
			 //     }
		       
			/*    while (DES_ResSet.next()) {
			    	String DES_row="";
			    	//System.out.println(DES_ResSet);
			    	 for (int i = 1; i <= DES_ColumnCount; i++) { 
						 DES_row +=DES_ResSet.getString(i) + ", "; } 
						 System.out.println(DES_row);
					//	 System.out.println("======================================================================================================");
						writeToFile(DES_row);
			    }
			    	while(TDB_ResSet.next()) {
			    	//System.out.println(TDB_ResSet);
			    		 String TDB_row="";
						 for (int j = 1; j <= TDB_ColumnCount; j++) { 
								TDB_row +=TDB_ResSet.getString(j) + ", "; } 
								 System.out.println(TDB_row);
								// System.out.println("========================================================================================================================");
								 writeToFile(TDB_row);
								
								 
						
			      
			    }*/
			    
			  //Closing DB Connection
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//Updated Code///////////////////////////////
			   ArrayList<String> DES_list=new ArrayList<String>();
			   ArrayList<String> TDB_list=new ArrayList<String>();
			   ArrayList<String>  DES_Column_list=new ArrayList<String>();
			   ArrayList<String>  TDB_Column_list=new ArrayList<String>();
			    while(DES_ResSet.next()) {
			    
			    	 for(int i=1;i<=DES_ColumnCount;i++) {
			    		
			    		 DES_list.add(DES_ResSet.getString(i));
			    		 DES_Column_list.add(DES_metadata.getColumnName(i));
			    	 }
			    		 
			    	 }
			    
			    System.out.println("DES DB Table Data");
			    System.out.println("------------------------------------");
			    System.out.println(DES_list);
			    System.out.println("------------------------------------");
			    while(TDB_ResSet.next()) {
			    	 for(int j=1;j<=TDB_ColumnCount;j++) {
			    		 TDB_list.add(TDB_ResSet.getString(j));
			    		 TDB_Column_list.add(TDB_metadata.getColumnName(j));
			    		 
			    }
			    }
			   
			    System.out.println("Transformation DB Table Data");
			    System.out.println("------------------------------------");
			    System.out.println(TDB_list);
			    System.out.println("------------------------------------");
			  
			    
			    if(!DES_list.equals(TDB_list)) {
			    	Reporter.log("DES Table Data which is not available on Transformation DB after migration\n\n\n");
			    	 System.out.println("DES Table Data which is not available on Transformation DB after migration");
					    System.out.println("------------------------------------");
					    Reporter.log("------------------------------------------");
					    DES_list.removeAll(TDB_list);
					    Reporter.log(DES_list+"\n");
					    System.out.println(DES_list);
					    System.out.println("------------------------------------");
			    }
			    if(DES_list.equals(TDB_list)) 
			   {	
			       Reporter.log("---------------------------------------------");
				   Reporter.log("Table migrated successfully\n\n\n");
				   Reporter.log("---------------------------------------------");
			    }
					
			
			    DES_con.close();
			    TDB_con.close(); 
					 }
			    
		
				
//-------------------------------------------------------------------------------------------------------//
		
				//Nexus DataBase
//-------------------------------------------------------------------------------------------------------//				
		
	
				
				@DataProvider(name ="NexusDB_Input")
				public String[][] NexusDBTesting() throws Exception {
						return commonUtil.fetchInputData(Inputfilepath,datasheetDBInput,NexusDB_Input);
						}
				
				
								
						@Test(dataProvider = "NexusDB_Input")
						@Parameters({"Runmode","TableName","Columns","NexusDB_Query"})
				public void Nexus_selectQuery(String Runmode,String TableName,String Columns,String NexusDB_query) throws SQLException, ClassNotFoundException 
				{
							 Class.forName("com.mysql.jdbc.Driver");
					    		
					  //  Class.forName("org.mariadb.jdbc.Driver");
						Connection NexusDB_con = DriverManager.getConnection(Nexus_dbURL,Nexus_username,Nexus_password);
						//Creating statement object
						Statement NexusDB_st = NexusDB_con.createStatement();
						String NexusDB_Query=NexusDB_query;
						//Executing the SQL Query and store the results in ResultSet
						ResultSet NexusDB_ResSet = NexusDB_st.executeQuery(NexusDB_Query);
						ResultSetMetaData rsmd = NexusDB_ResSet.getMetaData();
						int DBColumncount=rsmd.getColumnCount();
						int rowCount = 0;
						//While loop to iterate through all data and print results
						while(NexusDB_ResSet.next()) {
							String DES_row="";
							rowCount++;
						    	 for(int j=1;j<=DBColumncount;j++) {
						    		 DES_row +=NexusDB_ResSet.getString(j) + ", "; } 
						    		 System.out.println(DES_row);
									 System.out.println("No: of Columns: "+ rsmd.getColumnCount());
									 System.out.println("No: of rows: "+ rowCount);
						    }
						
						
						//Closing DB Connection
						NexusDB_con.close();
				}
				
}
	
	
	