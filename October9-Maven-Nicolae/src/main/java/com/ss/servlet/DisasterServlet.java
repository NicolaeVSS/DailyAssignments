package com.ss.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ss.dto.LoginInfo;

@WebServlet(urlPatterns = {"/login","/login/"})
public class DisasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisasterServlet() {
        super();
    }

    public void init() 
    {
    	System.out.println("*****************************");
    	System.out.println("**  LoginServlet Starting  **");
    	System.out.println("*****************************");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// create our list of valid logins
		List<LoginInfo> logins = new ArrayList<LoginInfo>();
		logins.add(new LoginInfo("user1", "pass1"));
		logins.add(new LoginInfo("user2", "pass2"));
		
		Gson gson = new Gson();
		
		final LoginInfo sentData = gson.fromJson(request.getReader(), LoginInfo.class);

		if(sentData == null || sentData.getUsername() == null || sentData.getPassword() == null) 
		{
			log("null data recieved");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		log("Data sent: " + sentData.getUsername() + " " + sentData.getPassword());
		
		logins = logins.stream().filter(ele -> ele.equals(sentData)).collect(Collectors.toList());

		if(logins.size() == 1)
		{
			response.getWriter().print("Success! Welcome " + logins.get(0).getUsername());
		}
		else if(logins.size() == 0)
		{
			response.getWriter().print("Failure!");
		}
		else 
		{
			log("More than one user with:" + sentData.getUsername() + " " + sentData.getPassword());
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
