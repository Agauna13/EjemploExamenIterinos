package simulacion;

public class Docente extends Persona {
    private String titulacion;
    private double puntos;


    public Docente(String nombre, String primerApellido, String segundoApellido, String titulacion, double puntos) {
        super('D', nombre, primerApellido, segundoApellido);
        setTitulacion(titulacion);
        setPuntos(puntos);
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTitulacion: " + getTitulacion() +
                "\nPuntos: " + getPuntos();
    }
}
