public class Coche extends Vehiculo {
    private int ruedas;

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public Coche(String nombre, int velocidad, int ruedas) {
        super(nombre, velocidad);
        this.ruedas=ruedas;
    }

    public String acelerar(){
        return "Acelera el coche";
    }
    public String  frenar(){
        return "Frena el coche";
    }
}
