package com.matt.ui.commonns;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringUI(path=UniversMainUI.NAME)
@Title("U n i v e r  s")
@Theme("valo")
public class UniversMainUI extends UI {
	
	public static final String NAME="/ui";

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout rootLayout = new VerticalLayout();
		
		rootLayout.addComponent(new Label("oh we have made it"));
		
		setContent(rootLayout);
	}

}
