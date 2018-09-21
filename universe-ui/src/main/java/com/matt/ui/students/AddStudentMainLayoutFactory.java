package com.matt.ui.students;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gwt.i18n.server.testing.Gender;
import com.matt.model.entity.Student;
import com.matt.service.addstudent.AddStudentService;
import com.matt.utils.NotificationMessages;
import com.matt.utils.StudentStringUitls;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory {
	
	private class AddStudentMainLayout extends VerticalLayout implements Button.ClickListener {
		
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
			
			saveButton.addClickListener(this);
			clearButton.addClickListener(this);
			
			
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
			
			gender.addItem(Gender.FEMALE.toString());
			gender.addItem(Gender.MALE.toString());
			
			firstName.setNullRepresentation("");
			lastName.setNullRepresentation("");
			age.setNullRepresentation("");
			
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


		public void buttonClick(ClickEvent event) {
			
			if(event.getSource() == this.saveButton) {
				save();
			}else {
				clearField();
			}
			
		}
		
		private void save() {
			try {
				fieldGroup.commit();
			} catch (CommitException e) {
				 Notification.show(NotificationMessages.STUDENT_SAVE_VALIDATION_ERROR_TITLE.getString(),
						NotificationMessages.STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION.getString(),
						Type.ERROR_MESSAGE);
				 return;
			}
			addStudentService.saveStudent(student);
			clearField();
			
			Notification.show(NotificationMessages.STUDENT_SAVE_SUCCESS_TITLE.getString(),
					NotificationMessages.STUDENT_SAVE_SUCCESS_DESCRIPTION.getString(),
					Type.WARNING_MESSAGE);
		}
		
		
		private void clearField() {
			firstName.setValue(null);
			lastName.setValue(null);
			gender.setValue(null);
			age.setValue(null);
		}
	}
	
	@Autowired
	private AddStudentService addStudentService;
	
	public Component createComponent() {
		return new AddStudentMainLayout().init().bind().layout();
	}

}
