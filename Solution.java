import java.util.*;
import java.io.*;

public class Patient
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
      while(currentLine!= null)
      {
        HashMap<String, Float> aData = new HashMap<String, Float>();
        String aID;
        boolean aRemission;
        double aDuration;
        double aMonths;
        aID = parts[0];
        if(parts[266].equals("COMPLETE_REMISSION"))
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
