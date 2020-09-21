package fr.ubordeaux.ao;
import org.jdom2.*;

public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(int x , int y , int height , int width) throws SvgExcept{
        super(x,y,"rect");
        this.height = height;
        this.width = width;
    }

    // Tester ce code avec les autres formes.
    public void generateXml() {
        this.setAttribute("height",""+width);
        this.setAttribute("width",""+width);

        this.setXAttribute("x");
        this.setYAttribute("y");
        this.setColorAttribute("yellow");
    }
}