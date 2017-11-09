package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpresaRepository {

    private List<Empresa> empresas = new ArrayList<Empresa>();
    private int id = 0;

    public int save(Empresa empresa) {
        empresas.add(empresa);
        empresa.setId(++id);
        return id;
    }

    public Empresa findOne(int id) {
        for (Empresa empresa: empresas) {
            if (id == empresa.getId()) {
                return empresa;
            }
        }
        return null;
    }

    public void update(Empresa newEmpresa) {
        Empresa oldEmpresa = findOne(newEmpresa.getId());
        empresas.remove(oldEmpresa);
        empresas.add(newEmpresa);
    }

    public Empresa findByUser(String user) {
        for (Empresa empresa: empresas) {
            if (user.equals(empresa.getUser())) {
                return empresa;
            }
        }
        return null;
    }
}
