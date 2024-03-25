import java.util.*;

public class MainSet {
    public static HashMap<String,CuerpoCeleste> sistemaSolar = new HashMap<>();
    public static HashSet<CuerpoCeleste> planetas = new HashSet<>();
    public static HashSet<CuerpoCeleste> planetas2 = new HashSet<>();
    public static HashSet<CuerpoCeleste> lunas = new HashSet<>();

    public static void main(String[] args) { //Planetas
    CuerpoCeleste Mercurio = new CuerpoCeleste("Mercurio",88, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Venus = new CuerpoCeleste("Venus",225, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Tierra = new CuerpoCeleste("Tierra",365, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Marte = new CuerpoCeleste("Marte",687, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Jupiter = new CuerpoCeleste("Jupiter",4332, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Saturno = new CuerpoCeleste("Saturno",10759, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Urano = new CuerpoCeleste("Urano",30660, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Neptuno = new CuerpoCeleste("Neptuno",165, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    CuerpoCeleste Pluton = new CuerpoCeleste("Pluton",248, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
    //Los añadimos a las dos cosas
    sistemaSolar.put("p1",Mercurio);
    planetas.add(Mercurio);
    sistemaSolar.put("p2",Venus);
    planetas.add(Venus);
    sistemaSolar.put("p3",Tierra);
    planetas.add(Tierra);
    sistemaSolar.put("p4",Marte);
    planetas.add(Marte);
    sistemaSolar.put("p5",Jupiter);
    planetas.add(Jupiter);
    sistemaSolar.put("p6",Saturno);
    planetas.add(Saturno);
    sistemaSolar.put("p7",Urano);
    planetas.add(Urano);
    sistemaSolar.put("p8",Neptuno);
    planetas.add(Neptuno);
    sistemaSolar.put("p9",Pluton);
    planetas.add(Pluton);

    //Luna para la tierra

        CuerpoCeleste Luna = new CuerpoCeleste("Luna",27, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("l1",Luna);
        Tierra.addSatelite(Luna);

    //Lunas para Marte

        CuerpoCeleste Deimos = new CuerpoCeleste("Deimos",1.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("l2",Deimos);
        Marte.addSatelite(Deimos);

        CuerpoCeleste Phobos = new CuerpoCeleste("Phobos",0.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("l3",Phobos);
        Marte.addSatelite(Phobos);

    //Lunas para Jupiter

        CuerpoCeleste lo = new CuerpoCeleste("lo",1.8, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("l4",lo);
        Jupiter.addSatelite(lo);

        CuerpoCeleste Europa = new CuerpoCeleste("Europa",3.5, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("l5",Europa);
        Jupiter.addSatelite(Europa);

        CuerpoCeleste Ganymede = new CuerpoCeleste("Ganymede",7.1, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("l6",Ganymede);
        Jupiter.addSatelite(Ganymede);

        CuerpoCeleste Callisto = new CuerpoCeleste("Callisto",16.7, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("l7",Callisto);
        Jupiter.addSatelite(Callisto);

        for (CuerpoCeleste a: planetas) {
            System.out.println(a.toString());
        }

        System.out.println(sistemaSolar.get("p4").getSatelites());

        for (CuerpoCeleste a:
                planetas) {
            lunas.addAll(a.getSatelites());
        }

        for (CuerpoCeleste a:lunas) {
            System.out.println(a.toString());
        }

        //No añade porque es mismo tipo y mismo nombre
        CuerpoCeleste Pluton2 = new CuerpoCeleste("Pluton",884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        System.out.println(planetas.add(Pluton2));
        System.out.println(planetas);

        //Si que se añade al no ser el mismo tipo
        CuerpoCeleste Pluton3 = new CuerpoCeleste("Pluton",884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO);
        System.out.println(planetas.add(Pluton3));
        System.out.println(planetas);


        //añado planetas al otro set para luego poner usar la diferencia y la interseccion
        CuerpoCeleste Bigo = new CuerpoCeleste("Bigo",32, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Te = new CuerpoCeleste("te",240, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste BenDover = new CuerpoCeleste("BenDover",2642, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);

        planetas2.add(Mercurio);
        planetas2.add(Venus);
        planetas2.add(Tierra);
        planetas2.add(Marte);
        planetas2.add(Jupiter);
        planetas2.add(Bigo);
        planetas2.add(Te);
        planetas2.add(BenDover);

        //Intersección
        System.out.println("Intersección");//Devuelve Mercurio,Venus,Tierra,Marte y jupiter que son los que comparten los dos
        planetas2.retainAll(planetas);
        System.out.println(planetas2);

        //Le vuelvo a añadir los planetas
        planetas2.add(Bigo);
        planetas2.add(Te);
        planetas2.add(BenDover);
        System.out.println("Diferencia"); //Devuelve solo Bigo,te y BenDover que son los diferentes
        planetas2.removeAll(planetas);
        System.out.println(planetas2);
    }
}

class CuerpoCeleste{
    public enum TipoCuerpoCeleste {
    ESTRELLA,PLANETA,PLANETA_ENANO,LUNA,COMETA,ASTEROIDE
    }
    private String nombre;
    private double periodoOrbital;
    private HashSet<CuerpoCeleste> satelites = new HashSet<>();
    private TipoCuerpoCeleste tipoCuerpo;

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public HashSet<CuerpoCeleste> getSatelites() {
        return satelites;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
    }

    public boolean addSatelite(CuerpoCeleste a){
        return satelites.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Objects.equals(nombre, that.nombre) && tipoCuerpo == that.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCuerpo);
    }


    @Override
    public String toString() {
        return nombre + ": " + tipoCuerpo + ", " + periodoOrbital;
    }
}

class Planeta extends CuerpoCeleste{

    public Planeta(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste a) {
        if (a.getTipoCuerpo().equals(TipoCuerpoCeleste.LUNA)){
            return super.addSatelite(a);
        }else{
            return false;
        }
    }
}

class PlanetaEnano extends CuerpoCeleste{
    public PlanetaEnano(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
    }
}

class Luna extends CuerpoCeleste{
    public Luna(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
    }
}
