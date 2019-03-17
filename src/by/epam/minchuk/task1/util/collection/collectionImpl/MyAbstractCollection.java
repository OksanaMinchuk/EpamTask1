package by.epam.minchuk.task1.util.collection.collectionImpl;

import by.epam.minchuk.task1.util.collection.MyCollection;

public abstract class MyAbstractCollection<E> implements MyCollection<E> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
