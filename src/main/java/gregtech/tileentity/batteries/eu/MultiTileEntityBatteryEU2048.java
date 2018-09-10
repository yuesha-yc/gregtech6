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

package gregtech.tileentity.batteries.eu;

import static gregapi.data.CS.*;

import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.energy.TileEntityBase08Battery;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;

/**
 * @author Gregorius Techneticies
 */
public class MultiTileEntityBatteryEU2048 extends TileEntityBase08Battery {
	@Override
	public ITexture getTexture2(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {
		return SIDES_HORIZONTAL[aSide] ? aRenderPass == 1 ? BlockTextureDefault.get(sTextures[3], mRGBa) : BlockTextureDefault.get(sTextures[2]) : aRenderPass == 1 ? null : BlockTextureDefault.get(sTextures[FACES_TBS[aSide]]);
	}
	
	public static IIconContainer sTextures[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/batteries/eu/standard/2048/bottom"),
		new Textures.BlockIcons.CustomIcon("machines/batteries/eu/standard/2048/top"),
		new Textures.BlockIcons.CustomIcon("machines/batteries/eu/standard/2048/sides"),
		new Textures.BlockIcons.CustomIcon("machines/batteries/eu/standard/2048/bar"),
	};
	
	@Override
	public boolean setBlockBounds2(Block aBlock, int aRenderPass, boolean[] aShouldSideBeRendered) {
		if (aRenderPass == 1) {
			box(aBlock, PX_P[ 2]-0.002F, PX_P[ 1], PX_P[ 2]-0.002F, PX_N[ 2]+0.002F, PX_P[mDisplayedEnergy+1], PX_N[ 2]+0.002F);
			return T;
		}
		box(aBlock, PX_P[ 2], PX_P[ 0], PX_P[ 2], PX_N[ 2], PX_N[ 3], PX_N[ 2]);
		return T;
	}
	
	@Override public AxisAlignedBB getCollisionBoundingBoxFromPool() {return box(PX_P[ 2], PX_P[ 0], PX_P[ 2], PX_N[ 2], PX_N[ 3], PX_N[ 2]);}
	@Override public AxisAlignedBB getSelectedBoundingBoxFromPool () {return box(PX_P[ 2], PX_P[ 0], PX_P[ 2], PX_N[ 2], PX_N[ 3], PX_N[ 2]);}
	@Override public void setBlockBoundsBasedOnState(Block aBlock) {box(aBlock,  PX_P[ 2], PX_P[ 0], PX_P[ 2], PX_N[ 2], PX_N[ 3], PX_N[ 2]);}
	
	@Override public byte getDisplayScaleMax() {return 9;}
	
	@Override public String getTileEntityName() {return "gt.multitileentity.battery.eu.2048";}
}
