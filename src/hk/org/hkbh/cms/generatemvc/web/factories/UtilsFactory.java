package hk.org.hkbh.cms.generatemvc.web.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hk.org.hkbh.cms.generatemvc.web.utils.CalendarUtils;
import hk.org.hkbh.cms.generatemvc.web.utils.CommonUtils;
import hk.org.hkbh.cms.generatemvc.web.utils.DateUtils;
import hk.org.hkbh.cms.generatemvc.web.utils.FileUtils;
import hk.org.hkbh.cms.generatemvc.web.utils.MiscUtils;

public class UtilsFactory {
	private final static Logger logger = LoggerFactory.getLogger(getClassName());
	private static UtilsFactory generalUtilsFactory;
	private static MiscUtils miscUtils;
	private static CalendarUtils calendarUtils;
	private static CommonUtils commonUtils;
	private static DateUtils dateUtils;
	private static FileUtils fileUtils;
	public static String getClassName() {
		String className = UtilsFactory.class.getName();
		return className;
	}
	public CommonUtils getInstanceOfCommonUtils()
	{
		if (commonUtils == null) {
			commonUtils = new CommonUtils();
		}
		return commonUtils;
	}
	public static UtilsFactory getInstance() {
		if (generalUtilsFactory == null) {
			generalUtilsFactory = new UtilsFactory();
		}
		return generalUtilsFactory;
	}
	public MiscUtils getInstanceOfMiscUtils() {
		if (miscUtils == null) {
			miscUtils = new MiscUtils();
		}
		return miscUtils;
	}
	public CalendarUtils getInstanceOfCalendarUtils() {
		if (calendarUtils == null) {
			calendarUtils = new CalendarUtils();
		}
		return calendarUtils;
	}
	public DateUtils getInstanceOfDateUtils() {
		if (dateUtils == null) {
			dateUtils = new DateUtils();
		}
		return dateUtils;
	}
	public FileUtils getInstanceOfFileUtils() {
		if (fileUtils == null) {
			fileUtils = new FileUtils();
		}
		return fileUtils;
	}
}
