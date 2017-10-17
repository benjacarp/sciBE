package utn.frt.proyecto.SCIBackEnd.model;

import java.util.Date;

public class Llenado {

    private int id;
    private String date;
    private double llenado;

    public Llenado() {
    }

    public Llenado(int id, Date date, double llenado) {
        this.id = id;
        this.date = date.getMonth() + "/" +date.getDate() + " - " +
                date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        this.llenado = llenado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLlenado() {
        return llenado;
    }

    public void setLlenado(double llenado) {
        this.llenado = llenado;
    }
}
