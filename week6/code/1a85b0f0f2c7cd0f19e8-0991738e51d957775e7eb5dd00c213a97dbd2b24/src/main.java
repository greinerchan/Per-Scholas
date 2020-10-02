public class main {
    public static void main(String[] args) {
        System.out.println("Doubly Linked list");
        DLL dlist = new DLL();

        dlist.insertNode("test1");
        dlist.insertNode("test2");
        dlist.insertNode("test3");
        dlist.insertNode("test4");
        dlist.insertNode("test5");
        dlist.insertNode("test6");
        dlist.insertNode("test7");
        dlist.printDListNodes();

        System.out.println();

        System.out.println("Finding item test2 in the Linked list");
        dlist.findNode("test2");
        System.out.println("Finding item nonExist in the Lineked list");
        dlist.findNode("nonExist");

        System.out.println();

        System.out.println("Finding item at location 4");
        dlist.findNodeAt(4);

        System.out.println();
        System.out.println("Finding item at last location ");
        dlist.findLastNode();
        System.out.println();

        System.out.println("Adding test1st at start of the Node");
        dlist.insertFirst("test1st");
        dlist.printDListNodes();

        System.out.println();

        System.out.println("Adding testNth at 2nd Location");
        dlist.insertNth("testNth", 2);
        dlist.printDListNodes();

        System.out.println();

        System.out.println("Adding testNth at 6th Location");
        dlist.insertNth("testNth2", 6);
        dlist.printDListNodes();

        System.out.println();

        System.out.println("Deleting first node");
        dlist.deleteFirstNode();
        dlist.printDListNodes();

        System.out.println();

        System.out.println("Deleting last node");
        dlist.deleteLastNode();
        dlist.printDListNodes();

        System.out.println();

        System.out.println("Deleting 4th node");
        dlist.deleteNthNode(4);
        dlist.printDListNodes();

    }
}
