/**
 * 
 */
package com.ui.helper;

import java.io.File;
import java.io.FileFilter;

/**
 * @author ankursrivastava
 *
 */
public class AdFileFilter implements FileFilter{

	String acceptedFileExt[] = {"jpg", "png", "gif"};
	
	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		for(String ext : acceptedFileExt){
			if(file.getName().toLowerCase().endsWith(ext)){
				return true;
			}
		}
		return false;
	}

}
