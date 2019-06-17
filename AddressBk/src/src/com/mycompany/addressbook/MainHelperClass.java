
package src.com.mycompany.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ss
 */
public class MainHelperClass {
 private static final String fileName="AddressBook.txt";   
    
    
 
 public static void saveRecord(String name,String gender,String date){
     
     gender=gender.toLowerCase().trim();
     if(gender.equals("m"))
         gender="Male";
     else if(gender.equals("f"))
         gender="Female";
     
     
     writeFile(name.trim()+", "+gender+", "+date.trim());
     
     
     
 }
 
 
    public static void writeFile(String data) {
        
        
        
   try{
       
    FileWriter fw = new FileWriter(fileName, true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw);

    out.println(data);
    
    out.close();
} catch (IOException e) {
    System.out.println("ERROR");
}
}
    
    public static String readRecord() {
		
        String data="";
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
                            
                           
				data=data+System.lineSeparator()+line;
				// read next line
				line = reader.readLine();
			}
			reader.close();
                        
                       
		} catch (IOException e) {
		}
                
                 return data;
    }
    
    
    
    
    
    public static boolean updateRecord(String oldName,String newName,String gender,String date){
        gender=gender.toLowerCase().trim();
     if(gender.equals("m"))
         gender="Male";
     else if(gender.equals("f"))
         gender="Female";
     
     
     return update(oldName.toLowerCase(),newName.trim()+", "+gender+", "+date.trim());
        
        
    }
    
    
    
    public static String[] numberOfMales(){
        
        
           String data="";
           int count=0;
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				String[]parts=line.split(",");
                                if(parts[1].trim().toLowerCase().equals("male")){
                                    
                                    
                                    data=data+System.lineSeparator()+line;
                                    count++;
                                    
                                }
                                
				// read next line
				line = reader.readLine();
			}
			reader.close();
                        
                       
		} catch (IOException e) {
                    
                    return null;
		}
                
                 return new String[]{count+"",data};
        
        
        
        
    }
    
    
    public static String findOldestPerson() {
        
        String data=null;
        
       try { 
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Date maximum = new Date();
         Date d;
        
        
        BufferedReader reader;
		
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
                            
                            String[]parts=line.split(",");
                          d= sdf.parse( parts[2].trim());
                          
                          if(d.before(maximum)){
                              
                              data=line;
                              maximum=d;
                              
                          }
                            
				
				// read next line
				line = reader.readLine();
			}
			reader.close();
                        
                       
		} catch (Exception e) {
                    
                    return null;
		}
                
                 return data;
        
        
        
        
        
        
    }
    
    
    public static String compareAges(String person1,String person2){
        
        
         boolean flagPerson1=false;
          boolean flagPerson2=false;
        
      try {  
        File inputFile = new File(fileName);
        

BufferedReader reader;
     
         reader = new BufferedReader(new FileReader(inputFile));
     
     


            String currentLine;

while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmedLine = currentLine.trim();
    if(trimmedLine.split(",")[0].trim().toLowerCase().equals(person1)){
        
        flagPerson1=true;
    
    person1=currentLine;
   
    
    }
    if(trimmedLine.split(",")[0].trim().toLowerCase().equals(person2)){
        
      flagPerson2=true;
    
    person2=currentLine;  
        
        
    }
    
    
    if(flagPerson1&&flagPerson2){
        
        
      return  processAges(person1,person2);
        
    }
        
        
        
    
   
}

reader.close();





} catch (Exception ex) {
         return null;
     }
                
                 
                return null;
        
        
        
        
    }
    
    
    private static String processAges(String person1,String person2){
         String []part1=person1.split(",");
         String []part2=person2.split(",");
         
         
          try {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         
         
    
         Date dp1=sdf.parse(part1[2].trim());
         Date dp2=sdf.parse(part2[2].trim());
         
         
         if(dp1.before(dp2)){
             
             return part1[0]+" is "+TimeUnit.DAYS.convert(dp2.getTime() - dp1.getTime(), TimeUnit.MILLISECONDS)+" days older than "+part2[0];
             
             
         }else if(dp2.before(dp1)){
           return part2[0]+" is "+TimeUnit.DAYS.convert(dp2.getTime() - dp1.getTime(), TimeUnit.MILLISECONDS)+" days older than "+part1[0]; 
             
             
         }
         
         
     } catch (ParseException ex) {
         
         return null;
         
     }
         
        return null;
        
    }
    
    
    
    public static boolean deleteRecord(String name){
        
        
        boolean flag=false;
        
      try {  
        File inputFile = new File(fileName);
        File tempFile = new File("myTempFile.txt");

BufferedReader reader;
     
         reader = new BufferedReader(new FileReader(inputFile));
     
     BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


            String currentLine;

while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmedLine = currentLine.trim();
    if(trimmedLine.split(",")[0].trim().toLowerCase().equals(name)){flag=true;continue;}
        
        
        
    
    writer.write(currentLine + System.getProperty("line.separator"));
}
writer.close(); 
reader.close();
inputFile.delete();
tempFile.renameTo(inputFile);
return flag;


} catch (Exception ex) {
         return false;
     }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    public static boolean update(String name,String newRecord){
 boolean flag=false;
 
 
 System.out.println("11");
        
      try {  
        File inputFile = new File(fileName);
        File tempFile = new File("myTempFile.txt");

BufferedReader reader;
     
         reader = new BufferedReader(new FileReader(inputFile));
     
     BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


            String currentLine;

while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    
    
    String trimmedLine = currentLine.trim();
   
    if(trimmedLine.split(",")[0].trim().toLowerCase().equals(name)){flag=true;
   
    writer.write(newRecord+System.getProperty("line.separator"));
    continue;
    
    }
        
        
        
    
    writer.write(currentLine + System.getProperty("line.separator"));
}
writer.close(); 
reader.close();
inputFile.delete();
tempFile.renameTo(inputFile);
return flag;


} catch (Exception ex) {
         return false;
     }
        
        
    }
    
    
}
