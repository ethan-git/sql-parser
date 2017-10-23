/*******************************************************************************
 * Copyright (c) 2017 ejpark.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 * 
 * Contributors:
 *     eungjun11@gmail.com - initial API and implementation
 ******************************************************************************/

package psn.ej.parser.antlr.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * FileHandler
 * 
 * @author ej.park
 *
 */
public class FileHandler {

	/**
	 * getFileList
	 * 
	 * @param filePath
	 * @return List<File>
	 */
	public List<File> getFileList(String filePath) {
		List<File> fileList = new ArrayList<File>();
		File file = new File(filePath);

		if (file.isDirectory()) {
			listFiles(fileList, file);
		} else {
			fileList.add(FileUtils.getFile(filePath));
		}
		return fileList;
	}

	/**
	 * listFiles
	 * 
	 * @param fileList
	 * @param directory
	 */
	public void listFiles(List<File> fileList, File directory) {
		File[] found = directory.listFiles();
		for(File file : found){
			if(file.isDirectory()){
				listFiles(fileList, file);
			}else{
				fileList.add(file);
			}
		}
	}

	/**
	 * readFile
	 * 
	 * @param file
	 * @return String
	 */
	public String readFile(File file) {
		String rtnStr = "";
		try {
			rtnStr = FileUtils.readFileToString(file, "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return rtnStr;
	}
}
