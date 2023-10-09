package potionstudios.byg.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.screen.HypogealImperiumScreen;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.common.entity.boat.BYGBoat;
import potionstudios.byg.common.entity.boat.BYGBoatRenderer;
import potionstudios.byg.common.particles.FallingLeafParticle;
import potionstudios.byg.common.particles.TheriumGlint;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class BYGClient {

    public static void load() {
        BYG.logDebug("BYG: \"Client Setup\" Event Starting...");
//        BiomepediaClientData.getConfig(true);
//        EntityRendererRegistry.register(BYGEntities.MAN_O_WAR, ManOWarRenderer::new);
        BYG.logInfo("BYG: \"Client Setup\" Event Complete!");
    }

    public static void threadSafeLoad() {
        MenuScreens.register(BYGMenuTypes.HYPOGEAL_CONTAINER.get(), HypogealImperiumScreen::new);
    }

    public static void registerParticles(ParticleStrategy strategy) {
        strategy.register(BYGParticleTypes.THERIUM_GLINT.get(), TheriumGlint.Provider::new);
        strategy.register(BYGParticleTypes.WITCH_HAZEL_LEAVES.get(), FallingLeafParticle.Provider::new);
        strategy.register(BYGParticleTypes.PINK_CHERRY_BLOSSOM_LEAVES.get(), FallingLeafParticle.Provider::new);
        strategy.register(BYGParticleTypes.WHITE_CHERRY_BLOSSOM_LEAVES.get(), FallingLeafParticle.Provider::new);
        strategy.register(BYGParticleTypes.SILVER_MAPLE_LEAVES.get(), FallingLeafParticle.Provider::new);
        strategy.register(BYGParticleTypes.RED_MAPLE_LEAVES.get(), FallingLeafParticle.Provider::new);
    }

    public interface ParticleStrategy {
        <T extends ParticleOptions> void register(ParticleType<T> particle, ParticleEngine.SpriteParticleRegistration<T> provider);
    }

    public static void registerLayerDefinitions(final BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
        for (BYGBoat.BYGType value : BYGBoat.BYGType.values()) {
            consumer.accept(BYGBoatRenderer.createBoatModelName(value), BoatModel::createBodyModel);
            consumer.accept(BYGBoatRenderer.createChestBoatModelName(value), ChestBoatModel::createBodyModel);
        }
    }
}
