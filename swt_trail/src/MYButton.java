import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MYButton {
	   public static void main(String[] args) {
	      Display myDisplay = new Display();
	      Shell myShell = new Shell(myDisplay);
	      myShell.setText("This is my button");
	      myShell.setBounds(120, 120, 220, 120);
	      myShell.setLayout(new FillLayout());
	      final Button button = new Button(myShell, SWT.PUSH);
	       button.setText("Click");
	      button.addSelectionListener(new SelectionAdapter() {
	         public void widgetSelected(SelectionEvent event) {
	           button.setText("You clicked me!");
	         }
	      });
	      myShell.open();
	      while (!myShell.isDisposed()) {
	         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
	      }
	      myDisplay.dispose();
	 }
	}