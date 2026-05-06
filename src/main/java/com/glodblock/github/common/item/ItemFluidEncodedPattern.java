package com.glodblock.github.common.item;

import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.items.misc.ItemEncodedPattern;
import com.glodblock.github.interfaces.HasCustomModel;
import com.glodblock.github.util.FluidPatternDetails;
import com.glodblock.github.util.NameConst;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFluidEncodedPattern extends ItemEncodedPattern implements HasCustomModel {

    @Override
    protected void getCheckedSubItems(final CreativeTabs creativeTab, final NonNullList<ItemStack> itemStacks) {
        // NO-OP
    }

    @Nullable
    @Override
    public ICraftingPatternDetails getPatternForItem(final ItemStack is, final World w) {
        final FluidPatternDetails pattern = new FluidPatternDetails(is);
        return pattern.readFromStack() ? pattern : null;
    }

    @Override
    public ResourceLocation getCustomModelPath() {
        return NameConst.MODEL_DENSE_ENCODED_PATTERN;
    }

}