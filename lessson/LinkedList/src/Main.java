
public class Main {


	public static void main(String[] args) {
		/*Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		n1.next = n2;
		n2.next = n3;
		
		n1 = Node.reverseLinkedNode(n1);	
		System.out.println(n1);*/
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for(int i = 0; i < 8; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
		
		linkedList.add(2, 19);
		System.out.println(linkedList);
		
		System.out.println(linkedList.removeNode(2));
		System.out.print(linkedList);
		
	}

}
