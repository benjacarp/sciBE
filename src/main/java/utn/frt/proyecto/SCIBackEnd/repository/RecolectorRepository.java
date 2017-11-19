package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecolectorRepository {

    private List<Recolector> recolectores = new ArrayList<Recolector>();

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
