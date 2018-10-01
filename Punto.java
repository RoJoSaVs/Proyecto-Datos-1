package dots;

public class Punto extends Node {
    private int x;
    private int y;
    private int columna;
    private int fila;
    private LinkedList rect = new LinkedList();
    private LinkedList vecinos= new LinkedList();
    private LinkedList enlazados= new LinkedList();
    private LinkedList enlazadosAux=enlazados;
    private boolean estado=false;
    
    public void setPos(int columna,int fila){
        this.columna=columna;
        this.fila=fila;
        
    }
    public int getColumna(){
        return this.columna;
    }
    public int getFila(){
        return this.fila;
    }
    
    public boolean enlazar(Punto newEnlace){
        int c = this.vecinos.size()-1;
        while (c>0){
            if(newEnlace==this.vecinos.recorrer(c)){
                int c2=this.enlazados.size();
                while(c2>0){
                    if(newEnlace==this.enlazados.recorrer(c)){
                        return false;
                    }
                    else{
                        c2--;
                    }
                }
                this.enlazados.insertFirst(newEnlace);
                return true;
            }
            else{
                c--;
            }
        }
        return false;
    }

    public void setEstado(){
        if (this.estado==false){
            this.estado=true;
        }
        else{
            this.estado=false;
        }
    }
    public boolean getEstado(){
        return this.estado;
    }
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
        this.vecinos.insertFirst(vecino);
    }
    public void agregarEnlazado(Punto vecino){
        this.enlazados.insertFirst(vecino);
    }
    public boolean Enlazado(Punto verif){
        int recorrido= this.enlazados.size();
        while (recorrido>0){
            if(verif==this.enlazados.recorrer(recorrido)){
                return true;
            }
            else{
                recorrido--;
            }
        }
        return false;
    }
}
