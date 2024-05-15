package simulacion;

public class Persona {
    private static int nextCount = 0;
    private char id; // 'S' : Sanitario, 'D' : Docente
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private final int contador; // número de personas dadas de alta

    public Persona(char id, String nombre, String primerApellido, String segundoApellido) {
        this.id = id;
        setNombre(nombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
        contador = getNextCount(); // inicializo el contador
    }

    private static int getNextCount() {
        return nextCount++; // retorna el contador y lo incrementa para la próxima vez
    }

    public int getContador() {
        return contador;
    }

    public char getId() {
        return id; // 'S' o 'D'
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public String toString() {
        return "ID: " + getContador() +
                "\nNombre:" + getNombre() +
                "\nApellido1: " + getPrimerApellido() +
                "\nApellido2: " + getSegundoApellido();
    }
}
