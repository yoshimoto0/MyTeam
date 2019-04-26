package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.Action;
import member.action.CreateAction;
import member.action.LoginAction;
import member.action.LogoutAction;
import member.action.SearchAction;
import member.action.SearchFormAction;
import member.action.UpdateAction;
import member.action.UpdateFormAction;
import member.vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.member")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcesser(request, response);	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doProcesser(request, response);
	}
	public void doProcesser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8"); 
		     	 
		 		Action action = null; 
		 		ActionForward af = null; 
		     	 
		     	String requestURI = request.getRequestURI(); 
		     	String contextPath = request.getContextPath(); 
		     	String command = requestURI.substring(contextPath.length()); 
		     	System.out.print(command+"로이동");
				if(command.equals("/create.member")) { 
					action = new CreateAction();//회원가입
					try { 
		 				af = action.execute(request, response); 
		 			} catch (Exception e) { 
		 				e.printStackTrace(); 
		 			} 
		 		}else if(command.equals("/searchForm.member")) {//아이디,비밀번호찾기폼
					action = new SearchFormAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 
				}else if(command.equals("/sesrchAction.member")) {//아이디,비밀번호찾기
					action = new SearchAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 
				}else if(command.equals("/login.member")) {//로그인
					action = new LoginAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 	
				}else if(command.equals("/updateAction.member")) {//회원정보수정
					action = new UpdateAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 	
				}else if(command.equals("/updateForm.member")) {//회원정보수정폼
					action = new UpdateFormAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 	
				}else if(command.equals("/logout.member")) {//로그아웃
					action = new LogoutAction();
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