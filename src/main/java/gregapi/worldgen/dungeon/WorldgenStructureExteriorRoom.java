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

package gregapi.worldgen.dungeon;

import static gregapi.data.CS.*;

import java.util.Random;

import net.minecraft.world.World;

/**
 * @author Gregorius Techneticies
 */
public class WorldgenStructureExteriorRoom extends WorldgenDungeonGT {
	public static boolean generate(World aWorld, Random aRandom, int aChunkX, int aChunkZ, DungeonChunkData aData, boolean aConnected) {
		WorldgenStructureExteriorPillar.generate(aWorld, aRandom, aChunkX, aChunkZ, aData);
		
		for (int tX = 0; tX < 16; tX++) for (int tZ = 0; tZ < 16; tZ++) for (int tY = 0; tY <= 7; tY++) {
			if (tX == 0 || tX == 15 || tZ == 0 || tZ == 15 || tY == 0 || tY == 7) {
				if ((tX == 3 || tX == 6 || tX == 9 || tX == 12) && (tZ == 3 || tZ == 6 || tZ == 9 || tZ == 12)) {
					if (tY == 0) {
						setChiseledStone(aWorld, aChunkX+tX, aData.mY+tY, aChunkZ+tZ, aData, aRandom);
					} else if (tY == 7) {
						setLampBlock(aWorld, aChunkX+tX, aData.mY+tY, aChunkZ+tZ, aData, aRandom, +1);
					} else {
						setRandomBricks(aWorld, aChunkX+tX, aData.mY+tY, aChunkZ+tZ, aData, aRandom);
					}
				} else {
					if (tY == 0) {
						setStoneTiles(aWorld, aChunkX+tX, aData.mY+tY, aChunkZ+tZ, aData, aRandom);
					} else if (tY == 7) {
						setSmallTiles(aWorld, aChunkX+tX, aData.mY+tY, aChunkZ+tZ, aData, aRandom);
						setStoneTiles(aWorld, aChunkX+tX, aData.mY+tY+1, aChunkZ+tZ, aData, aRandom);
					} else {
						setRandomBricks(aWorld, aChunkX+tX, aData.mY+tY, aChunkZ+tZ, aData, aRandom);
					}
				}
			} else {
				setAirBlock(aWorld, aChunkX+tX, aData.mY+tY, aChunkZ+tZ, aData, aRandom);
			}
		}
		
		if (aConnected) {
			if (aData.mRoomLayout[aData.mRoomX+1][aData.mRoomZ] != 0) {
				setChiseledStone(aWorld, aChunkX+15, aData.mY+0, aChunkZ+ 5, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+0, aChunkZ+ 6, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+0, aChunkZ+ 7, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+0, aChunkZ+ 8, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+0, aChunkZ+ 9, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+15, aData.mY+0, aChunkZ+10, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+1, aChunkZ+ 5, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+1, aChunkZ+ 6, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+1, aChunkZ+ 7, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+1, aChunkZ+ 8, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+1, aChunkZ+ 9, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+1, aChunkZ+10, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+2, aChunkZ+ 5, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+2, aChunkZ+ 6, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+2, aChunkZ+ 7, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+2, aChunkZ+ 8, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+2, aChunkZ+ 9, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+2, aChunkZ+10, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+3, aChunkZ+ 5, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+3, aChunkZ+ 6, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+3, aChunkZ+ 7, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+3, aChunkZ+ 8, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+15, aData.mY+3, aChunkZ+ 9, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+3, aChunkZ+10, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+15, aData.mY+4, aChunkZ+ 5, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+4, aChunkZ+ 6, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+4, aChunkZ+ 7, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+4, aChunkZ+ 8, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+15, aData.mY+4, aChunkZ+ 9, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+15, aData.mY+4, aChunkZ+10, aData, aRandom);
			}
			if (aData.mRoomLayout[aData.mRoomX-1][aData.mRoomZ] != 0) {
				setChiseledStone(aWorld, aChunkX+ 0, aData.mY+0, aChunkZ+ 5, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+0, aChunkZ+ 6, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+0, aChunkZ+ 7, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+0, aChunkZ+ 8, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+0, aChunkZ+ 9, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+ 0, aData.mY+0, aChunkZ+10, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+1, aChunkZ+ 5, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+1, aChunkZ+ 6, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+1, aChunkZ+ 7, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+1, aChunkZ+ 8, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+1, aChunkZ+ 9, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+1, aChunkZ+10, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+2, aChunkZ+ 5, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+2, aChunkZ+ 6, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+2, aChunkZ+ 7, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+2, aChunkZ+ 8, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+2, aChunkZ+ 9, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+2, aChunkZ+10, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+3, aChunkZ+ 5, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+3, aChunkZ+ 6, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+3, aChunkZ+ 7, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+3, aChunkZ+ 8, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 0, aData.mY+3, aChunkZ+ 9, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+3, aChunkZ+10, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+ 0, aData.mY+4, aChunkZ+ 5, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+4, aChunkZ+ 6, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+4, aChunkZ+ 7, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+4, aChunkZ+ 8, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 0, aData.mY+4, aChunkZ+ 9, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+ 0, aData.mY+4, aChunkZ+10, aData, aRandom);
			}
			if (aData.mRoomLayout[aData.mRoomX][aData.mRoomZ+1] != 0) {
				setChiseledStone(aWorld, aChunkX+ 5, aData.mY+0, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 6, aData.mY+0, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 7, aData.mY+0, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 8, aData.mY+0, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 9, aData.mY+0, aChunkZ+15, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+10, aData.mY+0, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 5, aData.mY+1, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 6, aData.mY+1, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 7, aData.mY+1, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 8, aData.mY+1, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 9, aData.mY+1, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+10, aData.mY+1, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 5, aData.mY+2, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 6, aData.mY+2, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 7, aData.mY+2, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 8, aData.mY+2, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 9, aData.mY+2, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+10, aData.mY+2, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 5, aData.mY+3, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 6, aData.mY+3, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 7, aData.mY+3, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 8, aData.mY+3, aChunkZ+15, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 9, aData.mY+3, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+10, aData.mY+3, aChunkZ+15, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+ 5, aData.mY+4, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 6, aData.mY+4, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 7, aData.mY+4, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 8, aData.mY+4, aChunkZ+15, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 9, aData.mY+4, aChunkZ+15, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+10, aData.mY+4, aChunkZ+15, aData, aRandom);
			}
			if (aData.mRoomLayout[aData.mRoomX][aData.mRoomZ-1] != 0) {
				setChiseledStone(aWorld, aChunkX+ 5, aData.mY+0, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 6, aData.mY+0, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 7, aData.mY+0, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 8, aData.mY+0, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 9, aData.mY+0, aChunkZ+ 0, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+10, aData.mY+0, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 5, aData.mY+1, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 6, aData.mY+1, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 7, aData.mY+1, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 8, aData.mY+1, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 9, aData.mY+1, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+10, aData.mY+1, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 5, aData.mY+2, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 6, aData.mY+2, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 7, aData.mY+2, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 8, aData.mY+2, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 9, aData.mY+2, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+10, aData.mY+2, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 5, aData.mY+3, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 6, aData.mY+3, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 7, aData.mY+3, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 8, aData.mY+3, aChunkZ+ 0, aData, aRandom);
				setAirBlock     (aWorld, aChunkX+ 9, aData.mY+3, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+10, aData.mY+3, aChunkZ+ 0, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+ 5, aData.mY+4, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 6, aData.mY+4, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 7, aData.mY+4, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 8, aData.mY+4, aChunkZ+ 0, aData, aRandom);
				setSmoothBlock  (aWorld, aChunkX+ 9, aData.mY+4, aChunkZ+ 0, aData, aRandom);
				setChiseledStone(aWorld, aChunkX+10, aData.mY+4, aChunkZ+ 0, aData, aRandom);
			}
		}
		return T;
	}
}