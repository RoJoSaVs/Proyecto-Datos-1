package dots;


/**
 *
 * @author Andrey
 */
public class Constructor {
    private LinkedList Fila1= new LinkedList();
    
    public void Matriz(int tamaño){
        int size=tamaño;
        while(tamaño>0){
            int c = size;
            int c1=tamaño-1;
            LinkedList columna = new LinkedList();
            while (c>0){
                Node punto= new Node();
                punto.setData(c1);
                columna.insertFirst(punto.getData());
                c--;
            }
            columna.displayList();
            Fila1.insertFirst(columna);
            tamaño--;
        }
        
    }
    public LinkedList getLista(){
        return this.Fila1;
    }
    
}
