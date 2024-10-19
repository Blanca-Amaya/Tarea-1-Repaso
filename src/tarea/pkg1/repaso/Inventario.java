/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea.pkg1.repaso;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Inventario {

    static ArrayList<Inventario> nuevoVehiculo = new ArrayList<Inventario>();
    public String matricula;
    public String marca;
    public String modelo;
    public String color;
    public int fabricacion;
    public int precio;

    public Inventario(String matricula, String marca, String modelo, String color, int fabricacion, int precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fabricacion = fabricacion;
        this.precio = precio;
    }

    public Inventario() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(int fabricacion) {
        this.fabricacion = fabricacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "1. Matricula: " + matricula + "\n 2. Marca: " + matricula + "\n 3. Modelo: " + modelo + "\n 4. Color: " + color + "\n 5. Fabricacion: " + fabricacion + "\n 6. Precio: " + precio;
    }
}
