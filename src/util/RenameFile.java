package com.ecl.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RenameFile {

	public static void main(String[] args) {
		
	  
		Path pathin = Paths.get("c:/test/repo/un.json");
		   System.out.println("pathin  = " + pathin.toString() );
		   
		     
		System.out.println("path = " + pathin.getFileName().toString());
		
		   String fileout = pathin.getFileName().toString().replace(".json", ".zlib");  
		
		   Path pathout =  pathin.getParent().resolve(fileout);
	
			System.out.println("pathout  = " + pathout.toString() );
			   
				   
		String filename ="contracts-CRMPART-2_CRMPART-2_60-634390b7-070c-4acc-8b7c-274c6796e6be";
		
		
		final String a = filename.split("-")[0];
		final String b = filename.split("-")[2].split("_")[1];
	
		final String name = a + "-"+ b;
		
		
		
		Pattern.compile("^[a-z]+\\-(.)*_$");
		
		
		
		
		  // remove -PART-X- if exists
        if (filename.indexOf("-CRMPART-") != -1) {
            filename = filename.replace(filename.substring(filename.indexOf("-CRMPART-"), filename.indexOf("_")), "");
        }
        if (filename.indexOf("-NOCRMPART-") != -1) {
            filename = filename.replace(filename.substring(filename.indexOf("-NOCRMPART-"), filename.indexOf("_")), "");
        }
        System.out.println("key = " + filename.substring(0, StringUtils.ordinalIndexOf(filename, "_", 2)));
        
        String key = filename.substring(0, StringUtils.ordinalIndexOf(filename, "_", 2));

        final String fileType = key.substring(key.indexOf("_") + 1);
        String contractFileName = key.substring(0, key.indexOf("_"));
       
        if (contractFileName.contains("-PART-")) {
            contractFileName = contractFileName.substring(0, key.indexOf("-PART-"));
        }
        contractFileName = contractFileName + "-" + fileType + ".zlib";
        System.out.println("contractFileName = " + contractFileName);
        
        
        
    
	}

}
