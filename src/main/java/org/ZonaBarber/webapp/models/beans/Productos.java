package org.ZonaBarber.webapp.models.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class Productos {

    private  int ProId;
    private String ProNombre;
    private int Provalor;
    private int ProCantidad;
    private Blob ProFoto;

    public Productos(int proId, String proNombre, int provalor, int proCantidad, Blob proFoto) {
        ProId = proId;
        ProNombre = proNombre;
        Provalor = provalor;
        ProCantidad = proCantidad;
        ProFoto = proFoto;
    }

    public Productos() {

    }

    public int getProId() {
        return ProId;
    }

    public void setProId(int proId) {
        ProId = proId;
    }

    public String getProNombre() {
        return ProNombre;
    }

    public void setProNombre(String proNombre) {
        ProNombre = proNombre;
    }

    public int getProvalor() {
        return Provalor;
    }

    public void setProvalor(int provalor) {
        Provalor = provalor;
    }

    public int getProCantidad() {
        return ProCantidad;
    }

    public void setProCantidad(int proCantidad) {
        ProCantidad = proCantidad;
    }

    public Blob getProFoto() {
        return ProFoto;
    }

    public void setProFoto(Blob proFoto) {
        ProFoto = proFoto;
    }

    private byte[] imageBytes;


    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
    public byte[] getImageBytes() throws SQLException, IOException {
        if (ProFoto == null) {
            return null;
        } else {
            InputStream inputStream = ProFoto.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = outputStream.toByteArray();
            inputStream.close();
            outputStream.close();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            setImageDataUrl("data:image/jpeg;base64," + base64Image);
            System.out.println("Tamaño de la imagen: " + imageBytes.length);
            return imageBytes;
        }
    }
    private String imageDataUrl;

    public String getImageDataUrl() {
        return imageDataUrl;
    }

    public void setImageDataUrl(String imageDataUrl) {
        this.imageDataUrl = imageDataUrl;
    }



}
