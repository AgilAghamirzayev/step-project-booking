package dao;
import java.io.IOException;
import java.util.Collection;

public interface DAO<T> {

    Collection<T> getAll();
    void create(T data);
    void delete(int id);
    void write() throws IOException;

}
