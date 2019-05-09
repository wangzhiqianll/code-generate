package com.utils;

import com.constant.GenEnum;
import com.domain.Column;
import com.domain.Table;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.*;

/**
 * 
 * @Description 生成工具
 * @author ansen.zhu
 * @date 2019年3月18日
 */
@Slf4j
public class GenUtils {

	private static List<String> getTemplates() {
		List<String> templates = new ArrayList<>();
		templates.add(GenEnum.APICONTROLLER.getFileName());
		templates.add(GenEnum.APISERVICE.getFileName());
		templates.add(GenEnum.BEAN.getFileName());
		templates.add(GenEnum.BO.getFileName());
		templates.add(GenEnum.VO.getFileName());
		templates.add(GenEnum.DAO.getFileName());
		templates.add(GenEnum.MAPPER.getFileName());
		templates.add(GenEnum.SERVICE.getFileName());
		templates.add(GenEnum.IMPL.getFileName());
		templates.add(GenEnum.GATECONTROLLER.getFileName());
		templates.add(GenEnum.PAGEQUERY.getFileName());
		templates.add(GenEnum.PAGEVO.getFileName());
		return templates;
	}

	/**
	 * 在对应的模块生成代码
	 *
	 * @param tableName
	 * @param columns
	 */
	public static void generate(String tableName, List<Column> columns) {
		Configuration config = getConfig();
		disposeColumns(columns, config);
		String className = tableToJava(tableName);
		Table table = Table.builder().tableName(tableName).uppercaseClassName(className)
				.lowercaseClassName(StringUtils.uncapitalize(className)).columns(columns).pk(columns.get(0)).build();

		VelocityContext context = getVelocityContext(table, config);
		List<String> templates = getTemplates();
		for (String template : templates) {
			StringWriter sw = new StringWriter();
			Template tpl = Velocity.getTemplate(template, "UTF-8");
			tpl.merge(context, sw);
			byte[] bytes = sw.toString().getBytes();
			String packageName = config.getString("package")
					.substring(config.getString("package").lastIndexOf(".") + 1);
			createFolderAndFile(bytes, template, className, packageName, config.getString("project"));
		}
	}

	private static void disposeColumns(List<Column> columns, Configuration config) {
		for (Column column : columns) {
			String attrName = columnToJava(column.getColumnName());
			column.setUppercaseAttrName(attrName);
			column.setLowercaseAttrName(StringUtils.uncapitalize(attrName));
			String javaDataType = config.getString(column.getColumnDataType(), "unknownType");
			column.setJavaDataType(javaDataType);
		}
	}

	/**
	 * 设置velocity资源加载器
	 */
	private static void setProperties() {
		Properties prop = new Properties();
		prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(prop);
	}

	/**
	 * 设置velocity资源加载器 , 封装模板数据
	 *
	 * @param table
	 * @param config
	 * @return
	 */
	private static VelocityContext getVelocityContext(Table table, Configuration config) {
		setProperties();
		Map<String, Object> velocityMap = new HashMap<>(16);
		velocityMap.put("tableName", table.getTableName());
		velocityMap.put("pk", table.getPk());
		velocityMap.put("className", table.getUppercaseClassName());
		velocityMap.put("classname", table.getLowercaseClassName());
		velocityMap.put("pathName", config.getString("package").substring(config.getString("package").lastIndexOf(".") + 1));
		velocityMap.put("package", config.getString("package"));
		velocityMap.put("columns", table.getColumns());
		velocityMap.put("datetime", DateUtils.formatDateTime(new Date()));
		velocityMap.put("project", config.getString("project"));
		velocityMap.put("service", config.getString("service"));
		velocityMap.put("controller", config.getString("controller"));
		velocityMap.put("dao", config.getString("dao"));
		velocityMap.put("domain", config.getString("domain"));
		velocityMap.put("model", config.getString("model"));
		velocityMap.put("modelname", config.getString("modelname"));
		return new VelocityContext(velocityMap);
	}

	/**
	 * 列名转换成Java属性名
	 */
	private static String columnToJava(String columnName) {
		return WordUtils.capitalizeFully(columnName, new char[] { '_' }).replace("_", "");
	}

	/**
	 * 表名转换成Java类名
	 */
	private static String tableToJava(String tableName) {
		return columnToJava(tableName);
	}

	/**
	 * 获取配置信息 TODO yml形式
	 */
	private static Configuration getConfig() {
		try {
			return new PropertiesConfiguration("generator.properties");
		} catch (ConfigurationException e) {
			throw new RuntimeException("获取配置文件失败，", e);
		}
	}

	/**
	 * 创建文件夹和文件
	 *
	 * @param bytes
	 * @param template
	 * @param className
	 * @param packageName
	 */
	private static void createFolderAndFile(byte[] bytes, String template, String className, String packageName,
			String projectName) {
		String basePath = "src" + File.separator + "main" + File.separator;
		String packagePath = basePath + "java" + File.separator+"gen"+File.separator;
		String folderName, fileName;
		if (StringUtils.isNotBlank(packageName)) {
			packagePath += packageName.replace(".", File.separator) + File.separator;
		}

		if (template.contains("Bean.java.vm")) {
			folderName = packagePath + projectName + File.separator + "persistence" + File.separator + "bean"
					+ File.separator;
			fileName = folderName + className + ".java";
		} else if (template.contains("Mapper.java.vm")) {
			folderName = packagePath + projectName + File.separator + "persistence" + File.separator + "mapper"
					+ File.separator;
			fileName = folderName + className + "Mapper.java";
		} else if (template.contains("Service.java.vm")) {
			folderName = packagePath + projectName + File.separator + "biz" + File.separator + "service"
					+ File.separator;
			fileName = folderName + className + "BizService.java";
		} else if (template.contains("ServiceImpl.java.vm")) {
			folderName = packagePath + projectName + File.separator + "biz" + File.separator + "service"
					+ File.separator;
			fileName = folderName + className + "BizServiceImpl.java";
		} else if (template.contains("BO1.java.vm")) {
			folderName = packagePath + projectName + File.separator + "api" + File.separator + "bo" + File.separator;
			fileName = folderName + className + "BO.java";
		} else if (template.contains("PageQueryBO.java.vm")) {
			folderName = packagePath + projectName + File.separator + "api" + File.separator + "bo" + File.separator;
			fileName = folderName + className + "PageQueryBO.java";
		}else if (template.contains("PageVO.java.vm")) {
			folderName = packagePath + projectName + File.separator + "api" + File.separator + "vo" + File.separator;
			fileName = folderName + className + "PageVO.java";
		}else if (template.contains("VO1.java.vm")) {
			folderName = packagePath + projectName + File.separator + "api" + File.separator + "vo" + File.separator;
			fileName = folderName + className + "VO.java";
		}else if (template.contains("ApiCervice.java.vm")) {
			folderName = packagePath + projectName + File.separator + "api" + File.separator + "service" + File.separator;
			fileName = folderName + className + "ApiService.java";
		} else if (template.contains("ApiController.java.vm")) {
			folderName = packagePath + projectName + File.separator + "api" + File.separator + "controller" + File.separator;
			fileName = folderName + className + "ApiController.java";
		} else if (template.contains("GateController.java.vm")) {
			folderName = packagePath + projectName + File.separator + "api" + File.separator + "controller" + File.separator;
			fileName = folderName + className + "Controller.java";
		}else if (template.contains("Mapper.xml.vm")) {
			folderName = basePath + "resources" + File.separator + "mapper" + File.separator;
			fileName = folderName + className + "Mapper.xml";
		} else {
			return;
		}
		createFolderIfNotExists(folderName);
		newFile(bytes, fileName);

	}

	/**
	 * 创建文件夹
	 *
	 * @param folderName
	 */
	private static void createFolderIfNotExists(String folderName) {
		File file = new File(folderName);
		if (!file.exists()) {
			boolean result = file.mkdirs();
			log.info("create folder name:{} is {}", folderName, result);
		}
	}

	/**
	 * 创建文件
	 *
	 * @param bytes
	 * @param fileName
	 */
	private static void newFile(byte[] bytes, String fileName) {
		try {
			System.out.println(System.getProperty("java.class.path"));
			File newFile = new File(fileName);
			FileOutputStream fop = new FileOutputStream(newFile);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			fop.write(bytes);
			fop.flush();
			fop.close();
			log.info("fileName: {}, created success", fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
