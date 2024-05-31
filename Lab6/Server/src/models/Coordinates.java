package models;

import java.io.Serial;
import java.io.Serializable;

public class Coordinates implements Serializable {
    @Serial
    private static final long serialVersionUID = -2198189148456433200L;
    private Long x;
    private Double y;
    public Coordinates(Long x, Double y){
        this.x = x;
        this.y = y;
    }
    public Long getX(){
        return x;
    }
    public void setX(Long x){
        this.x = x;
    }
    public Double getY(){
        return y;
    }
    public void setY(Double y){
        this.y = y;
    }
}
