package nick1666.dev.fabricfine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
public class customPlayerCapes {
    public static final Logger LOGGER = LoggerFactory.getLogger("ffm");
    public static Map<String, String> playerMap = new HashMap<String, String>()
    {
        {
            put("Arky", "https://cdn.discordapp.com/attachments/773983707299184703/972547402357694544/Birthday.png");
            put("Pythagoras_314", "https://cdn.discordapp.com/attachments/773983707299184703/972531345983164486/sculk_cape.png");
        }
    };
}