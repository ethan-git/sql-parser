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

package psn.ej.parser.antlr.tree;

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
	 * @param tree
	 */
	public static void showTree(Parser parser, ParseTree tree){
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
