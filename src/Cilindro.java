public class Cilindro extends Circulo{

    private double altura;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Cilindro(double radio, double altura) {
        super(radio);
        this.altura=altura;
        if (altura < 0){
            this.altura = 0;
        }
    }

    public double getVolume(){
        return getAltura() * getArea();
    }
}
