import java.util.Stack;

class MinStack {
private Node head;
//initialise node of the stack

public void push(int x){
    if(head  == null){
        head =  new Node (x , x , null);
    }
    else{
        head = new Node(x, Math.min(x,head.min), head);
    }
}
//push function , if head is null, new head is initiated
// else the old head is compared to the new one and the minimum of both is selected as head of the minStack

public void pop(){
    head = head.next;
} 
// when a value is popped the head is moved to the next Node after head

public int top(){
    return head.val;
}
//returns value of the head

public int getMin(){
    return head.min;
}
//returns the minmum value of the head

private class Node{
    int val;
    int min;
    Node next;

    Node(int val, int min, Node next){
        this.val =  val;
        this.min = min;
        this.next = next;
    }
}
//generic node class
}