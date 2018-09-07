package com.matt.ui.students;

import com.google.gwt.i18n.server.testing.Gender;
import com.matt.model.entity.Student;
import com.matt.utils.StudentStringUitls;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory {
	
	private class AddStudentMainLayout extends VerticalLayout {
		
		private TextField firstName;
		private TextField lastName;
		private TextField age;
		private ComboBox gender;
		private Button saveButton;
		private Button clearButton;
		
		private BeanFieldGroup<Student> fieldGroup;
		private Student student;
		
		public AddStudentMainLayout init() {
			fieldGroup = new BeanFieldGroup<Student>(Student.class);
			firstName = new TextField(StudentStringUitls.FIRST_NAME.getString());
			lastName = new TextField(StudentStringUitls.LAST_NAME.getString());
			age = new TextField(StudentStringUitls.AGE.getString());
			
			gender = new ComboBox(StudentStringUitls.GENDER.getString());
			
			saveButton = new Button(StudentStringUitls.SAVE_BUTTON.getString());
			clearButton = new Button(StudentStringUitls.CLEAR_BUTTON.getString());
			
			gender.addItem(Gender.FEMALE.getString());
			gender.addItem(Gender.MALE.getString());
			
			return this;
		}
		
		public AddStudentMainLayout layout() {
			return this;
		}
		
	}
	
	public Component createComponent() {
		return new AddStudentMainLayout().init().layout();
	}

}
