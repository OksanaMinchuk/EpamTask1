package by.epam.minchuk.task1.model.collection.collectionImpl;

import java.util.Arrays;

public class MyArrayList<E> extends MyAbstractCollection<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    protected Object[] elementData;
    protected int size;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    public E get(int index){
        if (index >= 0 && index < size) {
            return (E) elementData[index];
        }
        return null; //TODO throw exception
    }


    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     *
     */
    public E set (int index, E element){
        if (index >= 0 && index < size) {
            E oldValue = (E) elementData[index];
            elementData[index] = element;
            return oldValue;
        }
        return null;  //TODO throw exception
    }

    public boolean removeAt(int index) { //TODO throw exception
        boolean result = false;
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elementData[i] = elementData[i + 1];
            }
            elementData[--size] = null;
            result = true;
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) { //TODO throw exception
        boolean result = false;
        if (o != null) {
            for (Object elem: elementData) {
                if (o.equals(elem)) {
                    result = true;
                }
            }
            result = false;
        }
        return result;
    }

    @Override
    public boolean add(E e) { //TODO throw exception
        if (e != null) {
            if (size == elementData.length) {
                elementData = Arrays.copyOf(elementData, size + 1);
            }
            elementData[size++] = e;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) { //TODO throw exception
        boolean result = false;
        if (o != null) {
            for (int i = 0; i <elementData.length; i++) {
                if (o.equals(elementData[i])) {
                    removeAt(i);
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public void clear() {
        elementData = new Object[0];
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                if (i < size) {
                    array[i] = (E) elementData[i];
                } else {
                    array[i] = null;
                }
            }
        }
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<?> that = (MyArrayList<?>) o;

        if (size != that.size) return false;
        return Arrays.equals(elementData, that.elementData);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(elementData);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            buffer.append(elementData[i]);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
