package ce1002.fp.s102502509;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FpDirection extends JPanel implements ActionListener 
{
	private JButton bt2 = new JButton();
	private JButton bt3 = new JButton();
	private JLabel label = new JLabel();
	
	public FpDirection() 
	{
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 500, 500);
		setVisible(false);

		//加入背景
		ImageIcon picIcon = new ImageIcon("speak.jpg");
		//圖片充斥背景
		picIcon.setImage(picIcon.getImage().getScaledInstance(picIcon.getIconWidth(), 
				                            picIcon.getIconHeight(), Image.SCALE_DEFAULT));
		label.setBounds(0, 0, 500, 500);
		//置中，預設0
		label.setHorizontalAlignment(0);
		label.setIcon(picIcon);
		
		bt3.setBounds(40, 400, 100, 30);
		bt3.setText("Home");
		add(bt3);
		
		bt2.setBounds(350, 400, 100, 30);
		bt2.setText("Start");
		add(bt2);
		//label的位置要對
		add(label);
		
		bt3.addActionListener(this);
		bt2.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent a) 
	{
		// TODO Auto-generated method stub
		String buttonName = a.getActionCommand();
		if(buttonName.equals("Home"))
		{
			setVisible(false);
			FpMyframe.Showstart();
		}
		
		else
		{
			setVisible(false);
			FpMyframe.Showone();
		}
	}
}


