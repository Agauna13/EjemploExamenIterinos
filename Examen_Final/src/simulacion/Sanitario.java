package simulacion;

public class Sanitario extends Persona {
    private String especialidad;
    private int noDias;


    public Sanitario(String nombre, String primerApellido, String segundoApellido, String especialidad, int noDias) {
        super('S', nombre, primerApellido, segundoApellido);
        setEspecialidad(especialidad);
        setNoDias(noDias);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNoDias() {
        return noDias;
    }

    public void setNoDias(int noDias) {
        this.noDias = noDias;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecialidad: " + especialidad +
                "\nDias experiencia: " + noDias;
    }
}
