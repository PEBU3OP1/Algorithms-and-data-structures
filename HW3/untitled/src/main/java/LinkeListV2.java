package main.java;

public class LinkeListV2<T> {

    private NodeV2 head;
    private NodeV2 tail;


    public NodeV2 getHead() {
        return head;
    }

    public NodeV2 getTail() {
        return tail;
    }

    /**
     * Узел
     */
    class NodeV2 {
        private T value;
        private NodeV2 next;
        private NodeV2 previous;

        public NodeV2 getPrevious() {
            return previous;
        }

        public void setNext(NodeV2 next) {
            this.next = next;
        }

        public void setPrevious(NodeV2 previous) {
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public NodeV2 getNext() {
            return next;
        }


        public NodeV2(T value) {
            this.value = value;
        }
    }

    public void addFirst(T value) {
        NodeV2 nodev2 = new NodeV2(value);
        if (head != null) {
            nodev2.setNext(head);
            head.setPrevious(nodev2);
            //head = nodev2;

        } else {
            tail = nodev2;
            //head = nodev2;
        }
        head = nodev2;
    }

    public void removeFirst() {
        if (head != null && head.getNext() != null){
        head.getNext().setPrevious(null);
        head = head.getNext();
        }else {
            head = null;
            tail = null;
        }

    }

}
