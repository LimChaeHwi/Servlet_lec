# Servlet_lec
서블릿 교육

RequestDispatcher
다른페이지로 이동
forward ()
include ()

WebServer = Http = stateless(연결이 바로 끊김)
네트워크가 계속 유지되지 않음.

이전에 쓴 데이터를 다른 페이지에서도 사용하고 싶다면.

계속 유지 시킬수 있는 저장 공간 3 only
1.ServletContext
2.HttpSession
3.HttpServletRequest

메모리 존재 기간이 다름.

HttpServletRequest 
- client가 서비스를 요청했을 때 (생성) service실행 전에
- client에게 응답했을 때 (삭제)
- request 단위

HttpSession : 장바구니, 로그인/로그아웃
- client 최초 접속 시
- client 접속 종료시
- client 단위

ServletContext
- context(web application) 서비스 시작 시, 서버 시작시
- context 서비스 종료시, 서버 중지 시
- context 단위

사용 범위(scope)?

저장 : setAttribute(name, value)
추출 : getAttribute(name)

