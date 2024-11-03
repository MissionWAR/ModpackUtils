package dev.ultimatchamp.mutils.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.*;
import dev.isxander.yacl3.gui.controllers.cycling.EnumController;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ModpackUtilsGui {
    public static Screen createConfigScreen(Screen parent) {
        return YetAnotherConfigLib.create(ModpackUtilsConfig.handler(), (defaults, config, builder) -> builder
                .title(Text.translatable("mutils.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("mutils.category.update"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("mutils.menuAlert"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.menuAlert.desc"))
                                        .build())
                                .binding(
                                        defaults.menuAlert,
                                        () -> config.menuAlert,
                                        (value) -> config.menuAlert = value
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("mutils.chatAlert"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.chatAlert.desc"))
                                        .build())
                                .binding(
                                        defaults.chatAlert,
                                        () -> config.chatAlert,
                                        (value) -> config.chatAlert = value
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("gui.abuseReport.type.chat"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.chatMessage.desc"))
                                        .build())
                                .binding(
                                        defaults.chatMessage,
                                        () -> config.chatMessage,
                                        (value) -> config.chatMessage = value
                                )
                                .controller(StringControllerBuilder::create)
                                .build())
                        .option(Option.<ModpackUtilsConfig.Platforms>createBuilder()
                                .name(Text.translatable("telemetry.property.platform.title"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.platform.desc"))
                                        .build())
                                .binding(
                                        defaults.platform,
                                        () -> config.platform,
                                        (value) -> config.platform = value
                                )
                                .customController(opt -> new EnumController<>(opt, ModpackUtilsConfig.Platforms.class))
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("mutils.modpackName"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.modpackName.desc"))
                                        .build())
                                .binding(
                                        defaults.modpackName,
                                        () -> config.modpackName,
                                        (value) -> config.modpackName = value
                                )
                                .controller(StringControllerBuilder::create)
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("mutils.modpackId"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.modpackId.desc"))
                                        .build())
                                .binding(
                                        defaults.modpackId,
                                        () -> config.modpackId,
                                        (value) -> config.modpackId = value
                                )
                                .available(ModpackUtilsConfig.instance().platform != ModpackUtilsConfig.Platforms.CUSTOM)
                                .controller(StringControllerBuilder::create)
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("mutils.modpackHome"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.modpackHome.desc"))
                                        .build())
                                .binding(
                                        defaults.modpackHome,
                                        () -> config.modpackHome,
                                        (value) -> config.modpackHome = value
                                )
                                .available(ModpackUtilsConfig.instance().platform == ModpackUtilsConfig.Platforms.CUSTOM)
                                .controller(StringControllerBuilder::create)
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("mutils.localVersion"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.localVersion.desc"))
                                        .build())
                                .binding(
                                        defaults.localVersion,
                                        () -> config.localVersion,
                                        (value) -> config.localVersion = value
                                )
                                .controller(StringControllerBuilder::create)
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("mutils.versionAPI"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.versionAPI.desc"))
                                        .build())
                                .binding(
                                        defaults.versionAPI,
                                        () -> config.versionAPI,
                                        (value) -> config.versionAPI = value
                                )
                                .available(ModpackUtilsConfig.instance().platform == ModpackUtilsConfig.Platforms.CUSTOM)
                                .controller(StringControllerBuilder::create)
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("mutils.changelogLink"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.changelogLink.desc"))
                                        .build())
                                .binding(
                                        defaults.changelogLink,
                                        () -> config.changelogLink,
                                        (value) -> config.changelogLink = value
                                )
                                .available(ModpackUtilsConfig.instance().platform == ModpackUtilsConfig.Platforms.CUSTOM)
                                .controller(StringControllerBuilder::create)
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("mutils.category.window"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("mutils.customIcon"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.customIcon.desc"))
                                        .build())
                                .binding(
                                        defaults.customIcon,
                                        () -> config.customIcon,
                                        (value) -> config.customIcon = value
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("mutils.customTitle"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.customTitle.desc"))
                                        .build())
                                .binding(
                                        defaults.customTitle,
                                        () -> config.customTitle,
                                        (value) -> config.customTitle = value
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<String>createBuilder()
                                .name(Text.translatable("mco.backup.entry.name"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.cTitle.desc"))
                                        .build())
                                .binding(
                                        defaults.title,
                                        () -> config.title,
                                        (value) -> config.title = value
                                )
                                .available(ModpackUtilsConfig.instance().customTitle)
                                .controller(StringControllerBuilder::create)
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("mutils.category.mmc"))
                        .option(Option.<ModpackUtilsConfig.MmcStyle>createBuilder()
                                .name(Text.translatable("mutils.mmcIntg"))
                                .description(OptionDescription.createBuilder()
                                        .text(Text.translatable("mutils.mmcIntg.desc"))
                                        .build())
                                .binding(
                                        defaults.mainMenuCreditsIntegeration,
                                        () -> config.mainMenuCreditsIntegeration,
                                        (value) -> config.mainMenuCreditsIntegeration = value
                                )
                                .customController(opt -> new EnumController<>(opt, ModpackUtilsConfig.MmcStyle.class))
                                .build())
                        .build())
                .save(ModpackUtilsConfig.handler()::save)
        ).generateScreen(parent);
    }
}
