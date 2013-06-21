package blfngl.skyrim.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.block.BlockGrindstone;
import blfngl.skyrim.tileentity.TileEntityGrindstone;

public class RecipesGrindstone
{
	private static final RecipesGrindstone smeltBase = new RecipesGrindstone();

	private HashMap<List<Integer>, ItemStack> metaSmeltingList1 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingList2 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList1 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList2 = new HashMap<List<Integer>, ItemStack>();

	public static final RecipesGrindstone smelting()
	{
		return smeltBase;
	}

	private RecipesGrindstone()
	{
		this.addDoubleItemSmelting(new ItemStack(Skyrim.swordSteel), new ItemStack(Skyrim.ingotSteel), new ItemStack(Skyrim.swordSteel));
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

		/**Item item4 = Skyrim.swordSteel;
		ItemStack item3 = new ItemStack(Skyrim.swordSteel);

		if(item1.stackTagCompound.getString("Reforged") == "fine")
		{
			item3.stackTagCompound.setString("Reforged", "superior");
			return item3;
		}

		if(item1.stackTagCompound.getString("Reforged") == "superior")
		{
			item3.stackTagCompound.setString("Reforged", "exquisite");
			return item3;
		}

		if(item1.stackTagCompound.getString("Reforged") == "exquisite")
		{
			item3.stackTagCompound.setString("Reforged", "flawless");
			return item3;
		}

		if(item1.stackTagCompound.getString("Reforged") == "flawless")
		{
			item3.stackTagCompound.setString("Reforged", "epic");
			return item3;
		}

		if(item1.stackTagCompound.getString("Reforged") == "epic")
		{
			item3.stackTagCompound.setString("Reforged", "legendary");
			return item3;
		}**/

		if (item1.itemID == Skyrim.swordSteel.itemID && item2.itemID == Skyrim.ingotSteel.itemID && item1.stackTagCompound.getString("Reforged") == "fine")
		{
			ItemStack item3 = item1;
			item3.stackTagCompound.setString("Reforged", "superior");
			return item3;
		}

		else if (item1.itemID == Skyrim.swordSteel.itemID && item2.itemID == Skyrim.ingotSteel.itemID && item1.stackTagCompound.getString("Reforged") != "superior")
		{
			item1.stackTagCompound.setString("Reforged", "exquisite");
			return item1;
		}

		else
		{
			item1.stackTagCompound.setString("Reforged", "fine");
			return item1;
		}
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