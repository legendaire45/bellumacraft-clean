package Bellumacraft.stair;

import net.minecraft.src.*;

import java.util.ArrayList;
import java.util.Random;

public class BlockStairLog extends Block 
{
    private Block modelBlock;

    public BlockStairLog(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
        this.modelBlock = planks;
        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setStepSound(planks.stepSound);
        this.setCreativeTab(CreativeTabs.tabBlock);
        //this.setLightOpacity(255);
    }

/**
 * Updates the blocks bounds based on its current state. Args: world, x, y, z
 */
public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
{
    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
}

/**
 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
 * cleared to be reused)
 */
public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
    return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
}

/**
 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
 */
public boolean isOpaqueCube()
{
    return false;
}

/**
 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
 */
public boolean renderAsNormalBlock()
{
    return false;
}

/**
 * The type of render function that is called for this block
 */
public int getRenderType()
{
    return 10;
}

/**
 * Adds to the supplied array any colliding bounding boxes with the passed in bounding box. Args: world, x, y, z,
 * axisAlignedBB, arrayList
 */
public void getCollidingBoundingBoxes(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList, Entity par7Entity)
{
    int var7 = par1World.getBlockMetadata(par2, par3, par4);
    int var8 = var7 & 3;
    float var9 = 0.0F;
    float var10 = 0.5F;
    float var11 = 0.5F;
    float var12 = 1.0F;

    if ((var7 & 4) != 0)
    {
        var9 = 0.5F;
        var10 = 1.0F;
        var11 = 0.0F;
        var12 = 0.5F;
    }

    this.setBlockBounds(0.0F, var9, 0.0F, 1.0F, var10, 1.0F);
    super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

    if (var8 == 0)
    {
        this.setBlockBounds(0.5F, var11, 0.0F, 1.0F, var12, 1.0F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
    }
    else if (var8 == 1)
    {
        this.setBlockBounds(0.0F, var11, 0.0F, 0.5F, var12, 1.0F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
    }
    else if (var8 == 2)
    {
        this.setBlockBounds(0.0F, var11, 0.5F, 1.0F, var12, 1.0F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
    }
    else if (var8 == 3)
    {
        this.setBlockBounds(0.0F, var11, 0.0F, 1.0F, var12, 0.5F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
    }

    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
}

/**
 * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
 */
public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
{
    this.modelBlock.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
}

/**
 * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
 */
public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
{
    this.modelBlock.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
}

/**
 * Returns how much this block can resist explosions from the passed in entity.
 */
public float getExplosionResistance(Entity par1Entity)
{
    return this.modelBlock.getExplosionResistance(par1Entity);
}

/**
 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
 *

/**
 * How many world ticks before ticking
 */
public int tickRate()
{
    return this.modelBlock.tickRate();
}

/**
 * Can add to the passed in vector for a movement vector to be applied to the entity. Args: x, y, z, entity, vec3d
 */
public void velocityToAddToEntity(World par1World, int par2, int par3, int par4, Entity par5Entity, Vec3 par6Vec3D)
{
    this.modelBlock.velocityToAddToEntity(par1World, par2, par3, par4, par5Entity, par6Vec3D);
}

/**
 * Returns if this block is collidable (only used by Fire). Args: x, y, z
 */
public boolean isCollidable()
{
    return this.modelBlock.isCollidable();
}

/**
 * Returns whether this block is collideable based on the arguments passed in Args: blockMetaData, unknownFlag
 */
public boolean canCollideCheck(int par1, boolean par2)
{
    return this.modelBlock.canCollideCheck(par1, par2);
}

/**
 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
 */
public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
{
    return this.modelBlock.canPlaceBlockAt(par1World, par2, par3, par4);
}

/**
 * Called whenever the block is added into the world. Args: world, x, y, z
 */
public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
    this.onNeighborBlockChange(par1World, par2, par3, par4, 0);
    this.modelBlock.onBlockAdded(par1World, par2, par3, par4);
}

/**
 * Called whenever the block is removed.
 */
public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
{
    this.modelBlock.breakBlock(par1World, par2, par3, par4, par5, par6);
}

/**
 * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
 */
public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
{
    this.modelBlock.onEntityWalking(par1World, par2, par3, par4, par5Entity);
}

/**
 * Ticks the block if it's been scheduled
 */
public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
{
    this.modelBlock.updateTick(par1World, par2, par3, par4, par5Random);
}

/**
 * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
 * block.
 */
public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
{
    return this.modelBlock.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, 0, 0.0F, 0.0F, 0.0F);
}
/**
 * Called upon the block being destroyed by an explosion
 */
public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4)
{
    this.modelBlock.onBlockDestroyedByExplosion(par1World, par2, par3, par4);
}

/**
 * Called when the block is placed in the world.
 */
public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
{
    int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    int var7 = par1World.getBlockMetadata(par2, par3, par4) & 4;

    if (var6 == 0)
    {
        par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | var7);
    }

    if (var6 == 1)
    {
        par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | var7);
    }

    if (var6 == 2)
    {
        par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | var7);
    }

    if (var6 == 3)
    {
        par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | var7);
    }
}

/**
 * Called when a block is placed using an item. Used often for taking the facing and figuring out how to position
 * the item. Args: x, y, z, facing
 */
public void onBlockPlaced(World par1World, int par2, int par3, int par4, int par5)
{
    if (par5 == 0)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 4);
    }
}

    public static int getOrientation(int var0)
    {
        return var0 & 7;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        int var3 = getOrientation(var2);
        System.out.println("var2");
        System.out.println(var2);
        System.out.println("getorientation (var3)");
        System.out.println(var3);

        if (var3 == 0)
        {
            switch (var1)
            {
                case 0:
                    return this.blockIndexInTexture;

                case 1:
                    return 8;

                case 2:
                case 3:
                default:
                    return 7;

                case 4:
                    return 9;
            }
        }
        else if (var3 == 1)
        {
            switch (var1)
            {
                case 0:
                    return this.blockIndexInTexture;

                case 1:
                    return 8;

                case 5:
                    return 9;

                default:
                    return 7;
            }
        }
        else if (var3 == 2)
        {
            switch (var1)
            {
                case 0:
                    return this.blockIndexInTexture;

                case 1:
                    return 8;

                case 2:
                    return 9;

                default:
                    return 7;
            }
        }
        else if (var3 == 3)
        {
            switch (var1)
            {
                case 0:
                    return this.blockIndexInTexture;

                case 1:
                    return 8;

                case 2:
                default:
                    return 7;

                case 3:
                    return 9;
            }
        }
        
        if (var3 == 4)
        {
            switch (var1)
            {
                case 0:
                    return 8;

                case 1:
                    return 8;

                case 2:
                case 3:
                default:
                    return 7;

                case 4:
                    return 10;
            }
        }
        else if (var3 == 5)
        {
            switch (var1)
            {
                case 0:
                    return 8;

                case 1:
                    return 8;

                case 5:
                    return 10;

                default:
                    return 7;
            }
        }
        else if (var3 == 6)
        {
            switch (var1)
            {
                case 0:
                    return 8;

                case 1:
                    return 8;

                case 2:
                    return 10;

                default:
                    return 7;
            }
        }
        else if (var3 == 7)
        {
            switch (var1)
            {
                case 0:
                    return 8;

                case 1:
                    return 8;

                case 2:
                default:
                    return 7;

                case 3:
                    return 10;
            }
        }
        else
        {
            return 7;
        }
        
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int var1)
    {
        switch (var1)
        {
            case 0:
                return this.blockIndexInTexture;

            case 1:
                return 8;

            case 2:
            default:
                return 7;

            case 3:
                return 9;
        }
    }

    public String getTextureFile()
    {
        return "/mod_texture/terrain2.png";
    }
}
