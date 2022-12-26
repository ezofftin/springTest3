package ez.web.day07;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, boolean rememberId, String moveURL, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		System.out.println("rememberId : "+rememberId);
		
		System.out.println("moveURL : " + moveURL);
		
		
		// id와 pw를 확인(DB에 있는지) 
		if(!memberChk(id, pw)) {
			// DB와 일치하지 않으면 출력할 메세지
			String msg = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다!!", "utf-8");
			
			return "redirect:/login/login?msg="+msg; 
		}
		
		
		// id와 pw가 일치하면
		// 세션 객체를 얻어오기
		// 클라이언트의 request에 있는 세션아이디와 
		// 서버의 세션객체중에 세션아이디와 일치하는 세션객체를 얻어오기
		HttpSession session = request.getSession();
		// 세션 객체에 id를 저장
		session.setAttribute("id", id);		
		
		if(rememberId) { // 아이디 기억하기가 체크되어 있는 경우 쿠키 생성
			// 쿠키를 생성
			Cookie cookie = new Cookie("id", id);
			// 쿠키 응답하기
			response.addCookie(cookie);
		}else { // 체크가 안되어 있으면
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); // 쿠키 삭제
			
			// 응답하기
			response.addCookie(cookie);
		}
		
		moveURL = moveURL== null || moveURL.equals("") ? "/": moveURL;
		
		return "redirect:"+moveURL; // 로그인 성공시 홈으로 이동
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { // 스프링이 자동으로 session 생성해줌
		// 세션 수동 종료
		session.invalidate();
		// 세션 예약종료
		// session.setMaxInactiveInterval(60*30); // 초단위로 계산 30분후 종료
		
		// 홈으로 이동
		return "redirect:/";
	}

	private boolean memberChk(String id, String pw) {
		
		// DB아이디: test, DB비번: 1234 가정
		return "test".equals(id) && "1234".equals(pw);
	}
	
}
