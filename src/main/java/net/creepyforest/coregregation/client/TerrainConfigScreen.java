package net.creepyforest.coregregation.client;

import net.creepyforest.coregregation.common.world_preset.TerrainConfigLogic;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;


public class TerrainConfigScreen extends Screen {

    private final Screen parent;

    public TerrainConfigScreen(Screen parent) {
        super(Component.literal("Terrain Config Screen"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, b -> this.onClose())
                .bounds(this.width / 2 - 100, this.height - 28, 200, 20)
                .build());

        int w = 260, h = 20, gap = 4;
        int x = this.width / 2 - w / 2;
        int y = this.height / 4;

        if(TerrainConfigLogic.isTerraTonicActive) {
            addRenderableWidget(Button.builder(Component.literal("Tectonic + Terralith (Currently active)"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.TerraTonicScreen(this));
            }).bounds(x, y, w, h).build());
        } else {
            addRenderableWidget(Button.builder(Component.literal("Tectonic + Terralith"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.TerraTonicScreen(this));
            }).bounds(x, y, w, h).build());
        }

        if(TerrainConfigLogic.isEpicTerrainandWWEEActive) {
            addRenderableWidget(Button.builder(Component.literal("Epic Terrain + WWEE (default) (Currently active)"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.ETWWEEScreen(this));
            }).bounds(x, y + (h + gap), w, h).build());
        } else {
            addRenderableWidget(Button.builder(Component.literal("Epic Terrain + WWEE"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.ETWWEEScreen(this));
            }).bounds(x, y + (h + gap), w, h).build());
        }

        if(TerrainConfigLogic.isLithoSphereAndStillLifeActive) {
            addRenderableWidget(Button.builder(Component.literal("Lithosphere + Still Life (Currently active)"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.LithosphereAndStillLifeScreen(this));
            }).bounds(x, y + 2 * (h + gap), w, h).build());
        } else {
            addRenderableWidget(Button.builder(Component.literal("Lithosphere + Still Life"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.LithosphereAndStillLifeScreen(this));
            }).bounds(x, y + 2 * (h + gap), w, h).build());
        }


        if(TerrainConfigLogic.isVanillaTerrainActive) {
            addRenderableWidget(Button.builder(Component.literal("Vanilla (None) (Currently active)"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.VaniilaTerrainScreen(this));
            }).bounds(x, y + 3 * (h + gap), w, h).build());
        } else {
            addRenderableWidget(Button.builder(Component.literal("Vanilla (None)"), b -> {
                this.minecraft.setScreen(new ConfirmationScreens.VaniilaTerrainScreen(this));
            }).bounds(x, y + 3 * (h + gap), w, h).build());
        }


    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }
}




