//Written by Chinchillax
//Spreadsheet is here: https://docs.google.com/spreadsheets/d/1Wsj45jwHofcWpow4hXgJa3-BSOQcD1FnKSEcWREKgXA/edit#gid=0

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TotalWordCount //This does not print out a CSV.
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
	
	public static long allWordCount=0;
	public static long storyCount=0;
	public static long storiesBelow5k=0;
	public static long storiesAbove5k=0;
	public static long storiesAbove100k=0;
	public static long ratedE=0;
	public static long ratedT=0;
	public static long ratedM=0;
	
	public static int[] wordCountArray= new int[STORYCOUNT];
	public static int[] storyLikes= new int[STORYCOUNT];
	public static int likeCount=0;
	public static int[] storyDislikes= new int[STORYCOUNT]; 
	public static int dislikeCount=0;
	public static int[] commentArray= new int[STORYCOUNT];
	public static int commentCount=0;
	public static int commentLessCount=0;
	public static int[] viewArray= new int[STORYCOUNT];
	public static int viewCount=0;
	
	public static int completeStories=0;
	public static int incompleteStories=0;
	public static int hiatusStories=0;
	public static int cancelledStories=0;
	
	
	public static int adventureCount=0;
	public static int aUCount=0;
	public static int anthroCount=0;
	public static int comedyCount=0;
	public static int crossoverCount=0;
	public static int darkCount=0;
	public static int humanCount=0;
	public static int randomCount=0;
	public static int romanceCount=0;
	public static int sadCount=0;
	public static int lifeCount=0;
	public static int tragedyCount=0;
	
	
	public static int findMedian(int[] array)
	{
		if (array.length % 2 == 0)
		{
		   
		    return (int) ((double) array[array.length/2] + (double) array[array.length/2 - 1])/2;
		    		
		}
		else
		{
			return (int) array[array.length/2];
		}
	}
	
	public static double dayCalculator(int wordsPerMinute)
	{
		double minutesOfReading= (double) (allWordCount/wordsPerMinute);
		double daysOfReading= minutesOfReading/720; //Reading twelve hours per day
		
		
		return daysOfReading;
	}
	
	public static void main(String[] args) 
	{
	
		try 
		{
			FileReader reader = new FileReader(filePath);
	
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			for(int i=0; i<250000; i++) //Highest current ID
			{
				String temp= String.valueOf(i);
				JSONObject obj= (JSONObject) jsonObject.get(temp);
				if(obj==null)
				{
					continue;
				}
				
				//String title= (String) obj.get("title");
				long contentRating =(Long) obj.get("content_rating");
				
				if(contentRating==0)
				{
					ratedE++;
				}
				else if(contentRating==1)
				{
					ratedT++;
				}
				else if(contentRating==2)
				{
					ratedM++;
				}
				
				long words =  (Long) obj.get("words");
				wordCountArray[(int) storyCount] =(int) words;
				
				long comments =  (Long) obj.get("comments");
				//System.out.println("Comments: "+ comments);
				commentCount+=comments;
				commentArray[(int) storyCount] =(int) comments;
				
				if(comments==0)
				{commentLessCount++;}
				
				long like =  (Long) obj.get("likes");
				likeCount+=like;
				storyLikes[(int) storyCount] =(int) like;
				
				long dislike =  (Long) obj.get("dislikes");
				dislikeCount+=dislike;
				storyDislikes[(int) storyCount] =(int) dislike;
				
				long views =  (Long) obj.get("views");
				viewCount+=views;
				viewArray[(int) storyCount] =(int) views;
				
				storyCount++;

				allWordCount+=words;
				if(words<5000)
				{
					storiesBelow5k++;
				}
				else if(words>=100000)
				{
					storiesAbove100k++;
				}
				else
				{
					storiesAbove5k++;
				}
				
				
				
				
				String status= (String) obj.get("status");
				if(status.equals("Incomplete"))
				{
					incompleteStories++;
				}
				else if(status.equals("Complete"))
				{
					completeStories++;
				}
				else if(status.equals("Cancelled"))
				{
					cancelledStories++;
				}
				else
				{
					hiatusStories++;
				}
				
				JSONObject category= (JSONObject) obj.get("categories");
				
				boolean adventure= (Boolean) category.get("Adventure");
				if(adventure==true) adventureCount++;
				boolean au= (Boolean) category.get("Alternate Universe");
				if(au==true) aUCount++;
				boolean anthro= (Boolean) category.get("Anthro");
				if(anthro==true) anthroCount++;
				boolean comedy= (Boolean) category.get("Comedy");
				if(comedy==true) comedyCount++;
				boolean crossover= (Boolean) category.get("Crossover");
				if(crossover==true) crossoverCount++;
				boolean dark= (Boolean) category.get("Dark");
				if(dark==true) darkCount++;
				boolean human= (Boolean) category.get("Human");
				if(human==true) humanCount++;
				boolean random= (Boolean) category.get("Random");
				if(random==true) randomCount++;
				boolean romance= (Boolean) category.get("Romance");
				if(romance==true) romanceCount++;
				boolean sad= (Boolean) category.get("Sad");
				if(sad==true) sadCount++;
				boolean life= (Boolean) category.get("Slice of Life");
				if(life==true) lifeCount++;
				boolean tragedy= (Boolean) category.get("Tragedy");
				if(tragedy==true) tragedyCount++;
				
				
				
				
				//System.out.println("WordCount: " + words+". Title: "+title);
			}
			System.out.println("Total stories: "+storyCount);
			System.out.println("Total amount of words: " + allWordCount);
			
			System.out.println("For the average adult reading at 300 words per minute for 12 hours a day, it would take " + dayCalculator(300)+" days! Or "+(dayCalculator(300)/365)+" years");
			System.out.println("For a speed reader at 1500 words per minute for 12 hours a day, it would take " + dayCalculator(1500)+" days!");
			
			Arrays.sort(wordCountArray);
			System.out.println("Roughly "+(allWordCount/storyCount) +" words for each story. Median wordcount is: "+ findMedian(wordCountArray));
			System.out.println("Stories above 5k: "+storiesAbove5k+ " which is about "+(( (double) storiesAbove5k/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Stories below 5k: "+storiesBelow5k+ " which is about "+(( (double) storiesBelow5k/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Stories above 100k: "+storiesAbove100k+ " which is about "+(( (double) storiesAbove100k/ (double) storyCount)*100)+ "% of stories on the site.");

			System.out.println("Stories rated Everyone: "+ratedE+ " which is about "+(( (double) ratedE/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Stories rated Teen: "+ratedT+ " which is about "+(( (double) ratedT/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Stories rated Mature: "+ratedM+ " which is about "+(( (double) ratedM/ (double) storyCount)*100)+ "% of stories on the site.");
			
			System.out.println("Stories complete: "+completeStories+ " which is about "+(( (double) completeStories/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Stories incomplete: "+incompleteStories+ " which is about "+(( (double) incompleteStories/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Stories on hiatus: "+hiatusStories+ " which is about "+(( (double) hiatusStories/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Stories on cancelled: "+cancelledStories+ " which is about "+(( (double) cancelledStories/ (double) storyCount)*100)+ "% of stories on the site.");
			
			
			
			
			Arrays.sort(storyLikes);
			Arrays.sort(storyDislikes);
			Arrays.sort(commentArray);
			Arrays.sort(viewArray);
			
			System.out.println("Average views per story: "+((double) viewCount/ (double) storyCount)+". Median view amount: "+findMedian(viewArray));
			System.out.println("Average Likes: "+((double)likeCount/ (double) storyCount)+". Median Likes: "+findMedian(storyLikes));
			System.out.println("Average Dislikes: "+((double)dislikeCount/ (double) storyCount)+". Median Dislikes: "+findMedian(storyDislikes));
			System.out.println("Average comments per story: "+((double)commentCount/ (double) storyCount)+". Median Comment amount: "+findMedian(commentArray));
				
			System.out.println("Amount of stories without comments: "+commentLessCount);
			
			
			
			
			System.out.println("Amount of Adventure stories: "+adventureCount+ " which is about "+(( (double) adventureCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Alternate Universe stories: "+aUCount+ " which is about "+(( (double) aUCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Anthro stories: "+anthroCount+ " which is about "+(( (double) anthroCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Comedy stories: "+comedyCount+ " which is about "+(( (double) comedyCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Crossover stories: "+crossoverCount+ " which is about "+(( (double) crossoverCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Dark stories: "+darkCount+ " which is about "+(( (double) darkCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Human stories: "+humanCount+ " which is about "+(( (double) humanCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Random stories: "+randomCount+ " which is about "+(( (double) randomCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Romance stories: "+romanceCount+ " which is about "+(( (double) romanceCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Sad stories: "+sadCount+ " which is about "+(( (double) sadCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Slice of Life stories: "+lifeCount+ " which is about "+(( (double) lifeCount/ (double) storyCount)*100)+ "% of stories on the site.");
			System.out.println("Amount of Tragedy stories: "+tragedyCount+ " which is about "+(( (double) tragedyCount/ (double) storyCount)*100)+ "% of stories on the site.");
	
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