package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import model.dao.ClassDetailDAO;
import model.entity.class_detail.ClassDetails;

/**
 * Servlet implementation class ClassDetails
 */
@WebServlet("/ClassDetails")
public class ClassDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String webRoot = getServletContext().getRealPath("");
		try{
			List<ClassDetails.ClassDetail> classDetail = new ClassDetailDAO(webRoot).getClassDetail();
			request.setAttribute("classDetails", classDetail);
			request.getRequestDispatcher("ClassDetail.jsp").forward(request, response);
		} catch(JAXBException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
