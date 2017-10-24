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

package org.ej.parser.sql;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.ej.common.util.FileUtils;
import org.ej.parser.sql.SqlParser;
import org.ej.parser.sql.SqlParserFactory;
import org.ej.parser.sql.SqlType;
import org.ej.parser.sql.exception.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SqlParserFactoryTest
 * 
 * @author ej.park
 *
 */
@RunWith(Parameterized.class)
public class SqlParserFactoryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SqlParserFactoryTest.class);
	private File sqlFile;

	public SqlParserFactoryTest(File sqlFile) {
		this.sqlFile = sqlFile;
	}

	@Parameters
	public static List<File> getFileList() {
		return FileUtils.getFileList("src/test/resources/org/ej/parser/sql/oracle");
	}

	@Test
	public void test() {
		LOGGER.debug("FilePath:{}", this.sqlFile.getAbsolutePath());

		String fileString = FileUtils.readFile(this.sqlFile);

		String[] sqls = fileString.split(";");
		SqlParser sqlParser = SqlParserFactory.getSqlParser(SqlType.ORACLE);
		for (String sql : sqls) {
			try {
				if (!sql.trim().isEmpty()) {
					sqlParser.parse(sql + ";");
				}
			} catch (ParseException e) {
				assertTrue(false);
			}
		}
	}

}
