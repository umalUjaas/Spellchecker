package spellchecker;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class BusinessLayer {

	public void initUI() {
	    JLabel detailsOfFile = new JLabel();

	    JPanel bottomPanel = new JPanel();

	    JMenuBar menuBar = new JMenuBar();
	    JMenu file = new JMenu("File");
	    JMenuItem newdoc = new JMenuItem("New");
	    newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

	    JMenuItem open = new JMenuItem("Open");
	    open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	    JMenu save = (JMenu) new JMenuItem("Save");
	    save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

	    JMenuItem print = new JMenuItem("Print");
	    print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

	    JMenu exit = (JMenu) new JMenuItem("Exit");

	    exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
	    JMenu edit = new JMenu("Edit");
	    JMenu copy = (JMenu) new JMenuItem("Copy");
	    copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
	    JMenuItem paste = new JMenuItem("Paste");
	    paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
	    JMenu cut = (JMenu) new JMenuItem("Cut");
	    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
	    JMenu selectall = (JMenu) new JMenuItem("Select All");
	    selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
	    JMenu format = new JMenu("Format");
	    JMenuItem fontfamily = new JMenuItem("Font Family");
	    JMenuItem fontstyle = new JMenuItem("Font Style");
	    JMenuItem fontsize = new JMenuItem("Font Size");

	    Object fontFamilyvalue;
	    JList familylist = new JList(fontFamilyvalue);
	    ListModel stylevalues;
		JList stylelist = new JList(stylevalues);
	    ListModel sizevalue;
		sizelist = new JList(sizevalue);
	    familylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    sizelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    stylelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    JTextArea area = new JTextArea(); 
	    area.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
	    area.setLineWrap(true);
	    area.setWrapStyleWord(true);
	    JScrollPane scpane = new JScrollPane(area);

	    scpane.setBorder(BorderFactory.createEmptyBorder());

	    Object f;
		f.setJMenuBar(menuBar);
	    menuBar.add(file);
	    menuBar.add(edit);
	    menuBar.add(format);

	    file.add(newdoc);
	    file.add(open);
	    file.add(save);
	    file.add(print);
	    file.add(exit);

	    edit.add(copy);
	    edit.add(paste);
	    edit.add(cut);
	    edit.add(selectall);

	    format.add(fontfamily);
	    format.add(fontstyle);
	    format.add(fontsize);

	    bottomPanel.add(detailsOfFile);

	    f.setSize(980, 480);
	    ((Container) f).setLayout(new BorderLayout());

	    f.add(scpane, BorderLayout.CENTER);
	    f.add(bottomPanel, BorderLayout.SOUTH);
	    f.setVisible(true);
	}
}
