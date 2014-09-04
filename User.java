//Written by Chinchillax
public class User
{
	public int userId;
	public String username;
	
	public int wordCount=0;
	public int storyCount=0;
	
	public int ratedE=0;
	public int ratedT=0;
	public int ratedM=0;
	
	public int completeStories=0;
	public int incompleteStories=0;
	public int hiatusStories=0;
	public int cancelledStories=0;
	
	public int adventureCount=0;
	public int aUCount=0;
	public int anthroCount=0;
	public int comedyCount=0;
	public int crossoverCount=0;
	public int darkCount=0;
	public int humanCount=0;
	public int randomCount=0;
	public int romanceCount=0;
	public int sadCount=0;
	public int lifeCount=0;
	public int tragedyCount=0;
	
	public int likeCount=0;
	public int dislikeCount=0;
	public int commentCount=0;
	public int viewCount=0;
	public int chapterCount=0;
	
	User(int id, String name)
	{
		userId=id;
		username=name;
	}
	
	
	public String toCSV()
	{
		return userId+","+username+","+storyCount+","+wordCount+","+viewCount+","
	+commentCount+","+likeCount+","+dislikeCount+","+chapterCount+","+ratedE+","+ratedT+","+ratedM+
	","+completeStories+","+incompleteStories+","+hiatusStories+","+cancelledStories+","+
	adventureCount+","+aUCount+","+anthroCount+","+comedyCount+","+crossoverCount+","+darkCount+","+
	humanCount+","+randomCount+","+romanceCount+","+sadCount+","+lifeCount+","+tragedyCount+'\n';
	}
	
	@Override
	public String toString() {
		return "User:"+userId+" "+username+"\r\n"+"[wordCount=" + wordCount + ", storyCount=" + storyCount
				+ ", ratedE=" + ratedE + ", ratedT=" + ratedT + ", ratedM="
				+ ratedM + ", completeStories=" + completeStories
				+ ", incompleteStories=" + incompleteStories
				+ ", hiatusStories=" + hiatusStories + ", cancelledStories="
				+ cancelledStories + ", adventureCount=" + adventureCount
				+ ", aUCount=" + aUCount + ", anthroCount=" + anthroCount
				+ ", comedyCount=" + comedyCount + ", crossoverCount="
				+ crossoverCount + ", darkCount=" + darkCount + ", humanCount="
				+ humanCount + ", randomCount=" + randomCount
				+ ", romanceCount=" + romanceCount + ", sadCount=" + sadCount
				+ ", lifeCount=" + lifeCount + ", tragedyCount=" + tragedyCount
				+ ", likeCount=" + likeCount + ", dislikeCount=" + dislikeCount
				+ ", commentCount=" + commentCount + ", viewCount=" + viewCount
				+ ", chapterCount=" + chapterCount + "]";
	}
	
	
	
}
