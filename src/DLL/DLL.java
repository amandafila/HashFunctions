package DLL;

public class DLL<T>{
    Node <T> base;
    Node <T> top;
    int size;

    public DLL(){
        this.base = null;
        this.top = null;
        this.size = 0;
    }

    public void add(T element){
        Node<T> no = new Node(element);
        if (base == null){
            base = no;
            top = no;
        }else{
            top.next = no;
            no.previous = top;
            top = no;
        }
        size++;
    }

    public void add(T element, int pos){
        Node<T> no = new Node(element);
        Node<T> noAtual = getNode(pos);

        no.previous = noAtual.previous;
        no.next = noAtual;
        noAtual.previous.next = no;
        noAtual.previous = no;
    }

    public void remove(int pos){
        //resolver excessões
        Node<T> no = getNode(pos);
        no.previous.next = no.next;
        no.next.previous = no.previous;
    }

    public boolean remove(T element){
        Node<T> temp = base;
        int idx = 0;
        while (true){
            if (element.equals(temp.element) ){
                remove(idx  );
                return true;
            }
            temp = temp.next;
            idx++;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public T get(int pos){
        Node<T> no = getNode(pos);
        return no.element;
    }

    public void set(int pos, T element){
        Node<T> no = getNode(pos);
        no.element = element;
    }


    private Node getNode(int pos){
        int half = size / 2;
        if (pos <= half){
            int idx = 0;
            Node<T> temp = base;
            while (true){
                if (idx == pos){
                    return temp;
                }
                temp = temp.next;
                idx++;
            }
        } else{
            Node<T> temp = top;
            int idx = size - 1;
            while (true){
                if (idx == pos){
                    return temp;
                }
                temp = temp.previous;
                idx--;
            }
        }
    }

    public void print(){
        Node<T> temp = base;
        while (temp != null){
            System.out.println(temp.getElement());
            temp = temp.next;
        }
    }
}
