package 学生管理系统;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class tongji extends J10 implements ActionListener{

	private static final long serialVersionUID = 1L;
	JButton b1,b2,b3,b4;
	JTextField t1,t2;
	 tongji(int i){
		 if(i==1) {
			 setSize(300,200);
				setTitle("查询该门课程最高分");
				t1 = new JTextField(10);
				t2 = new JTextField(10);
				
				JLabel l1 = new JLabel("课程名称："); 
				JLabel l2 = new JLabel("最高分："); 
			
				setLayout(new GridLayout(3,1));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();

				p1.add(l1);p2.add(l2);
				p1.add(t1);p2.add(t2);
				add(p1);add(p2);
				
				b1 = new JButton("查找"); 
				b1.addActionListener(this);
				p3.add(b1); add(p3);
				setLocationRelativeTo(null);
				setResizable(false); 
				setVisible(true);
		 }else if(i==2) {
			 setSize(300,200);
				setTitle("查询该门课程最低分");
				t1 = new JTextField(10);
				t2 = new JTextField(10);
				
				JLabel l1 = new JLabel("课程名称："); 
				JLabel l2 = new JLabel("最低分："); 
			
				setLayout(new GridLayout(3,1));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();

				p1.add(l1);p2.add(l2);
				p1.add(t1);p2.add(t2);
				add(p1);add(p2);
				
				b2 = new JButton("查找"); 
				b2.addActionListener(this);
				p3.add(b2); add(p3);
				setLocationRelativeTo(null);
				setResizable(false); 
				setVisible(true);
		 }else if(i==3) {
			 setSize(300,200);
				setTitle("查询该门课程平均分");
				t1 = new JTextField(10);
				t2 = new JTextField(10);
				
				JLabel l1 = new JLabel("课程名称："); 
				JLabel l2 = new JLabel("平均分："); 
			
				setLayout(new GridLayout(3,1));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();

				p1.add(l1);p2.add(l2);
				p1.add(t1);p2.add(t2);
				add(p1);add(p2);
				
				b3 = new JButton("查找"); 
				b3.addActionListener(this);
				p3.add(b3); add(p3);
				setLocationRelativeTo(null);
				setResizable(false); 
				setVisible(true);
		 }else if(i==4) {
			 setSize(300,200);
				setTitle("查询该门课程及格率");
				t1 = new JTextField(10);
				t2 = new JTextField(10);
				
				JLabel l1 = new JLabel("课程名称："); 
				JLabel l2 = new JLabel("及格率："); 
			
				setLayout(new GridLayout(3,1));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();

				p1.add(l1);p2.add(l2);
				p1.add(t1);p2.add(t2);
				add(p1);add(p2);
				
				b4 = new JButton("查找"); 
				b4.addActionListener(this);
				p3.add(b4); add(p3);
				setLocationRelativeTo(null);
				setResizable(false); 
				setVisible(true);
		 }
		 
	 }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==b1) {
			String cname = this.t1.getText();
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql ="select g.grade max from class c join sc s on c.con="
						+ "s.con join grade g on s.sno=g.sno and s.con="
						+ "g.con where c.cname='"+cname+"' order by grade desc limit 1";
				JDB1.rs = x.executeQuery(sql);
				
				while(JDB1.rs.next()) {
					t2.setText(JDB1.rs.getString("max"));
				}
				
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b2) {
			String cname = this.t1.getText();
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql ="select g.grade min from class c join sc s on c.con="
						+ "s.con join grade g on s.sno=g.sno and s.con="
						+ "g.con where c.cname='"+cname+"' order by grade limit 1";
				JDB1.rs = x.executeQuery(sql);
				
				while(JDB1.rs.next()) {
					t2.setText(JDB1.rs.getString("min"));
				}
				
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b3) {
			String cname = this.t1.getText();
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql ="select AVG(g.grade) aver from class c join sc s on c.con="
						+ "s.con join grade g on s.sno="
						+ "g.sno and s.con=g.con where c.cname='"+cname+"'";
				JDB1.rs = x.executeQuery(sql);
				
				while(JDB1.rs.next()) {
					t2.setText(JDB1.rs.getString("aver"));
				}
				
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
			
		}else if(obj==b4) {
			
		}
		
	}

}
