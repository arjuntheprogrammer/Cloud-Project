

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MyRowLayout {
	   public static void main(String[] args) {
	      Button myButton;
	      Display myDisplay = new Display();
	      Shell myShell = new Shell(myDisplay);
	      myShell.setText("MyRowLayout");
	      myShell.setBounds(120, 120, 420, 120);
	      RowLayout myLayout = new RowLayout();
	      myShell.setLayout(myLayout);
	      myLayout.spacing = 15;
	      myLayout.marginTop = 15;
	      myLayout.marginRight = 15;
	      myLayout.marginLeft = 15;
	      myLayout.marginBottom = 15;
	      for (int i = 1; i <= 10; i++) {
	         myButton = new Button(myShell, SWT.PUSH);
	         myButton.setText("" + i);
	      }
	      myShell.open();
	      while (!myShell.isDisposed()) {
	         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
	      }
	      myDisplay.dispose();
	   }
	}