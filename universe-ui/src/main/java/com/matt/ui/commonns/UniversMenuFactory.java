package com.matt.ui.commonns;

import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversMenuFactory implements UIComponentBuilder {
	
	private class UniversMenu extends VerticalLayout {
		
		private Tree mainMenu;
		
		public UniversMenu init() {
			mainMenu = new Tree();
			return this;
		}
		
		public UniversMenu layout() {
			setWidth("100%");
			setHeightUndefined();
			
			mainMenu.addItem("STUDENT");
			mainMenu.addItem("UNIVERSITY");
			
			mainMenu.expandItem("STUDENT");
			mainMenu.expandItem("UNIVERSITY");
			
			mainMenu.addItem("Add Student");
			mainMenu.addItem("Remove Student");
			mainMenu.setChildrenAllowed("Add Student", false);
			mainMenu.setChildrenAllowed("Remove Student", false);
			mainMenu.setParent("Add Student",  "STUDENT");
			mainMenu.setParent("Remove Student", "STUDENT");
			
			mainMenu.addItem("Operations");
			mainMenu.setChildrenAllowed("Operations", false);
			mainMenu.setParent("Operations", "UNIVERSITY");
			
			addComponent(mainMenu);
			return this;
		}
		
	}

	public Component createComponent() {
		return new UniversMenu().init().layout();
	}

}
