package dots;

public class Punto extends Node {
    private int x;
    private int y;
<<<<<<< HEAD
    private LinkedList rect = new LinkedList();
=======
>>>>>>> 7d5c6c71511627485a8e156d5370ad78d71c778b
    private LinkedList vecinos;
    private LinkedList enlazados;
    private LinkedList enlazadosAux=enlazados;
    private boolean estado=false;
<<<<<<< HEAD

=======
    
>>>>>>> 7d5c6c71511627485a8e156d5370ad78d71c778b
    public void setEstado(){
        if (this.estado==false){
            this.estado=true;
        }
        else{
            this.estado=false;
        }
    }
<<<<<<< HEAD

    public boolean getEstado(){
        return this.estado;
    }

=======
    
    public boolean getEstado(){
        return this.estado;
    }
    
>>>>>>> 7d5c6c71511627485a8e156d5370ad78d71c778b
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
<<<<<<< HEAD
    public void setRect(int rectX, int rectY, int grosX, int grosY){
        rect.insertFirstN(grosY);
        rect.insertFirstN(grosX);
        rect.insertFirstN(rectY);
        rect.insertFirstN(rectX);
    }
    public LinkedList getRect(){
      return this.rect;
    }
    public LinkedList getVecinos(){
        return this.vecinos;
    }
    public void agregarVecino(Node vecino){
        vecinos.insertFirstN(vecino.getData());
    }

    public LinkedList getVecinos(){
        return this.vecinos;
    }
=======
    public LinkedList getVecinos(){
        return this.vecinos;
    }
>>>>>>> 7d5c6c71511627485a8e156d5370ad78d71c778b
    public LinkedList getEnlazados(){
        return this.enlazados;
    }
    public LinkedList getAux(){
        return this.enlazadosAux;
    }
    public void setAux(LinkedList newAux){
        this.enlazadosAux= newAux;
    }
    public void agregarVecino(Punto vecino){
        vecinos.insertFirstP(vecino.getX(),vecino.getY(),vecino.getData());
    }
    public void agregarEnlazado(Punto vecino){
        enlazados.insertFirstP(vecino.getX(),vecino.getY(),vecino.getData());
    }
    public boolean Enlazado(Punto verif){
        int recorrido= this.enlazados.size();
        while (recorrido>0){
            if(verif.getX() == this.enlazados.recorrerL(recorrido).getX() && verif.getY() == this.enlazados.recorrerL(recorrido).getY() ){
                return true;
            }
            else{
                recorrido--;
            }
        }
        return false;
    }
}
