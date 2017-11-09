package utn.frt.proyecto.SCIBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.repository.ContenedorRepository;

import java.util.List;

@Component
public class ContenedorService {
    @Autowired
    private ContenedorRepository repository;

    public int newContenedor(Contenedor contenedor) {
        return repository.save(contenedor);
    }

    public Contenedor getById(int id) {
        return repository.findOne(id);
    }
}
