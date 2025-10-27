package DLL;

public class Node<T>{
    T element;
    Node previous;
    Node next;

    public Node (T element){
        this.element = element;
        this.previous = null;
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}