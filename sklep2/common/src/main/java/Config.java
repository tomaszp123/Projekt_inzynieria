import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;


public class Config
{
	private static final String CONFIG_FILE = "config.xml";
	
	private static XMLConfiguration configuration = loadConfiguration(CONFIG_FILE);
	
	private static XMLConfiguration loadConfiguration(String filename)
	{
		try {
			return new XMLConfiguration(filename);
		} catch (ConfigurationException e) {
			throw new Error("There was a problem loading the configuration", e);
		}
	}
	
	public static String getSomething()
	{
		return configuration.getString("sth");
	}
}
