package model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import model.entity.course.Courses;
import model.entity.student_attdendance.StudentAttendances;

public class StudentAttendanceDAO {
	private String path;

	public StudentAttendanceDAO(String path) {
		this.path = path;
	}
	
	public List<StudentAttendances.StudentAttendance> getStudentAttendance() throws JAXBException {
		File file = new File(path + "WEB-INF/XML_DB/StudentAttendances.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(StudentAttendances.class);
		StudentAttendances studentAttedances = (StudentAttendances) jaxbContext.createUnmarshaller().unmarshal(file);
		return studentAttedances.getStudentAttendance();
	}
	
	public List<StudentAttendances.StudentAttendance> filterStudentAttendance(String courseId, String groupId) throws JAXBException {
		List<StudentAttendances.StudentAttendance> result = new ArrayList<>();
		getStudentAttendance().forEach(sa -> {
			if(sa.getCourseId().equalsIgnoreCase(courseId) && sa.getGroupId().equalsIgnoreCase(groupId)) {
				result.add(sa);
			}
		});
		return result;
	}
}
