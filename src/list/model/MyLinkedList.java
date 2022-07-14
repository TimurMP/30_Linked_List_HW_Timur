package list.model;

import list.interfaces.IList;

import java.util.Iterator;

public class MyLinkedList<E> implements IList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;



    @Override
    public boolean add(E element) {

        Node<E> newNode = new Node<E>(last, element, null);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E element) {


        Node<E> nodeAfter = getNodeByIndex(index);
        if (nodeAfter == first){
            Node<E> newNode = new Node<E>(null, element, first);
            first.prev = newNode;
            first = newNode;
            size++;
            return true;
        }
        if (nodeAfter == last){
            Node<E> newNode = new Node<E>(last, element, null);
            last.next = newNode;
            last = newNode;
            size++;
            return true;
        }


        Node<E> nodeBefore = getNodeByIndex(index-1);

        Node<E> newNode = new Node<E>(nodeBefore, element, nodeAfter);
        nodeBefore.next = newNode;
        nodeAfter.prev = newNode;
        size++;
        return true;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            Node<E> node = getNodeByIndex(0);

            Node<E> prev = node.prev;
            Node<E> next = node.next;
            if (prev != null) {
                prev.next = next;
                node.prev = null;
            } else {
                first = next;
            }
            if (next != null) {
                next.prev = prev;
                node.next = null;
            } else {
                last = prev;
            }
            node.data = null;
        }
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node.data;
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o != null) {
            for (Node<E> x = first; x != null; x = x.next, index++) {
                if (o.equals(x.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next, index++) {
                if (o == x.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o != null) {
            for (Node<E> x = last; x != null; x = x.prev, index--) {
                if (o.equals(x.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev, index--) {
                if (o == x.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);
        return unlink(node);
    }

    private E unlink(Node<E> node) {
        E victim = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev != null) {
            prev.next = next;
            node.prev = null;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
            node.next = null;
        } else {
            last = prev;
        }
        node.data = null;
        size--;
        return victim;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);
        E victim = node.data;
        node.data = element;
        return victim;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 0;
//            Node<E> node = first;


            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                Node<E> node = getNodeByIndex(count);
                count++;
                return node.data;
            }
        };
    }

    private static class Node<E> {
        Node<E> prev;
        E data;
        Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }


}