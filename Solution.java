import java.util.*;
import java.io.*;

public class Solution
{

}
private static ArrayList<Patient> importPatientInfo(String patientFilePath)
{
  ArrayList<Patient> patient = new ArrayList<Patient>();
  try
  {
    BufferedReader reader = new BufferedReader (new FileReader(doctorFilePath));
    String currentLine = reader.readLine();
    currentLine = reader.readLine();
    while(currentLine != null)
    {
      String[] parts = new String[4];
      parts = currentLine.split(",");
      String firstname = parts[0];
      String lastname = parts[1];
      String specialty = parts[2];
      long id = Long.parseLong(parts[3]);
      //split each component by commas, and add to a new doctor object 
      Doctor newdoc = new Doctor(firstname, lastname, specialty, id);
      doc.add(newdoc);
      currentLine = reader.readLine();
    }
    reader.close();
    }
  catch (IOException x)
  {
    System.out.println(x);
  }
  //returns array list
  return doc;
 }
