package nick1666.dev.fabricfine.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import nick1666.dev.fabricfine.Fabricfine;
import nick1666.dev.fabricfine.Zoom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class ZoomMixin {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    @Inject(method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D", at = @At("RETURN"), cancellable = true)
    public void getZoomLevel(CallbackInfoReturnable<Double> callbackInfo) {
        if(Zoom.keyBinding.isPressed()) {
            double fov = callbackInfo.getReturnValue();
            mc.options.smoothCameraEnabled = true;
            callbackInfo.setReturnValue(fov * Zoom.zoomLevel);
        }
        mc.options.smoothCameraEnabled = false;
        Zoom.zoomCam();
    }
}