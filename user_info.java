
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;


public class user_info extends JFrame 
{
		
	JTextField  	tf_UserName,UserName,Artist;
	JPasswordField tf_UserPassword,UserPassword;
	public static String gender,agevalue;
	String[] ageRange = new String[]{">40","30-40","25-30","20-25","15-20"};
	JComboBox	age;
	JRadioButton	M,F,First,Second,College,Graduate,yes,no;
	//design the ui form width and height
	public user_info() {
		
		
		setTitle("Register Your Basic Information");
		setSize(300,500);
		initUI();
		setVisible(true);
		
	}
	//initial all  component
	public void initUI() {
	
		setLayout(new BorderLayout());
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		
		JPanel basic = new JPanel();
		JPanel center = new JPanel();
		JPanel left = new JPanel();
		center.setLayout(new GridLayout(4,1,20,10));
		left.setLayout(new GridLayout(4,1,20,5));
		
		basic.setBorder(new TitledBorder("Basic Information"));
		basic.setLayout(new BorderLayout());
		basic.add(left,BorderLayout.WEST);
		basic.add(center,BorderLayout.CENTER);
		
		left.add(new JLabel("                User Name :"));
		UserName = new JTextField(Register.tf_UserName.getText());
		JPanel bgPane = new JPanel(new BorderLayout());
		bgPane.add(new JLabel("      "),BorderLayout.WEST);
		bgPane.add(new JLabel("      "),BorderLayout.EAST);
		bgPane.add(UserName,BorderLayout.CENTER);
		center.add(bgPane);
		
		left.add(new JLabel("                User Password :"));
		UserPassword = new JPasswordField(Register.tf_UserPassword.getText());
		JPanel bgPane2 = new JPanel(new BorderLayout());
		bgPane2.add(new JLabel("      "),BorderLayout.WEST);
		bgPane2.add(new JLabel("      "),BorderLayout.EAST);
		bgPane2.add(UserPassword,BorderLayout.CENTER);
		center.add(bgPane2);
		
		left.add(new JLabel("                Age :"));
		
		age = new JComboBox(ageRange);
		age.setSelectedIndex(3);
		bgPane = new JPanel(new BorderLayout());
		bgPane.add(new JLabel("      "),BorderLayout.WEST);
		bgPane.add(new JLabel("      "),BorderLayout.EAST);
		bgPane.add(age,BorderLayout.CENTER);
		center.add(bgPane);
		
		
		left.add(new JLabel("                Gender :"));
		F = new JRadioButton("Female",true);
		M = new JRadioButton("Male",false);
		ButtonGroup bgsex = new ButtonGroup();
		bgPane = new JPanel(new FlowLayout());
		bgsex.add(F); bgsex.add(M); 
		bgPane.add(F); bgPane.add(M); 
		center.add(bgPane);
		
		content.add(basic,BorderLayout.NORTH);
		
		JPanel music = new JPanel();
		center = new JPanel();
		left = new JPanel();
		center.setLayout(new GridLayout(5,1,20,5));
		left.setLayout(new GridLayout(5,1,20,5));
		music.setBorder(new TitledBorder("Now you want to listening?"));
		music.setLayout(new BorderLayout());
		music.add(left,BorderLayout.WEST);
		music.add(center,BorderLayout.CENTER);
		
		left.add(new JLabel("Please enter Artist or Song"));
		Artist = new JTextField("");
		JPanel bgPane3 = new JPanel(new BorderLayout());
		bgPane3.add(new JLabel(""),BorderLayout.WEST);
		bgPane3.add(new JLabel(""),BorderLayout.EAST);
		bgPane3.add(Artist,BorderLayout.CENTER);
		center.add(bgPane3);
		
	
		content.add(music,BorderLayout.CENTER);
		
		//  buttonPane
		JPanel buttonPane = new JPanel();
		JButton register = new JButton("Finish");
		//connect database and insert user information to table 
		register.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				agevalue=String.valueOf(ageRange[age.getSelectedIndex()]);
				if(F.isSelected()){
				gender=F.getText();}else if(M.isSelected()){
				gender=M.getText();
					
				}
			
				DBQuery register=new DBQuery();
				register.insertTableuser(UserName.getText(), UserPassword.getText(), agevalue, gender,Artist.getText());
				DBQuery d_art = new DBQuery();
				d_art.Query(d_art.drop_art_class);
				DBQuery art = new DBQuery();
				art.Query(art.art_class);
				DBQuery d_art_a = new DBQuery();
				d_art_a.Query(d_art_a.drop_art_a);
				DBQuery art_a = new DBQuery();
				art_a.Query(art_a.art_a);
				DBQuery d_ano = new DBQuery();
				d_ano.Query(d_ano.drop_song_anno);
				DBQuery c_ano = new DBQuery();
				c_ano.Query(c_ano.song_anno);
				DBQuery ano = new DBQuery();
				ano.anno_();
				//create Artist-similarity playlist
				DBQuery search=new DBQuery();
				search.art_a(Artist.getText());
				DBQuery p = new DBQuery();
				p.a_anno_playlist(UserName.getText());
				dispose();
			}});
		buttonPane.setLayout(new FlowLayout());
		buttonPane.add(register);
		
		add(content,BorderLayout.WEST);
		add(buttonPane,BorderLayout.SOUTH);
		
		
	}
	
	public static void main(String argv[]) {
		
		new user_info();
	}
	
}