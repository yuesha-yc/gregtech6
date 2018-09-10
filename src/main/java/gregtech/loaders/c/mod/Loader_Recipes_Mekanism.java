/**
 * Copyright (c) 2018 Gregorius Techneticies
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregtech.loaders.c.mod;

import static gregapi.data.CS.*;

import gregapi.data.MD;
import gregapi.util.CR;
import gregapi.util.ST;
import net.minecraft.item.ItemStack;

public class Loader_Recipes_Mekanism implements Runnable {
	@Override
	public void run() {
		if (MD.Mek.mLoaded) {
			OUT.println("GT_Mod: Doing Mekanism Recipes.");
			ItemStack x = ST.make(MD.Mek, "Salt", 1, 0);
			CR.remove(x, x, NI, x, x);
		}
	}
}
