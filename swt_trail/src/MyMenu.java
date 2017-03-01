

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

class MyMenu {
	   public static void main(String[] args) {
		      Display myDisplay = new Display();
		      final Shell myShell = new Shell(myDisplay);
		      myShell.setText("My Menu");
		      myShell.setBounds(110, 110, 210, 110);
		      Menu myBar = new Menu(myShell, SWT.BAR);
		      myShell.setMenuBar(myBar);
		      MenuItem fileMenuItem = new MenuItem(myBar, SWT.CASCADE);
		      fileMenuItem.setText("&This is my Menu");
		      Menu subMenuItem = new Menu(myShell, SWT.DROP_DOWN);
		      fileMenuItem.setMenu(subMenuItem);
		      MenuItem selectMenuItem = new MenuItem(
		         subMenuItem, SWT.NULL);
		      selectMenuItem.setText("&Hello\tCtrl+S");
		      selectMenuItem.setAccelerator(SWT.CTRL + 'S');
		      selectMenuItem.addSelectionListener(
		         new SelectionAdapter() {
		         public void widgetSelected(SelectionEvent event) {
		            System.out.println("Hello Selected!");
		         }
		      });
		      MenuItem thisIsSeperator = new MenuItem(subMenuItem, SWT.SEPARATOR);
		      MenuItem exitMenuItem = new MenuItem(subMenuItem, SWT.NULL);
		      exitMenuItem.setText("&Bye");
		      exitMenuItem.addSelectionListener(new SelectionAdapter(){
		         public void widgetSelected(SelectionEvent event) {
		            myShell.dispose();
		         }
		      });
		      myShell.open();
		      while (!myShell.isDisposed()) {
		         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
		      }
		      myDisplay.dispose();
		   }
		}