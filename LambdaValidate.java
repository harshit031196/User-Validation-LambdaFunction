import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LambdaValidate {
	
	public static boolean checkFirstName(String example) throws ValidationException{
		Matcher matcher = Pattern.compile("^[A-Z]{1}[a-zA-Z]{2,}").matcher(example);
		if(matcher.matches())return true;
		throw new ValidationException("Invalid first name");
	}
	public static boolean checkLastName(String example) throws ValidationException {
		Matcher matcher = Pattern.compile("^[A-Z]{1}[a-zA-Z]{2,}").matcher(example);
		if(matcher.matches())return true;
		throw new ValidationException("Invalid last name");
	}
	public static boolean checkEmailID(String example) throws ValidationException{
		Matcher matcher = Pattern.compile("^([a-zA-Z0-9\\_\\-]+)([\\.|\\-]{1}[a-zA-Z0-9]+)*@([a-zA-Z0-9]+)\\.([a-zA-Z]{2,})(\\.[a-zA-Z] {2,})?$").matcher(example);
		if(matcher.matches())return true;
		throw new ValidationException("Invalid Email ID");
	}
	public static boolean checkPhoneNumber(String example) throws ValidationException{
		Matcher matcher = Pattern.compile("^[1-9]{1}[0-9]{9}").matcher(example);
		if(matcher.matches())return true;
		throw new ValidationException("Invalid Phone Number");
	}
	public static boolean checkPassword(String example) throws ValidationException{
		Matcher matcher = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%]*[@#$%][^@#$%]*$).{8,}$").matcher(example);
		if(matcher.matches())return true;
		throw new ValidationException("Invalid Password");
	}
	static lambdaInterface validateFirstName = (String y)->{
		try {
			return checkFirstName(y);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return false;
	};
	static lambdaInterface validateLastName = (String y)->{
		try {
			return checkLastName(y);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return false;
	};
	static lambdaInterface validateEmailID = (String y)->{
		try {
			return checkEmailID(y);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return false;
	};
	static lambdaInterface validatePhoneNumber = (String y)->{
		try {
			return checkPhoneNumber(y);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return false;
	};
	static lambdaInterface validatePassword = (String y)->{
		try {
			return checkPassword(y);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return false;
	};
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the User Validation Portal");
		boolean flag=false;
		while(!flag) {
			System.out.println("Please enter your first name");
			if(validateFirstName.validate(sc.next())) {
				System.out.println("The first name is valid" );
				flag=true;
			}
		}
		flag=false;
		while(!flag) {
			System.out.println("Please enter your last name");
			if(validateLastName.validate(sc.next())) {
				System.out.println("The last name is valid" );
				flag=true;
			}
		}
		flag=false;
		while(!flag) {
			System.out.println("Please enter your E-mail");
			if(validateEmailID.validate(sc.next())) {
				System.out.println("The Email ID is valid" );
				flag=true;
			}
		}
		
		flag=false;
		while(!flag) {
			System.out.println("Please enter your Phone Number");
			if(validatePhoneNumber.validate(sc.next())) {
				System.out.println("The Phone Number is valid" );
				flag=true;
			}
		}
		
		flag=false;
		while(!flag) {
			System.out.println("Please enter your Password");
			if(validatePassword.validate(sc.next())) {
				System.out.println("The Password is valid" );
				flag=true;
			}
		}
		System.out.println("User Validation is complete");
	}
	
}
