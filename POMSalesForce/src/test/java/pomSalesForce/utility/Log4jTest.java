package pomSalesForce.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

	public static void main(String[] args) {

		Logger logger = LogManager.getLogger(Log4jTest.class.getName());
		logger.debug("This is a debub message for SalesForce");
		logger.info("This is an information message for SalesForce");
		logger.warn("this is a warn message for SalesForce");
		logger.error("This is an error message for SalesForce");
		logger.fatal("This is a fatal message for SalesForce");
	}
	}
