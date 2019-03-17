package by.epam.minchuk.task1.util.collection.collectionImpl;

import by.epam.minchuk.task1.util.collection.MyQueue;

public class MyArrayListQueue<E> extends MyArrayList<E> implements MyQueue<E> {

    public MyArrayListQueue() {
    }

    @Override
    public E element() {
        if (elementData.length !=0) {
            return (E) elementData[0];
        }
        return null; //TODO throw exception !! delete null
    }

    @Override
    public E remove() {
        if (elementData.length != 0 && size != 0) {
            E element = (E) elementData[size - 1];
            Object [] current = new Object[elementData.length-1];
            for (int i = 0; i < elementData.length - 1; i++) {
                current[i] = elementData[i];
            }
            size--;
            elementData = current;
        }
        return null; //TODO throw exception !!  delete null
    }

    @Override
    public E poll() {
       element();
        return null; //TODO throw exception !! null - if this queue is empty
    }

    @Override
    public E peek() {
        remove();
        return null; //TODO throw exception !! null - if this queue is empty
    }
}


