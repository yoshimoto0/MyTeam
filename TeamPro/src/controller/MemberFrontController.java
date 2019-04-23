package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.action.CreateAction;
import member.action.CreateFormAction;
import member.action.LoginAction;
import member.action.SherchAction;
import member.action.UpdateAction;
import member.action.AdminShowAction;
import member.action.Action;
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
		     	 
				if(command.equals("create.member")) { 
					action = new CreateAction();//회원가입
					try { 
		 				af = action.execute(request, response); 
		 			} catch (Exception e) { 
		 				e.printStackTrace(); 
		 			} 
		 		}else if(command.equals("createform.member")) {//회원가입폼이동
		 			action = new CreateFormAction();
					try { 
		 				af = action.execute(request, response); 
		 			} catch (Exception e) { 
		 				e.printStackTrace(); 
		 			} 
				}else if(command.equals("sherch.member")) {//아이디,비밀번호찾기
					action = new SherchAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 
				}else if(command.equals("allshow.member")) {//관리자 회원정보 전체보기
					action = new AdminShowAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 	
				}else if(command.equals("login.member")) {//로그인
					action = new LoginAction();
					try { 
						af = action.execute(request, response); 
					} catch (Exception e) { 
						e.printStackTrace(); 
					} 	
				}else if(command.equals("update.member")) {//회원정보수정
					action = new UpdateAction();
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