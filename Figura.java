package dots;

/**
 *
 * @author Andrey
 */
public class Figura {
    private LinkedList tria= new LinkedList();
    private LinkedList Aocupada= new LinkedList();
    private LinkedList fCreadas= new LinkedList();
    private int lineas;
    
    public int getLineas(){
        return this.lineas;
    }
    
    public int getPuntos(Figura creada){
        int puntos= creada.getLineas()*2;
        return puntos;
        
        
        
    }
    
}
