package com.lhg.test.gtan.begin.file;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class TestFile {
    public static void readFileByLine(String fileName,int param) {
	File file = new File(fileName);
	File tmp = new File("/home/liuhuiguang/exercise/src/com/gtan/file/tmp");
	BufferedReader reader = null;
	BufferedWriter writer = null;
	try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF16"));
	    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmp),"UTF16"));
	    String tempString = null;
            while((tempString = reader.readLine())!= null) {          
	        if(tempString.contains("-->")) {
		    String str[] = tempString.split("-->");
		    Date date0 = readTime(str[0].trim());
		    Date date1 = readTime(str[1].trim());
    	            String dateStr0 = modifyTime(date0,param);
                    String dateStr1 = modifyTime(date1,param);	
		    tempString = new String(dateStr0+" --> "+dateStr1+"\n");
		} else {
		    tempString = new String(tempString+"\n");
		}	
                writer.write(tempString,0,tempString.length());
            }
	    writer.flush();
            reader.close();
	    writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                   reader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
	String dir = file.getParent();
	String name = file.getName();
	file.delete();
	tmp.renameTo(new File(dir,name));
    }

    public static Date readTime(String str) {
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss,SSS");
        Date date = null;
	try {
	    date = format.parse(str);
	}catch (ParseException e) {
            e.printStackTrace();
	}
	return date;
    }

    
    public static String modifyTime(Date date , int param) {
         SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss,SSS");
         Long l = date.getTime()+param*1000;
         String dateStr = format.format(l);
         return dateStr;
    }

    public static void main(String args[]) {
	String fileName = "/home/liuhuiguang/exercise/src/com/gtan/file/test1.srt";
	//String fileName = "test1.srt";
        System.out.println("args[0]="+Integer.parseInt(args[0]));
	TestFile.readFileByLine(fileName,Integer.parseInt(args[0]));
    }
}
