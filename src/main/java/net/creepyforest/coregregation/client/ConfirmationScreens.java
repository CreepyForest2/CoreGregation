package net.creepyforest.coregregation.client;

import com.mojang.logging.LogUtils;
import net.creepyforest.coregregation.common.world_preset.TerrainConfigLogic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;

public class ConfirmationScreens {

    public static class TerraTonicScreen extends Screen {
        private final Screen parent;



        public TerraTonicScreen(Screen parent) {
            super(Component.literal("Tectonic + Terralith"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            int w = 100, h = 20, gap = 4;
            int y = this.height - 28;
            this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, b -> {
                        try {
                            TerrainConfigLogic.terraTonicActive();
                            Minecraft.getInstance().stop();
                        } catch (Exception exception) {
                            Logger logger = LogUtils.getLogger();
                            logger.error("Failed to apply terrain preset: TerraTonic", exception);
                        }
                        Minecraft.getInstance().stop();
                this.onClose();
            })
                    .bounds(this.width / 2 - w - gap / 2, y, w, h)
                    .build());

            this.addRenderableWidget(Button.builder(CommonComponents.GUI_BACK, b -> this.onClose())
                    .bounds(this.width / 2 + gap / 2, y, w, h)
                    .build());
        }

        @Override
        public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
            this.renderBackground(graphics);
            graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
            super.render(graphics, mouseX, mouseY, partialTick);

            graphics.drawCenteredString(this.font,
                    Component.literal("This preset may not work very fast with slower computers! Proceed? " +
                            "If yes, the game will close to apply the changes."),
                    this.width / 2, 50, 0xAAAAAA);
        }

        @Override
        public void onClose() {
            this.minecraft.setScreen(parent);
        }
    }



public static class ETWWEEScreen extends Screen {

    private final Screen parent;
    public ETWWEEScreen(Screen parent) {
        super(Component.literal("Epic Terrain + WWEE (Default preset)"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int w = 100, h = 20, gap = 4;
        int y = this.height - 28;
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, b -> {
                    try {
                        TerrainConfigLogic.epicTerrainAndWWEEActive();
                        Minecraft.getInstance().stop();
                    } catch (Exception exception) {
                        Logger logger = LogUtils.getLogger();
                        logger.error("Failed to apply terrain preset: Epic Terrain + WWEE", exception);
                    }
                    Minecraft.getInstance().stop();
                    this.onClose();
                })
                .bounds(this.width / 2 - w - gap / 2, y, w, h)
                .build());

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_BACK, b -> this.onClose())
                .bounds(this.width / 2 + gap / 2, y, w, h)
                .build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(graphics, mouseX, mouseY, partialTick);

        graphics.drawCenteredString(this.font,
                Component.literal("This preset requires a beefy computer! Proceed? " +
                        "If yes, the game will close to apply the changes."),
                this.width / 2, 50, 0xAAAAAA);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }
}
public static class LithosphereAndStillLifeScreen extends Screen {

    private final Screen parent;

    public LithosphereAndStillLifeScreen(Screen parent) {
        super(Component.literal("Lithosphere + Still Life"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int w = 100, h = 20, gap = 4;
        int y = this.height - 28;
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, b -> {
                    try {
                        TerrainConfigLogic.lithoSphereAndStillLifeActive();
                        Minecraft.getInstance().stop();
                    } catch (Exception exception) {
                        Logger logger = LogUtils.getLogger();
                        logger.error("Failed to apply terrain preset: Lithosphere + Still Life", exception);
                    }
                    Minecraft.getInstance().stop();
                    this.onClose();
                })
                .bounds(this.width / 2 - w - gap / 2, y, w, h)
                .build());

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_BACK, b -> this.onClose())
                .bounds(this.width / 2 + gap / 2, y, w, h)
                .build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(graphics, mouseX, mouseY, partialTick);

        graphics.drawCenteredString(this.font,
                Component.literal("This preset requires a beefy computer! Proceed? " +
                        "If yes, the game will close to apply the changes."),
                this.width / 2, 50, 0xAAAAAA);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }
}

    public static class VaniilaTerrainScreen extends Screen {

        private final Screen parent;

        public VaniilaTerrainScreen(Screen parent) {
            super(Component.literal("Vanilla Terrain"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            int w = 100, h = 20, gap = 4;
            int y = this.height - 28;
            this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, b -> {
                        try {
                            TerrainConfigLogic.vanillaTerrainActive();
                            Minecraft.getInstance().stop();
                        } catch (Exception exception) {
                            Logger logger = LogUtils.getLogger();
                            logger.error("Failed to apply terrain preset: Vanilla", exception);
                        }
                        Minecraft.getInstance().stop();
                        this.onClose();
                    })
                    .bounds(this.width / 2 - w - gap / 2, y, w, h)
                    .build());

            this.addRenderableWidget(Button.builder(CommonComponents.GUI_BACK, b -> this.onClose())
                    .bounds(this.width / 2 + gap / 2, y, w, h)
                    .build());
        }

        @Override
        public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
            this.renderBackground(graphics);
            graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
            super.render(graphics, mouseX, mouseY, partialTick);

            graphics.drawCenteredString(this.font,
                    Component.literal("Proceed? If yes, the game will close to apply the changes."),
                    this.width / 2, 50, 0xAAAAAA);
        }

        @Override
        public void onClose() {
            this.minecraft.setScreen(parent);
        }
    }


}
