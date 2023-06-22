package 学生管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

class J10 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	J10(){
		setTitle("管理员登录界面");
	}
}

class J11 extends J10{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField t1;
	JPasswordField pass;
	J11(){
		t1 = new JTextField(12);//文本框
		pass = new JPasswordField(12);//密码框
		JLabel l1 = new JLabel("账号："); JLabel l2 = new JLabel("密码："); //标签对象
		setLayout(new GridLayout(2,1)); //网格布局管理器
		JPanel p1 = new JPanel(); JPanel p2 = new JPanel();
		p1.add(l1); p2.add(l2);
		p1.add(t1); p2.add(pass);
		add(p1); add(p2);
		
	}
}

class J12 extends J11 implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1,b2;
	Object obj;
	J12(){
		setLayout(new GridLayout(3,1));
		JPanel p3 = new JPanel();
		b1 = new JButton("登录"); b2 = new JButton("注册");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p3.add(b1);p3.add(b2);add(p3);
		setSize(400,150);
		setLocationRelativeTo(null);
		setResizable(false); 
		setVisible(true);
		}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1){
			String name = this.t1.getText();
			@SuppressWarnings("deprecation")
			String passw = this.pass.getText();
			boolean t = false;
			try {
				JDB1.OpenConn();
				t = JDB1.login(name, passw);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(t == true) 
				{
				this.dispose();
					System.out.println("登录成功！");
					new J31().setVisible(true);
				}
			else {
				this.dispose();
				System.out.println("登录失败！");
				new J10().setTitle("登录失败！！！");
			}	
		}
		else if(obj==b2) {
			String id = this.t1.getText();
			@SuppressWarnings("deprecation")
			String password = this.pass.getText();
			try {
				JDB1.OpenConn();//连接数据库
				String sql = "insert into user(id,password) values('"+id+"','"+password+"')";
				Statement st=JDB1.conn.createStatement();
				st.executeUpdate(sql);
				st.close();
				JDB1.conn.close();
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			System.out.println("注册成功！");
			this.t1.setText("");
			this.pass.setText("");
		}
	}
}

class J31 extends J10 implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar mainMenu = new JMenuBar(); //创建菜单栏
	JMenu menuSystem = new JMenu("系统管理");
	JMenuItem itemOpen = new JMenuItem("打开");
	JMenuItem itemExit = new JMenuItem("退出");
	
	JMenu menuStu = new JMenu("学生管理");
	JMenuItem itemAdds = new JMenuItem("增加");
	JMenuItem itemEdits = new JMenuItem("修改");
	JMenuItem itemDeletes = new JMenuItem("删除");
	JMenuItem itemSearch = new JMenuItem("查询");
	
	JMenu menuclass= new JMenu("课程管理");
	JMenuItem itemAdds1 = new JMenuItem("增加");
	JMenuItem itemEdits1 = new JMenuItem("修改");
	JMenuItem itemDeletes1 = new JMenuItem("删除");
	JMenuItem itemSearch1 = new JMenuItem("查询");
	
	JMenu menusc= new JMenu("选课信息管理");
	JMenuItem itemAdds2 = new JMenuItem("增加");
	JMenuItem itemEdits2 = new JMenuItem("修改");
	JMenuItem itemDeletes2 = new JMenuItem("删除");
	JMenuItem itemSearch2 = new JMenuItem("查询");
	
	JMenu menugrade= new JMenu("成绩管理");
	JMenuItem itemAdds3 = new JMenuItem("增加");
	JMenuItem itemEdits3 = new JMenuItem("修改");
	JMenuItem itemDeletes3 = new JMenuItem("删除");
	JMenuItem itemSearch3 = new JMenuItem("查询");
	JMenuItem max = new JMenuItem("最高分");
	JMenuItem min = new JMenuItem("最低分");
	JMenuItem aver = new JMenuItem("平均分");
	JMenuItem pass = new JMenuItem("及格率");
	
	Font t = new Font("Dialog",0,12);
	
	J31(){
		itemAdds.addActionListener(this);
		itemEdits.addActionListener(this);
		itemDeletes.addActionListener(this);
		itemSearch.addActionListener(this);
		itemExit.addActionListener(this);

		itemAdds1.addActionListener(this);
		itemEdits1.addActionListener(this);
		itemDeletes1.addActionListener(this);
		itemSearch1.addActionListener(this);

		itemAdds2.addActionListener(this);
		itemEdits2.addActionListener(this);
		itemDeletes2.addActionListener(this);
		itemSearch2.addActionListener(this);
		
		itemAdds3.addActionListener(this);
		itemEdits3.addActionListener(this);
		itemDeletes3.addActionListener(this);
		itemSearch3.addActionListener(this);
		max.addActionListener(this);
		min.addActionListener(this);
		aver.addActionListener(this);
		pass.addActionListener(this);
		
		this.pack();
		setTitle("学生管理信息系统主界面"); setSize(600,500);
		menuSystem.setFont(t);
		menuSystem.add(itemOpen); 
		menuSystem.add(itemExit);
		
		menuStu.add(itemAdds); menuStu.add(itemEdits); menuStu.add(itemDeletes); menuStu.add(itemSearch);
		menuclass.add(itemAdds1);menuclass.add(itemEdits1);menuclass.add(itemDeletes1);menuclass.add(itemSearch1);
		menusc.add(itemAdds2);menusc.add(itemEdits2);menusc.add(itemDeletes2);menusc.add(itemSearch2);
		menugrade.add(itemAdds3);menugrade.add(itemEdits3);menugrade.add(itemDeletes3);menugrade.add(itemSearch3);
		menugrade.add(max);menugrade.add(min);menugrade.add(aver);menugrade.add(pass);
		
		mainMenu.add(menuSystem); mainMenu.add(menuStu); mainMenu.add(menuclass); mainMenu.add(menusc); mainMenu.add(menugrade); 
		this.setJMenuBar(mainMenu);
		setLocationRelativeTo(null);
		setResizable(false); 
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == itemAdds) {
			new add(0);
		}
		else if(obj==itemAdds1) {
			new add(1);
		}
		else if(obj==itemAdds2) {
			new add(2);
		}
		else if(obj==itemAdds3) {
			new add(3);
		}
		else if(obj == itemEdits) {
			new alter(0);
		}
		else if(obj == itemEdits1) {
			new alter(1);
		}
		else if(obj == itemEdits2) {
			new alter(2);
		}
		else if(obj == itemEdits3) {
			new alter(3);
		}
		else if(obj == itemDeletes) {
			new delete(0);
		}
		else if(obj == itemDeletes1) {
			new delete(1);
		}
		else if(obj == itemDeletes2) {
			new delete(2);
		}
		else if(obj == itemDeletes3) {
			new delete(3);
		}
		else if(obj == itemSearch) {
			new select(0);
		}
		else if(obj == itemSearch1) {
			new select(1);
		}
		else if(obj == itemSearch2) {
			new select(2);
		}
		else if(obj == itemSearch3) {
			new select(3);
		}
		else if(obj==max) {
			new tongji(1);
		}else if(obj==min) {
			new tongji(2);
		}else if(obj==aver) {
			new tongji(3);
		}else if(obj==pass) {
			new tongji(4);
		}
		else if(obj == itemExit) {
			this.dispose();
		}
	}
}

public class test11{
	public static void main(String []args) {
		new J12();
	}
}
