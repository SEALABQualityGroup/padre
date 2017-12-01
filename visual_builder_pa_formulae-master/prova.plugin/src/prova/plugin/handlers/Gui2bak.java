package prova.plugin.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ArmEvent;
import org.eclipse.swt.events.ArmListener;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import model.Check;
import model.Context;
import model.Do;
import model.Evl;

public class Gui2bak {
	Menu menu,menu2;
	MenuItem item1,item2,item3,r1;
	private Evl evl;
	public void createGui(Composite s) {
		
		
		s.setLayout(new FormLayout());
		s.setSize(800, 600);

		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 5;
		fillLayout.marginWidth = 5;
		s.setLayout(fillLayout);

		Composite outer = new Composite(s, SWT.BORDER);
		outer.setBackground(new Color(null, 207, 255, 206)); // Green

		FormLayout formLayout = new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		formLayout.spacing = 5;
		outer.setLayout(formLayout);

		Composite innerLeft = new Composite(outer, SWT.BORDER);
		innerLeft.setLayout(new FormLayout());
		//innerLeft.setBackground(new Color(null, 232, 223, 255)); // Blue
		
		FormData fData = new FormData();
		fData.top = new FormAttachment(0);
		fData.left = new FormAttachment(0);
		fData.right = new FormAttachment(40); // Locks on 40% of the view
		fData.bottom = new FormAttachment(80);
		innerLeft.setLayoutData(fData);
		

		Tree tree = new Tree(innerLeft, SWT.SINGLE | SWT.BORDER);
		FormData fdTree = new FormData();
		fdTree.top = new FormAttachment(0);
		fdTree.left = new FormAttachment(0);
		fdTree.right = new FormAttachment(90);
		fdTree.bottom = new FormAttachment(100);
		tree.setLayoutData(fdTree);
		evl = GenerateSampleEvl();
		tree.setData(evl);
		fillTree(tree,evl );
		
		Composite buttonsComp = new Composite(innerLeft, SWT.NONE);
		buttonsComp.setLayout(new FormLayout());
		

	    FormData fdButtons = new FormData();
	    fdButtons.top = new FormAttachment(0);
	    fdButtons.left = new FormAttachment(tree,10);
		fdButtons.right = new FormAttachment(100);
		fdButtons.bottom = new FormAttachment(30);
		buttonsComp.setLayoutData(fdButtons);
		
		Button button1 = new Button(buttonsComp, SWT.PUSH);
	    button1.setText("+");
	    Button button2 = new Button(buttonsComp, SWT.PUSH);
	    button2.setText("-");
		FormData f1 = new FormData();
		f1.height=20;
		f1.width=20;
		
		
		FormData f2 = new FormData();
		
		f2.top = new FormAttachment(button1,5);
		f2.height=20;
		f2.width=20;
		
		button1.setLayoutData(f1);
		button2.setLayoutData(f2);
		
		Composite innerRight = new Composite(outer, SWT.BORDER);
		innerRight.setLayout(fillLayout);
		innerRight.setBackground(new Color(null, 255, 235, 223)); // Orange

		FormData fData2 = new FormData();
		fData2.top = new FormAttachment(0);
		fData2.left = new FormAttachment(innerLeft);
		fData2.right = new FormAttachment(100);
		fData2.bottom = new FormAttachment(80);
		innerRight.setLayoutData(fData2);

		Composite innerBottom = new Composite(outer, SWT.BORDER);
		innerBottom.setLayout(fillLayout);
		innerBottom.setBackground(new Color(null, 255, 0, 0));

		FormData fData3 = new FormData();
		
		fData3.top = new FormAttachment(innerLeft,5);
		fData3.bottom = new FormAttachment(100);
		
		fData3.right = new FormAttachment(100);
		fData3.left = new FormAttachment(0);
		
		innerBottom.setLayoutData(fData3);
		
		
		
		
		button1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stubsuper.widgetSelected(e);
                
				TreeItem[] selected = tree.getSelection();
				String string="";
				for(TreeItem t : selected){
					string+=t;
				}
				menu = new Menu(innerLeft);
				if(string.toLowerCase().contains("context")){
					
					item1 = new MenuItem(menu, SWT.PUSH);
	                item1.setText("Add Check");
	                item1.addSelectionListener(new SelectionAdapter() {
	                    

						public void widgetSelected(SelectionEvent e) {
	                        System.out.println("add check");
	                        TreeItem temp = selected[0];
	                        
	                        Context cSelected = (Context)temp.getData();
	                        System.out.println(cSelected.toString());
	                        
	                        Check checkToAdd = new Check(cSelected, "cNew");
	                        evl.addCheckToContext(cSelected, checkToAdd);
	                        
	                        
	                        tree.clearAll(true);
	                        tree.removeAll();
	                        tree.setData(evl);
	                        fillTree(tree, evl);
	                        
	                        
	                        
	                      }
	                    });
	                item2 = new MenuItem(menu, SWT.PUSH);
	                item2.setText("Add Do");
	                item2.addSelectionListener(new SelectionAdapter() {
	                	public void widgetSelected(SelectionEvent e) {
	                        System.out.println("add do");
	                        TreeItem temp = selected[0];
	                        
	                        Context cSelected = (Context)temp.getData();
	                        System.out.println(cSelected.toString());
	                        
	                        Do d = new Do(cSelected, "doNew");
	                        evl.addDoToContext(cSelected, d);
	                        
	                        
	                        tree.clearAll(true);
	                        tree.removeAll();
	                        tree.setData(evl);
	                        fillTree(tree, evl);
	                        
	                        
	                        
	                      }
	                	
					});
	                
	               
					
				}
				if(string.toLowerCase().isEmpty()){
					item1 = new MenuItem(menu, SWT.PUSH);
	                item1.setText("Add Context");
				}
				
				
				
                Point loc = button1.getLocation();
                Rectangle rect = button1.getBounds();

                Point mLoc = new Point(loc.x-1, loc.y+rect.height);

                menu.setLocation(s.getDisplay().map(button1.getParent(), null, mLoc));

                menu.setVisible(true);
                
                
                
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		button2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] selected = tree.getSelection();
				String string="";
				for(TreeItem t : selected){
					string+=t;
				}
				menu2 = new Menu(innerLeft);
				if(string.toLowerCase().contains("context")){
					r1 = new MenuItem(menu2, SWT.PUSH);
	                r1.setText("Remove Context");
				}
				if(string.toLowerCase().contains("check")){
					r1 = new MenuItem(menu2, SWT.PUSH);
	                r1.setText("Remove Check");
					
				
				}
				if(string.toLowerCase().contains("do")){
					r1 = new MenuItem(menu2, SWT.PUSH);
	                r1.setText("Remove Do");
	                
					
					
				}
				
				
				Point loc2 = button2.getLocation();
                Rectangle rect2 = button2.getBounds();

                Point mLoc2 = new Point(loc2.x-1, loc2.y+rect2.height);

                menu2.setLocation(s.getDisplay().map(button2.getParent(), null, mLoc2));

                menu2.setVisible(true);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	private static void fillTree(Tree tree, Evl evl) {
		 tree.setRedraw(false);
		 for(Context c : evl.getContextList()){
			 TreeItem item = new TreeItem(tree, SWT.NONE);
		     item.setText("Context " + c.getName());
		     item.setData(c);
		     for(Check check : c.getCheckList()){
		    	 TreeItem child = new TreeItem(item, SWT.NONE);
			     child.setText("check "+check.getName());
			     child.setData(check);
		     }
		     for(Do d : c.getDoList()){
		    	 TreeItem child = new TreeItem(item, SWT.NONE);
		         child.setText("do " + d.getName());
		         child.setData(d);
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
