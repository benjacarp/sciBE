package utn.frt.proyecto.SCIBackEnd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpresaRepository {

    private List<Empresa> empresas = initEmpresas();

    private ArrayList<Empresa> initEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<>();

        Empresa e = new Empresa();
        e.setId(1);
        e.setNombre("Cooperativa Bach y asociados");
        e.setDireccion("Calle 123");
        e.setCuit("20-12345678-8");
        e.setUser("ebach");
        e.setPassword("1234");

        List<Contenedor> contenedores = e.getContenedores();
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

        contenedores.add(contenedor1);
        contenedores.add(contenedor2);
        contenedores.add(contenedor3);

        List<Recolector> recolectores = e.getRecolectores();

        Recolector recolector1 = new Recolector();
        recolector1.setId(1);
        recolector1.setNombre("Luis Gomez");
        recolector1.setDni(20123456);

        Recolector recolector2 = new Recolector();
        recolector2.setId(2);
        recolector2.setNombre("Juan Perez");
        recolector2.setDni(30123456);

        recolectores.add(recolector1);
        recolectores.add(recolector2);

        recolector1.getContenedores().add(contenedor1);
        contenedor1.setRecolector(recolector1);

        recolector2.getContenedores().add(contenedor2);
        contenedor2.setRecolector(recolector2);

        recolector2.getContenedores().add(contenedor3);
        contenedor3.setRecolector(recolector2);

        empresas.add(e);

        return empresas;
    }

    private int empresaId = 1;
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
                if (contenedor.getId() == contenedorEmpresa.getId()) {
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
