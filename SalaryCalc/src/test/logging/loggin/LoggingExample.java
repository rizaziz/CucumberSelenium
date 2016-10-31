package loggin;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

import java.io.FileInputStream;

public class LoggingExample {

    public static Logger log= LogManager.getRootLogger();
    //static Logger log= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    public static void main(String[] args) throws Exception{

        log.fatal(System.getProperty("log4j.configurationFile"));
        log.debug("Hello this is a debug message");
        log.info("Hello this is a info message");
        log.trace("Hello this is trace");
        log.error("hello this is error");
        log.fatal("this is fatal");
        log.warn("this is warn");

    }
}
