package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.ContenedorDTO;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.service.ContenedorService;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContenedorController {
    @Autowired
    private ContenedorService contenedorService;

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/empresa/{idEmpresa}/contenedor", method = RequestMethod.POST)
    public Boolean createContenedor(@PathVariable int idEmpresa,
                                    @RequestBody ContenedorDTO contenedorDTO) {
        Empresa empresa = empresaService.getById(idEmpresa);

        Contenedor contenedor = new Contenedor();
        contenedor.setMaterial(contenedorDTO.getMaterial());
        contenedor.setCordX(contenedorDTO.getCordX());
        contenedor.setCordY(contenedorDTO.getCordY());

        contenedorService.newContenedor(contenedor);

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
            contenedorDTOS.add(contenedorDTO);
        }
        return contenedorDTOS;
    }
}
