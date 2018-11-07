package model.dao;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import model.entity.account.Account;
import model.entity.account.Accounts;
import model.entity.course.Courses;

public class CourseDAO {
	
	private String path;

	public CourseDAO(String path) {
		this.path = path;
	}
	
	public List<Courses.Course> getCourses() throws JAXBException {
		File file = new File(path + "WEB-INF/XML_DB/Courses.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Courses.class);
		Courses courses = (Courses) jaxbContext.createUnmarshaller().unmarshal(file);
		return courses.getCourse();
	}
}
