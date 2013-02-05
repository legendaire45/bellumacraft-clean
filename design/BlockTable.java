package Bellumacraft.design;

import java.util.Random;

import Bellumacraft.mod_Mine;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockTable extends Block
{
	public static final Block blocktable = null;
	public BlockTable(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return mod_Mine.ItemTable.shiftedIndex;
    }
    
    public boolean isOpaqueCube()
    {
       return false;
    }

    public boolean renderAsNormalBlock()
    {
       return false;
    }

    public int getRenderType()
    {
       return mod_Mine.RenderTable;
    }
}