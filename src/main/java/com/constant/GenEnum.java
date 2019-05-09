package com.constant;


/**
 * 
 * @Description 常量枚举类
 * @author ansen.zhu
 * @date 2019年3月19日
 */
public enum GenEnum {
    BEAN("template/Bean.java.vm"),
    BO("template/BO1.java.vm"),
    VO("template/VO1.java.vm"),
    APISERVICE("template/ApiCervice.java.vm"),
    APICONTROLLER("template/ApiController.java.vm"),
    DAO("template/Mapper.java.vm"),
    SERVICE("template/Service.java.vm"),
    IMPL("template/ServiceImpl.java.vm"),
    MAPPER("template/Mapper.xml.vm"),
	GATECONTROLLER("template/GateController.java.vm"),
	PAGEQUERY("template/PageQueryBO.java.vm"),
	PAGEVO("template/PageVO.java.vm");

    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    GenEnum(String fileName) {
        this.fileName = fileName;
    }

}
