package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContenedorRepository {

    private List<Contenedor> contenedores = new ArrayList<Contenedor>();

    private int id = 0;

    public int save(Contenedor contenedor) {
        contenedores.add(contenedor);
        contenedor.setId(++id);
        return id;
    }

    public Contenedor findOne(int idContenedor) {
        for (Contenedor contenedor : contenedores) {
            if (idContenedor == contenedor.getId()) {
                return contenedor;
            }
        }
        return null;
    }
}
