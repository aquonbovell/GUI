public class DoublyNode {
	private int value;
	private DoublyNode Next;

	public DoublyNode() {
		value = 0;
		Next = null;
	}

	public DoublyNode(int number) {
		value = number;
		Next = null;
	}

	public int getValue() {
		return value;
	}

	public DoublyNode getNext() {
		return Next;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(DoublyNode next) {
		this.Next = next;
	}
}
