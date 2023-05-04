package org.ZonaBarber.webapp.models.beans;

public class Clientes {

    int ClientesId;
    String ClientesNombre;
    String ClientesApellido;
    String ClientesDireccion;
    String ClientesIdentificacion;
    String ClientesTipoIdent;
    String ClientesCelular;
    String ClientesCorreo;
    String ClientesContrasena;

    public Clientes() {
    }

    public Clientes(int clientesId, String clientesNombre, String clientesApellido, String clientesDireccion, String clientesIdentificacion, String clientesTipoIdent, String clientesCelular, String clientesCorreo, String clientesContrasena) {
        ClientesId = clientesId;
        ClientesNombre = clientesNombre;
        ClientesApellido = clientesApellido;
        ClientesDireccion = clientesDireccion;
        ClientesIdentificacion = clientesIdentificacion;
        ClientesTipoIdent = clientesTipoIdent;
        ClientesCelular = clientesCelular;
        ClientesCorreo = clientesCorreo;
        ClientesContrasena = clientesContrasena;
    }

    public int getClientesId() {
        return ClientesId;
    }

    public void setClientesId(int clientesId) {
        ClientesId = clientesId;
    }

    public String getClientesNombre() {
        return ClientesNombre;
    }

    public void setClientesNombre(String clientesNombre) {
        ClientesNombre = clientesNombre;
    }

    public String getClientesApellido() {
        return ClientesApellido;
    }

    public void setClientesApellido(String clientesApellido) {
        ClientesApellido = clientesApellido;
    }

    public String getClientesDireccion() {
        return ClientesDireccion;
    }

    public void setClientesDireccion(String clientesDireccion) {
        ClientesDireccion = clientesDireccion;
    }

    public String getClientesIdentificacion() {
        return ClientesIdentificacion;
    }

    public void setClientesIdentificacion(String clientesIdentificacion) {
        ClientesIdentificacion = clientesIdentificacion;
    }

    public String getClientesTipoIdent() {
        return ClientesTipoIdent;
    }

    public void setClientesTipoIdent(String clientesTipoIdent) {
        ClientesTipoIdent = clientesTipoIdent;
    }

    public String getClientesCelular() {
        return ClientesCelular;
    }

    public void setClientesCelular(String clientesCelular) {
        ClientesCelular = clientesCelular;
    }

    public String getClientesCorreo() {
        return ClientesCorreo;
    }

    public void setClientesCorreo(String clientesCorreo) {
        ClientesCorreo = clientesCorreo;
    }

    public String getClientesContrasena() {
        return ClientesContrasena;
    }

    public void setClientesContrasena(String clientesContrasena) {
        ClientesContrasena = clientesContrasena;
    }
}