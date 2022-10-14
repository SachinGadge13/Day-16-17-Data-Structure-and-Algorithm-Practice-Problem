package com.bridgelabz.DataStructureAlgorithm;

public class Unordered {
    public static class Node {
        private String data;
        private Node next;

        public Node(String x) {
            this.data = x;
            this.next = null;
        }
    }

    // head and tail of the singly linked list
    private Node head = null;
    private Node tail = null;

    // Add nodes at End
    public void addToEnd(String x) {
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

    // Node size
    public int size() {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    public boolean findWord(String x) {
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
            System.out.println("Singly Linked List is Empty");
        }
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        Unordered list = new Unordered();

        list.addToEnd("'Pulsar'");
        list.addToEnd("'Benelli'");
        System.out.println("Before adding Words in LinkedList :");
        list.displayList();

        String array[] = { "'Ducati'", "'Kawasaki'", "'Ninja'", "'Yamaha'" };
        for (int i = 0; i < array.length; i++) {
            if (list.findWord(array[i])) {
                continue;
            } else {
                list.addToEnd(array[i]);
            }
        }
        System.out.println("After adding Words in LinkedList :");
        list.displayList();

    }

}