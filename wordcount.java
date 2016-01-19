
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
/* @author: Jajuan Brooks    

   - The purpose of this program is read a text file of whatever length 
   - The file will be given from the user
   - It will count the amount of words, letters, punctuation, vowels, sentences and lines
   - Lastly create an output file containing the text file as well as the count info 
   
    
  
Solution: 
   - This should list all of the steps in your algorithm.  Example is below.
   - Suggestion:
       - Do this part first if you want to use it to help create your algorithm
      
   - use a scanner to take in input 
   - prompt the user to enter file location 
   - create a try block for reading the file and making the output 
   - use filereader to read the file given by the user 
   - use printwriter to create an output file called output.txt
   - create an if statement so that if the file is blank it will return "file is empty" and the info
   - create a while loop that iterates if the file is not empty. it then goes through the file and  after every word int wordcount increases by one. 
     at the same time it puts these words into a string, it also writes that word into the output.txt
   - create a for going through the string of words by each character and increasing int letters by one for each character. But subtracting
   	 by one for each space to ensuere the count is only letters
   	-for loop for finding and adding each time there is a vowel
   	-for loop for finding and adding each time there is punctuation
   	- lastly write all count info into the output.txt file
   		-the 

HOW TO USE PROGRAM:	
      - prompt: Enter the file location 
        user: c:/user/Desktop/input.txt
      
      	output file will be put in the parent directory of wherever the input file was taken from
      
      	prompt: 
      	lines: 1
		words: 18
		vowels: 22
		letters: 63
		Punctuation: 1
		Sentences: 0
*/


public class wordcount {
public static void main(String [] args) {                                           
	System.out.println("Enter the file location: ");								
	Scanner in = new Scanner(System.in); 
	String input= in.nextLine(); 												
	String words, line;																
	int wordcount=0, letters = 0, vowels=0, punct=0;								
	int lines=0, sent=0;															
	char c;																			
	try {
		File file = new File ("jbrookscsc/output.txt");
		file.getParentFile().mkdirs();
		PrintWriter output = new PrintWriter(file);
		Scanner finput = new Scanner (new FileReader(input));
		BufferedReader br = new BufferedReader(new FileReader(input));              
		if (!finput.hasNext()){
		System.out.println("File is empty");
		}
		
		while(br.readLine()!=null){
			lines++;
		}
		while(finput.hasNext())
		{
			words=finput.next();
			output.print(words+" ");
			wordcount++;
			
		for (int i = 0; i < words.length(); i++) {
			c=words.charAt(i);
			letters++;
			if (c==' '){
				letters--;
			}
		}
		
		for (int i = 0; i < words.length(); i++) {
			c=words.charAt(i);
			if (c=='o'||c=='a'||c=='e'||c=='i'||c=='u'||
				c=='O'||c=='A'||c=='E'||c=='I'||c=='U'){
				vowels++;
			}
		}
		
		for (int i = 0; i < words.length(); i++) {
			c=words.charAt(i);
			if (c=='\''||c==','||c==';'||c==':'||c=='.'||c=='?'||c=='!'){
				punct++;
			}
		}
		
		for (int i = 0; i < words.length(); i++) {
			c=words.charAt(i);
			if (c=='?'|| c=='.'||c=='!'){
				sent++;
			}
		}
			for (int i = 0; i < words.length(); i++) {
				c=words.charAt(i);
				if (c=='\n'){
					lines++;
				}
			}
		}
		output.println("\nLines: "+lines+"\nwords:" +wordcount+"\nvowels: "+ vowels+"\nletters: "+letters+"\npunctuations: "+punct+"\nsentences: "+sent);
		output.close();
		br.close();
	
	}
	catch(FileNotFoundException ex){
		System.out.println("Could not find file");
	}

	catch(IOException ex){
		System.out.println("ehh?");
	}
	
	System.out.println("words: "+ wordcount);
	System.out.println("vowels: "+ vowels);
	System.out.println("letters: "+letters);
	System.out.println("punctuations: "+punct);
	System.out.println("Sentences: "+sent);
	System.out.println("lines: " +lines);
	}
}

