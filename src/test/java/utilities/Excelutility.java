package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	


    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum() + 1;;
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // skip header
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = getCellValue(cell);
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
    private static Object getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:  return cell.getStringCellValue();
            case NUMERIC: return cell.getNumericCellValue();
            case BOOLEAN: return cell.getBooleanCellValue();
            default:      return "";
        }
    }

}
