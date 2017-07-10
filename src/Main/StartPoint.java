package Main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import dao.Dao;

import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.Enumeration;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.plaf.FontUIResource;

public class StartPoint {
	
	//定义一系列的JPanel 和需要的变量
	private String p ;
	private static Dao dao = new Dao() ;
	private JFrame frame;
	private JTextField name_text;
	private JPasswordField passwordField;
	private JLabel login_info ;
	private JLabel lblNewLabel_1 ;
	private JLabel lblNewLabel ;
	private JButton login_button ;
	private JButton reset_button ;
	private JPanel login ;
	private JFrame mainFrame ;
	private left_menu left ; 
	private sale sale ;
	private Time time ;
	private Kc_manager kc_manager ;
	private Stats stats ;
	private person person ;
	private String name ;
	private Modify modify ;
	private JDialog exit ;
	private final JPanel contentPanel = new JPanel();
	private JButton exit_button ;
	private JButton cancel ;
	private JLabel sure_exit ;
	private JDialog modify_success ;
	private final success_modify success = new success_modify() ;
	private JDialog sale_tip ;
	private final sale_success sale_success = new sale_success() ;
	
	//判断一个字符串能否被转化为数字，用来对一些必须是数字的框进行检验
	public static boolean isNumber(String str)
	{
		return str.matches("[0-9]+") ;
	} 
	/**
	 * Launch the application.
	 */
	
	//设置字体
	private static void initGlobalFont(){
	    FontUIResource fontUIResource = new FontUIResource(new Font("宋体",Font.PLAIN, 15));
	    for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
	        Object key = keys.nextElement();
	        Object value= UIManager.get(key);
	        if (value instanceof FontUIResource) {
	            UIManager.put(key, fontUIResource);
	        }  
	    }
	}
	//主函数入口
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
			    {
					BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			        UIManager.put("RootPane.setupButtonVisible", false);
			        
			    }
			    catch(Exception e)
			    {
			        //TODO exception
			    }
				try {
					StartPoint window = new StartPoint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public StartPoint() {
		initGlobalFont() ;
		initialize();
	}
	/**
	 * judge the username and password
	 * @param username
	 * @param password
	 * @return
	 */
	private static boolean judge(String username,String password){
		
		ResultSet rs =  dao.executeQuery("select username,password from Login_info") ;
		
		try{
			while(rs.next()){
				
				if(rs.getString("username").trim().equals(username)&&rs.getString("password").trim().equals(password)){
					return true ;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false ;
		
	}
	/**
	 * 
	 */
	public void exit(){
		
		
		
		exit.setLayout(null);
		exit.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBounds(0, 0, 450, 300);
		
		exit_button = new JButton("确  定") ;
		exit_button.setBounds(80, 150, 80, 50);
		contentPanel.add(exit_button) ;
		
		cancel = new JButton("取  消") ;
		cancel.setBounds(290, 150, 80, 50);
		contentPanel.add(cancel) ;
		
		sure_exit = new JLabel("真 的 要 退 出 吗 ？") ;
		sure_exit.setBounds(145, 50, 200, 60);
		contentPanel.add(sure_exit) ;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		sale_tip = new JDialog(mainFrame,true) ;
		sale_tip.setLayout(null);
		sale_tip.setBounds(750, 350, 450, 300);
		sale_tip.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		sale_tip.setVisible(false);
		sale_tip.getContentPane().add(sale_success);
		
		modify_success = new JDialog(mainFrame,true) ;
		modify_success.setLayout(null);
		modify_success.setBounds(750, 350, 450, 300);
		modify_success.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		modify_success.setVisible(false);
		modify_success.getContentPane().add(success);
		
		
		exit = new JDialog(mainFrame,true) ;
		exit.setBounds(750, 350, 450, 300);
		exit.setTitle("退出系统");
		exit.setVisible(false);
		exit.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		exit() ;
		stats = new Stats(dao) ;
		kc_manager = new Kc_manager(dao) ;
		time = new Time() ;
		sale = new sale(dao) ;
		left = new left_menu() ;
		mainFrame = new JFrame() ;
		mainFrame.setLayout(null);
		mainFrame.setBounds(400, 150, 1100, 700);
		mainFrame.setTitle("库存管理系统V1.0");
		
		frame = new JFrame();
		frame.setTitle("登  录");
		frame.setBounds(550, 200, 800, 600);
		//frame.getContentPane().add(new left_menu()) ;
		JPanel temp = new JPanel() ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		name_text = new JTextField();
		name_text.setBounds(300, 200, 198, 44);
		name_text.setColumns(10);
		login = new JPanel() ;
		login.setLayout(null);
		login.setBounds(0, 0, 800, 600);
		temp.setLayout(null);
		temp.setBounds(0, 0, 800, 600);
		temp.add(name_text) ;
		frame.getContentPane().add(login);
		
		reset_button = new JButton("重  置");
		reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name_text.setText("");
				passwordField.setText("");
				login_info.setText("");
			}
		});
		reset_button.setBounds(300, 318, 77, 36);
		
		
		login_button = new JButton("登  陆");
		login_button.setBounds(421, 318, 77, 36);
		
		
		lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(250, 200, 68, 44);
		
		
		lblNewLabel_1 = new JLabel("密  码");
		lblNewLabel_1.setBounds(250, 264, 68, 44);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 264, 198, 44);
		

		login_info = new JLabel("");
		login_info.setBounds(238, 360, 317, 44);
		login.add(lblNewLabel) ;
		login.add(lblNewLabel_1);
		login.add(login_button) ;
		login.add(login_info) ;
		login.add(reset_button) ;
		login.add(passwordField) ;
		login.add(name_text) ;
		this.action() ;
		mainFrame.getContentPane().add(left) ;
		mainFrame.getContentPane().add(sale) ;
		mainFrame.getContentPane().add(time) ;

		
	}
	public void action(){
		left.getSale_show().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.remove(stats);
				mainFrame.remove(kc_manager);
				mainFrame.remove(modify);
				sale.setTemp(sale.getList().getSelectedItem().toString().trim());
				sale.update();
		
				mainFrame.getContentPane().add(sale) ;
				mainFrame.repaint();
			}
			
		});
		sale.getList().addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					
					String temp = sale.getList().getSelectedItem().toString() ;
					sale.setTemp(temp);
					sale.update();
					sale.repaint();
				}
			}
			
		});
		left.getInout_show().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.remove(stats) ;
				mainFrame.remove(sale);
				mainFrame.remove(modify);
				kc_manager.reupdate();
				mainFrame.getContentPane().add(kc_manager) ;
			
				mainFrame.repaint();
			}
			
		});
		left.getSale_stats().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stats.getList().addItemListener(new ItemListener(){

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange()==ItemEvent.SELECTED){
							
							p = stats.getList().getSelectedItem().toString() ;
							stats.update(p);
							
						}
					}
					
				});
				stats.list_update();
				stats.update(stats.getList().getSelectedItem().toString().trim());
				mainFrame.remove(kc_manager);
				mainFrame.remove(sale);
				mainFrame.remove(modify) ;
				mainFrame.getContentPane().add(stats);
				mainFrame.repaint();
			}
			
		});
		left.getModify_password().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.remove(sale) ;
				mainFrame.remove(kc_manager);
				mainFrame.remove(stats);
				mainFrame.getContentPane().add(modify) ;
				mainFrame.repaint();
			}
			
		});
		left.getExit_system().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit.setVisible(true);
			}
			
		});
		exit_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit.setVisible(false);
			}
			
		});
		
		login_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(judge(name_text.getText().trim(), String.valueOf(passwordField.getPassword()).trim())){
					name = name_text.getText().trim() ;
					person = new person(name) ;
					if(modify==null){
						modify = new Modify(name) ;
						
					}
					frame.setVisible(false);
					mainFrame.getContentPane().add(person);
					mainFrame.setVisible(true);
					modify.getSure().addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							String old_pass = String.valueOf(modify.getOld().getPassword()).trim() ;
							String new_pass = String.valueOf(modify.getNew().getPassword()).trim() ;
							String re_new = String.valueOf(modify.getSure_password().getPassword()).trim() ;
							if(!new_pass.equals("")){
								if(judge(modify.getName().trim(),old_pass)){
									if(new_pass.equals(re_new)){
										dao.executeQuery("update Login_info set password = "+"'"+re_new+"'"+"where username="+"'"+modify.getName().trim()+"'") ;
										modify_success.setVisible(true);
									}
									else{
										modify.getTip().setText("提示：两次密码输入不一致，请检查后重试！");
										modify.repaint();
									}
								}else{
									modify.getTip().setText("提示：旧密码输入错误，请重新输入！");
									modify.repaint();
								}
								
							}
						else{
							modify.getTip().setText("提示：新密码不能为空！");
							modify.repaint();
						}
						}
					});
					
					
				}else{
					login_info.setText("用户名或密码输入错误，请检查后重试");
				}
			}
			
		});
		sale.getSure().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = sale.getSale_num().getText().trim() ;
				if(isNumber(num)){
					int nums = Integer.valueOf(num) ;
					int x = Integer.valueOf(sale.getNum().getText().trim()) ;
					if(nums>x){
						sale.getTip().setText("购买失败！超出库存");
						sale.repaint();
					}else{
						int temp = x-nums ;
						Date date = new Date() ;
						String sql1 = "update Tb_kc set tb_nums="+String.valueOf(temp)+" where tb_title='"+
						sale.getList().getSelectedItem().toString().trim()+"'" ;
						dao.execute(sql1);
						java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("yyyy-MM-dd");  
						
						String sql = String.format("insert into Tb_Sale(id,tb_title,tb_nums,tb_value,tb_date) values(NULL,'"+
						sale.getList().getSelectedItem().toString().trim()+"',"+String.valueOf(nums)+","+
								String.valueOf(Float.valueOf(sale.getSingle_value().getText().trim())*(1.0)*nums)+",'"+
						fmt1.format(date)+"')") ;
						dao.execute(sql);
						sale.getTip().setText("");
						sale.repaint();
						sale_tip.setVisible(true);
						sale.setTemp(sale.getList().getSelectedItem().toString().trim());
						sale.update();
						sale.repaint();
					}
				}else{
					sale.getTip().setText("购买失败！请检查非法字符");
					sale.repaint();
				}
			}
			
		});
		sale_success.getBtnNewButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sale_tip.setVisible(false);
			}
			
		});
	}
}
