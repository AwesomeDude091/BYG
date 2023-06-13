package potionstudios.byg.datagen;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.BYGDamageTypes;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.common.world.feature.features.BYGFeaturesUtil;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;
import potionstudios.byg.common.world.preset.BYGWorldPresets;
import potionstudios.byg.common.world.structure.BYGStructureSets;
import potionstudios.byg.common.world.structure.BYGStructures;
import potionstudios.byg.common.world.structure.village.pool.StructureTemplatePoolFactory;
import potionstudios.byg.datagen.providers.BYGRecipeProviders;
import potionstudios.byg.datagen.providers.BYGWoodAssetsProvider;

import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = BYG.MOD_ID)
public class BYGDataGen {


    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, pContext -> {
                BYGFeaturesUtil.CONFIGURED_FEATURES_FACTORIES.forEach((biomeResourceKey, factory) -> {
                    pContext.register(biomeResourceKey, factory.generate(pContext));
                });
            })
            .add(Registries.PLACED_FEATURE, pContext -> {
                BYGPlacedFeaturesUtil.PLACED_FEATURE_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext.lookup(Registries.CONFIGURED_FEATURE)));
                });
            })
            .add(Registries.BIOME, pContext -> {
                BYGBiomes.BIOME_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext.lookup(Registries.PLACED_FEATURE), pContext.lookup(Registries.CONFIGURED_CARVER)));

                });
            }).add(Registries.STRUCTURE, pContext -> {
                BYGStructures.STRUCTURE_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            }).add(Registries.STRUCTURE_SET, pContext -> {
                BYGStructureSets.STRUCTURE_SET_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext.lookup(Registries.STRUCTURE)));

                });
            }).add(Registries.TEMPLATE_POOL, pContext -> {
                StructureTemplatePoolFactory.STRUCTURE_TEMPLATE_POOL_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            }).add(Registries.WORLD_PRESET, pContext -> {
                BYGWorldPresets.WORLD_PRESET_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            }).add(Registries.DAMAGE_TYPE, pContext -> {
                BYGDamageTypes.DAMAGE_TYPE_FACTORIES.forEach((resourceKey, factory) -> {
                    pContext.register(resourceKey, factory.generate(pContext));

                });
            });

    @SubscribeEvent
    static void onDatagen(final GatherDataEvent event) {
        final var gen = event.getGenerator();

        gen.addProvider(event.includeServer(), new BYGRecipeProviders(gen));
        gen.addProvider(event.includeServer(), new BYGWoodAssetsProvider(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(gen.getPackOutput(), event.getLookupProvider(), BUILDER, Set.of(BYG.MOD_ID)));
    }

}
