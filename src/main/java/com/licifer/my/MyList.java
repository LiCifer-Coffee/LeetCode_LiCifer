package com.licifer.my;

/**
 * @Author: LiCifer
 * @Date: Created in 11:34 2023/8/27
 */
public interface MyList<E> extends Iterable<E>{

    void addLast(E e);

    void add(int index, E e);

    void addFirst(E e);

    E remove(int index);

    E removeLast();

    E removeFirst();

    E get(int index);

    void set(int index, E e);

}
