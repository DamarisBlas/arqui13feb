package arquitectura.software.demo.dto;

import java.math.BigDecimal;

public class dto {
    BigDecimal cantidad;

    String de;
    String a;
    //String fecha;

    public dto(BigDecimal cantidad, String de, String a) {
        this.cantidad = cantidad;
        this.de = de;
        this.a = a;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
