package dots;

public class Constructor {
    private LinkedList Fila1= new LinkedList();

    public Constructor(int tam){
        int size=tam;
        while(tam>0){
            int c = size;
            int c1=tam-1;
            LinkedList columna = new LinkedList();
            while (c>0){
                int x =0;
                int y =0;
                Punto punto= new Punto();
                punto.setXY(x,y);
                punto.setData(c1);
                punto.setPos(c1,c-1);
                columna.insertFirst(punto);
                c--;
            }
            Fila1.insertFirst(columna);
            tam--;
        }

    }
    public LinkedList getLista(){
        return this.Fila1;
    }
        public void setVecinos(LinkedList matriz, int contador){
        int cFijo=contador;
        while(contador>=0){
            LinkedList currentList=(LinkedList) matriz.recorrer(contador);
            int c2= currentList.size()-1;
            while(c2>=0){
                Punto current= (Punto) currentList.recorrer(c2);
                if(current.getColumna()==cFijo){
                    if(current.getFila()==0){
                        LinkedList anteriorL = (LinkedList) matriz.recorrer(cFijo-1);
                        Punto anterior = (Punto) anteriorL.recorrer(0);
                        Punto diagonal = (Punto) anteriorL.recorrer(1);
                        Punto abajo = (Punto) currentList.recorrer(1);
                        current.agregarVecino(abajo);
                        current.agregarVecino(diagonal);
                        current.agregarVecino(anterior);
                        c2--;
                    }
                    else if(current.getFila()==cFijo){
                        LinkedList anteriorL = (LinkedList) matriz.recorrer(cFijo-1);
                        Punto anterior = (Punto) anteriorL.recorrer(cFijo);
                        Punto diagonal = (Punto) anteriorL.recorrer(cFijo-1);
                        Punto arriba = (Punto) currentList.recorrer(cFijo-1);
                        current.agregarVecino(arriba);
                        current.agregarVecino(diagonal);
                        current.agregarVecino(anterior);
                        c2--;
                    }
                    else{
                        LinkedList anteriorL = (LinkedList) matriz.recorrer(cFijo-1);
                        Punto anterior = (Punto) anteriorL.recorrer(current.getFila());
                        Punto dArriba = (Punto) anteriorL.recorrer(current.getFila()-1);
                        Punto dAbajo = (Punto) anteriorL.recorrer(current.getFila()+1);
                        Punto abajo = (Punto) currentList.recorrer(current.getFila()+1);
                        Punto arriba = (Punto) currentList.recorrer(current.getFila()-1);
                        current.agregarVecino(abajo);
                        current.agregarVecino(arriba);
                        current.agregarVecino(dArriba);
                        current.agregarVecino(dAbajo);
                        current.agregarVecino(anterior);
                        c2--;
                    }
                }
                else if(current.getColumna()==0){
                    if(current.getFila()==0){
                        LinkedList siguienteL = (LinkedList) matriz.recorrer(1);
                        Punto siguiente = (Punto) siguienteL.recorrer(0);
                        Punto diagonal = (Punto) siguienteL.recorrer(1);
                        Punto abajo = (Punto) currentList.recorrer(1);
                        current.agregarVecino(abajo);
                        current.agregarVecino(diagonal);
                        current.agregarVecino(siguiente);
                        c2--;
                    }
                    else if(current.getFila()==cFijo){
                        LinkedList siguienteL = (LinkedList) matriz.recorrer(1);
                        Punto siguiente = (Punto) siguienteL.recorrer(cFijo);
                        Punto diagonal = (Punto) siguienteL.recorrer(cFijo-1);
                        Punto arriba = (Punto) currentList.recorrer(cFijo-1);
                        current.agregarVecino(arriba);
                        current.agregarVecino(diagonal);
                        current.agregarVecino(siguiente); 
                        c2--;
                    }
                    else{
                        LinkedList siguienteL = (LinkedList) matriz.recorrer(1);
                        Punto siguiente = (Punto) siguienteL.recorrer(current.getFila());
                        Punto dArriba = (Punto) siguienteL.recorrer(current.getFila()-1);
                        Punto dAbajo = (Punto) siguienteL.recorrer(current.getFila()+1);
                        Punto abajo = (Punto) currentList.recorrer(current.getFila()+1);
                        Punto arriba = (Punto) currentList.recorrer(current.getFila()-1);
                        current.agregarVecino(abajo);
                        current.agregarVecino(arriba);
                        current.agregarVecino(dArriba);
                        current.agregarVecino(dAbajo);
                        current.agregarVecino(siguiente);
                        c2--;
                    }
                }
                else{
                    if(current.getFila()==0){
                        LinkedList siguienteL = (LinkedList) matriz.recorrer(current.getColumna()+1);
                        LinkedList anteriorL = (LinkedList) matriz.recorrer(current.getColumna()-1);
                        Punto siguiente = (Punto) siguienteL.recorrer(0);
                        Punto dAnterior = (Punto) anteriorL.recorrer(1);
                        Punto dSiguiente = (Punto) siguienteL.recorrer(1);
                        Punto abajo = (Punto) currentList.recorrer(1);
                        Punto anterior = (Punto) anteriorL.recorrer(0);
                        current.agregarVecino(abajo);
                        current.agregarVecino(anterior);
                        current.agregarVecino(dAnterior);
                        current.agregarVecino(dSiguiente);
                        current.agregarVecino(siguiente);
                        c2--;
                    }
                    else if(current.getFila()==cFijo){
                        LinkedList siguienteL = (LinkedList) matriz.recorrer(current.getColumna()+1);
                        LinkedList anteriorL = (LinkedList) matriz.recorrer(current.getColumna()-1);
                        Punto siguiente = (Punto) siguienteL.recorrer(cFijo);
                        Punto dAnterior = (Punto) anteriorL.recorrer(cFijo-1);
                        Punto dSiguiente = (Punto) siguienteL.recorrer(cFijo-1);
                        Punto arriba = (Punto) currentList.recorrer(cFijo-1);
                        Punto anterior = (Punto) anteriorL.recorrer(cFijo);
                        current.agregarVecino(arriba);
                        current.agregarVecino(anterior);
                        current.agregarVecino(dAnterior);
                        current.agregarVecino(dSiguiente);
                        current.agregarVecino(siguiente);
                        c2--;
                    }
                    else{
                        LinkedList siguienteL = (LinkedList) matriz.recorrer(current.getColumna()+1);
                        LinkedList anteriorL = (LinkedList) matriz.recorrer(current.getColumna()-1);
                        Punto siguiente = (Punto) siguienteL.recorrer(current.getFila());
                        Punto dAnteriorArriba = (Punto) anteriorL.recorrer(current.getFila()-1);
                        Punto dAnteriorAbajo = (Punto) anteriorL.recorrer(current.getFila()+1);
                        Punto dSiguienteArriba = (Punto) siguienteL.recorrer(current.getFila()-1);
                        Punto dSiguienteAbajo = (Punto) siguienteL.recorrer(current.getFila()+1);
                        Punto arriba = (Punto) currentList.recorrer(current.getFila()-1);
                        Punto abajo = (Punto) currentList.recorrer(current.getFila()+1);
                        Punto anterior = (Punto) anteriorL.recorrer(current.getFila());
                        current.agregarVecino(arriba);
                        current.agregarVecino(abajo);
                        current.agregarVecino(anterior);
                        current.agregarVecino(dAnteriorAbajo);
                        current.agregarVecino(dAnteriorArriba);
                        current.agregarVecino(dSiguienteAbajo);
                        current.agregarVecino(dSiguienteArriba);
                        current.agregarVecino(siguiente);
                        c2--;
                    }
                }
            }
            contador--;
        }
        
    }

}
