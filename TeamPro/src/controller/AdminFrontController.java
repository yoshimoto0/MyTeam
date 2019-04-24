package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.Action;
import admin.action.AddKindAction;
import admin.action.AddNoticeAction;
import admin.action.RemoveKindAction;
import admin.action.RemoveNoticeAction;
import admin.action.RemoveWordAction;
import admin.action.RequestRemoveAction;
import admin.action.ViewRequestAction;
import admin.action.AdminViewAction;
import admin.action.MemberUpgradeAction;
import admin.vo.ActionForward;

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
    	
		if(command.equals("/addNotice.admin")) {//이벤트/공지사항 추가 기능
			action = new AddNoticeAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/removeNotice.admin")) {//이벤트/공지사항 삭제 기능
			action = new RemoveNoticeAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/removeWord.admin")) {//단어삭제기능
			action = new RemoveWordAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/addKind.admin")) {//종류추가기능
			action = new AddKindAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/removeKind.admin")) {//종류 삭제 기능
			action = new RemoveKindAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/adminView.admin")) { //단어회원색기능
			action = new AdminViewAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/viewRequest.admin")) { //문의사항보기
			action = new ViewRequestAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/removeRequest.admin")) { //문의사항처리--> 삭제
			action = new RequestRemoveAction();
			try {
				af = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/memberupgrade.admin")) { //관리자권한주기
			action = new MemberUpgradeAction();
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
