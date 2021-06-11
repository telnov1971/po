package ru.omel.po.view.list;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.service.DemandService;
import ru.omel.po.view.main.MainView;

@Route(value = "", layout = MainView.class)
@PageTitle("List demands")
public class ListDemandView extends VerticalLayout {
    private DemandService demandService;
    private Grid<Demand> grid = new Grid<>(Demand.class);

    public ListDemandView(DemandService demandService) {
        this.demandService = demandService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("demand-grid");
        grid.setSizeFull();
        grid.setColumns("date", "type", "status", "objectName", "objectAdress");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        grid.setItems(demandService.findAll());
    }

}
