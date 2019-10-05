/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author grifiun
 */
public class Usuario {
    private String username;
    private String nombre;
    private String apellido;
    private int edad;
    private String pais;
    private String ciudad;
    private String descripcion;
    private String hobbie;
    private String temaInteres;
    private String rol;
    private byte[] fotoUsuario;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public String getTemaInteres() {
        return temaInteres;
    }

    public void setTemaInteres(String temaInteres) {
        this.temaInteres = temaInteres;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public byte[] getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(byte[] fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
    
    
}
