package fi.dy.masa.litematica.gui.widgets;

import fi.dy.masa.litematica.data.DataManager;
import fi.dy.masa.litematica.data.SchematicPlacement;
import fi.dy.masa.litematica.gui.GuiPlacementManager;
import fi.dy.masa.litematica.gui.widgets.base.WidgetListBase;

public class WidgetSchematicPlacements extends WidgetListBase<SchematicPlacement, WidgetSchematicPlacement>
{
    private final GuiPlacementManager parent;

    public WidgetSchematicPlacements(int x, int y, int width, int height, GuiPlacementManager parent)
    {
        super(x, y, width, height, parent);

        this.parent = parent;
        this.browserEntryHeight = 22;
    }

    public GuiPlacementManager getParentGui()
    {
        return this.parent;
    }

    @Override
    public void refreshEntries()
    {
        this.listContents.clear();
        this.listContents.addAll(DataManager.getInstance().getSchematicPlacementManager().getAllSchematicsPlacements());

        this.recreateListWidgets();
    }

    @Override
    protected WidgetSchematicPlacement createListWidget(int x, int y, boolean isOdd, SchematicPlacement entry)
    {
        return new WidgetSchematicPlacement(x, y, this.browserEntryWidth, this.getBrowserEntryHeightFor(entry), this.zLevel, isOdd, entry, this, this.mc);
    }
}
