public class MainForma{
    public static void main(String[] args) {
        Rectangulo rec1 = new Rectangulo(4,2,3);
        Rectangulo rec2 = new Rectangulo(4, 2, 5);
        System.out.println(rec1.getarea() + " (-- Area y Perimetro --) " + rec1.getPerimeter());
        //rec1.redimensionar(2);
        //System.out.println(rec1.getarea() + " (-- Area y Perimetro --) " + rec1.getPerimeter());

        if (rec1.compareTo(rec2) > 0){
            System.out.println("El area de el rectangulo comparado es mayor");
        } else if(rec1.compareTo(rec2) < 0){System.out.println("El area de el rectangulo comparado es menor");}
    }
}

interface Redimensionable{
    void redimensionar(int x);
}
abstract class Forma {
private int numLados;

    public int getNumLados() {
        return numLados;
    }

    public Forma(int numLados) {
        this.numLados = numLados;
    }

   public abstract int getarea(); public abstract int getPerimeter();
}
class Rectangulo extends Forma implements Redimensionable,Comparable<Rectangulo>{

private int ancho;
private int alto;

    public Rectangulo(int numLados, int ancho, int alto) {
        super(numLados);
        this.alto=alto;
        this.ancho=ancho;
    }

    @Override
    public int getarea() {
        return ancho * alto;
    }

    @Override
    public int getPerimeter() {
        return ancho + ancho + alto + alto;
    }

    @Override
    public void redimensionar(int x) {
        ancho = x;
        alto = x;
    }

    @Override
    public int compareTo(Rectangulo o) {
        if (getarea() < o.getarea()){
            return 1;
        } else{
            return -1;
        }
    }
}
class Triangulo extends Forma{

    private int ancho;
    private int alto;

    public Triangulo(int numLados, int ancho, int alto) {
        super(numLados);
        this.alto=alto;
        this.ancho=ancho;
    }

    @Override
    public int getarea() {
        return (ancho * alto) / 2;
    }

    @Override
    public int getPerimeter() {
        return ancho * 3;
    }
}
