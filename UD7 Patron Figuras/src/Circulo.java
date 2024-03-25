public class Circulo implements Figura{
    @Override
    public void crearFigura(double l1, double l2, double l3) {
    }

    @Override
    public void crearFigura(double l1, double l2) {
    }

    @Override
    public void crearFigura(double radio) {
        System.out.println("Area:" + Math.PI * Math.pow(radio,2));
        System.out.println("Perimetro:" + 2 * Math.PI * radio);
    }
}
