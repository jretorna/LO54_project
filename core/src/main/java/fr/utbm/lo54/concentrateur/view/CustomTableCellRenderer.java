package fr.utbm.lo54.concentrateur.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @version 01.00.00
 *
 * @author Jeremy - V01.00.00
 * @date 25 mai 2015<br>
 *
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(	final JTable table,
													final Object value,
													final boolean isSelected,
													final boolean hasFocus,
													final int row,
													final int column) {
		Component cellComponent = super.getTableCellRendererComponent(table,
				value, isSelected, hasFocus, row, column);

		float temp = (float) table.getModel().getValueAt(row, 4);
		if (temp > 100 || temp < -50) {
			cellComponent.setBackground(Color.RED);
		} else {
			cellComponent.setBackground(Color.WHITE);
		}
		return cellComponent;
	}
}