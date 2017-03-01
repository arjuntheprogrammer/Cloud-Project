

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MyFillLayout {
Display myDisplay = new Display();
Shell myShell = new Shell(myDisplay);

 public MyFillLayout() {
 FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
 fillLayout.marginHeight = 5;
 fillLayout.marginWidth = 5;
 fillLayout.spacing = 1;

  myShell.setLayout(fillLayout);

  Button button1 = new Button(myShell, SWT.PUSH);
  button1.setText("button1");

   Button button2 = new Button(myShell, SWT.PUSH);
   button2.setText("button2");

   Button button3 = new Button(myShell, SWT.PUSH);
   button3.setText("button3");

    myShell.pack();
    myShell.open();

    while (!myShell.isDisposed()) {
    if (!myDisplay.readAndDispatch()) {
        myDisplay.sleep();
        }
    }

    myDisplay.dispose();
    }

    public static void main(String[] args) {
    new MyFillLayout();
}
}