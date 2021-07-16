package me.regexmc.hitboxrebind;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@Mod(modid = "hitboxrebind", name = "Hitbox Rebind", version = "1.0")
public class Main {
    private static KeyBinding hitboxesKeybind;

    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        hitboxesKeybind = new KeyBinding("Hitboxes", Keyboard.KEY_RBRACKET, "Hitboxes");
        ClientRegistry.registerKeyBinding(hitboxesKeybind);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(InputEvent.KeyInputEvent event) {
        if (hitboxesKeybind.isPressed())
            Minecraft.getMinecraft().getRenderManager().setDebugBoundingBox(!Minecraft.getMinecraft().getRenderManager().isDebugBoundingBox());
    }
}
