public class Pelicula extends Video {
    private String director;
    private int valoracion;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Pelicula(String titulo, int minutos, int precio, String director, int valoracion){
        super(titulo,minutos,precio);
        this.director = director;
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return super.toString() + " Director " + getDirector() + " Valoración " + getValoracion();
    }
}
