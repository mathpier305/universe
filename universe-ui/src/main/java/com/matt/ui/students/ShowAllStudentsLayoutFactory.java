package com.matt.ui.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.matt.model.entity.Student;
import com.matt.service.showallstudents.ShowAllStudentsService;
import com.matt.ui.commonns.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllStudentsLayoutFactory implements UIComponentBuilder{

	private List<Student> students;
	private BeanItemContainer<Student> container;
	
	
	private class ShowAllStudentsLayout extends VerticalLayout {
		private Grid studentsTable;
		
		public ShowAllStudentsLayout init() {
			setMargin(true);
			
			container = new BeanItemContainer<Student>(Student.class, students);
			studentsTable = new Grid(container);
			studentsTable.setColumnOrder("firstName", "lastName", "age", "gender");
			studentsTable.removeColumn("id");
			studentsTable.setImmediate(true);
			
			
			return this;
		}
		
		public ShowAllStudentsLayout load() {
			students = showAllStudentsService.getAllStudents();
			return this;
		}
		
		public ShowAllStudentsLayout layout() {
			addComponent(studentsTable);
			return this;
		}
	}
	
	@Autowired
	private ShowAllStudentsService showAllStudentsService;
	
	public Component createComponent() {
		return new ShowAllStudentsLayout().init().load().layout();
	}
	
	

}
