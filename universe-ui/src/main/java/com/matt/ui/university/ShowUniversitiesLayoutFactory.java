package com.matt.ui.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.matt.model.entity.University;
import com.matt.service.showUniversityService.ShowAllUniversitiesService;
import com.matt.ui.commonns.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class ShowUniversitiesLayoutFactory implements UIComponentBuilder {
	
	private List<University> universities;
	private BeanItemContainer<University> container;
	
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;
	
	
	
	private class ShowUniversityLayout extends VerticalLayout {
		private  Grid universityTable;
		
		public ShowUniversityLayout init() {
			setMargin(true);
			
			container = new BeanItemContainer<University>(University.class, universities);
			universityTable = new Grid(container);
			universityTable.setColumnOrder("UniversityName", "UniversityCountry", "UniversityCity");
			universityTable.removeColumn("id");
			universityTable.setImmediate(true);
			return this;
		}
	}

	public Component createComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void refreshTable() {
		// TODO Auto-generated method stub
		
	}

}
