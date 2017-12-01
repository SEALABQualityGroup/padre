package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import dialogs.MyTitleAreaDialogCont;
import dialogs.MyTitleAreaDialogCrit;
import dialogs.MyTitleAreaDialogFixTitle;
import dialogs.MyTitleAreaDialogMessage;
import dialogs.MyTitleAreaDialogNewProject;
import listeners.ExitMenuItemListener;
import listeners.port2eplListener;
import listeners.port2ewlListener;
import model.BinaryPredicate;
import model.BinaryPredicateOperator;
import model.Check;
import model.Constraint;
import model.Container;
import model.Context;
import model.Critique;
import model.Do;
import model.Evl;
import model.Fix;
import model.GuardOperator;
import model.Message;
import model.Operation;
import model.Predicate;
import model.Threshold;
import model.Title;
import model.UnaryOperator;
import model.UnaryPredicate;
import plugin.handlers.ProjectManagment;
import model.F;
import model.Db;

/** *
 *main gui
 */
public class Gui {
	private Menu menu, menu2;

	private MenuItem removeContextMenuItem, removeCheckMenuItem,  removeFixItem, removeCritiqueItem,
			removeMessageItem, removeTitleItem;
	private MenuItem addTitleMenuItem, addCritiqueMenuItem, addFixMenuItem, addMessageMenuItem, addCheckMenuItem,
			 addContextMenuItem;

	private Evl evl;
	List<F> listF = new ArrayList<F>();

	public void createGui(Composite s) {
		
		Shell shell = (Shell) s;
		shell.setLayout(new FormLayout());
		shell.setSize(1024, 768);
		

		FormLayout fLayout = new FormLayout();
		fLayout.marginHeight = 5;
		fLayout.marginWidth = 5;
		fLayout.marginTop = 15;
		fLayout.marginBottom = 5;
		shell.setLayout(fLayout);

		Composite outer = new Composite(shell, SWT.BORDER);

		FormLayout formLayout = new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		formLayout.spacing = 5;
		formLayout.marginTop = 5;
		outer.setLayout(formLayout);
		//left composite 
		Composite innerLeft = new Composite(outer, SWT.BORDER);
		innerLeft.setLayout(new FormLayout());

		FormData fData = new FormData();
		fData.top = new FormAttachment(0);
		fData.left = new FormAttachment(0);
		fData.right = new FormAttachment(40); // Locks on 40% of the view
		fData.bottom = new FormAttachment(65);
		innerLeft.setLayoutData(fData);
		//tree for representing the evl file hierarchy
		Tree tree = new Tree(innerLeft, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
		FormData fdTree = new FormData();
		fdTree.top = new FormAttachment(0);
		fdTree.left = new FormAttachment(0);
		fdTree.right = new FormAttachment(90);
		fdTree.bottom = new FormAttachment(100);
		tree.setLayoutData(fdTree);
		//evl object 
		evl = new Evl();
		tree.setData(evl);
		//composite which will contain the buttons for managing the tree
		Composite buttonsComp = new Composite(innerLeft, SWT.NONE);
		buttonsComp.setLayout(new FormLayout());
		//buttons form data for specify their location
		FormData fdButtons = new FormData();
		fdButtons.top = new FormAttachment(0);
		fdButtons.left = new FormAttachment(tree, 10);
		fdButtons.right = new FormAttachment(100);
		fdButtons.bottom = new FormAttachment(30);
		buttonsComp.setLayoutData(fdButtons);

		Button button1 = new Button(buttonsComp, SWT.PUSH);
		button1.setText("+");
		Button button2 = new Button(buttonsComp, SWT.PUSH);
		button2.setText("-");
		Button button3 = new Button(buttonsComp, SWT.PUSH);
		button3.setText("<");
		button3.setEnabled(false);
		Button button4 = new Button(buttonsComp, SWT.PUSH);
		button4.setText(">");
		button4.setEnabled(false);

		FormData f1 = new FormData();
		f1.height = 20;
		f1.width = 20;

		FormData f2 = new FormData();

		f2.top = new FormAttachment(button1, 5);
		f2.height = 20;
		f2.width = 20;

		FormData f3 = new FormData();
		f3.top = new FormAttachment(button2, 5);
		f3.height = 20;
		f3.width = 20;

		FormData f4 = new FormData();
		f4.top = new FormAttachment(button3, 5);
		f4.height = 20;
		f4.width = 20;

		button1.setLayoutData(f1);
		button2.setLayoutData(f2);
		button3.setLayoutData(f3);
		button4.setLayoutData(f4);
		//right composite for the Check and Do areas
		Composite innerRight = new Composite(outer, SWT.BORDER);
		innerRight.setLayout(new FormLayout());

		FormData fData2 = new FormData();
		fData2.top = new FormAttachment(0);
		fData2.left = new FormAttachment(innerLeft);
		fData2.right = new FormAttachment(100);
		fData2.bottom = new FormAttachment(65);
		innerRight.setLayoutData(fData2);

		Composite right1 = new Composite(innerRight, SWT.BORDER);
		right1.setLayout(new FormLayout());
		FormData formDatar1 = new FormData();
		formDatar1.top = new FormAttachment(0);
		formDatar1.left = new FormAttachment(0);
		formDatar1.right = new FormAttachment(100);
		formDatar1.bottom = new FormAttachment(100);
		right1.setLayoutData(formDatar1);
		//this composite will contains the list of GuardOperators,F,operators,Thresholds
		Composite checkComp = new Composite(right1, SWT.BORDER);
		checkComp.setLayout(new FormLayout());
		FormData checkFormData = new FormData();
		checkFormData.top = new FormAttachment(0);
		checkFormData.left = new FormAttachment(0);
		checkFormData.right = new FormAttachment(100);
		checkFormData.bottom = new FormAttachment(45);
		checkComp.setLayoutData(checkFormData);
		//guard op
		Composite guardOpComposite = new Composite(checkComp, SWT.NONE);
		FormData guardOpCompositeFormData = new FormData();
		guardOpCompositeFormData.top = new FormAttachment(0);
		guardOpCompositeFormData.left = new FormAttachment(0);
		guardOpCompositeFormData.right = new FormAttachment(15);
		guardOpCompositeFormData.bottom = new FormAttachment(100);

		guardOpComposite.setLayoutData(guardOpCompositeFormData);

		guardOpComposite.setLayout(new FormLayout());
		org.eclipse.swt.widgets.List guardOpList = new org.eclipse.swt.widgets.List(guardOpComposite,
				SWT.BORDER | SWT.V_SCROLL);
		Label guardOpLabel = new Label(guardOpComposite, SWT.NULL);

		FormData guardOpListFormData = new FormData();
		guardOpListFormData.top = new FormAttachment(10);
		guardOpListFormData.left = new FormAttachment(1);
		guardOpListFormData.right = new FormAttachment(99);
		guardOpListFormData.bottom = new FormAttachment(99);
		guardOpList.setLayoutData(guardOpListFormData);

		FormData guardOpLabelFormData = new FormData();
		guardOpLabelFormData.bottom = new FormAttachment(guardOpList);
		guardOpLabelFormData.left = new FormAttachment(5);
		guardOpLabel.setLayoutData(guardOpLabelFormData);
		guardOpLabel.setText("Op");

		guardOpList.add(GuardOperator.AND.toString());
		guardOpList.add(GuardOperator.OR.toString());
		guardOpList.add(GuardOperator.XOR.toString());
		guardOpList.add(GuardOperator.EMPTY.toString());
		//F
		Composite fComposite = new Composite(checkComp, SWT.NONE);
		FormData fCompositeFormData = new FormData();
		fCompositeFormData.top = new FormAttachment(0);
		fCompositeFormData.left = new FormAttachment(guardOpComposite);
		fCompositeFormData.right = new FormAttachment(55);
		fCompositeFormData.bottom = new FormAttachment(100);
		fComposite.setLayoutData(fCompositeFormData);

		fComposite.setLayoutData(fCompositeFormData);

		fComposite.setLayout(new FormLayout());

		Label fLabel = new Label(fComposite, SWT.NULL);
		fLabel.setText("F");
		org.eclipse.swt.widgets.List fList = new org.eclipse.swt.widgets.List(fComposite, SWT.BORDER | SWT.V_SCROLL);

		FormData fListFormData = new FormData();
		fListFormData.top = new FormAttachment(10);
		fListFormData.left = new FormAttachment(1);
		fListFormData.right = new FormAttachment(99);
		fListFormData.bottom = new FormAttachment(99);
		fList.setLayoutData(fListFormData);

		FormData fLabelFormData = new FormData();
		fLabelFormData.left = new FormAttachment(5);
		fLabelFormData.bottom = new FormAttachment(fList);

		fLabel.setLayoutData(fLabelFormData);
		//op
		Composite opComposite = new Composite(checkComp, SWT.NONE);
		FormData opCompositeFormData = new FormData();
		opCompositeFormData.top = new FormAttachment(0);
		opCompositeFormData.left = new FormAttachment(fComposite);
		opCompositeFormData.right = new FormAttachment(70);
		opCompositeFormData.bottom = new FormAttachment(100);
		opComposite.setLayoutData(opCompositeFormData);

		opComposite.setLayout(new FormLayout());
		org.eclipse.swt.widgets.List opList = new org.eclipse.swt.widgets.List(opComposite, SWT.BORDER | SWT.V_SCROLL);
		Label opLabel = new Label(opComposite, SWT.NULL);
		opLabel.setText("Operators");

		FormData opListFormData = new FormData();
		opListFormData.top = new FormAttachment(10);
		opListFormData.left = new FormAttachment(1);
		opListFormData.right = new FormAttachment(99);
		opListFormData.bottom = new FormAttachment(99);
		opList.setLayoutData(opListFormData);

		FormData opLabelFormData = new FormData();
		opLabelFormData.bottom = new FormAttachment(opList);
		opLabelFormData.left = new FormAttachment(5);
		opLabel.setLayoutData(opLabelFormData);
		//Thresholds
		Composite thComposite = new Composite(checkComp, SWT.NONE);
		FormData thCompositeFormData = new FormData();
		thCompositeFormData.top = new FormAttachment(0);
		thCompositeFormData.left = new FormAttachment(opComposite);
		thCompositeFormData.right = new FormAttachment(100);
		thCompositeFormData.bottom = new FormAttachment(100);
		thComposite.setLayoutData(thCompositeFormData);

		thComposite.setLayoutData(thCompositeFormData);

		thComposite.setLayout(new FormLayout());

		org.eclipse.swt.widgets.List thList = new org.eclipse.swt.widgets.List(thComposite,
				SWT.BORDER | SWT.V_SCROLL | DND.DROP_COPY);
		FormData thListFormData = new FormData();
		thListFormData.top = new FormAttachment(10);
		thListFormData.left = new FormAttachment(1);
		thListFormData.right = new FormAttachment(99);
		thListFormData.bottom = new FormAttachment(99);
		thList.setLayoutData(thListFormData);

		Label thLabel = new Label(thComposite, SWT.NULL);
		thLabel.setText("Thresholds");
		FormData thLabelFormData = new FormData();
		thLabelFormData.left = new FormAttachment(5);
		thLabelFormData.bottom = new FormAttachment(thList);
		thLabel.setLayoutData(thLabelFormData);

		checkComp.pack();
		//do
		Composite doComp = new Composite(right1, SWT.BORDER);
		doComp.setLayout(new FormLayout());

		FormData doFormData = new FormData();
		doFormData.top = new FormAttachment(checkComp, 10);
		doFormData.left = new FormAttachment(0);
		doFormData.right = new FormAttachment(100);
		doFormData.bottom = new FormAttachment(100);
		doComp.setLayoutData(doFormData);

		org.eclipse.swt.widgets.List doList = new org.eclipse.swt.widgets.List(doComp, SWT.BORDER | SWT.V_SCROLL);
		Label doLabel = new Label(doComp, SWT.NONE);
		doLabel.setText("Do");

		FormData doListFormData = new FormData();
		doListFormData.top = new FormAttachment(10);
		doListFormData.left = new FormAttachment(5);
		doListFormData.right = new FormAttachment(95);
		doListFormData.bottom = new FormAttachment(95);
		doList.setLayoutData(doListFormData);

		FormData doLabelFormData = new FormData();
		doLabelFormData.left = new FormAttachment(20);
		doLabelFormData.bottom = new FormAttachment(doList);
		doLabel.setLayoutData(doLabelFormData);
		//Console composite
		Composite innerBottom = new Composite(outer, SWT.BORDER);
		innerBottom.setLayout(new FormLayout());

		FormData fData3 = new FormData();

		fData3.top = new FormAttachment(innerLeft, 5);
		fData3.bottom = new FormAttachment(100);

		fData3.right = new FormAttachment(100);
		fData3.left = new FormAttachment(0);

		innerBottom.setLayoutData(fData3);

		Text console = new Text(innerBottom, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		console.setEditable(false);
		
		
		FormData fdBottom = new FormData();
		fdBottom.top = new FormAttachment(0);
		fdBottom.left = new FormAttachment(0);
		fdBottom.right = new FormAttachment(100);
		fdBottom.bottom = new FormAttachment(100);
		console.setLayoutData(fdBottom);
		console.setBackground(new Color(null, 0, 0, 0));
		console.setForeground(new Color(null, 0, 255, 0));	
		//add a listener to the 'button1', the button for adding elements to the tree hierarchy
		button1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				TreeItem[] selected = tree.getSelection();
				// TreeItem itemSelected = selected[0];
				String string = "";
				for (TreeItem t : selected) {
					string += t;
				}
				menu = new Menu(innerLeft);
				//Check which element of the tree has been selected by comparing its label with the specified keyword
				if ((string.toLowerCase().contains("critique")) || ((string.toLowerCase().contains("constraint")))) {
					//if an invariant tree item is selected , it's enabled to set check, set message and add fix
					//the evl associated to the tree is updated acording to the user selection
					addCheckMenuItem = new MenuItem(menu, SWT.PUSH);
					addCheckMenuItem.setText("Set Check");
					addCheckMenuItem.addSelectionListener(new SelectionAdapter() {

						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							Context contParent = (Context) parent.getData();
							Container cSelected = (Container) temp.getData();

							Check checkNew = new Check();
							// cSelected.setCheck(checkNew);
							for (Context c : evl.getContextList()) {
								if (c.equals(contParent)) {
									for (Container container : c.getContainers()) {
										if (container.equals(cSelected)) {
											container.setCheck(checkNew);
										}
									}
								}
							}
							// evl.setCheckToContainer(cSelected.getParent(),
							// cSelected, checkNew);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

					addMessageMenuItem = new MenuItem(menu, SWT.PUSH);
					addMessageMenuItem.setText("Add Message");
					addMessageMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							Context contParent = (Context) parent.getData();
							Container cSelected = (Container) temp.getData();

							String txtMsg = "";
							MyTitleAreaDialogMessage dialogMessage = new MyTitleAreaDialogMessage(shell);
							dialogMessage.create();
							if (dialogMessage.open() == Window.OK) {
								txtMsg = dialogMessage.getName();

							} else {
								return;
							}

							Message msg = new Message(txtMsg);
							for (Context c : evl.getContextList()) {
								if (c.equals(contParent)) {
									for (Container container : c.getContainers()) {
										if (container.equals(cSelected)) {
											container.setMessage(msg);
										}
									}
								}
							}
							// evl.setCMessage(cSelected.getParent(), cSelected,
							// msg);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

					addFixMenuItem = new MenuItem(menu, SWT.PUSH);
					addFixMenuItem.setText("Add Fix");
					addFixMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							Container cSelected = (Container) temp.getData();
							Context contextParent = (Context) parent.getData();
							Fix fixNew = new Fix();
							List<Fix> fixList = cSelected.getFixList();
							fixList.add(fixNew);
							// cSelected.setFixList(fixList);
							for (Context c : evl.getContextList()) {
								if (c.equals(contextParent)) {
									for (Container container : c.getContainers()) {
										if (container.equals(cSelected)) {
											container.setFixList(fixList);
										}
									}
								}
							}

							// evl.addFix2C(cSelected.getParent(), cSelected,
							// fixNew);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

				}
				if (string.toLowerCase().contains("fix")) {
					addTitleMenuItem = new MenuItem(menu, SWT.PUSH);
					addTitleMenuItem.setText("Set fix title");
					addTitleMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];

							Fix fixSelected = (Fix) temp.getData();
							String title = "";
							MyTitleAreaDialogFixTitle fixTitleDialog = new MyTitleAreaDialogFixTitle(shell);
							fixTitleDialog.create();
							if (fixTitleDialog.open() == Window.OK) {
								title = fixTitleDialog.getName();

							} else {
								return;
							}
							Title titleNew = new Title(title);
							fixSelected.setTitle(titleNew);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

					/*addDoMenuItem = new MenuItem(menu, SWT.PUSH);
					addDoMenuItem.setText("Add Do");
					addDoMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];
							Fix fixSelected = (Fix) temp.getData();
							Do d = new Do();
							//List<Do> doListTemp = fixSelected.getDoList();
							//doListTemp.add(d);
							fixSelected.setDoList(doListTemp);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});*/

				}
				if ((string.toLowerCase().contains("context"))) {
					addCritiqueMenuItem = new MenuItem(menu, SWT.PUSH);
					addCritiqueMenuItem.setText("Add Critique/Constraint");
					addCritiqueMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							String contName = "";
							String type = "";
							MyTitleAreaDialogCrit dialog2 = new MyTitleAreaDialogCrit(shell);
							dialog2.create();
							if (dialog2.open() == Window.OK) {
								contName = dialog2.getName();
								type = dialog2.getType();

							} else {
								return;
							}
							TreeItem temp = selected[0];
							Context contToAddParent = (Context) temp.getData();
							tree.removeAll();
							Container cont2add = null;
							if (type.equals("critique")) {
								cont2add = new Critique(contName);
							} else if (type.equals("constraint")) {
								cont2add = new Constraint(contName);
							}
							// System.out.println(cont2add.toString());
							for (Context c : evl.getContextList()) {
								if (c.equals(contToAddParent)) {
									List<Container> tempContainerList = c.getContainers();
									tempContainerList.add(cont2add);
									c.setContainer(tempContainerList);
								}
							}
							fillTreeModel2(tree, evl);

						}
					});

				}
				if (string.toLowerCase().isEmpty()) {
					addContextMenuItem = new MenuItem(menu, SWT.PUSH);
					addContextMenuItem.setText("Add Context");
					addContextMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							String contextName = "";
							MyTitleAreaDialogCont dialog = new MyTitleAreaDialogCont(shell);
							dialog.create();
							if (dialog.open() == Window.OK) {
								contextName = dialog.getName();

							} else {
								return;
							}

							tree.removeAll();

							Context cNew = new Context(contextName);
							List<Context> cList = evl.getContextList();
							cList.add(cNew);
							evl.setContextList(cList);
							// evl.addContext(cNew);

							fillTreeModel2(tree, evl);

						}
					});
				}

				Point loc = button1.getLocation();
				Rectangle rect = button1.getBounds();

				Point mLoc = new Point(loc.x - 1, loc.y + rect.height);

				menu.setLocation(shell.getDisplay().map(button1.getParent(), null, mLoc));

				menu.setVisible(true);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		//add a listener to the 'button2', the button for removing elements to the tree hierarchy
		button2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				//this listener has the same logic of the button1's selection listener
				TreeItem[] selected = tree.getSelection();
				String string = "";
				for (TreeItem t : selected) {
					string += t;
				}

				menu2 = new Menu(innerLeft);
				if (string.toLowerCase().contains("context")) {
					removeContextMenuItem = new MenuItem(menu2, SWT.PUSH);
					removeContextMenuItem.setText("Remove Context");
					removeContextMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							Context contextTemp2 = (Context) temp.getData();
							List<Context> cList = evl.getContextList();
							cList.remove(contextTemp2);
							evl.setContextList(cList);
							// evl.removeContext(contextTemp2);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				if (string.toLowerCase().contains("check")) {
					removeCheckMenuItem = new MenuItem(menu2, SWT.PUSH);
					removeCheckMenuItem.setText("Remove Check");
					removeCheckMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							TreeItem grandParent = parent.getParentItem();
							Container parentContainer = (Container) parent.getData();
							Context grandParentContext = (Context) grandParent.getData();
							// Check checkTemp2 = (Check) temp.getData();
							// Container contTtemp2 = checkTemp2.getParent();

							for (Context context : evl.getContextList()) {
								if (context.equals(grandParentContext)) {
									for (Container container : context.getContainers()) {
										if (container.equals(parentContainer)) {
											container.setCheck(null);
										}
									}
								}
							}
							// evl.removeCheck(contTtemp2.getParent(),
							// contTtemp2, checkTemp2);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				/*Do treeItem cant't be removed
				 * if (string.toLowerCase().contains("do")) {
					removeDoMenuItem = new MenuItem(menu2, SWT.PUSH);
					removeDoMenuItem.setText("Remove Do");
					removeDoMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							TreeItem grandParent = parent.getParentItem();
							TreeItem contextParent = grandParent.getParentItem();

							Do DoTemp2 = (Do) temp.getData();
							Fix fixTemp = (Fix) parent.getData();
							Container cTemp = (Container) grandParent.getData();

							for (Context context : evl.getContextList()) {
								if (context.equals(contextParent.getData())) {
									for (Container container : context.getContainers()) {
										if (container.equals(cTemp)) {
											List<Fix> fList = container.getFixList();
											for (Fix f : fList) {
												if (f.equals(fixTemp)) {
													f.getDoList().remove(DoTemp2);
												}
											}
										}

									}
								}
							}

							// evl.removeDoFromFix(cTemp.getParent(), cTemp,
							// fixTemp, DoTemp2);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}*/
				if (string.toLowerCase().contains("fix")) {
					removeFixItem = new MenuItem(menu2, SWT.PUSH);
					removeFixItem.setText("Remove Fix");
					removeFixItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							TreeItem grandParent = parent.getParentItem();
							Fix fixToDel = (Fix) temp.getData();
							Container containerParent = (Container) parent.getData();
							Context contextGrandParent = (Context) grandParent.getData();

							for (Context c : evl.getContextList()) {
								if (c.equals(contextGrandParent)) {
									for (Container container : c.getContainers()) {
										if (container.equals(containerParent)) {
											container.getFixList().remove(fixToDel);
										}
									}
								}
							}
							// evl.removeFixFromC(contTemp, critTemp, fixToDel);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				if ((string.toLowerCase().contains("critique")) || ((string.toLowerCase().contains("constraint")))) {
					removeCritiqueItem = new MenuItem(menu2, SWT.PUSH);
					removeCritiqueItem.setText("Remove Critique/Constraint");
					removeCritiqueItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							Container critToDel = (Container) temp.getData();
							Context contTemp = (Context) parent.getData();
							for (Context c : evl.getContextList()) {
								if (c.equals(contTemp)) {
									c.getContainers().remove(critToDel);
								}
							}
							// evl.removeContainer(contTemp, critToDel);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

				}
				if (string.toLowerCase().contains("message")) {
					removeMessageItem = new MenuItem(menu2, SWT.PUSH);
					removeMessageItem.setText("Remove Message");
					removeMessageItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							TreeItem grandParent = parent.getParentItem();
							// Message messageTemp = (Message) temp.getData();
							Container critTemp = (Container) parent.getData();
							Context contextTemp = (Context) grandParent.getData();

							for (Context context : evl.getContextList()) {
								if (context.equals(contextTemp)) {
									for (Container container : context.getContainers()) {
										if (container.equals(critTemp)) {
											container.setMessage(null);
										}
									}
								}
							}
							// evl.removeCMessage(critTemp.getParent(),
							// critTemp);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});
				}
				if (string.toLowerCase().contains("title")) {
					removeTitleItem = new MenuItem(menu2, SWT.PUSH);
					removeTitleItem.setText("Remove Title");
					removeTitleItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							TreeItem parent = temp.getParentItem();
							TreeItem grandParent = parent.getParentItem();
							TreeItem contextParent = grandParent.getParentItem();
							// Title titleTemp = (Title) temp.getData();
							Fix fixTemp = (Fix) parent.getData();
							Container contTemp = (Container) grandParent.getData();
							Context contextTemp = (Context) contextParent.getData();

							for (Context c : evl.getContextList()) {
								if (c.equals(contextTemp)) {
									for (Container container : c.getContainers()) {
										if (container.equals(contTemp)) {
											List<Fix> fixList = container.getFixList();
											for (Fix f : fixList) {
												if (f.equals(fixTemp)) {
													f.setTitle(null);
												}
											}
											container.setFixList(fixList);
										}
									}
								}
							}

							// evl.removeTitleFromFix(critTemp.getParent(),
							// critTemp, fixTemp);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});
				}

				Point loc2 = button2.getLocation();
				Rectangle rect2 = button2.getBounds();

				Point mLoc2 = new Point(loc2.x - 1, loc2.y + rect2.height);

				menu2.setLocation(s.getDisplay().map(button2.getParent(), null, mLoc2));

				menu2.setVisible(true);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		//topMenu
		Menu menuBar = new Menu(shell, SWT.BAR);

		MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu.setText("&File");

		MenuItem cascadeFileMenu2 = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu2.setText("&Save");
		
		MenuItem cascadeFileMenu3 = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu3.setText("&Porting");
		
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);

		Menu saveMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeFileMenu2.setMenu(saveMenu);
		
		Menu portingMenu = new Menu(shell,SWT.DROP_DOWN);
		cascadeFileMenu3.setMenu(portingMenu);

		//Saves the .evl file
		MenuItem saveEvlMenuItem = new MenuItem(saveMenu, SWT.PUSH);
		saveEvlMenuItem.setText("Save in .evl"); 
		saveEvlMenuItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				FileDialog dialog = new FileDialog(shell, SWT.SAVE);
				dialog.setText("Save EVL code...");
				dialog.setFilterNames(new String[] { "All Files (*.evl)" });
				dialog.setFilterExtensions(new String[] { "*.evl" }); 
				dialog.setFilterPath("c:\\");
				dialog.setFileName("");
				String dir = dialog.open();
				File file;
				if (dir != null)
				{
					file = new File(dir);
				}
				else 
				{
					return;
				}

				
				try {
					
					FileWriter fw;
					fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(evl.toString());
					bw.flush();
					bw.close();
					console.append("\n" + evl.toString());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					console.append("\n" + e1.getMessage() );
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		MenuItem newProjectMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		newProjectMenuItem.setText("&New Evl Project");
		//Creates a blank project
		newProjectMenuItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				MyTitleAreaDialogNewProject dialog = new MyTitleAreaDialogNewProject(shell);
				dialog.create();
				boolean confirm = false;
				if (dialog.open() == Window.OK) {
					confirm = dialog.getConfirm();

				} else {
					return;
				}

				if (confirm) {
					tree.removeAll();
					evl = new Evl();
					fillTreeModel2(tree, evl);
					console.setText("");
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		MenuItem saveItem = new MenuItem(fileMenu, SWT.PUSH);
		saveItem.setText("&Save Project");
		//save the current project in a xml file; it invokes the method Save() from the ProjectManagment class
		saveItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(shell, SWT.SAVE);
				dialog.setFilterNames(new String[] { "Xml Files (*.*xml)" });
				dialog.setFilterExtensions(new String[] { "*.xml" }); // Windows
				dialog.setFilterPath("c:\\"); // Windows path
				dialog.setFileName("");
				String dir = dialog.open();
				try {
					File evl_file = new File(dir);
					ProjectManagment.Save(evl, evl_file);
					console.append("\n Save complete ");
				} catch (JAXBException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					console.append("\n" + e1.getMessage());

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(shell, SWT.SAVE);
				dialog.setFilterNames(new String[] { "All Files (*.*)" });
				dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); // Windows
				dialog.setFilterPath("c:\\"); // Windows path
				dialog.setFileName("");
				String dir = dialog.open();
				try {
					File evl_file = new File(dir);
					ProjectManagment.Save(evl, evl_file);
				} catch (JAXBException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					console.append("\n" + e1.getMessage() );
				}

			}
		});
		
		MenuItem openProjectItem = new MenuItem(fileMenu, SWT.PUSH);
		openProjectItem.setText("&Open existing Project");
		//open a already saved project; it invokes the method Open() from the ProjectManagment class
		openProjectItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(shell);
				dlg.setText("Open Project...");
				dlg.setFilterPath("C:/");
				String[] filterExt = { "*.xml" };
				dlg.setFilterExtensions(filterExt);
				String dir = dlg.open();
				
				try {
					
					evl = ProjectManagment.Open(dir);
					console.append("\n Project opened ");
					
				} catch (FileNotFoundException | JAXBException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					console.append("\n" + e1.getMessage() );

				}
				
				tree.removeAll();
				fillTreeModel2(tree, evl);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(shell);
				dlg.setText("Open Project...");
				dlg.setFilterPath("C:/");
				String[] filterExt = { "*.xml" };
				dlg.setFilterExtensions(filterExt);
				String dir = dlg.open();
				try {
					evl = ProjectManagment.Open(dir);
				} catch (FileNotFoundException | JAXBException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					console.append("\n" + e1.getMessage() );
				}
				tree.removeAll();
				fillTreeModel2(tree, evl);

			}
		});
		
		
		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("&Exit");
		exitItem.addSelectionListener(new ExitMenuItemListener(shell));
		
		//Porting EVL to EPL
		MenuItem port2eplMenuItem = new MenuItem(portingMenu, SWT.PUSH);
		port2eplMenuItem.setText("Port EVL file to EPL");
		port2eplMenuItem.addSelectionListener(new port2eplListener(console, shell));
		
		//Porting EVL to EWL
		MenuItem port2ewlMenuItem = new MenuItem(portingMenu, SWT.PUSH);
		port2ewlMenuItem.setText("Port EVL file to EWL");
		port2ewlMenuItem.addSelectionListener(new port2ewlListener(console, shell));
		
		//this is a mouse listener for the tree
		//this listener populates the fList according to the context name and if a context is properly selected
		
		tree.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				Tree tempTree = (Tree) e.getSource();
				//checks if a tree element is selected
				if (tempTree.getItem(new Point(e.x, e.y)) != null) {
					// an item was clicked.
					TreeItem[] selected;
					TreeItem itemSelected;

					try {
						selected = tree.getSelection();
						itemSelected = selected[0];

					} catch (ArrayIndexOutOfBoundsException exception) {
						//console.append("\nSelecet correct treeItem");

						return;
					}

					TreeItem par = itemSelected.getParentItem();
					String string = itemSelected.getText();
					if (string.toLowerCase().contains("context")) {
						//if a context treeItem is selected the fList applicable to it, is recovered from db
						button3.setEnabled(false);
						button4.setEnabled(false);
						Context context = (Context) itemSelected.getData();
						List<F> fl = null;
						try {
							fl = Db.getFList(context.getName());
						} catch (ClassNotFoundException | SQLException e1) {
							// e1.printStackTrace();
							console.append("\n" + e1.getMessage() );
						}
						fList.removeAll();
						for (F f : fl) {
							fList.add(f.getText());
						}
					} else if (string.toLowerCase().contains("fix")) {
						//if a fix treeItem is selected the doList applicable to it, is recovered from db
						button3.setEnabled(true);
						button4.setEnabled(true);
						// populate doList
						//Fix fix = (Fix) itemSelected.getData();
						List<String> tempDoList = new ArrayList<String>();
						TreeItem invariant = itemSelected.getParentItem();
						TreeItem context = invariant.getParentItem();
						Context cont = (Context) context.getData();
						try {
							tempDoList = Db.getDo(cont.getName());
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						doList.setVisible(true);
						doList.removeAll();
						for (String s : tempDoList) {
							doList.add(s);

						}

					} else if (string.toLowerCase().contains("do")) {
						//if a do treeItem is selected the doList applicable to it, is recovered from db
						button3.setEnabled(true);
						button4.setEnabled(true);
						// populate doList
						List<String> tempDoList = new ArrayList<String>();
						TreeItem fixItem = itemSelected.getParentItem();
						TreeItem invariant = fixItem.getParentItem();
						TreeItem context = invariant.getParentItem();
						Context cont = (Context) context.getData();
						try {
							tempDoList = Db.getDo(cont.getName());
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						doList.setVisible(true);
						doList.removeAll();
						for (String s : tempDoList) {
							doList.add(s);

						}

					} else if ((string.toLowerCase().contains("critique"))
							|| (string.toLowerCase().contains("constraint"))) {
						//if an invariant treeItem is selected the fList applicable to it, is recovered from db
						button3.setEnabled(false);
						button4.setEnabled(false);

						TreeItem contextItem = itemSelected.getParentItem();
						Context context = (Context) contextItem.getData();

						List<F> fl = null;
						try {
							fl = Db.getFList(context.getName());
						} catch (ClassNotFoundException | SQLException e1) {
							// e1.printStackTrace();
							console.append("\n" + e1.getMessage() );
						}
						fList.removeAll();
						for (F f : fl) {
							fList.add(f.getText());
						}

					}

					else if (string.toLowerCase().contains("check")) {
						//if a check treeItem is selected the fList applicable to it, is recovered from db
						button3.setEnabled(true);
						button4.setEnabled(true);
						TreeItem invariantItem = itemSelected.getParentItem();
						TreeItem contextItem = invariantItem.getParentItem();
						Context context = (Context) contextItem.getData();

						List<F> fl = null;
						try {
							fl = Db.getFList(context.getName());
						} catch (ClassNotFoundException | SQLException e1) {
							// e1.printStackTrace();
							console.append("\n" + e1.getMessage() );
						}
						fList.removeAll();
						for (F f : fl) {
							fList.add(f.getText());
						}

					} else if ((par.getText().toLowerCase().contains("not"))||(par.getText().toLowerCase().contains("check"))) {
						button3.setEnabled(true);
						button4.setEnabled(true);
					} else {
						button3.setEnabled(false);
						button4.setEnabled(false);
					}

				} else {
					tree.deselectAll();
					fList.removeAll();
					guardOpList.deselectAll();
					opList.removeAll();
					thList.removeAll();
					doList.removeAll();
					button3.setEnabled(false);
					button4.setEnabled(false);
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
		//this listener populates the oplist, guardOpList, and threshold List
		//form the F selected from the fList; 
		//if the element returns a boolean value only the Flist, and GuardOpList are populated
		//and the opList is populated with not operator and empty op
		fList.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {

				//String string = "";
				String[] s = fList.getSelection();
				String selection = s[0];

				List<F> fListTemp = null;
				try {
					fListTemp = Db.getFList();

				} catch (ClassNotFoundException | SQLException e1) {
					console.append("\n" + e1.getMessage() );
				}
				for (F f : fListTemp) {
					// console.append(f.getCard()+f.getText()+"\n");
					//take the fList from db and find the f selected
					
					if (f.getText().equals(selection)) {
						// if the f return a boolean or not the f are populated properly 
						
						if (f.getReturnType().equals("boolean")) {
							
							// console.append(f.getText()+f.getCard());
							thList.removeAll();
							opList.removeAll();
							opList.add("");
							opList.add("!");
							// console.append("Boolean F\n");
						
						} else if (!(f.getReturnType().equals("boolean"))) {
							thList.removeAll();
							opList.removeAll();
							opList.add(">");
							opList.add(">=");
							opList.add("<");
							opList.add("<=");
							opList.add("=");
							opList.add("<>");
							List<Threshold> tList = null;
							try {
								thList.removeAll();
								tList = Db.getThresholdList(selection);
								tList.addAll(Db.getFListToCompare(selection));
							} catch (ClassNotFoundException | SQLException e1) {
								console.append("\n" + e1.getMessage() );
							}
							for (Threshold t : tList) {
								thList.add(t.getText());
							}
						}
					}
				}

			}
		});

		// add button listener
		//the button3 is the button for adding F and do
		button3.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] selectedItems;
				TreeItem item = null;
				TreeItem parentItem = null;
				int opListIndex = opList.getSelectionIndex();
				int guardOpListIndex = guardOpList.getSelectionIndex();
				
				try {
					selectedItems = tree.getSelection();
					item = selectedItems[0];
					parentItem = item.getParentItem();
				} catch (ArrayIndexOutOfBoundsException exception) {
					console.append("\nSelect the correct treeItem, check or do");
					fList.deselectAll();
					opList.deselectAll();
					guardOpList.deselectAll();
					thList.deselectAll();
					return;
				}

				String fName = "";

				if ((item.getText().toLowerCase().contains("check"))||(parentItem.getText().toLowerCase().contains("check"))) {
					Check check = null ;
					String contextName="";
					if(item.getText().toLowerCase().contains("check")){
						check = (Check) item.getData();
						TreeItem checkGrandParentItem = parentItem.getParentItem();
						Context context = (Context)checkGrandParentItem.getData();
						contextName = context.getName();
					}else if(parentItem.getText().toLowerCase().contains("check")){
						check = (Check) parentItem.getData();
						TreeItem checkParent = parentItem.getParentItem();
						TreeItem checkGrandParentItem = checkParent.getParentItem();
						Context context = (Context)checkGrandParentItem.getData();
						contextName = context.getName();
					}
					int index = fList.getSelectionIndex();
					if (index > -1) {
						try {
							fName = fList.getItem(index);
							List<F> temp;
							temp = Db.getFList(contextName);
							//
							//
							for (F f : temp) {
								if (f.getText().equals(fName)) {
									if (f.getReturnType().equals("boolean")) {
					                    UnaryOperator op = UnaryOperator.EMPTY;
															try{
																if (opList.getItem(opListIndex).equals("!")) {
																	op = UnaryOperator.NOT;
																}
															}catch(Exception e1){
																console.append("\n  "+e1.getMessage());
																break;
															}
															/*if (opList.getItem(opListIndex).equals("!")) {
																op = UnaryOperator.NOT;
															}*/
															F fBool = new F(f.getText(), f.getCard(), f.getReturnType());
															Predicate pred = new UnaryPredicate(op, fBool);
															String guardOpSelected = guardOpList.getItem(guardOpListIndex);
															GuardOperator guardOp = GuardOperator.EMPTY;
															switch (guardOpSelected) {
															case "and":
																guardOp = GuardOperator.AND;
																break;
															case "or":
																guardOp = GuardOperator.OR;
																break;
															case "xor":
																guardOp = GuardOperator.XOR;
																break;
															}
															if (!(check.getOperations().isEmpty())) {
																if (guardOp.equals(GuardOperator.EMPTY)) {
																	console.append("\nSELECT GUARD OPERATOR : can't choose Empty guard operator");
																	break;
																}
															} else if ((check.getOperations().isEmpty())
																	&& (!(guardOp.equals(GuardOperator.EMPTY)))) {
																console.append("\nFIRST PREDICATE: INSERT EMPTY GUARD OP");
																break;
															}
															Operation operation = new Operation(guardOp, pred);

															check.getOperations().add(operation);
															tree.removeAll();
															fList.deselectAll();
															opList.deselectAll();
															guardOpList.deselectAll();
															thList.deselectAll();
															fillTreeModel2(tree, evl);

									}else{
					                    					F fInt = new F(f.getText(), f.getCard(), f.getReturnType());
															BinaryPredicateOperator op = null;
															String binOpSelected = opList.getItem(opListIndex);
															// take operatore between F and Th
															switch (binOpSelected) {
															case "":
																console.append("\nChoose an operator (Emoty op selected)");
																break;
															case ">":
																op = BinaryPredicateOperator.GREATER;
																break;
															case ">=":
																op = BinaryPredicateOperator.GREATER_OR_EQUAL;
																break;
															case "<":
																op = BinaryPredicateOperator.LOWER;
																break;
															case "<=":
																op = BinaryPredicateOperator.LOWER_OR_EQUAL;
																break;
															case "=":
																op = BinaryPredicateOperator.EQUAL;
																break;
															case "<>":
																op = BinaryPredicateOperator.DIFFERENT;
																break;
															}
															int thIndex = thList.getSelectionIndex();
															Threshold th = new Threshold();
															if (thIndex > -1) {

																th = new Threshold(thList.getItem(thIndex));
															}
															//take th selected
															Predicate pred = new BinaryPredicate(fInt, th, op);

															if ((guardOpListIndex < -1) && (guardOpListIndex > 3)) {
																console.append("\nGuardOpList index out of bounds");
															}
															String guardOpSelected = guardOpList.getItem(guardOpListIndex);

															GuardOperator guardOp;
															switch (guardOpSelected) {
															case "and":
																guardOp = GuardOperator.AND;
																break;
															case "or":
																guardOp = GuardOperator.OR;
																break;
															case "xor":
																guardOp = GuardOperator.XOR;
																break;
															default:
																guardOp = GuardOperator.EMPTY;
															}
															if ((!(check.getOperations().isEmpty()))&&(guardOp.equals(GuardOperator.EMPTY))) {
																	console.append("\nSELECT GUARD OPERATOR , THE OPERATOR MUST BE OR,AND OR XOR");
																	return;

															} else if ((check.getOperations().isEmpty())
																	&& (!(guardOp.equals(GuardOperator.EMPTY)))) {
																console.append("\nFIRST PREDICATE, INSERT EMPTY GUARD OP");
																return;
															}
															Operation operation = new Operation(guardOp, pred);

															check.getOperations().add(operation);
															fList.deselectAll();
															opList.deselectAll();
															guardOpList.deselectAll();
															thList.deselectAll();
															tree.removeAll();
															fillTreeModel2(tree, evl);
							
									}
								}
							}
						} catch (ClassNotFoundException | SQLException e1) {
							console.append("\n"+e1.getMessage() );
						}

					}
				} else if (item.getText().toLowerCase().contains("do")) {
					Do d = (Do) item.getData();

					List<String> list = d.getFunctions();

					String fun = doList.getItem(doList.getSelectionIndex());

					list.add(fun);
					d.setFunctions(list);
					doList.deselectAll();
					tree.removeAll();
					fillTreeModel2(tree, evl);

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// remove button listener
		button4.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] selectedItems;
				TreeItem item = null;
				try {
					selectedItems = tree.getSelection();
					item = selectedItems[0];
				} catch (ArrayIndexOutOfBoundsException exception) {
					console.append("\nSelecet the correct parent element, e.g. 'check:' for add guard elements, or 'do' for add do()");

					return;
				}

				//String fName = "";
				TreeItem parentItem = item.getParentItem();

				if (parentItem.getText().toLowerCase().contains("do")) {
					Do d = (Do) parentItem.getData();
					String function = (String) item.getData();
					d.getFunctions().remove(function);
					tree.removeAll();
					fillTreeModel2(tree, evl);
				} else if (parentItem.getText().toLowerCase().equals("not")) {
					TreeItem checkItem = parentItem.getParentItem();
					
					Operation op = (Operation) item.getData();
					Check check = (Check) checkItem.getData();
					check.getOperations().remove(op);
					tree.removeAll();
					fillTreeModel2(tree, evl);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		shell.setMenuBar(menuBar);

		shell.pack();

	}
	/**
	  * this method populates the tree from the evl file 
	  * @param		tree to populate		  
	  * @param		evl to represent in a tree view   
	  * @return		void    
	  */
	private static void fillTreeModel2(Tree tree, Evl evl) {
		tree.setRedraw(false);
		for (Context c : evl.getContextList()) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("context " + c.getName());
			item.setData(c);
			for (Container cont : c.getContainers()) {
				TreeItem contItem = new TreeItem(item, SWT.NONE);
				contItem.setText(cont.getType() + " " + cont.getName());
				contItem.setData(cont);

				Check check = cont.getCheck();
				if (check != null) {
					TreeItem checkItem = new TreeItem(contItem, SWT.NONE);
					checkItem.setText("check :");
					checkItem.setData(check);
					checkItem.setExpanded(true);
					
					TreeItem notCheckItem = new TreeItem(checkItem, SWT.NONE);
					notCheckItem.setText("not");
					
					for (Operation op : check.getOperations()) {
						if (op.getOp() != GuardOperator.EMPTY) {
							TreeItem checkChild2 = new TreeItem(notCheckItem, SWT.NONE);
							checkChild2.setText(op.getOp().toString());
							checkChild2.setData(op);

						}
						TreeItem checkChild1 = new TreeItem(notCheckItem, SWT.NONE);
						checkChild1.setText(op.getPredicate().toString());
						checkChild1.setData(op);

						// checkChild1.setExpanded(true);
					}
					notCheckItem.setExpanded(true);
					checkItem.setExpanded(true);
				}
				Message message = cont.getMessage();
				if (message != null) {
					TreeItem messageItem = new TreeItem(contItem, SWT.NONE);
					messageItem.setText("message : " + message.getText());
					messageItem.setData(message);
				}

				for (Fix fix : cont.getFixList()) {
					TreeItem fixItem = new TreeItem(contItem, SWT.NONE);
					fixItem.setText("fix");
					fixItem.setData(fix);

					Title title = fix.getTitle();
					if (title != null) {
						TreeItem titleItem = new TreeItem(fixItem, SWT.NONE);
						titleItem.setText("title : " + title.getText());
						titleItem.setData(fix.getTitle());

					}
						TreeItem doItem = new TreeItem(fixItem, SWT.NONE);
						doItem.setText("do");
						doItem.setData(fix.getDoList());

						for (String doFun : fix.getDoList().getFunctions()) {
							TreeItem doChildItem = new TreeItem(doItem, SWT.NONE);
							doChildItem.setText(doFun);
							doChildItem.setData(doFun);
							// doChildItem.setExpanded(true);
						doItem.setExpanded(true);
					}
					fixItem.setExpanded(true);
				}
				contItem.setExpanded(true);
			}

			item.setExpanded(true);

		}
		tree.setRedraw(true);

	}

}
