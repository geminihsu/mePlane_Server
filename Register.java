import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Register extends JFrame implements ActionListener
{
	Container c;
	JPanel j0,j1,j2,j3;
	public static JTextField  	tf_UserName,tf_host,tf_port;
	public static JPasswordField tf_UserPassword;
	JLabel user,password,host,port;
	public static JComboBox jcb;
	JList li;
	JButton register,Server;
	public static String[] str,u_log,user_name;
	public static String no,vv,ta,search_a_song;
	private Socket sk;
	public static int count;
public static  boolean check;
//initial all  component
	public Register(){
		count=0;
		c=getContentPane();
		JLabel lab1=new JLabel("Please Register user information be profile");

		lab1.setBounds(120,5,300,20);
		setTitle("Start Service");
		user=new JLabel("User Name");
		tf_UserName=new JTextField("gemini");
		tf_UserName.setBounds(100,30,150,20);	
		user.setBounds(5,30,150,20);
		j0=new JPanel();
		j0.add(user);j0.add(tf_UserName);
		j0.setBounds(10,50,100,30);
		password=new JLabel("User Password");
		tf_UserPassword=new JPasswordField("612");
		password.setBounds(5,50,150,20);
		tf_UserPassword.setBounds(100,50,150,20);
		register=new JButton("User Register");
		register.setBounds(250,30,120,40);
		j1=new JPanel();
		j1.add(password);j1.add(tf_UserName);
		j1.setBounds(10,100,150,30);
		JLabel question=new JLabel("When you listen music What import to you:");
		question.setBounds(5,80,350,20);
		String[] option={"Emotion","MetaData","Usage"};
		jcb=new JComboBox(option);
		jcb.setBounds(250,80,150,20);
		str=new String[3];
		str[0]="Emotion and music Relation";
		str[1]="MetaData and music Relation";
		str[2]="Usage and music Relation";
		
        li=new JList(str);
		li.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		li.setSelectionBackground(Color.red);
		li.setSelectionForeground(Color.white);
		li.setSelectedIndex(1);
		li.setBounds(180, 120, 250, 100);
		j2=new JPanel();
		j2.add(question);j2.add(jcb);j2.add(li);
		j2.setBounds(10,100,150,30);
	    jcb.addActionListener(this);
		
		host=new JLabel("host IP:");
		host.setBounds(5,120,100,20);	
		tf_host=new JTextField("140.136.149.204");
		tf_host.setBounds(80,120,100,20);
		port=new JLabel("host port:");
		port.setBounds(5,150,100,20);	
		tf_port=new JTextField("14741");
		tf_port.setBounds(80,150,50,20);
		Server=new JButton("start Server");
		Server.setBounds(50,180,120,30);	
		
		c.setLayout(null);
		
		register.addActionListener(this);
		Server.addActionListener(this);

		c.add(lab1);
		c.add(user);
		c.add(host);
		c.add(port);
		c.add(tf_host);
		c.add(tf_UserName);
		c.add(tf_port);
		c.add(password);
		c.add(tf_UserPassword);
		c.add(jcb);
		c.add(register);
		c.add(Server);
		
		c.add(j0);
		c.add(j1);
		c.add(j2);
		c.add(question);
		c.add(li);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(!tf_UserName.getText().equals("")&&!tf_UserPassword.equals("")){
			if(e.getSource()==register){
				setTitle("Please fill up some information about:"+String.valueOf(jcb.getSelectedItem()));
				if(jcb.getSelectedItem().equals("Emotion")){
				  str[0]="This is some keyword about emotion";
				 user_info emo=new user_info();
				}else if(jcb.getSelectedItem().equals("MetaData")){
					str[1]="This is some id3 information about song";
				}else{
					str[2]="This is some state about listening habbit";
				}
				}
			//start service
		if(e.getSource()==Server){
		connection(14741);
		}
	//alert didn't fill up all information
		}else{
			JOptionPane.showConfirmDialog(jcb,"Please input your name and password","Login Message",JOptionPane.CLOSED_OPTION);
			
		}
		}
	//start server ip and port 
	public void connection(int po){
		po=Integer.valueOf(tf_port.getText().toString());
		try{
			ServerSocket ss = new ServerSocket(po);
		try{
			while (true){
				sk = ss.accept();
				new HandleRequest(sk).start();
			
		 
			}
		}catch(IOException e){
			sk.close();
			System.err.println(e);
		}
		}catch(IOException ie){
			System.err.println(ie);
		}
	}
  //wait for client request connection
	class HandleRequest extends Thread{
		Socket socket;
		HandleRequest(Socket ss){
			
			socket = ss;
			
		}
		public void run(){
			try{
				
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		str=new String[13];
		
		 ta=new String();
            vv=new String();

			
     		System.out.println(vv = br.readLine());
			
				str=vv.split("-");
				for(String ta:str){
					System.out.print(ta+" ");
				}
				DBQuery log = new DBQuery();
				DBQuery db_user = new DBQuery("user");
				DBQuery db_list = new DBQuery();
				if(str[0].equals(vv)){
				
					check=log.Login(str[0]);
					if(check==true){
						 count++;
						 u_log=new String[count];
							user_name=new String[count];
					
						u_log[count-1]=DBQuery.u_id;
				       user_name[count-1]=DBQuery.u_name;
				      
				       
						System.out.println(vv+" login success");
					
					str[0]="";
					
					}
						}
				//user Authentication
				else if(str[0].equals("1")){
							
							DBQuery u = new DBQuery();
							check=u.Login(str[1]);
							if(check==true){
								 count++;
								 u_log=new String[count];
									user_name=new String[count];
									u_log[count-1]=DBQuery.u_id;
								       user_name[count-1]=DBQuery.u_name;
								      

							
							
							db_list.Query("DELETE FROM playlist WHERE Song_id ='"+str[2]+"' AND u_id ='"+u_log[count-1]+"'");
							db_list.histery(u_log[count-1],user_name[count-1]);
							
							str[0]="";
							str[1]="";
							}
						}
				//generation Map-Query playlist
				else if(str[0].equals("2")){
							DBQuery u = new DBQuery();
							check=u.Login(str[1]);
							if(check==true){
								 count++;
								 u_log=new String[count];
									user_name=new String[count];
									u_log[count-1]=DBQuery.u_id;
								       user_name[count-1]=DBQuery.u_name;
								      

							
							DBQuery query = new DBQuery();
							query.Query(query.drop_map);
							query.Query(query.map_playlist);
							query.location(u_log[count-1],user_name[count-1],str[2],str[3]);
							str[0]="";
							str[1]="";
							str[2]="";
							str[3]="";
							}
							
						}
				//generation Artist-Annotation-Similarity playlist
				else if(str[0].equals("3")){
							DBQuery u = new DBQuery();
							check=u.Login(str[1]);
							if(check==true){
								 count++;
								 u_log=new String[count];
									user_name=new String[count];
									u_log[count-1]=DBQuery.u_id;
								       user_name[count-1]=DBQuery.u_name;
								      

						
							DBQuery d = new DBQuery();
							d.Query(d.drop_song_anno);
							DBQuery art_d = new DBQuery();
							art_d.Query(art_d.drop_art_class);
						
							log.Query_user("INSERT INTO annotation (u_id,Year,Month,Date,Hour,Minute,Song_id,Song_artist,Song_title,Song_artist_ch,Song_title_ch,emo1,emo1_v,emo1_a,score1,emo2,emo2_v,emo2_a,score2,emo3,emo3_v,emo3_a,score3) VALUES ('"+u_log[count-1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+str[7]+"','"+str[8]+"','"+str[9]+"','"+str[10]+"','"+str[11]+"','"+str[12]+"','"+str[13]+"','"+str[14]+"','"+str[15]+"','"+str[16]+"','"+str[17]+"','"+str[18]+"','"+str[19]+"','"+str[20]+"','"+str[21]+"','"+str[22]+"','"+str[23]+"')");		
							DBQuery db = new DBQuery();
							db.Query(db.song_anno);
							DBQuery art = new DBQuery();
							art.Query(art.art_class);
							DBQuery d1 = new DBQuery();
							d1.anno_();
							DBQuery d2 = new DBQuery();
							d2.art_(u_log[count-1],user_name[count-1]);
							str[0]="";
							str[1]="";
							str[2]="";
							str[3]="";
							str[4]="";
							str[5]="";
							str[6]="";
							str[7]="";
							str[8]="";
							str[9]="";
							str[10]="";
							str[11]="";
							str[12]="";
							str[13]="";
							str[14]="";
							str[15]="";
							str[16]="";
							str[17]="";
							str[18]="";
							str[19]="";
							str[20]="";
							str[21]="";
							str[22]="";
							str[23]="";
							}
						}
				//generation User Personality playlist
						else if(str[0].equals("4"))
						{
							DBQuery u = new DBQuery();
							check=u.Login(str[1]);
							if(check==true){
								 count++;
								 u_log=new String[count];
									user_name=new String[count];
									u_log[count-1]=DBQuery.u_id;
								       user_name[count-1]=DBQuery.u_name;
								      

								       DBQuery a = new DBQuery();	
							a.Query("INSERT INTO playlist (u_id,Year,Month,Date,Hour,Minute,Latitude,Longitude,label,Song_id,Song_artist,Song_title,Song_artist_ch,Song_title_ch) VALUES ('"+u_log[count-1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"','"+str[6]+"','"+str[7]+"','"+str[8]+"','"+str[9]+"','"+str[10]+"','"+str[11]+"','"+str[12]+"','"+str[13]+"','"+str[14]+"')");
							   DBQuery h = new DBQuery();	
							h.histery(u_log[count-1],user_name[count-1]);
										str[0]="";
										str[1]="";
										str[2]="";
										str[3]="";
										str[4]="";
										str[5]="";
										str[6]="";
										str[7]="";
										str[8]="";
										str[9]="";
										str[10]="";
										str[11]="";
										str[12]="";
										str[13]="";
										str[14]="";
							}
							
						}
				//delete song record from playlist 
						else if(str[0].equals("5"))
						{
							DBQuery u = new DBQuery();
							check=u.Login(str[1]);
							if(check==true){
								 count++;
								 u_log=new String[count];
									user_name=new String[count];
									u_log[count-1]=DBQuery.u_id;
								       user_name[count-1]=DBQuery.u_name;
							DBQuery d = new DBQuery();
							d.Query(d.drop_song_anno);
							DBQuery art_d = new DBQuery();
							art_d.Query(art_d.drop_art_class);
							DBQuery d_ano = new DBQuery();
							d_ano.Query("DELETE FROM annotation WHERE Song_id ='"+str[2]+"' AND u_id ='"+u_log[count-1]+"'");
							DBQuery db = new DBQuery();
							db.Query(db.song_anno);
							DBQuery art = new DBQuery();
							art.Query(art.art_class);
							DBQuery d1 = new DBQuery();
							d1.anno_();
							DBQuery d2 = new DBQuery();
							d2.art_(u_log[count-1],user_name[count-1]);
						
							str[0]="";
							}
							}
				//generation Artist-Album list
						else if(str[0].equals("6"))
							{
								DBQuery search = new DBQuery();
								search_a_song=DBQuery.s_artist;
								search.search(str[1]);
								str[0]="";
								str[1]="";
							}
					//user logout 
						else if(str[0].equals("7"))
							{
								
								str[0]="";
								str[1]="";
								u_log[count-1]="";
								user_name[count-1]="";
								count--;
							}
				//generation Artist-song playlist
						else if(str[0].equals("8"))
							{
								DBQuery search_song = new DBQuery();
							    search_song.Query(search_song.drop_search);
								search_song.Query(search_song.search_playlist);
								search_song.search_artist(str[2]);
								str[0]="";
								str[1]="";
								str[2]="";
								search_a_song="";
							}
			
				
			
                 socket.close();
			}catch (IOException ie){
				
				
			}
		}
		
	}
	//design the ui form width and height
	public static void main(String args[])
	{
		Register frm=new Register();
		frm.setSize(450,300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.show();
	}	
	
}