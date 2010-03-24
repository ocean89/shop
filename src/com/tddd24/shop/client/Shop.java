package com.tddd24.shop.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Shop implements EntryPoint {
	
	MyServiceAsync myService = (MyServiceAsync) GWT.create(MyService.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		mainLayout.addMember(generateNavigationTree());

		VLayout vLayout = new VLayout();
		vLayout.setWidth("80%");

		Label listingLabel = new Label();
		listingLabel.setContents("Listing");
		listingLabel.setAlign(Alignment.CENTER);
		listingLabel.setOverflow(Overflow.HIDDEN);
		listingLabel.setHeight("20%");

		Label detailsLabel = new Label();
		detailsLabel.setContents("Details");
		detailsLabel.setAlign(Alignment.CENTER);
		detailsLabel.setOverflow(Overflow.HIDDEN);
		detailsLabel.setHeight("70%");

		vLayout.addMember(detailsLabel);
		vLayout.addMember(listingLabel);

		
		myService.testMethod("test", new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				Window.alert("omg");
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
				
			}
		});

		mainLayout.addMember(vLayout);
		mainLayout.draw();
	}

	public TreeGrid generateNavigationTree() {

		TreeNode[] employeeData = new TreeNode[] {
				new EmployeeTreeNode("4", "1", "Wigga Madigen"),
				new EmployeeTreeNode("189", "4", "Gene Porter"),
				new EmployeeTreeNode("265", "189", "Olivier Doucet"),
				new EmployeeTreeNode("264", "189", "Cheryl Pearson"),
				new EmployeeTreeNode("188", "4", "Rogine Leger") };

		Tree navigationTree = new Tree();
		navigationTree.setModelType(TreeModelType.PARENT);
		navigationTree.setIdField("ID");
		navigationTree.setParentIdField("parentID");
		navigationTree.setNameProperty("name");
		navigationTree.setRootValue(1);
		navigationTree.setData(employeeData);
		
		TreeGrid navigationTreeGrid = new TreeGrid();
		navigationTreeGrid.setFields(new TreeGridField("name"));
		navigationTreeGrid.setData(navigationTree);
		
		return navigationTreeGrid;
	}
	
	public static class EmployeeTreeNode extends TreeNode {
		public EmployeeTreeNode(String ID, String parentID, String name) {
			setAttribute("ID", ID);
			setAttribute("parentID", parentID);
			setAttribute("name", name);
		}
	}

}