package com.matt.ui.students;

import org.springframework.beans.factory.annotation.Autowired;

import com.matt.ui.commonns.UniversMainUI;
import com.matt.utils.StudentStringUitls;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=StudentLayoutFactory.NAME, ui=UniversMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View {
	
	public static final String NAME ="addstudent";
	
	@Autowired
	private AddStudentMainLayoutFactory mainLayoutFactory;
	
	private TabSheet tabSheet;
	
	
	private void addLayout() {
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addStudentMainTab = mainLayoutFactory.createComponent();
		
		Component showStudentTAb = new Label("Show Student tab...");
		
		tabSheet.addTab(addStudentMainTab, StudentStringUitls.MAIN_MENU.getString());
		tabSheet.addTab(showStudentTAb, StudentStringUitls.SHOW_ALL_STUDENTS.getString());

		addComponent(tabSheet);
		
	}

	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}

}
