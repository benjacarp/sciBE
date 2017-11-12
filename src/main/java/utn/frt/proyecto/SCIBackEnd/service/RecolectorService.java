package utn.frt.proyecto.SCIBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.repository.RecolectorRepository;

@Service
public class RecolectorService {

    @Autowired
    private RecolectorRepository recolectorRepository;

    public void save(Recolector recolector) {
        recolectorRepository.save(recolector);
    }

    public Recolector findById(int idRecolector) {
        return recolectorRepository.findOne(idRecolector);
    }
}
