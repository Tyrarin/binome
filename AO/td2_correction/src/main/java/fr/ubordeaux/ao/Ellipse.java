package fr.ubordeaux.ao;
import org.jdom2.*;


public class Ellipse extends Shape{
    private int radiusX;
    private int radiusY;

    public Ellipse(int x , int y , int radiusX , int radiusY) throws SvgExcept{
        super(x,y,"ellipse");
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public void generateXml(){
        this.setAttribute("rx",""+this.radiusX);
        this.setAttribute("ry",""+this.radiusY);

        this.setXAttribute("cx");
        this.setYAttribute("cy");
        this.setColorAttribute("red");
    }
    
}