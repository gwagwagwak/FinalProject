package oracle.java.nomyBatis3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oracle.java.nomyBatis3.model.CardVO;
import oracle.java.nomyBatis3.model.QnaVO;
import oracle.java.nomyBatis3.service.AutoPayService;
import oracle.java.nomyBatis3.service.CardService;
import oracle.java.nomyBatis3.service.MemberService;
import oracle.java.nomyBatis3.service.Pager;
import oracle.java.nomyBatis3.service.PayListService;
import oracle.java.nomyBatis3.service.QnaCommentService;
import oracle.java.nomyBatis3.service.QnaMainService;
import oracle.java.nomyBatis3.service.QnaService;

@Controller
public class CardController {
	@Autowired
	private MemberService ms;
	@Autowired
	private AutoPayService as;
	@Autowired
	private CardService cservice;
	@Autowired
	private PayListService ps;
	@Autowired
	private QnaCommentService qcs;
	@Autowired
	private QnaMainService qms;
	@Autowired
	private QnaService qs;
	
	
	
	
	ModelAndView mv;
	
	//카드 한개 정보 가져오기
	@RequestMapping(value = "getCardList.do")
	public ModelAndView getcardlistHandle(@RequestParam String c_username) throws Exception {
		
		List<CardVO> clist = cservice.getCardList(c_username);		//
		
		System.out.println("qnalist목록 생성 완료");
		
		mv = new ModelAndView();
		mv.setViewName("이동할 jsp 페이지 이름만 쓰시오");

		// 리스트의 데이터가 많아서 해쉬맵에 담는게 효율적이다.
		Map<String, Object> map = new HashMap<>();
		map.put("clist", clist);

		mv.addObject("map", map); // 데이터 저장
		
			
		return mv;
		
		/*
	 	jsp 페이지로 값을 넘겨준 뒤
	   
	   	페이지에서는 jstl을 이용하여 ${map.clist} 로 리스트를 불러와서 반복문을 이요하여 사용할 수 있다.
	   	
	   
	   	예시!!!!!!
	   	
	   	<c:forEach var="row" items="${map.list}">
						<tr>
							<td class="number_dot">${row.q_no}</td>
							<td>${row.q_divide}</td>
							<td><c:choose>
									<c:when test="${row.q_private eq '비밀글'}">
										${row.q_title} <span class="glyphicon glyphicon-ok"></span>
									</c:when>
									<c:when test="${row.q_private eq '공개글'}">
										<a href="qnaRead.do?q_no=${row.q_no} &curPage=${map.pager.curPage}">${row.q_title} </a>
									</c:when>
									<%-- <c:otherwise> ... </c:otherwise> --%>
								</c:choose></td>
							<td>${row.q_writer}</td>
							<td><fmt:formatDate value="${row.q_date}"
									pattern="yyyy-MM-dd" /></td>
							<!--pattern="yyyy-MM-dd HH:mm:ss"  -->
							<td>${row.q_complete}</td>
						</tr>
					</c:forEach>

	  	
	 */
	}
	
	@RequestMapping(value = "getCard.do")
	public ModelAndView getcardHandle(@RequestParam int c_number) throws Exception {
		
		mv = new ModelAndView();
		mv.setViewName("이동할 jsp 페이지 이름만 쓰시오");
		
		mv.addObject("cvo", cservice.getCard(c_number));
		return mv;
	}
	
	
	
	
	
	
	

	@RequestMapping(value = "registCard.do")
	public ModelAndView registcardHandle(@ModelAttribute CardVO card) throws Exception {
		//넘겨받은 값에의해 자동으로 객체 생성
		
		
		mv = new ModelAndView();
		mv.setViewName("이동할 jsp 페이지 이름만 쓰시오");
		
		

		//확인
		System.out.println(card.toString());
		
		cservice.registCard(card);
		
	/*	
		mv.addObject("cvo", map);
		mv.addObject("cvo", cservice.getCard(1));*/
		return mv;
		
	}
	

	//아마 수정 필요...?
	@RequestMapping(value = "updateCard.do")
	public ModelAndView updatecardHandle(@ModelAttribute CardVO card) throws Exception {
		//자동 주입으로 만료일, 보안코드, 주소 값이 들어간 CardVO 객체 card가 생성
		mv = new ModelAndView();
		mv.setViewName("이동할 jsp 페이지 이름만 쓰시오");
		
		//확인
		System.out.println(card.toString());
		
		
		cservice.updateCard(card);
		
		return mv;
	}
	
	
	
	
	//아마 수정 필요...?
	@RequestMapping(value = "deleteCard.do")
	public ModelAndView deletecardHandle(@RequestParam int c_number) throws Exception {
		
		mv = new ModelAndView();
		mv.setViewName("이동할 jsp 페이지 이름만 쓰시오");
		
		
		
		cservice.deleteCard(c_number);
		
		
		return mv;
	}
	
	
}
