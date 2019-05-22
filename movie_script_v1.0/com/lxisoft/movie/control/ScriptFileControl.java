package com.lxisoft.movie.control;
import java.io.*;
import java.util.*;
import java.util.logging.*;
/**
*This class is the control class for ScriptFile
*
*@author Arya Vineesh
*
*@version 1.0
*
*Date Modified:22/05/2019
*/
public class ScriptFileControl
{
	/**
	*Reference Logger class to get log messages
	*/
	private static final Logger log=Logger.getLogger(ScriptFileControl.class.getName());
	
	/**
	*This method is used for create file
	*
	*@param fileName - the name of the file to be create
	*/
	public void createFile(String fileName)
	{
		log.info("ScriptFileControl class.............createFile............start");
		try
		{
			File newFile=new File(fileName);
			newFile.createNewFile();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		log.info("ScriptFileControl class.............createFile............end");
	}
	
	/**
	*This method is used to read data from file
	*
	*@param fileName - the name of the file to be read
	*
	*/
	public ArrayList<String> readFromFile(String fileName)
	{
		log.info("ScriptFileControl class.............readFromFile............start");
		
		
		ArrayList<String> readDataList=new ArrayList<String>();
		QuizModel quizFileModel=new QuizModel();
		try
		{
			FileReader fr=new FileReader(fileName);
			BufferedReader br=new BufferedReader(fr);
			
			quizFileModel.setReadData(br.readLine());
			
			String data=quizFileModel.getReadData();
			while(data!=null)
			{
				
				
				String array[]=data.split(",");
				for(String value:array)
					readDataList.add(value);
				data=br.readLine();
			}
			
			
			br.close();
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println("Array overflow..........");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		log.info("ScriptFileControl class.............readFromFile............end");
	return readDataList;
	}
}