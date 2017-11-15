package utn.frt.proyecto.SCIBackEnd.dto;

import utn.frt.proyecto.SCIBackEnd.model.Recolector;

public class ContenedorDTO {
    private int id;
    private String material;
    private double cordX;
    private double cordY;
    private String recolectorName;
    private double capacidad;

    public ContenedorDTO() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getCordX() {
        return cordX;
    }

    public void setCordX(double cordX) {
        this.cordX = cordX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCordY() {
        return cordY;
    }

    public void setCordY(double cordY) {
        this.cordY = cordY;
    }

    public String getRecolectorName() {
        return recolectorName;
    }

    public void setRecolectorName(String recolectorName) {
        this.recolectorName = recolectorName;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "material='" + material + '\'' +
                ", ubicacion=" + cordX +
                ", " + cordY +
                '}';
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}

