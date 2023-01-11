package com.example.application.views.inicio;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import com.example.application.data.entity.User;
import com.example.application.security.AuthenticatedUser;
import com.example.application.views.MainLayout;
import com.example.application.views.cuenta.CuentaView;
import com.example.application.views.login.LoginView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout.Section;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Navigator;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@PageTitle("Inicio")
@Route(value = "Inicio", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@AnonymousAllowed
public class InicioView extends VerticalLayout {
	
	private AuthenticatedUser authenticatedUser;
	
    public InicioView(AuthenticatedUser authenticatedUser) {
    	this.authenticatedUser = authenticatedUser;
    	         
		Optional<User> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            
            setSpacing(false);

            Button cuenta = new Button("Mi cuenta");
            cuenta.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            cuenta.addClickListener(e -> { UI.getCurrent().navigate(CuentaView.class); });
            

            add(new H2("Bienvenid@ a su perfil, " + user.getName()));
            add(cuenta);

        } else {
        	setSpacing(false);

            Button login = new Button("Login");
            login.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            login.addClickListener(e -> { UI.getCurrent().navigate(LoginView.class); });
            

            add(new H2("Bienvenid@ a EsiBank"));
            add(login);
        }


        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
/*
private Footer createFooter() {
    Footer layout = new Footer();

    Optional<User> maybeUser = authenticatedUser.get();
    if (maybeUser.isPresent()) {
        User user = maybeUser.get();

        Avatar avatar = new Avatar(user.getName());
        StreamResource resource = new StreamResource("profile-pic",
                () -> new ByteArrayInputStream(user.getProfilePicture()));
        avatar.setImageResource(resource);
        avatar.setThemeName("xsmall");
        avatar.getElement().setAttribute("tabindex", "-1");

        MenuBar userMenu = new MenuBar();
        userMenu.setThemeName("tertiary-inline contrast");

        MenuItem userName = userMenu.addItem("");
        Div div = new Div();
        div.add(avatar);
        div.add(user.getName());
        div.add(new Icon("lumo", "dropdown"));
        div.getElement().getStyle().set("display", "flex");
        div.getElement().getStyle().set("align-items", "center");
        div.getElement().getStyle().set("gap", "var(--lumo-space-s)");
        userName.add(div);
        userName.getSubMenu().addItem("Sign out", e -> {
            authenticatedUser.logout();
        });

        layout.add(userMenu);
    } else {
        Anchor loginLink = new Anchor("login", "Sign in");
        layout.add(loginLink);
    }

    return layout;
}*/