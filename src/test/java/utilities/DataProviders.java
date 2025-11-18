package utilities;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {
	
	@DataProvider(name="LoginData" )
	public Object[][] getdata() throws IOException{
		String path=System.getProperty("user.dir")+"//testdata//LMS-LOGIN.xlsx";
		return Excelutility.getTestData(path, "Sheet1");
		
	}

}
