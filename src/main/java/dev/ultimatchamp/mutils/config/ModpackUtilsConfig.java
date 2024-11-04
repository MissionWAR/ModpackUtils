package dev.ultimatchamp.mutils.config;

import dev.isxander.yacl3.api.NameableEnum;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;

//? if fabric {
import net.fabricmc.loader.api.FabricLoader;
//?} else neo {
/*import net.neoforged.fml.loading.FMLPaths;
*///?} else {
/*import net.minecraftforge.fml.loading.FMLPaths;
*///?}

public class ModpackUtilsConfig {
    public static Path CONFIG_DIR =
            //? if fabric {
            FabricLoader.getInstance().getConfigDir()
            //?} else {
            /*FMLPaths.CONFIGDIR.get()
            *///?}
            ;

    private static final ConfigClassHandler<ModpackUtilsConfig> GSON = ConfigClassHandler.createBuilder(ModpackUtilsConfig.class)
            .id(Identifier.of("mutils", "config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(CONFIG_DIR.resolve("mutils/mutils.json5"))
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry
    public boolean menuAlert = false;

    @SerialEntry
    public boolean chatAlert = false;

    @SerialEntry
    public String chatMessage = "There is an update available for your modpack!";

    @SerialEntry
    public Platforms platform = Platforms.MODRINTH;

    public enum Platforms implements NameableEnum {
        CUSTOM("generator.custom"),
        MODRINTH("mutils.modrinth");

        private final String displayName;

        Platforms(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public Text getDisplayName() {
            return Text.translatable(displayName);
        }
    }

    @SerialEntry
    public String modpackName = "My Modpack";

    @SerialEntry
    public String modpackId = "my-modpack";

    @SerialEntry
    public String modpackHome = "https://github.com/me/My-Modpack";

    @SerialEntry
    public String localVersion = "1.0.0";

    @SerialEntry
    public String versionAPI = "https://raw.githubusercontent.com/me/My-Modpack/main/Packwiz/pack.toml";

    @SerialEntry
    public String changelogLink = "https://raw.githubusercontent.com/me/My-Modpack/main/CHANGELOG.md";

    @SerialEntry
    public boolean customIcon = false;

    @SerialEntry
    public boolean customTitle = false;

    @SerialEntry
    public String title = "<modpack-name> <version> | Minecraft <mc>";

    //? if fabric {
    @SerialEntry
    public MmcStyle mainMenuCreditsIntegeration = MmcStyle.OFF;
    //?}

    @SerialEntry
    public boolean ramMenuAlert = false;

    @SerialEntry
    public boolean ramChatAlert = false;

    @SerialEntry
    public Integer minRam = 8192;

    public enum MmcStyle implements NameableEnum {
        OFF("options.off"),
        NORMAL("options.difficulty.normal"),
        FANCY("options.graphics.fancy");

        private final String displayName;

        MmcStyle(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public Text getDisplayName() {
            return Text.translatable(displayName);
        }
    }

    public static ConfigClassHandler<ModpackUtilsConfig> handler() {
        return GSON;
    }

    public static void load() {
        GSON.load();
    }

    public static ModpackUtilsConfig instance() {
        return GSON.instance();
    }

    public static Screen createScreen(@Nullable Screen parent) {
        return ModpackUtilsGui.createConfigScreen(parent);
    }
}
