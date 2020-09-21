package voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.Random;
import java.util.Set;

public class AspenTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public AspenTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int minHeight = config.getMinHeight();
        Biome biome = worldIn.getBiome(pos);
        if (biome == BYGBiomeList.ASPENFORESTHILLS)
            minHeight = config.getMinHeight() + 4;

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + minHeight;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 13, 5, 5, isSapling)) {
                return false;
            } else {
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //Bottom Leaves
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 3, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);


                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}