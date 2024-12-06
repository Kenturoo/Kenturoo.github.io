public class Doubly {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\nBrowser History Menu:");
            System.out.println("1. Visit a page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Display Current Page");
            System.out.println("5. Display History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the URL of the page to visit: ");
                    String url = scanner.nextLine();
                    history.visit(url);
                    break;
                case 2:
                    history.goBack();
                    break;
                case 3:
                    history.goForward();
                    break;
                case 4:
                    history.displayCurrentPage();
                    break;
                case 5:
                    history.displayHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
class Page {
 String url;
 Page next;
 Page prev;

 Page(String url) {
     this.url = url;
     this.next = null;
     this.prev = null;
 }
}

class BrowserHistory {
 private Page currentPage;
 public BrowserHistory() {
     currentPage = null;
 }
 
 public void visit(String url) {
     Page newPage = new Page(url);

     if (currentPage == null) {
         currentPage = newPage;
     } else {
         currentPage.next = newPage;
         newPage.prev = currentPage;
         currentPage = newPage;
     }

     if (currentPage.next != null) {
         currentPage.next = null;
     }
 }

 public void goBack() {
     if (currentPage != null && currentPage.prev != null) {
         currentPage = currentPage.prev;
         System.out.println("\nBack to: " + currentPage.url);
     } else {
         System.out.println("\nNo previous page.");
     }
 }

 public void goForward() {
     if (currentPage != null && currentPage.next != null) {
         currentPage = currentPage.next;
         System.out.println("\nForward to: " + currentPage.url);
     } else {
         System.out.println("\nNo next page.");
     }
 }

 public void displayCurrentPage() {
     if (currentPage != null) {
         System.out.println("\nCurrent page: " + currentPage.url);
     } else {
         System.out.println("\nNo pages visited yet.");
     }
 }

 public void displayHistory() {
     if (currentPage == null) {
         System.out.println("\nNo history.");
         return;
     }

     System.out.println("\nHistory:");
     Page temp = currentPage;
     while (temp != null) {
         System.out.println(temp.url);
         temp = temp.prev;
     	}
 	}
}