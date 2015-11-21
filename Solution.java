import java.util.*;
import java.io.*;

class Patient
{
  private String patientId; 
  private boolean Remission;
  private double RemDuration;
  private double monthsToLive; 
  HashMap<String[], Float[]> data = new HashMap<String[], Float[]>();
  
  public Patient(String patientId, boolean Remission, double RemDuration, double monthsToLive, HashMap data){
    this.patientId = patientId;
    this.Remission = Remission;
    this.RemDuration = RemDuration;
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
    return this.Remission;
  }
  
  public void setRemission(boolean Remission){
    this.Remission = Remission;
  }
  
  public double getRemDuration(){
    return this.RemDuration;
  }
  
  public void setRemDuration(double RemDuration){
    this.RemDuration = RemDuration;
  }
  
  public double getMonthsToLive(){
    return this.monthsToLive;
  }
  
  public void setMonthsToLive(double monthsToLive){
    this.monthsToLive = monthsToLive;
  }
  
}

public class Solution
{
  
  public static void main (String[] args)
  {
    ArrayList<Patient> butthole = new ArrayList<Patient>();
    butthole = importPatientInfo("trainingData.txt");
    for(int i = 0; i<butthole.size(); i++)
    {
      System.out.println(butthole.get(i).getPatientId());
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
      String [] parts = currentLine.split("\t");
      String [] keys = new String [266];
      int counter = 0;
      for (int i = 1; i < 266; i++)
      {
       // System.out.println(parts[i]);
        keys[counter] = parts[i];
        counter++;
      }  
      currentLine = reader.readLine();
      currentLine = currentLine.toLowerCase();
      parts = currentLine.split("\t");
      
      
      
      int [] nonNumIndex = {1,4,5,6,7,8,9,10,11};
      
      for (int m = 1; m < nonNumIndex.length; m++)
      {
        int i = nonNumIndex[m];
        
        if (parts[i] == "no" || parts[i] == "m" || parts[i] == "neg" || parts[i] == "anthra-hdac")
        {
          parts[i] = "0";
        }
        
        if (parts[i] == "yes" || parts[i] == "f" || parts[i] == "pos" || parts[i] == "anthra-plus")
        {
          parts[i] = "1";
        }
        
        if (parts[i] == "flu-hdac")
        {
          parts[i] = "2";
        }
        
        if (parts[i] == "hdac-plus")
        {
          parts[i] = "3";
        }
        
        if (parts[i] == "stdaracplus")
        {
          parts[i] = "4";
        }
        
        
        if (parts[i] == "na" || parts[i] == "notdone")
        {
          parts[i] = "44";
        }
      }
      while(currentLine!= null)
      {
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
         aDuration =Double.parseDouble(parts[267]);
         aMonths = Double.parseDouble(parts[268]);
         int counter2 = 0;
        for (int i=1; i<266; i++)
        {
          Float value = Float.parseFloat(parts[i]);
          aData.put(keys[counter2], value);
        }
        Patient newPatient = new Patient (aID, aRemission, aDuration, aMonths, aData);
        patient.add(newPatient);
        currentLine = reader.readLine();
        currentLine = currentLine.toLowerCase();
        parts = currentLine.split("\t");
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
