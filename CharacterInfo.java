//Written by Chinchillax
//Spreadsheet is here: https://docs.google.com/spreadsheets/d/1-tB--cReIT_cLE1mOtGfbs08ZNFuGeQaDGQgArcYmgc/edit?usp=drive_web
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class CharacterInfo 
{
	//private static final String filePath = "index-20130616.json";
	//private static final String filePath = "index-20131015.json";
	//private static final String filePath = "index-20140120.json";
	//private static final String filePath = "index-20140418.json";
	private static final String filePath = "index-20140719.json";
	
	public static boolean isFirstColumn=false;
	
	public static long allWordCount=0;
	public static long storyCount=0;
	
	public static int twilightCount=0;
	public static int spikeCount=0;
	public static int fluttershyCount=0;
	public static int applejackCount=0;
	public static int rarityCount=0;
	public static int rainbowCount=0;
	public static int pinkieCount=0;
	public static int discordCount=0;
	public static int chrysalisCount=0;
	public static int bigMacCount=0;
	public static int celestiaCount=0;
	public static int lunaCount=0;
	public static int lyraCount=0;
	public static int flashCount=0;
	public static int scootalooCount=0;
	public static int applebloomCount=0;
	public static int sweetieCount=0;
	public static int zecoraCount=0;
	public static int cadenceCount=0;
	public static int armorCount=0;
	public static int beardedCount=0;
	public static int derpyCount=0;
	public static int doctorCount=0;
	
	public static int trixieCount=0;
	public static int vinylCount=0;
	public static int octaviaCount=0;
	public static int sombraCount=0;
	public static int gildaCount=0;
	public static int daringCount=0;
	public static int shimmerCount=0; //Sunset Shimmer
	public static int maudCount=0;
	public static int bonCount=0; //Bon-Bon
	public static int braeburnCount=0;
	public static int cheerileeCount=0;
	public static int nightmareCount=0;
	
	
	public static void toCSV()
	{
		FileWriter writer;
		try 
		{
			writer = new FileWriter("Character5.txt");//Change this every time
	
			if(isFirstColumn==true)
			{
				writer.append("____"+'\n');	
				writer.append("Twilight Sparkle Stories"+'\n');
				writer.append("Twilight Sparkle Percentage"+'\n');
				writer.append("Spike Stories"+'\n');
				writer.append("Spike Percentage"+'\n');
				writer.append("Fluttershy Stories"+'\n');
				writer.append("Fluttershy Percentage"+'\n');
				writer.append("Applejack"+'\n');
				writer.append("Applejack Percentage"+'\n');
				writer.append("Rarity"+'\n');
				writer.append("Rarity Percentage"+'\n');
				writer.append("Rainbow Dash"+'\n');
				writer.append("Rainbow Dash Percentage"+'\n');
				writer.append("Pinkie Pie"+'\n');
				writer.append("Pinkie Pie Percentage"+'\n');
				writer.append("Discord"+'\n');
				writer.append("Discord Percentage"+'\n');
				writer.append("Chrysalis"+'\n');
				writer.append("Chrysalis Percentage"+'\n');
				writer.append("Big Macintosh"+'\n');
				writer.append("Big Macintosh Percentage"+'\n');
				writer.append("Celestia"+'\n');
				writer.append("Celestia Percentage"+'\n');
				writer.append("Luna"+'\n');
				writer.append("Luna Percentage"+'\n');
				writer.append("Lyra"+'\n');
				writer.append("Lyra Percentage"+'\n');
				writer.append("Flash Sentry"+'\n');
				writer.append("Flash Sentry Percentage"+'\n');
				writer.append("Scootaloo"+'\n');
				writer.append("Scootaloo Percentage"+'\n');
				writer.append("Applebloom"+'\n');
				writer.append("Applebloom Percentage"+'\n');
				writer.append("Sweetie Belle"+'\n');
				writer.append("Sweetie Belle Percentage"+'\n');
				writer.append("Zecora"+'\n');
				writer.append("Zecora Percentage"+'\n');
				writer.append("Cadence"+'\n');
				writer.append("Cadence Percentage"+'\n');
				writer.append("Shining Armor"+'\n');
				writer.append("Shining Armor Percentage"+'\n');
				writer.append("Star Swirl the Bearded"+'\n');
				writer.append("Star Swirl the Bearded Percentage"+'\n');
				writer.append("Derpy"+'\n');
				writer.append("Derpy Percentage"+'\n');
				writer.append("Doctor Whooves"+'\n');
				writer.append("Doctor Whooves Percentage"+'\n');
				writer.append("Trixie"+'\n');
				writer.append("Trixie Percentage"+'\n');
				writer.append("Vinyl Scratch"+'\n');
				writer.append("Vinyl Scratch Percentage"+'\n');
				writer.append("Octavia"+'\n');
				writer.append("Octavia Percentage"+'\n');
				writer.append("Sombra"+'\n');
				writer.append("Sombra Percentage"+'\n');
				writer.append("Gilda"+'\n');
				writer.append("Gilda Percentage"+'\n');
				writer.append("Daring Do"+'\n');
				writer.append("Daring Do Percentage"+'\n');
				writer.append("Sunset Shimmer"+'\n');
				writer.append("Sunset Shimmer Percentage"+'\n');
				writer.append("Maud Pie"+'\n');
				writer.append("Maud Pie Percentage"+'\n');
				writer.append("Bon Bon"+'\n');
				writer.append("Bon Bon Percentage"+'\n');
				writer.append("Cheerilee"+'\n');
				writer.append("Cheerilee Percentage"+'\n');
				writer.append("Nightmare Moon"+'\n');
				writer.append("Nightmare Moon Percentage"+'\n');
				
				
				writer.flush();
				writer.close();
				return;
			}
						
			
			DecimalFormat df = new DecimalFormat("###.##");
			
			writer.append("2013.6.16"+'\n');	
			writer.append(String.valueOf(twilightCount)+'\n');
			writer.write( df.format(((double) twilightCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(spikeCount)+'\n');
			writer.write(df.format(((double) spikeCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(fluttershyCount)+'\n');
			writer.write(df.format(((double) fluttershyCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(applejackCount)+'\n');
			writer.write(df.format(((double) applejackCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(rarityCount)+'\n');
			writer.write(df.format(((double) rarityCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(rainbowCount)+'\n');
			writer.write(df.format(((double) rainbowCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(pinkieCount)+'\n');
			writer.write(df.format(((double) pinkieCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(discordCount)+'\n');
			writer.write(df.format(((double) discordCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(chrysalisCount)+'\n');
			writer.write(df.format(((double) chrysalisCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(bigMacCount)+'\n');
			writer.write(df.format(((double) bigMacCount/ (double) storyCount)*100) +"%"+'\n');
			
			writer.append(String.valueOf(celestiaCount)+'\n');
			writer.write(df.format(((double) celestiaCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(lunaCount)+'\n');
			writer.write(df.format(((double) lunaCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(lyraCount)+'\n');
			writer.write(df.format(((double) lyraCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(flashCount)+'\n');
			writer.write(df.format(((double) flashCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(scootalooCount)+'\n');
			writer.write(df.format(((double) scootalooCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(applebloomCount)+'\n');
			writer.write(df.format(((double) applebloomCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(sweetieCount)+'\n');
			writer.write(df.format(((double) sweetieCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(zecoraCount)+'\n');
			writer.write(df.format(((double) zecoraCount/ (double) storyCount)*100) +"%"+'\n');
			
			writer.append(String.valueOf(cadenceCount)+'\n');
			writer.write(df.format(((double) cadenceCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(armorCount)+'\n');
			writer.write(df.format(((double) armorCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(beardedCount)+'\n');
			writer.write(df.format(((double) beardedCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(derpyCount)+'\n');
			writer.write(df.format(((double) derpyCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(doctorCount)+'\n');
			writer.write(df.format(((double) doctorCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(trixieCount)+'\n');
			writer.write(df.format(((double) trixieCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(vinylCount)+'\n');
			writer.write(df.format(((double) vinylCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(octaviaCount)+'\n');
			writer.write(df.format(((double) octaviaCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(sombraCount)+'\n');
			writer.write(df.format(((double) sombraCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(gildaCount)+'\n');
			writer.write(df.format(((double) gildaCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(daringCount)+'\n');
			writer.write(df.format(((double) daringCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(shimmerCount)+'\n');
			writer.write(df.format(((double) shimmerCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(maudCount)+'\n');
			writer.write(df.format(((double) maudCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(bonCount)+'\n');
			writer.write(df.format(((double) bonCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(cheerileeCount)+'\n');
			writer.write(df.format(((double) cheerileeCount/ (double) storyCount)*100) +"%"+'\n');
			writer.append(String.valueOf(nightmareCount)+'\n');
			writer.write(df.format(((double) nightmareCount/ (double) storyCount)*100) +"%"+'\n');
					
			writer.flush();
			writer.close();
		
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static int findMedian(int[] array)
	{
		if (array.length % 2 == 0){
		    return (int) ((double) array[array.length/2] + (double) array[array.length/2 - 1])/2;   		
		}
		else{
			return (int) array[array.length/2];
		}
	}
	
	
	public static void ifCharacter(String title, String description, String sDescription)
	{
		
		if(title.contains("twilight") || description.contains("twilight")|| sDescription.contains("twilight"))
		{
			twilightCount++;
		}
		if(title.contains("spike") || description.contains("spike")|| sDescription.contains("spike"))
		{
			spikeCount++;
		}
		if(title.contains("fluttershy") || description.contains("fluttershy")|| sDescription.contains("fluttershy"))
		{
			fluttershyCount++;
		}
		if(title.contains("applejack") || description.contains("applejack")|| sDescription.contains("applejack"))
		{
			applejackCount++;
		}
		if(title.contains("rarity") || description.contains("rarity")|| sDescription.contains("rarity"))
		{
			rarityCount++;
		}
		if(title.contains("rainbow") || description.contains("rainbow")|| sDescription.contains("rainbow"))
		{
			rainbowCount++;
		}
		if(title.contains("pinkie") || description.contains("pinkie")|| sDescription.contains("pinkie"))
		{
			pinkieCount++;
		}
		if(title.contains("discord") || description.contains("discord")|| sDescription.contains("discord"))
		{
			discordCount++;
		}
		if(title.contains("chrysalis") || description.contains("chrysalis")|| sDescription.contains("chrysalis"))
		{
			chrysalisCount++;
		}
		
		if(title.contains("macintosh") || description.contains("macintosh")|| sDescription.contains("macintosh")
				||title.contains("big mac") || description.contains("big mac")|| sDescription.contains("big mac"))
		{
			bigMacCount++;
		}
	
		if(title.contains("celestia") || description.contains("celestia")|| sDescription.contains("celestia"))
		{
			celestiaCount++;
		}
		if(title.contains("luna") || description.contains("luna")|| sDescription.contains("luna"))
		{
			lunaCount++;
		}
		if(title.contains("lyra") || description.contains("lyra")|| sDescription.contains("lyra"))
		{
			lyraCount++;
		}
		if(title.contains("flash sentry") || description.contains("flash sentry")|| sDescription.contains("flash sentry"))
		{
			flashCount++;
		}
		if(title.contains("scootaloo") || description.contains("scootaloo")|| sDescription.contains("scootaloo"))
		{
			scootalooCount++;
		}
		if(title.contains("applebloom") || description.contains("applebloom")|| sDescription.contains("applebloom"))
		{
			applebloomCount++;
		}
		if(title.contains("sweetie") || description.contains("sweetie")|| sDescription.contains("sweetie"))
		{
			sweetieCount++;
		}
		if(title.contains("zecora") || description.contains("zecora")|| sDescription.contains("zecora"))
		{
			zecoraCount++;
		}
		if(title.contains("cadence") || description.contains("cadence")|| sDescription.contains("cadence"))
		{
			cadenceCount++;
		}
		if(title.contains("armor") || description.contains("armor")|| sDescription.contains("armor")
				||title.contains("armour") || description.contains("armour")|| sDescription.contains("armour"))
		{
			armorCount++;
		}
	
		if(title.contains("bearded") || description.contains("bearded")|| sDescription.contains("bearded")
				|| title.contains("star swirl") || description.contains("star swirl")|| sDescription.contains("star swirl"))
		{
		
			beardedCount++; //Star Swirl the bearded
		}
		
		
		if(title.contains("derpy") || description.contains("derpy")|| sDescription.contains("derpy") 
				|| title.contains("ditsy") || description.contains("ditsy")|| sDescription.contains("ditsy")
				|| title.contains("ditzy") || description.contains("ditzy")|| sDescription.contains("ditzy"))
		{
			derpyCount++;
		}
		if(title.contains("the doctor") || description.contains("the doctor")|| sDescription.contains("the doctor")			
				||title.contains("whooves") || description.contains("whooves")|| sDescription.contains("whooves")
				||title.contains("tardis") || description.contains("tardis")|| sDescription.contains("tardis")
				)
		{
			doctorCount++;//This is gonna skew the data
		}
	
		/////////////////////////
		if(title.contains("trixie") || description.contains("trixie")|| sDescription.contains("trixie"))
		{
			trixieCount++;
		}
		if(title.contains("vinyl") || description.contains("vinyl")|| sDescription.contains("vinyl"))
		{
			vinylCount++;
		}
		if(title.contains("dj pon") || description.contains("dj pon")|| sDescription.contains("dj pon")
				||title.contains("dj p0n") || description.contains("dj p0n")|| sDescription.contains("dj p0n"))
		{
			vinylCount++;
		}
		
		if(title.contains("octavia") || description.contains("octavia")|| sDescription.contains("octavia"))
		{
			octaviaCount++;
		}
		if(title.contains("sombra") || description.contains("sombra")|| sDescription.contains("sombra"))
		{
			sombraCount++;
		}
		if(title.contains("gilda") || description.contains("gilda")|| sDescription.contains("gilda"))
		{
			gildaCount++;
		}
		if(title.contains("daring do") || description.contains("daring do")|| sDescription.contains("daring do"))
		{
			daringCount++;
		}
		if(title.contains("sunset shimmer") || description.contains("sunset shimmer")|| sDescription.contains("sunset shimmer"))
		{
			shimmerCount++;
		}
		if(title.contains("maud") || description.contains("maud")|| sDescription.contains("maud"))
		{
			maudCount++;
		}
		if(title.contains("bon bon") || description.contains("bon bon")|| sDescription.contains("bon bon")
				||title.contains("bon-bon") || description.contains("bon-bon")|| sDescription.contains("bon-bon"))
		{
			bonCount++;
		}
		
		if(title.contains("cheerilee") || description.contains("cheerilee")|| sDescription.contains("cheerilee"))
		{
			cheerileeCount++;
		}
		if(title.contains("braeburn") || description.contains("braeburn")|| sDescription.contains("braeburn"))
		{
			braeburnCount++;
		}
		
		if(title.contains("nightmare moon") || description.contains("nightmare moon")|| sDescription.contains("nightmare moon"))
		{
			nightmareCount++;
		}
		
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
				
				String title= (String) obj.get("title");
				long wordCount= (Long) obj.get("words");
				String description= (String) obj.get("description");
				String sDescription= (String) obj.get("short_description");
				
				if(title== null || description==null || sDescription== null)
				{
					continue;
				}
				allWordCount+=wordCount;
				
				storyCount++;
				
				title= title.toLowerCase();
				description= description.toLowerCase();
				sDescription= sDescription.toLowerCase();
				
				ifCharacter(title,description,sDescription);
			}
			
			System.out.println("Total stories: "+storyCount);
			System.out.println("Total amount of words: " + allWordCount);
				
//			System.out.println("Twilight: "+twilightCount+" percentage: "+((double) twilightCount/ (double) storyCount)*100 );
//			System.out.println("Spike: "+spikeCount+" percentage: "+((double) spikeCount/ (double) storyCount)*100 );
//			System.out.println("Fluttershy: "+fluttershyCount+" percentage: "+((double) fluttershyCount/ (double) storyCount)*100 );
//			System.out.println("Applejack: "+applejackCount+" percentage: "+((double) applejackCount/ (double) storyCount)*100 );
//			System.out.println("Rarity: "+rarityCount+" percentage: "+((double) rarityCount/ (double) storyCount)*100 );
//			
//			System.out.println("Rainbow Dash: "+rainbowCount+" percentage: "+((double) rainbowCount/ (double) storyCount)*100 );
//			System.out.println("Pinkie Pie: "+pinkieCount+" percentage: "+((double) pinkieCount/ (double) storyCount)*100 );
//			System.out.println("Discord: "+discordCount+" percentage: "+((double) discordCount/ (double) storyCount)*100 );
//			System.out.println("Chrysalis: "+chrysalisCount+" percentage: "+((double) chrysalisCount/ (double) storyCount)*100 );
//			System.out.println("Big Macintosh: "+bigMacCount+" percentage: "+((double) bigMacCount/ (double) storyCount)*100 );
//			System.out.println("Celestia: "+celestiaCount+" percentage: "+((double) celestiaCount/ (double) storyCount)*100 );
//			System.out.println("Luna: "+lunaCount+" percentage: "+((double) lunaCount/ (double) storyCount)*100 );
//			System.out.println("Lyra: "+lyraCount+" percentage: "+((double) lyraCount/ (double) storyCount)*100 );
//			System.out.println("Flash Sentry: "+flashCount+" percentage: "+((double) flashCount/ (double) storyCount)*100 );
//			System.out.println("Scootaloo: "+scootalooCount+" percentage: "+((double) scootalooCount/ (double) storyCount)*100 );
//			System.out.println("Applebloom: "+applebloomCount+" percentage: "+((double) applebloomCount/ (double) storyCount)*100 );
//			System.out.println("Sweetie Belle: "+sweetieCount+" percentage: "+((double) sweetieCount/ (double) storyCount)*100 );
//			System.out.println("Zecora: "+zecoraCount+" percentage: "+((double) zecoraCount/ (double) storyCount)*100 );
//			System.out.println("Cadence: "+cadenceCount+" percentage: "+((double) cadenceCount/ (double) storyCount)*100 );
//			System.out.println("Shining Armor: "+armorCount+" percentage: "+((double) armorCount/ (double) storyCount)*100 );
//			System.out.println("Star Swirl the Bearded: "+beardedCount+" percentage: "+((double) beardedCount/ (double) storyCount)*100 );
//			System.out.println("Derpy: "+derpyCount+" percentage: "+((double) derpyCount/ (double) storyCount)*100 );
//			System.out.println("Doctor Whooves: "+doctorCount+" percentage: "+((double) doctorCount/ (double) storyCount)*100 );
//			System.out.println("Trixie: "+trixieCount+" percentage: "+((double) trixieCount/ (double) storyCount)*100 );
//			System.out.println("Vinyl Scratch: "+vinylCount+" percentage: "+((double) vinylCount/ (double) storyCount)*100 );
//			System.out.println("Octavia: "+octaviaCount+" percentage: "+((double) octaviaCount/ (double) storyCount)*100 );
//			System.out.println("Sombra: "+sombraCount+" percentage: "+((double) sombraCount/ (double) storyCount)*100 );
//			System.out.println("Gilda: "+gildaCount+" percentage: "+((double) gildaCount/ (double) storyCount)*100 );
//			System.out.println("Daring Do: "+daringCount+" percentage: "+((double) daringCount/ (double) storyCount)*100 );
//			System.out.println("Sunset Shimmer: "+shimmerCount+" percentage: "+((double) shimmerCount/ (double) storyCount)*100 );
//			
//			System.out.println("Maud Pie: "+maudCount+" percentage: "+((double) maudCount/ (double) storyCount)*100 );
//			System.out.println("Bon Bon: "+bonCount+" percentage: "+((double) bonCount/ (double) storyCount)*100 );
//			System.out.println("Cheerilee: "+cheerileeCount+" percentage: "+((double) cheerileeCount/ (double) storyCount)*100 );
//			System.out.println("Nightmare Moon: "+nightmareCount+" percentage: "+((double) nightmareCount/ (double) storyCount)*100 );
//						
			toCSV(); //Call the function to create the .csv file
			
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