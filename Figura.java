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
        eliminar.getAux().delete(recorre);
        sizeEcurrent= vecinos.size()-1;
        recorridos.insertFirst(recorre);
        newFigura.insertFirst(recorre);
        if(sizeEcurrent>=0){
            Punto eCurrent=(Punto) vecinos.recorrer(sizeEcurrent);
            if (inicial.getFila()==recorre.getFila() && inicial.getColumna()==recorre.getColumna()){
                newFigura.insertFirst(eCurrent);
                fCreadas.insertLast(newFigura);
                while(recorridos.size()-1>=0){
                    Punto current = (Punto) recorridos.recorrer(recorridos.size()-1);
                    LinkedList vecinosC = current.getEnlazados();
                    current.setAux(vecinosC);
                    recorridos.delete(current);
                }
                while(newFigura.size()-1>=0){
                    Punto current = (Punto) newFigura.recorrer(newFigura.size()-1);
                    newFigura.delete(current);
                }
                System.out.println("cerro");
                return true;
            }
            else if(recorre.Enlazado(eCurrent)){
                recorre.getAux().delete(eCurrent);
                eCurrent.getAux().delete(recorre);
                return cierraFig(inicial, eCurrent,recorre,eCurrent.getAux(),newFigura,eCurrent.getAux().size()-1, recorridos);
            }
            else{
                return cierraFig(inicial,recorre,eliminar,vecinos,newFigura,sizeEcurrent--,recorridos);
            }

        }
        else if(eliminar.getAux().size()-1>=0){
            newFigura.delete(recorre);
            Punto newNext= (Punto) eliminar.getAux().recorrer(eliminar.getAux().size()-1);
            return cierraFig(inicial,newNext,inicial,newNext.getAux(),newFigura,newNext.getAux().size()-1, recorridos);

        }
        else{
            while(recorridos.size()-1>=0){
                Punto current = (Punto) recorridos.recorrer(recorridos.size()-1);
                LinkedList vecinosC = current.getEnlazados();
                current.setAux(vecinosC);
                recorridos.delete(current);
            }
            while(newFigura.size()-1>=0){
                Punto current = (Punto) newFigura.recorrer(newFigura.size()-1);
                newFigura.delete(current);
            }
        }
        System.out.println("No cerro");
        return false;

    }
    public LinkedList getUltimaFig(){
        LinkedList fig=(LinkedList) this.fCreadas.recorrer(this.fCreadas.size()-1);
        return fig;
    }
}
