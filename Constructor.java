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

}
