package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.Action;
import member.vo.ActionForward;

/**
 * Servlet implementation class AdminFrontController
 */
@WebServlet("*.admin")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("utf-8");
    	
		Action action = null;
		ActionForward af = null;
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length());
    	
		if(command.equals("addWord.admin")) {
//			action = new AddWordAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("removeWord.admin")) {
//			action = #;
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("updateWord.admin")) {
//			action = #;
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("addKind.admin")) {
//			action = #;
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("removeKind.admin")) {
//			action = #;
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("updateKind.admin")) {
//			action = #;
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("viewAllMember.admin")) {
//			action = #;
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("viewOneMember.admin")) {
//			action = #;
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		if(af != null) {
    		if(af.isRedirect()) {
    			response.sendRedirect(af.getResUrl());
    		}else {
    			RequestDispatcher rdp = request.getRequestDispatcher(af.getResUrl());
    			rdp.forward(request, response);
    		}    		
    	}
		
	}

}
