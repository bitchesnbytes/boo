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
      currentLine = reader.readLine();
      String after = currentLine.trim().replaceAll(" +", ",");
      String [] parts = after.split(",");
        //31
      String [] arr = new String [265];
      int counter =0;
      for (int i = 31; i<=296; i++)
      {
        arr[counter] = parts[i];
        counter++;
      }
      for(int i = 297; i<parts.length; i++)
      {
       Patient newPatient = new Patient(aRemission, aDuration, aMonths, aData, aName);
       int key = (i+30)%269;
       if(key==0)
       { newPatient.aName = parts[i];}
       if(key==266)
       {  newPatient.aRemission = parts[i];}
       if(key==267)
       {  newPatient.aDuration = Integer.parseInt(parts[i]);}
       if(key==268)
       {  
         newPatient.aMonths = Integer.parseInt(parts[i]);
         patient.add(newPatient);
       }
       else
       {
         float value = Float.parseFloat(parts[i]);
         newPatient.aData.put(key, value);
        } 
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
