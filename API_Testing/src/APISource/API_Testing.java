package APISource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

//import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class API_Testing {
	
	private String name = "hello";
	public static CommonUtilities commonUtil;
	public static String datasheetAPIInput;
	public String APIPropertyFile;
	public String inputLine;
	public static String Inputfilepath=System.getProperty("user.dir")+File.separator+"resources"+File.separator+"Input"+File.separator+"APIInputTable.xls";
	public static String GET_APITesting;
	public static String POST_APITesting;
	
	
	public API_Testing()throws Exception{
		commonUtil = new CommonUtilities();
		Properties APIPropertyFile = new Properties();		
		APIPropertyFile.load(new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"properties"+File.separator+"API.properties")));
		datasheetAPIInput = APIPropertyFile.getProperty("excel.API.datasheet");
		GET_APITesting=APIPropertyFile.getProperty("excel.API.GET_APITesting");	 
		POST_APITesting=APIPropertyFile.getProperty("excel.API.POST_APITesting");	
	}	
/*---------------------------------------------------------------------------------------------------------------------------------------------------------
                                                  Code to Run GET Request
------------------------------------------------------------------------------------------------------------------------------------------------------------*/ 
@DataProvider(name ="GET_APITesting")
public String[][] aptTesting_GETRequest() throws Exception {
return commonUtil.fetchInputData(Inputfilepath,datasheetAPIInput,GET_APITesting);
}
		
@Test(dataProvider = "GET_APITesting")
@Parameters({"Runmode","GET_URL","Type","Headers"})
public void aptTesting_GETRequest(String Runmode,String API_Header,String GET_URL,String Type,String Headers) throws Exception {

URL url = new URL(GET_URL);
HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
connection.setRequestMethod(Type);
connection.setRequestProperty("Authorization", Headers);

int responseCode = connection.getResponseCode();
if (responseCode== 200) { // success
	System.out.println("\nSending 'GET' request to URL : " + url);
	System.out.println("Response Code : " + responseCode);
	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	StringBuffer response = new StringBuffer();
	while ((inputLine = in.readLine()) != null) {
		System.out.println(inputLine);
		response.append(inputLine);
	}
	in.close();
}else {
	System.out.println("\nSending 'GET' request to URL : " + url);
	System.out.println("Response Code : " + responseCode);
	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
	StringBuffer response = new StringBuffer();
	while ((inputLine = in.readLine()) != null) {
		System.out.println(inputLine);
		response.append(inputLine);
		
	}
	in.close();
}
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------
//Code to Run POST and Put Request
//------------------------------------------------------------------------------------------------------------------------------------------------------------    
@DataProvider(name ="POST_APITesting")
public String[][] aptTesting_POSTRequest() throws Exception {
return commonUtil.fetchInputData(Inputfilepath,datasheetAPIInput,POST_APITesting);
}
                                                     
@Test(dataProvider = "POST_APITesting")
public void aptTesting_POSTRequest(String Runmode,String API_Header,String POST_URL,String Type,String Headers,String urlParameters) throws Exception {
	URL url = new URL(POST_URL);
	HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
	HttpURLConnection connection2 = (HttpURLConnection) url.openConnection();
	//https Request//
	connection.setRequestMethod(Type);
	connection.setRequestProperty("Authorization", Headers);
	connection.setRequestProperty("Content-Type", "application/json");
    connection.setDoOutput(true);
	//http Request//
	connection2.setRequestMethod(Type);
	connection2.setRequestProperty("Authorization", Headers);
	connection2.setRequestProperty("Content-Type", "application/json");
    connection2.setDoOutput(true);
    //------------------------------------------------------------------------//
	OutputStream os = connection.getOutputStream();
	OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");  
	osw.write(urlParameters);
	System.out.println(osw);
	osw.flush();
	osw.close();
	os.close();
	
	int responseCode = connection.getResponseCode();

	if (responseCode == 200||responseCode == 201) { //success
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			System.out.println(inputLine);
		}
		in.close();
	} else {
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			System.out.println(inputLine);
		}
		in.close();
		
	
	}
}
}
	