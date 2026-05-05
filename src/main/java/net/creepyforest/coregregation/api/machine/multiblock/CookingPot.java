package net.creepyforest.coregregation.api.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.UITemplate;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.gui.widget.TankWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.IUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveWorkableMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.ProgressWidget;
import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_BRICKS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_GEARBOX;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class CookingPot extends PrimitiveWorkableMachine implements IUIMachine {

    public static final MultiblockMachineDefinition CookingPot = REGISTRATE
            .multiblock("cooking_pot", CookingPot::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(CoreGregationRecipeTypes.OVEN_RECIPES)
            .shape(Block.box(2, 0, 2, 14, 10, 14))
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("c", "C")
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where('c', blocks(Blocks.CAMPFIRE))
                    .build())
            .register();
    public CookingPot(IMachineBlockEntity info) {
        super(info);
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        return new ModularUI(176, 200, this, entityPlayer)
                .background(GuiTextures.BACKGROUND)
                .widget(new SlotWidget(importItems.storage, 0, 8, 18, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new LabelWidget(5, 5, getBlockState().getBlock().getDescriptionId()))
                .widget(new SlotWidget(importItems.storage, 1, 26, 18, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 2, 44, 18, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 3, 8, 36, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 4, 26, 36, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 5, 44, 36, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 6, 8, 54, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new LabelWidget(5, 5, getBlockState().getBlock().getDescriptionId()))
                .widget(new SlotWidget(importItems.storage, 7, 26, 54, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 8, 44, 54, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 9, 78, 6, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(importItems.storage, 10, 78, 61, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new TankWidget(importFluids.getStorages()[0], 8, 72, 18, 18, true, true)
                        .setBackground(GuiTextures.FLUID_SLOT)
                        .setFillDirection(ProgressTexture.FillDirection.DOWN_TO_UP)
                        .setShowAmountOverlay(true))



                .widget(new ProgressWidget(recipeLogic::getProgressPercent, 78, 36, 20, 20,
                        GuiTextures.PROGRESS_BAR_ARROW))
                .widget(new SlotWidget(exportItems.storage, 0, 123, 36, true, false)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(new SlotWidget(exportItems.storage, 1, 141, 36, true, false)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.SLOT)))
                .widget(UITemplate.bindPlayerInventory(entityPlayer.getInventory(), GuiTextures.SLOT, 7, 114,
                        true));
    }

    public static void init() {}
}