package fr.utbm.lo54.concentrateur.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class View extends JFrame {
	/*--------------------------*/
	private static final long serialVersionUID = 1L;
	private ReleveTableModel releveTableModel;
	private JTable table;
	/*--------------------------*/
	public View() {
		super();
		setTitle("Affichage des derniers relevés");
		setPreferredSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		releveTableModel = new ReleveTableModel();
		table = new JTable(releveTableModel);
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		getContentPane().add(new JScrollPane(table), SwingConstants.CENTER);
		pack();
	}
}
