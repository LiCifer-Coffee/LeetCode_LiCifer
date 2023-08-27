package com.licifer.my;

import java.util.Iterator;

/**
 * @Author: LiCifer
 * @Dscription  使用双链表实现
 * @Date: Created in 09:43 2023/8/27
 */
public class MyLinkedList<E> extends AbstractMyList<E> {

    private Node<E> head;

    private Node<E> tail;

    public MyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    @Override
    public void addLast(E e) {

        Node<E> newNode = new Node<>(e);
        Node<E> last = tail.prev;

        newNode.next = tail;
        newNode.prev = last;

        last.next = newNode;
        tail.prev = newNode;

        size++;

    }

    @Override
    public void add(int index, E e) {
        checkPosition(index);

        if (index == size) {
            addLast(e);
            return;
        }

        Node<E> x = new Node<>(e);
        Node<E> temp = getNode(index);
        Node<E> prev = temp.prev;

        x.next = temp;
        x.prev = temp.prev;

        temp.prev = x;
        prev.next = x;

        size++;
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public E remove(int index) {
        checkElement(index);
        Node<E> node = getNode(index);
        Node<E> next = node.next;
        Node<E> prev = node.prev;
        prev.next = next;
        next.prev = prev;

        node.prev = node.next = null;

        size--;
        return node.val;
    }

    @Override
    public E removeLast() {
        Node<E> last = tail.prev;
        Node<E> prev = last.prev;
        prev.next = tail;
        tail.prev = prev;
        last.prev = last.next = null;
        size--;
        return last.val;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.val;
    }

    @Override
    public void set(int index, E e) {
        Node<E> node = getNode(index);
        node.val = e;
    }

    private Node<E> getNode(int index) {
        checkElement(index);
        Node<E> curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> curr = head.next;
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

    private static class Node<E>{
        private E val;

        private Node<E> prev;

        private Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
//        linkedList.addLast(1);
//        linkedList.addLast(2);
//        linkedList.addLast(3);
        linkedList.add(0, 1);
        linkedList.add(0, 2);
        linkedList.add(0, 3);

//        linkedList.remove(0);
//        linkedList.remove(1);

//        linkedList.removeLast();
//        linkedList.removeLast();

//        Integer i = linkedList.get(1);
//        System.out.println(i);

//        linkedList.remove(1);

        linkedList.set(1, 6);
        linkedList.forEach(System.out::println);
    }



}
