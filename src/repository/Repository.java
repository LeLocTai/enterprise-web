package repository;

import java.util.ArrayList;

public interface Repository<T> {
    T get(int id);
    ArrayList<T> getAll();
    /**
     * 
     * @param item
     * @return number of rows affected
     */
    int add(T item);

    /**
     * 
     * @param item should be retrieve from the database through the {@link #add(Object) add} method first
     * @return
     */
    int update(T item);
    int remove(int id);
}
