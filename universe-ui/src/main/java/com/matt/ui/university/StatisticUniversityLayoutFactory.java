package com.matt.ui.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.matt.model.entity.University;
import com.matt.service.showUniversityService.ShowAllUniversitiesService;
import com.matt.service.universityStatisticService.UniversityStatisticService;
import com.matt.ui.commonns.UIComponentBuilder;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class StatisticUniversityLayoutFactory  implements UIComponentBuilder {
	
	private List<University> universities;
	
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;

	@Autowired
	private UniversityStatisticService universityStatisticService;
	
	
	private class StatisticsUniversityLayout extends VerticalLayout {
		
		public StatisticsUniversityLayout load() {
			universities = showAllUniversitiesService.getAllUniversities();
			return this;
		}
		
		public StatisticsUniversityLayout layout() {
			
			setMargin(true);
			for(University university : universities) {
				int numOfStudents = universityStatisticService.getNumOfStudentsForUniversity(university.getId());
				Label label = new Label("<p><b>"+university.getUniversityName()+"</b>"+numOfStudents+" Students </p>");
				addComponent(label);
				
			}
			return this;
		}
		
	}
	public Component createComponent() {
		
		return new StatisticsUniversityLayout().load().layout();
	}
	public void refresh() {
	}

}
