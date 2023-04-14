package correlativas.test;

import correlativas.Inscripcion;
import correlativas.Alumno;
import correlativas.Materia;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class CorrelativasTest {

    private Alumno unAlumno;
    private Materia pdep;
    private Materia ayed;
    private Inscripcion unaInscripcion;

    @BeforeEach
    public void init() {

        this.unAlumno = new Alumno();
        this.pdep = new Materia();
        this.ayed = new Materia();
        this.unaInscripcion = new Inscripcion(unAlumno);

        pdep.agregarCorrelativas(ayed);

    }


    @Test
    public void inscripcionAceptada() {

        //el alumno aprobo ayed
        unAlumno.agregarMateriasAprobadas(ayed);

        //y ahora quiere inscribirse a pdep
        unaInscripcion.agregarMaterias(pdep);

        //por ende el sistema lo va a dejar inscribirse
        Assertions.assertTrue(unaInscripcion.aprobada());
    }

    @Test
    public void inscripcionRechazada() {

        //el alumno quiere inscribirse a pdep
        unaInscripcion.agregarMaterias(pdep);

        //pero no aprobo ayed, por lo que la inscripcion sera rechazada
        Assertions.assertFalse(unaInscripcion.aprobada());

    }

}
