import java.util.*;

import Includes.*;

public class LibraryStorage {
    // HashMap
    // process return
    private HashMap<Integer, BookData> storage;
    private RequestQueue rqQueue;
    private PendingRequests prLinkedList;

    public LibraryStorage() {
        storage = new HashMap<Integer, BookData>();
        for (int i=100001; i<100011; i++) {
            BookData book = new BookData();
            MyDate dateor = new MyDate();
            dateor.month = 0;
            dateor.year = 0;
            book.BorrowedStatus = false;
            book.BorrowedByUserID = 0;
            book.ISBN = i;
            book.Publisher = "publisher";
            book.Author = "author";
            book.DateOfReturn = dateor;
            storage.put(i, book);
        }

        rqQueue = new RequestQueue();
        prLinkedList = new PendingRequests();
    }

    public void push(int ISBN, int UserID) {
        rqQueue.push(ISBN, UserID);
        return;
    }

    public boolean processQueue() {
        /*
         * Your code here.
         */
		// iterate over all requests in requestQueue
			// I can iterate using front of requestQueue 
		RequestData front = rqQueue.getFront();
		while (front != null ){
		// check if book is available in library and not borrowed
			int key = front.ISBN;
			BookData book = storage.get(key);
			if (storage.containsKey(key) && book.BorrowedStatus == false ){
			// return true and change borrowed status , userid , pop front from request queue
				book.BorrowedStatus = true;
				book.BorrowedByUserID=front.UserID;
				rqQueue.pop();
				return true;
			}
		// if borrowed , add in pending linklist and pop queue in this case return false
		//if book is not available return false	and also add this into pending linklist and pop
        	else{
				Node<RequestData> a = new Node<>();
				a.data=front;
				prLinkedList.insert(a);
				rqQueue.pop();
				return false;
			}
		}
		return false;
    }

    public boolean processReturn(BookData book) {          // I have assumed this takes BookData object as argument, can also work with ISBN perhaps
        /*
         * Your code here.
         */
		
		//check if returened book is in pending list
		Node<RequestData> elem = prLinkedList.find(book.ISBN);
		if (elem != null){ 
		// if in pending list then change the book borrowed  user id , and remove it from pending list 
		 	book.BorrowedByUserID = elem.data.UserID;
			prLinkedList.delete(elem);
        return true;
		}
		else{ 
		book.BorrowedStatus=false;
		book.BorrowedByUserID = -1 ;
		return false ;
		}
    }

    public String rqQueueToString(){
        return rqQueue.toString();
    }

    public String prLinkedListToString(){
        return prLinkedList.toString();
    }
    
}
