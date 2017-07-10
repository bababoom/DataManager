package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class left_menu extends JPanel {
	private JFrame frame ;
	private JButton sale_show ;
	private JButton inout_show ;
	private JButton modify_password ;
	private JButton sale_stats ;
	private JButton exit_system ;
	public left_menu(){
		this.initial() ;
	}
	
	public JButton getSale_show(){
		return this.sale_show ;
	}
	public JButton getExit_system(){
		return this.exit_system ;
	}
	public JButton getModify_password(){
		return this.modify_password ;
	}
	public JButton getSale_stats(){
		return this.sale_stats ;
	}
	public JButton getInout_show(){
		return this.inout_show ;
	}
	public void initial(){
		sale_show = new JButton("首页") ;
		
		
		inout_show = new JButton("库存管理") ;
		modify_password = new JButton("修改密码") ;
		sale_stats = new JButton("销售统计") ;
		exit_system = new JButton("退出系统") ;
		this.setLayout(null);
		this.setBounds(0, 100, 200, 500);
		this.add(sale_show) ;
		this.add(sale_stats) ;
		this.add(exit_system) ;
		this.add(modify_password) ;
		this.add(inout_show) ;
		sale_show.setBounds(0, 0, 200, 50);
		inout_show.setBounds(0, 50, 200, 50);
		sale_stats.setBounds(0, 100, 200, 50);
		modify_password.setBounds(0, 150, 200, 50);
		exit_system.setBounds(0, 200, 200, 50);
		
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/
}
