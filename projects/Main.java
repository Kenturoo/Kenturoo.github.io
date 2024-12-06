import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Kindly input the price and quantity of your 3 items ٩(｡•́‿•̀｡)۶");
		
		//item inputs
		System.out.println("\nItem #1:");
		System.out.print("Price: ");
		double pItem01 = scanner.nextDouble();
		System.out.print("Quantity: ");
		double qItem01 = scanner.nextDouble();
		
		System.out.println("\nItem #2:");
		System.out.print("Price: ");
		double pItem02 = scanner.nextDouble();
		System.out.print("Quantity: ");
		double qItem02 = scanner.nextDouble();
		
		System.out.println("\nItem #3:");
		System.out.print("Price: ");
		double pItem03 = scanner.nextDouble();
		System.out.print("Quantity: ");
		double qItem03 = scanner.nextDouble();
		
		//calculation
		double subTotal = (pItem01 * qItem01) + (pItem02 * qItem02) + (pItem03 * qItem03);
		double discount = subTotal * 0.05;
		double salesTax = 0.12 * (subTotal - discount);
		double finalTotal = (subTotal - discount) + salesTax;
		
		//print the totalities
		System.out.println("\nSubtotal: " + subTotal);
		System.out.println("Discount (5%): " + discount);
		System.out.println("Sales Tax (12%): " + salesTax);
		System.out.println("Final Total: " + finalTotal);
		
		
	}

}
