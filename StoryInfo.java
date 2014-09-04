//Written by Chinchillax
//https://docs.google.com/spreadsheets/d/1RMpWN3ErWIWH9htRsGBfqo_Zikqjypeg1MsD1065OVY/edit?usp=drive_web

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class StoryInfo //This prints out one column of a .csv at a time, then a user has to combine them together
{
	//public final static int STORYCOUNT=47167;
	//public final static int STORYCOUNT=60613;
	//public final static int STORYCOUNT=70420;
	//public final static int STORYCOUNT=79236;
	public final static int STORYCOUNT=87519; //If the amount of stories changes, change this
	
	
	//private static final String filePath = "index-20130616.json";
	//private static final String filePath = "index-20131015.json";
	//private static final String filePath = "index-20140120.json";
	//private static final String filePath = "index-20140418.json";
	private static final String filePath = "index-20140719.json";
	
	public static void main(String[] args) 
	{
		FileWriter writer;
		FileWriter allStories;
		try 
		{
			FileReader reader = new FileReader(filePath);
			writer = new FileWriter("StoryInfo.csv");
			
			allStories= new FileWriter("AllStories.txt");
	
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			writer.append("Title, Author, Wordcount, Views, Likes, Dislikes, Comments, Rated,Status"+'\n');
			
			int storycount=0;
			for(int i=0; i<250000; i++) //Highest current ID
			{
				String temp= String.valueOf(i);
				JSONObject obj= (JSONObject) jsonObject.get(temp);
				if(obj==null)
				{
					continue;
				}
				storycount++;
				//String title= (String) obj.get("title");
				long contentRating =(Long) obj.get("content_rating");
				String title= (String) obj.get("title");
				
				allStories.append(title+" ~ ");
				JSONObject authorInfo= (JSONObject) obj.get("author");
				String username = (String) authorInfo.get("name");
				
				if(title==null)
				{
					writer.append(',');
					
				}
				else
				{
					if(title.contains(","))
					{
						title=title.replace(",", "");
					}
					writer.append(title+',');
				}
				
				if(username.contains(","))
				{
					username=username.replace(",", "");
				}
				writer.append(username+',');

				
				
				long words =  (Long) obj.get("words");

				
				writer.append(Long.toString(words)+',');
				
				

				long views =  (Long) obj.get("views");
				writer.append(Long.toString(views)+',');
				
				long like =  (Long) obj.get("likes");
				writer.append(Long.toString(like)+',');
				
				long dislike =  (Long) obj.get("dislikes");
				writer.append(Long.toString(dislike)+',');

				long comments =  (Long) obj.get("comments");
				writer.append(Long.toString(comments)+',');

				
				if(contentRating==0)
				{
					writer.append("Everyone"+',');
				}
				else if(contentRating==1)
				{
					writer.append("Teen"+',');
				}
				else if(contentRating==2)
				{
					writer.append("Mature"+',');
				}
				
				String status= (String) obj.get("status");
				if(status.equals("Incomplete"))
				{
					writer.append("Incomplete");
				}
				else if(status.equals("Complete"))
				{
					writer.append("Complete");
				}
				else if(status.equals("Cancelled"))
				{
					writer.append("Cancelled");
				}
				else
				{
					writer.append("Hiatus");
				}
				writer.append('\n');
				System.out.println("Printed Story: "+storycount);
			}
			
			allStories.flush();
			allStories.close();
			
			writer.flush();
			writer.close();
			
		} 
		catch (FileNotFoundException ex) 
		{
			ex.printStackTrace();
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		} 
		catch (ParseException ex) 
		{
			ex.printStackTrace();
		} 
		catch (NullPointerException ex) 
		{
			ex.printStackTrace();
		}

	}
}

