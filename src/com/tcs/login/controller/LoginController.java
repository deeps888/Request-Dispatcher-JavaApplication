package com.tcs.login.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		try{
			res.setContentType("text/html");
			String user = req.getParameter("username");
			String password = req.getParameter("password");			
			HttpSession session = req.getSession(false);
			if(session!=null && user!=null && password!=null && !user.trim().isEmpty() && !password.trim().isEmpty()){
				session.setAttribute("user", user);
				session.setAttribute("token", session.getId());
				res.sendRedirect(req.getContextPath()+"/home/view");
			}
			else{
				PrintWriter out = res.getWriter();
				out.println("<center><b style=\"color:red\">Username/Password not proper.</b></center>");
				req.getRequestDispatcher("/view/login.jsp").include(req, res);
				out.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
