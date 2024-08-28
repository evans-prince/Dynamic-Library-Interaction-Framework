import Includes.*;

public class RequestQueue {
    private Node<RequestData> front;
    private Node<RequestData> back;
    private int length = 0;

    public RequestData getFront() {
        return this.front.data;
    }

    public int getLength() {
        /*
         * Your code here.
         */
		
        return this.length;
    }

    public void push(int ISBN, int UserID) {
        /*
         * Your code here.
         */
		// new element of data type RequestData is created
		RequestData rd =new RequestData();
		rd.ISBN = ISBN;
		rd.UserID = UserID;
		Node<RequestData> elem = new Node<>();
		elem.data = rd;
		// adding this element 
		if (front == null){
			front = elem;
			back = front;
		}
		else {
			elem.previous=back;
			back.next=elem;
			back = elem;
		}
		this.length ++;
        return;
    }

    public void pop() {      // processing needs to be done before popping, 
        /*
         * Your code here.
         */
		if(front!=null){
		front=front.next;
		this.length --;
		}
        return;
    }

    public String toString(){
        Node<RequestData> temp = front;
        String s = "Length: " + length + "\n";
        while(temp != null){
            s+=temp.data.toString();// temp.data gives data type of RequestData and uses its toString method
            temp = temp.next; // .next is method of Node 
        }
        return s;// returns a string containing length and data in queue
    }
}
