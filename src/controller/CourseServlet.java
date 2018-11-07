package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import model.dao.CourseDAO;
import model.dao.GroupDAO;
import model.dao.StudentAttendanceDAO;
import model.entity.course.Courses;
import model.entity.group.Groups;
import model.entity.student_attdendance.StudentAttendances;
import model.entity.student_attdendance.StudentAttendances.StudentAttendance;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String webRoot = getServletContext().getRealPath("");
		
		try {
			String courseId = "MLN101";
			String groupId = "IS1104";
			String filterdCourse = courseId;
			String filterdGroup = groupId;
			
			List<Courses.Course> courses = new ArrayList<Courses.Course>();
			List<Groups.Group> groups = new ArrayList<Groups.Group>();
			List<StudentAttendances.StudentAttendance> studentAttendances = new ArrayList<StudentAttendances.StudentAttendance>();
			
			if (request.getParameter("courseId") != null && request.getParameter("groupId") != null) {
				courseId = request.getParameter("courseId");
				groupId = request.getParameter("groupId");
				filterdCourse = courseId;
				filterdGroup = groupId;
				studentAttendances = new StudentAttendanceDAO(webRoot).filterStudentAttendance(courseId, groupId);
			} else {
				studentAttendances = new StudentAttendanceDAO(webRoot).getStudentAttendance();
			}			
			
			courses = new CourseDAO(webRoot).getCourses();
			groups = new GroupDAO(webRoot).getGroups();
			
			request.setAttribute("filteredCourse", filterdCourse);
			request.setAttribute("filteredGroup", filterdGroup);
			request.setAttribute("courses", courses);
			request.setAttribute("groups", groups);
			request.setAttribute("studentAttendances", studentAttendances);
			request.getRequestDispatcher("AttendanceDetail.jsp").forward(request, response);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

