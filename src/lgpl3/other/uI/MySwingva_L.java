package lgpl3.other.uI;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import lgpl3.o.B;

/**
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MySwingva_L" >MySwingva_L.java</a>
 *
 * @see MySwingva
 */
public abstract class MySwingva_L extends MySwingva_F {

	// private static final Class<?> THIS = MySwingva_L.class;

	/**
	 * To set GridBagConstraints.<br/>
	 * To set GridBagConstraints.
	 */
	public static Component genHeadJPanel(int key32) {

		JPanel jPanel = new JPanel();

		jPanel.setBorder(EMPTY_BORDER);
		jPanel.setBackground(COLOR_BACKGROUND);
		jPanel.setDoubleBuffered(B.I);

		jPanel.setLayout(new GridBagLayout());

		GridBagConstraints constr = new GridBagConstraints();

		constr.gridx = 0; // txtfld0
		constr.gridy = 0;
		constr.gridwidth = 1;
		constr.gridheight = 1;
		constr.weightx = 0.35D;

		constr.fill = GridBagConstraints.BOTH;
		// constr.anchor = GridBagConstraints.NORTH;

		jPanel.add(MAP_OF_TXTFLD.get(key32), constr);

		constr.gridx = 1; // txtfld1
		constr.gridy = 0;
		constr.gridwidth = 1;
		constr.gridheight = 1;
		constr.weightx = 0.35D;

		constr.fill = GridBagConstraints.BOTH;

		jPanel.add(MAP_OF_TXTFLD.get(key32 + 1), constr);

		constr.gridx = 2; // btn0
		constr.gridy = 0;
		constr.gridwidth = 1;
		constr.gridheight = 1;
		constr.weightx = 0.15D;

		constr.fill = GridBagConstraints.BOTH;

		jPanel.add(MAP_OF_BTN.get(key32), constr);

		constr.gridx = 3; // btn1
		constr.gridy = 0;
		constr.gridwidth = 1;
		constr.gridheight = 1;
		constr.weightx = 0.15D;

		constr.fill = GridBagConstraints.BOTH;

		jPanel.add(MAP_OF_BTN.get(key32 + 1), constr);

		return jPanel;

	}

	/**
	 * To set GridBagConstraints.<br/>
	 * To set GridBagConstraints.
	 */
	public static JPanel setGridBagConstr(int key32, JPanel jPanel) { // MP, EP, DIY

		jPanel.setLayout(new GridBagLayout());

		GridBagConstraints constr = new GridBagConstraints();

		constr.gridx = 0; // txtfld and btn
		constr.gridy = 0;
		constr.gridwidth = 4;
		constr.gridheight = 1;
		constr.weightx = 1;
		constr.weighty = 0;
		constr.fill = GridBagConstraints.BOTH;

		jPanel.add(genHeadJPanel(key32), constr);

		constr.gridx = 0; // progrBar
		constr.gridy = 1;
		constr.gridwidth = 4;
		constr.gridheight = 1;
		constr.weightx = 1;
		constr.weighty = 0;

		constr.fill = GridBagConstraints.BOTH;

		if (key32 != MySue.KEY_DIY0)
			jPanel.add(MAP_OF_PROGR_BAR.get(key32), constr);

		constr.gridx = 0; // scrlpane
		constr.gridy = 2;
		constr.gridwidth = 4;
		constr.gridheight = 1;
		constr.weightx = 1;
		constr.weighty = 0.8;

		constr.fill = GridBagConstraints.BOTH;

		jPanel.add(MAP_OF_SCRLPANE.get(key32), constr);

		return jPanel;

	}
}
