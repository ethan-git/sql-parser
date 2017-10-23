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

package psn.ej.parser.antlr.sql;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import psn.ej.parser.antlr.file.FileHandler;

/**
 * SqlParserFactoryTest
 * 
 * @author ej.park
 *
 */
public class SqlParserFactoryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SqlParserFactoryTest.class);
	
	@Test
	public void test() {
		FileHandler fileHandler = new FileHandler();
		List<File> fileList = fileHandler.getFileList("src/test/resources/psn/ej/parser/antlr/sql/oracle");
		for(File file : fileList){
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("FilePath:{}", file.getAbsolutePath());
			}
			String fileString = fileHandler.readFile(file);
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("Contents:{}", fileString);
			}
			String[] sqls = fileString.split(";");
			for(String sql : sqls){
				if(LOGGER.isDebugEnabled()){
					LOGGER.debug("SQL:{}", sql);
				}
				SqlParser sqlParser = SqlParserFactory.getSqlParser(SqlParserType.ORACLE, sql);
				Parser parser = sqlParser.getParser();
				assertFalse(parser.getNumberOfSyntaxErrors()>0);
			}
		}
	}

}
