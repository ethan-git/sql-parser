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
	 * getParser
	 * 
	 * @return Parser
	 */
	public Parser getParser();
	
	/**
	 * getTree
	 * 
	 * @return ParseTree
	 */
	public ParseTree getTree();
}
