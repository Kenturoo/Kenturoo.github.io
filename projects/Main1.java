import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("Enter your password: ");
			String input = scanner.next();
			
			int pass = input.length();
			if (pass < 8) {
			System.out.println("invalid");
			}
			else if (!input.matches(".*[A-Z].*")){
				System.out.println("Your password must contain at least one or more capital letter");
			}
			else if (!input.matches(".*[a-z].*")){
				System.out.println("Your password must contain at least one or more small letter");
			}
			else if (!input.matches(".*[1-9].*")) {
				System.out.println("Your password must contain at least one or more numbers");
			}
			else if (!input.matches (".*[!@#\\\\$%^&*].*")){
				System.out.println("Your password must contain at least one or more symbols");
			}
			else {
				System.out.println("Your password is valid!");
			break;
			}
		}
	}
}
