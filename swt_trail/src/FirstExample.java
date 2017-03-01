import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class FirstExample {
     public static void main(String[] args){
    	 Display myDisplay = new Display();
         Shell myShell = new Shell(myDisplay);
         myShell.setText("This is a label");
         myShell.setBounds(100, 100, 200, 50);
         myShell.setLayout(new FillLayout());
          Label label = new Label(myShell, SWT.CENTER);
          label.setText("Hello World");
        Color red = new Color(myDisplay, 255, 0, 0);
        label.setForeground(red);
        
        final Button myButton = new Button(myShell, SWT.PUSH);
        
        SelectionAdapter adapter = new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event) {
                myButton.setText("You clicked me!");
            }
        };	
        myButton.addSelectionListener(adapter);
        myButton.setText("Click");
        
        
        
        myShell.open();
        while (!myShell.isDisposed()) {
           if (!myDisplay.readAndDispatch()) myDisplay.sleep();
        }
        red.dispose();
        myDisplay.dispose();
     }
     
}