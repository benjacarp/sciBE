package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.ContenedorDTO;
import utn.frt.proyecto.SCIBackEnd.dto.RecolectorDTO;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Recolector;
import utn.frt.proyecto.SCIBackEnd.service.ContenedorService;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;
import utn.frt.proyecto.SCIBackEnd.service.RecolectorService;

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

        contenedorService.save(contenedor);

        empresa.getContenedores().add(contenedor);

        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/empresa/{idEmpresa}/contenedor/{idContenedor}", method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Boolean modifyContenedor(@PathVariable int idEmpresa, @PathVariable int idContenedor, ContenedorDTO contenedorDTO) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Contenedor contenedor = contenedorService.findById(idContenedor);

        contenedor.setMaterial(contenedorDTO.getMaterial());
        contenedor.setCordX(contenedorDTO.getCordX());
        contenedor.setCordY(contenedorDTO.getCordY());

        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/empresa/{idEmpresa}/contenedor/{idContenedor}", method = RequestMethod.DELETE)
    public Boolean deleteContenedor(@PathVariable int idEmpresa, @PathVariable int idContenedor) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Contenedor contenedor = contenedorService.findById(idContenedor);

        empresa.getContenedores().remove(contenedor);

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

    @RequestMapping(value = "/recolector/{idRecolector}/contenedor/{idContenedor}", method = RequestMethod.POST)
    public Boolean createContenedor(@PathVariable int idRecolector,
                                    @PathVariable int idContenedor) {

        Contenedor contenedor = contenedorService.findById(idContenedor);

        Recolector recolector = recolectorService.findById(idRecolector);

        recolector.getContenedores().add(contenedor);

        contenedor.setRecolector(recolector);

        Empresa empresa = empresaService.findByContenedor(contenedor);

        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/contenedor", method = RequestMethod.GET)
    public List<String> viewAll(@RequestParam int x, @RequestParam int y, @RequestParam(defaultValue = "") String material) {
        List<Contenedor> contenedoresOrdenados = contenedorService.getContenedoresSortedByDistance(x, y, material);

//        return convertToDTOForUser(contenedoresOrdenados);

        List<String> contenedores = new ArrayList<>();
        for (Contenedor contenedor : contenedoresOrdenados) {
            contenedores.add(contenedor.toString());
        }
        return contenedores;
    }

    private List<ContenedorDTO> convertToDTOForUser(List<Contenedor> contenedoresOrdenados) {
        List<ContenedorDTO> contenedorDTOS = new ArrayList<>();
        ContenedorDTO contenedorDTO;
        for (Contenedor contenedor : contenedoresOrdenados) {
            contenedorDTO = new ContenedorDTO();
            contenedorDTO.setMaterial(contenedor.getMaterial());
            contenedorDTO.setCordX(contenedor.getCordX());
            contenedorDTO.setCordY(contenedor.getCordY());
            contenedorDTOS.add(contenedorDTO);
        }
        return contenedorDTOS;
    }

    @RequestMapping(value = "/recolector/{id}/contenedor", method = RequestMethod.GET)
    public List<ContenedorDTO> getContenedoresForRecolector(@PathVariable int id) {
        Recolector recolector = recolectorService.findById(id);
        List<Contenedor> contenedores = contenedorService.getAllByRecolector(recolector);
        return convertToDTOForRecolector(contenedores);
    }

    private List<ContenedorDTO> convertToDTOForRecolector(List<Contenedor> contenedores) {
        List<ContenedorDTO> contenedorDTOS = new ArrayList<>();
        ContenedorDTO contenedorDTO;
        for (Contenedor contenedor : contenedores) {
            contenedorDTO = new ContenedorDTO();
            contenedorDTO.setId(contenedor.getId());
            contenedorDTO.setMaterial(contenedor.getMaterial());
            contenedorDTO.setCordX(contenedor.getCordX());
            contenedorDTO.setCordY(contenedor.getCordY());
            contenedorDTOS.add(contenedorDTO);
        }
        return contenedorDTOS;
    }
}
