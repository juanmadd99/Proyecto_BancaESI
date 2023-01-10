package com.example.application.views.noticias;

import com.example.application.views.MainLayout;
import com.example.application.views.cuenta.CuentaView;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@SuppressWarnings("serial")
@PageTitle("Noticias")
@Route(value = "Noticias", layout = MainLayout.class)
@AnonymousAllowed
public class NoticiasView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    public NoticiasView() {
        constructUI();

        imageContainer.add(new NoticiasViewCard("Hipotecas Onilne","Digital desde el principio, atencion personal hasta el final.", "Hipotecas Onilne",
                "https://s10.s3c.es/imag/_v0/1200x655/b/b/1/hipoteca-tipo-fijo-ocu-iStock-1328126737.jpg"));
        imageContainer.add(new NoticiasViewCard("Planeta seguros","Agrupa tus seguros, paga mes a mes y podrás ahorrar hasta un 11%..", "Planeta seguros",
                "https://www.bancosantander.es/wcm/connect/www.bancosantander.es24647/57c15fc2-548f-4c4c-ac7c-3e4412692cd6/720x450_banner-producto_centrado_planeta_seguros.jpg?MOD=AJPERES&CACHEID=ROOTWORKSPACE.Z18_O1A0HJ82O0E160Q2H3HV972000-57c15fc2-548f-4c4c-ac7c-3e4412692cd6-okWeHk1"));
        imageContainer.add(new NoticiasViewCard("Sacar dinero sin tarjeta","Te explicamos de manera sencilla como sacar dinero con tu móvil paso por paso.", "Sacar dinero sin tarjeta",
                "https://www.bancosantander.es/wcm/connect/www.bancosantander.es24647/272f925e-13d4-4dc6-b0b5-3351ca9749c4/704x430_imagen_sacar_dinero.jpg?MOD=AJPERES&CACHEID=ROOTWORKSPACE.Z18_O1A0HJ82O0E160Q2H3HV972000-272f925e-13d4-4dc6-b0b5-3351ca9749c4-nCDQA4d"));
        imageContainer.add(new NoticiasViewCard("Seguridad","Descubre un mundo entero sobre ciberseguridad.", "Seguridad",
                "https://blog.hubspot.es/hubfs/media/queesseguridadinformatica.jpeg"));
        imageContainer.add(new NoticiasViewCard("Ahorros y depositos","Un seguro de ahorro para un futuro de diez.", "Ahorros y depositos",
                "https://img.freepik.com/fotos-premium/pareja-abrazos-sentado-banco-mirador-contra-pintorescas-montanas-antiguas-al-atardecer-vista-trasera_255755-2465.jpg?w=2000"));
        imageContainer.add(new NoticiasViewCard("Bizum","Paga con tu móvil de forma fácil y segura.", "Bizum",
                "https://www.consumidorglobal.com/uploads/s1/36/03/6/tarjeta1.jpeg"));
        
    }

    private void constructUI() {
        addClassNames("noticias-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Noticias e información");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);
        headerContainer.add(header);

        imageContainer = new OrderedList();
        imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        container.add(headerContainer);
        add(container, imageContainer);

    }
}
