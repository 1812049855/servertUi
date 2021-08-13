package com.fhec.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loading extends JFrame {
	static JLabel lblNewLabel =new JLabel("");
	class ImagePanel extends JPanel{
		Dimension d;
		Image image;
		
		public ImagePanel(Dimension d,Image image) {
			super();
			this.d=d;
			this.image=image;
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, d.width,d.height,this);
		}
	 
	}

	Dimension frameSize = new Dimension(560, 370);
	ImageIcon imageIcon = new ImageIcon("image//load.png");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 370);
		this.setLocationRelativeTo(null);//窗体居中显示
		getContentPane().setLayout(null);
		setUndecorated(true);
		
		ImagePanel imagePanel = new ImagePanel(frameSize, imageIcon.getImage());
		setLabTxt("正在初始化.......");
		lblNewLabel.setBounds(10, 310, 45, 20);
		imagePanel.add(lblNewLabel);
	
		setContentPane(imagePanel);
	}
	
	public static void setLabTxt(String txt) {
		lblNewLabel.setText(txt);
	}
	public static void setVisible(Loading l,boolean result) {
		l.setVisible(result);
	}
}
