import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FiguraFactory figuraFactory = new FiguraFactory();
        Scanner tfigura = new Scanner(System.in);
        System.out.println("Seleccione el tipo de figura:\n1:Rectangulo.\n2:Triangulo.\n3:Circulo.");
        int tipo = tfigura.nextInt();
        double l1;
        double l2;
        double l3;
        switch (tipo){
            case 1 -> {
                Figura figura = figuraFactory.obtenerFigura(TipoFigura.Rectangulo);
                System.out.println("Lado 1");
                l1 = tfigura.nextInt();
                System.out.println("Lado 2");
                l2 = tfigura.nextInt();
                figura.crearFigura(l1,l2);
            }
            case 2 -> {
                Figura figura = figuraFactory.obtenerFigura(TipoFigura.Triangulo);
                System.out.println("Lado 1");
                l1 = tfigura.nextInt();
                System.out.println("Lado 2");
                l2 = tfigura.nextInt();
                System.out.println("Lado 3");
                l3 = tfigura.nextInt();
                figura.crearFigura(l1,l2,l3);
            }
            case 3 -> {
                Figura figura = figuraFactory.obtenerFigura(TipoFigura.Circulo);
                System.out.println("Radio");
                l1 = tfigura.nextInt();
                figura.crearFigura(l1);
            }
        }
    }
}
