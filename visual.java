package spellchecker;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class visual 
{
	public void addActionEvents() {
        JFileChooser newdoc = null;
		newdoc.addActionListener((ActionListener) this);
        JFileChooser save = null;
		save.addActionListener((ActionListener) this);
        JFileChooser print = null;
		print.addActionListener((ActionListener) this);
        JFileChooser exit = null;
		exit.addActionListener((ActionListener) this);
        JFileChooser copy = null;
		copy.addActionListener((ActionListener) this);
        JFileChooser paste = null;
		paste.addActionListener((ActionListener) this);
        JFileChooser cut = null;
		cut.addActionListener((ActionListener) this);
        JFileChooser selectall = null;
		selectall.addActionListener((ActionListener) this);
        JFileChooser open = null;
		open.addActionListener((ActionListener) this);
        JFileChooser fontfamily = null;
		fontfamily.addActionListener((ActionListener) this);
        JFileChooser fontsize = null;
		fontsize.addActionListener((ActionListener) this);
        JFileChooser fontstyle = null;
		fontstyle.addActionListener((ActionListener) this);

    }
	public void actionPerformed(ActionEvent ae, Object fontStyleList) {
        Component f;
		Object area;
		Object fstyle;
		Font newFont;
		int fsize;
		String fontFamily;
		if (ae.getActionCommand().equals("New")) {
            ((Object) area).setText("");
        } 
        else if (ae.getActionCommand().equals("Open")) {
            JFileChooser chooser = new JFileChooser("C:/");
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
            chooser.addChoosableFileFilter(restrict);

            int result = chooser.showOpenDialog(f);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    area.read(br, null);
                    br.close();
                    ((JComponent) area).requestFocus();
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        }
        else if (ae.getActionCommand().equals("Save")) {
            final JFileChooser SaveAs = new JFileChooser();
            SaveAs.setApproveButtonText("Save");
            int actionDialog = SaveAs.showOpenDialog(f);
            if (actionDialog != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File fileName = new File(SaveAs.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                area.write(outFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
        else if (ae.getActionCommand().equals("Print")) {
            try {
                area.print();
            } catch (Exception e) {
            }
        } 
        else if (ae.getActionCommand().equals("Exit")) {
            ((Object) f).dispose();
        }
        else if (ae.getActionCommand().equals("Copy")) {
            text = area.getSelectedText();
        }
        else if (ae.getActionCommand().equals("Paste")) {
            area.insert(text, area.getCaretPosition());
        }
        else if (ae.getActionCommand().equals("Cut")) {
            text = area.getSelectedText();
            area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
        }
        else if (ae.getActionCommand().equals("Select All")) {
            area.selectAll();
        } 
        else if (ae.getActionCommand().equals("Font Family")) {
          
            JOptionPane.showConfirmDialog(null, fontFamilyList, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fontFamily = String.valueOf(fontFamilyList.getSelectedValue());
            newFont = new Font(fontFamily, fstyle, fsize);
            area.setFont(newFont);

        } 
        else if (ae.getActionCommand().equals("Font Style")) {
            
            JOptionPane.showConfirmDialog(null, fontStyleList, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            Object[] stylevalue;
			fstyle = stylevalue[fontStyleList.getSelectedIndex()];
            newFont = new Font(fontFamily, (int) fstyle, fsize);
            area.setFont(newFont);

        } 
        else if (ae.getActionCommand().equals("Font Size")) {
            Object fontSizeList;
		
            JOptionPane.showConfirmDialog(null, fontSizeList, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            String fontSize = String.valueOf(fontSizeList.getSelectedValue());
            fsize = Integer.parseInt(fontSize);
            newFont = new Font(fontFamily, fstyle, fsize);
            ((JComponent) area).setFont(newFont);

        }
    }

 public void keyTyped(KeyEvent ke) {
        Object area;
        cl = area.getText().length();
        Object linecount = ((Object) area).getLineCount();
        Object detailsOfFile;
		detailsOfFile.setText("Length: " + cl + " Line: " + linecount);
    }
 
}
