package dots;

public class LinkedList{
    private Node head;
    private int size;

    public LinkedList(){
        this.head= null;
        this.size=0;
    }
    public boolean isEmpty(){
        return this.head==null;
    }
    public int size(){
        return this.size;
    }
    public void insertFirstN(Object data){
        Node newNode= new Node();
        newNode.setData(data);
        newNode.setNext(this.head);
        this.head=newNode;
        this.size++;
    }
    public void insertFirstP(int x,int y,Object data){
        Punto newNode= new Punto();
        newNode.setData(data);
        newNode.setXY(x,y);
        newNode.setNext(this.head);
        this.head=newNode;
        this.size++;
    }
    public Node deleteFirst(){
        if(this.head != null){
            Node temp= this.head;
            this.head= this.head.getNext();
            this.size--;
        }
        return null;
    }
    public void displayList(){
        Node current= this.head;
        while(current != null){
            System.out.println(current.getData());
            current=current.getNext();
        }
    }
    public Node find(Object searchValue){
        Node current= this.head;
        while(current != null){
            if (current.getData().equals(searchValue)){
            return current;
            }
            else{
                current=null;
            }
        }
        return null;
    }
    public Node delete(Object searchValue){
        Node current= this.head;
        Node previous= this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                if (current.equals(this.head)){
                    this.head = head.getNext();
                }
                else{
                    previous.setNext(current.getNext());
                }
            return current;
            }
            else{
                previous= current;
                current=current.getNext();
            }
        }
        return null;
    }
    public void insertLast(Object data){
        if (this.head==null) {
            Node nuevo = new Node();
            nuevo.setData(data);
            this.head = nuevo;

        }
        else {
            Node head = this.head;
            Node current_last = head;
            while (head!=null){
		current_last = head;
		head = head.getNext();
            }
            Node nuevo = new Node();
            nuevo.setData(data);
            current_last.setNext(nuevo);
        }
        this.size++;
    }
    public Object recorrer(int i){
        Node current = this.head;
        while(i > 0){
            current = current.getNext();
            i -= 1;
        }
        return current.getData();
    }
    public Punto recorrerL(int i){
        Punto current = (Punto) this.head;
        while(i > 0){
            current = (Punto) current.getNext();
            i -= 1;
        }
        return current;
    }
}
