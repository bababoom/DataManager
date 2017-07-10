package Main;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import dao.Dao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * 
 * @author Administrator
 *
 */
public class sale extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6100066606026527217L;
	private JComboBox<String> list ;
	private JLabel num ;
	private JLabel info ;
	private JLabel single_value ;
	private JTextField sale_num ;
	private JButton sure_sale ;
	HashMap<String,String> map ;
	HashMap<String,Float> value_map ;
	HashMap<String,Integer> num_map ;
	Vector<String> v ;
	private String temp ;
	private JLabel select ;
	private JLabel mark ;
	private JLabel value ;
	private JLabel kc ;
	private JLabel sale ;
	private JLabel tip ;
	private ResultSet rs ;
	private Dao dao ;
	private Vector<String> tmp = new Vector<String>() ;
	private Vector<String> list_ele =new Vector<String>() ;
	private Vector<String> ss = new Vector<String>() ;
	
	public sale(Dao dao){
		this.dao = dao ;
		this.initial() ;
	}
	
	public void setTemp(String s){
		this.temp = s ;
	}
	public JComboBox getList(){
		return this.list ;
	}
	public JButton getSure(){
		return this.sure_sale ;
	}
	public JTextField getSale_num(){
		return this.sale_num ;
	}
	/**
	 * 
	 */
	
	public void update(){
		
		rs = dao.executeQuery("select *from Tb_kc") ;
		tmp.clear();
		map.clear();
		num_map.clear();
		value_map.clear();
		try{
			while(rs.next()){
				String title ,mark ;
				float value ;
				int nums ;
				if(rs.getString("tb_title").trim()!=null){
					title = rs.getString("tb_title").trim() ;
				}else title ="" ;
				if(rs.getString("tb_mark").trim()!=null){
					mark= rs.getString("tb_mark").trim() ;
				}else mark ="暂无介绍" ;
				value = rs.getFloat("tb_value") ;
				nums = rs.getInt("tb_nums") ;
				if(!v.contains(title)){
					tmp.addElement(title);
					v.addElement(title);
				}
				map.put(title, mark) ;
				value_map.put(title, value) ;
				num_map.put(title, nums) ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		for(String i:tmp){
			
			list.addItem(i);
		}
		if(!v.isEmpty()){
			this.info.setText(map.get(temp));
			this.single_value.setText(String.valueOf(value_map.get(temp)));
			this.num.setText(String.valueOf(num_map.get(temp)));
		}
	}
	public void initial(){
		this.setBounds(200, 0,900,600);
		this.setLayout(null);
		//初始化组件
		v = new Vector<String>() ;
		list = new JComboBox<String>() ;
		map = new HashMap<String,String>() ; 
		value_map = new HashMap<String,Float>() ;
		num_map = new HashMap<String,Integer>() ;
		num = new JLabel() ;
		info = new JLabel() ;
		single_value = new JLabel() ;
		sale_num = new JTextField() ;
		sure_sale = new JButton("确认购买") ;
		
		select = new JLabel("请选择商品 : ") ;
		select.setBounds(150, 100, 150, 50);
		add(select) ;
		
		mark = new JLabel("备   注 : ") ;
		mark.setBounds(150, 165, 150, 50);
		add(mark) ;
		
		setValue(new JLabel("单  价(￥) : ")) ;
		getValue().setBounds(150, 230, 150, 50);
		add(getValue()) ;
		
		setKc(new JLabel("库  存 : ")) ;
		getKc().setBounds(150, 295, 150, 50);
		add(getKc()) ;
		
		sale = new JLabel("请输入购买数量 : ") ;
		sale.setBounds(150, 360, 150, 50);
		add(sale) ;
		
		list.setBounds(300, 100, 200, 50);
		info.setBounds(300, 165, 200, 50);
		single_value.setBounds(300, 230, 200, 50);
		num.setBounds(300, 295, 200, 50);
		sale_num.setBounds(300, 360, 200, 50);
		sure_sale.setBounds(300, 425, 200, 50);
		update() ;
		
		/*
		info.setText(map.get(v.get(0)));
		single_value.setText(String.valueOf(value_map.get(v.get(0))));
		num.setText(String.valueOf(num_map.get(v.get(0))));
		*/
		tip = new JLabel("") ;
		tip.setBounds(530, 360, 200, 50);
		tip.setForeground(Color.RED);
		add(tip) ;
	
		if(!v.isEmpty()){
			this.info.setText(map.get(v.get(0)));
			this.single_value.setText(String.valueOf(value_map.get(v.get(0))));
			this.num.setText(String.valueOf(num_map.get(v.get(0))));
		}
		this.add(info) ;
		this.add(list) ;
		this.add(single_value) ;
		this.add(num) ;
		this.add(sure_sale) ;
		this.add(sale_num) ;
	}

	public JLabel getTip() {
		return tip;
	}

	public JLabel getKc() {
		return kc;
	}

	public void setKc(JLabel kc) {
		this.kc = kc;
	}

	public JLabel getValue() {
		return value;
	}

	public void setValue(JLabel value) {
		this.value = value;
	}

	public JLabel getNum() {
		return num;
	}

	public void setNum(JLabel num) {
		this.num = num;
	}

	public JLabel getSingle_value() {
		return single_value;
	}

	public void setSingle_value(JLabel single_value) {
		this.single_value = single_value;
	}

	
}
