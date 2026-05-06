package com.glodblock.github.loader;

import com.glodblock.github.FluidCraft;
import com.glodblock.github.common.block.BlockBurette;
import com.glodblock.github.common.block.BlockDualInterface;
import com.glodblock.github.common.block.BlockFluidAssembler;
import com.glodblock.github.common.block.BlockFluidPacketDecoder;
import com.glodblock.github.common.block.BlockGeneralLevelMaintainer;
import com.glodblock.github.common.block.BlockIngredientBuffer;
import com.glodblock.github.common.block.BlockLargeIngredientBuffer;
import com.glodblock.github.handler.RegistryHandler;
import com.glodblock.github.util.NameConst;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FCBlocks {

    @GameRegistry.ObjectHolder(FluidCraft.MODID + ":" + NameConst.BLOCK_FLUID_PACKET_DECODER)
    public static BlockFluidPacketDecoder FLUID_PACKET_DECODER;
    @GameRegistry.ObjectHolder(FluidCraft.MODID + ":" + NameConst.BLOCK_INGREDIENT_BUFFER)
    public static BlockIngredientBuffer INGREDIENT_BUFFER;
    @GameRegistry.ObjectHolder(FluidCraft.MODID + ":" + NameConst.BLOCK_LARGE_INGREDIENT_BUFFER)
    public static BlockLargeIngredientBuffer LARGE_INGREDIENT_BUFFER;
    @GameRegistry.ObjectHolder(FluidCraft.MODID + ":" + NameConst.BLOCK_BURETTE)
    public static BlockBurette BURETTE;
    @GameRegistry.ObjectHolder(FluidCraft.MODID + ":" + NameConst.BLOCK_DUAL_INTERFACE)
    public static BlockDualInterface DUAL_INTERFACE;
    @GameRegistry.ObjectHolder(FluidCraft.MODID + ":" + NameConst.BLOCK_GENERAL_LEVEL_MAINTAINER)
    public static BlockGeneralLevelMaintainer GENERAL_LEVEL_MAINTAINER;
    @GameRegistry.ObjectHolder(FluidCraft.MODID + ":" + NameConst.BLOCK_FLUID_ASSEMBLER)
    public static BlockFluidAssembler FLUID_ASSEMBLER;
    public static void init(final RegistryHandler regHandler) {
        regHandler.block(NameConst.BLOCK_FLUID_PACKET_DECODER, new BlockFluidPacketDecoder());
        regHandler.block(NameConst.BLOCK_INGREDIENT_BUFFER, new BlockIngredientBuffer());
        regHandler.block(NameConst.BLOCK_LARGE_INGREDIENT_BUFFER, new BlockLargeIngredientBuffer());
        regHandler.block(NameConst.BLOCK_BURETTE, new BlockBurette());
        regHandler.block(NameConst.BLOCK_DUAL_INTERFACE, new BlockDualInterface());
        regHandler.block(NameConst.BLOCK_GENERAL_LEVEL_MAINTAINER, new BlockGeneralLevelMaintainer());
        regHandler.block(NameConst.BLOCK_FLUID_ASSEMBLER, new BlockFluidAssembler());
    }

}
