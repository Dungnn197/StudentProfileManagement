package model.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import model.entity.student.Students;
import model.entity.student.Students.Student;

public class ProfileDAO {

	private String path;

	public ProfileDAO(String path) {
		this.path = path;
	}

	public Student getStudentInfo(String email) throws JAXBException {
		return unmarshaller().stream().filter(student -> student.getEmail().equals(email)).findAny().orElse(null);
	}

	private List<Student> unmarshaller() throws JAXBException {
		File file = new File(path + "WEB-INF/XML_DB/Students.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
		Students students = (Students) jaxbContext.createUnmarshaller().unmarshal(file);
		return students.getStudent();
	}
}
