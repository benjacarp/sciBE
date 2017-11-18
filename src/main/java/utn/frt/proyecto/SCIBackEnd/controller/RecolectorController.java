package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.ContenedorDTO;
import utn.frt.proyecto.SCIBackEnd.dto.LoginResponseDTO;
import utn.frt.proyecto.SCIBackEnd.dto.RecolectorDTO;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;
import utn.frt.proyecto.SCIBackEnd.service.RecolectorService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecolectorController {
    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private RecolectorService recolectorService;

    @RequestMapping(value = "/empresa/{idEmpresa}/recolector", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Boolean createContenedor(@PathVariable int idEmpresa, RecolectorDTO recolectorDTO) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Recolector recolector = new Recolector();
        recolector.setDni(recolectorDTO.getDni());
        recolector.setNombre(recolectorDTO.getNombre());

        recolectorService.save(recolector);

        empresa.getRecolectores().add(recolector);

        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/empresa/{idEmpresa}/recolector/{idRecolector}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Boolean modifyContenedor(@PathVariable int idEmpresa, @PathVariable int idRecolector, RecolectorDTO recolectorDTO) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Recolector recolector = recolectorService.findById(idRecolector);

        recolector.setDni(recolectorDTO.getDni());
        recolector.setNombre(recolectorDTO.getNombre());

        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/empresa/{idEmpresa}/recolector/{idRecolector}", method = RequestMethod.DELETE)
    public Boolean deleteContenedor(@PathVariable int idEmpresa, @PathVariable int idRecolector) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Recolector recolector = recolectorService.findById(idRecolector);

        empresa.getRecolectores().remove(recolector);

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
            recolectorDTO.setContenedorDTOs(convertToContenedorDTO(recolector.getContenedores()));
            recolectorDTOS.add(recolectorDTO);

        }
        return recolectorDTOS;
    }

    private List<ContenedorDTO> convertToContenedorDTO(List<Contenedor> contenedores) {
        List<ContenedorDTO> contenedorDTOS = new ArrayList<>();
        ContenedorDTO contenedorDTO;
        for (Contenedor contenedor : contenedores) {
            contenedorDTO = new ContenedorDTO();
            contenedorDTO.setId(contenedor.getId());
            contenedorDTO.setMaterial(contenedor.getMaterial());
            contenedorDTO.setCordX(contenedor.getCordX());
            contenedorDTO.setCordY(contenedor.getCordY());
            contenedorDTO.setCapacidad(contenedor.getCapacidad());

            if (contenedor.getRecolector() == null) {
                contenedorDTO.setRecolectorName("no asignado");
            } else {
                contenedorDTO.setRecolectorName(contenedor.getRecolector().getNombre());
            }
            contenedorDTOS.add(contenedorDTO);
        }
        return contenedorDTOS;
    }

    @RequestMapping(value = "/recolector/login", method = RequestMethod.GET
    )
    public String login(@RequestParam String dni) {
        Recolector recolector = empresaService.getByRecolecotor(Integer.parseInt(dni));

        if (recolector == null) {
            return null;
        }
        return String.valueOf(recolector.getId());
    }
}
