package dots;

/**
 * Clase: Punto
 * @autor Andrey Sanchez
 * @autor Ronny Santamaria
 * @autor Jose Solano
 * @version 01.10.2018
 */

public class Punto extends Node {
    private int x;
    private int y;
    private int columna;
    private int fila;
    private LinkedList rect = new LinkedList();
    private LinkedList vecinos= new LinkedList();
    private LinkedList enlazados= new LinkedList();
    private LinkedList enlazadosAux=new LinkedList();
    private boolean estado=false;
    
    /**
     * Setea la posicion y columna del punto
     * @param columna
     * @param fila
     */
    
    public void setPos(int columna,int fila){
        this.columna=columna;
        this.fila=fila;
        
    }
    
    /**
     * Getter
     * @return columna
     */
    
    public int getColumna(){
        return this.columna;
    }
    
    /**
     * Getter
     * @return fila
     */
    
    public int getFila(){
        return this.fila;
    }
    
    /**
     * Establece un enlace con otro punto
     * @param newEnlace
     */
    
    public void enlazar(Punto newEnlace){
        this.enlazados.insertFirst(newEnlace);
        this.enlazadosAux.insertFirst(newEnlace);
    }
    
    /**
     * Verifica si puede enlazar o no con otro punto
     * @param newEnlace
     * @return boolean
     */
    
    public boolean puedeEnlazar(Punto newEnlace){
        int c = this.vecinos.size()-1;
        while (c>=0){
            if(newEnlace==this.vecinos.recorrer(c)){
                int c2=this.enlazados.size()-1;
                while(c2>=0){
                    if(newEnlace==this.enlazados.recorrer(c2)){
                        return false;
                    }
                    else{
                        c2--;
                    }
                }
                return true;
            }
            else{
                c--;
            }
        }
        return false;
    }

    /**
     * Hace cambio de estado al llamarla
     * 
     */
    
    public void setEstado(){
        if (this.estado==false){
            this.estado=true;
        }
        else{
            this.estado=false;
        }
    }
    
    /**
     * Getter
     * @return estado
     */
    
    public boolean getEstado(){
        return this.estado;
    }
    /**
     * Hace set de la posicion en X y Y en la ventana
     * @param x
     * @param y
     */
    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * Getter
     * @return x
     */
    
    public int getX(){
        return this.x;
    }
    
    /**
     * Getter
     * @return y
     */
    
    public int getY(){
        return this.y;
    }
    
    /**
     * Establece las dimensiones del rectangulo donde se dibujara el punto en
     * la interfaz
     * @param rectX
     * @param rectY
     * @param grosX
     * @param grosY
     */
    
    public void setRect(int rectX, int rectY, int grosX, int grosY){
        rect.insertFirst(grosY);
        rect.insertFirst(grosX);
        rect.insertFirst(rectY);
        rect.insertFirst(rectX);
    }
    
    /**
     * Getter
     * @return rect
     */
    
    public LinkedList getRect(){
      return this.rect;
    }
    
    /**
     * Getter
     * @return vecinos
     */
    
    public LinkedList getVecinos(){
        return this.vecinos;
    }

    /**
     * Getter
     * @return enlazados
     */
    
    public LinkedList getEnlazados(){
        return this.enlazados;
    }
    
    /**
     * Getter
     * @return enlazadosAux
     */
    
    public LinkedList getAux(){
        return this.enlazadosAux;
    }
    
    /**
     * Setea la lista auxiliar de enlazados
     * @param newAux
     */
    
    public void setAux(LinkedList newAux){
        this.enlazadosAux= newAux;
    }
    
    /**
     * Inserta un punto de primero en la lista vecinos
     * @param vecino
     */
    
    public void agregarVecino(Punto vecino){
        this.vecinos.insertFirst(vecino);
    }
    
    /**
     * Inserta un punto de primero en la lista enlazados
     * @param vecino
     */
    
    public void agregarEnlazado(Punto vecino){
        this.enlazados.insertFirst(vecino);
    }
    
    /**
     * Verifica si el punto esta enlazado con otro
     * @param verif
     * @return boolean
     */
    
    public boolean Enlazado(Punto verif){
        int c=this.enlazadosAux.size()-1;
        while(c>=0){
            if(verif==this.enlazadosAux.recorrer(c)){
                return true;
            }
            else{
                c--;
            }
        }
        return false;
    }
}
