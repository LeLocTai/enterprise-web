package repository;

public interface Repository<T> {
    /**
     * 
     * @param item
     * @return number of rows affected
     */
    int add(T item);
    T get(int id);
}
