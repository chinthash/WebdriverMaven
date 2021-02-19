package log4j;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jex {
	public static Logger log = Logger.getLogger(Log4jex.class);

	public static void main(String args[]) {
		Date date = new Date();
		String cdate = date.toString().replace(":", "_").replace(" ", "_");
		System.setProperty("current.date", cdate);
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.error("This is error");
		log.debug("This is debug");
		log.info("This is info message");

	}
}
