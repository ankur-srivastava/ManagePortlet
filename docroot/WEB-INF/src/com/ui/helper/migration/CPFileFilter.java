/**
 * 
 */
package com.ui.helper.migration;

import java.io.File;
import java.io.FileFilter;

/**
 * @author ankursrivastava
 *
 */
public class CPFileFilter implements FileFilter{

	String acceptedFileExt[] = {"txt"};
	
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
