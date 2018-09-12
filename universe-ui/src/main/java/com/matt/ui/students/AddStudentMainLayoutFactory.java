package com.matt.ui.students;

import com.google.gwt.i18n.server.testing.Gender;
import com.matt.model.entity.Student;
import com.matt.utils.StudentStringUitls;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

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
			student = new Student();
			
			firstName = new TextField(StudentStringUitls.FIRST_NAME.getString());
			lastName = new TextField(StudentStringUitls.LAST_NAME.getString());
			age = new TextField(StudentStringUitls.AGE.getString());
			
			gender = new ComboBox(StudentStringUitls.GENDER.getString());
			
			saveButton = new Button(StudentStringUitls.SAVE_BUTTON.getString());
			clearButton = new Button(StudentStringUitls.CLEAR_BUTTON.getString());
			
			
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
			
			gender.addItem(Gender.FEMALE.toString());
			gender.addItem(Gender.MALE.toString());
			
			return this;
		}
	

		private AddStudentMainLayout bind() {
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(student);
			return this;
		}
		
		public Component layout() {
			setMargin(true);
			GridLayout gridLayout = new GridLayout(2, 3);
			gridLayout.setSpacing(true);
			gridLayout.addComponent(firstName,0,0);
			gridLayout.addComponent(lastName,1,0);
			
			gridLayout.addComponent(age, 0, 1);
			gridLayout.addComponent(gender, 1,1);
			
			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 2);

			return gridLayout;

		}
		
	}
	
	public Component createComponent() {
		return new AddStudentMainLayout().init().layout();
	}

}
