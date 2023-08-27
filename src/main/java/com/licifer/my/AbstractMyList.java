package com.licifer.my;

/**
 * @Author: LiCifer
 * @Date: Created in 11:38 2023/8/27
 */
public abstract class AbstractMyList<E> implements MyList<E> {
    // 容器中元素个数
    protected int size;

    // 检查index是否存在元素
    protected boolean isElement(int index) {
        return index >= 0 && index < size;
    }

    // 检查index是否可以添加元素
    protected boolean isPosition(int index) {
        return index >= 0 && index <= size;
    }

    protected void checkPosition(int index) {
        if (!isPosition(index)) {
            throw new IndexOutOfBoundsException("数组越界");
        }
    }

    protected void checkElement(int index) {
        if (!isElement(index)) {
            throw new IndexOutOfBoundsException("数组越界");
        }
    }

}
