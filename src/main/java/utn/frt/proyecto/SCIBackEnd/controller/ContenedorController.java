package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.ContenedorDTO;
import utn.frt.proyecto.SCIBackEnd.dto.RecolectorDTO;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.repository.RecolectorRepository;
import utn.frt.proyecto.SCIBackEnd.service.ContenedorService;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;
import utn.frt.proyecto.SCIBackEnd.service.RecolectorService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ContenedorController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ContenedorService contenedorService;

    @Autowired
    private RecolectorService recolectorService;

    @RequestMapping(value = "/empresa/{idEmpresa}/contenedor", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Boolean createContenedor(@PathVariable int idEmpresa, ContenedorDTO contenedorDTO) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Contenedor contenedor = new Contenedor();
        contenedor.setMaterial(contenedorDTO.getMaterial());
        contenedor.setCordX(contenedorDTO.getCordX());
        contenedor.setCordY(contenedorDTO.getCordY());

//        contenedor.setId(empresaService.getNextContenedorId());
        contenedorService.save(contenedor);

        empresa.getContenedores().add(contenedor);

        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/empresa/{idEmpresa}/contenedor", method = RequestMethod.GET)
    public List<ContenedorDTO> getContenedores(@PathVariable int idEmpresa) {
        Empresa empresa = empresaService.getById(idEmpresa);

        List<Contenedor> contenedores = empresa.getContenedores();

        return convertToDTO(contenedores);
    }

    private List<ContenedorDTO> convertToDTO(List<Contenedor> contenedores) {
        List<ContenedorDTO> contenedorDTOS = new ArrayList<>();
        ContenedorDTO contenedorDTO;
        for (Contenedor contenedor : contenedores) {
            contenedorDTO = new ContenedorDTO();
            contenedorDTO.setId(contenedor.getId());
            contenedorDTO.setMaterial(contenedor.getMaterial());
            contenedorDTO.setCordX(contenedor.getCordX());
            contenedorDTO.setCordY(contenedor.getCordY());

            if (contenedor.getRecolector() == null) {
                contenedorDTO.setRecolectorName("no asignado");
            } else {
                contenedorDTO.setRecolectorName(contenedor.getRecolector().getNombre());
            }
            contenedorDTOS.add(contenedorDTO);
        }
        return contenedorDTOS;
    }

    //TODO agregar los services de contenedores y recolectores para facilitar esta parte.
    @RequestMapping(value = "/recolector/{idRecolector}/contenedor/{idContenedor}", method = RequestMethod.POST)
    public Boolean createContenedor(@PathVariable int idRecolector,
                                    @PathVariable int idContenedor) {

        Contenedor contenedor = contenedorService.findById(idContenedor);

        Recolector recolector = recolectorService.findById(idRecolector);

        recolector.getContenedores().add(contenedor);

        contenedor.setRecolector(recolector);

        Empresa empresa = empresaService.findByRecolector(recolector);

        empresaService.update(empresa);

        return true;
    }
}
