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

import java.io.File;

import org.ej.common.util.FileUtils;
import org.junit.Test;

/**
 * SqlErrorCaseTest
 * 
 * @author ej.park
 *
 */
public class TempTest {

	@Test
	public void testLexerError() {
		File sqlFile = FileUtils.getFile("src/test/resources/org/ej/parser/sql/temp.sql");
		String fileString = FileUtils.readFile(sqlFile);
		String[] sqls = fileString.split(";");
		SqlParser sqlParser = SqlParserFactory.getSqlParser(SqlType.ORACLE);
		for (String sql : sqls) {
			if (!sql.trim().isEmpty()) {
				sqlParser.parse(sql + ";");
				sqlParser.getTree();
			}
		}
	}
}
