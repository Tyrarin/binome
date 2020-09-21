package fr.ubordeaux.ao;
import org.jdom2.*;

public class Line extends Shape{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1 , int y1 , int x2 , int y2) throws SvgExcept{
        super("line");
    	if(x1 < 0 || x2 < 0 || y1 < 0 || y2 <0)
    		throw new SvgExcept("must be greater than 0");

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    public void generateXml(){
        this.setAttribute("x1",""+ this.x1);
        this.setAttribute("y1",""+ this.y1);

        this.setAttribute("x2",""+ this.x2);
        this.setAttribute("y2",""+ this.y2);
        this.setColorAttribute("black");
    }

}