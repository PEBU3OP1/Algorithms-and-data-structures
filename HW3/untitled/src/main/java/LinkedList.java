package main.java;

import org.w3c.dom.Node;

import java.util.Comparator;

/**
 * однонаправленный связанный список
 *
 * @param <T>
 */

public class LinkedList<T> {
    private Node head;

    public Node getHead() {
        return head;
    }

    /**
     * Узел
     */
    class Node {
        private T value;
        private Node next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    /***
     * Добавить новый элемент в начало связанного списка
     * @param value
     */
    public void addFirst(T value) {
        Node node = new Node(value);

        if (head != null)
            node.setNext(head);
        head = node;
    }

    public void removeFirst(T value) {
        if (head != null)
            head = head.getNext();
    }

    /**
     * Поиск элемента в связнном списке
     *
     * @param value значение
     * @return результат поиска
     */
    public boolean сontains(T value) {
        Node node = head;
        while (node != null) {
            if (node.getValue().equals(value)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    /**
     * Добавить последний элемент из связанного списка
     *
     * @param value значение
     */

    public void addLast(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.getNext() != null)
                last = last.getNext();
            last.setNext(node);

        }
    }

    public void directSort(Comparator<T> comparator) {
        Node node = head;
        while (node != null) {
            Node minValue = node;

            Node node2 = node.getNext();
            while (node2 != null) {
                if (comparator.compare(minValue.getValue(), node2.getValue()) > 0) {
                    minValue = node2;

                }
                node2 = node2.getNext();
            }
            if (node != minValue){
                T buf = node.getValue();
                node.setValue(minValue.getValue());
                minValue.setValue(buf);
            }

            node = node.getNext();
        }
    }

    /**
     * Удалить последний элемент связанного списка
     */
    public void removeLast() {
        if (head == null)
            return;
        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getNext() == null) {
                node.setNext(null);
                return;
            }
            node = node.getNext();
        }
        head = null;

    }
}
