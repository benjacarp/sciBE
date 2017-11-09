package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.ContenedorDTO;
import utn.frt.proyecto.SCIBackEnd.model.Contenedor;
import utn.frt.proyecto.SCIBackEnd.service.ContenedorService;

@RestController
@RequestMapping("/contenedor")
public class ContenedorController {
    @Autowired
    private ContenedorService service;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int newContenedor(@RequestBody ContenedorDTO contenedorDTO) {
        Contenedor contenedor = new Contenedor();

        contenedor.setModelo(contenedorDTO.getModelo());
        contenedor.setNumeroDeSerie(contenedorDTO.getNumeroDeSerie());

        return service.newContenedor(contenedor);
    }
}
