package utn.frt.proyecto.SCIBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utn.frt.proyecto.SCIBackEnd.dto.EmpresaDTO;
import utn.frt.proyecto.SCIBackEnd.dto.LoginResponseDTO;
import utn.frt.proyecto.SCIBackEnd.model.Empresa;
import utn.frt.proyecto.SCIBackEnd.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
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

    @RequestMapping(value = "/login", method = RequestMethod.GET
    )
    public LoginResponseDTO login(@RequestParam String user, @RequestParam String pass) {
        Empresa empresa = empresaService.getByUser(user);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        if (empresa == null) {
            loginResponseDTO.setMessage("Usuario invalido");
        } else {
            if (empresa.getPassword().equals(pass)) {
                loginResponseDTO.setMessage("" + empresa.getId());
                loginResponseDTO.setSuccess(true);
            } else
                loginResponseDTO.setMessage("Pass incorrecto");
        }
        return loginResponseDTO;
    }
}
