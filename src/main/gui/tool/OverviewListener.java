package gui.tool;

import java.util.EventListener;

public interface OverviewListener extends EventListener {
    public void overviewOccurred(DetailEvent event);
}

