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
	 * @param sql
	 * @return SqlParser
	 */
	public static SqlParser getSqlParser(SqlParserType sqlParserType, String sql){
		SqlParser sqlParser = null;
		if(SqlParserType.ORACLE.equals(sqlParserType)){
			sqlParser = new OracleSqlParser(sql);
		}
		return sqlParser;
	}
}
