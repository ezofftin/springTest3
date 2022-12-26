package ez.web.day07;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member") // URL패턴에서 공통되는 부분을 클래스에 적용가능
public class RegisterController {

	/***** 데이터 변환시 사용되는 객체  
	 1. PropertyEditor (String --> 타입, 타입 --> String (양방향 변환))
	 	- 디폴트 PropertyEditor - 스프링이 제공해주는 editor
	 	- 사용자정의(커스텀) PropertyEditor - 사용자가 직접 정의해서 사용하는  editor
	 
	 	@WebBindingInitializer : 모든 컨틀롤러 내에서 변환 사용 가능
	 	
	 	특정 컨트롤러안에 @InitBinder를 메소드에 붙여 사용
	 
	 2. Converter (단방향) : PropertyEditor 단점을 보완 
	 	- ConversionService에 여러 Converter 등록되어 있다.
	 
	 3. Fomatter(양방향) : @DateTimeFormat(pattern="yyyy-MM-dd"), @NumberFormat(pattern="###,###") ==> int
	 
	 
	  -- 적용우선순위
	    i) 커스텀 PropertyEditor
	    ii) ConversionService
	    iii) 디폴트 PropertyEditor
		---> 예외처리
	 */
	
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//								// 변환할 타입	, 변환시 사용될 객체(주어진문자열, 빈값의 허용여부)	
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("/"));
		
		// WebDataBinder에 Validator를 등록
//		binder.setValidator(new MemberValidator()); // Member객체에만 적용되는 Validator
		binder.addValidators(new MemberValidator()); // GlobalValidator다음에 추가
		
		// 등록된 Validator 확인
		List<Validator> validList=binder.getValidators();
		System.out.println("validList : " + validList);
	}
	
	@GetMapping("/form")
	public String register() {
		return "registerForm";
	}
	
	
//	@PostMapping("/save")
	@PostMapping("/form")
	// @Valid 어노테이션은 springFramework 어노테이션이 아님, javax에 있으므로 mvn repository에서 받아옴.
	// validation 검색 후 bean validation API
	// WebDataBinder에 등록후에는 @Valid를 객체 앞에 붙여주면 된다. 
	public String save(@Valid Member member, BindingResult result, Model model) throws Exception {
		System.out.println("result : "+ result);
		System.out.println("member : "+member);
		
		// Validator 인터페이스를 구현한 객체를 생성, 수동 검증
//		MemberValidator memberValidator = new MemberValidator();
//		memberValidator.validate(member, result);// BindingResult는 Errors의 자손 
		
		
		// 검증후 에러메시지가 있으면 registerForm에 출력
		// MessageSource 인터페이스 : 파일과 같은 리소스에서 메시지를 읽어올 때 사용하는 인터페이스 
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		
		// 유효성 검사 예
//		if(!chkParam(member)) {
//			// encoding 지원이 안되는 형식일 경우 예외 사항이 발생한다.
//			String msg = URLEncoder.encode("잘못 입력하셨습니다!!! 다시 확인 요망!!", "utf-8");
//			
//			model.addAttribute("msg", msg); // redirect url에는 model 적용이 안되나
//			return "redirect:/member/form"; // 스프링이 자동으로 적용해줌.
//			
////			return "redirect:/member/form?msg="+msg; // 재요청
//		}
		
		return "registerInfo";
	}

	private boolean chkParam(Member member) {
//		return false; 
		return true; // 유효성검사 성공적으로 이루어졌을 때를 의미 
	}
}
