package utn.frt.proyecto.SCIBackEnd.model;

public class Contenedor {
    private int id;
    private String material;
    private int cordX;
    private int cordY;
    private Recolector recolector;
    private double espacioLibre;
    private double capacidad;

    public Contenedor() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

    public Recolector getRecolector() {
        return recolector;
    }

    public void setRecolector(Recolector recolector) {
        this.recolector = recolector;
    }

    public double getEspacioLibre() {
        return espacioLibre;
    }

    public void setEspacioLibre(double espacioLibre) {
        this.espacioLibre = espacioLibre;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}
