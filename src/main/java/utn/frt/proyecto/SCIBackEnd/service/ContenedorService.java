package utn.frt.proyecto.SCIBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.repository.ContenedorRepository;
import utn.frt.proyecto.SCIBackEnd.repository.RecolectorRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<Contenedor> getContenedoresSortedByMaterial(String material) {
        List<Contenedor> contenedores;
        if (!material.equals("")) {
            contenedores = contenedorRepository.getAllFilterByMaterial(material);
        } else {
            contenedores = contenedorRepository.getAll();
        }

        return contenedores;
    }

    public List<Contenedor> getAllByRecolector(Recolector recolector) {
        List<Contenedor> allContenedores = contenedorRepository.getAll();
        List<Contenedor> contenedores = new ArrayList<>();

        for (Contenedor contenedor : allContenedores) {
            if (recolector.equals(contenedor.getRecolector())) {
                contenedores.add(contenedor);
            }
        }
        return contenedores;
    }
}
