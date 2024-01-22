public class Main {
    public static void main(String[] args) {

        System.out.println("EJ 11");


    Video ob1 = new Video("VHS",90,1000);
    Pelicula ob2 = new Pelicula("ET",120,100,"Spielberg",10);
    VideoMusical ob3 = new VideoMusical("Overconfidence",5,10,"Tallah","Metal");

    System.out.println(ob1.toString());
    System.out.println(ob2.toString());
    System.out.println(ob3.toString());


        System.out.println("EJ 12");


    CocheCombustion Nose = new CocheCombustion("Ferraras",50,4,5);
    CocheElectrico Nose2 = new CocheElectrico("Teslote",100,4,1);

    //Nose.CambiarMarchas();
    //Nose2.BateriasEnElOceano();


        System.out.println("EJ 13");


        Circulo cir1 = new Circulo(-1);
        Cilindro cil1 = new Cilindro(-1,5);
        System.out.println(cir1.getArea());
        System.out.println(cil1.getArea());
        System.out.println(cil1.getVolume());

    }
}
