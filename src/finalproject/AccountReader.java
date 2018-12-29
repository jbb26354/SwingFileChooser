
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class AccountReader
{
  // INSTANCE FIELDS
  // ===============

  private String strData = "";
  private String strStatus = "";
  private int intRecordCount = 0;
  private String strOutData = "";

  // CONSTRUCTOR
  // ===========

  public AccountReader()
  {
    JFileChooser fileChooser = new JFileChooser(".");
    int returnVal = fileChooser.showOpenDialog(new JFrame());
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      try
      {
        File file = fileChooser.getSelectedFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        int intLineCount = 0;
        if (line == null)
        {
          JOptionPane.showMessageDialog(null, "File is empty", "File | Open",0);
          strStatus = "File is empty";
        }
        String result = line;
        while ((line = br.readLine()) != null)
        {
          result += '\n' + line;
          intLineCount ++;
        }
        if(intLineCount % 3 != 0)
        {
          JOptionPane.showMessageDialog(null, "Incorrect record structure in datafile", "File | Open",0);
          strStatus = "Incorrect record structure in datafile";
        }
        else if(Integer.parseInt(result.substring(0,1)) != intLineCount / 3)
        {
          intRecordCount = intLineCount / 3;
        }
        else
        {
          intRecordCount = Integer.parseInt(result.substring(0,1));
        }
        strOutData = intRecordCount +  result.substring(1,result.length());
        BadDataException objBDE = new BadDataException(strOutData);
        if(objBDE.getStatus().substring(0,19).equals("Datafile records OK"))
        {
          strStatus = objBDE.getStatus();
        }
      }
      catch (IOException ex)
      {
        JOptionPane.showMessageDialog(null, "Something went wrong loading the file", "File | Open",0);
      }
      catch(NumberFormatException ex)
      {
        JOptionPane.showMessageDialog(null, "RecordCount is not a number", "File | Open",0);
      }
    }
    else
    {
      JOptionPane.showMessageDialog(null, "Cancelled", "File | Open",1);
    }
  }

  // ACCESSORS
  // =========

  public String ShowStatus()
  {
    return strStatus;
  }

  public String ShowData()
  {
    return strOutData;
  }

  public int ShowRecordCount()
  {
    return intRecordCount;
  }

}