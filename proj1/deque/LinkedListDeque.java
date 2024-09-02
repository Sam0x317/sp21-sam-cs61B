package deque;

public class LinkedListDeque<Any> {

    private class Node<Any> {
        public Any item;
        public Node pre;
        public Node next;

        public Node(Any i, Node p, Node n) {
            item = i;
            pre = p;
            next = n;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(Any item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        size++;
    }

    public void addLast(Any item) {
        sentinel.pre = new Node(item, sentinel.next, sentinel);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        Node p = sentinel.next;
        for ( ; p.next != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public Any removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinel.next;
        sentinel.next = p.next;
        p.next.pre = sentinel;
        size--;
        return (Any) p.item;
    }

    public Any removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinel.pre;
        sentinel.pre = p.pre;
        p.pre.next = sentinel;
        size--;
        return (Any) p.item;
    }

    public Any get(int index) {
        Node p0 = sentinel.next;
        for (int i = 0; i != index; i++) {
            if (p0.next == sentinel) {
                return null;
            }
            p0 = p0.next;
        }
        return (Any) p0.item;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = other.size;

        for (int i = 0; i < other.size(); i++) {
            addLast((Any) other.get(i));
        }
    }
}
