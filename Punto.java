package dots;

import static java.lang.Math.abs;

/**
 *
 * @author Andrey
 */
public class Punto extends Node {
    private int x;
    private int y;
    private LinkedList vecinos;

    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void agregarVecino(Node vecino){
        vecinos.insertFirst(vecino.getData());
    }
    public void borrarVecino(Node vecino){
        vecinos.delete(vecino.getData());
    }
}
