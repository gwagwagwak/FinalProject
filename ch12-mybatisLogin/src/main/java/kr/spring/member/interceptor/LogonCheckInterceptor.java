package kr.spring.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogonCheckInterceptor extends HandlerInterceptorAdapter {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("===LogonCheckInterceptor ����===");
		}
		
		//session �˻�
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") == null) {
			//�α����� �ȵǾ������� login.do�� ����
			response.sendRedirect(request.getContextPath() + "/login.do");
			
			return false;
		}
		
		return true;
	}
} 
