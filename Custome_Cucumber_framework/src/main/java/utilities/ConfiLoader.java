package utilities;

import java.util.Properties;

import constants.Env_Type;

public class ConfiLoader {

	private Properties props;
	private static ConfiLoader configloader;
	
	public ConfiLoader() {
		String env = System.getProperty("env",String.valueOf(Env_Type.QA));
		switch(Env_Type.valueOf(env)) {
		case SIT:
			props = propertyUtilities.getProperties("src/test/resources/SIT_Config.properties");
			break;
		case QA:
			props = propertyUtilities.getProperties("src/test/resources/QA_Config.properties");
			break;
		}
	}
	
	
	public static ConfiLoader getInstance() {
		if (configloader == null) {
			configloader = new ConfiLoader();
		}
		return configloader;
	}
	
	public String getURL() {
		String prop = props.getProperty("baseURL");
		if(props!=null) return prop;
		else throw new RuntimeException("Target is not specified in SIT propertyfile");
	}
	
	public String getbrowser() {
		String prop = props.getProperty("browser");
		if(prop!=null) return prop;
		else throw new RuntimeException("Target is not specified in SIT propertyfile");
	}
	public String getBaseUrl() {
		String prop = props.getProperty("baseURL");
		if(prop!=null) return prop;
		else throw new RuntimeException("Base URL is not specified in SIT propertyfile");
	}
	public String getUsername() {
		String prop = props.getProperty("emailID");
		if(prop!=null) return prop;
		else throw new RuntimeException(" Username is not specified in SIT propertyfile");
	}
	
	public String getPassword() {
		String prop = props.getProperty("Password");
		if(prop!=null) return prop;
		else throw new RuntimeException("Password is not specified in SIT propertyfile");
	}
	
}
