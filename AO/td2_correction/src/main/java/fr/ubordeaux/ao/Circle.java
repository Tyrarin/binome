package fr.ubordeaux.ao;
import org.jdom2.*;

public class Circle extends Shape{
    private int radius;

    public Circle(int x , int y , int radius) throws SvgExcept{
        super(x,y,"circle");
        this.radius = radius;
    }

    public void generateXml(){
        this.setAttribute("r",""+radius);

        this.setXAttribute("cx");
        this.setYAttribute("cy");
        this.setColorAttribute("blue");
    }
}