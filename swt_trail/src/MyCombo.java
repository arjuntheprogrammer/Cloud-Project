import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MyCombo {
	   public static void main(String[] args) {
	      Display myDisplay = new Display();
	      Shell myShell = new Shell(myDisplay);
	      myShell.setText("My Combo");
	      myShell.setBounds(120, 120, 220, 120);
	      myShell.setLayout(new FillLayout(SWT.VERTICAL));
	     final Combo myCombo = new Combo(myShell,SWT.READ_ONLY);
	      myCombo.setItems(new String[]
	         {"option1", "option2", "option3", "option4", "option5"});
	      myCombo.setText("option5");
	      myCombo.addSelectionListener(new SelectionAdapter() {
	         public void widgetSelected(SelectionEvent event) {
	            System.out.println("you selected me: " + myCombo.getText());
	          }
	      });
	      myShell.open();
	       while (!myShell.isDisposed()) {
	         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
	      }
	      myDisplay.dispose();
	   }
	}