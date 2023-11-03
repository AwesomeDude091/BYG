package potionstudios.byg.common.world.biome.end;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.sound.BYGSounds;
import potionstudios.byg.common.world.biome.BYGDefaultBiomeFeatures;
import potionstudios.byg.common.world.feature.BYGPlacedFeatures;
import potionstudios.byg.mixin.access.VanillaBiomeAccess;

public class BYGEndBiomes {

    public static Biome bulbisGardens(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        BYGDefaultBiomeFeatures.addMixedColorBulbisTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBulbisOddity(generationSettings);
        BYGDefaultBiomeFeatures.addBulbisAnomaly(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(10040012).waterFogColor(10040012).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WITCH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }


    public static Biome crypticWastes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);

        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.CRYPTIC_CAVE);
        BYGDefaultBiomeFeatures.addCrypticVents(generationSettings);
        BYGDefaultBiomeFeatures.addCrypticBramble(generationSettings);
        BYGDefaultBiomeFeatures.addCrypticFire(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.CRYPTIC_SPIKE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BYGPlacedFeatures.CRYPTIC_REDSTONE);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));

        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome etherealIslands(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        System.out.println("Etheral Islands Builder was Called");
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);

        BYGDefaultBiomeFeatures.addEtherPlants(generationSettings);
        BYGDefaultBiomeFeatures.addEtherFoliage(generationSettings);
        BYGDefaultBiomeFeatures.addSparseEtherTrees(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(3905655).waterFogColor(3905655).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome impariusGrove(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);

        BYGDefaultBiomeFeatures.addImpariusPlants(generationSettings);
        BYGDefaultBiomeFeatures.addFungalImparius(generationSettings);
        BYGDefaultBiomeFeatures.addLargeImpariusMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        BYGDefaultBiomeFeatures.addEnderLily(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.IMPARIUS_GROVE_DELTA);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(3722412).waterFogColor(3722412).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome ivisFields(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);

        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.IVIS_FIELDS_SPIKE);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.IVIS_FIELDS_COLUMN);
        BYGDefaultBiomeFeatures.addIvisPlants(generationSettings);
        BYGDefaultBiomeFeatures.addSparseBulbisAnomaly(generationSettings);
        BYGDefaultBiomeFeatures.addSparsePurpleBulbisTrees(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WITCH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome nightshadeForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);

        BYGDefaultBiomeFeatures.addNightshadePlants(generationSettings);
        BYGDefaultBiomeFeatures.addNightShadeTrees(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 1, 1, 2));
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }


    public static Biome shatteredDesert(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        BYGDefaultBiomeFeatures.addShatteredDesertPlants(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome viscalIsles(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);

        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.ISLANDS);
        BYGDefaultBiomeFeatures.addHangingTheriumLanterns(generationSettings);
        BYGDefaultBiomeFeatures.addDeadEtherTrees(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultEndFeatures(generationSettings);

        generationSettings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BYGPlacedFeatures.HANGING_THERIUM_LANTERNS);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(1415511).waterFogColor(2005339).fogColor(8339307).skyColor(VanillaBiomeAccess.byg_invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_VISCAL_ISLES_LOOP.asHolder()).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0010D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}