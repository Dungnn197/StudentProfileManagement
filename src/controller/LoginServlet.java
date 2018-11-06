package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import model.dao.AccountDAO;
import model.entity.account.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			String webRoot = getServletContext().getRealPath("");
			Account account = new AccountDAO(webRoot).checkAccount(email, password);
			if (account != null) {
				out.println("Successful");
			} else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
				requestDispatcher.include(request, response);
			}
		} catch (JAXBException e) {
			out.println(e.toString());
		} finally {
			out.close();
		}
	}

}
