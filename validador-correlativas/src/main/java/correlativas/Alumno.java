package correlativas;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Alumno {
    private String nombre;
    private int legajo;
    private List<Materia> materiasAprobadas;

    //inicializamos las materias aprobadas del alumno con una lista vacia
    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }

    //agregamos las materias aprobadas por el alumno
    public void agregarMateriasAprobadas(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }

}
