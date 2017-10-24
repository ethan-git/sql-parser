/**
 * Copyright (c) 2017 ej.park 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.ej.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.ej.common.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FileUtils
 * 
 * @author ej.park
 *
 */
public class FileUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * getFileList
	 * 
	 * @param filePath
	 *            file path
	 * @return List file list
	 */
	public static List<File> getFileList(String filePath) {
		List<File> fileList = new ArrayList<File>();
		File file = new File(filePath);

		if (file.isDirectory()) {
			listFiles(fileList, file);
		} else {
			fileList.add(new File(filePath));
		}
		return fileList;
	}

	/**
	 * getFile
	 * 
	 * @param filePath
	 *            file path
	 * @return File the file
	 */
	public static File getFile(String filePath) {
		return new File(filePath);
	}

	/**
	 * listFiles
	 * 
	 * @param fileList
	 *            file list
	 * @param directory
	 *            file directory
	 */
	public static void listFiles(List<File> fileList, File directory) {
		File[] found = directory.listFiles();
		for (File file : found) {
			if (file.isDirectory()) {
				listFiles(fileList, file);
			} else {
				fileList.add(file);
			}
		}
	}

	/**
	 * readFile
	 * 
	 * @param file
	 *            file
	 * @return String file string
	 */
	public static String readFile(File file) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = reader.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException ioe) {
			throw new SystemException(ioe);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (final IOException ioe) {
				// ignore
				LOGGER.error(ioe.getMessage());
			}
		}
		return sb.toString();
	}

}
