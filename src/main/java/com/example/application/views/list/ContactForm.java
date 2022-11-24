package com.example.application.views.list;

import java.util.List;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class ContactForm {
	// Other fields omitted
	Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);
	private Contact contact; 

	public ContactForm(List<Company> companies, List<Status> statuses) {
	    addClassName("contact-form");
	    binder.bindInstanceFields(this); 
	    // Rest of constructor omitted
	}

	private void addClassName(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public void setContact(Contact contact) {
        this.contact = contact; 
        binder.readBean(contact); 
    }
}

//Events
public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {
private Contact contact;

protected ContactFormEvent(ContactForm source, Contact contact) { 
 super(source, false);
 this.contact = contact;
}

public Contact getContact() {
 return contact;
}
}

public static class SaveEvent extends ContactFormEvent {
SaveEvent(ContactForm source, Contact contact) {
 super(source, contact);
}
}

public static class DeleteEvent extends ContactFormEvent {
DeleteEvent(ContactForm source, Contact contact) {
 super(source, contact);
}

}

public static class CloseEvent extends ContactFormEvent {
CloseEvent(ContactForm source) {
 super(source, null);
}
}

public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
 ComponentEventListener<T> listener) { 
return getEventBus().addListener(eventType, listener);
}
