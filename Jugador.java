package dots;

public class Jugador {
    private LinkedList figuras;
    private int puntaje;
    private int turno;
    
    public Jugador(int turno){
        this.turno=turno;
    }
    

    public void setFigura(Figura nueva){
        figuras.insertFirstN(nueva);

    }


}
