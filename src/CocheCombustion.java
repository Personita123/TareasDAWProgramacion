import java.util.Scanner;

public class CocheCombustion extends Coche{
    Scanner scan = new Scanner(System.in);
    private int marcha;

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public CocheCombustion(String nombre, int velocidad, int ruedas, int marchas) {
        super(nombre, velocidad, ruedas);
        this.marcha=marchas;
    }

    public void CambiarMarchas(){
        this.marcha = scan.nextInt();
        System.out.println("La marcha esta en " + getMarcha());
    }
}
