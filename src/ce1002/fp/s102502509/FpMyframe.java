package ce1002.fp.s102502509;

import java.awt.CardLayout;


import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.security.ProtectionDomain;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FpMyframe extends JFrame //music 
{
	//都要static
	protected static FpStart fpStart = new FpStart();
	protected static FpEnd fpEnd = new FpEnd();
	protected static FpOne fpOne = new FpOne();
	protected static FpTwo fpTwo = new FpTwo();
	protected static FpDirection fpDirection = new FpDirection();

	JPanel cards = new JPanel();
	CardLayout cl = new CardLayout();
	
	FpMyframe()
	{
		super("Body Fat Consumer");
		setLayout(null);
		setLocation(450,50);
		setSize(500, 500);
		setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//鎖死視窗大小
		setResizable(false);
		add(fpEnd);// 顯示紀錄
		add(fpStart);// 開始 載入
		add(fpOne);//填資料 存txt
		add(fpTwo); // 計時器
		add(fpDirection);
		addWindowListener((WindowListener) new AdapterDemo());
		/*cards.setLayout(cl);//the other method of change the panel called card layout 
		fpStart.setBackground(Color.YELLOW);
		fpOne.setBackground(Color.YELLOW);
		fpTwo.setBackground(Color.YELLOW);
		fpEnd.setBackground(Color.YELLOW);
		cards.add(fpStart, "1");
		cards.add(fpOne, "2");
		cards.add(fpTwo, "1");
		cards.add(fpEnd, "1");
		cl.show(cards, "1");*/
	}// Fp
	//換panel方法
	public static void Showstart()
	{
		
		fpStart.setVisible(true);
	}
	
	public static void Showone()
	{
		
		fpOne.setVisible(true);
	}
	
	public static void Showtwo()
	{
		
		fpTwo.setVisible(true);
	}
	
	public static void Showend()
	{
		
		fpEnd.setVisible(true);
	}
	
	public static void Showdirection()
	{
		fpDirection.setVisible(true);
	}
}// class

class AdapterDemo extends WindowAdapter 
{
    public void windowClosing(WindowEvent e) 
    {
        System.exit(0);
    }
}
