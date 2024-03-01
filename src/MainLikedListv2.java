import java.util.*;

public class MainLikedListv2 {
    public static boolean adondeva = false; //Falso delante / verdadero detras
    public static LinkedList<Cancion> playlist1 = new LinkedList<Cancion>();

    public static void imprimirMenu() {
        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir siguiente canción en la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir la canción actual");
        System.out.println("4 - Imprimir la lista de canciones en la playlist");
        System.out.println("5 - Volver a imprimir el menú");
        System.out.println("6 - Eliminar de la playlist");
    }

    public static void imprimirLista(LinkedList<Cancion> playlist){
        ListIterator<Cancion> it = playlist.listIterator();
        if (playlist.size() != 0){
        for (int i = 0; i < playlist.size();i++){
            System.out.println(it.next());
        }} else System.out.println("No hay canciones");
    }

    public static void play(LinkedList<Cancion> playlist){
        ListIterator<Cancion> itprincip = playlist.listIterator();
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;
        String opcion;
        imprimirMenu();

        while(continuar) {
            System.out.println("Elige una opción: ");
            opcion = scan.nextLine();

            switch (opcion) {
                case "0":
                    continuar = false;
                    break;
                case "1":
                    if(!adondeva) {
                        if (itprincip.hasNext()) {
                            System.out.println(itprincip.next());
                        } else System.out.println("No hay siguiente");
                    } else {itprincip.next();System.out.println(itprincip.next()); adondeva = false;}
                    break;
                case "2":
                    if(adondeva) {
                        if (itprincip.hasPrevious()) {
                            System.out.println(itprincip.previous());
                        } else System.out.println("No hay anterior");
                    }else {itprincip.previous(); System.out.println(itprincip.previous()); adondeva=true;}
                    break;
                case "3":

                    if(!itprincip.hasPrevious()){
                        System.out.println("No more");
                    }else {
                        int anterior = itprincip.previousIndex();
                        System.out.println(playlist.get(anterior));
                    }
                    break;
                case "4":
                    imprimirLista(playlist);
                    break;
                case "5":
                    imprimirMenu();
                    break;
                case "6":
                    try {
                    itprincip.remove();
                    if (itprincip.hasNext()){
                        System.out.println(itprincip.next());
                    } else if (itprincip.hasPrevious()){
                        System.out.println(itprincip.previous());
                    } else System.out.println("No hay mas canciones");
                    }catch (IllegalStateException e){
                        System.out.println("No has seleccionado ninguna canción o no quedan mas");
                    }
                    break;
                default:
                    System.out.println("No has seleccionado ninguna opcion\n");
                    imprimirMenu();
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Album> Albumes = new ArrayList<Album>();
        Album alb1 = new Album("TGOD","Tallah");
        Album alb2 = new Album("Exmilitary","Death Grips");
        Albumes.add(alb1);
        Albumes.add(alb2);

        Albumes.get(0).addSong("How Long",3.32);
        Albumes.get(0).addSong("The Impressionist",4.32);
        Albumes.get(1).addSong("Guillotine",3.48);
        Albumes.get(1).addSong("No Love",3.47);


        Albumes.get(0).addToPlaylist(0,playlist1);
        Albumes.get(0).addToPlaylist("The Impressionist",playlist1);
        Albumes.get(1).addToPlaylist(0,playlist1);
        Albumes.get(1).addToPlaylist("No Love",playlist1);

        play(playlist1);
    }
}


class Cancion{
    private final String titulo;
    private final double duracion;

    public String getTitulo() {
        return titulo;
    }

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo +  " : " + duracion;
    }

}

class Album{
    private final String nombre;
    private final String artista;
    private final ArrayList<Cancion> canciones = new ArrayList<Cancion>();

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
    }

    private Cancion findSong(String titulo){
        for(int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getTitulo().equals(titulo)) {
                return canciones.get(i);
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion){
        if (findSong(titulo) != null){
            return false;
        } else
        canciones.add(new Cancion(titulo,duracion));
        return true;
    }

    public boolean addToPlaylist(int numpista, LinkedList<Cancion> playlist){
        if (playlist.contains(canciones.get(numpista))){
            return false;
        } else {
            playlist.add(canciones.get(numpista));
            return true;
        }
    }

    public boolean addToPlaylist(String titulo, LinkedList<Cancion> playlist){
        if (playlist.contains(findSong(titulo))){
            return false;
        } else {
            playlist.add(findSong(titulo));
            return true;
        }
    }
}