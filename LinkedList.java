package dots;

/**
 * Clase: LinkedList
 * @autor Andrey Sanchez
 * @autor Ronny Santamaria
 * @autor Jose Solano
 * @version 01.10.2018
 */

public class LinkedList{
    private Node head;
    private int size;
    
    /**
     * Constructor
     * 
     */

    public LinkedList(){
        this.head= null;
        this.size=0;
    }
    
    /**
     * Getter
     * @return head 
     */
    
    public boolean isEmpty(){
        return this.head==null;
    }
    
    /**
     * Getter
     * @return size 
     */
    
    public int size(){
        return this.size;
    }
    
    /**
     * Inserta un nuevo nodo al inicio
     * @param data 
     */
    
    public void insertFirst(Object data){
        Node newNode= new Node();
        newNode.setData(data);
        newNode.setNext(this.head);
        this.head=newNode;
        this.size++;
    }
    
    /**
     * Borra el primer nodo
     * @return null 
     */
    
    public Node deleteFirst(){
        if(this.head != null){
            Node temp= this.head;
            this.head= this.head.getNext();
            this.size--;
        }
        return null;
    }
    
    /**
     * Muestra los nodos de la lista uno por uno
     * 
     */
    
    public void displayList(){
        Node current= this.head;
        while(current != null){
            System.out.println(current.getData());
            current=current.getNext();
        }
    }
    
    /**
     * Metodo para buscar nodos
     * @param searchValue
     * @return Node
     */
    
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
    
    /**
     * Borra el nodo introducido
     * @param searchValue 
     */
    
    public Node delete(Object searchValue){
        Node current= this.head;
        Node previous= this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                if (current.equals(this.head)){
                    this.head = this.head.getNext();
                }
                else{
                    previous.setNext(current.getNext());
                }
            this.size--;
            return current;
            }
            else{
                previous= current;
                current=current.getNext();
            }
        }
        return null;
    }
    
    /**
     * Inserta un nodo al final de la lista
     * @param data 
     */

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
    
    /**
     * Metodo para recorrer y obtener un nodo
     * @param i
     * @return Object
     */
    
    public Object recorrer(int i){
        Node current = this.head;
        while(i > 0){
            current = current.getNext();
            i -= 1;
        }
        return current.getData();
    }
}
