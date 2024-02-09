import java.util.Arrays;

public class MainEstudiantes {
    public static void main(String[] args) {
    Estudiantes[] estudiantes = new Estudiantes[5];
    estudiantes[0] = new Estudiantes("Patri",12,170);
    estudiantes[1] = new Estudiantes("Manuel",43,173);
    estudiantes[2] = new Estudiantes("Javier",72,189);
    estudiantes[3] = new Estudiantes("Alicia",52,168);
    estudiantes[4] = new Estudiantes("Alberto",35,189);

    for (int i = 0; i < 5; i++){
        System.out.println((i+1) + " " +estudiantes[i].toString());
    }

        System.out.println("\n Ahora se presentaras a los alumnos ordenados \n"); Arrays.sort(estudiantes);

    for (int i = 0; i < 5; i++){

        System.out.println((i+1) + " " +estudiantes[i].toString());
    }

    }}


class Estudiantes implements Comparable<Estudiantes>{
    private String nombre;
    private int edad;
    private int altura;


    public Estudiantes(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public int compareTo(Estudiantes o) {
        if (altura == o.altura){
            if(edad > o.edad){
                return -1;
            } else{
                return 1;
            }
        } else if(altura > o.altura){return -1;}
        else {return 1;}
    }

    @Override
    public String toString() {
        return "Estudiantes{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }
}
