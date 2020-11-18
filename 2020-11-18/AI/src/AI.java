import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	/*变量的声明
	语法：数据类型 变量名称 （标识符）
	*/
	int x,y;
	Image downImg,leftImg,upImg,rightImg,currentImg;
	public MainCanvas(){
		try
		{
			/*给变量赋值
			语法：变量名称=value;
			*/
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			upImg=Image.createImage("/sayo14.png");
			rightImg=Image.createImage("/sayo16.png");
			currentImg=downImg;
				x=120;
				y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：x的坐标，100：y的坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*实现转向代码*/
			/*给变量重新赋值即可*/
			currentImg=leftImg;
			x=x-1;//每次移动一个像素
			System.out.println("向左转");
			}
		if(action==RIGHT){
			currentImg=rightImg;
			x=x+1;
			System.out.println("向右转");
		}
		if(action==UP){
			currentImg=upImg;
			y=y-1;
			System.out.println("向上转");
		}
		if(action==DOWN){
			currentImg=downImg;
			y=y+1;
			System.out.println("向下转");
		}
		repaint();
    }
}