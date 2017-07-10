package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Exit extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton exit ;
	private JButton cancel ;
	private JLabel sure_exit ;
	
	public JButton getExit(){
		return this.exit ;
	}
	public JButton getCancel(){
		return this.cancel ;
	}

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			Exit dialog = new Exit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public Exit() {
		setBounds(750, 350, 450, 300);
		
		initial() ;
	}
	public void initial(){
		this.setLayout(null);
		this.getContentPane().add(contentPanel) ;
		contentPanel.setLayout(null);
		contentPanel.setBounds(0, 0, 450, 300);
		
		exit = new JButton("确  定") ;
		exit.setBounds(80, 150, 80, 50);
		contentPanel.add(exit) ;
		
		cancel = new JButton("取  消") ;
		cancel.setBounds(290, 150, 80, 50);
		contentPanel.add(cancel) ;
		
		sure_exit = new JLabel("真 的 要 退 出 吗 ？") ;
		sure_exit.setBounds(145, 50, 200, 60);
		contentPanel.add(sure_exit) ;
		
	}
	
	
}
