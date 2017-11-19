package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecolectorRepository {

    private List<Recolector> recolectores = init();

    private ArrayList<Recolector> init() {
        ArrayList<Recolector> recolectors = new ArrayList<>();
        Recolector recolector1 = new Recolector();
        recolector1.setId(1);
        recolector1.setNombre("Luis Gomez");
        recolector1.setDni(20123456);

        Recolector recolector2 = new Recolector();
        recolector2.setId(2);
        recolector2.setNombre("Juan Perez");
        recolector2.setDni(30123456);

        //contenedores
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

        recolector1.getContenedores().add(contenedor1);
        recolector2.getContenedores().add(contenedor2);
        recolector2.getContenedores().add(contenedor3);

        recolectors.add(recolector1);
        recolectors.add(recolector2);

        return recolectors;
    }

    private int id = 2;

    public int save(Recolector recolector) {
        recolectores.add(recolector);
        recolector.setId(++id);
        return id;
    }

    public Recolector findOne(int idRecolector) {
        for (Recolector recolector : recolectores) {
            if (idRecolector == recolector.getId()) {
                return recolector;
            }
        }
        return null;
    }
}
