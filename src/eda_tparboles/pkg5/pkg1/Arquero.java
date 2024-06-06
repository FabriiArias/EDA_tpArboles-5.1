package eda_tparboles.pkg5.pkg1;

public class Arquero {

    private int puntuacion;
    private String nombre;

    public Arquero(String nombre,int puntos) {
        this.nombre = nombre;
        this.puntuacion = puntos;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
    public int getPuntuacion() {
        return puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Arquero{" + "puntuacion=" + puntuacion + ", nombre=" + nombre + '}';
    }
    
    

}
