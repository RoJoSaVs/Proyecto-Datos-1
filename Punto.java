package dots;

public class Punto extends Node {
    private int x;
    private int y;
    private LinkedList rect;
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
    public void setRect(int rectX, int rectY, int grosX, int grosY){
        rect.insertFirst(grosY);
        rect.insertFirst(grosX);
        rect.insertFirst(rectY);
        rect.insertFirst(rectX);
    }
    public LinkedList getRect(){
      return this.rect;
    }
    public LinkedList getVecinos(){
        return this.vecinos;
    }
    public void agregarVecino(Node vecino){
        vecinos.insertFirst(vecino.getData());
    }
    public void borrarVecino(Node vecino){
        vecinos.delete(vecino.getData());
    }
}
