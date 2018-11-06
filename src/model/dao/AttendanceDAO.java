package model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import jdk.nashorn.internal.runtime.ListAdapter;
import model.entity.account.Account;
import model.entity.account.Accounts;
import model.entity.attendance.Attendances;

public class AttendanceDAO {
	private String path;

	public AttendanceDAO(String path) {
		this.path = path;
	}
	
	public List<Attendances.Attendance> allAttendance() throws JAXBException{
		return unmashaller();
	}
	
	//Attendance by StudentId And Course
	public List<Attendances.Attendance> attenByStuIdAndCourse(String stuId,String cId) throws JAXBException{
		List<Attendances.Attendance> list=new ArrayList<>();
		for(Attendances.Attendance a : unmashaller()){
			if(a.getStudentId().equalsIgnoreCase(stuId) && a.getAttendance_Course().equalsIgnoreCase(cId) ){
				list.add(a);
			}
		}
		return list;
	}
	
	//Attendance by StudentId And Course AND Status
	public List<Attendances.Attendance> attenByStatus(List<Attendances.Attendance> arr,int status) throws JAXBException{
		List<Attendances.Attendance> list=new ArrayList<>();
		for(Attendances.Attendance a : arr){
			if(a.getAttendance_Status()==status){
				list.add(a);
			}
		}
		return list;
	}
	
	//Get Attendance Present/Absent
	public List<Attendances.Attendance> attendanceFilter(int check) throws JAXBException{
		List<Attendances.Attendance> arrFilter=new ArrayList<>();
		for(Attendances.Attendance a:unmashaller()){
			if(a.getAttendance_Status()==check){
				arrFilter.add(a);
			}
		}
		return arrFilter;
	}
	
	//Calculate % absent
	public int percentAbsent(int i,int total){
		int num=0;
		num=i*100/total;
		return num;
	}
	
	private List<Attendances.Attendance> unmashaller() throws JAXBException {
		File file = new File(path + "WEB-INF/XML_DB/Attendances.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Attendances.class);
		Attendances attendances = (Attendances) jaxbContext.createUnmarshaller().unmarshal(file);
		return attendances.getAttendance();
	}
}
