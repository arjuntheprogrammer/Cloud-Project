import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MyGridLayout {
   public static void main(String[] args) {
 
// Gridlayout swt image tutorial
 
      Display myDisplay = new Display();
      Shell myShell = new Shell(myDisplay);
      myShell.setText("My GridLayout");
      myShell.setBounds(120, 120, 220, 120);
      GridLayout myLayout = new GridLayout();
      myLayout.numColumns = 2;
      myShell.setLayout(myLayout);
 
      Label myLabel = new Label(myShell, SWT.LEFT);
      myLabel.setText("Please enter your age and birthdate");
      GridData gridData = new GridData();
      gridData.horizontalSpan = 2;
      myLabel.setLayoutData(gridData);
 
      myLabel = new Label(myShell, SWT.LEFT);
      myLabel.setText("Age:");
 
      Text myText = new Text(myShell, SWT.SINGLE | SWT.BORDER);
      gridData = new GridData();
      gridData.horizontalAlignment = GridData.FILL;
      gridData.grabExcessHorizontalSpace = true;
      myText.setLayoutData(gridData);
 
      myLabel = new Label(myShell, SWT.LEFT);
      myLabel.setText("BirthDate");
      myText = new Text(myShell, SWT.SINGLE | SWT.BORDER);
      gridData = new GridData();
      gridData.horizontalAlignment = GridData.FILL;
      gridData.grabExcessHorizontalSpace = true;
      myText.setLayoutData(gridData);
 
      myShell.open();
      while (!myShell.isDisposed()) {
         if (!myDisplay.readAndDispatch()) myDisplay.sleep();
      }
      myDisplay.dispose();
   }
} 