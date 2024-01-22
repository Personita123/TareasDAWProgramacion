public class Main {
    public static void main(String[] args) {
        Circulo cir1 = new Circulo(-1);
        Cilindro cil1 = new Cilindro(-1,5);
        System.out.println(cir1.getArea());
        System.out.println(cil1.getArea());
        System.out.println(cil1.getVolume());

    }
}
