package com.example.application.views.list;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;

@Route(value = "login",layout = MainLayout.class)
public class LoginView extends Div {

    public LoginView() {
        // Demo purposes only
        getStyle().set("background-color", "var(--lumo-contrast-5pct)")
                .set("display", "flex").set("justify-content", "center")
                .set("padding", "var(--lumo-space-l)");

        // tag::snippet[]
        LoginForm loginForm = new LoginForm();
        add(loginForm);
        // end::snippet[]
        // Prevent the example from stealing focus when browsing the
        // documentation
        loginForm.getElement().setAttribute("no-autofocus", "");
    }

}
