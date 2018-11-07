package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import model.dao.ProfileDAO;
import model.entity.student.Students.Student;
import utility.Constants;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String webRoot = getServletContext().getRealPath("");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute(Constants.SESSION_EMAIL);
		try {
			Student student = new ProfileDAO(webRoot).getStudentInfo(email);
			response.setContentType("text/html; charset=utf-8");
			request.setAttribute("student", student);
			request.getRequestDispatcher("MyProfile.jsp").forward(request, response);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
