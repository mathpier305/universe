package com.matt.ui.students;

import com.matt.ui.commonns.UniversMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=StudentLayoutFactory.NAME, ui=UniversMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View {
	
	public static final String NAME ="addstudents";

	public void enter(ViewChangeEvent event) {
		addComponent(new Label("This is the Student Layout"));
	}

}
