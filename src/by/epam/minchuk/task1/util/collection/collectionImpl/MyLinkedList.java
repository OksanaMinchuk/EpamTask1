package by.epam.minchuk.task1.util.collection.collectionImpl;

public class MyLinkedList<E> extends MyAbstractCollection<E> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E[] toArray(E[] a) {
        return null;
    }

    //TODO equals, hashCode, toString
}
