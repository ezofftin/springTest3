package ez.web.day07;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 전역 예외 클래스
@ControllerAdvice // 모든 컨틀롤러에서 발생하는 예외 처리를 할 수 있도록 해주는 애너테이션
//@ControllerAdvice("ez.web.day07") // 지정 패키지에만 적용
public class GlobalCatcher {
	// 모든 컨틀롤러에서 발생하는 공통 예외처리를 기술
	// 개별 컨트롤러에 있는 예외처리가 우선 적용됨
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e, Model model) {
		model.addAttribute("e", e); // 예외 정보를 저장해서 넘겨줌	
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception e, Model model) {
		//System.out.println("널포인터 예외!!");
		model.addAttribute("e", e); // 예외 정보를 저장해서 넘겨줌
		return "error";
	}
}
