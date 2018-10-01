package dots;

public class Jugador {
    private int puntaje;
    private int turno;
    private boolean activo= false;
    
    public Jugador(int turno){
        this.turno=turno;
    }
    public boolean getEstado(){
        return this.activo;
    }
    public void setEstado(){
        if (this.activo){
            this.activo=false;
        }
        else{
            this.activo=true;
        }
    }
    public int getTurn(){
        return this.turno;
    }
    public void setPuntos(int puntos){
        this.puntaje+= puntos;
    }
    public int getPuntaje(){
        return this.puntaje;
    }

}
