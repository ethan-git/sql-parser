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

package org.ej.common;

/**
 * AbstractCommonException
 * 
 * @author ej.park
 *
 */
public abstract class AbstractCommonException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 878651182443255137L;

	/**
	 * constructor
	 */
	public AbstractCommonException() {
		super();
	}

	/**
	 * constructor
	 * 
	 * @param message
	 *            exception message
	 */
	public AbstractCommonException(String message) {
		super(message);
	}

	/**
	 * constructor
	 * 
	 * @param message
	 *            exception message.
	 * @param cause
	 *            the cause
	 */
	public AbstractCommonException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * constructor
	 * 
	 * @param cause
	 *            the cause
	 */
	public AbstractCommonException(Throwable cause) {
		super(cause);
	}
}
