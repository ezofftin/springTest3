package ez.web.day07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlPatternTest {
	@RequestMapping("/register/member.do")
	public void test() {
		System.out.println("urlPattern=/register/member.do");
	}
	
	// /register/member, /register/mm, /register/aaa.do
	@RequestMapping("/register/*") 
	public void test1() {
		System.out.println("urlPattern=/register/*");
	}
	
	// /register/A/B/C/D/temp/hello.do, /register/temp/hello.do, /register/A/temp/hello.do
	@RequestMapping("/register/**/temp/*.do")
	public void test2() {
		System.out.println("urlPattern=/register/**/aa/*.do");
	}
	
	// /register/ab. , /register/abc, /register/.do, /register/aaa.bak
	// /register/abc.do
	@RequestMapping("/register/???")
	public void test3() {
		System.out.println("urlPattern=/register/???");
	}
	
	@RequestMapping("*.do")
	public void test4() {
		System.out.println("urlPattern=*.do");
	}
	
	// /member.abc, 
	@RequestMapping("/*.???")
	public void test5() {
		System.out.println("urlPattern=/*.???");
	}
	
	/*
	  
	 ? : 한글자
	 * : 여러글자
	 **: 하위 경로 포함
		 
		 /register/member.do :정확하게 매핑되야 호출 
		 /register/*  : 경로매핑, /** 하위경로 포함한 매핑
		 *.do		  : 확장자 매핑	
	 
	 
	 */
	
	
}
