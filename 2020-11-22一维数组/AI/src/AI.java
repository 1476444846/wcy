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
	int leftFlag,rightFlag,upFlag,downFlag;
	Image heroLeftImag[]=new Image[3];
	Image heroRightImag[]=new Image[3];
	Image heroUpImag[]=new Image[3];
	Image heroDownImag[]=new Image[3];
	Image currentImg;

	public MainCanvas(){
		try
		{
			/*给变量赋值
			语法：变量名称=value;
			*/

			//左
			for(int i=0;i<heroLeftImag.length;i++){
				heroLeftImag[i]=Image.createImage("/sayo"+i+"2.png");
				}
			/*leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");*/

			//右
			for(int i=0;i<heroRightImag.length;i++){
				heroRightImag[i]=Image.createImage("/sayo"+i+"6.png");
				}
			/*rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");*/

			//上
			for(int i=0;i<heroUpImag.length;i++){
				heroUpImag[i]=Image.createImage("/sayo"+i+"4.png");
				}
			/*upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");*/
			
			//下
			for(int i=0;i<heroDownImag.length;i++){
				heroDownImag[i]=Image.createImage("/sayo"+i+"0.png");
				}
			/*downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");*/


			currentImg=heroDownImag[1];
				x=120;
				y=100;
				leftFlag=1;
				rightFlag=1;
				upFlag=1;
				downFlag=1;
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
	public void keyReleased(int keyCode){
		
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*实现转向代码*/
			/*给变量重新赋值即可*/
			if(leftFlag==1)
			{
				currentImg=heroLeftImag[0];
				leftFlag++;
			}
				else if(leftFlag==2)
					{
				currentImg=heroLeftImag[2];
				leftFlag=1;
					}
			x=x-1;//每次移动一个像素
			}
		if(action==RIGHT){
			if(rightFlag==1)
			{
				currentImg=heroRightImag[0];
				rightFlag++;
			}
				else if(rightFlag==2)
					{
				currentImg=heroRightImag[2];
				rightFlag=1;
					}
			x=x+1;
			}
		if(action==UP){
			if(upFlag==1)
			{
				currentImg=heroUpImag[0];
				upFlag++;
			}
				else if(upFlag==2)
					{
				currentImg=heroUpImag[2];
				upFlag=1;
					}
			y=y-1;
		}
		if(action==DOWN){
			if(downFlag==1)
			{
				currentImg=heroDownImag[0];
				downFlag++;
			}
				else if(downFlag==2)
					{
				currentImg=heroDownImag[2];
				downFlag=1;
					}
			y=y+1;
		}
		repaint();
    }
}