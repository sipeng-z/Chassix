package com.project.domain.entity;


/**
 * Quantity  & Target
 */
public class G38QT {

    public Integer getLh() {
        return Lh;
    }

    public void setLh(Integer lh) {
        Lh = lh;
    }

    public Integer getRh() {
        return Rh;
    }

    public void setRh(Integer rh) {
        Rh = rh;
    }

    private Double Quantity;
    private Double Target;
    private Integer Lh;
    private Integer Rh;



    public Double getQuantity() {
        return Quantity;
    }

    public void setQuantity(Double quantity) {
        Quantity = quantity;
    }

    public Double getTarget() {
        return Target;
    }

    public void setTarget(Double target) {
        Target = target;
    }
}
