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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("msg", "abcde");
		request.getRequestDispatcher("/WEB-INF/join.jsp").forward(request,response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("Pw");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPw(pw);
		user.setEmail(email);
		
		// 데이터베이스에 정보를 저장
		UserDao dao = new UserDao();
		if (dao.insertMember(user)) {		// 회원 조회 페이지로 
			response.sendRedirect(request.getContextPath() + "/list");
		} else {	// 다시 등록페이지로 
			request.setAttribute("error", "등록이 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/join.jsp").forward(request, response);
		}
	}

}
