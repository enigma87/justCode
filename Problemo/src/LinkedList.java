
public class LinkedList {

	 	private Node head;
	 	
	public Node getHead() {
			return head;
		}

		public void setHead(Node head) {
			this.head = head;
		}


	class Node {
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		private int data;
		private Node next;
		
		public Node (int val ){
			this.data = val;
			this.next = null;
		}
	}
	
	public LinkedList(int headVal) {
		LinkedList.Node newHead = this.new Node(headVal);
		this.setHead(newHead);
	}

	public int add(Node newNode) {
		int size = 0;
		if (null == this.getHead()) return size;
		Node iter = this.getHead();
		while (null != iter.getNext()){
			size += 1;
			iter = iter.getNext();
		}
		iter.setNext(newNode);
		return size+2;
	}
	
	public void peekAll() {
		Node iter = this.getHead();
		while(null != iter) {
			System.out.println(iter.getData());
			iter = iter.getNext();
		}
		
	}
	
	public void reverse() {
		_reverse(null, this.getHead());
	}
	
	private void _reverse(Node prev, Node current) {
		
		if (current == null) { 
			this.setHead(prev);
			return; 
		}
		
		_reverse(current, current.getNext());
		
		current.setNext(prev);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList(1);
		ll.add(ll.new Node(2));
		ll.add(ll.new Node(3));
		ll.add(ll.new Node(4));
		
		System.out.println(ll.add(ll.new Node(5)));
		ll.peekAll();
		ll.reverse();
		ll.peekAll();
		
		
	}

}
