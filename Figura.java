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
    public boolean cierraFig(Punto inicial, Punto recorre, Punto eliminar, LinkedList vecinos, LinkedList newFigura, int sizeEcurrent, LinkedList recorridos){
        vecinos.delete(eliminar);
        if (inicial.getFila()==recorre.getFila() && inicial.getColumna()==inicial.getColumna()){
            recorridos.insertFirst(recorre);
            newFigura.insertFirst(recorre);
            fCreadas.insertLast(newFigura);
            while(recorridos.size()>0){
                Punto current = (Punto) recorridos.recorrer(recorridos.size());
                LinkedList vecinosC = current.getVecinos();
                current.setAux(vecinosC);
                recorridos.delete(current);
            }
            return true;
        }
        else if(sizeEcurrent>0){
            Punto eCurrent=(Punto) vecinos.recorrer(sizeEcurrent);
            if(recorre.Enlazado(eCurrent)){
                recorridos.insertFirst(eCurrent);
                recorre.getAux().delete(eCurrent);
                newFigura.insertFirst(eCurrent);
                eCurrent.getAux().delete(recorre);
                cierraFig(inicial, eCurrent,recorre,eCurrent.getAux(),newFigura,eCurrent.getVecinos().size(), recorridos);
            }
            else{
                cierraFig(inicial,recorre,eliminar,vecinos,newFigura,sizeEcurrent--,recorridos);
            }

        }
        else if(eliminar.getAux().size()>0){
            newFigura.delete(recorre);
            cierraFig(inicial,eliminar,recorre,eliminar.getAux(),newFigura,eliminar.getAux().size(), recorridos);

        }
        else{
            while(recorridos.size()>0){
                Punto current = (Punto) recorridos.recorrer(recorridos.size());
                LinkedList vecinosC = current.getVecinos();
                current.setAux(vecinosC);
                recorridos.delete(current);
            }
        }
        return false;

    }
}
