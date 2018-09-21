package dots;

public class Constructor {
    private LinkedList Fila1= new LinkedList();

    public void Matriz(int tamaño){
        int size=tamaño;
        while(tamaño>0){
            int c = size;
            int c1=tamaño-1;
            LinkedList columna = new LinkedList();
            while (c>0){
                int x =0;
                int y =0;
                Punto punto= new Punto();
                punto.setXY(x,y);
                punto.setData(c1);
                columna.insertFirstP(punto.getX(),punto.getY(),punto.getData());
                c--;
            }
            Fila1.insertFirstN(columna);
            tamaño--;
        }

    }
    public LinkedList getLista(){
        return this.Fila1;
    }

}
