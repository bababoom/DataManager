package Main;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Time extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel time ;
	private Date date = new Date();
	private JLabel hour ;
	private java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("yyyyƒÍ MM‘¬ dd»’ ");  
	private java.text.SimpleDateFormat fmt2 = new java.text.SimpleDateFormat("HH:mm:ss"); 
	/**
	 * Create the panel.
	 */
	public Time() {
		this.initial();
		new Thread(this).start();
	}
	public void initial(){
		this.setBounds(800, 620, 300, 40);
		this.setLayout(null);
		
		time = new JLabel() ;
		time.setBounds(0,0,150,50) ;
		hour = new JLabel() ;
		hour.setBounds(150, 0,150, 50);
		this.update();
		this.add(time) ;
		this.add(hour) ;
	}
	public void update(){
		this.time.setText(fmt1.format(date));
		this.hour.setText(fmt2.format(date));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			date = new Date() ;
			this.update();
			this.repaint();
		}
	}
}
