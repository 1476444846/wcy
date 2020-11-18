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
	/*����������
	�﷨���������� �������� ����ʶ����
	*/
	int x,y;
	Image downImg,leftImg,upImg,rightImg,currentImg;
	public MainCanvas(){
		try
		{
			/*��������ֵ
			�﷨����������=value;
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
		g.drawImage(currentImg,x,y,0);//120��x�����꣬100��y������
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
			/*ʵ��ת�����*/
			/*���������¸�ֵ����*/
			currentImg=leftImg;
			x=x-1;//ÿ���ƶ�һ������
			System.out.println("����ת");
			}
		if(action==RIGHT){
			currentImg=rightImg;
			x=x+1;
			System.out.println("����ת");
		}
		if(action==UP){
			currentImg=upImg;
			y=y-1;
			System.out.println("����ת");
		}
		if(action==DOWN){
			currentImg=downImg;
			y=y+1;
			System.out.println("����ת");
		}
		repaint();
    }
}