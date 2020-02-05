package hk.org.hkbh.cms.generatemvc.web.services;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.models.dtos.CompressFileDto;

import hk.org.hkbh.cms.generatemvc.web.factories.UtilsFactory;
import hk.org.hkbh.cms.generatemvc.web.utils.CommonUtils;

public class CompressionMgr {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String getClassName(){
		String className = this.getClassName();
		return className;
	}
	public ByteArrayOutputStream compressByteArrayOutputStreamList(List<CompressFileDto> compressFileDtoList) throws Exception {
		ByteArrayOutputStream outByteArrayOutputStream = null;
		try{
			UtilsFactory utilsFactory = UtilsFactory.getInstance();
			CommonUtils commonUtils = utilsFactory.getInstanceOfCommonUtils();
			outByteArrayOutputStream = new ByteArrayOutputStream();
			commonUtils.compressBytes(outByteArrayOutputStream, compressFileDtoList);
		} catch (Exception e){
			logger.error(getClassName() + ".compressByteArrayOutputStreamList()");
			throw e;
		}
		return outByteArrayOutputStream;
	}
}
