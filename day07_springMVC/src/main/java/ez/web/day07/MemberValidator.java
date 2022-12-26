package ez.web.day07;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


// 객체검증시 사용되는 인터페이스 Validator
public class MemberValidator implements Validator{
	
	// 검증 가능한 객체인지를 알려주는 메소드
	@Override
	public boolean supports(Class<?> clazz) {		
		return Member.class.equals(clazz); // Member 클래스를 검증하겠다는 의미
	}
	
	// 객체를 검증하는 메소드
	@Override            // 검증할 객체, 검증시 발생한 에러를 저장하는 저장소
	public void validate(Object target, Errors errors) { //
		System.out.println("MemberValidator.validate() 호출");
		// Object는 모든 객체를 의미하지만 supports()에서 검증할 객체를 정했기 때문에
		// 여기서는 Object가 Member 객체
		
		// supports() 메소드가 없으면 Member객체를 확인하는 작업이 필요
//		if(!(target instanceof Member)) return;
		
		Member member = (Member)target;
		
		String id = member.getId();
		String pw = member.getPw();
		String name = member.getName();
		
		// reject(에러코드): 객체를 대상, rejectValue(필드, 에러코드) : 객체의 필드를 대상
		
//		if(id==null || "".equals(id.trim())) {
//			errors.rejectValue("id", "required");
//		}		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		
		
		// 값이 공백값("    ")이거나 비어있으면("") errors 객체에 필드는 pw로 하고 에러코드를 required로 저장
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "required");
		
		// id가 null이거나 4자리미만이거나 8자리 초과이면 invalidSize코드로 errors에 저장
		if(id==null || id.length() < 4 || id.length() > 8) {
//			errors.rejectValue("id", "invalidSize", "아이디는 4 ~ 8자리 사이여야 합니다.");
			errors.rejectValue("id", "invalidSize", new String[] {"4", "8"}, null);
		}
		
		if(pw==null || pw.length() < 4 || id.length() > 8) {
//			errors.rejectValue("id", "invalidSize", "아이디는 4 ~ 8자리 사이여야 합니다.");
			errors.rejectValue("pw", "invalidSize", new String[] {"4", "8"}, null);
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		

		
//		System.out.println("errors : " + errors);
	}

}
