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

import org.ej.common.util.FileUtils;
import org.ej.parser.sql.ParseErrorHandler;
import org.ej.parser.sql.SqlParser;
import org.ej.parser.sql.SqlParserFactory;
import org.ej.parser.sql.SqlType;
import org.ej.parser.sql.exception.ParseException;
import org.junit.Test;

/**
 * SqlErrorCaseTest
 * 
 * @author ej.park
 *
 */
public class SqlErrorCaseTest {

	@Test
	public void testLexerError() {
		File sqlFile = FileUtils.getFile("src/test/resources/org/ej/parser/sql/error/lexererrorsql.sql");
		String fileString = FileUtils.readFile(sqlFile);
		String[] sqls = fileString.split(";");
		SqlParser sqlParser = SqlParserFactory.getSqlParser(SqlType.ORACLE);
		for (String sql : sqls) {
			try {
				if (!sql.trim().isEmpty()) {
					sqlParser.parse(sql + ";");
					sqlParser.getTree();
				}
			} catch (ParseException e) {
				assertTrue(true);
			}
		}
	}

	@Test
	public void testLexerErrorWithHandler() {
		File sqlFile = FileUtils.getFile("src/test/resources/org/ej/parser/sql/error/lexererrorsql.sql");
		String fileString = FileUtils.readFile(sqlFile);
		String[] sqls = fileString.split(";");
		SqlParser sqlParser = SqlParserFactory.getSqlParser(SqlType.ORACLE);
		for (String sql : sqls) {
			try {
				if (!sql.trim().isEmpty()) {
					sqlParser.parse(sql + ";", new ParseErrorHandler() {

						@Override
						public void error(ParseException exception) {
							assertTrue(true);
						}

						@Override
						public void error() {
							assertTrue(true);
						}
					});
					sqlParser.getTree();
				}
			} catch (ParseException e) {
				assertTrue(false);
			}
		}
	}

	@Test
	public void testParserError() {
		File sqlFile = FileUtils.getFile("src/test/resources/org/ej/parser/sql/error/parsererrorsql.sql");
		String fileString = FileUtils.readFile(sqlFile);
		String[] sqls = fileString.split(";");
		SqlParser sqlParser = SqlParserFactory.getSqlParser(SqlType.ORACLE);
		for (String sql : sqls) {
			try {
				if (!sql.trim().isEmpty()) {
					sqlParser.parse(sql + ";");
					sqlParser.getTree();
				}
			} catch (ParseException e) {
				assertTrue(true);
			}
		}
	}

	@Test
	public void testParserErrorWithHandler() {
		File sqlFile = FileUtils.getFile("src/test/resources/org/ej/parser/sql/error/parsererrorsql.sql");
		String fileString = FileUtils.readFile(sqlFile);
		String[] sqls = fileString.split(";");
		SqlParser sqlParser = SqlParserFactory.getSqlParser(SqlType.ORACLE);
		for (String sql : sqls) {
			try {
				if (!sql.trim().isEmpty()) {
					sqlParser.parse(sql + ";", new ParseErrorHandler() {

						@Override
						public void error(ParseException exception) {
							assertTrue(true);
						}

						@Override
						public void error() {
							assertTrue(true);
						}
					});
					sqlParser.getTree();
				}
			} catch (ParseException e) {
				assertTrue(false);
			}
		}
	}
}
