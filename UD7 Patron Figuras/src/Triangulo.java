public class Triangulo implements Figura {

    @Override
    public void crearFigura(double l1, double l2, double l3) {
        double s = (l1 + l2 + l3) / 2;
        System.out.println("S:" + s);
        System.out.println("Area:" + Math.sqrt(s*(s - l1)*(s-l2)*(s-l3)));
        System.out.println("Perimetro:" + (l1 + l2 + l3));
    }

    @Override
    public void crearFigura(double l1, double l2) {
    }

    @Override
    public void crearFigura(double radio) {

    }
}
