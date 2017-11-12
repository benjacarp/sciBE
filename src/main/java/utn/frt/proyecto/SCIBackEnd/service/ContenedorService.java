package utn.frt.proyecto.SCIBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.repository.ContenedorRepository;
import utn.frt.proyecto.SCIBackEnd.repository.RecolectorRepository;

@Service
public class ContenedorService {

    @Autowired
    private ContenedorRepository contenedorRepository;

    public void save(Contenedor contenedor) {
        contenedorRepository.save(contenedor);
    }

    public Contenedor findById(int idContenedor) {
        return contenedorRepository.findOne(idContenedor);
    }
}
