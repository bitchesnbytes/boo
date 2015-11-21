import java.util.*;
import java.io.*;
  
  
  // Class containing patient data
static class Patient
{
  private String patientId; 
  private boolean remission;
  private double remDuration;
  private double monthsToLive; 
  HashMap<String, Float> data = new HashMap<String, Float>();
  
  
  // Constructor that takes all Patient attributes as input
  public Patient(String patientId, boolean remission, double remDuration, double monthsToLive, HashMap<String, Float> data){
    this.patientId = patientId;
    this.remission = remission;
    this.remDuration = remDuration;
    this.monthsToLive = monthsToLive;
    this.data = data;
  }
  
  public String getPatientId(){
    return this.patientId;
  }
  
  public void setPatientId(String patientId){
    this.patientId = patientId;
  }
  
  public boolean getRemission(){
    return this.remission;
  }
  
  public void setRemission(boolean remission){
    this.remission = remission;
  }
  
  public double getRemDuration(){
    return this.remDuration;
  }
  
  public void setRemDuration(double remDuration){
    this.remDuration = remDuration;
  }
  
  public double getMonthsToLive(){
    return this.monthsToLive;
  }
  
  public void setMonthsToLive(double monthsToLive){
    this.monthsToLive = monthsToLive;
  }
  
}

  private static ArrayList<Patient> importPatientInfo(String patientFilePath)
  {
    ArrayList<Patient> patient = new ArrayList<Patient>();
    try
    {
      BufferedReader reader = new BufferedReader (new FileReader(patientFilePath));
      
      String currentLine = reader.readLine();
      currentLine = currentLine.toLowerCase();
      currentLine = reader.readLine();
      String [] parts = currentLine.split("\t"); //put elements in array seperated by tabs
      String [] keys = new String [266];//string of the keys to hash map
      int counter = 0;
      for (int i = 1; i < 266; i++) //go through first block to get all keys into keys array 
      {
       // System.out.println(parts[i]);
        keys[counter] = parts[i];
        counter++;
      }  
      currentLine = reader.readLine();
      currentLine = currentLine.toLowerCase();
      parts = currentLine.split("\t");
      

      while(currentLine!= null)
      {
        currentLine = currentLine.toLowerCase();
        parts = currentLine.split("\t");
        int [] nonNumIndex = {1,4,5,6,7,8,9,10,11};//changing all elements in hashmap that aren't numbers into a number
        
        for (int m = 0; m < nonNumIndex.length; m++)
        {
          
          int i = nonNumIndex[m];
          
          if (parts[i].equals("no") || parts[i].equals("m") || parts[i].equals("neg") || parts[i].equals("anthra-hdac"))
          {
            parts[i] = "0";
          }
          
          if (parts[i].equals("yes") || parts[i].equals("f") || parts[i].equals("pos") || parts[i].equals("anthra-plus"))
          {
            parts[i] = "1";
          }
          
          if (parts[i].equals("flu-hdac"))
          {
            parts[i] = "2";
          }
          
          if (parts[i].equals("hdac-plus"))
          {
            parts[i] = "3";
          }
          
          if (parts[i].equals("stdarac-plus"))
          {
            parts[i] = "4";
          }
          
          if (parts[i].equals("na") || parts[i].equals("notdone") || parts[i].equals("nd"))
          {
            parts[i] = "8008135"; //arbitrary number, shouldn't be a value this high 
          }
        }
        HashMap<String, Float> aData = new HashMap<String, Float>();
        String aID;
        boolean aRemission;
        double aDuration;
        double aMonths;
        aID = parts[0];
        if(parts[266].equals("complete_remission"))
         {
           aRemission = true;
         }
         else
         {
           aRemission = false;
         }
         if (!(parts[267].equals("na")))
         {
           aDuration =Double.parseDouble(parts[267]);
         }
         else{ aDuration = 0; }
         
         aMonths = Double.parseDouble(parts[268]);
         int counter2 = 0;
        for (int i=1; i<266; i++)
        {
         // System.out.println(parts[i]);
          if(parts[i].equals("na"))
          {
            Float value = Float.parseFloat("8008135");
          }
          else
          {
          Float value = Float.parseFloat(parts[i]);
          
//          System.out.println(value);
          aData.put(keys[counter2], value);
          }
        }
        
        Patient newPatient = new Patient (aID, aRemission, aDuration, aMonths, aData); //create a new patient object for each line of code
        patient.add(newPatient); 
        currentLine = reader.readLine();

      }
      reader.close();
    }
      catch (IOException x)
  {
    System.out.println(x);
  }
  //returns array list
  return patient;
 }
}

