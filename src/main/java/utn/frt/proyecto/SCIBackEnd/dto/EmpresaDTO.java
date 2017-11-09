package utn.frt.proyecto.SCIBackEnd.dto;

import utn.frt.proyecto.SCIBackEnd.model.Contenedor;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDTO {
    private String nombre;
    private String direccion;
    private String cuit;

    private String user;
    private String password;

    private List<ContenedorDTO> contenedores;

    public EmpresaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ContenedorDTO> getContenedores() {
        return contenedores;
    }

    public void setContenedores(List<Contenedor> contenedores) {

        List<ContenedorDTO> contenedoresDTO = new ArrayList<ContenedorDTO>();
        if (contenedores == null)
            return;
        ContenedorDTO contenedorDTO;
        for (Contenedor contenedor : contenedores) {
            contenedorDTO = new ContenedorDTO();
            contenedorDTO.setModelo(contenedor.getModelo());
            contenedorDTO.setNumeroDeSerie(contenedor.getNumeroDeSerie());
            contenedoresDTO.add(contenedorDTO);
        }
        this.contenedores = contenedoresDTO;
    }
}
