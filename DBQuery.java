import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.regex.*;

class DBQuery{
	Connection conn = null;
	Statement stmt = null;
	Connection song_con = null;
	Connection search_con = null;
	Connection web = null;
	Connection conn1 = null;
    Connection con3=null;
	Statement stmt1 = null;
	Statement song_stmt = null;
	Statement search_stmt = null;
	Statement web_song = null;
	  private ResultSet rs3 = null; 
	  private ResultSet rs = null; 
	  private ResultSet search = null; 
	  private ResultSetMetaData md2=null;
	  private PreparedStatement pst = null; 

	  //drop every table
	  public static String drop_map="DROP TABLE location";
	  public static String drop_search="DROP TABLE search";
	  public static String drop_playlist="DROP TABLE playlist";
	  public static String drop_annotation="DROP TABLE annotation";
	  public static String drop_song_anno="DROP TABLE song_anno";
	  public static String drop_art_class="DROP TABLE art_class";
	  public static String drop_art_a="DROP TABLE art_a";
	  
	  public static String[]  emotion_list,emotion_cal,emotion_class,same_record,record,record_ch,same_record_ch,Latitude,Longitude,label,valence,arousal,song_id,same_song_id,song_title,song_title_ch,same_song_title,same_song_title_ch,song_artist,same_song_artist,song_artist_ch,same_song_artist_ch,song_album,same_song_album,song_album_ch,same_song_album_ch,record_album,same_record_album,record_album_ch,same_record_album_ch;

		
	  public static String list,u_id,u_name,s_artist;
	  public static int i,j,s,t,m=18+(335-18)/4;;
	  public static int exit=0;
	  public static boolean log;
	  //insert user information to table
	  private String insertdbuser = "insert into user(u_id,name,password,age,gender,favor_artist) " + 
	  "select ifNULL(max(u_id),0)+1,?,?,?,?,? FROM user";
	  //create user table
	  public static String user_table = "CREATE TABLE user (" + 
	    "   u_id     INTEGER " +
	    " , name     VARCHAR(255) " + 
	    "  , password   VARCHAR(255) " + 
	    "  , age   VARCHAR(255) " + 
	    "  , gender   VARCHAR(255) " + 
	    "  , favor_artist  VARCHAR(255))"; 
	  //create map table
	  public static String map_playlist = "CREATE TABLE location (" + 
	    "   u_id     VARCHAR(255) " + 
	    "  ,Song_id     VARCHAR(255) " + 
	    "  ,Song_artist   VARCHAR(255) " + 
	    "  ,Song_artist_ch   VARCHAR(255) " + 
	    "  ,Song_title   VARCHAR(255) " + 
	    "  ,Song_title_ch  VARCHAR(255))"; 
	  //create search table
	  public static String search_playlist = "CREATE TABLE search (" + 
	    "   Song_id     VARCHAR(255) " + 
	    "  ,Song_artist   VARCHAR(255) " + 
	    "  ,Song_artist_ch   VARCHAR(255) " + 
	    "  ,Song_title   VARCHAR(255) " + 
	    "  ,Song_title_ch  VARCHAR(255))";
	  //create playlist table
	  public static String playlist = "CREATE TABLE playlist (" + 
	  "   u_id     VARCHAR(255) " + 
	  "   ,Year     VARCHAR(255) " + 
	    "  ,Month   VARCHAR(255) " + 
	    "  ,Date   VARCHAR(255) " + 
	    "  ,Hour   VARCHAR(255) " + 
	    "  ,Minute   VARCHAR(255) " + 
	    "  ,Latitude   VARCHAR(255) " + 
	    "  ,Longitude   VARCHAR(255) " + 
	    "  ,label   VARCHAR(255) " + 
	    "  ,Song_id   VARCHAR(255) " + 
	    "  ,Song_artist   VARCHAR(255) " + 
	    "  ,Song_title   VARCHAR(255) " + 
	    "  ,Song_artist_ch   VARCHAR(255) " + 
	    "  ,Song_title_ch  VARCHAR(255))";
	  //create song score table
	  public static String annotation = "CREATE TABLE annotation (" + 
	    "   u_id     VARCHAR(255) " + 
	    "   ,Year     VARCHAR(255) " + 
	    "  ,Month   VARCHAR(255) " + 
	    "  ,Date   VARCHAR(255) " + 
	    "  ,Hour   VARCHAR(255) " + 
	    "  ,Minute   VARCHAR(255) " + 
	    "  ,Song_id   VARCHAR(255) " + 
	    "  ,Song_artist   VARCHAR(255) " + 
	    "  ,Song_title   VARCHAR(255) " + 
	    "  ,Song_artist_ch   VARCHAR(255) " + 
	    "  ,Song_title_ch   VARCHAR(255) " + 
	    "  ,emo1   VARCHAR(255) " + 
	    "  ,emo1_v   VARCHAR(255) " + 
	    "  ,emo1_a   VARCHAR(255) " + 
	    "  ,score1   VARCHAR(255) " + 
	    "  ,emo2   VARCHAR(255) " + 
	    "  ,emo2_v   VARCHAR(255) " + 
	    "  ,emo2_a   VARCHAR(255) " + 
	    "  ,score2   VARCHAR(255) " + 
	    "  ,emo3   VARCHAR(255) " + 
	    "  ,emo3_v   VARCHAR(255) " + 
	    "  ,emo3_a   VARCHAR(255) " + 
	    "  ,score3  VARCHAR(255))";
	  //create song emotion keyword table
	  public static String song_anno = "CREATE TABLE song_anno (" + 
	    "   u_id     VARCHAR(255) " + 
	    "   ,Year     VARCHAR(255) " + 
	    "  ,Month   VARCHAR(255) " + 
	    "  ,Date   VARCHAR(255) " + 
	    "  ,Hour   VARCHAR(255) " + 
	    "  ,Minute   VARCHAR(255) " + 
	    "  ,Song_id   VARCHAR(255) " + 
	    "  ,Song_artist   VARCHAR(255) " + 
	    "  ,Song_title   VARCHAR(255) " + 
	    "  ,Song_artist_ch   VARCHAR(255) " + 
	    "  ,Song_title_ch   VARCHAR(255) " + 
	    "  ,激勵   VARCHAR(255) " + 
	    "  ,熱鬧   VARCHAR(255) " + 
	    "  ,情緒化   VARCHAR(255) " + 
	    "  ,熱情   VARCHAR(255) " + 
	    "  ,刺激   VARCHAR(255) " + 
	    "  ,高興   VARCHAR(255) " + 
	    "  ,愉悅   VARCHAR(255) " + 
	    "  ,強烈   VARCHAR(255) " + 
	    "  ,渾厚   VARCHAR(255) " + 
	    "  ,積極   VARCHAR(255) " + 
	    "  ,浪漫   VARCHAR(255) " + 
	    "  ,深情  VARCHAR(255) " + 
	    "  ,敏感   VARCHAR(255) " + 
	    "  ,奇特   VARCHAR(255) " + 
	    "  ,生氣   VARCHAR(255) " + 
	    "  ,活潑   VARCHAR(255) " + 
	    "  ,嬉戲   VARCHAR(255) " + 
	    "  ,難過   VARCHAR(255) " + 
	    "  ,振作   VARCHAR(255) " + 
	    "  ,輕鬆   VARCHAR(255) " + 
	    "  ,舒適   VARCHAR(255) " + 
	    "  ,明亮   VARCHAR(255) " + 
	    "  ,悠閒   VARCHAR(255) " + 
	    "  ,溫柔   VARCHAR(255) " + 
	    "  ,圓潤   VARCHAR(255) " + 
	    "  ,慰藉   VARCHAR(255) " +
	    "  ,平靜   VARCHAR(255) " + 
	    "  ,感動  VARCHAR(255))"; 
	  //generation user personality  playlist
	  public static String art_class = "CREATE TABLE art_class (" + 
	    "   u_id     VARCHAR(255) " + 
	    "   ,Year     VARCHAR(255) " + 
	    "  ,Month   VARCHAR(255) " + 
	    "  ,Date   VARCHAR(255) " + 
	    "  ,Hour   VARCHAR(255) " + 
	    "  ,Minute   VARCHAR(255) " + 
	    "  ,Song_id   VARCHAR(255) " + 
	    "  ,Song_artist   VARCHAR(255) " + 
	    "  ,Song_title   VARCHAR(255) " + 
	    "  ,Song_artist_ch   VARCHAR(255) " + 
	    "  ,Song_title_ch   VARCHAR(255) " + 
	    "  ,Valence   VARCHAR(255) " + 
	    "  ,Arousal  VARCHAR(255))";
	  //generation Artist-Annotation-Similarity playlist
	  public static String art_a = "CREATE TABLE art_a (" + 
	    "   u_id     VARCHAR(255) " + 
	    "   ,Year     VARCHAR(255) " + 
	    "  ,Month   VARCHAR(255) " + 
	    "  ,Date   VARCHAR(255) " + 
	    "  ,Hour   VARCHAR(255) " + 
	    "  ,Minute   VARCHAR(255) " + 
	    "  ,Song_id   VARCHAR(255) " + 
	    "  ,Song_artist   VARCHAR(255) " + 
	    "  ,Song_title   VARCHAR(255) " + 
	    "  ,Song_artist_ch   VARCHAR(255) " + 
	    "  ,Song_title_ch   VARCHAR(255) " + 
	    "  ,Valence   VARCHAR(255) " + 
	    "  ,Arousal  VARCHAR(255))"; 
	 //connection database
	DBQuery(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/android?useUnicode=true&characterEncoding=Big5","root","740612");
			stmt = conn.createStatement();
			conn1 = DriverManager.getConnection("jdbc:mysql://localhost/android?useUnicode=true&characterEncoding=Big5","root","740612");
			stmt1 = conn1.createStatement();
			song_con=DriverManager.getConnection("jdbc:mysql://localhost/android?useUnicode=true&characterEncoding=Big5","root","740612");
			song_stmt= conn.createStatement();
			search_con=DriverManager.getConnection("jdbc:mysql://localhost/song_db?useUnicode=true&characterEncoding=Big5","root","740612");
			search_stmt= search_con.createStatement();
		}
		catch(ClassNotFoundException ce){
			System.out.println("Class NOT found!!");
		}
		catch(SQLException se){
			System.out.println("Connection ERROR");
		}
	}
	 //connection database
	DBQuery(String user){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection("jdbc:mysql://localhost/android?useUnicode=true&characterEncoding=Big5","root","740612");
			stmt1 = conn1.createStatement();

		}
		catch(ClassNotFoundException ce){
			System.out.println("Class NOT found!!");
		}
		catch(SQLException se){
			System.out.println("Connection ERROR");
		}
	}
	//drop every table
	public void dropTable() 
	  { 
	    try 
	    { 
	    	  stmt = conn.createStatement(); 
		      stmt.executeUpdate(drop_annotation); 
		      stmt.executeUpdate(drop_song_anno); 
		      stmt.executeUpdate(drop_art_class); 
		      stmt.executeUpdate(drop_art_a); 
		      stmt.executeUpdate(drop_playlist); 
		      stmt.executeUpdate(drop_map);
		      search_stmt.executeUpdate(drop_search); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	//create every table
	 public void createTable() 
	  { 
	    try 
	    { 
	    	  stmt = conn.createStatement();    
	 	     stmt.executeUpdate(playlist);
	 	      stmt.executeUpdate(annotation);
	 	      stmt.executeUpdate(map_playlist);
	 	      stmt.executeUpdate(song_anno);
	 	      stmt.executeUpdate(art_class);
	 	      stmt.executeUpdate(art_a);
	 	      stmt.executeUpdate(user_table);
	 	      stmt.executeUpdate(search_playlist);
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("CreateDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  }  
	 //query sql description
	void Query(String sql){
		if (stmt != null){
			try{
				stmt.execute(sql);
			}catch(SQLException se){
				System.out.println("SQL ERROR!!");
			}
		}
	}
	//query user 
		void Query_user(String sql2){
			if (stmt1 != null){
				try{
					stmt1.execute(sql2);
				}catch(SQLException se){
					System.out.println("SQL ERROR!!");
				}
			}
	}
		//insert user information to table include name,password,age,gender,favor_artist
		public void insertTableuser(String name,String password,String age,String gender,String favor_artist) 
		  { 
		    try 
		    { 
		      pst = conn1.prepareStatement(insertdbuser); 
		      
		      pst.setString(1,name); 
		      pst.setString(2,password); 
		      pst.setString(3,age);
		      pst.setString(4,gender);
		      pst.setString(5,favor_artist);
		      pst.executeUpdate(); 
		    } 
		    catch(SQLException e) 
		    { 
		      System.out.println("InsertDB Exception :" + e.toString()); 
		    } 
		    finally 
		    { 
		      Close(); 
		    } 
		  } 
		//user Authentication 
	public boolean Login(String name) 
	  { 
	    
		  try 
	    {  
			  stmt = conn.createStatement(); 
		      rs = stmt.executeQuery("select * from user WHERE name='"+name+"'"); 
	   
	      while(rs.next()) 
	      { 
	     
	    	  if(name.equals(rs.getString("name")))
	    		  u_id=String.valueOf(rs.getString("u_id"));
	    	      u_name=String.valueOf(rs.getString("name"));
	       log=true;
	      }
	     
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    {  

	      Close();
	      
	    } 
	  
	    return log;
	  }
	//generation user personality playlist file named playlist_user's name.xml
	public void histery(String u_id,String u_name) 
	  { 
		
		  try 
	    {  
			  stmt1 = conn1.createStatement(); 
		      rs = stmt.executeQuery("select DISTINCT * from playlist WHERE u_id='"+u_id+"'GROUP BY Song_id HAVING Count(Song_id)>=1 ORDER BY Date DESC"); 
		      j=0;
	    	  while(rs.next()) 
    { 
	    		  j++;
	  }
	    	  song_id=new String[j];
			  song_title=new String[j];
			  song_title_ch=new String[j];
		      record=new String[j];
		      record_ch=new String[j];
		      valence=new String[j];
		      arousal=new String[j];
	           i=0;
	     	  rs.first();
	     	 try{
	     	 song_id[0]=rs.getString("song_id");
			 song_title[0]=rs.getString("Song_title");
			 song_title_ch[0]=rs.getString("Song_title_ch");
			 record[0]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
			 record_ch[0]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
		      FileOutputStream se=new FileOutputStream("playlist_"+u_name+".xml");
				OutputStreamWriter out=new OutputStreamWriter(se,"UTF-8");
	
		      if(song_id[0]==""){
				out.close();
		     }
	     	 out.write("<?xml version=\"1.0\"?><xml_api_reply version=\"1\"><playlist module_id=\"0\" tab_id=\"0\" mobile_row=\"0\" mobile_zipped=\"1\" row=\"0\" section=\"0\" ><forecast_information><city data=\"beijing\"/><postal_code data=\"beijing\"/><latitude_e6 data=\"\"/><longitude_e6 data=\"\"/><forecast_date data=\"2009-07-23\"/><current_date_time data=\"2009-07-24 00:13:21 +0000\"/><unit_system data=\"US\"/></forecast_information><current_conditions><condition data=\"Thunderstorm\"/><temp_f data=\"70\"/><temp_c data=\"21\"/><humidity data=\"Humidity: 84%\"/><icon data=\"/ig/images/weather/thunderstorm.gif\"/><wind_condition data=\"Wind: SW at 3 mph\"/></current_conditions>");
	     	 out.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record[0]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[0]+"\"/></mp3_conditions>");
	      
	     	 i++;
	     	 list="";
	     	     	 while(rs.next()) 
	          {
	     		song_id[i]=rs.getString("song_id");
		    	song_title[i]=rs.getString("Song_title");
		    	song_title_ch[i]=rs.getString("Song_title_ch");
		   	 record[i]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
			 record_ch[i]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
		 	 out.write("<mp3_conditions><song_id data=\""+song_id[i]+"\"/><song_title  data=\""+record[i]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[i]+"\"/></mp3_conditions>");
		 		    		  i++;
		    		  
	    	  }
	     	out.write("</playlist></xml_api_reply>");
	     	out.close();
	     	}catch(IOException e){
				e.printStackTrace();
			}
	    }
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    {  

	      Close();
	      
	    } 
	  }
	//generation song coordinates playlist file named anno_map_user's name.xml
	public void anno_playlist(String u_id,String u_name) 
	  { 
	      
		  try 
	    {  
			  stmt1 = conn1.createStatement(); 
		      rs = stmt.executeQuery("select DISTINCT Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch,Valence,Arousal from art_class WHERE u_id='"+u_id+"' ORDER BY Date DESC"); 
		      j=0;
	    	  while(rs.next()) 
      { 
	    		  j++;
	  }
	    	  song_id=new String[j];
			  song_title=new String[j];
			  song_title_ch=new String[j];
		      record=new String[j];
		      record_ch=new String[j];
		      valence=new String[j];
		      arousal=new String[j];
	           i=0;
	     	  rs.first();
	     	 try{
	     	 song_id[0]=rs.getString("song_id");
			 song_title[0]=rs.getString("Song_title");
			 song_title_ch[0]=rs.getString("Song_title_ch");
			 record[0]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
			 record_ch[0]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
			 valence[0]=rs.getString("Valence");
		      arousal[0]=rs.getString("Arousal");
		      FileOutputStream se=new FileOutputStream("anno_map_"+u_name+".xml");
				OutputStreamWriter out=new OutputStreamWriter(se,"UTF-8");		 	
		      if(song_id[0]==""){
				out.close();
		     }
	     	 out.write("<?xml version=\"1.0\"?><xml_api_reply version=\"1\"><playlist module_id=\"0\" tab_id=\"0\" mobile_row=\"0\" mobile_zipped=\"1\" row=\"0\" section=\"0\" ><forecast_information><city data=\"beijing\"/><postal_code data=\"beijing\"/><latitude_e6 data=\"\"/><longitude_e6 data=\"\"/><forecast_date data=\"2009-07-23\"/><current_date_time data=\"2009-07-24 00:13:21 +0000\"/><unit_system data=\"US\"/></forecast_information><current_conditions><condition data=\"Thunderstorm\"/><temp_f data=\"70\"/><temp_c data=\"21\"/><humidity data=\"Humidity: 84%\"/><icon data=\"/ig/images/weather/thunderstorm.gif\"/><wind_condition data=\"Wind: SW at 3 mph\"/></current_conditions>");
		     	 out.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record[0]+"\"/><valence data=\""+valence[0]+"\"/><arousal data=\""+arousal[0]+"\"/><song_title_ch  data=\""+record_ch[0]+"\"/></mp3_conditions>");
	     
		     	 i++;
	     	 list="";
	     	     	 while(rs.next()) 
	          {
	     		song_id[i]=rs.getString("song_id");
		    	song_title[i]=rs.getString("Song_title");
		    	song_title_ch[i]=rs.getString("Song_title_ch");
		    	 valence[i]=rs.getString("Valence");
			      arousal[i]=rs.getString("Arousal");
		   	 record[i]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
			 record_ch[i]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
		   	 out.write("<mp3_conditions><song_id data=\""+song_id[i]+"\"/><song_title  data=\""+record[i]+"\"/><valence data=\""+valence[i]+"\"/><arousal data=\""+arousal[i]+"\"/><song_title_ch  data=\""+record_ch[i]+"\"/></mp3_conditions>");
		    		  i++;
		    		  
	    	  }
	     	out.write("</playlist></xml_api_reply>");
	     	out.close();
	     
	     		
	     	}catch(IOException e){
				e.printStackTrace();
			}
	    }
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    {  

	      Close();
	      
	    } 
	  }
	//generation user Artist-Annotation-similarity playlist file named anno_map_user's name.xml
	public void a_anno_playlist(String u_name) 
	  { 
	      
		  try 
	    {  
			  stmt1 = conn1.createStatement(); 
		      rs = stmt.executeQuery("select DISTINCT Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch,Valence,Arousal from art_a GROUP BY Song_id HAVING Count(Song_id)>=1"); 
		      j=0;
	    	  while(rs.next()) 
    { 
	    		  j++;
	  }
	    	  song_id=new String[j];
			  song_title=new String[j];
			  song_title_ch=new String[j];
		      record=new String[j];
		      record_ch=new String[j];
		      valence=new String[j];
		      arousal=new String[j];
	           i=0;
	     	  rs.first();
	     	 try{
	     	 song_id[0]=rs.getString("song_id");
			 song_title[0]=rs.getString("Song_title");
			 song_title_ch[0]=rs.getString("Song_title_ch");
			 record[0]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
			 record_ch[0]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
			 valence[0]=rs.getString("Valence");
		      arousal[0]=rs.getString("Arousal");
			// FileWriter out=new FileWriter("anno_map.xml");
		      FileOutputStream se=new FileOutputStream("anno_map_"+u_name+".xml");
				OutputStreamWriter out=new OutputStreamWriter(se,"UTF-8");		 	
		      if(song_id[0]==""){
				out.close();
		     }
	     	 out.write("<?xml version=\"1.0\"?><xml_api_reply version=\"1\"><playlist module_id=\"0\" tab_id=\"0\" mobile_row=\"0\" mobile_zipped=\"1\" row=\"0\" section=\"0\" ><forecast_information><city data=\"beijing\"/><postal_code data=\"beijing\"/><latitude_e6 data=\"\"/><longitude_e6 data=\"\"/><forecast_date data=\"2009-07-23\"/><current_date_time data=\"2009-07-24 00:13:21 +0000\"/><unit_system data=\"US\"/></forecast_information><current_conditions><condition data=\"Thunderstorm\"/><temp_f data=\"70\"/><temp_c data=\"21\"/><humidity data=\"Humidity: 84%\"/><icon data=\"/ig/images/weather/thunderstorm.gif\"/><wind_condition data=\"Wind: SW at 3 mph\"/></current_conditions>");
		     	 out.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record[0]+"\"/><valence data=\""+valence[0]+"\"/><arousal data=\""+arousal[0]+"\"/><song_title_ch  data=\""+record_ch[0]+"\"/></mp3_conditions>");
	     
		     	 i++;
	     	 list="";
	     	     	 while(rs.next()) 
	          {
	     		song_id[i]=rs.getString("song_id");
		    	song_title[i]=rs.getString("Song_title");
		    	song_title_ch[i]=rs.getString("Song_title_ch");
		    	 valence[i]=rs.getString("Valence");
			      arousal[i]=rs.getString("Arousal");
		   	 record[i]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
			 record_ch[i]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
		   	 out.write("<mp3_conditions><song_id data=\""+song_id[i]+"\"/><song_title  data=\""+record[i]+"\"/><valence data=\""+valence[i]+"\"/><arousal data=\""+arousal[i]+"\"/><song_title_ch  data=\""+record_ch[i]+"\"/></mp3_conditions>");
		    		  i++;
		    		  
	    	  }
	     	out.write("</playlist></xml_api_reply>");
	     	out.close();
	     	}catch(IOException e){
				e.printStackTrace();
			}
	    }
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    {  

	      Close();
	      
	    } 
	  }
	//there were insert song emotion score to song_anno table
	public void anno_() 
	  { 
		   int v_offset2=0;
		    int a_offset2=0;
		    int count=0;
		    int v_count=0;
		    int a_count=0;
		    int value2[];
		    String key[];
		    float cal,cal2;
		    float v_cal;
		    float a_cal;
		    int c=0;
		    int nColumns2;
		  try 
	    {  
			  stmt1 = conn1.createStatement(); 
			    rs3 = stmt.executeQuery("select DISTINCT *  from annotation ORDER BY Song_id DESC,u_id DESC"); 
			    while(rs3.next()) 
			    { 
			    
				  	 md2=rs3.getMetaData();
			  	   nColumns2=md2.getColumnCount();
			  		value2=new int[3];
			  		key=new String[3];
			  		value2[0]=rs3.getInt("score1");
			  		value2[1]=rs3.getInt("score2");
			  		value2[2]=rs3.getInt("score3");
			  		key[0]=rs3.getString("emo1");
			  		key[1]=rs3.getString("emo2");
			  		key[2]=rs3.getString("emo3");
			  		System.out.println(key[0]);
						   DBQuery db2 = new DBQuery();  	
			 	 db2.Query("INSERT INTO song_anno VALUES ('"+rs3.getInt("u_id")+"','"+rs3.getInt("Year")+"','"+rs3.getString("Month")+"','"+rs3.getString("Date")+"','"+rs3.getString("Hour")+"','"+rs3.getString("Minute")+"','"+rs3.getString("Song_id")+"','"+rs3.getString("Song_artist")+"','"+rs3.getString("Song_title")+"','"+rs3.getString("Song_artist_ch")+"','"+rs3.getString("Song_title_ch")+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"','"+"0"+"')");
			  		for(int i=0;i<3;i++){
				  		DBQuery db3 = new DBQuery();
			  	 db3.Query("UPDATE song_anno SET "+key[i]+" = '"+value2[i]+"' WHERE u_id='"+rs3.getInt("u_id")+"' AND Song_id='"+rs3.getInt("Song_id")+"'");
			    }
			   }
	    
	    }
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    {  

	      Close();
	      
	    } 
	  }
	//the function first will be search user annotation song if counter < 5 then add similarity song 
	public void art_(String u_id,String u_name) 
	  { 
		   int number=28;
		   double p=0.05;
		   int t[];

		   int x[],sum[];
		   int x_sum=0;
		   int r_sum=0;
		   double x_po=0;
		   double r=0;
		    int nColumns,nColumns2;
		    int value[];
		    int v_count=0;
		    int a_count=0;
		    int v_offset=0;
		    int a_offset=0;
		    int v_offset2=0;
		    int a_offset2=0;
		  float cal=0,cal2;
		  double v_cal=0;
		  double a_cal=0;
		  double v_sum=0;
		  double a_sum=0;
		   int song_id_first;
		   int song_id_last;
		   int c=0;
	
		  try 
	    {  
			  stmt1 = conn1.createStatement(); 
			    rs3 = stmt.executeQuery("select DISTINCT *  from song_anno WHERE u_id='"+u_id+"' GROUP BY Song_id HAVING Count(Song_id)>=1"); 
			    int[] valence=new int[]{160,238,230,230,251,259,232,198,198,224,251,251,219,195,123,123,134,82,160,238,232,207,213,219,213,224,224,181};
			    int[] arousal=new int[]{174,143,157,157,125,137,184,163,163,207,122,122,189,169,143,143,166,178,174,143,184,198,135,189,135,207,207,157};

			    md2=rs3.getMetaData();
			  	   nColumns2=md2.getColumnCount();
			  	 nColumns=md2.getColumnCount();
			 		t=new int[29];
			  	   for(int i=0;i<29;i++){
			  			t[0]=1;
			  		}
			  	   while(rs3.next()) 
			    { 
			  		   c++;
			    	x_po=0;
			    	x_sum=0;
			    	v_sum=0;
			    	a_sum=0;
			    	v_cal=0;
			    	a_cal=0;
			  		x=new int[29];
			  		value=new int[29];
			  			int k=0;
			  		for(int i=12;i<=nColumns2;i++){
		  				x[k]=rs3.getInt(md2.getColumnLabel(i));
		  				if(x[k]==5){
		    				value[i-12]=2;
		    			}else if(x[k]==4){
		    				value[i-12]=1;
		    			}else if(x[k]==2){
		    				value[i-12]=-1;
		    			}else if(x[k]==1){
		    				value[i-12]=-2;
		    			}else if(x[k]==3){
		    				value[i-12]=0;
		    			}
		  				
		  				x_sum+=x[k];
		  				x_po+=x[k]*t[k];
		  				t[k+1]=x[k];
		  			  System.out.print(x[k]+",");
		  			 v_sum+=value[i-12]*valence[i-12];
	    			 a_sum+=value[i-12]*arousal[i-12];
	    		
		  				k++;
		  		}
					r=x_po/x_sum;
					if(r<1&&r!=0){
					 v_cal=v_sum/x.length*r;
	    			 a_cal=a_sum/x.length*r;}
					else if(r>1&&r!=0){
						 v_cal=v_sum/x.length/r;
		    			 a_cal=a_sum/x.length/r;
					}else if(r==0){
						 v_cal=v_sum/x.length;
		    			 a_cal=a_sum/x.length;
					}
					v_cal=scaling_V_coordinate(r,v_cal);
					a_cal=scaling_A_coordinate(r,a_cal);
			  			System.out.println(x_po+"/"+x_sum+":"+r);
			  			   DBQuery db2 = new DBQuery();  	
						 	 db2.Query("INSERT INTO art_class VALUES ('"+rs3.getInt("u_id")+"','"+rs3.getInt("Year")+"','"+rs3.getString("Month")+"','"+rs3.getString("Date")+"','"+rs3.getString("Hour")+"','"+rs3.getString("Minute")+"','"+rs3.getString("Song_id")+"','"+rs3.getString("Song_artist")+"','"+rs3.getString("Song_title")+"','"+rs3.getString("Song_artist_ch")+"','"+rs3.getString("Song_title_ch")+"','"+(int)v_cal+"','"+(int)a_cal+"')");
                  if(c<5){
                	  DBQuery db = new DBQuery();  	
					 	 db.Query("INSERT INTO art_a VALUES ('"+rs3.getInt("u_id")+"','"+rs3.getInt("Year")+"','"+rs3.getString("Month")+"','"+rs3.getString("Date")+"','"+rs3.getString("Hour")+"','"+rs3.getString("Minute")+"','"+rs3.getString("Song_id")+"','"+rs3.getString("Song_artist")+"','"+rs3.getString("Song_title")+"','"+rs3.getString("Song_artist_ch")+"','"+rs3.getString("Song_title_ch")+"','"+(int)v_cal+"','"+(int)a_cal+"')");
					 	DBQuery a_ano = new DBQuery();
					 	a_ano.a_anno_playlist(u_name);
                  }else{
              	 	DBQuery u_ano = new DBQuery();
				 	u_ano.anno_playlist(u_id, u_name);
                  }
			    }
	  	
	    }
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    {  

	      Close();
	      
	    } 
	  }
	//the function run generation song coordinates Algorithm
	//the function will be counter song had been scored record then run algorithm 
	public void art_a(String artist) 
	  {  
		String a_t="";
		   int number=28;
		   double p=0.05;
		   int t[];
		   int x[],sum[];
		   int x_sum=0;
		   int r_sum=0;
		   double x_po=0;
		   double r=0;
		    int nColumns,nColumns2;
		    int value[];
		    int v_count=0;
		    int a_count=0;
		    int v_offset=0;
		    int a_offset=0;
		    int v_offset2=0;
		    int a_offset2=0;
		  float cal=0,cal2;
		  double v_cal=0;
		  double a_cal=0;
		  double v_sum=0;
		  double a_sum=0;
		   int song_id_first;
		   int song_id_last;
		   int c=0;
		  try 
	    {  
			  stmt1 = conn1.createStatement(); 
			    rs3 = stmt.executeQuery("select DISTINCT *  from song_anno WHERE Song_artist='"+artist+"'  OR Song_artist_ch='"+artist+"' OR Song_title='"+artist+"' OR Song_title_ch='"+artist+"' GROUP BY Song_id,u_id HAVING Count(Song_id)>=1 AND Count(u_id)>=1 ORDER BY Date DESC"); 
			    int[] valence=new int[]{160,238,230,230,251,259,232,198,198,224,251,251,219,195,123,123,134,82,160,238,232,207,213,219,213,224,224,181};
			    int[] arousal=new int[]{174,143,157,157,125,137,184,163,163,207,122,122,189,169,143,143,166,178,174,143,184,198,135,189,135,207,207,157};

			    md2=rs3.getMetaData();
			  	   nColumns2=md2.getColumnCount();
			  	 nColumns=md2.getColumnCount();
			 		t=new int[29];
			  	   for(int i=0;i<29;i++){
			  			t[0]=1;
			  		}
			  	   while(rs3.next()) 
			    { 
			  		   c++;
			    	x_po=0;
			    	x_sum=0;
			    	v_sum=0;
			    	a_sum=0;
			    	v_cal=0;
			    	a_cal=0;
			  		x=new int[29];
			  		value=new int[29];
			  			int k=0;
			  		for(int i=12;i<=nColumns2;i++){
		  				x[k]=rs3.getInt(md2.getColumnLabel(i));
		  				if(x[k]==5){
		    				value[i-12]=2;
		    			}else if(x[k]==4){
		    				value[i-12]=1;
		    			}else if(x[k]==2){
		    				value[i-12]=-1;
		    			}else if(x[k]==1){
		    				value[i-12]=-2;
      		    			}else if(x[k]==3){
		    				value[i-12]=0;
		    			}
		  				x_sum+=x[k];
		  				x_po+=x[k]*t[k];
		  				t[k+1]=x[k];
		  			  System.out.print(x[k]+",");
		  				
		  			 a_t+=String.valueOf(x[k])+"-";
		  			 v_sum+=value[i-12]*valence[i-12];
	    			 a_sum+=value[i-12]*arousal[i-12];
	    		
		  				k++;
		  		}
			  		System.out.println();
					r=x_po/x_sum;
					  System.out.print(x[k]+",");
					if(r<1&&r!=0){
					 v_cal=v_sum/x.length*r;
	    			 a_cal=a_sum/x.length*r;}
					else if(r>1&&r!=0){
						 v_cal=v_sum/x.length/r;
		    			 a_cal=a_sum/x.length/r;
					}else if(r==0){
						 v_cal=v_sum/x.length;
		    			 a_cal=a_sum/x.length;
					}
					v_cal=scaling_V_coordinate(r,v_cal);
					a_cal=scaling_A_coordinate(r,a_cal);
			  			System.out.println(x_po+"/"+x_sum+":"+r);
			  			   DBQuery db2 = new DBQuery();  	
						 	 db2.Query("INSERT INTO art_class VALUES ('"+rs3.getInt("u_id")+"','"+rs3.getInt("Year")+"','"+rs3.getString("Month")+"','"+rs3.getString("Date")+"','"+rs3.getString("Hour")+"','"+rs3.getString("Minute")+"','"+rs3.getString("Song_id")+"','"+rs3.getString("Song_artist")+"','"+rs3.getString("Song_title")+"','"+rs3.getString("Song_artist_ch")+"','"+rs3.getString("Song_title_ch")+"','"+(int)v_cal+"','"+(int)a_cal+"')");
						 DBQuery db3 = new DBQuery();  	
						db3.Query("INSERT INTO art_a VALUES ('"+rs3.getInt("u_id")+"','"+rs3.getInt("Year")+"','"+rs3.getString("Month")+"','"+rs3.getString("Date")+"','"+rs3.getString("Hour")+"','"+rs3.getString("Minute")+"','"+rs3.getString("Song_id")+"','"+rs3.getString("Song_artist")+"','"+rs3.getString("Song_title")+"','"+rs3.getString("Song_artist_ch")+"','"+rs3.getString("Song_title_ch")+"','"+(int)v_cal+"','"+(int)a_cal+"')");
					
						 	 
			    }
			  	 if(c<5){
    				  			 	art_a_simlar(a_t);
				  		}
	  	
	    }
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    {  

	      Close();
	      
	    } 
	  }
	//the function run Artist-Annotation-Similarity Algorithm
//the function run Artist-Annotation-similarity algorithm
	public void art_a_simlar(String anno) 
	  { 
		   int number=28;
		   double p=0.05;
		   int t[];
		   int x[],sum[];
		   int x_sum=0;
		   int r_sum=0;
		   double x_po=0;
		   double r=0;
		    int nColumns,nColumns2;
		    int value[];
		    int v_count=0;
		    int a_count=0;
		    int v_offset=0;
		    int a_offset=0;
		    int v_offset2=0;
		    int a_offset2=0;
		  float cal=0,cal2;
		  double v_cal=0;
		  double a_cal=0;
		  double v_sum=0;
		  double a_sum=0;
		   int song_id_first;
		   int song_id_last;
		 String[] at;
	     at=new String[29];
		 at=anno.split("-");
			System.out.print(anno+":length="+at.length+"\n");
		  	 try 
	    {  
			  stmt = conn1.createStatement(); 
			    rs = stmt.executeQuery("select DISTINCT *  from song_anno  GROUP BY Song_id HAVING Count(Song_id)>=1"); 
			    int[] valence=new int[]{160,238,230,230,251,259,232,198,198,224,251,251,219,195,123,123,134,82,160,238,232,207,213,219,213,224,224,181};
			    int[] arousal=new int[]{174,143,157,157,125,137,184,163,163,207,122,122,189,169,143,143,166,178,174,143,184,198,135,189,135,207,207,157};
			    md2=rs.getMetaData();
			 	   nColumns2=md2.getColumnCount();
			  	 t=new int[28];
			  	   for(int i=0;i<28;i++){
			  			t[i]=Integer.valueOf(at[i]);
			  			System.out.print(at[i]+",");
			  		   }
				  while(rs.next()) 
			    { 
			    	x_po=0;
			    	x_sum=0;
			    	v_sum=0;
			    	a_sum=0;
			    	v_cal=0;
			    	a_cal=0;
			  		x=new int[28];
			  		value=new int[28];
			  			int k=0;
			  		for(int i=13;i<=nColumns2;i++){
		  				x[k]=rs.getInt(md2.getColumnLabel(i));
		  			
		  				if(x[k]==5){
		    				value[i-12]=2;
		    			}else if(x[k]==4){
		    				value[i-12]=1;
		    			}else if(x[k]==2){
		    				value[i-12]=-1;
		    			}else if(x[k]==1){
		    				value[i-12]=-2;
		    			}else if(x[k]==3){
		    				value[i-12]=0;
		    			}
		 
		  				x_sum+=x[k];
		  				x_po+=x[k]*t[k];
		  			  System.out.print(x[k]+",");
		  			 v_sum+=value[i-12]*valence[i-12];
	    			 a_sum+=value[i-12]*arousal[i-12];
	    		
		  				k++;
		  		}
			  		System.out.println();
					r=x_po/x_sum;
					  System.out.print(x[k]+",");
					if(r<1&&r!=0){
					 v_cal=v_sum/x.length*r;
	    			 a_cal=a_sum/x.length*r;}
					else if(r>1&&r!=0){
						 v_cal=v_sum/x.length/r;
		    			 a_cal=a_sum/x.length/r;
					}else if(r==0){
						 v_cal=v_sum/x.length;
		    			 a_cal=a_sum/x.length;
					}
					v_cal=scaling_V_coordinate(r,v_cal);
					a_cal=scaling_A_coordinate(r,a_cal);
			  			System.out.println(x_po+"/"+x_sum+":"+r);
			  			if(r>1){
			  			   DBQuery db3 = new DBQuery();  	
						 	 db3.Query("INSERT INTO art_a VALUES ('"+rs.getInt("u_id")+"','"+rs.getInt("Year")+"','"+rs.getString("Month")+"','"+rs.getString("Date")+"','"+rs.getString("Hour")+"','"+rs.getString("Minute")+"','"+rs.getString("Song_id")+"','"+rs.getString("Song_artist")+"','"+rs.getString("Song_title")+"','"+rs.getString("Song_artist_ch")+"','"+rs.getString("Song_title_ch")+"','"+(int)v_cal+"','"+(int)a_cal+"')");
			  			}
			    }
	  	
	    }
	    catch(SQLException e) 
	   { 
	     System.out.println("DropDB Exception :" + e.toString()); 
	   } 
	    finally 
	    {  

	      Close();
	      
	  } 
	  }
	//scale valence coordinate value
//scaling Valence coordinate value
public double scaling_V_coordinate(double r,double v_coordinate){
		
		double v_interval=0;
		double v_score;
		double valence=0;
		v_score=v_coordinate+(317/4)*2;
		if(r>1){
		v_interval=r*(317/4)-v_score;
		}
		if(v_interval>=0){
			valence=v_score+v_interval;
		}else if(v_interval<0){
			valence=-(v_score+v_interval);
		}
		if(valence<0){
			valence=-valence;
		}
	      return valence;
			
	}
//scale Arousal coordinate value
//scaling Arousal coordinate value
public double scaling_A_coordinate(double r,double a_coordinate){
		
	double a_interval=0;
	double a_score;
	double arousal=0;
	a_score=a_coordinate+m*2;
	if(r>1){
	a_interval=r*m-a_score;}
	if(a_interval>=0){
		arousal=a_score+a_interval;
	}else if(a_interval<0){
		arousal=-(a_score+a_interval);
	}
	if(arousal<0){
		arousal=-arousal;
	}
	return arousal;
	}
//generation Map-Query playlist
//generation Map-Query playlist  file named location_user's name.xml
public void location(String u_id,String u_name,String Latitude,String Longitude) 
	  { 
	    try 
	    { 
	    	stmt1 = conn1.createStatement(); 
		     rs = stmt.executeQuery("select DISTINCT * from playlist WHERE u_id='"+u_id+"'AND Latitude='"+Latitude+"'AND Longitude='"+Longitude+"' GROUP BY Song_id HAVING Count(Song_id)>=1"); 
		     i=0;
		     j=0;
			  while(rs.next()) 
		 { 
				  j++;
		 }
			  song_id=new String[j];
			  song_artist=new String[j];
			  song_artist_ch=new String[j];
			  song_title=new String[j];
			  song_title_ch=new String[j];
			  record=new String[j];
			  record_ch=new String[j];
			 rs.first();
			 try{
			 song_id[0]=rs.getString("Song_id");
			 song_artist[0]=rs.getString("Song_artist");
			 song_artist_ch[0]=rs.getString("Song_artist_ch");
			 song_title[0]=rs.getString("Song_title");
			 song_title_ch[0]=rs.getString("Song_title_ch");
			 record[0]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
			 record_ch[0]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
			 FileOutputStream se=new FileOutputStream("location_"+u_name+".xml");
				OutputStreamWriter map=new OutputStreamWriter(se,"UTF-8");
			   
			 if(song_id[0]==""){
				map.close();
		     }
	        		 	 map.write("<?xml version=\"1.0\"?><xml_api_reply version=\"1\"><playlist module_id=\"0\" tab_id=\"0\" mobile_row=\"0\" mobile_zipped=\"1\" row=\"0\" section=\"0\" ><forecast_information><city data=\"beijing\"/><postal_code data=\"beijing\"/><latitude_e6 data=\"\"/><longitude_e6 data=\"\"/><forecast_date data=\"2009-07-23\"/><current_date_time data=\"2009-07-24 00:13:21 +0000\"/><unit_system data=\"US\"/></forecast_information><current_conditions><condition data=\"Thunderstorm\"/><temp_f data=\"70\"/><temp_c data=\"21\"/><humidity data=\"Humidity: 84%\"/><icon data=\"/ig/images/weather/thunderstorm.gif\"/><wind_condition data=\"Wind: SW at 3 mph\"/></current_conditions>");
	
			 i++;
			 while(rs.next()){
		     song_id[i]=rs.getString("Song_id");
		     song_artist[i]=rs.getString("Song_artist");
		     song_artist_ch[i]=rs.getString("Song_artist_ch");
		     song_title[i]=rs.getString("Song_title");
		     song_title_ch[i]=rs.getString("Song_title_ch");
		     record[i]=rs.getString("Song_artist")+"-"+rs.getString("Song_title");
		     record_ch[i]=rs.getString("Song_artist_ch")+"-"+rs.getString("Song_title_ch");
			 
		     i++;
 }
			
		     for(int k=0;k<i;k++){
		    	 for(int s=k+1;s<i;s++){
		    if(song_id[k].endsWith(song_id[s]))	 
		    {   same_song_id=new String[song_id.length-1];
		       same_song_artist=new String[song_artist.length-1];
		       same_song_artist_ch=new String[song_artist_ch.length-1];
		       same_song_title=new String[song_title.length-1];
		       same_song_title_ch=new String[song_title_ch.length-1];
   	       same_record=new String[record.length-1] ;
   	     same_record_ch=new String[record_ch.length-1] ;
		       same_song_id[k]=song_id[k];
		         same_song_artist[k]=song_artist[k];
		         same_song_artist_ch[k]=song_artist_ch[k];
		         same_song_title[k]=song_title[k];
		         same_song_title_ch[k]=song_title_ch[k];
		         same_record[k]=record[k];
		         same_record_ch[k]=record_ch[k];
		    	System.out.print("第"+k+"首歌曲和第"+s+"歌曲是相同的");		
		    	Query("INSERT INTO location (u_id,Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+u_id+"','"+same_song_id[k]+"','"+same_song_artist[k]+"','"+same_song_artist_ch[k]+"','"+same_song_title[k]+"','"+same_song_title_ch[k]+"')");	
		      	map.write("<mp3_conditions><song_id data=\""+same_song_id[k]+"\"/><song_title  data=\""+same_record[k]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+same_record_ch[k]+"\"/></mp3_conditions>");   	
		    k=s;
		    }else{
		    	if(k==0){
		 	       Query("INSERT INTO location (u_id,Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+u_id+"','"+song_id[k]+"','"+song_artist[k]+"','"+song_artist_ch[k]+"','"+song_title[k]+"','"+song_title_ch[k]+"')");   	
		  	  map.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record[0]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[0]+"\"/></mp3_conditions>");    	 
		    	}
		    	
			       if(k>0&&song_id[k].endsWith(song_id[k-1])){ break;}else{
		  Query("INSERT INTO location (u_id,Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+u_id+"','"+ song_id[s]+"','"+song_artist[s]+"','"+song_artist_ch[s]+"','"+song_title[s]+"','"+song_title_ch[s]+"')");   	
		  map.write("<mp3_conditions><song_id data=\""+song_id[s]+"\"/><song_title  data=\""+record[s]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[s]+"\"/></mp3_conditions>");    	 
			       }
		    }
		    break;
		    	 }
		    		if(k==0&&i==1){
				 	       Query("INSERT INTO location (u_id,Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+u_id+"','"+song_id[k]+"','"+song_artist[k]+"','"+song_artist_ch[k]+"','"+song_title[k]+"','"+song_title_ch[k]+"')");   	
				  	  map.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record[0]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[0]+"\"/></mp3_conditions>");    	 
		    		}
		     }
	    	 map.write("</playlist></xml_api_reply>");
		 	map.close();
		     }catch(IOException e){
	  				e.printStackTrace();
	  			} 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	private void Close() 
	  { 
	    try 
	    { 
	      if(rs!=null) 
	      { 
	        rs.close(); 
	        rs = null; 
	      } 
	      if(stmt!=null) 
	      { 
	        stmt.close(); 
	        stmt = null; 
	      } 
	      if(pst!=null) 
	      { 
	        pst.close(); 
	        pst = null; 
	      } 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("Close Exception :" + e.toString()); 
	    } 
	  } 
	//generation Search Artist-Song playlist 
	//generation Search Album-Song playlist
	public void search_artist(String artist) 
	  { 
	    try 
	    { 
	    	
	    	search_stmt = search_con.createStatement(); 
	    	search = search_stmt.executeQuery("select * from en_song WHERE Song_artist='"+artist+"' OR Song_artist_ch='"+artist+"' OR Song_title='"+artist+"' OR Song_title_ch='"+artist+"' OR Song_album='"+artist+"'"); 
		     i=0;
		     j=0;
			  while(search.next()) 
		 { 
				  j++;
		 }
			  song_id=new String[j];
			  song_artist=new String[j];
			  song_artist_ch=new String[j];
			  song_title=new String[j];
			  song_title_ch=new String[j];
			  record=new String[j];
			  record_ch=new String[j];
			  search.first();
			 try{
			 song_id[0]=search.getString("Song_id");
			 song_artist[0]=search.getString("Song_artist");
			 song_artist_ch[0]=search.getString("Song_artist_ch");
			 song_title[0]=search.getString("Song_title");
			 song_title_ch[0]=search.getString("Song_title_ch");
			 record[0]=search.getString("Song_artist")+"-"+search.getString("Song_title");
			 record_ch[0]=search.getString("Song_artist_ch")+"-"+search.getString("Song_title_ch");
			FileOutputStream se=new FileOutputStream("search_artist.xml");
			OutputStreamWriter sea=new OutputStreamWriter(se,"UTF-8");
	     	   if(song_id[0]==""){
				sea.close();
		     }
	     	 sea.write("<?xml version=\"1.0\"?><xml_api_reply version=\"1\"><playlist module_id=\"0\" tab_id=\"0\" mobile_row=\"0\" mobile_zipped=\"1\" row=\"0\" section=\"0\" ><forecast_information><city data=\"beijing\"/><postal_code data=\"beijing\"/><latitude_e6 data=\"\"/><longitude_e6 data=\"\"/><forecast_date data=\"2009-07-23\"/><current_date_time data=\"2009-07-24 00:13:21 +0000\"/><unit_system data=\"US\"/></forecast_information><current_conditions><condition data=\"Thunderstorm\"/><temp_f data=\"70\"/><temp_c data=\"21\"/><humidity data=\"Humidity: 84%\"/><icon data=\"/ig/images/weather/thunderstorm.gif\"/><wind_condition data=\"Wind: SW at 3 mph\"/></current_conditions>");
		    
			 i++;
			 while(search.next()){
		     song_id[i]=search.getString("Song_id");
		     song_artist[i]=search.getString("Song_artist");
		     song_artist_ch[i]=search.getString("Song_artist_ch");
		     song_title[i]=search.getString("Song_title");
		     song_title_ch[i]=search.getString("Song_title_ch");
		     record[i]=search.getString("Song_artist")+"-"+search.getString("Song_title");
		     record_ch[i]=search.getString("Song_artist_ch")+"-"+search.getString("Song_title_ch");
			   
		     i++;
}
			
		     for(int k=0;k<i;k++){
		    	 for(int s=k+1;s<i;s++){
		    if(song_id[k].endsWith(song_id[s]))	 
		    {   same_song_id=new String[song_id.length-1];
		       same_song_artist=new String[song_artist.length-1];
		       same_song_artist_ch=new String[song_artist_ch.length-1];
		       same_song_title=new String[song_title.length-1];
		       same_song_title_ch=new String[song_title_ch.length-1];
		       same_record=new String[record.length-1] ;
		       same_record_ch=new String[record_ch.length-1] ;
		       same_song_id[k]=song_id[k];
		         same_song_artist[k]=song_artist[k];
		         same_song_artist_ch[k]=song_artist_ch[k];
		         same_song_title[k]=song_title[k];
		         same_song_title_ch[k]=song_title_ch[k];
		         same_record[k]=record[k];
		         same_record_ch[k]=record_ch[k];
		    	System.out.print("第"+k+"首歌曲和第"+s+"首歌曲是相同的");		
		    	Query("INSERT INTO search (Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+same_song_id[k]+"','"+same_song_artist[k]+"','"+same_song_artist_ch[k]+"','"+same_song_title[k]+"','"+same_song_title_ch[k]+"')");	
		      	sea.write("<mp3_conditions><song_id data=\""+same_song_id[k]+"\"/><song_title  data=\""+same_record[k]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+same_record_ch[k]+"\"/></mp3_conditions>");   	
		    }else{
		    	if(k==0){
		 	       Query("INSERT INTO search (Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+ song_id[k]+"','"+song_artist[k]+"','"+song_artist_ch[k]+"','"+song_title[k]+"','"+song_title_ch[k]+"')");   	
		  	  sea.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record[0]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[0]+"\"/></mp3_conditions>");    	 
		    	}
		    	same_song_id=new String[song_id.length-1];
			       same_song_artist=new String[song_artist.length-1];
			       same_song_artist_ch=new String[song_artist_ch.length-1];
			       same_song_title=new String[song_title.length-1];
			       same_song_title_ch=new String[song_title_ch.length-1];
			       same_record=new String[record.length-1] ;
			       same_record_ch=new String[record_ch.length-1] ;
			       Query("INSERT INTO search (Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+ song_id[s]+"','"+song_artist[s]+"','"+song_artist_ch[s]+"','"+song_title[s]+"','"+song_title_ch[s]+"')");   	
		  sea.write("<mp3_conditions><song_id data=\""+song_id[s]+"\"/><song_title  data=\""+record[s]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[s]+"\"/></mp3_conditions>");    	 
		  
		    }
		    break;
		    	 }
		    	 if(k==0&&i==1){
			 	       Query("INSERT INTO search (Song_id,Song_artist,Song_artist_ch,Song_title,Song_title_ch) VALUES ('"+ song_id[k]+"','"+song_artist[k]+"','"+song_artist_ch[k]+"','"+song_title[k]+"','"+song_title_ch[k]+"')");   	
			  	  sea.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record[0]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_ch[0]+"\"/></mp3_conditions>");    	 
		    	 }
		     }
	    	 sea.write("</playlist></xml_api_reply>");
		 	sea.close();
		     }catch(IOException e){
	  				e.printStackTrace();
	  			} 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	//generation Search Artist-Album list
	//the were generation Search Artist-Album list
	public void search(String artist) 
	  { 
	    try 
	    { 
	    	artist=artist+"%";
	    	search_stmt = search_con.createStatement(); 
	    	search = search_stmt.executeQuery("select * from en_song WHERE Song_artist LIKE'"+artist+"' OR Song_artist_ch LIKE'"+artist+"' OR Song_title='"+artist+"' OR Song_title_ch='"+artist+"' OR Song_album LIKE'"+artist+"' GROUP BY Song_album HAVING Count(Song_album)>=1"); 
		     i=0;
		     j=0;
			  while(search.next()) 
		 { 
				  j++;
		 }
			  song_id=new String[j];
			  song_artist=new String[j];
			  song_artist_ch=new String[j];
			  song_title=new String[j];
			  song_title_ch=new String[j];
			  song_album=new String[j];
			  song_album_ch=new String[j];
			  record=new String[j];
			  record_ch=new String[j];
			  record_album=new String[j];
			  record_album_ch=new String[j];
			  
			  search.first();
			 try{
			 song_id[0]=search.getString("Song_id");
			 song_artist[0]=search.getString("Song_artist");
			 song_artist_ch[0]=search.getString("Song_artist_ch");
			 song_title[0]=search.getString("Song_title");
			 song_title_ch[0]=search.getString("Song_title_ch");
			 song_album[0]=search.getString("Song_album");
			 song_album_ch[0]=search.getString("Song_album_ch");
			 record_album[0]=search.getString("Song_artist")+"-"+search.getString("Song_album");
			 record_album_ch[0]=search.getString("Song_artist_ch")+"-"+search.getString("Song_album_ch");
			 record[0]=search.getString("Song_artist")+"-"+search.getString("Song_title");
			 record_ch[0]=search.getString("Song_artist_ch")+"-"+search.getString("Song_title_ch");
			 FileOutputStream album=new FileOutputStream("search_artist_album.xml");
			OutputStreamWriter s_album=new OutputStreamWriter(album,"UTF-8");

	     	   if(song_id[0]==""){
	     		  s_album.close();
		     }
	     	  s_album.write("<?xml version=\"1.0\"?><xml_api_reply version=\"1\"><playlist module_id=\"0\" tab_id=\"0\" mobile_row=\"0\" mobile_zipped=\"1\" row=\"0\" section=\"0\" ><forecast_information><city data=\"beijing\"/><postal_code data=\"beijing\"/><latitude_e6 data=\"\"/><longitude_e6 data=\"\"/><forecast_date data=\"2009-07-23\"/><current_date_time data=\"2009-07-24 00:13:21 +0000\"/><unit_system data=\"US\"/></forecast_information><current_conditions><condition data=\"Thunderstorm\"/><temp_f data=\"70\"/><temp_c data=\"21\"/><humidity data=\"Humidity: 84%\"/><icon data=\"/ig/images/weather/thunderstorm.gif\"/><wind_condition data=\"Wind: SW at 3 mph\"/></current_conditions>");
	
			 i++;
			 while(search.next()){
		     song_id[i]=search.getString("Song_id");
		     song_artist[i]=search.getString("Song_artist");
		     song_artist_ch[i]=search.getString("Song_artist_ch");
		     song_title[i]=search.getString("Song_title");
		     song_title_ch[i]=search.getString("Song_title_ch");
		     song_album[i]=search.getString("Song_album");
		     song_album_ch[i]=search.getString("Song_album_ch");
		     record_album[i]=search.getString("Song_artist")+"-"+search.getString("Song_album");
		     record_album_ch[i]=search.getString("Song_artist_ch")+"-"+search.getString("Song_album_ch");   
		     record[i]=search.getString("Song_artist")+"-"+search.getString("Song_title");
		     record_ch[i]=search.getString("Song_artist_ch")+"-"+search.getString("Song_title_ch");
			   
		     i++;
	    	
}
			
		     for(int k=0;k<i;k++){
		    	 for(int s=k+1;s<i;s++){
		    if(song_id[k].endsWith(song_id[s])&&song_album[k].endsWith(song_album[s]))	 
		    {   same_song_id=new String[song_id.length-1];
		       same_song_artist=new String[song_artist.length-1];
		       same_song_artist_ch=new String[song_artist_ch.length-1];
		       same_song_title=new String[song_title.length-1];
		       same_song_title_ch=new String[song_title_ch.length-1];
		       same_song_album=new String[song_album.length-1];
		       same_song_album_ch=new String[song_album_ch.length-1];
		 
		       same_record=new String[record.length-1] ;
		       same_record_ch=new String[record_ch.length-1] ;

		       same_record_album=new String[record_album.length-1] ;
		       same_record_album_ch=new String[record_album_ch.length-1] ;
		       same_song_id[k]=song_id[k];
		         same_song_artist[k]=song_artist[k];
		         same_song_artist_ch[k]=song_artist_ch[k];
		         same_song_title[k]=song_title[k];
		         same_song_title_ch[k]=song_title_ch[k];
		         same_song_album[k]=song_album[k];
		         same_song_album_ch[k]=song_album_ch[k];
		         same_record[k]=record[k];
		         same_record_ch[k]=record_ch[k];
		         same_record_album[k]=record_album[k];
		         same_record_album_ch[k]=record_album_ch[k];
		    	System.out.print("第"+k+"首歌曲和第"+s+"首歌曲是相同的");		
		   			  	s_album.write("<mp3_conditions><song_id data=\""+same_song_id[k]+"\"/><song_title  data=\""+same_record_album[k]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+same_record_album_ch[k]+"\"/></mp3_conditions>");   	
		    	
		    }else{
		    	if(k==0){
		    			  	  s_album.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record_album[0]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_album_ch[0]+"\"/></mp3_conditions>");    	 
				
		    	}
		    	same_song_id=new String[song_id.length-1];
			       same_song_artist=new String[song_artist.length-1];
			       same_song_artist_ch=new String[song_artist_ch.length-1];
			       same_song_title=new String[song_title.length-1];
			       same_song_title_ch=new String[song_title_ch.length-1];
			       same_record=new String[record.length-1] ;
			       same_record_ch=new String[record_ch.length-1] ;
			 		  s_album.write("<mp3_conditions><song_id data=\""+song_id[s]+"\"/><song_title  data=\""+record_album[s]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_album_ch[s]+"\"/></mp3_conditions>");    	 
			
		    }
		    break;
		    	 }
		    	 if(k==0&&i==1){
		    		  	  s_album.write("<mp3_conditions><song_id data=\""+song_id[0]+"\"/><song_title  data=\""+record_album[0]+"\"/><low data=\"71\"/><high data=\"93\"/><song_title_ch  data=\""+record_album_ch[0]+"\"/></mp3_conditions>");    	 
				    
		    	 }
		     }
	    	 	 s_album.write("</playlist></xml_api_reply>");
		 	s_album.close();
		     }catch(IOException e){
	  				e.printStackTrace();
	  			} 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 

	  
}