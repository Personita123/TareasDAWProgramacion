public class FiguraFactory {
    public Figura obtenerFigura(TipoFigura tipoFigura)
    {
        return switch (tipoFigura)
                {
                    case Rectangulo -> new Rectangulo();
                    case Triangulo -> new Triangulo();
                    case Circulo -> new Circulo();
                };
    }
}
