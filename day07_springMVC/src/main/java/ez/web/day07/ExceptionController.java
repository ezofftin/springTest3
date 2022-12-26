package ez.web.day07;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
//	@RequestMapping("/except01") // 메소드의 return 타입이 void면 @RequestMapping("/except01")에서 except01이 view페이지가 된다.
////	public void main() throws Exception{
//	public String main() throws Exception{
//		try {
//			throw new Exception("예외 발생!!");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}
//	
//	@RequestMapping("/except02")
//	public String main2() throws Exception{
//		try {
//			throw new Exception("예외 발생!!");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}
	// 현재 Controller에서 발생하는 모든 예외를 받아서 처리
	@ExceptionHandler(Exception.class)
	// 응답 메시지의 상태코드 변경시 사용
	@ResponseStatus(HttpStatus.NOT_FOUND) // 200 --> 500으로 변경
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
	

	@RequestMapping("/except01") // 메소드의 return 타입이 void면 @RequestMapping("/except01")에서 except01이 view페이지가 된다.
	public String main() throws Exception{
		throw new Exception("예외 발생!!");
	}
	
	@RequestMapping("/except02")
	public String main2() throws Exception{
		throw new Exception("예외 발생!!");
	}
	
	@RequestMapping("/except03")
	public String main3() throws Exception{
		throw new NullPointerException("예외 발생!!");
	}
	
	@RequestMapping("/except04")
	public String main4() throws Exception{
		throw new FileNotFoundException("예외 발생!!");
	}

	
}
