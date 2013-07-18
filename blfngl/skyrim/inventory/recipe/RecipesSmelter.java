package blfngl.skyrim.inventory.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import blfngl.skyrim.Skyrim;

public class RecipesSmelter
{
	private static final RecipesSmelter smeltBase = new RecipesSmelter();

	private HashMap<List<Integer>, ItemStack> metaSmeltingList1 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingList2 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList1 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList2 = new HashMap<List<Integer>, ItemStack>();

	public static final RecipesSmelter smelting()
	{
		return smeltBase;
	}

	private RecipesSmelter()
	{
		this.addDoubleItemSmelting(new ItemStack(Skyrim.ingotCorundum), new ItemStack(Item.ingotIron), new ItemStack(Skyrim.ingotSteel));
		this.addDoubleItemSmelting(new ItemStack(Item.ingotIron), new ItemStack(Skyrim.ingotCorundum), new ItemStack(Skyrim.ingotSteel));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreCorundum), new ItemStack(Skyrim.oreCorundum), new ItemStack(Skyrim.ingotCorundum));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreEbony), new ItemStack(Skyrim.oreEbony), new ItemStack(Skyrim.ingotCorundum));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreMalachite), new ItemStack(Skyrim.oreMalachite), new ItemStack(Skyrim.ingotCorundum));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreMoonstone), new ItemStack(Skyrim.oreMoonstone), new ItemStack(Skyrim.ingotCorundum));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreOrichalcum), new ItemStack(Skyrim.oreOrichalcum), new ItemStack(Skyrim.ingotCorundum));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreQuicksilver), new ItemStack(Skyrim.oreQuicksilver), new ItemStack(Skyrim.ingotCorundum));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreSilver), new ItemStack(Skyrim.oreSilver), new ItemStack(Skyrim.ingotCorundum));
		this.addDoubleItemSmelting(new ItemStack(Block.oreGold), new ItemStack(Block.oreGold), new ItemStack(Item.ingotGold, 3));
		this.addDoubleItemSmelting(new ItemStack(Block.oreIron), new ItemStack(Block.oreIron), new ItemStack(Item.ingotIron, 3));
		this.addDoubleItemSmelting(new ItemStack(Block.oreDiamond), new ItemStack(Block.oreDiamond), new ItemStack(Item.diamond, 3));
		this.addDoubleItemSmelting(new ItemStack(Skyrim.oreStalhrim), new ItemStack(Skyrim.oreStalhrim), new ItemStack(Skyrim.stalhrim));
	}

	public void addDoubleItemSmelting(ItemStack input1, ItemStack input2, ItemStack output)
	{
		this.metaSmeltingList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), output);
		this.metaSmeltingList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), output);
		this.metaSmeltingCheckList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), input1);
		this.metaSmeltingCheckList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input2);
	}

	public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2)
	{
		if (item1 == null){return null;}
		if (item2 == null){return null;}

		if (item1.itemID == Skyrim.ingotCorundum.itemID && item2.itemID == Item.ingotIron.itemID
				||item1.itemID == Item.ingotIron.itemID && item2.itemID == Skyrim.ingotCorundum.itemID)
		{
			return new ItemStack(Skyrim.ingotSteel);
		}

		if (item1.itemID == Skyrim.oreCorundum.blockID && item2.itemID == Skyrim.oreCorundum.blockID)
		{
			return new ItemStack(Skyrim.ingotCorundum);
		}

		if (item1.itemID == Skyrim.oreCorundum.blockID && item2.itemID == Skyrim.oreCorundum.blockID)
		{
			return new ItemStack(Skyrim.ingotCorundum);
		}

		if (item1.itemID == Skyrim.oreEbony.blockID && item2.itemID == Skyrim.oreEbony.blockID)
		{
			return new ItemStack(Skyrim.ingotEbony);
		}

		if (item1.itemID == Skyrim.oreQuicksilver.blockID && item2.itemID == Skyrim.oreQuicksilver.blockID)
		{
			return new ItemStack(Skyrim.ingotQuicksilver);
		}

		if (item1.itemID == Skyrim.oreSilver.blockID && item2.itemID == Skyrim.oreSilver.blockID)
		{
			return new ItemStack(Skyrim.ingotSilver);
		}

		if (item1.itemID == Skyrim.oreMalachite.blockID && item2.itemID == Skyrim.oreMalachite.blockID)
		{
			return new ItemStack(Skyrim.ingotMalachite);
		}

		if (item1.itemID == Skyrim.oreMoonstone.blockID && item2.itemID == Skyrim.oreMoonstone.blockID)
		{
			return new ItemStack(Skyrim.ingotMoonstone);
		}

		if (item1.itemID == Skyrim.oreOrichalcum.blockID && item2.itemID == Skyrim.oreOrichalcum.blockID)
		{
			return new ItemStack(Skyrim.ingotOrichalcum);
		}

		if (item1.itemID == Block.oreIron.blockID && item2.itemID == Block.oreIron.blockID)
		{
			return new ItemStack(Item.ingotIron, 3);
		}

		if (item1.itemID == Block.oreGold.blockID && item2.itemID == Block.oreGold.blockID)
		{
			return new ItemStack(Item.ingotGold, 3);
		}

		if (item1.itemID == Block.oreDiamond.blockID && item2.itemID == Block.oreDiamond.blockID)
		{
			return new ItemStack(Item.diamond, 3);
		}

		if (item1.itemID == Skyrim.oreStalhrim.blockID && item2.itemID == Skyrim.oreStalhrim.blockID)
		{
			return new ItemStack(Skyrim.stalhrim);
		}

		return null;
	}

	public ItemStack getSlot1ReduceAmount(ItemStack input)
	{
		return (ItemStack) this.metaSmeltingCheckList1.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}

	public ItemStack getSlot2ReduceAmount(ItemStack input)
	{
		return (ItemStack) this.metaSmeltingCheckList2.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}

}