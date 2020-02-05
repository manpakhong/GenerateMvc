package hk.org.hkbh.cms.generatemvc.webservices;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.factories.PropertiesFactory;
import com.rabbitforever.generateJavaMVC.models.dtos.CompressFileDto;
import com.rabbitforever.generateJavaMVC.services.DaoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.EoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.FileArchieveMgr;
import com.rabbitforever.generateJavaMVC.services.OrmDaoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.ServiceGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.SoGenerateMgr;

import hk.org.hkbh.cms.generatemvc.factories.UtilsFactory;
import hk.org.hkbh.cms.generatemvc.services.CompressionMgr;
import hk.org.hkbh.cms.generatemvc.utils.CommonUtils;
import hk.org.hkbh.cms.generatemvc.utils.DateUtils;
import hk.org.hkbh.cms.generatemvc.utils.FileUtils;
//http://localhost:8080/MfmsReport/generatePatrolReportWs/test
//http://localhost:8080/MfmsReport/generatePatrolReportWs/requestPatrolRoutineJson
@Path("/generateMvcWs")
public class GenerateMvcWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private PropertiesFactory propertiesFactory;

	private UtilsFactory utilsFactory;
	private CommonUtils commonUtils;
	private FileUtils fileUtils;
	private DateUtils dateUtils;
	private final String EXCEL_EXT = ".xlsx";
	private final String ZIP_EXT = ".zip";
	
	public GenerateMvcWs() {
		try {
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();

			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
		} catch (Exception e) {
			logger.error(getClassName() + ".GeneratePatrolReportWs() - Exception: ", e);
		}
	}
	private String getClassName(){
		return this.getClass().getName();
	}

	@GET
	@Path("/generateMvc")
//    @Produces("application/vnd.ms-excel")
    @Produces(MediaType.TEXT_PLAIN)
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response requestPatrolRoutineExcel(
			@QueryParam("tableName") String tableName
			){
		String rootDir = null;
		String fileName = null;
		String fileNamePrefix = null;
		String fileNameSuffix = null;
		Response response = null;
		StreamingOutput  stream = null;
		try{
			
			Integer siteKey = null;
			Date resultStartDate = null;
			Date resultEndDate = null;
			List<String> routeKeyList = null;
			List<String> routeLocationKeyList = null;
			

			FileArchieveMgr fileArchieveMgr = new FileArchieveMgr();
			fileArchieveMgr.maintainFileArchieve();
			
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
			
			

	        stream = new StreamingOutput() {
	            @Override
	            public void write(OutputStream os) throws IOException, WebApplicationException {
	                os.write(byteArrayOutputStream.toByteArray());
	                os.flush();
	            }
	        };
			
	        

			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
	        

			fileName = fileNamePrefix + "_" + fileNameSuffix +  commonUtils.genTimestampString() + ZIP_EXT;

	        
	
			ResponseBuilder builder = 
					Response.ok(stream, MediaType.APPLICATION_OCTET_STREAM)
				    .header("content-disposition",
				      "attachment; filename = \"" + fileName + "\"");

			response = builder.build();

		}catch (Exception e){
			logger.error(getClassName() + ".requestPatrolRoutineExcel() - tableName=" + tableName , e);
		}
		return response;
	}
	
//	 @GET
//	 @Path("/download")
//	 public Response downloadPdfFile() {
//	  StreamingOutput fileStream = new StreamingOutput() {
//	   @Override
//	   public void write(java.io.OutputStream output) throws IOException,
//	     WebApplicationException {
//	    try {
//	     java.nio.file.Path path = Paths.get("/Report/patrol_excel20180802142602.xlsx");
//	     byte[] data = Files.readAllBytes(path);
//	     output.write(data);
//	     output.flush();
//	    } catch (Exception e) {
//	     throw new WebApplicationException("File Not Found !!");
//	    }
//	   }
//	  };
//	  return Response
//	    .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
//	    .header("content-disposition",
//	      "attachment; filename = patrol.xlsx").build();
//	 }
	
}
