package net.creepyforest.coregregation.api.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.UITemplate;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.gui.widget.TankWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.IUIMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveWorkableMachine;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.ProgressWidget;
import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Bloomery extends PrimitiveWorkableMachine implements IUIMachine {

    public static final MultiblockMachineDefinition BLOOMERY = REGISTRATE
            .multiblock("bloomery", Bloomery::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(CoreGregationRecipeTypes.BLOOMERY_RECIPES)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("BBB", "BBB", " B ", " B ")
                    .aisle("BBB", "B#B", "B#B", "B#B")
                    .aisle("BBB", "BCB", " B ", " B " )
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where('B', blocks(Blocks.MUD_BRICKS))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    ResourceLocation.parse("minecraft:block/mud_bricks"),
                    GTCEu.id("block/multiblock/primitive_blast_furnace")))
            .register();
    public Bloomery(IMachineBlockEntity info) {
        super(info);
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        return new ModularUI(176, 166, this, entityPlayer)
                .background(GuiTextures.PRIMITIVE_BACKGROUND)
                .widget(new LabelWidget(5, 5, getBlockState().getBlock().getDescriptionId()))
                .widget(new SlotWidget(importItems.storage, 0, 16, 38, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_INGOT_OVERLAY)))
                .widget(new SlotWidget(importItems.storage, 1, 34, 38, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_DUST_OVERLAY)))
                .widget(new SlotWidget(importItems.storage, 2, 52, 38, true, true)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_FURNACE_OVERLAY)))
                .widget(new ProgressWidget(recipeLogic::getProgressPercent, 77, 39, 20, 15,
                        GuiTextures.PRIMITIVE_BLAST_FURNACE_PROGRESS_BAR))
                .widget(new SlotWidget(exportItems.storage, 0, 104, 38, true, false)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_INGOT_OVERLAY)))
                .widget(new SlotWidget(exportItems.storage, 1, 122, 38, true, false)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_DUST_OVERLAY)))
                .widget(new SlotWidget(exportItems.storage, 2, 140, 38, true, false)
                        .setBackgroundTexture(
                                new GuiTextureGroup(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_DUST_OVERLAY)))
                .widget(UITemplate.bindPlayerInventory(entityPlayer.getInventory(),
                        GuiTextures.PRIMITIVE_SLOT, 7, 84, true));
    }

    public static void init() {}
}
