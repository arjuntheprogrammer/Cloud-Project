

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MyComposite {
	   public static void main(String[] args) {
	      Display myDisplay = new Display();
	      Shell myShell = new Shell(myDisplay);
	      myShell.setText("My Composite");
	      myShell.setBounds(120, 120, 220, 220);
	      Composite composite = new Composite(
	         myShell,SWT.BORDER);
	      composite.setBounds(35, 35, 155, 127);
	      final Button button = new Button(composite,SWT.PUSH);
	      button.setBounds(30, 30, 110, 85);
	      button.setText("ClickMe");
	      myShell.open();
	      while (!myShell.isDisposed()) {
	         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
	      }
	      myDisplay.dispose();
	   }
	}