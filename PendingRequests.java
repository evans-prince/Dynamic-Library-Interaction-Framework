import Includes.*;

public class PendingRequests {
    private int length = 0;
    private Node<RequestData> front;
    private Node<RequestData> back;

    public boolean insert(Node<RequestData> insnode) {
        /*
         * Your code here.
         */
        if (front == null){
			front = insnode;
			back=front;
		}
		else{
			insnode.previous=back;
			back.next=insnode;
			back = insnode;
		}
		length ++;
		return true;
    }

    public boolean delete(Node<RequestData> delnode) {
        /*
         * Your code here.
         */
		delnode.previous.next=delnode.next;
		delnode.next.previous=delnode.previous;
		length --;
        return true;
    }

    public Node<RequestData> find(int ISBN) {
        /*
         * Your code here.
         */
		Node<RequestData> currentNode=front;
		for (; currentNode!=null; currentNode=currentNode.next){
			if (currentNode.data.ISBN == ISBN){
				break ; 
			}
		}	
        return currentNode;
    }

    public String toString(){
        Node<RequestData> temp = front;
        String s = "Length: " + length + "\n";
        while(temp != null){
            s+=temp.data.toString();
            temp = temp.next;
        }
        return s;
    }
}
