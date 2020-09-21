package fr.ubordeaux.ao;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Element;

import java.lang.Exception;

public class Svg {
    private int width;
    private int height;
    private List<Shape> shapes;

    

    public Svg(int width, int height) throws SvgExcept {
        if (width == 0 || height == 0)
             throw new SvgExcept("SVG is too small");
        this.width = width;
        this.height = height;
        shapes = new ArrayList<Shape>();
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    public void generateXml(Element body) {
        body.setAttribute(new Attribute("width", "" + this.width));
        body.setAttribute(new Attribute("height", "" + this.height));
        for (Shape shape: shapes) {
            shape.generateXml();
            shape.addContent(body);
        }
    }

}