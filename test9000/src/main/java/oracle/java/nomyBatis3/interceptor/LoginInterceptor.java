package oracle.java.nomyBatis3.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter implements SessionNames{
	@Override				
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//로그인이 되어있는지 확인
		HttpSession httpsession = request.getSession();
		
		if(httpsession.getAttribute(LOGIN) != null){
			httpsession.removeAttribute(LOGIN);
		}
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		
		HandlerMethod method = (HandlerMethod) handler;
		System.out.println("mmmm>BEAN : " +method.getBean() + ", METHOD : " +method.getMethod());
		System.out.println("mmmm>Model : " +modelAndView);
		
		HttpSession httpsession = request.getSession();
		
		Object member = modelAndView.getModelMap().get("member");
		System.out.println("LoginInterceptor.post >> " +member);
		
		if(member != null){
			httpsession.setAttribute(LOGIN, member);
			
			Cookie loginCookie = new Cookie("loginCookie", httpsession.getId());
			loginCookie.setPath("/");
			loginCookie.setMaxAge(7*24*60*60);
			response.addCookie(loginCookie);
			
		}
	}

}
