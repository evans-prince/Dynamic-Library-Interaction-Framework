import Includes.*;

public class DriverCode2 {
    public static void main(String[] args) {
        LibraryStorage ls = new LibraryStorage();

        // Test case 1: Pushing requests
        System.out.println("Test Case 1: Pushing Requests");
        ls.push(100001, 1);
        ls.push(100002, 2);
        System.out.println("Request Queue: ");
        System.out.println(ls.rqQueueToString());
        System.out.println("Pending Requests: ");
        System.out.println(ls.prLinkedListToString());
        System.out.println("------------------------------------");

        // Test case 2: Processing requests
        System.out.println("Test Case 2: Processing Requests");
        System.out.println(ls.processQueue());
        System.out.println("Request Queue after processing: ");
        System.out.println(ls.rqQueueToString());
        System.out.println("Pending Requests after processing: ");
        System.out.println(ls.prLinkedListToString());
        System.out.println("------------------------------------");

        // Test case 3: Processing returns
        System.out.println("Test Case 3: Processing Returns");
        // Assuming you have a method to process returns
        BookData book = new BookData();
        book.ISBN = 100001; // Assuming this is the ISBN of the book to be returned
        ls.processReturn(book);
        // Print the state after processing returns
        System.out.println("State after processing returns: ");
        System.out.println(ls.toString());
        System.out.println("------------------------------------");

        // Add more test cases as needed...

    }
}

