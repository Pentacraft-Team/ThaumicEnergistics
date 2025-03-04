package thaumicenergistics.common.integration;

import appeng.api.config.Upgrades;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import thaumicenergistics.api.ThEApi;
import thaumicenergistics.common.blocks.BlockArcaneAssembler;
import thaumicenergistics.common.tiles.TileEssentiaProvider;
import thaumicenergistics.common.utils.EffectiveSide;
import thaumicenergistics.common.utils.ThELog;

/**
 * Integrates ThE with other mods.
 *
 * @author Nividica
 *
 */
public final class IntegrationCore {

    @SideOnly(Side.CLIENT)
    private static void integrateWithClientMods() {
        if (Loader.isModLoaded("NotEnoughItems")) {
            // Integrate with NEI
            ModuleNEI.init();
        }

        if (Loader.isModLoaded("Waila")) {
            // Integrate with Waila
            ModuleWaila.init();
        }
    }

    /**
     * Integrate with all modules
     */
    public static void init() {
        long startTime = ThELog.beginSection("Integration");
        // Is client side?
        if (EffectiveSide.isClientSide()) {
            // Integrate with client mods
            IntegrationCore.integrateWithClientMods();
        }
        if (Loader.isModLoaded("ComputerCraft")) {
            ModuleCC.init();
        }
        if (Loader.isModLoaded("extracells")) {
            ModuleEC2.init();
        }
        if (Loader.isModLoaded("ae2fc")) {
            ModuleAe2fc.init();
        }
        // Send a message to Thaumic Tinkerer to blacklist the essentia provider from its CC support
        FMLInterModComms.sendMessage("ThaumicTinkerer", "AddCCBlacklist", TileEssentiaProvider.class.getName());

        // Register the Arcane Assembler for upgrades
        Upgrades.SPEED.registerItem(
                ThEApi.instance().blocks().ArcaneAssembler.getStack(),
                BlockArcaneAssembler.MAX_SPEED_UPGRADES);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_1k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_4k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_16k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_64k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_256k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_1024k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_4096k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_16384k.getStack(), 1);
        Upgrades.VOID_OVERFLOW.registerItem(ThEApi.instance().items().EssentiaCell_Quantum.getStack(), 1);

        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_1k.getStack(), 1);
        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_4k.getStack(), 1);
        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_16k.getStack(), 1);
        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_64k.getStack(), 1);
        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_256k.getStack(), 1);
        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_1024k.getStack(), 1);
        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_4096k.getStack(), 1);
        Upgrades.DISTRIBUTION.registerItem(ThEApi.instance().items().EssentiaCell_16384k.getStack(), 1);

        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_1k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_4k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_16k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_64k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_256k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_1024k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_4096k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_16384k.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_Quantum.getStack(), 1);
        Upgrades.STICKY.registerItem(ThEApi.instance().items().EssentiaCell_Singularity.getStack(), 1);

        ThELog.endSection("Integration", startTime);
    }
}
