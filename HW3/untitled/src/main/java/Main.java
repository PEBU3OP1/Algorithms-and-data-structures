package main.java;

import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> linkedlst = new LinkedList<>();
        linkedlst.addLast(new Student("Student5", 22));
        linkedlst.addLast(new Student("Student4", 23));
        linkedlst.addLast(new Student("Student3", 24));
        linkedlst.addLast(new Student("Student2", 25));
        linkedlst.addLast(new Student("Student1", 26));

        printList(linkedlst);

        linkedlst.directSort(new StudentAgeComparator(SortType.Ascending));
        printList(linkedlst);

        linkedlst.directSort(new StudentAgeComparator(SortType.Decsending));
        printList(linkedlst);

    }

    public static <T> void printList (LinkedList<T> list){
        LinkedList.Node node = list.getHead();
        while (node != null){

            System.out.println(node.getValue());
            node = node.getNext();
        }
        System.out.println();
    }
}