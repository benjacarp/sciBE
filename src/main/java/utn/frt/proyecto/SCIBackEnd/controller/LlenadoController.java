package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.model.Llenado;
import utn.frt.proyecto.SCIBackEnd.service.ContenedorService;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/llenado")
public class LlenadoController {
    private List<Llenado> llenados = new ArrayList<Llenado>();

    @Autowired
    private ContenedorService contenedorService;

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Boolean llenado(@PathVariable int id, @RequestParam double llenado) {
        Contenedor contenedor = contenedorService.findById(id);
        contenedor.setLlenado(llenado);
        Empresa empresa = empresaService.findByContenedor(contenedor);
        empresaService.update(empresa);

        return true;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Llenado> getAll() {
        return llenados;
    }
}
