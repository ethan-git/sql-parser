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

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * SqlParser
 * 
 * @author ej.park
 *
 */
public interface SqlParser {

	/**
	 * parse
	 * 
	 * @param sql
	 *            sql string
	 */
	public void parse(String sql);

	/**
	 * parse
	 * 
	 * @param sql
	 *            sql string
	 * @param errorHandler
	 *            custom error handler
	 */
	public void parse(String sql, ParseErrorHandler errorHandler);

	/**
	 * getParser
	 * 
	 * @return Parser antlr parser
	 */
	public Parser getParser();

	/**
	 * getTree
	 * 
	 * @return ParseTree antlr tree
	 */
	public ParseTree getTree();
}
