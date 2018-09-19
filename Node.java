package dots;
/**
 *
 * @author Andrey
 */
public class Node{
    private Object data;
    private Node next;


    public Node(){
        this.next=null;
    }
    public Object getData(){
        return this.data;
    }
    public void setData(Object data){
        this.data=data;
    }
    public Node getNext(){
        return this.next;
    }
    public void setNext(Node node){
        this.next=node;
    }
   
}
