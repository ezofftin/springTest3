package ez.web.day07;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

// 응답 메시지의 상태코드를 변경할 때 사용하는 애너테이션
//@ResponseStatus(HttpStatus.BAD_REQUEST) // 기본 상태코드 500 --> 400번으로 변경
class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	
	MyException(){this("");} // 기본생성자
}


@Controller
public class ExceptionController2 {
//	// 현재 Controller에서 발생하는 모든 예외를 받아서 처리
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception e, Model model) {
//		model.addAttribute("e", e); // 예외 정보를 저장해서 넘겨줌	
//		return "error";
//	}
//	
//	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
//	public String catcher2(Exception e, Model model) {
//		//System.out.println("널포인터 예외!!");
//		model.addAttribute("e", e); // 예외 정보를 저장해서 넘겨줌
//		return "error";
//	}
	

	
	@RequestMapping("/except05")
	public String main2() throws Exception{
		throw new Exception("예외 발생!!");
	}
	
	@RequestMapping("/except06")
	public String main3() throws Exception{
		throw new NullPointerException("예외 발생!!");
	}
	
	@RequestMapping("/except07")
	public String main4() throws Exception{
		throw new MyException("예외 발생!!");
	}	
}
