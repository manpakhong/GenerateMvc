package hk.org.hkbh.cms.generatemvc.web.spring.system.impls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import hk.org.hkbh.cms.generatemvc.web.factories.CmsLoggerFactory;
import hk.org.hkbh.cms.generatemvc.web.spring.system.WebInitializer;

@SuppressWarnings("serial")
public class InitializerImpl extends HttpServlet implements WebInitializer{
	private Logger logger;
//	private final Logger logger = LogManager.getLogger(getClassName());
	private WebInitializer quartzInitializer;
	public void init() throws ServletException{
		try{
			CmsLoggerFactory cmsLoggerFactory = CmsLoggerFactory.getInstance();
			cmsLoggerFactory.setupLog4j();
			
			start();
		} catch (Exception e){
			logger.error("InitializerImpl.init()", e);
		}
	}
	@Override
	public void start() throws Exception{
		try {

			
			
//			Initializer initializer = new Initializer();
//			initializer.run();
		} catch (Exception e) {
			logger.error(InitializerImpl.class.getName() + "start()", e);
			throw e;
		}
	}
	private String getClassName(){
		return this.getClass().getName();
	}
}
