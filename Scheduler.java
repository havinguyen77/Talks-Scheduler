/* Havi Nguyen 
/* HTN2115 
/* This class serve as a repository for static methods 
 * that is use to schedule the talks. */

import java.util.*;
import java.io.*;

public class Scheduler{

	/* Creates an arraylist of Talks from an input file */
	public static ArrayList<Talk> makeTalks(String fileName) throws IOException{
		
		ArrayList<Talk> talks = new ArrayList<Talk>();
		
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));

		try {
			String currentLine;
			while ((currentLine = br.readLine()) != null) {

				// Split each txt line by white space
				String[] arrayLine = currentLine.split("\\s+");

				/* throw an error if the start and end times are incorrectly
				formatted */
				int start = Integer.parseInt(arrayLine[1]);
				int end = Integer.parseInt(arrayLine[2]);
				if (arrayLine[1].length() != 4 || arrayLine[2].length() != 4 || 
					start > 2400 || end > 2400 || start > end ||
					start < 0 || end < 0) {
                    talks.clear();
					throw new IncorrectArgumentException("Talk start or end " 
						+ "time is incorrectly formatted.");
				}

				Talk talkList = new Talk(arrayLine[0], start, end); 
				talks.add(talkList);
			}
		} 

		catch (IllegalArgumentException e) {
			System.out.println("There was an error passing the talk argument."); 
            talks.clear();
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Talk description format is incorrect.");
            talks.clear();
		} 
		catch (IncorrectArgumentException e) {
			System.out.println(e.getMessage());
            talks.clear();
		} 
		catch (Exception e) {
			System.out.println("There was an error.");
            talks.clear();
		} 
		finally {
			fileReader.close();
			bufferedReader.close();
		}

		return talks;
	}

    /* Schedules a room with maximum number of non-overlapping talks */
	public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks) {

		ArrayList<Talk> scheduledTalksList = new ArrayList<>();

		Collections.sort(talks);

		//Every talk, schedule it if start time is after previous end time
		int lastEndTime = -1;

		//Enhance for-loop
		for (Talk talk : talks) {
			if (talk.getStartTime() >= lastEndTime) {
				scheduledTalksList.add(talk);
				lastEndTime = talk.getEndTime();
			}
		}
		
		return scheduledTalksList;
	}
	
}