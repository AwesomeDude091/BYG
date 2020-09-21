package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SoulShroomTree2 extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public SoulShroomTree2(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);
        int randTreeHeight = 7 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.add(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 7, 0));
                this.soulShroomSporeEnd(worldIn, mainmutable.add(-2, 3, 1));
                this.soulShroomSpore(worldIn, mainmutable.add(-2, 4, 1));
                this.soulShroomSpore(worldIn, mainmutable.add(-2, 5, 1));
                this.soulShroomSporeEnd(worldIn, mainmutable.add(0, 5, -2));
                this.soulShroomSporeEnd(worldIn, mainmutable.add(1, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 11, 0));
            }
        }
        return true;
    }

    private void soulShroomSporeEnd(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlockList.SOUL_SHROOM_SPORE_END.getDefaultState());
        }
    }

    //Leaves Placement
    private void soulShroomSpore(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlockList.SOUL_SHROOM_SPORE.getDefaultState());
        }
    }
}