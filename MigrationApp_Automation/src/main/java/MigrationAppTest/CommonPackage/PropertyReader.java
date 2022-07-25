package MigrationAppTest.CommonPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private String filename=null;
	private Properties property;
	
	public PropertyReader(String filename)
	{
		this.filename = filename;
		this.property = new Properties();
		init();
	}
	
	private void init()
	{
		try {
			property.load(new FileInputStream(new File(filename)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String get(String key) throws Exception
	{
		if(property.getProperty(key)==null)
		{
			throw new Exception("Tyring to read a invalid property file || The value "+key+" is not present in the property file");
		}
		else
		{
			
		}
		return property.getProperty(key);
	}
	
	

}
