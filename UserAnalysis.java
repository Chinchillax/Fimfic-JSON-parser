//Written by Chinchillax
//Spreadsheet is here: https://docs.google.com/spreadsheets/d/11pxP7oJdMWTBwZWUYHXIIPa3iq518NyfzNrY2MRbEBY/edit?usp=drive_web
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



//Users have an ID, and a Username.
//Store User in an int ID, Map <int, User>, have that match to a User object, that we'll manipulate with each author

//Print out a CSV file of all users with:
//User total word count, total view count, total likes, total dislikes, 
//Complete count, incomplete, Hiatus, Cancelled stories
//Amount of comments
//Any other data
public class UserAnalysis //Requires User.java
{
	
	private static final String filePath = "index4.json";
	
	
	
	public static void main(String[] args) 
	{
		Map <Integer,User> userMap= new TreeMap<Integer,User>();
		try 
		{
			FileReader reader = new FileReader(filePath);
	
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			for(int i=0; i<250000; i++) //250000
			{
				String temp= String.valueOf(i);
				JSONObject obj= (JSONObject) jsonObject.get(temp);
				if(obj==null)
				{
					continue;
				}
								
				
				JSONObject authorInfo= (JSONObject) obj.get("author");
				String userID= (String) authorInfo.get("id");
				int userId= Integer.parseInt(userID);
				String username = (String) authorInfo.get("name");
				
				
				
				if(userMap.containsKey(userId)) //If the user HAS written a story before
				{
					User author= userMap.get(userId);
					
					long words =  (Long) obj.get("words");
					author.wordCount+= (int) words;
					author.storyCount++;
					
					
					long comments = (Long) obj.get("comments");
					author.commentCount+=comments;	
					
					long like = (Long) obj.get("likes");
					author.likeCount+=like;
					
					long dislike = (Long) obj.get("dislikes");
					author.dislikeCount+=dislike;
					
					long views = (Long) obj.get("views");
					author.viewCount+=views;
					
					long chapters = (Long) obj.get("chapter_count");
					author.chapterCount+=chapters;
					

					long contentRating =(Long) obj.get("content_rating");
					if(contentRating==0){author.ratedE++;}
					else if(contentRating==1){author.ratedT++;}
					else if(contentRating==2){author.ratedM++;}
					
					
					String status= (String) obj.get("status");
					if(status.equals("Incomplete")){author.incompleteStories++;}
					else if(status.equals("Complete")){author.completeStories++;}
					else if(status.equals("Cancelled")){author.cancelledStories++;}
					else{author.hiatusStories++;}
					
					JSONObject category= (JSONObject) obj.get("categories");
					
					boolean adventure= (Boolean) category.get("Adventure");
					if(adventure==true) author.adventureCount++;
					boolean au= (Boolean) category.get("Alternate Universe");
					if(au==true) author.aUCount++;
					boolean anthro= (Boolean) category.get("Anthro");
					if(anthro==true) author.anthroCount++;
					boolean comedy= (Boolean) category.get("Comedy");
					if(comedy==true) author.comedyCount++;
					boolean crossover= (Boolean) category.get("Crossover");
					if(crossover==true) author.crossoverCount++;
					boolean dark= (Boolean) category.get("Dark");
					if(dark==true) author.darkCount++;
					boolean human= (Boolean) category.get("Human");
					if(human==true) author.humanCount++;
					boolean random= (Boolean) category.get("Random");
					if(random==true) author.randomCount++;
					boolean romance= (Boolean) category.get("Romance");
					if(romance==true) author.romanceCount++;
					boolean sad= (Boolean) category.get("Sad");
					if(sad==true) author.sadCount++;
					boolean life= (Boolean) category.get("Slice of Life");
					if(life==true) author.lifeCount++;
					boolean tragedy= (Boolean) category.get("Tragedy");
					if(tragedy==true) author.tragedyCount++;				
				}
				else //If the user has not written a story before
				{
					User author = new User(userId,username); //Create the user
					long words =  (Long) obj.get("words");
					author.wordCount+= (int) words;
					author.storyCount++;
					
					long comments = (Long) obj.get("comments");
					author.commentCount+=comments;	
					
					long like = (Long) obj.get("likes");
					author.likeCount+=like;
					
					long dislike = (Long) obj.get("dislikes");
					author.dislikeCount+=dislike;
					
					long views = (Long) obj.get("views");
					author.viewCount+=views;
					
					long chapters = (Long) obj.get("chapter_count");
					author.chapterCount+=chapters;
					

					long contentRating =(Long) obj.get("content_rating");
					if(contentRating==0){author.ratedE++;}
					else if(contentRating==1){author.ratedT++;}
					else if(contentRating==2){author.ratedM++;}
					
					
					String status= (String) obj.get("status");
					if(status.equals("Incomplete")){author.incompleteStories++;}
					else if(status.equals("Complete")){author.completeStories++;}
					else if(status.equals("Cancelled")){author.cancelledStories++;}
					else{author.hiatusStories++;}
					
					JSONObject category= (JSONObject) obj.get("categories");
					
					boolean adventure= (Boolean) category.get("Adventure");
					if(adventure==true) author.adventureCount++;
					boolean au= (Boolean) category.get("Alternate Universe");
					if(au==true) author.aUCount++;
					boolean anthro= (Boolean) category.get("Anthro");
					if(anthro==true) author.anthroCount++;
					boolean comedy= (Boolean) category.get("Comedy");
					if(comedy==true) author.comedyCount++;
					boolean crossover= (Boolean) category.get("Crossover");
					if(crossover==true) author.crossoverCount++;
					boolean dark= (Boolean) category.get("Dark");
					if(dark==true) author.darkCount++;
					boolean human= (Boolean) category.get("Human");
					if(human==true) author.humanCount++;
					boolean random= (Boolean) category.get("Random");
					if(random==true) author.randomCount++;
					boolean romance= (Boolean) category.get("Romance");
					if(romance==true) author.romanceCount++;
					boolean sad= (Boolean) category.get("Sad");
					if(sad==true) author.sadCount++;
					boolean life= (Boolean) category.get("Slice of Life");
					if(life==true) author.lifeCount++;
					boolean tragedy= (Boolean) category.get("Tragedy");
					if(tragedy==true) author.tragedyCount++;
					
					userMap.put(userId, author); //Shove everything about the user into the map
				}
			}
				
			
		FileWriter writer = new FileWriter("AuthorData.csv");
		
		writer.append("Users Id, Username , Stories, Wordcount, Views, Comments, Likes, Dislikes,");
		writer.append("Chapters, Everyone Rated, Teen Rated, Mature Rated,Completed, Incompleted, On Hiatus, Cancelled,");
		writer.append("Adventure, Alternate Universe, Anthropromorphic, Comedy, Crossover, Dark,");
		writer.append("Human, Random, Romance, Sad, Slice of Life, Tragedy \n");
			
		for(Entry<Integer, User> entry : userMap.entrySet()) //Go through the map and print out the author
		{
			  User author = entry.getValue();
			  writer.append(author.toCSV());
		}
			
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
