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
                columna.insertFirstP(punto.getX(),punto.getY(),punto.getData());
                c--;
            }
            Fila1.insertFirstN(columna);
            tam--;
        }

    }
    public LinkedList getLista(){
        return this.Fila1;
    }

}
