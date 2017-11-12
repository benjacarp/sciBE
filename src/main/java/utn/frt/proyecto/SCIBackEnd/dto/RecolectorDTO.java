package utn.frt.proyecto.SCIBackEnd.dto;

import java.util.ArrayList;
import java.util.List;

public class RecolectorDTO {
    private int id;
    private int dni;
    private String nombre;
    private List<ContenedorDTO> contenedorDTOs = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ContenedorDTO> getContenedorDTOs() {
        return contenedorDTOs;
    }

    public void setContenedorDTOs(List<ContenedorDTO> contenedorDTOs) {
        this.contenedorDTOs = contenedorDTOs;
    }
}
