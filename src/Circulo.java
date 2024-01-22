public class Circulo {

    private double radio;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;

    }

    public Circulo(double radio) {
        this.radio = radio;
        if (radio < 0){
            this.radio = 0;
        }
    }

    public double getArea(){
        return radio * radio * Math.PI;
    }
}
