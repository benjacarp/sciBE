package utn.frt.proyecto.SCIBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.repository.EmpresaRepository;

@Component
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public int newEmpresa(Empresa empresa) {
        return repository.save(empresa);
    }

    public Empresa getById(int id) {
        return repository.findOne(id);
    }

    public void update(Empresa empresa) {
        repository.update(empresa);
    }

    public Empresa getByUser(String user) {
        return repository.findByUser(user);
    }

    public int getNextContenedorId() {
        return repository.getNextContenedorId();
    }

    public int getNextRecolectorId() {
        return repository.getNextRecolectorId();
    }

    public Empresa getAllContenedores() {
        return null;
    }

    public Empresa findByContenedor(Contenedor recolector) {
        return repository.findByRecolector(recolector);
    }

    public Recolector getByRecolecotor(int dni) {
        return repository.findByRecolectorDNI(dni);
    }
}
