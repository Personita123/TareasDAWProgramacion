public class Video {

    private String titulo;
    private int minutos;
    private int precio;

    public Video(String titulo, int minutos, int precio) {
        this.titulo = titulo;
        this.minutos = minutos;
        this.precio=precio;
    }

    public String toString(){
        return "Titulo " + getTitulo()+ " Minutos " + getMinutos() + " Precio " + getPrecio() + "$";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
