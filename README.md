# Talks-Scheduler
Assignment
* You are tasked with scheduling the largest possible subset from a set of talks for one conference room. Each talk in the set has a given start time and end time. Talks can be consecutively schedule but no talks should overlap. 
* To test the program, a text file with a list of all talks will be given in the following format: name, start time, and end time. The times are in a 24 hour format. 
* Your program must be able to catch exceptions errors in all cases (ex. wrong file, incorrect format, missing times, etc.)

My Implementation 
* Talk Class - This class implements the Comparable interface and is used to provide the speaker's name along with the start and stop times of the talk.
* Scheduler Class - This class will is a repository for static methods that I used to schedule the talks. Possible exceptions are catched and IOExceptions are thrown. 
* ScheduleTest Class - This is a test class provided by the instructor. IOExceptions are catched. 
* talks.txt - This is a sample valid talks files that can be used to test the program. 
  - If the file is not correctly formatted or uploaded, exceptions messages will be returned. 
