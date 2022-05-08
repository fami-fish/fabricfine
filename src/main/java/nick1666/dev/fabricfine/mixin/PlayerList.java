package nick1666.dev.fabricfine.mixin;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.util.Identifier;
import nick1666.dev.fabricfine.PlayerHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(PlayerListEntry.class)
public class PlayerList {
    @Shadow
    @Final
    private GameProfile profile;
    @Shadow
    @Final
    private Map<MinecraftProfileTexture.Type, Identifier> textures;
    private boolean loadedCapeTexture = false;

    public PlayerList() {
    }

    @Inject(method = "getCapeTexture", at = @At("HEAD"))
    private void injectedCapeTexture(CallbackInfoReturnable<Identifier> cir) {
        fetchCapeTexture();
    }

    @Inject(method = "getElytraTexture", at = @At("HEAD"))
    private void injectedElytraTexture(CallbackInfoReturnable<Identifier> cir) {
        fetchCapeTexture();
    }

    private void fetchCapeTexture() {
        if (loadedCapeTexture) return;
        loadedCapeTexture = true;
        Map<MinecraftProfileTexture.Type, Identifier> textures = this.textures;
        PlayerHandler.loadPlayerCape(this.profile, id -> {
            textures.put(MinecraftProfileTexture.Type.CAPE, id);
        });
    }
}
