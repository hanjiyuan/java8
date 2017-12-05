package h3w.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;


public class Log4jTest {

	static Logger logger = Logger.getLogger(Log4jTest.class.getName());

	@Test
	public void test() {
		PropertyConfigurator.configure(
				"E:\\java8\\eclipse\\workspace\\java8\\resource\\log4j.properties");
		logger.info("hello log4j");
	}
}
