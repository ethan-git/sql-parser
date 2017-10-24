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

import java.util.Locale;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.ej.parser.sql.exception.ParseException;
import org.ej.parser.sql.listener.LexerErrorListener;
import org.ej.parser.sql.listener.ParserErrorListener;
import org.ej.parser.sql.oracle.PlSqlLexer;
import org.ej.parser.sql.oracle.PlSqlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OracleSqlParser
 * 
 * @author ej.park
 *
 */
public class OracleSqlParser implements SqlParser {

	private static final Logger LOGGER = LoggerFactory.getLogger(OracleSqlParser.class);
	private final PlSqlLexer sqlLexer;
	private final PlSqlParser sqlParser;
	private ParseTree tree;

	/**
	 * constructor
	 */
	public OracleSqlParser() {
		this.sqlLexer = new PlSqlLexer(CharStreams.fromString(""));
		this.sqlLexer.addErrorListener(new LexerErrorListener());
		this.sqlParser = new PlSqlParser(new CommonTokenStream(this.sqlLexer));
		this.sqlParser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
		this.sqlParser.setBuildParseTree(true);
		this.sqlParser.addErrorListener(new ParserErrorListener());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ej.parser.sql.antlr.SqlParser#parse(java.lang.String)
	 */
	@Override
	public void parse(String sql) {
		parse(sql, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ej.parser.sql.antlr.SqlParser#parse(java.lang.String,
	 * org.ej.parser.sql.antlr.ParseErrorHandler)
	 */
	@Override
	public void parse(String sql, ParseErrorHandler errorHandler) {
		LOGGER.debug("\nSQL:\n{}", sql);
		this.sqlLexer.setInputStream(CharStreams.fromString(sql.toUpperCase(Locale.getDefault())));
		BufferedTokenStream tokens = new CommonTokenStream(this.sqlLexer);
		try {
			tokens.fill();
			this.sqlParser.setTokenStream(tokens);
			this.tree = this.sqlParser.compilation_unit();
		} catch (ParseException e) {
			if (errorHandler == null) {
				throw e;
			} else {
				errorHandler.error();
				errorHandler.error(e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.ej.parser.antlr.sql.SqlParser#getParser()
	 */
	@Override
	public Parser getParser() {
		return this.sqlParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.ej.parser.antlr.sql.SqlParser#getTree()
	 */
	@Override
	public ParseTree getTree() {
		return this.tree;
	}
}
