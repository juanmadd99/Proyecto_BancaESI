package com.example.application.views.transferencias;

import com.example.application.data.entity.Cuenta;
import com.example.application.data.entity.Movimiento;
import com.example.application.data.entity.User;
import com.example.application.data.service.CuentaService;
import com.example.application.data.service.MovimientoService;
import com.example.application.data.service.UserService;
import com.example.application.security.AuthenticatedUser;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.LocalDateTimeToDateConverter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.annotation.security.PermitAll;

@PageTitle("Transferencias")
@Route(value = "Transferencias", layout = MainLayout.class)
@PermitAll
public class TransferenciasView extends Div {
	
	private AuthenticatedUser authenticatedUser;
	private UserService userservice;
	private CuentaService cuentaservice;
	private MovimientoService movimientoservice;

	TextField cuentaDestino = new TextField("Cuenta Destino");
	TextField concepto = new TextField("Concepto");
    Select<String> cuentaSelect = new Select<String>("Cuenta Origen"); //CONSULTA de todos los IBAN de ese user.
    NumberField cantidad = new NumberField("Cantidad a enviar");
    DatePicker datefechaActual = new DatePicker();
    TextField datefechaActual2 = new TextField("fechap");
    private LocalDate fechaActual = LocalDate.now();
    Binder<Movimiento> binder = new Binder<>(Movimiento.class);
    private Button cancel;
    private Button submit;
    ///
    LocalDate hoy = LocalDate.now();
    Date ayer = new Date();
    Cuenta prueba;

    public TransferenciasView(AuthenticatedUser authenticatedUser, UserService userservice, CuentaService cuentaservice, MovimientoService movimientoservice) {
        addClassName("transferencias-view");
        
        this.authenticatedUser = authenticatedUser;
        this.userservice = userservice;
        this.cuentaservice = cuentaservice;
        this.movimientoservice = movimientoservice;
        
        Movimiento movActual =  new Movimiento("pruebaJava",hoy, (float) 0.00, "", "", prueba,prueba);
        
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());
        
        binder.forField(concepto)
        // Validator defined based on a lambda
        // and an error message
        .withValidator(
        		concepto -> concepto.length() >= 3,
            "El concepto debe tener al menos 3 caracteres de longitud")
        .bind(Movimiento::getConcepto, Movimiento::setConcepto);
        
        binder.forField(cuentaSelect) 
        .bind(Movimiento::getCuentao, Movimiento::setCuentao);
                
        binder.forField(cuentaDestino) 
        .bind(Movimiento::getCuentad, Movimiento::setCuentad);
        
        
        datefechaActual.setValue(hoy);
        binder.forField(datefechaActual);
        
        binder.forField(cantidad) 
        .withValidator(
        		cantidad -> cantidad > 0,
            "La cantidad debe ser mayor que 0");
        binder.setBean(movActual);
       
        cancel.addClickListener(e -> {
            concepto.clear();
            cuentaSelect.clear();
            cuentaDestino.clear();
            cantidad.clear();
        });
        
        submit.addClickListener(e -> {
        	if (binder.validate().isOk()) {
                // person is always up-to-date as long as
                // there are no validation errors
            	movimientoservice.update(movActual);
            	movActual.setdFecha(hoy);
            }
        });
    }

    private Component createTitle() {
        return new H3("Realizar Transferencia");
    }

    private Component createFormLayout() {
    	
    	concepto = new TextField("Concepto");
    	cuentaSelect = new Select<>();
    	cuentaSelect.setPlaceholder("Seleccionar tu cuenta");
    	cuentaSelect.setItems(); //Consulta a la BD
    	cuentaDestino = new TextField("Cuenta de destino");
    	cantidad = new NumberField("Cantidad a enviar");
    	
        FormLayout formLayout = new FormLayout();
        formLayout.add(concepto, cuentaSelect, cuentaDestino, cantidad);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");

        submit = new Button("Enviar");
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        cancel = new Button("Cancelar");

        buttonLayout.add(submit);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    private class ExpirationDateField extends CustomField<String> {
        public ExpirationDateField(String label, Select<Integer> month, Select<Integer> year) {
            setLabel(label);
            HorizontalLayout layout = new HorizontalLayout(month, year);
            layout.setFlexGrow(1.0, month, year);
            month.setWidth("100px");
            year.setWidth("100px");
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            // Unused as month and year fields part are of the outer class
            return "";
        }

        @Override
        protected void setPresentationValue(String newPresentationValue) {
            // Unused as month and year fields part are of the outer class
        }

    }

}