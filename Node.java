package dots;

/**
 * Clase: Node
 * @autor Andrey Sanchez
 * @autor Ronny Santamaria
 * @autor Jose Solano
 * @version 01.10.2018
 */

public class Node{
    private Object data;
    private Node next;
    
    /**
    * Constructor
    */

    public Node(){
        this.next=null;
    }
    
    /**
     * Getter
     * @return data
     */
    
    public Object getData(){
        return this.data;
    }
    
    /**
     * Setea la informacion del nodo
     * @param data
     */
    
    public void setData(Object data){
        this.data=data;
    }
    
    /**
     * Getter
     * @return next
     */
    
    public Node getNext(){
        return this.next;
    }
    
    /**
     * Setea el siguiente nodo
     * @param node
     */
    
    public void setNext(Node node){
        this.next=node;
    }

}
