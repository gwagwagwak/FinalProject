package oracle.java.nomyBatis3.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter implements SessionNames{
	
	
	@Override				
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//LOGIN = "loginMember"
		//LOGIN_COOKIE = "loginCookie"
		//ATTEMPTED = "attemptedLocation";
		
		System.out.println("prehandle 접근");
		//로그인이 되어있는지 확인
		HttpSession httpsession = request.getSession();
		
		if(httpsession.getAttribute(LOGIN) != null){		//로그인이 되어있는 상태면 세션을 없앤다.
			httpsession.removeAttribute(LOGIN);
		}
		return true;
	}
	
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			
		HandlerMethod method = (HandlerMethod) handler;
		System.out.println("mmmm>BEAN : " +method.getBean() + ", METHOD : " +method.getMethod());
		System.out.println("mmmm>Model : " +modelAndView);
		HttpSession httpsession = request.getSession();
		
		
		//로그인이 성공할 경우 컨트롤러 에서 model.addattribute 로 member객체 값을 받아서 member객체에 저장한다.(일회용이기 때문)
		Object member = modelAndView.getModelMap().get("member"); 
			
		//로그인이 성공했으면 
		//LOGIN이라는 값으로 session에 값이 들어간것이다. 이건 jsp에서 쓸 때는 ${loginMember}로 써야 한다. 
		if(member != null){
				httpsession.setAttribute(LOGIN, member);			
			
			if (StringUtils.isNotEmpty(request.getParameter("useCookie"))){
				Cookie loginCookie = new Cookie("loginCookie", httpsession.getId());
				loginCookie.setPath("/");			//도메인별로 키가 생긴다.
				loginCookie.setMaxAge(7*24*60*60);	//쿠키의 유효 기간 (일주일)
				
				response.addCookie(loginCookie);	//응답이 나갈 때 response에서 쿠키를 담고 나가게 된다.
			}
			// 만약 로그인 페이지를 검사하도록 하려면은
			String attempted =(String)httpsession.getAttribute(ATTEMPTED);
			if(StringUtils.isNotEmpty(attempted)){
				response.sendRedirect(attempted);	//가려는 경로로 이동
				httpsession.removeAttribute(ATTEMPTED);
			}
			else{ //딱히 보내주려는 곳이 없으면 컨트롤러로 이동한다.
				response.sendRedirect("loginSuccess.do");
			}
			
			
			
			/*
			//로그인 성공시 보내주는 컨트롤러 위치
			response.sendRedirect("loginSuccess.do");*/
			
		}
		//로그인 실패시 
		else{
			//httpsession.setAttribute("loginResult", "Login Fail!"); 
			response.sendRedirect("loginFail.do");
		}
		
	}

}
