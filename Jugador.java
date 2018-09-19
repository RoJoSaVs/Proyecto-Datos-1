/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

/**
 *
 * @author Andrey
 */
public class Jugador {
    private LinkedList figuras;
    
    public void setFigura(Figura nueva){
        figuras.insertFirst(nueva);
        
    }
    
    
}
