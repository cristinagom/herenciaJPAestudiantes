package model;

public enum Type {
    ESO("Educación Secundaria Obligatoria"),
    BAC("Bachillerato"),
    FP("Formación Profesional");

    private final String descripcion;

    Type(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

