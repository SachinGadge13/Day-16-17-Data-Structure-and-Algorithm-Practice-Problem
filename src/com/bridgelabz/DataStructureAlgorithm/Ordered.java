package com.bridgelabz.DataStructureAlgorithm;

public class Ordered {
    // Represent a node of the singly linked list
    public static class Node {
        private int data;
        private Node next;

        public Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    // Represent the head and tail of the singly linked list
    private Node head = null;
    private Node tail = null;

    // Add nodes to the list at End
    public void addToEnd(int x) {
        Node node = new Node(x);
        if (head == null) {
            this.head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    // Nodes size
    public int size() {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    public boolean findNode(int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // displayList() will display all the nodes
    public void displayList() {
        Node temp = head;
        if (head == null) {
            System.out.println(" List is Empty");
        }
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("");

    }

    // bubble sort
    public void sort() {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ordered List = new Ordered();

        List.addToEnd(18);
        List.addToEnd(26);
        List.addToEnd(62);
        List.addToEnd(52);

        System.out.println("Before adding elements :");
        List.displayList();
        System.out.println("");

        int arr[] = { 11, 29, 62, 90 };

        for (int i = 0; i < arr.length; i++) {
            if (List.findNode(arr[i])) {
                continue;
            } else {
                List.addToEnd(arr[i]);
            }
        }
        System.out.println("After adding some elements to the LinkedList :");
        List.displayList();
        System.out.println("");
        System.out.println("Before sorting the LinkedList :");
        List.displayList();
        System.out.println("");
        List.sort();
        System.out.println("After sorting the LinkedList :");
        List.displayList();

    }

}