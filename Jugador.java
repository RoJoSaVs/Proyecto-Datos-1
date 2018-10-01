package dots;

/**
 * Clase: Jugador
 * @autor Andrey Sanchez
 * @autor Ronny Santamaria
 * @autor Jose Solano
 * @version 01.10.2018
 */

public class Jugador {
    private int puntaje;
    private int turno;
    private boolean activo= false;
    
    /**
     * Constructor
     * @param turno 
     */

    public Jugador(int turno){
        this.turno=turno;
    }
    
    /**
     * Getter
     * @return activo 
     */
    
    public boolean getEstado(){
        return this.activo;
    }
    
    /**
     * Hace cambio de estado al hacer la llamada
     *
     */
    
    public void setEstado(){
        if (this.activo){
            this.activo=false;
        }
        else{
            this.activo=true;
        }
    }
    
    /**
     * Getter
     * @return turno 
     */
    
    public int getTurn(){
        return this.turno;
    }
    
    /**
     * Hace suma al puntaje del jugador
     * @param puntos 
     */
    
    public void setPuntos(int puntos){
        this.puntaje+= puntos;
    }
    
    /**
     * Getter
     * @return puntaje 
     */
    
    public int getPuntaje(){
        return this.puntaje;
    }

}
