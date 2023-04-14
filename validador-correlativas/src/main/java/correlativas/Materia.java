package correlativas;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Materia {
    private String nombre;
    private List<Materia> correlativas;


    //inicializamos las materias en 0
    public Materia() {
        this.correlativas = new ArrayList<>();
    }

    //agregamos correlativas a una materia
    public void agregarCorrelativas(Materia ... materias) {
        Collections.addAll(this.correlativas, materias);
    }
}
