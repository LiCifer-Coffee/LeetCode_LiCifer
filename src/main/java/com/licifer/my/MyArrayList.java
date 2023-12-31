package com.licifer.my;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: LiCifer
 * @Date: Created in 22:40 2023/8/25
 */
public class MyArrayList<E> extends AbstractMyList<E> {

    protected E[] data;
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        this.data = (E[]) new Object[initCapacity];
        size = 0;
    }

    @Override
    public  void addLast(E e) {
        int capacity = data.length;
        if (size == capacity) {
            resize(capacity * 2);
        }
        data[size] = e;
        size++;
    }

    @Override
    public void add(int index, E e) {
        checkPosition(index);
        int capacity = data.length;
        if (size == capacity) {
            resize(capacity * 2);
        }
        // 1. 数组index部分整体往后移动一位
        System.arraycopy(data, index, data, index + 1, size - index);
        // 2. 插入新元素
        data[index] = e;
        // 3. 数组元素加一
        size++;
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public E remove(int index) {
        checkElement(index);
        // 1. 数组复制（不是移动），注意复制后的数组最后一个元素还存在值
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        // 2. 将数组最后一位置位空
        data[size - 1] = null;
        // 3. 数组元素减一
        size--;
        // 4. 判断删除后的新数组是否需要缩容
        if (size <= data.length >> 1) {
            resize(data.length >> 1);
        }
        return data[index];
    }

    @Override
    public E removeLast() {
        E lastData = data[size - 1];
        data[size - 1] = null;
        size--;
        if (size <= data.length >> 1) {
            resize(data.length >> 1);
        }
        return lastData;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E get(int index) {
        checkElement(index);
        return data[index];
    }

    @Override
    public void set(int index, E e) {
        checkElement(index);
        data[index] = e;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index != size;
            }

            @Override
            public E next() {
                return data[index++];
            }
        };
    }

    // 创建一个新的数组，用于扩容和缩容
    private void resize(int newCap) {
        if (size > newCap) {
            return;
        }
        E[] temp = (E[]) new Object[newCap];
        System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(4);
        myArrayList.add(0, 1);
        myArrayList.add(1, 2);
        myArrayList.add(2, 3);
        myArrayList.add(3, 4);
        myArrayList.add(4, 5);

//        Integer remove = myArrayList.remove(1);
        Integer last = myArrayList.removeLast();
//        myArrayList.removeFirst();
        Integer get = myArrayList.get(2);
        System.out.println(get);
        myArrayList.set(3, 9);
//        myArrayList.forEach(System.out::println);
        System.out.println(myArrayList);


    }

}
