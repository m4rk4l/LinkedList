package m4rk4l.LinkedList;

/**
 * interface for MyList.
 *
 * @author Marco Anton
 */
public interface MyList<E> {

    public void add(E element);

    public void remove(E element);

    public E peek();

    public String print();
}
