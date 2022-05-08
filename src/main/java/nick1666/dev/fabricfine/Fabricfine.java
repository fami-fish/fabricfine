package nick1666.dev.fabricfine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class Fabricfine implements ClientModInitializer {
    public static final String MOD_ID = "ffm";

    @Override
    public void onInitializeClient() {
        Zoom.Initialize();
    }
}
