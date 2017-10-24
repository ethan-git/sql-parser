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

/**
 * SqlParserFactory
 * 
 * @author ej.park
 *
 */
public class SqlParserFactory {

	/**
	 * getSqlParser
	 * 
	 * @param sqlParserType
	 *            sql dbms type
	 * @return SqlParser sql parser interface
	 */
	public static SqlParser getSqlParser(SqlType sqlParserType) {
		SqlParser sqlParser = null;
		if (SqlType.ORACLE.equals(sqlParserType)) {
			sqlParser = new OracleSqlParser();
		}
		return sqlParser;
	}
}
