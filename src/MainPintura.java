import java.util.Scanner;

public class MainPintura {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean bucle = true;


        System.out.println( "\n" +
                "\n" +
                " ____ ____ ____ ____ ____ ____ ____ ____ ____ _________ ____ ____ ____ ____ ____ ____ ____ \n" +
                "||E |||j |||e |||r |||c |||i |||c |||i |||o |||       |||I |||n |||i |||c |||i |||a |||l ||\n" +
                "||__|||__|||__|||__|||__|||__|||__|||__|||__|||_______|||__|||__|||__|||__|||__|||__|||__||\n" +
                "|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/_______\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|\n" +
                "\n");

    Esfera esf = new Esfera(15);
    System.out.println(esf.toString());
    Rectangulo rec = new Rectangulo(20,35);
    System.out.println(rec.toString());
    Cilindro cil = new Cilindro(10,30);
    System.out.println(cil.toString());

    System.out.println("");

    Pintura pint1 = new Pintura(250);
    System.out.println("Pintura para cobertura de una esfera " + pint1.CantPint(esf));
    System.out.println("Pintura para cobertura de un rectangulo " + pint1.CantPint(rec));
    System.out.println("Pintura para cobertura de un cilindro " + pint1.CantPint(cil));

    do {


    System.out.println("\n" +
            "\n" +
            " ____ ____ ____ ____ ____ ____ ____ ____ ____ \n" +
            "||S |||e |||l |||e |||c |||c |||i |||o |||n ||\n" +
            "||__|||__|||__|||__|||__|||__|||__|||__|||__||\n" +
            "|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|\n" +
            "\n");

    System.out.println("Cuanta cobertura va a cubrir la pintura ?");
    double cobertura = scan.nextDouble();
    Pintura pint2 = new Pintura(cobertura);
    System.out.println("Que forma quieres crear ? ( 1| esfera 2| rectangulo 3| cilindro )");
    String eleccion = scan.next();

        switch (eleccion) {
            case "1" -> {
                System.out.println("Creando esfera | Introduzca el radio");
                String esfera = scan.next();
                Esfera esf2 = new Esfera(Integer.parseInt(esfera));
                System.out.println(esf2.toString());
                System.out.println("Pintura para cobertura de una esfera " + pint2.CantPint(esf2));
            }
            case "2" -> {
                System.out.println("Creando rectangulo | Introduzca el la longitud");
                String RectLong = scan.next();
                System.out.println("Creando rectangulo | Introduzca la anchura");
                String RectAnch = scan.next();
                Rectangulo rec2 = new Rectangulo(Integer.parseInt(RectLong), Integer.parseInt(RectAnch));
                System.out.println(rec2.toString());
                System.out.println("Pintura para cobertura de un rectangulo " + pint2.CantPint(rec2));
            }
            case "3" -> {
                System.out.println("Creando cilindro | Introduzca el radio");
                String CilRadio = scan.next();
                System.out.println("Creando cilindro | Introduzca la altura");
                String CilAltura = scan.next();
                Cilindro cil2 = new Cilindro(Integer.parseInt(CilRadio), Integer.parseInt(CilAltura));
                System.out.println(cil2.toString());
                System.out.println("Pintura para cobertura de un cilindro " + pint2.CantPint(cil2));
            }
            default -> System.out.println("Ninguna opción elegida | Datos introducidos incorrectamente");
        }

        System.out.println("Quieres repetir el codigo ? ( 1| si 2| no )");
        String respuesta = scan.next();
        switch (respuesta) {
            case "1":
                System.out.println("repitiendo");
                break;
            case "2":
                System.out.println("Apagando");
                bucle = false;
                break;
            default:

        }
    }while (bucle);
    }
}


class Forma{
    private String nombre;

    public Forma(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Forma{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public int area(){
        return 0;
    }
}

class Esfera extends Forma{
    private int radio;

    public Esfera(int radio){
        super("Esfera");
        this.radio=radio;
    }

    @Override
    public int area() {
        return (int) (4 * Math.PI * radio * radio);
    }

    @Override
    public String toString() {
        return "Esfera{" +
                "radio=" + radio +
                " y area=" + area() +'}';
    }
}

class Rectangulo extends Forma{
    private int Longitud;
    private int Ancho;



    public Rectangulo(int Longitud, int Ancho){
        super("Rectangulo");
        this.Longitud=Longitud;
        this.Ancho=Ancho;
    }

    @Override
    public int area() {
        return Longitud * Ancho;
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "Longitud=" + Longitud +
                ", Ancho=" + Ancho +
                " y area=" + area() + '}';
    }
}

class Cilindro extends Forma{
    private int radio;
    private int altura;

    public Cilindro(int radio, int altura){
        super("Cilindro");
        this.radio=radio;
        this.altura=altura;
    }

    @Override
    public int area() {
        return (int) (2 * Math.PI * radio * (altura + radio));
    }

    @Override
    public String toString() {
        return "Cilindro{" +
                "radio=" + radio +
                ", altura=" + altura +
                " y area=" +area() + '}';
    }
}

class Pintura{
    private double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double CantPint(Forma forma){
        return forma.area() / cobertura;
    }
}