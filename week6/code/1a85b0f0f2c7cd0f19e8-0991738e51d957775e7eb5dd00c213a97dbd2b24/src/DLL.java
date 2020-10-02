/**
 * Singly Linked list implementation in Java
 * 
 *  Copy the 3 classes in DList.java, DLinkedList.java and Main.java in order to run the implementation
 * 
 *  Dinesh
 * 
 *   ____________	    _____________       ______________
 *  |item "test1"|	   | item "test2"|      | item "test3" |
 *  |      next  |-------->|        next |----->|        next  |------>null	
 *  |_prev(null) |<--------|prev         |<-----|prev          |
 *  |____________|	   |_____________|	|______________| 	
 *    HEAD                                          TAIL
 *
 * This is a basic implementation for Doubly linked list. More optimization can be implemented.
 * Also more error checking needs to be done.
 * 
 * Sentinal can be added to store head and size information
 **/



/**
* DLinkedList.java
*
*/
public class DLL {
	public Node head;
	public Node tail;
	private int size;

	public DLL() {
		size = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * Inserting new node at the end of the linked list
	 * If there is node node present we will make the first node as out main node
	 *
	 * @param item - represent the DListNode item to be added to the linked list
	 */
	public void insertNode(String item) {
		Node node = new Node();
		node.item = item;
		node.next = null;

		if (this.head == null) {
			this.head = node;
			this.tail = node;
			this.tail.next = null;
			this.tail.prev = null;
			this.size = 1;
		} else {
			Node prev = this.tail;
			this.tail.next = node;
			this.tail = node;
			this.tail.prev = prev;
			this.size++;
		}
	}

	/**
	 * Adding DListNode at the first location of the linked list
	 *
	 * @param item - represent item of the DListNode to be added to LL
	 */
	public void insertFirst(String item) {
		Node node = new Node();
		node.item = item;
		node.next = this.head;
		this.head.prev = node;
		this.head = node;
		this.size++;
	}

	/**
	 * Adding DListNode at the nth location of the linked list
	 * if location is greater than half of size traverse from tail
	 * if location is smaller than half of size traverse from head
	 *
	 * @param item     - represent the item of the DListNode to be added to the list
	 * @param position - position at which the DListNode is to be added
	 */
	public void insertNth(String item, int position) {
		int center = (int) Math.floor(size / 2);
		Node node = new Node();
		node.item = item;
		Node current = null;
		if (this.head != null && position <= this.size) {
			if (position < center) {
				current = head;
				for (int i = 1; i < position; i++) {
					current = current.next;
				}
			} else {
				current = tail;
				for (int i = size; i > position; i--) {
					current = current.prev;
				}
			}
			node.next = current.next;
			current.next.prev = node;
			node.prev = current;
			current.next = node;
			this.size += 1;
		} else {
			System.out.println("Exceeded the linked list size. Current Size: " + size);
		}
	}

	/**
	 * Deleting the first Node from the list
	 */
	public void deleteFirstNode() {
		if (head != null) {
			this.head = this.head.next;
			this.head.prev = null;
			this.size--;
		} else {
			System.out.println("Linked list is empty");
		}
	}

	/**
	 * Deleting the last DListNode from the list
	 */
	public void deleteLastNode() {
		if (tail != null) {
			this.tail = this.tail.prev;
			this.tail.next = null;
			this.size--;
		}
	}

	/**
	 * Deleting the DListNode from the nth location in the list
	 *
	 * @param position - location of the DListNode to be deleted
	 */
	public void deleteNthNode(int position) {
		Node current = null;
		int center = (int) Math.floor(size / 2);
		if (position < size) {
			if (position < center) {
				current = head;
				for (int i = 1; i < position; i++) {
					current = current.next;
				}
			} else {
				current = tail;
				for (int i = size - 1; i > position; i--) {
					current = current.prev;
				}
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;
			size--;
		} else {
			System.out.println("The position is exceeds the linked list size: " + this.size);
		}
	}

	/**
	 * Find if the DListNode exist in the list
	 *
	 * @param item - item to be found in the list
	 */
	public void findNode(String item) {
		Node node = this.head;
		boolean found = false;
		for (int i = 0; i < size; i++) {
			if (node.item.equals(item)) {
				System.out.println("Item " + item + " was found at location " + i + " in the linked list");
				found = true;
			}
			node = node.next;
		}

		if (!found)
			System.out.println("Item " + item + " was not found in the Linked list");
	}

	/**
	 * Find the DListNode item located at a specific location
	 *
	 * @param location - Find item at location
	 */
	public void findNodeAt(int location) {
		Node node = this.head;
		if (head != null && location <= size) {
			for (int i = 0; i < location; i++) {
				node = node.next;
			}
			System.out.println("DListNode item at location " + location + " is " + node.item);
		}
	}

	/**
	 * Find the item at the last location
	 */
	public void findLastNode() {
		if (tail != null) {
			System.out.println("DListNode item at last location is " + tail.item);
		}
	}


	/**
	 * Printing all the items in the list
	 */
	public void printDListNodes() {
		if (this.size < 1)
			System.out.println("There are no Nodes in the Doubly linked list");
		else {
			Node current = this.head;
			for (int i = 0; i < this.size; i++) {
				if (current.prev == null)
					System.out.println("Node " + current.item + " is at location " + i + " : Previous Node: null : Next Node: " + current.next.item);
				else if (current.next == null)
					System.out.println("Node " + current.item + " is at location " + i + " : Previous Node: " + current.prev.item + " : Next Node: null");
				else
					System.out.println("Node " + current.item + " is at location " + i + " : Previous Node: " + current.prev.item + " : Next Node: " + current.next.item);
				current = current.next;
			}
			System.out.println("Head: " + this.head.item + " and Tail:" + this.tail.item);
		}
	}


	/**
	 * Get linked list size
	 *
	 * @return
	 */
	public int getSize() {
		return size;
	}
}
/**
* Main.java
*
**/



/**
* OUTPUT
*
* Doubly Linked list
* Node test1 is at location 0 : Previous Node: null : Next Node: test2
* Node test2 is at location 1 : Previous Node: test1 : Next Node: test3
* Node test3 is at location 2 : Previous Node: test2 : Next Node: test4
* Node test4 is at location 3 : Previous Node: test3 : Next Node: test5
* Node test5 is at location 4 : Previous Node: test4 : Next Node: test6
* Node test6 is at location 5 : Previous Node: test5 : Next Node: test7
* Node test7 is at location 6 : Previous Node: test6 : Next Node: null
* Head: test1 and Tail:test7
*
* Finding item test2 in the Linked list
* Item test2 was found at location 1 in the linked list
* Finding item nonExist in the Lineked list
* Item nonExist was not found in the Linked list 
*
* Finding item at location 4
* DListNode item at location 4 is test5
*
* Finding item at last location 
* DListNode item at last location is test7
*
* Adding test1st at start of the Node
* Node test1st is at location 0 : Previous Node: null : Next Node: test1
* Node test1 is at location 1 : Previous Node: test1st : Next Node: test2
* Node test2 is at location 2 : Previous Node: test1 : Next Node: test3
* Node test3 is at location 3 : Previous Node: test2 : Next Node: test4
* Node test4 is at location 4 : Previous Node: test3 : Next Node: test5
* Node test5 is at location 5 : Previous Node: test4 : Next Node: test6
* Node test6 is at location 6 : Previous Node: test5 : Next Node: test7
* Node test7 is at location 7 : Previous Node: test6 : Next Node: null
* Head: test1st and Tail:test7
*
* Adding testNth at 2nd Location
* Node test1st is at location 0 : Previous Node: null : Next Node: test1
* Node test1 is at location 1 : Previous Node: test1st : Next Node: testNth
* Node testNth is at location 2 : Previous Node: test1 : Next Node: test2
* Node test2 is at location 3 : Previous Node: testNth : Next Node: test3
* Node test3 is at location 4 : Previous Node: test2 : Next Node: test4
* Node test4 is at location 5 : Previous Node: test3 : Next Node: test5
* Node test5 is at location 6 : Previous Node: test4 : Next Node: test6
* Node test6 is at location 7 : Previous Node: test5 : Next Node: test7
* Node test7 is at location 8 : Previous Node: test6 : Next Node: null
* Head: test1st and Tail:test7
*
* Adding testNth at 6th Location
* Node test1st is at location 0 : Previous Node: null : Next Node: test1
* Node test1 is at location 1 : Previous Node: test1st : Next Node: testNth
* Node testNth is at location 2 : Previous Node: test1 : Next Node: test2
* Node test2 is at location 3 : Previous Node: testNth : Next Node: test3
* Node test3 is at location 4 : Previous Node: test2 : Next Node: test4
* Node test4 is at location 5 : Previous Node: test3 : Next Node: testNth2
* Node testNth2 is at location 6 : Previous Node: test4 : Next Node: test5
* Node test5 is at location 7 : Previous Node: testNth2 : Next Node: test6
* Node test6 is at location 8 : Previous Node: test5 : Next Node: test7
* Node test7 is at location 9 : Previous Node: test6 : Next Node: null
* Head: test1st and Tail:test7
*
* Deleting first node
* Node test1 is at location 0 : Previous Node: null : Next Node: testNth
* Node testNth is at location 1 : Previous Node: test1 : Next Node: test2
* Node test2 is at location 2 : Previous Node: testNth : Next Node: test3
* Node test3 is at location 3 : Previous Node: test2 : Next Node: test4
* Node test4 is at location 4 : Previous Node: test3 : Next Node: testNth2
* Node testNth2 is at location 5 : Previous Node: test4 : Next Node: test5
* Node test5 is at location 6 : Previous Node: testNth2 : Next Node: test6
* Node test6 is at location 7 : Previous Node: test5 : Next Node: test7
* Node test7 is at location 8 : Previous Node: test6 : Next Node: null
* Head: test1 and Tail:test7
*
* Deleting last node
* Node test1 is at location 0 : Previous Node: null : Next Node: testNth
* Node testNth is at location 1 : Previous Node: test1 : Next Node: test2
* Node test2 is at location 2 : Previous Node: testNth : Next Node: test3
* Node test3 is at location 3 : Previous Node: test2 : Next Node: test4
* Node test4 is at location 4 : Previous Node: test3 : Next Node: testNth2
* Node testNth2 is at location 5 : Previous Node: test4 : Next Node: test5
* Node test5 is at location 6 : Previous Node: testNth2 : Next Node: test6
* Node test6 is at location 7 : Previous Node: test5 : Next Node: null
* Head: test1 and Tail:test6
*
* Deleting 4th node
* Node test1 is at location 0 : Previous Node: null : Next Node: testNth
* Node testNth is at location 1 : Previous Node: test1 : Next Node: test2
* Node test2 is at location 2 : Previous Node: testNth : Next Node: test3
* Node test3 is at location 3 : Previous Node: test2 : Next Node: testNth2
* Node testNth2 is at location 4 : Previous Node: test3 : Next Node: test5
* Node test5 is at location 5 : Previous Node: testNth2 : Next Node: test6
* Node test6 is at location 6 : Previous Node: test5 : Next Node: null
* Head: test1 and Tail:test6
*
**/
