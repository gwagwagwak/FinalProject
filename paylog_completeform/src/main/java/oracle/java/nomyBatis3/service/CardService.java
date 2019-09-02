package oracle.java.nomyBatis3.service;

import java.util.List;

import oracle.java.nomyBatis3.model.CardVO;

public interface CardService {

	// 카드 정보 하나 가져오기
	public CardVO getCard(int c_number) throws Exception;

	// 회원 카드 정보 가져오기
	public List<CardVO> getCardList(String c_username) throws Exception;

	// 카드 등록
	public void registCard(CardVO card) throws Exception;

	// 카드 삭제
	public void deleteCard(int c_number) throws Exception;

	// 카드 정보 수정 - 만료일, 보안카드, 주소
	public void updateCard(CardVO card) throws Exception;
}
