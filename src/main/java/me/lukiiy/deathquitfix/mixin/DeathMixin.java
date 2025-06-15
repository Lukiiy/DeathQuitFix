package me.lukiiy.deathquitfix.mixin;

import net.minecraft.class_217;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeathScreen.class)
public class DeathMixin {
    @Inject(method = "buttonClicked", at = @At("HEAD"), cancellable = true)
    private void deathQuit$fix(ButtonWidget button, CallbackInfo ci) {
        if (button.id == 2) {
            Minecraft minecraft = ((MinecraftAccessor) this).deathQuit$getMinecraft();

            minecraft.field_2773.method_1990(class_217.field_823, 1);
            if (minecraft.isWorldRemote()) minecraft.world.method_293();
            minecraft.setWorld(null);
            minecraft.setScreen(new TitleScreen());
            ci.cancel();
        }
    }
}
