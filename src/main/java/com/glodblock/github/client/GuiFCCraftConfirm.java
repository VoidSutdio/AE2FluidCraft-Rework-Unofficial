package com.glodblock.github.client;

import appeng.api.storage.ITerminalHost;
import appeng.client.gui.implementations.GuiCraftConfirm;
import appeng.container.implementations.ContainerCraftConfirm;
import com.glodblock.github.client.container.ContainerFCCraftConfirm;
import com.glodblock.github.inventory.GuiType;
import com.glodblock.github.inventory.InventoryHandler;
import com.glodblock.github.util.Ae2ReflectClient;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;

import java.io.IOException;

public class GuiFCCraftConfirm extends GuiCraftConfirm {

    private GuiButton cancel;
    private GuiType originGui;

    public GuiFCCraftConfirm(final InventoryPlayer inventoryPlayer, final ITerminalHost te) {
        super(inventoryPlayer, te);
        this.inventorySlots = new ContainerFCCraftConfirm(inventoryPlayer, te);
        final ContainerCraftConfirm ccc = (ContainerCraftConfirm) this.inventorySlots;
        ccc.setGui(this);
        Ae2ReflectClient.writeCraftConfirmContainer(this, ccc);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.cancel = Ae2ReflectClient.getCraftConfirmBackButton(this);
    }

    @Override
    protected void actionPerformed(final GuiButton btn) throws IOException {
        if (btn == this.cancel && this.originGui != null) {
            InventoryHandler.switchGui(this.originGui);
            return;
        }
        super.actionPerformed(btn);
    }

}
