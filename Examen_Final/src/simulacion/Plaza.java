package simulacion;

public class Plaza {
    private int id; // correlativo
    private char tipo; // 'D': Docente, 'S': Sanitario
    private boolean adjudicado; // true -> adjudicado
    private Persona persona;

    public Plaza(int id, char tipo) {
        setId(id);
        setTipo(tipo);
        setAdjudicado(false); // cuando se crea la plaza no está adjudicada
        setPersona(null); // cuando se crea la plaza no tiene persona asignada
    }

    public boolean isAdjudicado() {
        return adjudicado;
    }

    public void setAdjudicado(boolean adjudicado) {
        this.adjudicado = adjudicado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String adjudicada = isAdjudicado() ? "ADJUDICADA" : "NO_ADJUDICADA";
        if (persona != null) {
            return "ID Plaza " + getId() +
                    "\nTipo: " + getTipo() +
                    "\nAdjudicada: " + adjudicada
                    + "\n"
                    + getPersona().toString() +
                    "\n____________________________________________";
        } else {
            return "ID Plaza " + getId() +
                    "\nTipo: " + getTipo() +
                    "\nAdjudicada: " + adjudicada;
        }

    }
}
