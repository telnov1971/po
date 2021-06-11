package ru.omel.po.view.profile;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.omel.po.view.main.MainView;

@Route(value = "profile", layout = MainView.class)
@PageTitle("User profile")
public class UserProfileView extends Div {
    public UserProfileView() {
        add(new Span("User profile"));
    }
}
