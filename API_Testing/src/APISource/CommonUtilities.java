package APISource;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.lang3.StringUtils;


public class CommonUtilities{
	 
	int row;
	public String[][] fetchInputData(String xlfilepath, String sheetName, String tableName) throws Exception{
		String[][] inputData = null;
		WorkbookSettings workbookSettings = new WorkbookSettings();
		workbookSettings.setEncoding( "Cp1252" );
		Workbook workbook = Workbook.getWorkbook(new File(xlfilepath),workbookSettings);
		Sheet sheet = workbook.getSheet(sheetName); 
		int startRow,startCol, endRow, endCol,ci,cj;
		Cell tableStart=sheet.findCell(tableName);
		startRow=tableStart.getRow();
		startCol=tableStart.getColumn();
		int abc = startCol+1;
		Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 200, 64000,  false);                

		endRow=tableEnd.getRow();
		endCol=tableEnd.getColumn();
		inputData=new String[endRow-startRow-1][endCol-startCol-1];
		ci=0;

		for (int i=startRow+1;i<endRow;i++,ci++) { 
			cj=0;
			 int  j=0;
			for (j=startCol+1;j<endCol;j++,cj++){
				if(sheet.getCell(j,i).getContents().equalsIgnoreCase("N"))
            	{
            		j=endCol;
            		break;
            	}
            	else 
            	{            		                		   
            		inputData[ci][cj]=sheet.getCell(j,i).getContents();
                		
               	}
				
			}
		}
		   int count=0;
           int prev=0;
           List<String[]> l = new ArrayList<String[]>(Arrays.asList(inputData));
           for(int i=0;i<inputData.length;i++)
           {
           	count=i;
           		//System.out.println("The contents finally:"+tabArray[i][0]);
	            	String nullvalue =inputData[i][0];
	            	
	            	if(!StringUtils.isNotBlank(nullvalue))
	            	{
	            			count=count-prev;
	            			//System.out.println("The value of count is:"+count);
	            			l.remove(count);
	            			prev++;
           			
	            	}
	   
           }
           String[][] inputDatas = l.toArray(new String[][]{});
		return(inputDatas);
	}

	public void createDirectory(String basePath) {
		File fPath = new File(basePath);
		fPath.mkdir();
	}
}