package fr.ubordeaux.ao;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.*;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Main {
   static Element racine = new Element("svg");

   static Document document = new Document(racine);
	public static void main(String[] args) throws IOException, SvgExcept {
		Svg shape = new Svg(1000,1000);

		Line l = new Line(0,0,500,500);
		Rectangle r = new Rectangle(50,500,300,400);
		Circle c = new Circle(500,300,30);
		Ellipse e = new Ellipse(500,100,300,100);
		Ellipse e1 = new Ellipse(100,500,100,300);

		shape.add(e);
		shape.add(e1);
		shape.add(c);
		shape.add(r);
		shape.add(l);
		shape.generateXml(racine);
		
		affiche();
	    enregistre("Affichage.svg");
		
		System.out.println("Done");
	}
	
	static void affiche()
	   {
		   try
		   {
			   XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			   sortie.output(document, System.out);
		   }
		   catch (java.io.IOException e){}
	   }
	   	
	   	static void enregistre(String fichier)
	   	{
	   		try
	   		{
	   			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	   			sortie.output(document, new FileOutputStream(fichier));
	   		}
	   		catch (java.io.IOException e){}
	   	}
}