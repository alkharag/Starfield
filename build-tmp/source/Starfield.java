import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

//your code here
Particle [] lots;

public void setup()
{
	size(1000, 900);
	lots = new Particle[3000];
	for (int i =0; i <lots.length; i++)
	{
		lots[i] = new NormalParticle();	
	}
	lots[499] = new OddballParticle();
}

public void draw()
{
	if(mousePressed==false)
	{
		background(0, 0, 0);
	}
	
	for (int i =0; i<lots.length; i++)
	{
		lots[i].show();
		lots[i].move();
		lots[i].wrap();
	}
}
public void mousePressed()
{
	if(mousePressed==true)
	{
		for (int i =0; i<lots.length; i++)
		{
			lots[i].show();
			lots[i].move();
			lots[i].wrap();
		}
	}

	
}
class NormalParticle implements Particle 
{
	double xP,yP,vP,angleP,vPchange;
	int colorP1,colorP2,colorP3;
	NormalParticle()
	{
		xP = 500;
		yP = 450;
		vPchange= (Math.random()*5)+0.1f;
		vP = (Math.random()*20)+0.1f;
		angleP = Math.PI*Math.random()*3;
		colorP1=(int)(Math.random()*255);
		colorP2=(int)(Math.random()*255);
		colorP3=(int)(Math.random()*255);
		
	}
	public void show()
	{
		noStroke();
		fill(colorP1,colorP2,colorP3,(float)(750/vP));
		ellipse((float)xP, (float)yP, (float)vP, (float)vP);		
	}
	public void move()
	{

		xP= xP+Math.cos(angleP)*vP;
		yP= yP+Math.sin(angleP)*vP;
	}
	public void wrap()
	{

		if(xP > width || xP < 0)
		{
			xP = 500;
			yP = 450;
			vP = (Math.random()*5)+1;
			angleP = Math.PI*Math.random()*3;
			
		}
	}
}
interface Particle
{
	public void show();
	public void move();
	public void wrap();
}

class OddballParticle implements Particle
{
	double xOP,yOP,vOP,angleOP,vOPchange,OPsize;
	OddballParticle()
	{
		xOP = 500;
		yOP = 450;
		vOP = 10;//(Math.random()*5)+10;
		vOPchange = 1;
		angleOP = Math.PI*Math.random()*3;
	}	
	public void show()
	{
		noStroke();
		fill(255);
		ellipse((float)xOP,(float)yOP,(float)(50-vOPchange),(float)(50-vOPchange));
	}
	public void move()
	{
		xOP= xOP+Math.cos(angleOP)*vOP;
		yOP= yOP+Math.cos(angleOP)*vOP;
		
	}
	public void wrap()
	{
		angleOP += 0.05f;
		
		if(vOPchange <50)
		{
			vOPchange++;
		}
		if(vOPchange == 50)
		{
			vOPchange =0;
		}
		
	}

}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
