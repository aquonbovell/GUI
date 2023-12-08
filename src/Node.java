public class Node {
    private int value;
    private Node Next;
    public Node() {
        value = 0;
        Next = null;
    }
    public Node(int number){
        value = number;
        Next = null;
    }
    public int getValue() {
        return value;
    }
    public Node getNext() {
        return Next;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setNext(Node next) {
        this.Next = next;
    }
}
