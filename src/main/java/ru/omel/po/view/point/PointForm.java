package ru.omel.po.view.point;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.entity.Point;
import ru.omel.po.data.service.PointService;
import ru.omel.po.view.main.MainView;

@Route(value = "point", layout = MainView.class)
@PageTitle("Connect point")
public class PointForm extends Div {
    private Demand demand;

    private NumberField powerDemand = new NumberField();
    private NumberField powerCurrent = new NumberField();
    private NumberField powerMax = new NumberField();
    private ComboBox<Point.Safety> safety = new ComboBox<>("Safety");
    private ComboBox<Point.Voltage> voltage = new ComboBox<>("Voltage");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<Point> binder = new Binder<>(Point.class);

    @Autowired
    public PointForm(PointService pointService) {
        addClassName("pointform-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);

        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            //pointService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " stored.");
            clearForm();
        });
    }

    private Component createTitle() {
        return new H3("New connection point");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(powerDemand, 2);
        formLayout.add(powerCurrent, 2);
        formLayout.add(powerMax, 2);
        safety.setItems(Point.Safety.FIRST, Point.Safety.SECOND, Point.Safety.THIRD);
        voltage.setItems(Point.Voltage.NULL_FOUR,Point.Voltage.TEN);
        formLayout.add(safety, voltage);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    private void clearForm() {
        this.binder.setBean(new Point());
    }

}
