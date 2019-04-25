package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.action.Action;
import word.action.AddNewWordAction;
import word.action.AllWordAction;
import word.action.DeleteWordBookAction;
import word.action.SearchMainWordAction;
import word.action.SearchWordAction;
import word.action.ViewOwnWordBookAction;
import word.action.addWordToBookAction;
import word.action.createWordBookAction;
import word.action.openMainAction;
import word.vo.ActionForward;

/**
 * Servlet implementation class WordFrontController
 */
@WebServlet("*.word")
public class WordFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordFrontController() {
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
		// TODO Auto-generated method stub
    	
    	request.setCharacterEncoding("utf-8");
    	
		Action action = null;
		ActionForward af = null;
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length());
    	
		if(command.equals("/addNewWord.word")) {
			action = new AddNewWordAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/SearchMain.word")) {
			action = new SearchMainWordAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/createWordBook.word")) {
			action = new createWordBookAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/addWordToBook.word")) {
//			action = new addWordToBookAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/main.word")) {
			action = new openMainAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/deleteWordBook.word")) {
			action = new DeleteWordBookAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/viewAllWordBook.word")) {
//			action = new ViewAllWordBookAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/viewOwnWordBook.word")) {
			action = new ViewOwnWordBookAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/viewWordBook.word")) {
//			action = new ViewWordBookAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/allWord.word")) {
			action = new AllWordAction();
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
