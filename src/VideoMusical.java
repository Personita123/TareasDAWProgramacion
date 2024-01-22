public class VideoMusical extends Video {
    private String artista;
    private String categoria;

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public VideoMusical(String titulo, int minutos,int precio,String artista, String categoria) {
        super(titulo, minutos, precio);
        this.artista=artista;
        this.categoria=categoria;
    }

    @Override
    public String toString() {
        return super.toString() + " Artista " + getArtista() + " Categoria " + getCategoria();
    }
}