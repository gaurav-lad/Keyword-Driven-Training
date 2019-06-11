package operation;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class ReadObject {
	Properties p = new Properties();
	
	public Properties getProperties() throws IOException {
		InputStream stream  = new FileInputStream(new File(("C:\\Users\\Gaurav\\eclipse-workspace\\KeywordDrivenTraining\\src\\objects\\object.properties")));
		p.load(stream);
		return p;
	}
}
