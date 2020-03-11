package dao;
import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {

    T get(int id);
    Collection<T> getAll() throws IOException, ClassNotFoundException, InterruptedException;
    void create(T data);
    void delete(int id);
    void write();
    void read();
}
