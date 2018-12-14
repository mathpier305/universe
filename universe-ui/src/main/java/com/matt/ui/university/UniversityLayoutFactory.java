package com.matt.ui.university;

import org.springframework.beans.factory.annotation.Autowired;

import com.matt.ui.commonns.UniversMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=UniversityLayoutFactory.NAME, ui=UniversMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View{

	public static final String NAME= "operations";
	
	@Autowired
	private AddUniversityLayoutFactory addUniversityLayoutFactory;
	private TabSheet tabSheet;
	
//	@Autowired
//	private ShowAllUniversitiesLayoutFactory showUniversitiesLayoutFactory;

	@Autowired
	private StatisticUniversityLayoutFactory statisticUniversityLayoutFactory;
	private void addLayout() {
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addUniversityTab = addUniversityLayoutFactory.createComponent();
		Component showAllUniverisitiesTab = new Label("All Univerisities");
		Component showStatistic = statisticUniversityLayoutFactory.createComponent();
		
		tabSheet.addTab(addUniversityTab, "ADD UNIVERSITY");
		tabSheet.addTab(showAllUniverisitiesTab, "Show All UNIVERSITIES");
		tabSheet.addTab(showStatistic, "StatISTICS");
		
		addComponent(tabSheet);
	
		
	}

	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}
}
