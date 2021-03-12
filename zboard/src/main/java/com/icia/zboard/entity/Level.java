package com.icia.zboard.entity;

// 전통적인 방식의 상수(인터페이스) : public static final Integer NORMAL = 1;
// 이것의 문제점 : int level = Level.NORMAL  타입이 int이므로 상수라는 티가 나지 않는다
// int level = 10   정상 실행
public enum Level {
	NORMAL, SILVER, GOLD;
}
