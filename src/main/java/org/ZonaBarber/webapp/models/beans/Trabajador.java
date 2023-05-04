package org.ZonaBarber.webapp.models.beans;

public class Trabajador {

    int EmplId;
    String EmplNombre;
    String EmplApellido;
    String EmplCorreo;
    String EmplContrasena;
    String EmplGenero;
    String EmplServicio;
    int EmplTipoEmpl;
    String EmplDireccion;
    String EmplTipoIdent;
    String EmplNumIdent;
    String EmplFoto;
    String EmplNumeroTel;

    public Trabajador(int emplId, String emplNombre, String emplApellido, String emplCorreo, String emplContrasena, String emplGenero, String emplServicio, int emplTipoEmpl, String emplDireccion, String emplTipoIdent, String emplNumIdent, String emplFoto, String emplNumeroTel) {
        EmplId = emplId;
        EmplNombre = emplNombre;
        EmplApellido = emplApellido;
        EmplCorreo = emplCorreo;
        EmplContrasena = emplContrasena;
        EmplGenero = emplGenero;
        EmplServicio = emplServicio;
        EmplTipoEmpl = emplTipoEmpl;
        EmplDireccion = emplDireccion;
        EmplTipoIdent = emplTipoIdent;
        EmplNumIdent = emplNumIdent;
        EmplFoto = emplFoto;
        EmplNumeroTel = emplNumeroTel;
    }

    public Trabajador() {
    }



    public int getEmplId() {
        return EmplId;
    }

    public void setEmplId(int emplId) {
        EmplId = emplId;
    }

    public String getEmplNombre() {
        return EmplNombre;
    }

    public void setEmplNombre(String emplNombre) {
        EmplNombre = emplNombre;
    }

    public String getEmplApellido() {
        return EmplApellido;
    }

    public void setEmplApellido(String emplApellido) {
        EmplApellido = emplApellido;
    }

    public String getEmplCorreo() {
        return EmplCorreo;
    }

    public void setEmplCorreo(String emplCorreo) {
        EmplCorreo = emplCorreo;
    }

    public String getEmplContrasena() {
        return EmplContrasena;
    }

    public void setEmplContrasena(String emplContrasena) {
        EmplContrasena = emplContrasena;
    }

    public String getEmplGenero() {
        return EmplGenero;
    }

    public void setEmplGenero(String emplGenero) {
        EmplGenero = emplGenero;
    }

    public String getEmplNumeroTel() {
        return EmplNumeroTel;
    }

    public void setEmplNumeroTel(String emplNumeroTel) {
        EmplNumeroTel = emplNumeroTel;
    }

    public String getEmplTipoEmpl() {
        return String.valueOf(EmplTipoEmpl);
    }

    public void setEmplTipoEmpl(int emplTipoEmpl) {
        EmplTipoEmpl = emplTipoEmpl;
    }

    public String getEmplDireccion() {
        return EmplDireccion;
    }

    public void setEmplDireccion(String emplDireccion) {
        EmplDireccion = emplDireccion;
    }

    public String getEmplTipoIdent() {
        return EmplTipoIdent;
    }

    public void setEmplTipoIdent(String emplTipoIdent) {
        EmplTipoIdent = emplTipoIdent;
    }

    public String getEmplNumIdent() {
        return EmplNumIdent;
    }

    public void setEmplNumIdent(String emplNumIdent) {
        EmplNumIdent = emplNumIdent;
    }

    public String getEmplFoto() {
        return EmplFoto;
    }

    public void setEmplFoto(String emplFoto) {
        EmplFoto = emplFoto;
    }
}


