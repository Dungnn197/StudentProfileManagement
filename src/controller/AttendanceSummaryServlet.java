package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import jdk.nashorn.internal.runtime.ListAdapter;
import model.dao.AttendanceDAO;
import model.dao.CourseDAO;
import model.entity.attendance.Attendances;
import model.entity.course.Courses;

/**
 * Servlet implementation class AttendanceSummaryServlet
 */
@WebServlet("/AttendanceSummaryServlet")
public class AttendanceSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceSummaryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String sId = "SE05043";
			String course = "DBW301";
			if (request.getParameter("courseId") != null) {
				course = request.getParameter("courseId");
			} 

			List<Attendances.Attendance> arr = new ArrayList<>();
			List<Attendances.Attendance> listFull = new ArrayList<>();
			List<Attendances.Attendance> listAbsent = new ArrayList<>();

			String webRoot = getServletContext().getRealPath("");
			List<Courses.Course> courses = new CourseDAO(webRoot).getCourses();
			AttendanceDAO attDAO = new AttendanceDAO(webRoot);
			listFull = attDAO.attenByStuIdAndCourse(sId, course);
			listAbsent = attDAO.attenByStatus(listFull, 0);

			int percent = attDAO.percentAbsent(listAbsent.size(),
					listFull.size());
			arr = listFull;
			if (request.getParameter("btPresent") != null) {
				arr = attDAO.attenByStatus(
						attDAO.attenByStuIdAndCourse(sId, course), 1);
			}
			if (request.getParameter("btAbsent") != null) {
				arr = listAbsent;
			}

			request.setAttribute("selectedCourse", course);
			request.setAttribute("courses", courses);
			request.setAttribute("allAtt", arr);
			request.setAttribute("absent", listAbsent);
			request.setAttribute("total", listFull);
			request.setAttribute("percent", percent);
			request.getRequestDispatcher("AttendanceSummary.jsp").forward(request, response);
		} catch (JAXBException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}

}
