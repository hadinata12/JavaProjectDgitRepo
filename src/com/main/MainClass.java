package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception { 
		
		/*
		 * File folder = new File("F://deploy"); File[] listOfFiles =
		 * folder.listFiles();
		 * 
		 * for (File file : listOfFiles) { if (file.isFile()) {
		 * System.out.println(file.getName()); } }
		 */
		/*
		 * Path fileName = Path.of("F://deploy//input.txt"); String content =
		 * "hello world !!"; // Files.writeString(fileName, content);
		 * 
		 * String actual = Files.readString(fileName); System.out.println(actual);
		 */
        
        String[] file = {"F://deploy//input.txt","F://deploy//index.php"}; 
        for(int i=0;i<args.length;i++) {
        	countWordsCapital(args[i]);
        	 countWords(args[i]);
        }
        
       
	}
	
	public static void countWordsCapital(String file) {
		Scanner sc = null;
	    try {
	        sc = new Scanner(new File(file));
	        int count = 0;
	        while(sc.hasNext()){
	            String line = sc.nextLine();
	            for(int i = 0 ; i < line.length(); i++){
	                if(line.charAt(i) >= 'A' && line.charAt(i) <= 'Z'){
	                    count ++;
	                }
	            }
	        }
	        System.out.println("The number of capital letters are : "+ file +" -- "+count);

	    } catch (FileNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	    finally{
	        sc.close();
	    }
	}
	
	public static void countWords(String file) throws Exception {
		File f1=new File(file); //Creation of File Descriptor for input file
	      String[] words=null;    //Intialize the word Array
	      int wc=0;     //Intialize word count to zero
	      FileReader fr = new FileReader(f1);    //Creation of File Reader object
	      BufferedReader br = new BufferedReader(fr);    //Creation of BufferedReader object
	      String s;
	      while((s=br.readLine())!=null)    //Reading Content from the file
	      {
	         words=s.split(" ");   //Split the word using space
	         wc=wc+words.length;   //increase the word count for each word
	      }
	      fr.close();
	      System.out.println("Number of words in the file: "+file+ " = " +wc);
	}
}

