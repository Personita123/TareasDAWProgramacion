import java.util.Scanner;

public class CocheElectrico extends Coche{
    Scanner scan = new Scanner(System.in);
    private int Bateria;

    public int getBateria() {
        return Bateria;
    }

    public void setBateria(int marchas) {
        Bateria = marchas;
    }

    public CocheElectrico(String nombre, int velocidad, int ruedas, int bateria) {
        super(nombre, velocidad, ruedas);
        this.Bateria = bateria;
    }

    public void   BateriasEnElOceano(){
        this.Bateria = scan.nextInt();
        System.out.println("Hay " + getBateria() + " baterias en el oceano");
    }
}
