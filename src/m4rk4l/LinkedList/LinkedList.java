package m4rk4l.LinkedList;

/**
 * Implementing a generic linked list. The linked list will simulate a stack
 * data structure. The add method will behave normally; however, the remove
 * will look for a given element and remove it.
 *
 * @author Marco Anton
 */
public class LinkedList<E> implements MyList<E> {
    
    /**
     * Class that represents a node in our linked list.
     */
    private class Node<E> {

        /** An element for this node. */
        E element;
        /** A pointer to the next node. */
        Node<E> next;

        /**
         * Creates a node with a given element and a pointer to the next
         * element.
         * @param element is an element to add to the list.
         * @param next is a pointer to the next element in the list.
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /** represents the root of the linked list. */
    Node<E> root;

    /**
     * Constructor for my linked list.
     * For now it only initializes our root to null. which is done
     * automagically if i dont set it here.
     */
    public LinkedList() {
        root = null;
    }

    /**
     * adds an element to the linked list. Since simulating a stack the element
     * will be added to the end of the list.
     * @param element is an element to add to the stack.
     */
    public void add(E element) {
        Node<E> cur = root;
        Node<E> newNode = new Node<E>(element, null);

        if (cur == null) {
            root = newNode;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    /**
     * shows the last element on the list.
     * @return element  is the last element on the list.
     */
    public E peek() {
        E elem = null;
        Node<E> cur = root;
        Node<E> prev = root;

        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }

        if (prev != null) {
            elem = prev.element;
        }

        return elem;
    }

    /**
     * removes an element from the linked list
     * @param element is an element to remove.
     */
    public void remove(E element) {
        Node<E> cur = root;
        Node<E> prev = root;

        // boundary conditions.
        if (root.element == element && root.next == null) {
            root = null;
        } else if (root.element == element && root.next != null) {
            root = root.next;
        }

        while (cur != null) {
            if (cur.element == element) {
                prev.next = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
        
    }

    /**
     * overloads the remove method. This method should remove the last element
     * on the list.
     * TODO: somehow it is not deleting the last element
     * @return the element removed.
     */
    public E remove() {
        E elem = null;
        Node<E> cur = root;
        Node<E> prev = root;

        while(cur != null) {
            prev = cur;
            cur = cur.next;
        }

        if (prev != null) {
            elem = prev.element;
            prev.next = null;
        }

        return elem;
    }

    /**
     * Prints the elements in our list.
     * @return list is a string containing the elements in the list.
     */
    public String print() {
        String list;
        Node<E> cur = root;

        list = "[ ";

        while (cur != null) {
            list += cur.element;
            cur = cur.next;
            if (cur != null) {
                list += ", ";
            }
        }

        list += " ]";

        return list;
    }
}

