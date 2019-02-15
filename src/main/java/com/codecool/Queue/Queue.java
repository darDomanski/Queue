package com.codecool.Queue;

public class Queue {

    private Node head;
    private Node tail;
    private int size = 0;


    public void enqueue(String value, int priority) {
        Node newNode = new Node(value, priority);
        Node current = head;

        if (isEmpty()) {
            setNewNodeInEmptyQueue(newNode);
        } else {
            setNewNodeInQueueContainingObjects(newNode, current);
        }
        size++;
    }

    private void setNewNodeInQueueContainingObjects(Node newNode, Node current) {

        if (current.getPriority() < newNode.getPriority()) {

            newNode.setNextNode(current);
            head = newNode;

        } else {

            if (current.getPriority() == newNode.getPriority()) {

                findPlaceForNewNodeAfterObjectsWithSamePriority(newNode, current);

            } else {

                findPlaceForNewNode(newNode, current);
            }

            setNewNodeInQueue(newNode, current);
        }
    }

    private void setNewNodeInEmptyQueue(Node newNode) {
        head = newNode;
        tail = newNode;
    }

    private void findPlaceForNewNode(Node newNode, Node current) {
        while (current.getNextNode() != null && current.getPriority() <= newNode.getPriority()) {
            current = current.getNextNode();
        }
    }

    private void findPlaceForNewNodeAfterObjectsWithSamePriority(Node newNode, Node current) {
        while (current.getNextNode().getPriority() == newNode.getPriority()) {
            current = current.getNextNode();
        }
    }

    private void setNewNodeInQueue(Node newNode, Node current) {
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);

        if (newNode.getNextNode() == null) {
            tail = newNode;
        }
    }

    public String peek() {
        return head.getValue();
    }

    public String dequeue() {
        String dequeuedValue = head.getValue();
        head = head.getNextNode();
        size--;
        return dequeuedValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
