package hk.org.hkbh.cms.generatemvc.web.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CmsLoggerFactory {
	private static CmsLoggerFactory loggerFactory;
	private final static String log4jAppZPath = "/app/generate_java_mvc/";
	private CmsLoggerFactory() throws Exception{
	}
	
	public static CmsLoggerFactory getInstance() throws Exception {
		if (loggerFactory == null) {
			loggerFactory = new CmsLoggerFactory();
			
		}
		return loggerFactory;
	}
	
	public void setupLog4j() {
        // InputStream inStreamLog4j = getClass().getResourceAsStream("/log4j.properties");

        String propFileName = log4jAppZPath + "log4j.properties";
        File f = new File(propFileName);
        if (f.exists()) {

            try {
                InputStream inStreamLog4j = new FileInputStream(f);
                Properties propertiesLog4j = new Properties();

                propertiesLog4j.load(inStreamLog4j);
                PropertyConfigurator.configure(propertiesLog4j);
            } catch (Exception e) {
                e.printStackTrace();
                BasicConfigurator.configure();
            }
        } else {
            BasicConfigurator.configure();
        }

        Logger logger = LogManager.getLogger(getClassName());
        logger.debug("log4j configured");

    }
	private String getClassName(){
		return this.getClass().getName();
	}
}
