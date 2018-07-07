package com.tcs.login.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.login.service.UserService;

public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession(false);
			if(session==null){
				response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + request.getContextPath());
			}
			else if(session.getAttribute("token")==null){
				response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + request.getContextPath());
			}
			else if(request.getPathInfo()!=null && request.getPathInfo().equals("/logout")){
				session.invalidate();
				Thread.sleep(1000);
				response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + request.getContextPath());
			}
			else if(request.getPathInfo()!=null && request.getPathInfo().equals("/view")){
				session.setAttribute("html", "<h1>Welcome to the home page</h1>");
				request.getRequestDispatcher("/view/home.jsp").include(request, response);
			}			
			else if(request.getPathInfo()!=null && request.getPathInfo().equals("/about")){
				session.setAttribute("html", "<h1>Welcome to the about page</h1>"
						+ "<article>Tata Consultancy Services Limited is an Indian multinational information technology service"
						+ ", consulting and business solutions company headquartered in Mumbai, Maharashtra. "
						+ "It is a subsidiary of the Tata Group and operates in 46 countries.</article>");
				request.getRequestDispatcher("/view/home.jsp").include(request, response);
			}
			else if(request.getPathInfo()!=null && request.getPathInfo().equals("/users")){
				session.setAttribute("html", new UserService().getUserInfo());
				request.getRequestDispatcher("/view/home.jsp").include(request, response);
			}
			else if(request.getPathInfo()!=null && request.getPathInfo().equals("/contact")){
				session.setAttribute("html", "<h1>Welcome to the contact page</h1>");
				request.getRequestDispatcher("/view/home.jsp").include(request, response);
			}
			else{
				request.getRequestDispatcher("/view/error.jsp").include(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
