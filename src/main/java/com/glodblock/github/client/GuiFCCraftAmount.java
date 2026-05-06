package com.glodblock.github.client;

import appeng.api.storage.ITerminalHost;
import appeng.client.gui.MathExpressionParser;
import appeng.client.gui.implementations.GuiCraftAmount;
import appeng.client.gui.widgets.GuiTabButton;
import com.glodblock.github.FluidCraft;
import com.glodblock.github.inventory.GuiType;
import com.glodblock.github.inventory.InventoryHandler;
import com.glodblock.github.network.CPacketInventoryAction;
import com.glodblock.github.util.Ae2ReflectClient;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import java.io.IOException;

public class GuiFCCraftAmount extends GuiCraftAmount {

    private GuiTabButton originalGuiBtn;
    private GuiButton next;
    private GuiType originGui;

    public GuiFCCraftAmount(final InventoryPlayer inventoryPlayer, final ITerminalHost te) {
        super(inventoryPlayer, te);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.originalGuiBtn = Ae2ReflectClient.getGuiCraftAmountBackButton(this);
        this.next = Ae2ReflectClient.getGuiCraftAmountNextButton(this);
        ItemStack icon = ItemStack.EMPTY;
        if (!icon.isEmpty() && this.originGui != null) {
            this.buttonList.remove(this.originalGuiBtn);
            this.buttonList.add(this.originalGuiBtn = new GuiTabButton(this.guiLeft + 154, this.guiTop, icon, icon.getDisplayName(), this.itemRender));
        }
    }

    @Override
    protected void actionPerformed(final GuiButton btn) throws IOException {
        if (btn == this.originalGuiBtn && this.originGui != null) {
            InventoryHandler.switchGui(this.originGui);
        } else if (btn == this.next) {
            final String text = Ae2ReflectClient.getGuiCraftAmountTextBox(this).getText();
            final double resultD = MathExpressionParser.parse(text);
            final int result;
            if (resultD <= 0 || Double.isNaN(resultD)) {
                result = 1;
            } else {
                result = (int) MathExpressionParser.round(resultD, 0);
            }
            FluidCraft.proxy.netHandler.sendToServer(new CPacketInventoryAction(CPacketInventoryAction.Action.REQUEST_JOB, isShiftKeyDown() ? 1 : 0, result, null));
        } else {
            super.actionPerformed(btn);
        }
    }

}
