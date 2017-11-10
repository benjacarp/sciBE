package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.EmpresaDTO;
import utn.frt.proyecto.SCIBackEnd.dto.LoginDTO;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public int newEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setNombre(empresaDTO.getNombre());
        empresa.setCuit(empresaDTO.getCuit());
        empresa.setDireccion(empresaDTO.getDireccion());
        empresa.setUser(empresaDTO.getUser());
        empresa.setPassword(empresaDTO.getPassword());

        return empresaService.newEmpresa(empresa);
    }

    @RequestMapping(value = "/{idEmpresa}", method = RequestMethod.GET)
    public EmpresaDTO getEmpresa(@PathVariable int idEmpresa) {
        Empresa empresa = empresaService.getById(idEmpresa);

        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresa.getId());
        empresaDTO.setNombre(empresa.getNombre());
        empresaDTO.setCuit(empresa.getCuit());
        empresaDTO.setDireccion(empresa.getDireccion());

        return empresaDTO;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public LoginDTO getEmpresa(@RequestParam String user, @RequestParam String pass) {
        Empresa empresa = empresaService.getByUser(user);
        LoginDTO loginDTO = new LoginDTO();
        if (empresa == null) {
            loginDTO.setMessage("Usuario invalido");
        } else {
            if (empresa.getPassword().equals(pass)) {
                loginDTO.setMessage("Log in exitoso");
                loginDTO.setSuccess(true);
            } else
                loginDTO.setMessage("Pass incorrecto");
        }
        return loginDTO;
    }
}
