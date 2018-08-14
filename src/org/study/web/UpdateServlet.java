package org.study.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.study.dao.UserDao;
import org.study.model.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateMember")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if (id != null) {
			UserDao dao = new UserDao();
			User user = dao.getMember(id);
			
			request.setAttribute("user", user);
		} else {
			request.setAttribute("user", null);
		}
		
		request.getRequestDispatcher("/WEB-INF/updateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPw(pw);
		user.setEmail(email);
		
		UserDao dao = new UserDao();
		if (dao.updateUser(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "success");
			response.sendRedirect(request.getContextPath() + "/list");
		} else {
			request.setAttribute("user", user);
			request.setAttribute("error", "정보 수정에 실패했습니다");
			request.getRequestDispatcher("/WEB-INF/updateForm.jsp").forward(request, response);
		}
	}

}
