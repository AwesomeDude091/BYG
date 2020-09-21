package voronoiaoc.byg.common.world.feature.features.overworld.trees.maple;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class MapleTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public MapleTree1(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(config, rand, changedBlocks, worldIn, mainmutable, boundsIn);

                    mainmutable.move(Direction.UP);
                }
                mainmutable.setPos(pos);

                //Stump
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 0, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 0, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, 1, 0), boundsIn);


                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 1, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 1, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 2, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 4, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 5, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 2, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 3, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(5, randTreeHeight + 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, -6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 4, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 5, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 5, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 5, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 5, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 5, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 5, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-2, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-6, randTreeHeight + 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-3, randTreeHeight + 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(0, randTreeHeight + 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-1, randTreeHeight + 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(4, randTreeHeight + 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 5, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 6, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-5, randTreeHeight + 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(-4, randTreeHeight + 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(1, randTreeHeight + 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(3, randTreeHeight + 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.add(2, randTreeHeight + 6, 3), boundsIn);
            }
        }
        return true;
    }


    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MAPLE_LOG.getDefaultState(), boundingBox);
        }
    }


    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.MAPLE_LOG.getDefaultState(), boundingBox);
        }
    }


    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().setPos(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.MAPLE_LEAVES.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 1;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}