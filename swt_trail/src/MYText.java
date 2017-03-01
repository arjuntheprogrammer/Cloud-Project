

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MYText {
	   public static void main(String[] args) {
	      Display myDisplay = new Display();
	      Shell myShell = new Shell(myDisplay);
	      myShell.setText("My Text Box");
	      myShell.setBounds(120, 120, 220, 120);
	      myShell.setLayout(new FillLayout());
	      final Text text = new Text(myShell, SWT.MULTI);
	      myShell.open();
	      while (!myShell.isDisposed()) {
	         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
	      }
	      myDisplay.dispose();
	   }
	}