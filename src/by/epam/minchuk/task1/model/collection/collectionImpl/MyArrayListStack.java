package by.epam.minchuk.task1.model.collection.collectionImpl;

import by.epam.minchuk.task1.model.collection.MyStack;

public class MyArrayListStack<E> extends MyArrayList<E> implements MyStack<E> {

    public MyArrayListStack() {
    }

    @Override
    public void push(E e) {
        super.add(e);
    }

    @Override
    public E pop() {
        if (elementData.length != 0 && size != 0) {
            E element = (E) elementData[size - 1];
            Object [] current = new Object[elementData.length-1];
            for (int i = 0; i < elementData.length - 1; i++) {
                current[i] = elementData[i];
            }
            size--;
            elementData = current;
            return  element;
        }
        return null; //TODO throw exception !! delete null
    }

    @Override
    public E peek() {  //TODO throw exception
        if (elementData.length != 0) {
            return (E) elementData[elementData.length - 1];
        }
        return null;
    }
}
