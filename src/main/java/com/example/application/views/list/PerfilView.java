package com.example.application.views.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "myaccount",layout = MainLayout.class)
public class PerfilView extends Div {

    public PerfilView() {
        // Demo purposes only
        getStyle().set("background-color", "var(--lumo-contrast-5pct)")
                .set("display", "flex").set("justify-content", "center")
                .set("padding", "var(--lumo-space-l)");

        
    }

}