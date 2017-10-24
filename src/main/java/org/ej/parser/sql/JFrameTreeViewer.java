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

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * JFrameTreeViewer
 * 
 * @author ej.park
 *
 */
public class JFrameTreeViewer {

	/**
	 * showTree
	 * 
	 * @param parser
	 *            antlr parser
	 * @param tree
	 *            antlr tree
	 */
	public static void showTree(Parser parser, ParseTree tree) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JScrollPane jScrollPane = new JScrollPane(panel);
		TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
		panel.setBackground(Color.WHITE);
		viewr.setScale(1.5);
		panel.add(viewr);
		frame.add(jScrollPane);
		frame.setSize(1600, 1000);
		frame.setVisible(true);
	}

}
