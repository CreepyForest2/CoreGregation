package net.creepyforest.coregregation.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class ScreenEvents {

    @SubscribeEvent
    public static void onTitleScreenInit(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof TitleScreen titleScreen) {
            Button button = Button.builder(Component.literal("Terrain Config"),
                            b -> Minecraft.getInstance().setScreen(new TerrainConfigScreen(titleScreen)))

                    .bounds(10, 10, 100, 20)
                    .build();
            event.addListener(button);
        }
    }
}