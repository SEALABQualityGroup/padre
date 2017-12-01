package prova.plugin.handlers;

import org.eclipse.jface.viewers.CellEditor.LayoutData;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import model.Check;
import model.Context;
import model.Do;
import model.Evl;

public class Gui {
	
	
	public  void createGui(Composite s){
		Button add,remove;
		s.setLayout(new GridLayout(1, true));
		s.setSize(800,600);
		s.setLocation(10,10);
		
	  
	    Tree tree = new Tree(s, SWT.SINGLE | SWT.BORDER);
	    /* GridData g = new GridData(SWT.LEFT, SWT.FILL, false, false);
	    tree.setLayoutData(g);*/
		
	    //fillTree2(tree);
	    //fillTree(tree, GenerateSampleEvl());
	    		
		/*Composite b = new Composite(s, SWT.NONE);
		b.setLayout(new GridLayout(1, true));
		b.setLocation(new Point(160, 10));		
		add = new Button(b, SWT.FILL|SWT.PUSH);
		
		add.setText("+");
		add.setSize(20,20);
		remove = new Button(b, SWT.FILL|SWT.PUSH);
		remove.setText("-");
		remove.setSize(20, 20);
		b.pack();
		*/
		
		
		
		tree.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
					TreeItem[] selected = tree.getSelection();
					String string="";
					for(TreeItem t : selected){
						string+=t;
					}
					if(string.toLowerCase().contains("context")){
						System.out.println("context");
						
					}
					if(string.toLowerCase().contains("check")){
						System.out.println("check");
					}
					if(string.toLowerCase().contains("do")){
						System.out.println("do");
					}
				
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println(e.toString());
				
			}
		});
		
		
		
	/*
		
		Composite bottom = new Composite(s, SWT.NONE);
		bottom.setLayout(new GridLayout(1, false));
		Button enter = new Button(bottom, SWT.PUSH);
		enter.setText("Enter");
		GridData gridDataButton = new GridData(GridData.CENTER, GridData.CENTER, false, false);
		gridDataButton.horizontalSpan = 3;
		gridDataButton.verticalAlignment=SWT.END;
		bottom.setLayoutData(gridDataButton);
		
	*/	
		
		
		
		
		
		
	}
	 private static void fillTree(Tree tree, Evl evl) {
		 tree.setRedraw(false);
		 for(Context c : evl.getContextList()){
			 TreeItem item = new TreeItem(tree, SWT.NONE);
		     item.setText("Context " + c.getName());
		     for(Check check : c.getCheckList()){
		    	 TreeItem child = new TreeItem(item, SWT.NONE);
			     child.setText("check "+check.getName());
		     }
		     for(Do d : c.getDoList()){
		    	 TreeItem child = new TreeItem(item, SWT.NONE);
 		         child.setText("do " + d.getName());
		     }
		 }
		 tree.setRedraw(true);
		 	
	}
	 public static void fillTree2(Tree tree){
		 // Turn off drawing to avoid flicker
		    tree.setRedraw(false);

		    // Create five root items
		    for (int i = 0; i < 5; i++) {
		      TreeItem item = new TreeItem(tree, SWT.NONE);
		      item.setText("Root Item " + i);

		      // Create three children below the root
		      for (int j = 0; j < 3; j++) {
		        TreeItem child = new TreeItem(item, SWT.NONE);
		        child.setText("Child Item " + i + " - " + j);

		        // Create three grandchildren under the child
		        for (int k = 0; k < 3; k++) {
		          TreeItem grandChild = new TreeItem(child, SWT.NONE);
		          grandChild.setText("Grandchild Item " + i + " - " + j + " - " + k);
		        }
		      }
		    }
		    // Turn drawing back on!
		    tree.setRedraw(true);
	 }
	 public static Evl GenerateSampleEvl (){
		 Evl evl = new Evl();
		 Context context = new Context("context1",evl);
		    List<Check> checkList = new ArrayList<Check>();
		    List<Do> doList = new ArrayList<Do>();
		    Check check1 = new Check(context, "c1");
		    Check check2 = new Check(context, "c2");
		    checkList.add(check1);
		    checkList.add(check2);
		    Do d1 = new Do(context, "do1");
		    Do d2 = new Do(context, "do2");
		    doList.add(d1);
		    doList.add(d2);
		    context.setCheckList(checkList, evl);
		    context.setDoList(doList, evl);
		    
		    List<Context> clist = new ArrayList<Context>();
		    clist.add(context);
		    evl.setContextList(clist);
		   return evl;
	 }
	 

}
