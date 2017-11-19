package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContenedorRepository {

    private List<Contenedor> contenedores = init();

    private ArrayList<Contenedor> init() {
        ArrayList<Contenedor> contenedors = new ArrayList<>();

        Contenedor contenedor1 = new Contenedor();
        contenedor1.setId(1);
        contenedor1.setCapacidad(100);
        contenedor1.setCordX(-26.819442);
        contenedor1.setCordY(-65.202670);
        contenedor1.setMaterial("pet");

        Contenedor contenedor2 = new Contenedor();
        contenedor2.setId(2);
        contenedor2.setCapacidad(150);
        contenedor2.setCordX(-26.819123);
        contenedor2.setCordY(-65.202456);
        contenedor2.setMaterial("vidrio");

        Contenedor contenedor3 = new Contenedor();
        contenedor3.setId(3);
        contenedor3.setCapacidad(80);
        contenedor3.setCordX(-26.123456);
        contenedor3.setCordY(-65.123456);
        contenedor3.setMaterial("pet");

        //recolectores
        Recolector recolector1 = new Recolector();
        recolector1.setId(1);
        recolector1.setNombre("Luis Gomez");
        recolector1.setDni(20123456);

        Recolector recolector2 = new Recolector();
        recolector2.setId(2);
        recolector2.setNombre("Juan Perez");
        recolector2.setDni(30123456);

        contenedor1.setRecolector(recolector1);
        contenedor2.setRecolector(recolector2);
        contenedor3.setRecolector(recolector2);

        contenedors.add(contenedor1);
        contenedors.add(contenedor2);
        contenedors.add(contenedor3);

        return contenedors;
    }

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
