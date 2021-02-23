package com.svalero.appaprendizaje.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Nasa implements Serializable {
    @SerializedName("title")
    private String titulo;
    private String copyright;
    private String explanation;
    @SerializedName("url")
    private String urlImage;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getCopyright() {
        return copyright;
    }
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    public String getExplanation() {
        return explanation;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}

