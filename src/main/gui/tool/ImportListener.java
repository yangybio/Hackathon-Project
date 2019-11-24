package gui.tool;

import java.util.EventListener;

public interface ImportListener extends EventListener {
    public void importOccurred(DetailEvent event);
}
