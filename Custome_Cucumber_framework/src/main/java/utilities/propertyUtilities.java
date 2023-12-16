package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertyUtilities {

	public static Properties getProperties(String PATH) {

		Properties props = new Properties();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(PATH));
			props.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("propertyfile Not Found  " + PATH);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("encountered with an Unexpected Exception");
		}
		return props;

	}

}
