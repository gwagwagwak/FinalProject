package oracle.java.nomyBatis3.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter implements SessionNames{
	//요청이 들어가기전에 로그인 체크만 하는 역할의 인터셉터
	
	@Override				
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//LOGIN = "loginMember"
		//LOGIN_COOKIE = "loginCookie"
		//ATTEMPTED = "attemptedLocation"
		
		System.out.println("prehandle 접근");
		//로그인이 되어있는지 확인
		HttpSession httpsession = request.getSession();
		
		if(httpsession.getAttribute(LOGIN) == null){		//로그인이 안 되어있는 상태면 세션을 없앤다.
			//httpsession.removeAttribute(LOGIN);
			String uri = request.getRequestURI();	//거쳐간 uri
			String query = request.getQueryString();	//uri에 같이 딸려온 쿼리문
			if(StringUtils.isNotEmpty(query)){
				uri += "?" +query; }
			
			httpsession.setAttribute(ATTEMPTED, uri);	//session에 uri정보 저장
			
			response.sendRedirect("loginForm.do");
		}
		return true;
	}
	
	


}
