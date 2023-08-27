package com.licifer.my;

import java.util.Iterator;

/**
 * @Author: LiCifer
 * @Dscription 使用单链表实现
 * @Date: Created in 14:09 2023/8/27
 */
public class MyLinkedList2<E> extends AbstractMyList<E>{

    private final Node<E> head;
    private final Node<E> tail;

    public MyLinkedList2() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.next = null;
        this.size = 0;
    }

    @Override
    public void addLast(E e) {
        Node<E> x = new Node<>(e);
        if (size == 0) {
            addFirst(e);
        }
        Node<E> last = getNode(size - 1);
        last.next = x;
        x.next = tail;
        size++;
    }

    @Override
    public void add(int index, E e) {
        checkPosition(index);
        if (size == 0 || index == 0) {
            addFirst(e);
            return;
        }
        if (index == size) {
            addLast(e);
            return;
        }

        Node<E> x = new Node<E>(e);
        Node<E> temp = getNode(index);
        int prevIndex = index - 1;
        Node<E> prev = getNode(prevIndex);
        prev.next = x;
        x.next = temp;
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> x = new Node<>(e);
        Node<E> first = head.next;
        head.next = x;
        x.next = first;
        size++;
    }

    @Override
    public E remove(int index) {

        checkElement(index);

        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> prev = getNode(index - 1);
        Node<E> temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        return temp.val;
    }

    @Override
    public E removeLast() {
        if (size == 1) {
            return removeFirst();
        }
        Node<E> prev = getNode(size - 2);
        Node<E> last = prev.next;
        prev.next = tail;
        size--;
        return last.val;
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<E> temp = head.next;
        head.next = temp.next;
        size--;
        return temp.val;
    }

    @Override
    public E get(int index) {
        checkElement(index);
        return getNode(index).val;
    }

    @Override
    public void set(int index, E e) {
        checkElement(index);
        Node<E> node = getNode(index);
        node.val = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> curr = head.next;
            @Override
            public boolean hasNext() {
                return curr != tail;
            }

            @Override
            public E next() {
                E val = curr.val;
                curr = curr.next;
                return val;
            }
        };
    }

    private MyLinkedList2.Node<E> getNode(int index) {
        checkElement(index);
        MyLinkedList2.Node<E> curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private static class Node<E> {
        private E val;
        private Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList2<Integer> linkedList2 = new MyLinkedList2<Integer>();
//        linkedList2.addLast(1);
//        linkedList2.addLast(2);

//        linkedList2.addFirst(1);
//        linkedList2.addFirst(2);

        linkedList2.add(0, 1);
        linkedList2.add(1, 2);
        linkedList2.add(0, 3);

//        linkedList2.removeFirst();
//        linkedList2.removeFirst();

//        linkedList2.removeLast();
//        linkedList2.removeLast();

//        Integer remove = linkedList2.remove(1);
//        Integer remove2 = linkedList2.remove(1);

//        Integer i = linkedList2.get(2);
//        System.out.println(i);
        linkedList2.set(1, 9);
        linkedList2.forEach(System.out::println);
    }
}
