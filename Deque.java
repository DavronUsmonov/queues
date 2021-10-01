import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node head;
    private Node last;

    private class Node {
        private Node next;
        private Node prev;
        private Item item;

    }

    public Deque() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldHead = head;
        head = new Node();
        head.next = oldHead;
        head.prev = null;
        head.item = item;
        if (isEmpty()) last = head;
        else oldHead.prev = head;
        size++;

    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldLast = last;
        last = new Node();
        last.prev = oldLast;
        last.next = null;
        last.item = item;
        if (isEmpty()) head = last;
        else oldLast.next = last;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Node oldHead = head;
        head = oldHead.next;
        size--;
        if (isEmpty()) last = null;
        else head.prev = null;
        return oldHead.item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new IllegalArgumentException();
        Node oldLast = last;
        last = oldLast.prev;
        size--;
        if (isEmpty()) head = null;
        else last.next = null;
        return oldLast.item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        Node current = head;

        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


    public static void main(String[] args) {
        Deque<Integer> test = new Deque<Integer>();
        test.addFirst(1);
        System.out.println(test.removeLast());
        test.addFirst(2);
        System.out.println(test.removeLast());
    }


}
