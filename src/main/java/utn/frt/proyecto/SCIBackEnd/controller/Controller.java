package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.model.Llenado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contenedor")
public class Controller {

    private List<Llenado> llenados = new ArrayList<Llenado>();

    @RequestMapping(value = "/{id}/llenado", method = RequestMethod.POST)
    public Boolean llenado(@PathVariable int id, @RequestParam double nivel) {
        llenados.add(new Llenado(id,new Date(),nivel));
        return true;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Llenado> getAll() {
        return llenados;
    }

}
