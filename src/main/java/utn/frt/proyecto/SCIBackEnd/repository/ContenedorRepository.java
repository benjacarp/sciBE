package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContenedorRepository {

    private List<Contenedor> contenedores = new ArrayList<Contenedor>();

    private int id = 3;

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

    public List<Contenedor> getAll() {
        return contenedores;
    }

    public List<Contenedor> getAllFilterByMaterial(String material) {
        List<Contenedor> contenedoresFiltrados = new ArrayList<>();
        for (Contenedor c : contenedores) {
            if (c.getMaterial().equals(material)) {
                contenedoresFiltrados.add(c);
            }
        }
        return contenedoresFiltrados;
    }
}
