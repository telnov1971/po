package ru.omel.po.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.omel.po.view.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class About extends Div{

        public About() {
            add(new Span("Admin view content"));
        }
}
