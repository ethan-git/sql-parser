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

package org.ej.parser.sql.listener;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.ej.parser.sql.exception.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ParserErrorListener
 * 
 * @author ej.park
 *
 */
public class ParserErrorListener extends BaseErrorListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParserErrorListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.v4.runtime.BaseErrorListener#syntaxError(org.antlr.v4.runtime.
	 * Recognizer, java.lang.Object, int, int, java.lang.String,
	 * org.antlr.v4.runtime.RecognitionException)
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		String message = String.format("%s(line:%s, pos:%s)", msg, line, charPositionInLine);
		LOGGER.error("[PARSER] syntaxError : {}", message);
		throw new ParseException(message, e);
	}

}
