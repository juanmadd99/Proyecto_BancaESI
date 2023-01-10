package com.example.application.views.cuenta;

import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.data.entity.Movimiento;
import com.example.application.data.service.MovimientoService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility;
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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import com.example.application.views.noticias.*;

@SuppressWarnings("serial")
@PageTitle("Cuenta")
@Route(value = "Cuenta", layout = MainLayout.class)
@PermitAll
@Uses(Icon.class)
public class CuentaView extends Div {

    private Grid<Movimiento> grid;

    private Filters filters;
    private final MovimientoService movimientoService;
    private OrderedList imageContainer;

    public CuentaView(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
        setSizeFull();
        addClassNames("cuenta-view");

        filters = new Filters(() -> refreshGrid());
        VerticalLayout layout = new VerticalLayout(createMobileFilters(), filters, createGrid(), Algo());
        //layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        add(layout);
    }
    private HorizontalLayout Algo() {
    	HorizontalLayout algo = new HorizontalLayout();
    	 Accordion accordion = new Accordion();
         Span name = new Span("Sophia Williams");
         Span email = new Span("sophia.williams@company.com");
         Span phone = new Span("(501) 555-9128");
         VerticalLayout personalInformationLayout = new VerticalLayout(name,
                 email, phone);
         personalInformationLayout.setSpacing(false);
         personalInformationLayout.setPadding(false);
         accordion.add("Personal information", personalInformationLayout);
         Span street = new Span("4027 Amber Lake Canyon");
         Span zipCode = new Span("72333-5884 Cozy Nook");
         Span city = new Span("Arkansas");
         VerticalLayout billingAddressLayout = new VerticalLayout();
         billingAddressLayout.setSpacing(false);
         billingAddressLayout.setPadding(false);
         billingAddressLayout.add(street, zipCode, city);
         accordion.add("Billing address", billingAddressLayout);
         Span cardBrand = new Span("Mastercard");
         Span cardNumber = new Span("1234 5678 9012 3456");
         Span expiryDate = new Span("Expires 06/21");
         VerticalLayout paymentLayout = new VerticalLayout();
         paymentLayout.setSpacing(true);
         paymentLayout.setPadding(true);
         paymentLayout.add(cardBrand, cardNumber, expiryDate);
         accordion.add("Payment", paymentLayout);
         algo.add(accordion);
         algo.setSpacing(true);
         algo.setPadding(true);
    	return algo;
    }

    private HorizontalLayout createMobileFilters() {
        // Mobile version
        HorizontalLayout mobileFilters = new HorizontalLayout();
        mobileFilters.setWidthFull();
        mobileFilters.addClassNames(LumoUtility.Padding.MEDIUM, LumoUtility.BoxSizing.BORDER,
                LumoUtility.AlignItems.CENTER);
        mobileFilters.addClassName("mobile-filters");
        Icon mobileIcon = new Icon("lumo", "plus");
        Span filtersHeading = new Span("Filters");
        mobileFilters.add(mobileIcon, filtersHeading);
        mobileFilters.setFlexGrow(1, filtersHeading);
        mobileFilters.addClickListener(e -> {
            if (filters.getClassNames().contains("visible")) {
                filters.removeClassName("visible");
                mobileIcon.getElement().setAttribute("icon", "lumo:plus");
            } else {
                filters.addClassName("visible");
                mobileIcon.getElement().setAttribute("icon", "lumo:minus");
            }
        });
        return mobileFilters;
    }

    public static class Filters extends Div implements Specification<Movimiento> {

        private final TextField concepto = new TextField("concepto");
        //private final NumberField fValor = new NumberField("Valor");

        private final DatePicker startDate = new DatePicker("Fecha de realizacion");
        private final TextField cuentaOrigen = new TextField("Cuenta origen");
        private final TextField cuentaDestino = new TextField("Cuenta destino");
        private final DatePicker endDate = new DatePicker();

        public Filters(Runnable onSearch) {

            setWidthFull();
            addClassName("filter-layout");
            addClassNames(LumoUtility.Padding.Horizontal.LARGE, LumoUtility.Padding.Vertical.MEDIUM,
                    LumoUtility.BoxSizing.BORDER);
           // name.setPlaceholder("First or last name");

            //occupations.setItems("Insurance Clerk", "Mortarman", "Beer Coil Cleaner", "Scale Attendant");

           // roles.setItems("Worker", "Supervisor", "Manager", "External");
           // roles.addClassName("double-width");

            // Action buttons
            Button resetBtn = new Button("Reset");
            resetBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
            resetBtn.addClickListener(e -> {
            	concepto.clear();
            	//fValor.clear();
                startDate.clear();
                endDate.clear();
                cuentaOrigen.clear();
                cuentaDestino.clear();
                onSearch.run();
            });
            Button searchBtn = new Button("Search");
            searchBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            searchBtn.addClickListener(e -> onSearch.run());
            Div actions = new Div(resetBtn, searchBtn);
            actions.addClassName(LumoUtility.Gap.SMALL);
            actions.addClassName("actions");

            add(concepto, createDateRangeFilter(), cuentaOrigen, cuentaDestino, actions);
        }

        private Component createDateRangeFilter() {
            startDate.setPlaceholder("Desde");
            endDate.setPlaceholder("Hasta");

            // For screen readers
            setAriaLabel(startDate, "Desde");
            setAriaLabel(endDate, "Hasta");

            FlexLayout dateRangeComponent = new FlexLayout(startDate, new Text(" – "), endDate);
            dateRangeComponent.setAlignItems(FlexComponent.Alignment.BASELINE);
            dateRangeComponent.addClassName(LumoUtility.Gap.XSMALL);
            return dateRangeComponent;
        }

        private void setAriaLabel(DatePicker datePicker, String label) {
            datePicker.getElement().executeJs("const input = this.inputElement;" //
                    + "input.setAttribute('aria-label', $0);" //
                    + "input.removeAttribute('aria-labelledby');", label);
        }

        @Override
        public Predicate toPredicate(Root<Movimiento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicates = new ArrayList<>();

            if (!concepto.isEmpty()) {
                String lowerCaseFilter = concepto.getValue().toLowerCase();
                Predicate conceptoMatch = criteriaBuilder.like(criteriaBuilder.lower(root.get("concepto")),
                        lowerCaseFilter + "%");

                predicates.add(criteriaBuilder.or(conceptoMatch));
            }

            if (!cuentaOrigen.isEmpty()) {
                String lowerCaseFilter = cuentaOrigen.getValue().toLowerCase();
                Predicate cuentaOrigenMATCH = criteriaBuilder.like(criteriaBuilder.lower(root.get("cuentaOrigen")),
                        lowerCaseFilter + "%");
                predicates.add(criteriaBuilder.or(cuentaOrigenMATCH));
            }

            if (!cuentaDestino.isEmpty()) {
                String lowerCaseFilter = cuentaDestino.getValue().toLowerCase();
                Predicate cuentaDestinoMATCH = criteriaBuilder.like(criteriaBuilder.lower(root.get("cuentaDestino")),
                        lowerCaseFilter + "%");
                predicates.add(criteriaBuilder.or(cuentaDestinoMATCH));
            }
            /*
            if (!valor.isEmpty()) {
                String databaseColumn = "phone";
                String ignore = "- ()";
                String lowerCaseFilter = ignoreCharacters(ignore, valor.getValue().toLowerCase());
                Predicate phoneMatch = criteriaBuilder.like(
                        ignoreCharacters(ignore, criteriaBuilder, criteriaBuilder.lower(root.get(databaseColumn))),
                        "%" + lowerCaseFilter + "%");
                predicates.add(phoneMatch);
            }
            */
            if (startDate.getValue() != null) {
                String databaseColumn = "dFecha";
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(databaseColumn),
                        criteriaBuilder.literal(startDate.getValue())));
            }
            if (endDate.getValue() != null) {
                String databaseColumn = "dFecha";
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.literal(endDate.getValue()),
                        root.get(databaseColumn)));
            }
            /*
            if (!occupations.isEmpty()) {
                String databaseColumn = "occupation";
                List<Predicate> occupationPredicates = new ArrayList<>();
                for (String occupation : occupations.getValue()) {
                    occupationPredicates
                            .add(criteriaBuilder.equal(criteriaBuilder.literal(occupation), root.get(databaseColumn)));
                }
                predicates.add(criteriaBuilder.or(occupationPredicates.toArray(Predicate[]::new)));
            }
            */

            /*
            if (!roles.isEmpty()) {
                String databaseColumn = "role";
                List<Predicate> rolePredicates = new ArrayList<>();
                for (String role : roles.getValue()) {
                    rolePredicates.add(criteriaBuilder.equal(criteriaBuilder.literal(role), root.get(databaseColumn)));
                }
                predicates.add(criteriaBuilder.or(rolePredicates.toArray(Predicate[]::new)));
            }
            */
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        }

        private String ignoreCharacters(String characters, String in) {
            String result = in;
            for (int i = 0; i < characters.length(); i++) {
                result = result.replace("" + characters.charAt(i), "");
            }
            return result;
        }
        private Expression<String> ignoreCharacters(String characters, CriteriaBuilder criteriaBuilder,
                Expression<String> inExpression) {
            Expression<String> expression = inExpression;
            for (int i = 0; i < characters.length(); i++) {
                expression = criteriaBuilder.function("replace", String.class, expression,
                        criteriaBuilder.literal(characters.charAt(i)), criteriaBuilder.literal(""));
            }
            return expression;
        }
    }

    private Component createGrid() {
        grid = new Grid<>(Movimiento.class, false);
        grid.addColumn("concepto").setAutoWidth(true);
        grid.addColumn("fValor").setAutoWidth(true);
        grid.addColumn("dFecha").setAutoWidth(true);
        grid.addColumn("cuentaOrigen").setAutoWidth(true);
        grid.addColumn("cuentaDestino").setAutoWidth(true);

        grid.setItems(query -> movimientoService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)),
                filters).stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.addClassNames(LumoUtility.Border.TOP, LumoUtility.BorderColor.CONTRAST_10);
        return grid;
    }
    private void refreshGrid() {
        grid.getDataProvider().refreshAll();
    }
}