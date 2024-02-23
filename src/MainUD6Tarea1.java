import java.util.ArrayList;
import java.util.Scanner;


public class MainUD6Tarea1 {

    private static TelefonoMovil tel1 = new TelefonoMovil("654444444",new ArrayList<>());


    public static void imprimirMenu() {
        System.out.println("0 - Salir");
        System.out.println("1 - Para imprimir contactos");
        System.out.println("2 - Para añadir un contacto");
        System.out.println("3 - Para modificar un contacto");
        System.out.println("4 - Para eliminar un contacto");
        System.out.println("5 - Para encontrar un contacto");
        System.out.println("6 - Imprimir Menu");
    }

    public static void ImprimirContactos(){
        tel1.printContacts();
    }

    public static String EscanerNom(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        boolean incorrecto;
        System.out.println("Inserte Nombre");
        do {
            nombre = scan.nextLine();
            incorrecto = true;
        try {
            System.out.print("[");
            for (int i = 0; i < nombre.length();i++) {
                if (nombre.charAt(i) >= 65 && nombre.charAt(i) <= 90  || nombre.charAt(i) >= 97 && nombre.charAt(i) <= 122){
                    System.out.print("# # ");
                } else {
                    throw new Error("Caracter no valido en el nombre ]");
                }
            }
            if (nombre.length() == 0){
                throw new Error("Caracter no valido en el nombre ]");
            }
        }catch (Error e){
            System.out.println(e);
            System.out.println("Inserta nombre de nuevo");
            incorrecto = false;
        }
        }while (!incorrecto);
        System.out.print("] ");
        System.out.println("Nombre Valido");
        return nombre;
    }

    public static String EscanerNum(){
        Scanner scan = new Scanner(System.in);
        String numero;
        boolean incorrecto;
        System.out.println("Inserte Numero");
        do {
            numero = scan.nextLine();
            incorrecto = true;
            try {
                System.out.print("[");
                for (int i = 0; i < numero.length();i++) {
                    if (numero.charAt(i) >= 48 && numero.charAt(i) <= 57){
                        System.out.print("##");
                    } else {
                        throw new Error("Caracter no valido en el numero ]");
                    }
                }
                if (numero.length() == 0){
                    throw new Error("Caracter no valido en el numero ]");
                }
            }catch (Error e){
                System.out.println(e);
                System.out.println("Inserta nombre de nuevo");
                incorrecto = false;
            }
        }while (!incorrecto);
        System.out.print("] ");
        System.out.println("Numero Valido");
        return numero;
    }

    public static void AnadirContacto(){
        if (tel1.addNewContact(Contacto.createContact(EscanerNom(), EscanerNum()))){
            System.out.println("Contacto añadido");
        } else System.out.println("Contacto ya existe");
    }

    public static void ModificarContacto(){
        System.out.println("Inserte nombre del contacto para modificar");
        String nombre = EscanerNom();
        if (tel1.queryContact(nombre) != null){
            System.out.println("Modificanto contactos");
            Contacto nuevo = Contacto.createContact(EscanerNom(),EscanerNum());
            if (tel1.queryContact(nuevo.getName()) != null){
                System.out.println("El contacto ya existe");
            } else {
                tel1.updateContact(tel1.queryContact(nombre), nuevo);
                System.out.println("Contacto Modificado");
            }
        } else{
            System.out.println("Contacto no existe");
        }
    }

    public static void EliminarContacto(){
        System.out.println("Inserte nombre del contacto para eliminar");
        String nombre = EscanerNom();
        if (!tel1.removeContact(nombre)){
            System.out.println("No existe el contacto");
        } else
            System.out.println("Contacto eliminado");
    }

    public static void BuscarContacto(){
        System.out.println("Inserte nombre del contacto para buscar");
        Contacto busca = tel1.queryContact(EscanerNom());
        if(busca == null){
            System.out.println("No existe el contacto");
        } else
            System.out.println(busca.getName() + " (---) " +busca.getPhoneNumber());
    }

    public static void main(String[] args) {
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
                    ImprimirContactos();
                    break;
                case "2":
                    AnadirContacto();
                    break;
                case "3":
                    ModificarContacto();
                    break;
                case "4":
                    EliminarContacto();
                    break;
                case "5":
                    BuscarContacto();
                    break;
                case "6":
                    imprimirMenu();
                    break;
                default:
                    System.out.println("No has seleccionado ninguna opcion\n");
                    imprimirMenu();
            }
        }
    }
}

class Contacto{
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact(String name, String phoneNumber){
        return new Contacto(name,phoneNumber);
    }
}

class TelefonoMovil{
    private String myNumber;
    private ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    public TelefonoMovil(String myNumber, ArrayList<Contacto> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contacto cont){
        if (findContact(cont) == 1){
            return false;
        } else {
            myContacts.add(cont);
            return true;
        }
    }

    public boolean updateContact(Contacto cont1, Contacto cont2){
        if (findContact(cont1) == 1){
            int index = myContacts.indexOf(cont1);
            myContacts.set(index,cont2);
            return true;
        } else{ return false;}
    }

    public boolean removeContact(String cont1){
        for(int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(cont1)) {
                myContacts.remove(i); return true;}
        }
        return false;
    }

    private int findContact(Contacto cont){
        for(int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(cont.getName())) {
                return 1;
            }
        }
        return -1;
    }

    private int findContact(String cont){
        return myContacts.indexOf(cont);
    }

    public Contacto queryContact(String cont){
            for(int i = 0; i < myContacts.size(); i++) {
                if (myContacts.get(i).getName().equals(cont)) {
                    return myContacts.get(i); }
            }
        return null;
    }

    public void printContacts(){
        int Contador = 1;
        System.out.println("Tenemos "  + myContacts.size() + " contactos en 'myContacts'");
        System.out.println("Lista de contactos");
        for(int i = 0; i < myContacts.size(); i++) {
            System.out.print(Contador + ". ");
            System.out.println(myContacts.get(i).getName() + " ---) " + myContacts.get(i).getPhoneNumber());
            Contador++;
        }
    }
}