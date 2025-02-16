package com.impactrecipes.recipes;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class ChickenChunks implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeChickens();
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 1L, 0), tBitMask, new Object[]{" h ", "BPB", "PFP", 'B', OrePrefixes.bolt.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Gold), 'F', OrePrefixes.frameGt.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 9L, 1), tBitMask, new Object[]{"sC", 'C', GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 1L, 0)});

        RA.addCutterRecipe(GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 1L, 0),
                GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 9L, 1), GT_Values.NI, 50, 8);

        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 3),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 1L, 0), 50, 12);
    }

    private void removeChickens() {
        removeRecipeByOutput(GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 1L, 1),
                true, false, false);
    }
}
