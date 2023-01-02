package com.example.application.views.MyAccount;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import javax.annotation.security.PermitAll;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.example.application.data.entity.User;
import com.example.application.data.entity.Movimiento;

@PageTitle("Mi cuenta")
@Route(value = "myaccount", layout = MainLayout.class)
@PermitAll
public class MyAccountView extends VerticalLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyAccountView() {
        setSpacing(false);
        
        Select<String> select = new Select<>();
        select.setLabel("Cuentas bancarias"); 
        select.setItems("Most recent first", 
        		"Rating: high to low",
                "Rating: low to high", 
                "Price: high to low",
                "Price: low to high"); //Cuentas bancarias de la BD

        add(select);
        Button button = new Button("Mostrar informacion de la cuenta seleccionada");
        button.addClickListener(clickEvent -> {
            //Consulta con la cuenta seleccionada
        	//mostrar info de esa cuenta
        });
        
        //TENEMOS YA LA CUENTA SELEECIONADA
        //Buscamos en movimientos del sistema, solo los de esa cuenta. (consulta SQL) - rs
        //
        
        Grid<Movimiento> grid = new Grid<>(Movimiento.class, false);
        grid.addColumn(Movimiento::getFirstName).setHeader("First name");
        grid.addColumn(Movimiento::getLastName).setHeader("Last name");
        grid.addColumn(Movimiento::getEmail).setHeader("Email");
        grid.addColumn(Movimiento::getProfession).setHeader("Profession");

        List<Person> people = DataService.getPeople();
        grid.setItems(people);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");   
    }

}
