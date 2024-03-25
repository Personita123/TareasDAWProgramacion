public class Rectangulo implements Figura {

    @Override
    public void crearFigura(double l1, double l2, double l3) {
    }

    @Override
    public void crearFigura(double l1, double l2) {
        System.out.println("Area:" + l1 + l2);
        System.out.println("Perimetro:" + 2 * l1 + l2 * 2);
    }

    @Override
    public void crearFigura(double radio) {

    }
}
