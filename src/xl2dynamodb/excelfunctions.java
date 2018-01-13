/**
 *@fileoverview file for excel related functions
 * @author amlan
 */
package xl2dynamodb;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author amlan
 */
public class excelfunctions {
    
    public static List readxl(String flepth) throws Exception{
        List<Object[]> otpt = new ArrayList<Object[]>();
        FileInputStream ExcelFileToRead = new FileInputStream(new File(flepth));
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook(); 
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row; 
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        while (rows.hasNext())
        {
            row=(XSSFRow) rows.next();
            Object[] rwobj=new Object[noOfColumns];
            int colcnt=0;
            Iterator cells = row.cellIterator();
            while (cells.hasNext())
            {
                cell=(XSSFCell) cells.next();

                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
                {
                    System.out.print(cell.getStringCellValue()+" ");
                    rwobj[colcnt]=cell.getStringCellValue().toString();
                    colcnt=colcnt+1;
                }
                else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                {
                    System.out.print(cell.getNumericCellValue()+" ");
                    rwobj[colcnt]=cell.getNumericCellValue();
                    colcnt=colcnt+1;
                }
                else
                {
                    //placeholder for other types
                }
            }
            otpt.add(rwobj);
            System.out.println();
        }
        return otpt;
    }
  
}
