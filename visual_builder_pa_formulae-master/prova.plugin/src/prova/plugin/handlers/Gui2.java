package prova.plugin.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import model.Check;
import model.Context;
import model.Do;
import model.Evl;

public class Gui2 {
	Menu menu,menu2;
	
	MenuItem item1,item2,item3,r1,r2,r3;
	private Evl evl;
	public void createGui(Composite s) {
		
		
		s.setLayout(new FormLayout());
		s.setSize(800, 600);

		FormLayout fLayout = new FormLayout();
		fLayout.marginHeight = 5;
		fLayout.marginWidth = 5;
		fLayout.marginTop = 15;
		fLayout.marginBottom = 5;
		s.setLayout(fLayout);
		
		Composite outer = new Composite(s, SWT.BORDER);
		//outer.setBackground(new Color(null, 207, 255, 206)); // Green

		FormLayout formLayout = new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		formLayout.spacing = 5;
		formLayout.marginTop=5;
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
		

		Tree tree = new Tree(innerLeft, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
		FormData fdTree = new FormData();
		fdTree.top = new FormAttachment(0);
		fdTree.left = new FormAttachment(0);
		fdTree.right = new FormAttachment(90);
		fdTree.bottom = new FormAttachment(100);
		tree.setLayoutData(fdTree);
		evl = GenerateSampleEvl();
		tree.setData(evl);
		fillTree(tree,evl );
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				Tree tempTree = (Tree) e.getSource();
				if (tempTree.getItem(new Point(e.x, e.y)) != null){
				    // an item was clicked.
				}else{
				    tree.deselectAll();
				}
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		innerRight.setLayout(new FormLayout());
		//innerRight.setBackground(new Color(null, 255, 235, 223)); // Orange

		FormData fData2 = new FormData();
		fData2.top = new FormAttachment(0);
		fData2.left = new FormAttachment(innerLeft);
		fData2.right = new FormAttachment(100);
		fData2.bottom = new FormAttachment(80);
		innerRight.setLayoutData(fData2);
		
		Composite right1 = new Composite(innerRight, SWT.BORDER);
		right1.setLayout(new FormLayout());
		right1.setBackground(new Color(null, 0, 255, 0));
		FormData formDatar1 = new FormData();
		formDatar1.top = new FormAttachment(0);
		formDatar1.left = new FormAttachment(0);
		formDatar1.right = new FormAttachment(50);
		formDatar1.bottom = new FormAttachment(100);
		right1.setLayoutData(formDatar1);
		
		Composite right2 = new Composite(innerRight, SWT.BORDER);
		right2.setLayout(new FormLayout());
		right2.setBackground(new Color(null, 4, 231, 255));
		FormData formDatar2 = new FormData();
		formDatar2.top = new FormAttachment(0);
		formDatar2.left = new FormAttachment(right1,10);
		formDatar2.right = new FormAttachment(100);
		formDatar2.bottom = new FormAttachment(100);
		
		
		right2.setLayoutData(formDatar2);
		
		
		Composite checkComp = new Composite(right1, SWT.BORDER);
		checkComp.setLayout(new FormLayout());
		checkComp.setBackground(new Color(null, 255, 113, 4));
		FormData checkFormData = new FormData();
		checkFormData.top = new FormAttachment(0);
		checkFormData.left = new FormAttachment(0);
		checkFormData.right = new FormAttachment(100);
		checkFormData.bottom = new FormAttachment(45);
		checkComp.setLayoutData(checkFormData);
		

		Composite doComp = new Composite(right1, SWT.BORDER);
		doComp.setLayout(new FormLayout());
		doComp.setBackground(new Color(null, 100, 100, 100));
		FormData doFormData = new FormData();
		doFormData.top = new FormAttachment(checkComp,10);
		doFormData.left = new FormAttachment(0);
		doFormData.right = new FormAttachment(100);
		doFormData.bottom = new FormAttachment(100);
		doComp.setLayoutData(doFormData);
		
		
		
		
		

		Composite innerBottom = new Composite(outer, SWT.BORDER);
		innerBottom.setLayout(new FormLayout());
		//innerBottom.setBackground(new Color(null, 255, 0, 0));// Red

		FormData fData3 = new FormData();
		
		fData3.top = new FormAttachment(innerLeft,5);
		fData3.bottom = new FormAttachment(100);
		
		fData3.right = new FormAttachment(100);
		fData3.left = new FormAttachment(0);
		
		innerBottom.setLayoutData(fData3);
		
		Button save = new Button(innerBottom, SWT.CENTER);
		save.setText("Save");
		FormData fdBottomButton = new FormData();
		fdBottomButton.top = new FormAttachment(40);
		fdBottomButton.left = new FormAttachment(45);
		fdBottomButton.right = new FormAttachment(55);
		fdBottomButton.bottom = new FormAttachment(65);
		save.setLayoutData(fdBottomButton);		
		
		save.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(evl.toString());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
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
	                        
	                        TreeItem temp = selected[0];
	                        
	                        Context cSelected = (Context)temp.getData();
	                        
	                        
	                        Check checkToAdd = new Check(cSelected, "cNew");
	                        evl.addCheckToContext(cSelected, checkToAdd);
	                        
	                        
	                        
	                        tree.removeAll();
	                        tree.setData(evl);
	                        fillTree(tree, evl);
	                        
	                        
	                        
	                      }
	                    });
	                item2 = new MenuItem(menu, SWT.PUSH);
	                item2.setText("Add Do");
	                item2.addSelectionListener(new SelectionAdapter() {
	                	public void widgetSelected(SelectionEvent e) {
	                        
	                        TreeItem temp = selected[0];
	                        
	                        Context cSelected = (Context)temp.getData();
	                        
	                        
	                        Do d = new Do(cSelected, "doNew");
	                        evl.addDoToContext(cSelected, d);
	                        
	                        
	                        
	                        tree.removeAll();
	                        tree.setData(evl);
	                        fillTree(tree, evl);
	                        
	                        
	                        
	                      }
	                	
					});
	                
	               
					
				}
				if(string.toLowerCase().isEmpty()){
					item3 = new MenuItem(menu, SWT.PUSH);
	                item3.setText("Add Context");
	                item3.addSelectionListener(new SelectionAdapter() {
	                	public void widgetSelected(SelectionEvent e) {
	                		tree.removeAll();
	                		Context newContext = new Context("Context New", evl);
	                		evl.addContext(newContext);
	                		fillTree(tree, evl);
	                		//Context newContext = new Context("ContextNew", evl);
	                		
	                		
	                		//evl.addContext(newContext);
	                		//System.out.println(evl.toString());
	                		
	                        
	                        //tree.setData(evl);
	                        //fillTree(tree, evl);
	                		
	                		
	                	}
					});
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
				TreeItem temp = selected[0];
                
                
				menu2 = new Menu(innerLeft);
				if(string.toLowerCase().contains("context")){
					r1 = new MenuItem(menu2, SWT.PUSH);
	                r1.setText("Remove Context");
	                r1.addSelectionListener(new SelectionAdapter() {
	                	public void widgetSelected(SelectionEvent e) {
	                		Context contextTemp2 = (Context)temp.getData();
			                evl.removeContext(contextTemp2.getName());
			                tree.removeAll();
		                    tree.setData(evl);
		                    fillTree(tree, evl);
	                		
	                	}
	                	
	                	
					});
	                
				}
				if(string.toLowerCase().contains("check")){
					r2 = new MenuItem(menu2, SWT.PUSH);
	                r2.setText("Remove Check");
	                r2.addSelectionListener(new SelectionAdapter() {
	                	public void widgetSelected(SelectionEvent e) {
	                		Check checkTemp2 = (Check)temp.getData();
			                evl.removeCheckFromContext(checkTemp2.getParent(), checkTemp2);
			                tree.removeAll();
		                    tree.setData(evl);
		                    fillTree(tree, evl);
	                		
	                	}
	                	
	                	
					});
	                
					
				
				}
				if(string.toLowerCase().contains("do")){
					r3 = new MenuItem(menu2, SWT.PUSH);
	                r3.setText("Remove Do");
	                r3.addSelectionListener(new SelectionAdapter() {
	                	public void widgetSelected(SelectionEvent e) {
	                		Do DoTemp2 = (Do)temp.getData();
			                evl.removeDoFromContext(DoTemp2.getParent(), DoTemp2);
			                tree.removeAll();
		                    tree.setData(evl);
		                    fillTree(tree, evl);
	                		
	                	}
	                	
	                	
					});
	                
					
					
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
		
		Shell shell = (Shell)s;
		
		Menu menuBar = new Menu(shell, SWT.BAR);
        MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
        cascadeFileMenu.setText("&File");
        
        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        cascadeFileMenu.setMenu(fileMenu);
        
        shell.setMenuBar(menuBar);

        
        
		
		
		s.pack();
		
		
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
		    
		    Context context2 = new Context("context2",evl);
		    List<Check> checkList2 = new ArrayList<Check>();
		    List<Do> doList2 = new ArrayList<Do>();
		    Check check12 = new Check(context2, "c1");
		    Check check22 = new Check(context2, "c2");
		    checkList2.add(check12);
		    checkList2.add(check22);
		    Do d12 = new Do(context2, "do1");
		    Do d22 = new Do(context2, "do2");
		    doList2.add(d12);
		    doList2.add(d22);
		    context2.setCheckList(checkList2, evl);
		    context2.setDoList(doList2, evl);
		    
		    
		    clist.add(context2);
		    
		    
		    evl.setContextList(clist);
		   return evl;
	 }
}
