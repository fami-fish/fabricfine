package nick1666.dev.fabricfine;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Zoom {
    private static boolean currentlyZooming;
    public static KeyBinding keyBinding;
    public static final double zoomLevel = 0.23;

    public static void Initialize() {
        keyBinding = new KeyBinding("key.fabricfine.zoom", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_C, "category.fabricfine");
        KeyBindingHelper.registerKeyBinding(keyBinding);
        currentlyZooming = false;
    }

    public static void zoomCam() {
        if (keyBinding.isPressed() && !currentlyZooming) {
            currentlyZooming = true;
        }
        if (keyBinding.isPressed() && currentlyZooming) {
            currentlyZooming = false;
        }
    }

}
