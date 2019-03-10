package by.epam.minchuk.task1.model.collection.collectionImpl;

import by.epam.minchuk.task1.model.collection.MyCollection;

public abstract class MyAbstractCollection<E> implements MyCollection<E> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
