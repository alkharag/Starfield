//your code here
Particle [] lots;

void setup()
{
	size(1000, 900);
	lots = new Particle[3000];
	for (int i =0; i <lots.length; i++)
	{
		lots[i] = new NormalParticle();	
	}
	lots[499] = new OddballParticle();

	for(int i=500; i < 520; i++)
	{
		lots[i] = new JumboParticle();
	}
}

void draw()
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
void mousePressed()
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
		vPchange= (Math.random()*5)+0.1;
		vP = (Math.random()*20)+0.1;
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
		yOP = 400;
		vOP = 25;//(Math.random()*5)+10;
		vOPchange = 1;
		angleOP = 0;
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
		yOP= yOP+Math.sin(angleOP)*vOP;
		
	}
	public void wrap()
	{
		angleOP += 0.3;
		
		if(vOPchange <50)
		{
			vOPchange+=0.5;
		}
		
		
	}

}
class JumboParticle extends NormalParticle
{

	int JumboSize;
	JumboParticle ()
	{
		JumboSize = 60;
	}

	public void show()
	{
		noStroke();
		fill(colorP1,colorP2,colorP3,100);
		ellipse((float)xP, (float)yP, JumboSize, JumboSize);
	}
}


