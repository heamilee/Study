package org.study.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.study.dao.UserDao;
import org.study.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		User[] users = dao.listUser();
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
	}

}
