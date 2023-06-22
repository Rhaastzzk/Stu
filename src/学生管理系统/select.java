package 学生管理系统;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class select extends J10 implements ActionListener{ //查询
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b0,b1,b2,b3;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	select(int i){
		if(i==0) {
			setSize(600,300);
			setTitle("查看学生信息");
			t1 = new JTextField(10);
			t2 = new JTextField(10);
			t3 = new JTextField(10);
			t4 = new JTextField(10);
			t5 = new JTextField(10);
			t6 = new JTextField(10);
			t7 = new JTextField(10);
			t8 = new JTextField(10);
			t9 = new JTextField(10);
			
			JLabel l1 = new JLabel("姓名："); 
			JLabel l2 = new JLabel("学号："); 
			JLabel l3 = new JLabel("性别："); 
			JLabel l4 = new JLabel("民族："); 
			JLabel l5 = new JLabel("学院："); 
			JLabel l6 = new JLabel("专业："); 
			JLabel l7 = new JLabel("籍贯："); 
			JLabel l8 = new JLabel("出生日期："); 
			JLabel l9 = new JLabel("入学日期："); 
			
			setLayout(new GridLayout(5,2));
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			JPanel p5 = new JPanel();
			JPanel p6 = new JPanel();
			JPanel p7 = new JPanel();
			JPanel p8 = new JPanel();
			JPanel p9 = new JPanel();
			
			p1.add(l1);p2.add(l2);p3.add(l3);p4.add(l4);p5.add(l5);p6.add(l6);p7.add(l7);p8.add(l8);p9.add(l9);
			p1.add(t1);p2.add(t2);p3.add(t3);p4.add(t4);p5.add(t5);p6.add(t6);p7.add(t7);p8.add(t8);p9.add(t9);
			add(p1);add(p2);add(p3);add(p4);add(p5);add(p6);add(p7);add(p8);add(p9);
			
			JPanel p10 = new JPanel();
			b0 = new JButton("查找"); 
			b0.addActionListener(this);
			p10.add(b0); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}else if(i==1) {
			setSize(600,300);
			setTitle("查询课程信息");
			t1 = new JTextField(10);
			t2 = new JTextField(10);
			t3 = new JTextField(10);
			
			JLabel l1 = new JLabel("课程号："); 
			JLabel l2 = new JLabel("课程名称："); 
			JLabel l3 = new JLabel("课时："); 
		
			setLayout(new GridLayout(3,1));
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();

			
			p1.add(l1);p2.add(l2);p3.add(l3);
			p1.add(t1);p2.add(t2);p3.add(t3);
			add(p1);add(p2);add(p3);
			
			JPanel p10 = new JPanel();
			b1 = new JButton("查找"); 
			b1.addActionListener(this);
			p10.add(b1); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}else if(i==2) {
			setSize(600,300);
			setTitle("查询选课信息");
			t1 = new JTextField(10);
			t2 = new JTextField(10);
			t3 = new JTextField(10);
			
			JLabel l1 = new JLabel("学生学号："); 
			JLabel l2 = new JLabel("课程号："); 
			JLabel l3 = new JLabel("选课时间："); 
		
			setLayout(new GridLayout(3,1));
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();

			
			p1.add(l1);p2.add(l2);p3.add(l3);
			p1.add(t1);p2.add(t2);p3.add(t3);
			add(p1);add(p2);add(p3);
			
			JPanel p10 = new JPanel();
			b2 = new JButton("查找"); 
			b2.addActionListener(this);
			p10.add(b2); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}else if(i==3) {
			setSize(600,300);
			setTitle("查询成绩信息");
			t1 = new JTextField(10);
			t2 = new JTextField(10);
			t3 = new JTextField(10);
			
			JLabel l1 = new JLabel("学生学号："); 
			JLabel l2 = new JLabel("课程号："); 
			JLabel l3 = new JLabel("成绩得分："); 
		
			setLayout(new GridLayout(3,1));
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();

			
			p1.add(l1);p2.add(l2);p3.add(l3);
			p1.add(t1);p2.add(t2);p3.add(t3);
			add(p1);add(p2);add(p3);
			
			JPanel p10 = new JPanel();
			b3 = new JButton("查找"); 
			b3.addActionListener(this);
			p10.add(b3); add(p10);
			setLocationRelativeTo(null);
			setResizable(false); 
			setVisible(true);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b0) {
			String num = this.t2.getText();
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from student where snum="+num;
				JDB1.rs = x.executeQuery(sql);
				while(JDB1.rs.next()) {
					t1.setText(JDB1.rs.getString("sname"));
					t2.setText(JDB1.rs.getString("snum"));
					t3.setText(JDB1.rs.getString("ssex"));
					t4.setText(JDB1.rs.getString("sethnic"));
					t5.setText(JDB1.rs.getString("scollege"));
					t6.setText(JDB1.rs.getString("smajor"));
					t7.setText(JDB1.rs.getString("shome"));
					t8.setText(JDB1.rs.getString("sbirth"));
					t9.setText(JDB1.rs.getString("syear"));
				}
				
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b1) {
			String con = this.t1.getText();
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from class where con="+con;
				JDB1.rs = x.executeQuery(sql);
				while(JDB1.rs.next()) {
					t1.setText(JDB1.rs.getString("con"));
					t2.setText(JDB1.rs.getString("cname"));
					t3.setText(JDB1.rs.getString("ctime"));
				}
				
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b2) {
			String sno = this.t1.getText();
			String con = this.t2.getText();
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from sc where sno='"+sno+"' and con='"+con+"'";
				JDB1.rs = x.executeQuery(sql);
				while(JDB1.rs.next()) {
					t1.setText(JDB1.rs.getString("sno"));
					t2.setText(JDB1.rs.getString("con"));
					t3.setText(JDB1.rs.getString("time"));
				}
				
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}else if(obj==b3) {
			String sno = this.t1.getText();
			String con = this.t2.getText();
			JDB1 x = new JDB1();
			try {
				JDB1.OpenConn();
				String sql = "select * from grade where sno='"+sno+"' and con='"+con+"'";
				JDB1.rs = x.executeQuery(sql);
				while(JDB1.rs.next()) {
					t1.setText(JDB1.rs.getString("sno"));
					t2.setText(JDB1.rs.getString("con"));
					t3.setText(String.valueOf(JDB1.rs.getDouble("grade")));
				}
				
			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}
	}
	
}
