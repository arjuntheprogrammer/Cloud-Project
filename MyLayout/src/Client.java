import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.Naming;

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

public class Client {

	/*
	 * public static JSONObject printFnames(String sDir) throws
	 * NullPointerException { File dir=new File(sDir); JSONObject obj= new
	 * JSONObject(); //System.out.println(dir.getAbsolutePath());
	 * if(dir.isFile()) { obj.put("type","file"); obj.put("name",
	 * dir.getName());
	 * 
	 * } else if(dir.isDirectory()) { JSONArray ja = new JSONArray();
	 * 
	 * File[] faFiles = dir.listFiles();
	 * 
	 * for(File file: faFiles) { try{
	 * ja.add(printFnames(file.getAbsolutePath())); } catch(Exception e){
	 * 
	 * } }
	 * 
	 * obj.put("type","directory"); obj.put("name", dir.getName());
	 * obj.put("subDir", ja); } return obj;
	 * 
	 * 
	 * }
	 */
	public static byte[] FileToByte(String fileName) {

		try {

			File file = new File(fileName);
			byte buffer[] = new byte[(int) file.length()];

			BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));

			input.read(buffer, 0, buffer.length);
			input.close();
			return (buffer);

		} catch (Exception e) {

			// System.out.println(Implement.getMessage());

			e.printStackTrace();

			return (null);

		}

	}

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
			Interface fi = (Interface) Naming.lookup(name);
			// JSONObject obj = (JSONObject)fi.printFnames
			// ("/home/arjun/Documents/eclipse/workspace/MyLayout/");
			// System.out.println("json object="+obj);
			// TimeUnit.SECONDS.sleep(3);
			// tree=input(tree,0, obj);

			byte[] filedata = fi.downloadFile("a1.txt");
			File file = new File("/home/arjun/Documents/eclipse/workspace/Download.txt");
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file.getName()));

			output.write(filedata, 0, filedata.length);
			output.flush();
			output.close();

			byte[] filedata1 = FileToByte("Server.policy");
			fi.uploadFile(filedata1, "name");

		} catch (Exception e) {
			System.out.println("Here" + e);
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
