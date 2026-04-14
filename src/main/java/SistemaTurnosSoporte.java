import java.util.LinkedList;
import java.util.Queue;

public class SistemaTurnosSoporte {

    private Queue<String[]> cola;
    private static final int CAPACIDAD_MAXIMA = 10;

    public SistemaTurnosSoporte() {
        cola = new LinkedList<>();
    }

    public boolean registrarTurno(String codigo, String problema) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }
        if (problema == null || problema.trim().isEmpty()) {
            return false;
        }
        if (cola.size() >= CAPACIDAD_MAXIMA) {
            return false;
        }
        String codigoTrim = codigo.trim();
        for (String[] turno : cola) {
            if (turno[0].equalsIgnoreCase(codigoTrim)) {
                return false;
            }
        }
        cola.offer(new String[]{ codigoTrim, problema.trim() });
        return true;
    }

    public String verSiguienteTurno() {
        if (cola.isEmpty()) {
            return "No hay turnos";
        }
        String[] turno = cola.peek();
        return turno[0] + " | " + turno[1];
    }

    public String atenderSiguienteTurno() {
        if (cola.isEmpty()) {
            return "No hay turnos";
        }
        String[] turno = cola.poll();
        return turno[0] + " | " + turno[1];
    }

    public int obtenerCantidadTurnos() {
        return cola.size();
    }

    public int obtenerEspaciosDisponibles() {
        return CAPACIDAD_MAXIMA - cola.size();
    }

    public String mostrarCola() {

    }
}