package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpresaRepository {

    private List<Empresa> empresas = new ArrayList<Empresa>();

    private int empresaId = 0;
    private int contenedorId = 0;
    private int recolectorId = 0;

    public int save(Empresa empresa) {
        empresas.add(empresa);
        empresa.setId(++empresaId);
        return empresaId;
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

    public int getNextContenedorId() {
        return ++contenedorId;
    }

    public int getNextRecolectorId() {
        return ++recolectorId;
    }

    public Empresa findByRecolector(Contenedor contenedor) {
        for (Empresa empresa: empresas) {
            for (Contenedor contenedorEmpresa : empresa.getContenedores()) {
                if (contenedor.equals(contenedorEmpresa)) {
                    return empresa;
                }
            }
        }
        return null;
    }

    public Recolector findByRecolectorDNI(int dni) {
        for (Empresa empresa: empresas) {
            for (Recolector recolector : empresa.getRecolectores()) {
                if (recolector.getDni() == dni) {
                    return recolector;
                }
            }
        }
        return null;
    }
}
