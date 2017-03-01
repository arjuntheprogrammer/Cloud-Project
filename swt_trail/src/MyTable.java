

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class MyTable {
	   public static void main(String[] args) {
	      Display myDisplay = new Display();
	      Shell myShell = new Shell(myDisplay);
	      myShell.setText("My Table");
	      myShell.setBounds(120, 120, 220, 120);
	      myShell.setLayout(new FillLayout());
	      final Table myTable = new Table(myShell,
	         SWT.SINGLE | SWT.FULL_SELECTION);
	      TableColumn col1 =
	         new TableColumn(myTable, SWT.NULL);
	      col1.setText("First Column");
	      col1.pack();
	      TableColumn col2 =
	         new TableColumn(myTable, SWT.NULL);
	      col2.setText("Second Column");
	      col2.pack();
	      TableItem tableItem1 = new TableItem(myTable, SWT.NULL);
	      tableItem1.setText(new String[] {"A1", "A2"});
	      TableItem tableItem2 = new TableItem(myTable, SWT.NULL);
	      tableItem2.setText(new String[] {"B1", "B2"});
	      myShell.open();
	      while (!myShell.isDisposed()) {
	         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
	      }
	      myDisplay.dispose();
	   }
	}