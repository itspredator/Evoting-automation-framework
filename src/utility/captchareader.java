package utility;

import java.io.File;

import net.sourceforge.lept4j.util.LoadLibs;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class captchareader {

	public static void main(String[] args) throws TesseractException {
		
		 Tesseract instance = new Tesseract();
		  //In case you don't have your own tessdata, let it also be extracted for you
		  File tessDataFolder = LoadLibs.extractNativeResources("tessdata");

		  System.out.println("F : " + tessDataFolder.getAbsolutePath());
		  
		 
  
           try { 

        	   //Set the tessdata path
     		  instance.setDatapath(tessDataFolder.getAbsolutePath());
                
               // the path of your tess data folder 
               // inside the extracted file 
               String text 
                   = instance.doOCR(new File("C:\\Users\\Pinkeshc\\Desktop\\captcha\\a.png")); 
     
               // path of your image file 
               System.out.print("CAP : " + text); 
           } 
           catch (TesseractException e) { 
               e.printStackTrace(); 
           } 
       

	}

}
