package packageUtill;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private static Configuration configuration;
	private Properties properties;
	private final String path = "configuration/config.properties";

	private Configuration() {
		loadProperty();
	}

	private void loadProperty() {
		properties = new Properties();
		try {
			InputStream iStream = new FileInputStream(path);
			properties.load(iStream);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Configuration getInstance() {
		if (configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}

	public String get(String key) {
		if (key != null) {
			return properties.getProperty(key);
		} else {
			return null;
		}

	}

}
