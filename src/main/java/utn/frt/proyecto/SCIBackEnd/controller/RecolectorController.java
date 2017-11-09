package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.RecolectorDTO;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecolectorController {
    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/empresa/{idEmpresa}/recolector", method = RequestMethod.POST)
    public Boolean createContenedor(@PathVariable int idEmpresa,
                                    @RequestBody RecolectorDTO recolectorDTO) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Recolector recolector = new Recolector();
        recolector.setDni(recolectorDTO.getDni());
        recolector.setNombre(recolectorDTO.getNombre());

        recolector.setId(empresaService.getNextRecolectorId());

        empresa.getRecolectores().add(recolector);

        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/empresa/{idEmpresa}/recolector", method = RequestMethod.GET)
    public List<RecolectorDTO> getContenedores(@PathVariable int idEmpresa) {
        Empresa empresa = empresaService.getById(idEmpresa);

        List<Recolector> recolectores = empresa.getRecolectores();

        return convertToDTO(recolectores);
    }

    private List<RecolectorDTO> convertToDTO(List<Recolector> recolectores) {
        List<RecolectorDTO> recolectorDTOS = new ArrayList<>();
        RecolectorDTO recolectorDTO;
        for (Recolector recolector : recolectores) {
            recolectorDTO = new RecolectorDTO();
            recolectorDTO.setId(recolector.getId());
            recolectorDTO.setDni(recolector.getDni());
            recolectorDTO.setNombre(recolector.getNombre());
            recolectorDTOS.add(recolectorDTO);
        }
        return recolectorDTOS;
    }

    //TODO agregar los services de contenedores y recolectores para facilitar esta parte.
    @RequestMapping(value = "/recolector/{idRecolector}/contenedor/{idContenedor}", method = RequestMethod.POST)
    public Boolean createContenedor(@PathVariable int idRecolector,
                                    @PathVariable int idContenedor,
                                    @RequestBody RecolectorDTO recolectorDTO) {
        return true;
    }
}
