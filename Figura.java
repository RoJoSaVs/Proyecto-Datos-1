package dots;

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
    public void recorrerFig(Punto inicial, Punto recorre, Punto eliminar, LinkedList vecinos, LinkedList newFigura, int sizeEcurrent, LinkedList recorridos){
        vecinos.delete(eliminar);
        if (inicial.getX()==recorre.getX() && inicial.getY()==inicial.getY()){
            recorridos.insertFirstP(inicial.getX(), inicial.getY(), inicial.getData());
            newFigura.insertFirstP(inicial.getX(),inicial.getY(),inicial.getData());
            fCreadas.insertFirstN(newFigura);
            while(recorridos.size()>0){
                recorridos.recorrerL(recorridos.size()).setAux(recorridos.recorrerL(recorridos.size()).getVecinos());
                recorridos.delete(recorridos.recorrerL(recorridos.size()));
            }
        }
        else if(sizeEcurrent>0){
            if(recorre.Enlazado(vecinos.recorrerL(sizeEcurrent))){
                newFigura.insertFirstP(vecinos.recorrerL(sizeEcurrent).getX(),vecinos.recorrerL(sizeEcurrent).getY(),vecinos.recorrerL(sizeEcurrent).getData());
                sizeEcurrent--;
                recorrerFig(inicial, vecinos.recorrerL(sizeEcurrent),recorre,vecinos.recorrerL(sizeEcurrent).getAux(),newFigura,vecinos.recorrerL(sizeEcurrent).getVecinos().size(), recorridos);
            }
            else{
                recorrerFig(inicial,recorre,eliminar,vecinos,newFigura,sizeEcurrent--,recorridos);
            }

        }
        else if(eliminar.getAux().size()>0){
            newFigura.delete(recorre);
            recorrerFig(inicial,eliminar,recorre,eliminar.getAux(),newFigura,eliminar.getAux().size(), recorridos);

        }
        else{
            while(recorridos.size()>0){
                recorridos.recorrerL(recorridos.size()).setAux(recorridos.recorrerL(recorridos.size()).getVecinos());
                recorridos.delete(recorridos.recorrerL(recorridos.size()));

            }
        }

    }
}
