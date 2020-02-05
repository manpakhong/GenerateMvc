package hk.org.hkbh.cms.generatemvc.web.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.factories.PropertiesFactory;
import com.rabbitforever.generateJavaMVC.models.dtos.CompressFileDto;
import com.rabbitforever.generateJavaMVC.services.DaoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.EoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.OrmDaoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.ServiceGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.SoGenerateMgr;

import hk.org.hkbh.cms.generatemvc.web.factories.UtilsFactory;
import hk.org.hkbh.cms.generatemvc.web.services.CompressionMgr;
import hk.org.hkbh.cms.generatemvc.web.utils.CommonUtils;
import hk.org.hkbh.cms.generatemvc.web.utils.DateUtils;
import hk.org.hkbh.cms.generatemvc.web.utils.FileUtils;

@SuppressWarnings("serial")
public class GenerateMvcServlet extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private PropertiesFactory propertiesFactory;
	private final String ZIP_EXT = ".zip";
	private UtilsFactory utilsFactory;
	private CommonUtils commonUtils;
	private FileUtils fileUtils;
	private DateUtils dateUtils;
	private final String EXCEL_EXT = ".xlsx";
	private String getClassName(){
		return this.getClass().getName();
	}

	public void init() throws ServletException {
		try {
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
		} catch (Exception e) {
			logger.error(getClassName() + ".ServletException() - Exception: ", e);
		}
	}	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream os = null;
		ByteArrayOutputStream baos = null;
		String rootDir = null;
		String fileName = null;
		String fileNamePrefix = null;
		String fileNameSuffix = null;
		try {
			String tableName = request.getParameter("tableName");



			
			

			
			List<CompressFileDto> compressFileDtoList = new ArrayList<CompressFileDto>();
			CompressFileDto compressFileDto1 = new CompressFileDto();
			CompressFileDto compressFileDto2 = new CompressFileDto();
			CompressFileDto compressFileDto3 = new CompressFileDto();
			CompressFileDto compressFileDto4 = new CompressFileDto();
			CompressFileDto compressFileDto5 = new CompressFileDto();
			
			EoGenerateMgr voGeneratorMgr = new EoGenerateMgr(tableName);
			voGeneratorMgr.generateEo(compressFileDto1);
			
			SoGenerateMgr soGeneratorMgr = new SoGenerateMgr(tableName);
			soGeneratorMgr.generateSo(compressFileDto2);
			

			DaoGenerateMgr daoGeneratorMgr = new DaoGenerateMgr(tableName);
			daoGeneratorMgr.generateDao(compressFileDto3);
//			
			OrmDaoGenerateMgr ormDaoGeneratorMgr = new OrmDaoGenerateMgr(tableName);
			ormDaoGeneratorMgr.generateDao(compressFileDto4);
			
//			IDaoGenerateMgr idaoGeneratorMgr = new IDaoGenerateMgr(temp[i]);
//			idaoGeneratorMgr.generateDao();	
//			
//			
			ServiceGenerateMgr svrGeneratorMgr = new ServiceGenerateMgr(tableName);
			svrGeneratorMgr.generateService(compressFileDto5);
//			
//			IServiceGenerateMgr isvrGeneratorMgr = new IServiceGenerateMgr(temp[i]);
//			isvrGeneratorMgr.generateService();
			
			compressFileDtoList.add(compressFileDto1);
			compressFileDtoList.add(compressFileDto2);
			compressFileDtoList.add(compressFileDto3);
			compressFileDtoList.add(compressFileDto4);
			compressFileDtoList.add(compressFileDto5);
		

			CompressionMgr mgr = new CompressionMgr();

			final ByteArrayOutputStream byteArrayOutputStream = mgr.compressByteArrayOutputStreamList(compressFileDtoList);
			

	        

			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
	        

			fileName = fileNamePrefix + "_" + fileNameSuffix +  commonUtils.genTimestampString() + ZIP_EXT;

			
			
			
			response.setContentType("application/zip");



//			baos = new ByteArrayOutputStream();
			//TODO uncomment the function after finished
//			mgr.generateExcel(voList, baos);

			byte[] byteArray = byteArrayOutputStream.toByteArray();
			response.setContentLength(byteArray.length);
			os = response.getOutputStream();

			byteArrayOutputStream.writeTo(os);


//			fileName = fileNamePrefix + "_" + fileNameSuffix +  commonUtils.genTimestampString() + EXCEL_EXT;

			response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");

			
		} catch (Exception e) {
			logger.error(getClassName() + ".doGet() - Exception: ", e);
		} finally {
			if (baos != null) {
				baos.close();		
				baos = null;
			}
			if (os != null) {
				os.flush();
				os.close();
				os = null;
			}
		}
	}

	public void destroy() {
		// do nothing.
	}
}
