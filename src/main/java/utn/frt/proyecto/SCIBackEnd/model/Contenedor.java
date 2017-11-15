package utn.frt.proyecto.SCIBackEnd.model;

public class Contenedor {
    private int id;
    private String material;
    private double cordX;
    private double cordY;
    private Recolector recolector;
    private double llenado;
    private double capacidad;

    public Contenedor() {
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

    public Recolector getRecolector() {
        return recolector;
    }

    public void setRecolector(Recolector recolector) {
        this.recolector = recolector;
    }

    public double getLlenado() {
        return llenado;
    }

    public void setLlenado(double llenado) {
        this.llenado = llenado;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Contenedor" + id +
                "\nmaterial: '" + material + '\'' +
                "\nubicacion: " + cordX + "," + cordY +
                "\ncapacidad: " + capacidad + "(lts), libre: " + (capacidad - llenado);
    }
}
