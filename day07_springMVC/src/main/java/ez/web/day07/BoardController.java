package ez.web.day07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		
		// 로그인 체크하기
		if(!loginChk(request)) {
			// 로그인을 안했을 경우 로그인 화면으로 이동
			return "redirect:/login/login?moveURL="+request.getRequestURL();
		}
		
		return "boardList"; // 로그인을 한 상태이면 게시판 페이지로
	}

	private boolean loginChk(HttpServletRequest request) {
		// 세션획득
		HttpSession session = request.getSession();
		
		// 세션 id가 있으면 true, 없으면 false
//		if(session.getAttribute("id") !=null) {
//			return true;
//		}else {
//			return false;
//		}
		
		return session.getAttribute("id") != null;
	}
}
