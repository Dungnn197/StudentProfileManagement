package model.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import model.entity.class_detail.ClassDetails;
import utility.Utility;

public class ClassDetailDAO {


	private String path;

	public ClassDetailDAO(String path) {
		this.path = path;
	}

	public List<ClassDetails.ClassDetail> getClassDetail() throws JAXBException {
		File file = new File(path + "WEB-INF/XML_DB/ClassDetails.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(ClassDetails.class);
		ClassDetails classDetails = (ClassDetails) jaxbContext.createUnmarshaller().unmarshal(file);
		return classDetails.getClassDetail();
	}
}
