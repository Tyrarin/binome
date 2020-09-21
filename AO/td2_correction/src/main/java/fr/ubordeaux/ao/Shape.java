
package fr.ubordeaux.ao;
import org.jdom2.Attribute;
import org.jdom2.Element;

import java.lang.Exception;


public abstract class Shape {
    private int x;
    private int y;
    private Element xmlElement;
    

    public Shape(String name){
        xmlElement = new Element(name);
    }

    public Shape(int x, int y, String name) throws SvgExcept {
        this.setX(x);
        this.setY(y);
        xmlElement = new Element(name);
    }

    private void setX(int x) throws SvgExcept{
         if (x <= 0) {throw new SvgExcept("must be greater than 0");}
        this.x = x;
    }

    private void setY(int y) throws SvgExcept {
         if (y <= 0) throw new SvgExcept(" must be greater than 0");
        this.y = y;
    }

    public void setXAttribute(String attribute) {
        xmlElement.setAttribute(new Attribute(attribute, ""+x));
    }

    public void setYAttribute(String attribute) {
        xmlElement.setAttribute(new Attribute(attribute, ""+y));
    }

    public void setAttribute(String attribute, String value) {
        xmlElement.setAttribute(new Attribute(attribute, value));
    }
    
    public void setColorAttribute(String color) {
    	if(this instanceof Line) {
            xmlElement.setAttribute(new Attribute("stroke", color));
    	}
    	else {
        xmlElement.setAttribute(new Attribute("fill", color));
    	}
    }

    public void addContent(Element element) {
        element.addContent(this.xmlElement);
    }

    public abstract void generateXml();

}