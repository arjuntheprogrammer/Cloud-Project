package Client;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.Naming;
import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StartClient {

	public static Tree input(Tree tree, int n, JSONObject obj) {

		if (obj.get("type").toString().equals("file")) {

		} else {

			JSONArray a = (JSONArray) obj.get("subDir");
			for (Object o : a) {
				JSONObject obj1 = (JSONObject) o;
				TreeItem treeItem0 = new TreeItem(tree, 0);
				input_(treeItem0, n + 1, obj1);
			}
		}
		return tree;
	}

	public static void input_(TreeItem treeitem, int n, JSONObject obj) {
		treeitem.setText(obj.get("name").toString());
		treeitem.setData(obj);
		if (obj.get("type").toString().equals("file")) {

		} else {
			System.out.println("heree");
			JSONArray a = (JSONArray) obj.get("subDir");
			for (Object o : a) {
				JSONObject obj1 = (JSONObject) o;
				TreeItem treeItem0 = new TreeItem(treeitem, 0);
				input_(treeItem0, n + 1, obj1);
			}

		}

	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Tree Example");

		final Text text = new Text(shell, SWT.BORDER);
		text.setBounds(0, 270, 290, 25);

		Tree tree = new Tree(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tree.setBounds(0, 0, 290, 260);
		shell.setSize(300, 330);

		String name = "dir";
		try {
			Client.ServerInterface fi = (Client.ServerInterface) Naming.lookup(name);
			JSONObject obj = (JSONObject) fi.printFnames("/home/arjun/Documents/eclipse/workspace/MyLayout/");
			System.out.println("json object=" + obj);
			TimeUnit.SECONDS.sleep(3);
			tree = input(tree, 0, obj);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		tree.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					String string = "";
					// JSONObject o = (JSONObject)tree.getSelection();
					/*
					 * TreeItem[] selection = tree.getSelection(); for (int i =
					 * 0; i < selection.length; i++) string +=
					 * selection[i].getText().toString() + " ";
					 * System.out.println("Selection={" + string + "}");
					 */
					TreeItem item = (TreeItem) event.item;
					TreeItem t;
					String path = item.getText();

					t = item.getParentItem();
					while (t != null) {
						path = t.getText() + "\\" + path;
						t = t.getParentItem();
					}
					System.out.println(path);

					// text.setText(o.get("name").toString() + " was checked.");
				} else {
					text.setText(event.item + " was selected");
				}
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
