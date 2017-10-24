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

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;

import psn.ej.parser.antlr.sql.oracle.PlSqlLexer;
import psn.ej.parser.antlr.sql.oracle.PlSqlParser;

/**
 * OracleSqlParser
 * 
 * @author ej.park
 *
 */
public class OracleSqlParser implements SqlParser {

	private PlSqlLexer sqlLexer;
	private PlSqlParser sqlParser;
	
	/**
	 * OracleSqlParser
	 * 
	 * @param sql
	 */
	public OracleSqlParser(String sql){
		this.sqlLexer = new PlSqlLexer(CharStreams.fromString(sql.toUpperCase()));
		BufferedTokenStream tokens = new CommonTokenStream(this.sqlLexer);
        tokens.fill();
		this.sqlParser = new PlSqlParser(tokens);
        this.sqlParser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        this.sqlParser.setBuildParseTree(true);
	}
	
	/* (non-Javadoc)
	 * @see psn.ej.parser.antlr.sql.SqlParser#getParser()
	 */
	@Override
	public Parser getParser() {
		return this.sqlParser;
	}
	
	/* (non-Javadoc)
	 * @see psn.ej.parser.antlr.sql.SqlParser#getTree()
	 */
	@Override
	public ParseTree getTree() {
		ParseTree tree = this.sqlParser.compilation_unit();
		if(this.sqlParser.getNumberOfSyntaxErrors()>0){
			throw new RuntimeException();
		}
		return tree;
	}
}
