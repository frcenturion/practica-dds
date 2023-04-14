package correlativas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasAInscribirse;

    //inicializamos las materias a inscribirse en 0 y ademas inicializamos el alumno con el que recibamos por parametro
    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasAInscribirse = new ArrayList<>();
    }

    //agregamos las materias a las que se quiere inscribir un alumno
    public void agregarMaterias(Materia ... materias) {
        Collections.addAll(this.materiasAInscribirse, materias);
    }

    //chequea si es valida la inscripcion
    public Boolean aprobada() {

        //tengo que obtener las correlativas de las materias a las que el alumno quiere inscribirse
        List<Materia> correlativasInscripcion = this.materiasAInscribirse.stream().flatMap(m -> m.getCorrelativas().stream()).collect(Collectors.toList());

        //ahora tenemos que obtener las materias que aprobo el alumno
        List<Materia> aprobadas = this.alumno.getMateriasAprobadas();

        //chequeo que el alumno tenga aprobadas esas correlativas -> means que todas las correlativas de la inscripcion estan dentro de la lista de aprobadas
        return aprobadas.containsAll(correlativasInscripcion);

    }
}
