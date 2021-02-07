/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptographie;
import static cryptographie.Cryptographie.absolutePath;
import java.io.*;
import java.io.File; 
import java.util.Scanner;
/**
 *
 * @author Chaima
 */
public class Cryptographie {

  static String directory = System.getProperty("user.home");
  static String filename ="FileCr.texte";
  static String filename1 ="FileDec.texte";
  static String  absolutePath = directory + File.separator + filename;
  static String  absolutePath1 = directory + File.separator + filename1;
 
  static char alphabet [] ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  static int r;
  static int k;
  static String lineEn="";
  static String lineDec="";
static String ref;
static String ref1;
static Scanner sc = new Scanner(System.in);
static  String cryptedTxt;
static  String decryptedTxt;
//la creation de fichier qui contient le message 
public static String WriteFile(){
    Scanner s = new Scanner(System.in);
    String line = "";
    
try {
      FileWriter myWriter = new FileWriter("C:\\Users\\Chaima\\filename1.txt");
      System.out.println("entrez votre texte");
       line = s.nextLine();
      myWriter.write(line);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    
       
     
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
      return null;
    
}
//lecture et cryptage du message 
public static String ReadAndCrypt(){
 
      System.out.println("entre le clé k");
k = sc.nextInt();
    try {
      File myObj = new File("C:\\Users\\Chaima\\filename1.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ref= data.toLowerCase();
                System.out.println("votre message est:"+data);
                
                
                for (int j=0;j<ref.length();j++){
                    if((ref.charAt(j)!=' ')){
    for(int i= 0;i<alphabet.length;i++){  
        if(alphabet[i]==ref.charAt(j)&&(ref.charAt(j)!=' ')){
            
          r=(((i+k))%26);
          
          lineEn =lineEn+ alphabet[r];
          
        }
           
    }
    
}else{
             lineEn =lineEn+" ";
        }
                }
                System.out.println(lineEn);
            } }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
  
      return lineEn;
     
}
//creation de fichier qui contient le message crypté
 public static String CreatCFile(){
    
     cryptedTxt=lineEn;
     
    try(BufferedWriter bufferedWriter = new BufferedWriter(new
FileWriter(absolutePath))) {
String fileContent = cryptedTxt;
bufferedWriter.write(fileContent);
} catch (IOException e) {
// Exception handling
}
      return null;
          
      }
 //lecture et decryptage du message 
 public static String ReadAndDerypt(){
 int test;
      System.out.println("entre le clé k");
k = sc.nextInt();
    try {
      File myObj = new File("C:\\Users\\Chaima\\FileCr.texte");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ref1= data;
                System.out.println("votre message est:"+data);
                
                
                for (int j=0;j<ref1.length();j++){
                    if((ref1.charAt(j)!=' ')){
    for(int i= 0;i<alphabet.length;i++){  
        if(alphabet[i]==ref1.charAt(j)&&(ref1.charAt(j)!=' ')){
            test =i-k;
            if(test<0){
              r=(((i-k))%(26+(i-k)));  
              lineDec =lineDec+ alphabet[r];
            }else{
          r=(((i-k))%26);
          
          lineDec =lineDec+ alphabet[r];
          
        }}
           
    }
    
}else{
             lineDec =lineDec+" ";
        }
                }
                System.out.println(lineDec);
            } }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
  
      return lineDec;
     
}
 //creation de fichier qui contient le message decrypté
 public static String CreatDECFile(){
    
     decryptedTxt=lineDec;
     
    try(BufferedWriter bufferedWriter = new BufferedWriter(new
FileWriter(absolutePath1))) {
String fileContent = decryptedTxt;
bufferedWriter.write(fileContent);
} catch (IOException e) {
// Exception handling
}
      return null;
          
      }
    public static void main(String[] args) throws IOException {
    // Write the content in file
WriteFile();
ReadAndCrypt();
CreatCFile();
ReadAndDerypt();
CreatDECFile();
}}
 