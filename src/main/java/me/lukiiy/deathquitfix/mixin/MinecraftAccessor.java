package me.lukiiy.deathquitfix.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Screen.class)
public interface MinecraftAccessor {
    @Accessor("minecraft")
    Minecraft deathQuit$getMinecraft();
}

