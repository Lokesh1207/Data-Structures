package CustomSinglyLL;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

public class CustomSinglyLL {
	Node head;
	Node tail;

	void insertAtEnd(int data) {
		Node newnode = new Node(data);
		if (head == null && tail == null) {
			head = newnode;
			tail = newnode;
		}
		tail.next = newnode;
		tail = newnode;
	}

	void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	void insertAtBegin(int data) {
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}

	int size() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	void deleteFirst() {
		Node temp = head;
		temp = temp.next;
		head = temp;
	}

	void deleteLast() {// wont work for insertAtbegin method.
		Node temp = head;
		while (temp.next != tail) {
			temp = temp.next;
		}
		temp.next = null;
		tail = temp;
	}

	void deleteAtPos(int pos) {
		Node temp = head;
		if (pos == 0) {
			deleteFirst();
			return;
		}
		for (int i = 0; i < pos - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}

	void insertAtPos(int pos, int data) {
		Node prev;
		Node newnode = new Node(data);
		Node temp = head;
		if (pos == 0) {
			insertAtBegin(data);
			return;
		}
		for (int i = 0; i < pos - 1; i++) {
			temp = temp.next;
		}
		newnode.next = temp.next;
		temp.next = newnode;
	}

	int get(int index) {
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public static void main(String[] args) {
		CustomSinglyLL list = new CustomSinglyLL();
		list.insertAtEnd(0);
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
//		list.deleteFirst();
		list.deleteLast();
		list.display();
		System.out.println();
		list.deleteAtPos(0);
		list.insertAtPos(1, 0);
		list.display();
		System.out.println();
		System.out.println("Element 2: " + list.get(2));
		System.out.println();
		System.out.println("Size: " + list.size());

	}

}
