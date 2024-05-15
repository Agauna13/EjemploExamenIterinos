package simulacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Datos de configuración
        int plazasDocentes = 5;
        int plazasSanitarios = 5;
        int sanitarios = 3;
        int docentes = 3;
        
        List<Persona> personas = simularPersonas(docentes, sanitarios);
        
        List<Plaza> plazas = simularPlazas(plazasDocentes, plazasSanitarios);
        
        adjudicarPlazas(plazas, personas);
        
        mostrarAdjudicaciones(plazas);
    }

    private static void mostrarAdjudicaciones(List<Plaza> plazas) {
        System.out.println("============================================\n" +
                "La última adjudicación de plazas ha producido\n" +
                "los siguientes resultados para DOCENTES\n" +
                "============================================");
        for (Plaza plaza : plazas) {
            if (plaza.getTipo() == 'D') {
                System.out.println(plaza);
            }
        }

        System.out.println("=============================================\n" +
                "La última adjudicación de plazas ha producido\n" +
                "los siguientes resultados para SANITARIOS\n" +
                "=============================================");
        for (Plaza plaza : plazas) {
            if (plaza.getTipo() == 'S') {
                System.out.println(plaza);
            }
        }
    }

    private static void adjudicarPlazas(List<Plaza> plazas, List<Persona> personas) {
        List<Docente> docentesDisponibles = new ArrayList<>();
        List<Sanitario> sanitariosDisponibles = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getId() == 'S') {
                sanitariosDisponibles.add((Sanitario) persona);
            } else if (persona.getId() == 'D'){
                docentesDisponibles.add((Docente) persona);
            }
        }

        for (Plaza plaza : plazas) {
            // iteramos a través de las plazas disponibles
            if (plaza.getTipo() == 'S') {
                Persona persona = buscarSanitario(sanitariosDisponibles);
                if (persona != null) {
                    plaza.setPersona(persona);
                    plaza.setAdjudicado(true);
                    sanitariosDisponibles.remove(persona); // elimino la persona de los disponibles
                }
            } else {
                Persona persona = buscarDocente(docentesDisponibles);
                if (persona != null) {
                    plaza.setPersona(persona);
                    plaza.setAdjudicado(true);
                    docentesDisponibles.remove(persona);
                }
            }

        }
    }

    private static Persona buscarDocente(List<Docente> docentesDisponibles) {
        double mayor = Double.MIN_VALUE;
        Persona seleccionado = null;
        for (Docente docente : docentesDisponibles) {
            if (docente.getPuntos() > mayor) {
                seleccionado = docente;
                mayor = docente.getPuntos();
            }
        }
        return seleccionado;
    }

    private static Persona buscarSanitario(List<Sanitario> sanitariosDisponibles) {
        int mayor = Integer.MIN_VALUE;
        Persona seleccionado = null;
        for (Sanitario sanitario : sanitariosDisponibles) {
            if (sanitario.getNoDias() > mayor) {
                seleccionado = sanitario;
                mayor = sanitario.getNoDias();
            }
        }
        return seleccionado;
    }

    private static List<Plaza> simularPlazas(int plazasDocentes, int plazasSanitarios) {
        int totalD = plazasDocentes;
        int totalS = plazasSanitarios;
        int id = 0;
        List<Plaza> plazas = new ArrayList<Plaza>(); // creo un arrayList de plazas
        Plaza plaza = null;
        while (totalD > 0 || totalS > 0) { // mientras haya plazas disponibles -> agregar plaza
            if (totalS > 0) {
                // genero plaza sanitario
                plaza = new Plaza(id++, 'S');
                plazas.add(plaza);
                totalS--;
            }
            if (totalD > 0) {
                // genero plaza docente
                plaza = new Plaza(id++, 'D');
                plazas.add(plaza);
                totalD--;
            }
        }
        return plazas;
    }

    private static List<Persona> simularPersonas(int docentes, int sanitarios) {
        int totalD = docentes;
        int totalS = sanitarios;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        while (totalD > 0 || totalS > 0) {
            // Genero Docente
            if (totalD > 0) {
                persona = new Docente(generarNombre(), generarApellido(), generarApellido(),
                        generarTitulacion(), generarNumeroPuntos());
                personas.add(persona);
                totalD--;
            }
            // Genero Sanitario
            if (totalS > 0) {
                persona = new Sanitario(generarNombre(), generarApellido(), generarApellido(),
                        generarEspecialidad(), generarDias());
                personas.add(persona);
                totalS--;
            }
        }
        return personas;
    }

    private static int generarDias() {
        return 1 + (int)(Math.random() * 100);
    }

    private static String generarEspecialidad() {
        int numeroRandom = (int)(Math.random() * 10);
        return "Especialidad" + numeroRandom;
    }

    private static double generarNumeroPuntos() {
        // genera un número de 1.0 a 100.0
        return 1 + (100.0 - 1) * Math.random();
    }

    private static String generarTitulacion() {
        int numeroRandom = (int)(Math.random() * 10);
        return "Titulación" + numeroRandom;
    }

    private static String generarApellido() {
        int numeroRandom = (int)(Math.random() * 100);
        return "Apellido" + numeroRandom;
    }

    private static String generarNombre() {
        int numeroRandom = (int)(Math.random() * 100);
        return "Nombre" + numeroRandom;
    }
}
