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

package gregtech.loaders.a;

import static gregapi.data.CS.*;

import gregapi.data.CS.FluidsGT;
import gregapi.data.CS.IconsGT;
import gregapi.data.CS.PotionsGT;
import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.LH;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.data.TD;
import gregapi.item.multiitem.food.FoodStatDrink;
import gregapi.old.Textures;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.IIconContainer;
import gregapi.render.TextureSet;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidStack;

public class Loader_Fluids implements Runnable {
	@Override
	public void run() {
		OUT.println("GT_Mod: Register Fluids.");
		UT.Fluids.create("HeliumPlasma"				, "Helium Plasma"		, MT.He					, 3,   1000, 10000).setLuminosity(15);
		UT.Fluids.create("NitrogenPlasma"			, "Nitrogen Plasma"		, MT.N					, 3,   1000, 10000).setLuminosity(15);
		
		//-----
		
		UT.Fluids.create("Helium-3"					, "Helium-3"			, MT.He_3				, 2,   1000,   300);
		UT.Fluids.create("Propane"					, "Propane"				, MT.Propane			, 2,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("Butane"					, "Butane"				, MT.Butane				, 2,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("dragonbreath"				, "Dragon's Breath"		, null					, 2,   1000,   300, IL.EtFu_Dragon_Breath.get(1), IL.Bottle_Empty.get(1), 250).setDensity(100).setLuminosity(5);
		UT.Fluids.create("netherair"				, "Nether Air"			, null					, 2,   1000,   370).setDensity(0);
		UT.Fluids.create("enderair"					, "Ender Air"			, null					, 2,   1000,   280).setDensity(0);
		UT.Fluids.create("Steam"					, "Steam"				, MT.Water				, 2, 160000, C+100);
		MT.Ice.mGas = MT.Water.mGas;
		MT.Water.mGas.getFluid().setTemperature((int)(C+100)).setGaseous(T);
		
		//-----
		
		UT.Fluids.create("liquid_extra_heavy_oil"	, "Very Heavy Oil"		, null					, 1,   1000,   300);
		UT.Fluids.create("liquid_heavy_oil"			, "Heavy Oil"			, null					, 1,   1000,   300);
		UT.Fluids.create("liquid_medium_oil"		, "Raw Oil"				, null					, 1,   1000,   300);
		UT.Fluids.create("liquid_light_oil"			, "Light Oil"			, null					, 1,   1000,   300);
		UT.Fluids.create("soulsandoil"				, "Soulsand Oil"		, null					, 1,   1000,   300);
		UT.Fluids.create("gas_natural_gas"			, "Natural Gas"			, null					, 2,   1000,   300, FluidsGT.SIMPLE); // ~95% methane, ~5% ethane and trace amounts of propane and butane
		
		UT.Fluids.create("liquidoxygen"				, "Liquid Oxygen"		, MT.O					, 1,   1000,    85);
		
		UT.Fluids.create("chargedmatter"			, "Charged Matter"		, null					, 1,	  1,	 1).setLuminosity(15);
		UT.Fluids.create("neutralmatter"			, "Neutral Matter"		, null					, 1,	  1,	 1).setLuminosity(15);
		UT.Fluids.create("UUAmplifier"				, "UU-Amplifier"		, MT.UUAmplifier		, 1,	100,   100);
		UT.Fluids.create("ic2uumatter"				, "UU-Matter"			, MT.UUMatter			, 1,	100,   100);
		UT.Fluids.create("ic2constructionfoam"		, "Construction Foam"	, MT.ConstructionFoam	, 1,	100,   300);
		UT.Fluids.create("ic2distilledwater"		, "Distilled Water"		, MT.DistWater			, 1,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("NitroFuel"				, "Nitro Fuel"			, MT.NitroFuel			, 1,   1000,   300);
		UT.Fluids.create("lubricant"				, "Lubricant"			, MT.Lubricant			, 1,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("oil"						, "Oil"					, MT.Oil				, 1,   1000,   300);
		UT.Fluids.create("fuel"						, "Fuel Oil"			, MT.Fuel				, 1,   1000,   300);
		UT.Fluids.create("kerosine"					, "Kerosine"			, MT.Kerosine			, 1,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("diesel"					, "Diesel"				, MT.Diesel				, 1,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("petrol"					, "Petrol"				, MT.Petrol				, 1,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("ic2biomass"				, "Biomass"				, MT.Biomass			, 1,   1000,   300);
		UT.Fluids.create("biomass"					, "Biomass"				, MT.Biomass			, 1,   1000,   300);
		UT.Fluids.create("ic2pahoehoelava"			, "Pahoehoe Lava"		, null					, 1,   1000,  1200).setLuminosity(10).setDensity(50000).setViscosity(250000);
		UT.Fluids.create("bioethanol"				, "Bio Ethanol"			, MT.Ethanol			, 1,   1000,   300, FluidsGT.SIMPLE);
		UT.Fluids.create("mcguffium"				, "Mc Guffium 239"		, MT.Mcg				, 1,	  L,   300, FluidsGT.ENCHANTED_EFFECT);
		UT.Fluids.create("hotfryingoil"				, "Hot Frying Oil"		, MT.FryingOilHot		, 1,   1000,   400);
		
		UT.Fluids.create("fieryblood"				, "Fiery Blood"			, null					, 1,	  L,  1500, FluidsGT.ENCHANTED_EFFECT).setLuminosity(10);
		UT.Fluids.create("fierytears"				, "Fiery Tears"			, null					, 1,	  L,  1500, FluidsGT.ENCHANTED_EFFECT).setLuminosity(10);
		
		DYE_FLUIDS[0].add(UT.Fluids.make(UT.Fluids.create("squidink"	, "Squid Ink"		, null, 1, L, 300, FluidsGT.SIMPLE), L));
		DYE_FLUIDS[4].add(UT.Fluids.make(UT.Fluids.create("indigo"		, "Indigo Dye"		, null, 1, L, 300, FluidsGT.SIMPLE), L));
		
		IIconContainer
		tDyeWaterMixed	= new Textures.BlockIcons.CustomIcon("fluids/dyes.water"),
		tDyeFlower		= new Textures.BlockIcons.CustomIcon("fluids/dyes.flower"),
		tDyeChemical	= new Textures.BlockIcons.CustomIcon("fluids/dyes.chemical"),
		tDyedCFoam		= new Textures.BlockIcons.CustomIcon("fluids/cfoam");
		
		for (byte i = 0; i < 16; i++) {
			DYE_FLUIDS[i].add(DYE_FLUIDS_WATER		[i] = UT.Fluids.make(UT.Fluids.create("dye.watermixed."	+ DYE_OREDICTS_POST[i].toLowerCase(), tDyeWaterMixed	, "Water Mixed " + DYE_NAMES[i] + " Dye"	, null, DYES[i], 1,   L, 300, NI, NI, 0, FluidsGT.SIMPLE), L));
			DYE_FLUIDS[i].add(DYE_FLUIDS_FLOWER		[i] = UT.Fluids.make(UT.Fluids.create("dye.flower."		+ DYE_OREDICTS_POST[i].toLowerCase(), tDyeFlower		, DYE_NAMES[i] + " Flower Dye"				, null, DYES[i], 1,   L, 300, NI, NI, 0, FluidsGT.SIMPLE), L));
			DYE_FLUIDS[i].add(DYE_FLUIDS_CHEMICAL	[i] = UT.Fluids.make(UT.Fluids.create("dye.chemical."	+ DYE_OREDICTS_POST[i].toLowerCase(), tDyeChemical		, "Chemical " + DYE_NAMES[i] + " Dye"		, null, DYES[i], 1,   L, 300, NI, NI, 0, FluidsGT.SIMPLE), L));
			DYED_C_FOAMS							[i] = UT.Fluids.make(UT.Fluids.create("cfoam."			+ DYE_OREDICTS_POST[i].toLowerCase(), tDyedCFoam		, DYE_NAMES[i] + " C-Foam"					, null, DYES[i], 1, 100, 300, NI, NI, 0), 100);
			DYED_C_FOAMS_OWNED						[i] = UT.Fluids.make(UT.Fluids.create("cfoam.owned."	+ DYE_OREDICTS_POST[i].toLowerCase(), tDyedCFoam		, "Advanced " + DYE_NAMES[i] + " C-Foam"	, null, DYES[i], 1, 100, 300, NI, NI, 0), 100);
		}
		
		//-----
		
		MT.Pyrotheum.liquid(UT.Fluids.make("pyrotheum", 250));
		MT.Cryotheum.liquid(UT.Fluids.make("cryotheum", 250));
		MT.Petrotheum.liquid(UT.Fluids.make("petrotheum", 250));
		MT.Aerotheum.gas(UT.Fluids.make("aerotheum", 250));
		
		FluidStack
		tFluid = UT.Fluids.make("mana", 250);
		if (tFluid != null) {
			MT.Magic.liquid(tFluid);
		}
		tFluid = UT.Fluids.make("ender", 250);
		if (tFluid != null) {
			tFluid.getFluid().setTemperature((int)MT.EnderPearl.mMeltingPoint);
			MT.EnderPearl.liquid(tFluid);
		}
		tFluid = UT.Fluids.make("redstone", 100);
		if (tFluid != null) {
			tFluid.getFluid().setTemperature((int)MT.Redstone.mMeltingPoint);
			MT.Redstone.liquid(tFluid);
		}
		tFluid = UT.Fluids.make("glowstone", 250);
		if (tFluid != null) {
			tFluid.getFluid().setTemperature((int)MT.Glowstone.mBoilingPoint);
			MT.Glowstone.gas(tFluid);
		}
		
		UT.Fluids.create("plastic"					, "Molten Plastic"		, MT.Plastic		, 1, 1000,   423);
		UT.Fluids.create("glass"					, "Molten Glass"		, MT.Glass			, 1, 1000,  1200);
		UT.Fluids.create("molten.enderpearl"		, "Molten Enderpearls"	, MT.EnderPearl		, 1,	L,  2723).setLuminosity( 5);
		UT.Fluids.create("molten.redstone"			, "Molten Redstone"		, MT.Redstone		, 1,	L,   500).setLuminosity( 5);
		UT.Fluids.create("blaze"					, "Blazing Goo"			, MT.Blaze			, 1,	L,  4000).setLuminosity(15);
		UT.Fluids.create("concrete"					, "Wet Concrete"		, MT.Concrete		, 1,	L,   300);
		UT.Fluids.create("molten.latex"				, "Latex"				, MT.Latex			, 1,	L, DEF_ENV_TEMP);
		UT.Fluids.create("latex"					, "Latex"				, MT.Latex			, 1,	L, DEF_ENV_TEMP);
		
		UT.Fluids.createMolten(MT.Chocolate			, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.Cheese			, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.Sugar				, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.Rubber			, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.Wax				, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.WaxBee			, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.WaxParaffin		, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.WaxPlant			, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.WaxRefractory		, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.WaxMagic			, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.WaxAmnesic		, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		UT.Fluids.createMolten(MT.WaxSoulful		, TextureSet.SET_FLUID[0].mList.get(IconsGT.INDEX_BLOCK_MOLTEN), FluidsGT.SIMPLE);
		
		/*
		for (OreDictMaterial tMaterial : OreDictMaterial.MATERIAL_MAP.values()) {
			if (tMaterial.mLiquid == null && !tMaterial.contains(TD.Properties.INVALID_MATERIAL) && tMaterial.contains(TD.Properties.MELTING) && tMaterial.mTargetSmelting.mAmount > 0) {
				UT.Fluids.createMoltenFluid(tMaterial);
				if (tMaterial.mTargetSmelting.mMaterial != tMaterial && tMaterial.mTargetSmelting.mMaterial.mLiquid == null) {
					UT.Fluids.createMoltenFluid(tMaterial.mTargetSmelting.mMaterial);
				}
			}
		}*/
		
		//-----
		
		new FoodStatDrink(UT.Fluids.create("potion.tainted"								, "Tainted Brew"							, null, 1, 1000, 300)																						, "tainted between the lands"				,  0, 0.0F  ,  20, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 100, 3, 100, Potion.hunger			.id, 100, 3, 100);
		
		new FoodStatDrink(UT.Fluids.create("potion.awkward"								, "Awkward Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,    16), IL.Bottle_Empty.get(1), 250)						, "well, that's awkward"					,  0, 0.0F  ,  20, C+37,  0.00F, EnumAction.drink, T, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.thick"								, "Thick Brew"								, null, 1, 1000, 300, ST.make(Items.potionitem, 1,    32), IL.Bottle_Empty.get(1), 250)						, "thick and gooey"							,  0, 0.0F  ,  15, C+37,  0.00F, EnumAction.drink, T, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.mundane"								, "Mundane Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,    64), IL.Bottle_Empty.get(1), 250)						, "how mundane of you"						,  0, 0.0F  ,  25, C+37,  0.00F, EnumAction.drink, T, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.damage"								, "Harming Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8204), IL.Bottle_Empty.get(1), 250)						, LH.Chat.RED	+ "Instant Damage I"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.harm				.id,   0, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.damage.strong"						, "Strong Harming Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8236), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.RED	+ "Instant Damage II"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.harm				.id,   0, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.damage.splash"						, "Splash Harming Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16396), IL.Bottle_Empty.get(1), 250)						, LH.Chat.RED	+ "Instant Damage I"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.harm				.id,   0, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.damage.strong.splash"				, "Strong Splash Harming Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16428), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.RED	+ "Instant Damage II"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.harm				.id,   0, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.health"								, "Healing Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8197), IL.Bottle_Empty.get(1), 250)						, LH.Chat.PINK	+ "Instant Health I"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.heal				.id,   0, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.health.strong"						, "Strong Healing Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8229), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.PINK	+ "Instant Health II"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.heal				.id,   0, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.health.splash"						, "Splash Healing Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16389), IL.Bottle_Empty.get(1), 250)						, LH.Chat.PINK	+ "Instant Health I"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.heal				.id,   0, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.health.strong.splash"				, "Strong Splash Healing Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16421), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.PINK	+ "Instant Health II"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.heal				.id,   0, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.jump"								, "Jumpy Brew"								, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8203), IL.Bottle_Empty.get(1), 250)						, LH.Chat.GREEN	+ "Jump Boost I (3:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.jump				.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.jump.strong"							, "Strong Jumpy Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8235), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.GREEN	+ "Jump Boost II (1:30)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.jump				.id,1800, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.jump.splash"							, "Splash Jumpy Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16395), IL.Bottle_Empty.get(1), 250)						, LH.Chat.GREEN	+ "Jump Boost I (2:15)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.jump				.id,2700, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.jump.strong.splash"					, "Strong Splash Jumpy Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16427), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.GREEN	+ "Jump Boost II (1:07)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.jump				.id,1350, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed"								, "Swiftness Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8194), IL.Bottle_Empty.get(1), 250)						, LH.Chat.GREEN	+ "Speed I (3:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.strong"						, "Strong Swiftness Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8226), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.GREEN	+ "Speed II (1:30)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id,1800, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.long"							, "Stretched Swiftness Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8258), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.GREEN	+ "Speed I (8:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id,9600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.splash"						, "Splash Swiftness Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16386), IL.Bottle_Empty.get(1), 250)						, LH.Chat.GREEN	+ "Speed I (2:15)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id,2700, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.strong.splash"					, "Strong Splash Swiftness Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16418), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.GREEN	+ "Speed II (1:07)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id,1350, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.long.splash"					, "Stretched Splash Swiftness Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16450), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.GREEN	+ "Speed I (6:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id,7200, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength"							, "Strength Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8201), IL.Bottle_Empty.get(1), 250)						, LH.Chat.GREEN	+ "Strength I (3:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.strong"						, "Strong Strength Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8233), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.GREEN	+ "Strength II (1:30)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id,1800, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.long"						, "Stretched Strength Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8265), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.GREEN	+ "Strength I (8:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id,9600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.splash"						, "Splash Strength Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16393), IL.Bottle_Empty.get(1), 250)						, LH.Chat.GREEN	+ "Strength I (2:15)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id,2700, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.strong.splash"				, "Strong Splash Strength Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16425), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.GREEN	+ "Strength II (1:07)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id,1350, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.long.splash"				, "Stretched Splash Strength Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16457), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.GREEN	+ "Strength I (6:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id,7200, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen"								, "Regenerating Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8193), IL.Bottle_Empty.get(1), 250)						, LH.Chat.PINK	+ "Regeneration I (0:45)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.strong"						, "Strong Regenerating Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8225), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.PINK	+ "Regeneration II (0:22)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id, 450, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.long"							, "Stretched Regenerating Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8257), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.PINK	+ "Regeneration I (2:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id,2400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.splash"						, "Splash Regenerating Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16385), IL.Bottle_Empty.get(1), 250)						, LH.Chat.PINK	+ "Regeneration I (0:33)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id, 666, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.strong.splash"					, "Strong Splash Regenerating Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16417), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.PINK	+ "Regeneration II (0:16)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id, 333, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.long.splash"					, "Stretched Splash Regenerating Brew"		, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16449), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.PINK	+ "Regeneration I (1:30)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id,1800, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison"								, "Poisonous Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8196), IL.Bottle_Empty.get(1), 250)						, LH.Chat.RED	+ "Poison I (0:45)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.strong"						, "Strong Poisonous Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8228), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.RED	+ "Poison II (0:22)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 450, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.long"							, "Stretched Poisonous Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8260), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.RED	+ "Poison I (2:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id,2400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.splash"						, "Splash Poisonous Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16388), IL.Bottle_Empty.get(1), 250)						, LH.Chat.RED	+ "Poison I (0:33)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 666, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.strong.splash"				, "Strong Splash Poisonous Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16420), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.RED	+ "Poison II (0:16)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 333, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.long.splash"					, "Stretched Splash Poisonous Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16452), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.RED	+ "Poison I (1:30)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id,1800, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.fireresistance"						, "Fire Resistant Brew"						, null, 1, 1000, 375, ST.make(Items.potionitem, 1,  8195), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.BLUE	+ "Fire Resistance (3:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.fireResistance	.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.fireresistance.long"					, "Stretched Fire Resistant Brew"			, null, 1, 1000, 375, ST.make(Items.potionitem, 1,  8259), IL.Bottle_Empty.get(1), 250).setLuminosity(15)	, LH.Chat.BLUE	+ "Fire Resistance (8:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.fireResistance	.id,9600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.fireresistance.splash"				, "Splash Fire Resistant Brew"				, null, 1, 1000, 375, ST.make(Items.potionitem, 1, 16387), IL.Bottle_Empty.get(1), 250).setLuminosity(10)	, LH.Chat.BLUE	+ "Fire Resistance (2:15)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.fireResistance	.id,2700, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.fireresistance.long.splash"			, "Stretched Splash Fire Resistant Brew"	, null, 1, 1000, 375, ST.make(Items.potionitem, 1, 16451), IL.Bottle_Empty.get(1), 250).setLuminosity(15)	, LH.Chat.BLUE	+ "Fire Resistance (6:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.fireResistance	.id,7200, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.nightvision"							, "Night Vision Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8198), IL.Bottle_Empty.get(1), 250)						, LH.Chat.CYAN	+ "Night Vision (3:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.nightVision		.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.nightvision.long"					, "Stretched Night Vision Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8262), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.CYAN	+ "Night Vision (8:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.nightVision		.id,9600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.nightvision.splash"					, "Splash Night Vision Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16390), IL.Bottle_Empty.get(1), 250)						, LH.Chat.CYAN	+ "Night Vision (2:15)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.nightVision		.id,2700, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.nightvision.long.splash"				, "Stretched Splash Night Vision Brew"		, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16454), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.CYAN	+ "Night Vision (6:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.nightVision		.id,7200, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.weakness"							, "Weakening Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8200), IL.Bottle_Empty.get(1), 250)						, LH.Chat.DRED	+ "Weakness (1:30)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.weakness			.id,1800, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.weakness.long"						, "Stretched Weakening Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8264), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.DRED	+ "Weakness (4:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.weakness			.id,4800, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.weakness.splash"						, "Splash Weakening Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16392), IL.Bottle_Empty.get(1), 250)						, LH.Chat.DRED	+ "Weakness (1:07)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.weakness			.id,1350, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.weakness.long.splash"				, "Stretched Splash Weakening Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16456), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.DRED	+ "Weakness (3:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.weakness			.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.slowness"							, "Lame Brew"								, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8202), IL.Bottle_Empty.get(1), 250)						, LH.Chat.DRED	+ "Slowness (1:30)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSlowdown		.id,1800, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.slowness.long"						, "Stretched Lame Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8266), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.DRED	+ "Slowness (4:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSlowdown		.id,4800, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.slowness.splash"						, "Splash Lame Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16394), IL.Bottle_Empty.get(1), 250)						, LH.Chat.DRED	+ "Slowness (1:07)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSlowdown		.id,1350, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.slowness.long.splash"				, "Stretched Splash Lame Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16458), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.DRED	+ "Slowness (3:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSlowdown		.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.waterbreathing"						, "Fishy Brew"								, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8205), IL.Bottle_Empty.get(1), 250)						, LH.Chat.CYAN	+ "Water Breathing (3:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.waterBreathing	.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.waterbreathing.long"					, "Stretched Fishy Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8269), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.CYAN	+ "Water Breathing (8:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.waterBreathing	.id,9600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.waterbreathing.splash"				, "Splash Fishy Brew"						, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16397), IL.Bottle_Empty.get(1), 250)						, LH.Chat.CYAN	+ "Water Breathing (2:15)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.waterBreathing	.id,2700, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.waterbreathing.long.splash"			, "Stretched Splash Fishy Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16461), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.CYAN	+ "Water Breathing (6:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.waterBreathing	.id,7200, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.invisibility"						, "Invisible Brew"							, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8206), IL.Bottle_Empty.get(1), 250)						, LH.Chat.CYAN	+ "Invisibility (3:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.invisibility		.id,3600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.invisibility.long"					, "Stretched Invisible Brew"				, null, 1, 1000, 300, ST.make(Items.potionitem, 1,  8270), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.CYAN	+ "Invisibility (8:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.invisibility		.id,9600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.invisibility.splash"					, "Splash Invisible Brew"					, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16398), IL.Bottle_Empty.get(1), 250)						, LH.Chat.CYAN	+ "Invisibility (2:15)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.invisibility		.id,2700, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.invisibility.long.splash"			, "Stretched Splash Invisible Brew"			, null, 1, 1000, 300, ST.make(Items.potionitem, 1, 16462), IL.Bottle_Empty.get(1), 250).setLuminosity( 5)	, LH.Chat.CYAN	+ "Invisibility (6:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.invisibility		.id,7200, 0, 100);
		
		// Those Potions are broken duplicates, which cannot be improved with Redstone or Glowstone anymore, so I need to at least add them for emptying the Bottles.
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(UT.Fluids.make("potion.weakness"			, 250), ST.make(Items.potionitem, 1,  8232), NI, T));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(UT.Fluids.make("potion.slowness"			, 250), ST.make(Items.potionitem, 1,  8234), NI, T));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(UT.Fluids.make("potion.damage"				, 250), ST.make(Items.potionitem, 1,  8268), NI, T));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(UT.Fluids.make("potion.weakness.splash"	, 250), ST.make(Items.potionitem, 1, 16424), NI, T));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(UT.Fluids.make("potion.slowness.splash"	, 250), ST.make(Items.potionitem, 1, 16426), NI, T));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(UT.Fluids.make("potion.damage.splash"		, 250), ST.make(Items.potionitem, 1, 16460), NI, T));
		
		// Et Futurum Lingering Potions
		new FoodStatDrink(UT.Fluids.create("potion.damage.lingering"					, "Lingering Harming Brew"					, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8268), IL.Bottle_Empty.get(1), 250)					, LH.Chat.RED	+ "Instant Damage I"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.harm				.id,   0, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.damage.strong.lingering"				, "Strong Lingering Harming Brew"			, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8236), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.RED	+ "Instant Damage II"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.harm				.id,   0, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.health.lingering"					, "Lingering Healing Brew"					, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8261), IL.Bottle_Empty.get(1), 250)					, LH.Chat.PINK	+ "Instant Health I"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.heal				.id,   0, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.health.strong.lingering"				, "Strong Lingering Healing Brew"			, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8229), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.PINK	+ "Instant Health II"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.heal				.id,   0, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.jump.lingering"						, "Lingering Jumpy Brew"					, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8267), IL.Bottle_Empty.get(1), 250)					, LH.Chat.GREEN	+ "Jump Boost I (0:45)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.jump				.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.jump.strong.lingering"				, "Strong Lingering Jumpy Brew"				, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8235), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.GREEN	+ "Jump Boost II (0:22)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.jump				.id, 450, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.lingering"						, "Lingering Swiftness Brew"				, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8194), IL.Bottle_Empty.get(1), 250)					, LH.Chat.GREEN	+ "Speed I (0:45)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.strong.lingering"				, "Strong Lingering Swiftness Brew"			, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8226), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.GREEN	+ "Speed II (0:22)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id, 450, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.speed.long.lingering"				, "Stretched Lingering Swiftness Brew"		, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8258), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.GREEN	+ "Speed I (2:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSpeed		.id,2400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.lingering"					, "Lingering Strength Brew"					, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8201), IL.Bottle_Empty.get(1), 250)					, LH.Chat.GREEN	+ "Strength I (0:45)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.strong.lingering"			, "Strong Lingering Strength Brew"			, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8233), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.GREEN	+ "Strength II (0:22)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id, 450, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.strength.long.lingering"				, "Stretched Lingering Strength Brew"		, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8265), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.GREEN	+ "Strength I (2:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.damageBoost		.id,2400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.lingering"						, "Lingering Regenerating Brew"				, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8193), IL.Bottle_Empty.get(1), 250)					, LH.Chat.PINK	+ "Regeneration I (0:11)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id, 222, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.strong.lingering"				, "Strong Lingering Regenerating Brew"		, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8225), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.PINK	+ "Regeneration II (0:05)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id, 111, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.regen.long.lingering"				, "Stretched Lingering Regenerating Brew"	, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8257), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.PINK	+ "Regeneration I (0:30)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.regeneration		.id, 600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.lingering"					, "Lingering Poisonous Brew"				, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8196), IL.Bottle_Empty.get(1), 250)					, LH.Chat.RED	+ "Poison I (0:11)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 222, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.strong.lingering"				, "Strong Lingering Poisonous Brew"			, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8228), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.RED	+ "Poison II (0:05)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 111, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.poison.long.lingering"				, "Stretched Lingering Poisonous Brew"		, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8260), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.RED	+ "Poison I (0:30)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.poison			.id, 600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.fireresistance.lingering"			, "Lingering Fire Resistant Brew"			, null, 1, 1000, 375, ST.make(MD.EtFu, "lingering_potion", 1,  8227), IL.Bottle_Empty.get(1), 250).setLuminosity(10), LH.Chat.BLUE	+ "Fire Resistance (0:45)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.fireResistance	.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.fireresistance.long.lingering"		, "Stretched Lingering Fire Resistant Brew"	, null, 1, 1000, 375, ST.make(MD.EtFu, "lingering_potion", 1,  8259), IL.Bottle_Empty.get(1), 250).setLuminosity(15), LH.Chat.BLUE	+ "Fire Resistance (2:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.fireResistance	.id,2400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.nightvision.lingering"				, "Lingering Night Vision Brew"				, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8230), IL.Bottle_Empty.get(1), 250)					, LH.Chat.CYAN	+ "Night Vision (0:45)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.nightVision		.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.nightvision.long.lingering"			, "Stretched Lingering Night Vision Brew"	, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8262), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.CYAN	+ "Night Vision (2:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.nightVision		.id,2400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.weakness.lingering"					, "Lingering Weakening Brew"				, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8232), IL.Bottle_Empty.get(1), 250)					, LH.Chat.DRED	+ "Weakness (0:22)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.weakness			.id, 450, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.weakness.long.lingering"				, "Stretched Lingering Weakening Brew"		, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8264), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.DRED	+ "Weakness (1:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.weakness			.id,1200, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.slowness.lingering"					, "Lingering Lame Brew"						, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8234), IL.Bottle_Empty.get(1), 250)					, LH.Chat.DRED	+ "Slowness (0:22)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSlowdown		.id, 450, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.slowness.long.lingering"				, "Stretched Lingering Lame Brew"			, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8266), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.DRED	+ "Slowness (1:00)"			,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.moveSlowdown		.id,1200, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.waterbreathing.lingering"			, "Lingering Fishy Brew"					, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8237), IL.Bottle_Empty.get(1), 250)					, LH.Chat.CYAN	+ "Water Breathing (0:45)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.waterBreathing	.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.waterbreathing.long.lingering"		, "Stretched Lingering Fishy Brew"			, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8269), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.CYAN	+ "Water Breathing (2:00)"	,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.waterBreathing	.id,2400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.invisibility.lingering"				, "Lingering Invisible Brew"				, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8238), IL.Bottle_Empty.get(1), 250)					, LH.Chat.CYAN	+ "Invisibility (0:45)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.invisibility		.id, 900, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.invisibility.long.lingering"			, "Stretched Lingering Invisible Brew"		, null, 1, 1000, 300, ST.make(MD.EtFu, "lingering_potion", 1,  8270), IL.Bottle_Empty.get(1), 250).setLuminosity( 5), LH.Chat.CYAN	+ "Invisibility (2:00)"		,  0, 0.0F  ,   0, C+37,  0.00F, EnumAction.drink, T, F, F, Potion.invisibility		.id,2400, 0, 100);
		
		
		
		
		
		
		
		
		
		new FoodStatDrink(UT.Fluids.create("error"										, "Liquid Error"							, null					, 1, 1000,   0)																							, "Do not drink!"													,  0, 0.0F  ,   0,    0,  1.00F,999,999,999,999,999, EnumAction.drink, T, F, F, Potion.harm						.id,9999,99, 999, Potion.blindness			.id,9999,99, 999, Potion.weakness			.id,9999,99, 999, Potion.hunger.id,9999,99, 999);
		
		new FoodStatDrink("water"																																																									, "Regular H2O"														,  0, 0.0F  ,  40, C+35,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F);
		new FoodStatDrink("ic2distilledwater"																																																						, "Distilled H2O"													,  0, 0.0F  ,  40, C+35,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F);
		new FoodStatDrink(UT.Fluids.create("ice"										, "Near Frozen Water"						, MT.Ice				, 1, 1000,   C)																							, "Almost frozen H2O"												,  0, 0.0F  ,  40, C+30,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F, Potion.moveSlowdown				.id, 400, 1,  40, Potion.digSlowdown		.id, 400, 1,  40, PotionsGT.ID_FROSTBITE	   , 400, 1,  10);
		new FoodStatDrink("waterdirty"																																																								, "Dirty"															,  0, 0.0F  ,  10, C+37,  0.50F,  0,  0,  5,  0,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  80, Potion.poison				.id, 200, 0,  30);
		new FoodStatDrink("seawater"																																																								, "Salty"															,  0, 0.0F  ,  10, C+35,  0.50F,  0,  0, 30,  0,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 2,  95, PotionsGT.ID_DEHYDRATION	   , 400, 1, 100);
		new FoodStatDrink("saltwater"																																																								, "Saltier than the seven Seas"										,  1, 0.0F  ,  10, C+35,  0.50F,  0,  0, 90,  0,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 800, 2, 100, PotionsGT.ID_DEHYDRATION	   , 800, 2, 100);
		new FoodStatDrink(UT.Fluids.create("soda"										, "Soda"									, null					, 1, 1000, 300)																							, "Simply carbonated Water"											,  1, 0.1F  ,  50, C+35,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.mineralwater"						, "Mineral Water"							, null					, 1, 1000, 300)																							, "The best Stuff you can drink to stay healthy"					,  1, 0.1F  ,  40, C+35,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.regeneration				.id, 100, 1,  10);
		new FoodStatDrink(UT.Fluids.create("mineralsoda"								, "Mineral Soda"							, null					, 1, 1000, 300)																							, "The best Stuff you can drink to stay healthy"					,  1, 0.2F  ,  50, C+35,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.regeneration				.id, 100, 1,  10);
		
		
		new FoodStatDrink(UT.Fluids.create("juice"										, "Juice"									, null					, 1, 1000, 300)																							, "From a Random Fruit"												,  3, 0.4F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("strawberryjuice"							, "Strawberry Juice"						, null					, 1, 1000, 300)																							, "Where is the Straw for that Berry Juice?"						,  6, 0.4F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  10);
		new FoodStatDrink(UT.Fluids.create("melonjuice"									, "Melon Juice"								, null					, 1, 1000, 300)																							, "Yoshis favourite Fruit Juice"									,  2, 0.4F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("kiwijuice"									, "Kiwi Juice"								, null					, 1, 1000, 300)																							, "Made of little Birds!"											,  4, 0.4F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("persimmonjuice"								, "Persimmon Juice"							, null					, 1, 1000, 300)																							, ""																,  3, 0.8F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("currantjuice"								, "Currant Juice"							, null					, 1, 1000, 300)																							, "Runs electric Currant"											,  3, 0.4F  ,  30, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("raspberryjuice"								, "Raspberry Juice"							, null					, 1, 1000, 300)																							, "Made of tiny Computers!"											,  3, 0.4F  ,  30, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("blackberryjuice"							, "Blackberry Juice"						, null					, 1, 1000, 300)																							, "Made of Smartphones!"											,  3, 0.4F  ,  30, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("blueberryjuice"								, "Blueberry Juice"							, null					, 1, 1000, 300)																							, "Colors everything Blue"											,  3, 0.4F  ,  30, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("gooseberryjuice"							, "Gooseberry Juice"						, null					, 1, 1000, 300)																							, "Made of real Geese!"												,  3, 0.4F  ,  30, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("binnie.juicecranberry"						, "Cranberry Juice"							, null					, 1, 1000, 300)																							, "Made of real Cranes!"											,  3, 0.4F  ,  30, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("binnie.juiceelderberry"						, "Elderberry Juice"						, null					, 1, 1000, 300)																							, "Made of elderly Berries!"										,  3, 0.4F  ,  30, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("binnie.juicelemon"							, "Lemon Juice"								, null					, 1, 1000, 300)																							, "Maybe adding Sugar will make it less sour"						,  3, 0.8F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juicepineapple"						, "Ananas Juice"							, null					, 1, 1000, 300)																							, "Made of Trees!"													,  3, 0.4F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juiceorange"							, "Orange Juice"							, null					, 1, 1000, 300)																							, "A very annoying Juice"											,  3, 0.8F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juiceapricot"						, "Apricot Juice"							, null					, 1, 1000, 300)																							, ""																,  3, 0.8F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juicelime"							, "Lime Juice"								, null					, 1, 1000, 300)																							, ""																,  3, 0.8F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juicepear"							, "Pear Juice"								, null					, 1, 1000, 300)																							, ""																,  6, 0.4F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 0,  20);
		new FoodStatDrink(UT.Fluids.create("binnie.juicecherry"							, "Cherry Juice"							, null					, 1, 1000, 300)																							, ""																,  6, 0.4F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  10);
		new FoodStatDrink(UT.Fluids.create("binnie.juiceplum"							, "Plum Juice"								, null					, 1, 1000, 300)																							, "May have a cleaning effect on your internals."					,  2, 0.4F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("binnie.juicepeach"							, "Peach Juice"								, null					, 1, 1000, 300)																							, "The Princess is in another Castle"								,  2, 0.4F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("binnie.juicegrapefruit"						, "Grapefruit Juice"						, null					, 1, 1000, 300)																							, "Not suitable for Diets!"											,  3, 0.8F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juicebanana"							, "Banana Juice"							, null					, 1, 1000, 300)																							, "Big juiced Banana"												,  6, 0.4F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("grapejuice"									, "Green Grape Juice"						, null					, 1, 1000, 300)																							, "May have a cleaning effect on your internals."					,  4, 0.4F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("grc.grapewine0"								, "Purple Grape Juice"						, null					, 1, 1000, 300)																							, "May have a cleaning effect on your internals."					,  4, 0.4F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juiceredgrape"						, "Red Grape Juice"							, null					, 1, 1000, 300)																							, "May have a cleaning effect on your internals."					,  4, 0.4F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juicewhitegrape"						, "White Grape Juice"						, null					, 1, 1000, 300)																							, "May have a cleaning effect on your internals."					,  4, 0.4F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.juiceapple"							, "Apple Juice"								, null					, 1, 1000, 300)																							, "Made of the Apples from our best Oak Farms"						,  6, 0.4F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 0,  20);
		new FoodStatDrink(UT.Fluids.create("grc.applecider0"							, "Apple Juice"								, null					, 1, 1000, 300)																							, "Made of the Apples from our best Oak Farms"						,  6, 0.4F  ,  20, C+37,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 0,  20);
		new FoodStatDrink(UT.Fluids.create("figjuice"									, "Fig Juice"								, null					, 1, 1000, 300)																							, ""																,  2, 0.4F  ,  40, C+37,  0.50F,  0,  0,  5, 15,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("pomegranatejuice"							, "Pomegranate Juice"						, null					, 1, 1000, 300)																							, ""																,  2, 0.4F  ,  40, C+37,  0.50F,  0,  0,  5, 15,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("mangojuice"									, "Mango Juice"								, null					, 1, 1000, 300)																							, ""																,  3, 0.4F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("starfruitjuice"								, "Starfruit Juice"							, null					, 1, 1000, 300)																							, ""																,  3, 0.4F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("papayajuice"								, "Papaya Juice"							, null					, 1, 1000, 300)																							, ""																,  3, 0.4F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("coconutmilk"								, "Coconut Milk"							, null					, 1, 1000, 300)																							, ""																,  6, 0.8F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		
		new FoodStatDrink(UT.Fluids.create("fruitsmoothie"								, "Froot Smoothie"							, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("strawberrysmoothie"							, "Strawberry Smoothie"						, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  10);
		new FoodStatDrink(UT.Fluids.create("melonsmoothie"								, "Melon Smoothie"							, null					, 1, 1000,   C)																							, ""																,  1, 0.2F  ,  40, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("kiwismoothie"								, "Kiwi Smoothie"							, null					, 1, 1000,   C)																							, ""																,  3, 0.2F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("currantsmoothie"							, "Currant Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("raspberrysmoothie"							, "Raspberry Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("blackberrysmoothie"							, "Blackberry Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("blueberrysmoothie"							, "Blueberry Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("gooseberrysmoothie"							, "Gooseberry Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("cranberrysmoothie"							, "Cranberry Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("elderberrysmoothie"							, "Elderberry Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("lemonsmoothie"								, "Lemon Smoothie"							, null					, 1, 1000,   C)																							, ""																,  2, 0.4F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("pineapplesmoothie"							, "Ananas Smoothie"							, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("orangesmoothie"								, "Orange Smoothie"							, null					, 1, 1000,   C)																							, ""																,  2, 0.4F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("persimmonsmoothie"							, "Persimmon Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.4F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("apricotsmoothie"							, "Apricot Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.4F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("limesmoothie"								, "Lime Smoothie"							, null					, 1, 1000,   C)																							, ""																,  2, 0.4F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  60);
		new FoodStatDrink(UT.Fluids.create("pearsmoothie"								, "Pear Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 0,  20);
		new FoodStatDrink(UT.Fluids.create("cherrysmoothie"								, "Cherry Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  10);
		new FoodStatDrink(UT.Fluids.create("plumsmoothie"								, "Plum Smoothie"							, null					, 1, 1000,   C)																							, ""																,  1, 0.2F  ,  40, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("peachsmoothie"								, "Peach Smoothie"							, null					, 1, 1000,   C)																							, ""																,  1, 0.2F  ,  40, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("grapefruitsmoothie"							, "Grapefruit Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.4F  ,  20, C+35,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("bananasmoothie"								, "Banana Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("redgrapesmoothie"							, "Grape Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("whitegrapesmoothie"							, "Grape Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("purplegrapesmoothie"						, "Grape Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("grapesmoothie"								, "Grape Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 1,  60);
		new FoodStatDrink(UT.Fluids.create("applesmoothie"								, "Apple Smoothie"							, null					, 1, 1000,   C)																							, ""																,  4, 0.2F  ,  20, C+35,  0.50F,  0,  0,  5, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 200, 0,  20);
		new FoodStatDrink(UT.Fluids.create("figsmoothie"								, "Fig Smoothie"							, null					, 1, 1000,   C)																							, ""																,  1, 0.2F  ,  40, C+35,  0.50F,  0,  0,  5, 15,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("pomegranatesmoothie"						, "Pomegranate Smoothie"					, null					, 1, 1000,   C)																							, ""																,  1, 0.2F  ,  40, C+35,  0.50F,  0,  0,  5, 15,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("mangosmoothie"								, "Mango Smoothie"							, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  40, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("starfruitsmoothie"							, "Starfruit Smoothie"						, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  40, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("papayasmoothie"								, "Papaya Smoothie"							, null					, 1, 1000,   C)																							, ""																,  2, 0.2F  ,  40, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1,  20);
		new FoodStatDrink(UT.Fluids.create("coconutsmoothie"							, "Coconut Smoothie"						, null					, 1, 1000,   C)																							, ""																,  4, 0.4F  ,  40, C+35,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		
		
		new FoodStatDrink(UT.Fluids.create("binnie.juicetomato"							, "Tomato Juice"							, null					, 1, 1000, 300)																							, "Used for Ketchup and Tomato Sauces"								,  1, 0.2F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  30);
		new FoodStatDrink(UT.Fluids.create("binnie.juicecarrot"							, "Carrot Juice"							, null					, 1, 1000, 300)																							, "Not scientifically proven to improve eyesight!"					,  1, 0.2F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.nightVision				.id, 400, 0,  30);
		new FoodStatDrink(UT.Fluids.create("beetjuice"									, "Beet Juice"								, null					, 1, 1000, 300)																							, "Beets me."														,  1, 0.2F  ,  40, C+37,  0.50F,  0,  0,  0, 40,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 200, 1,  25);
		new FoodStatDrink(UT.Fluids.create("pumpkinjuice"								, "Pumpkin Juice"							, null					, 1, 1000, 300)																							, "Perfect for Halloween"											,  1, 0.2F  ,  40, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("potatojuice"								, "Potato Juice"							, null					, 1, 1000, 300)																							, "Ever seen Potato Juice in stores? No? That has a reason."		,  3, 0.3F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("hopsmash"									, "Hops Mash"								, null					, 1, 1000, 300)																							, "Every Beer has a start"											,  1, 0.1F  ,  15, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("wheathopsmash"								, "Wheat-Hops Mash"							, null					, 1, 1000, 300)																							, "Also known as 'Duff-Lite'"										,  1, 0.1F  ,  15, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("binnie.mashwheat"							, "Wheat Mash"								, null					, 1, 1000, 300)																							, "Is this liquefied Bread or what?"								,  2, 0.1F  ,  15, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("binnie.mashcorn"							, "Corn Mash"								, null					, 1, 1000, 300)																							, ""																,  2, 0.1F  ,  15, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("binnie.mashgrain"							, "Grain Mash"								, null					, 1, 1000, 300)																							, ""																,  2, 0.1F  ,  15, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("binnie.mashrye"								, "Rye Mash"								, null					, 1, 1000, 300)																							, ""																,  2, 0.1F  ,  15, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("ricewater"									, "Ricewater"								, null					, 1, 1000, 300)																							, ""																,  1, 0.1F  ,  20, C+37,  0.50F,  0,  0,  0, 10,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("reedwater"									, "Reedwater"								, null					, 1, 1000, 300)																							, "I guess this tastes better when fermented"						,  1, 0.1F  ,  20, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("cactuswater"								, "Cactuswater"								, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.JUICE)											, ""																,  1, 0.1F  ,  10, C+37,  0.50F,  0,  0, 40,  0,  0, EnumAction.drink, F, F, F, Potion.poison					.id, 100, 0,  90);
		new FoodStatDrink(UT.Fluids.create("maplesap"									, "Maple Sap"								, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "May or may not be Canadian"										,  3, 0.2F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 300, 1,  50);
		new FoodStatDrink(UT.Fluids.create("rainbowsap"									, "Rainbow Sap"								, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "Friendship renews your Power! Or was it Magic? Yeah just Magic."	,  5, 0.5F  ,  30, C+37,  0.75F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.regeneration				.id,  60, 4, 100, Potion.digSpeed.id, 900, 2, 100).setMilk();
		
		
		
		new FoodStatDrink("binnie.juice"			/* Yep, the Fruit Wine has this internal name */																																								, "What Fruits is this made of?!"									,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.wineagave"																																																						, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.wineapricot"																																																						, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winebanana"																																																						, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winecarrot"																																																						, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winecherry"																																																						, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winecitrus"																																																						, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winecranberry"																																																					, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.wineelderberry"																																																					, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.wineplum"																																																							, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winesparkling"																																																					, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winetomato"																																																						, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink("binnie.winefortified"																																																					, ""																,  3, 0.4F  ,  10, C+37,  0.50F, 60,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 1,  90);
		new FoodStatDrink(UT.Fluids.create("wine"										, "Wine"									, null					, 1, 1000, 300)																							, "Exquisite"														,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink(UT.Fluids.create("ricardosanchez"								, "Ricardo Sanchez"							, null					, 1, 1000, 300)																							, "Wubalubadubdub"													,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.winered"								, "Red Wine"								, null					, 1, 1000, 300)																							, "Exquisite"														,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.winewhite"							, "White Wine"								, null					, 1, 1000, 300)																							, "Exquisite"														,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  60);
		new FoodStatDrink(UT.Fluids.create("limoncello"									, "Limoncello"								, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC, FluidsGT.WINE)						, "An alcoholic Drink which tastes like Lemons"						,  2, 0.4F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id,1200, 0,  90);
		new FoodStatDrink(UT.Fluids.create("potion.sake"								, "Sake"									, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC, FluidsGT.WINE)						, "Rice Wine"														,  4, 0.4F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 1,  60);
		
		new FoodStatDrink("binnie.beerale"																																																							, ""																,  6, 0.4F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 400, 2,  60);
		new FoodStatDrink("binnie.beercorn"																																																							, ""																,  6, 0.4F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 400, 2,  60);
		new FoodStatDrink("binnie.beerrye"																																																							, ""																,  6, 0.4F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 400, 2,  60);
		new FoodStatDrink("binnie.beerstout"																																																						, ""																,  6, 0.4F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 400, 2,  60);
		new FoodStatDrink("binnie.beerwheat"																																																						, ""																,  6, 0.4F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 400, 2,  60);
		new FoodStatDrink("binnie.beerlager"																																																						, ""																,  4, 0.4F  ,  10, C+35,  0.50F, 40,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 1,  60);
		new FoodStatDrink(UT.Fluids.create("beer"										, "Beer"									, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC, FluidsGT.BEER)						, "Not to be confused with Beerus, the God of Destruction"			,  6, 0.4F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 400, 2,  60);
		new FoodStatDrink(UT.Fluids.create("darkbeer"									, "Dark Beer"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC, FluidsGT.BEER)						, "Dark Beer, for the real Men"										,  4, 0.4F  ,  10, C+35,  0.50F, 40,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 1,  60);
		new FoodStatDrink(UT.Fluids.create("potion.dragonblood"							, "Dragon Blood"							, null					, 1, 1000, 325, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC, FluidsGT.BEER)						, "FUS RO DAH!"														,  4, 0.4F  ,   5, C+40,  0.50F, 70,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 2,  90, PotionsGT.ID_INSANITY, 600, 0, 100);
		
		new FoodStatDrink("binnie.brandyapple"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandyapricot"																																																					, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandycherry"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandycitrus"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandyelderberry"																																																					, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandyfruit"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandygrape"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandypear"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.brandyplum"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		
		new FoodStatDrink("binnie.whiskey"																																																							, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.whiskeycorn"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.whiskeyrye"																																																						, ""																,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.whiskeywheat"						, "Scotch"									, null					, 1, 1000, 275)																							, "Technically this is just a Whisky"								,  2, 0.1F  ,  10, C+35,  0.50F, 30,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink(UT.Fluids.create("glenmckenner"								, "Glen McKenner"							, null					, 1, 1000, 275)																							, "Don't hand to easily surprised people, they will shatter it."	,  2, 0.1F  ,   5, C+35,  0.50F, 50,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 2,  90);
		
		new FoodStatDrink(UT.Fluids.create("binnie.rumwhite"							, "Rum"										, null					, 1, 1000, 300)																							, "A buddle o' rum"													,  4, 0.4F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.rumdark"								, "Pirate Brew"								, null					, 1, 1000, 300)																							, "Set the Sails, we are going to Torrentuga!"						,  4, 0.4F  ,   5, C+37,  0.50F, 60,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 2,  90);
		
		new FoodStatDrink("binnie.ciderpear"																																																						, "If you have nothing better to do with your Pears"				,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.ciderpeach"																																																						, "If you have nothing better to do with your Peaches"				,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.winepineapple"						, "Ananas Cider"							, null					, 1, 1000, 300)																							, "If you have nothing better to do with your Pineapples"			,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.ciderapple"							, "Cider"									, null					, 1, 1000, 300)																							, "If you have nothing better to do with your Apples"				,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		
		new FoodStatDrink("binnie.liqueuralmond"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueuranise"																																																						, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurbanana"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurblackberry"																																																				, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurblackcurrant"																																																				, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurcherry"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurchocolate"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurcinnamon"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurcoffee"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurhazelnut"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurherbal"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurlemon"																																																						, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurmelon"																																																						, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurmint"																																																						, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurorange"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurpeach"																																																						, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		new FoodStatDrink("binnie.liqueurraspberry"																																																					, ""																,  4, 0.2F  ,  10, C+35,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 1,  60);
		
		new FoodStatDrink("binnie.liquorpear"																																																						, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.liquorfruit"																																																						, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.liquorelderberry"																																																					, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.liquorcherry"																																																						, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.liquorapricot"																																																					, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.liquorapple"																																																						, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.spiritsugarcane"																																																					, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.spiritneutral"																																																					, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.spiritgin"																																																						, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink("binnie.tequila"																																																							, ""																,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink(UT.Fluids.create("binnie.vodka"								, "Vodka"									, null					, 1, 1000, 275)																							, "Not to be confused with Water"									,  2, 0.2F  ,  10, C+35,  0.50F, 55,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 1,  60);
		new FoodStatDrink(UT.Fluids.create("potion.leninade"							, "Leninade"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC)										, "Let the Communism flow through you!"								,  2, 0.2F  ,   5, C+35,  0.50F, 65,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 500, 2,  90);
		new FoodStatDrink(UT.Fluids.create("potion.alcopops"							, "Alcopops"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC)										, "Don't let your Children drink this junk!"						,  2, 0.2F  ,  10, C+30,  0.50F, 30,  0,  0, 30,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 900, 1,  90);
		new FoodStatDrink(UT.Fluids.create("short.mead"									, "Mead"									, null					, 1, 1000, 300)																							, "A Vikings favourite brew"										,  3, 0.1F  ,  10, C+37,  0.50F, 30,  0,  0, 30,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 1,  60, Potion.resistance.id, 300, 1,  60);
		
		
		
		new FoodStatDrink(UT.Fluids.create("vinegar"									, "Grape Vinegar"							, null					, 1, 1000, 300)																							, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 1,  70);
		new FoodStatDrink(UT.Fluids.create("applevinegar"								, "Apple Cider Vinegar"						, null					, 1, 1000, 300)																							, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 15,  0, EnumAction.drink, F, F, F, Potion.resistance				.id, 400, 2,  70);
		new FoodStatDrink(UT.Fluids.create("canevinegar"								, "Cane Vinegar"							, null					, 1, 1000, 300)																							, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 2,  70);
		new FoodStatDrink(UT.Fluids.create("ricevinegar"								, "Rice Vinegar"							, null					, 1, 1000, 300)																							, ""																,  2, 0.2F  ,  10, C+37,  0.50F, 30,  0,  0, 10,  0, EnumAction.drink, F, F, F, Potion.damageBoost				.id, 300, 2,  70);
		
		
		new FoodStatDrink(UT.Fluids.create("chillysauce"								, "Chili Sauce"								, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "Spicy"															,  2, 0.1F  ,  10, C+42,  0.50F,  0,  0, 10, 10,  0, EnumAction.drink, F, F, F, Potion.confusion				.id,1000, 0,  10, Potion.fireResistance.id,1000, 0,  60, PotionsGT.ID_DEHYDRATION	   , 400, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.hotsauce"							, "Hot Sauce"								, null					, 1, 1000, 325, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "Very Spicy, I guess?"											,  2, 0.1F  ,  10, C+44,  0.50F,  0,  0, 20, 10,  0, EnumAction.drink, F, F, F, Potion.confusion				.id,2000, 0,  30, Potion.fireResistance.id,2000, 0,  70, PotionsGT.ID_DEHYDRATION	   , 400, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.diabolosauce"						, "Diabolo Sauce"							, null					, 1, 1000, 350, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "As if the Devil made this Sauce"									,  2, 0.1F  ,  10, C+46,  0.50F,  0,  0, 30, 10,  0, EnumAction.drink, F, F, F, Potion.confusion				.id,3000, 1,  50, Potion.fireResistance.id,3000, 0,  80, PotionsGT.ID_DEHYDRATION	   , 400, 2, 100, PotionsGT.ID_INSANITY	   , 600, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.diablosauce"							, "Diablo Sauce"							, null					, 1, 1000, 375, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ACID)											, "Diablo always comes back!"										,  2, 0.1F  ,  10, C+48,  0.50F,  0,  0, 40, 10,  0, EnumAction.drink, F, F, F, Potion.confusion				.id,4000, 1,  70, Potion.fireResistance.id,4000, 0,  90, PotionsGT.ID_DEHYDRATION	   , 400, 3, 100, PotionsGT.ID_INSANITY	   , 600, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.diablosauce.strong"					, "Old Man Snitches glitched Diablo Sauce"	, null					, 1, 1000, 999, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ACID, FluidsGT.ENCHANTED_EFFECT).setLuminosity(15)	, "[Missing No]"												,  2, 0.1F  ,  10, C+50,  0.50F,  0,  0, 99, 10,  0, EnumAction.drink, F, F, F, Potion.confusion				.id,9999, 2, 999, Potion.fireResistance.id,9999, 9, 999, PotionsGT.ID_DEHYDRATION	   , 400, 4, 100, PotionsGT.ID_INSANITY	   , 600, 2, 100);
		
		
		new FoodStatDrink(UT.Fluids.create("for.honey"									, "Honey"									, MT.Honey				, 1, 1000, 300)																							, "Bee careful with it"												,  1, 0.1F  ,  20, C+37,  0.50F,  0,  0,  0, 40,  0, EnumAction.drink, T, F, F).setMilk();
		new FoodStatDrink(UT.Fluids.create("grc.honey"									, "Honey (GrC)"								, MT.Honey				, 1, 1000, 300)																							, "Bee careful with it"												,  1, 0.1F  ,  20, C+37,  0.50F,  0,  0,  0, 40,  0, EnumAction.drink, T, F, F).setMilk();
		new FoodStatDrink(UT.Fluids.create("honey"										, "Honey (BoP, Erebus)"						, MT.Honey				, 1, 1000, 300)																							, "Bee careful with it"												,  1, 0.1F  ,  20, C+37,  0.50F,  0,  0,  0, 40,  0, EnumAction.drink, T, F, F).setMilk();
		new FoodStatDrink(UT.Fluids.create("honeydew"									, "Honeydew"								, MT.Honeydew			, 1, 1000, 300)																							, "Sweet sweet Honeydew"											,  2, 0.2F  ,  20, C+37,  0.50F, 10,  0,  0, 30,  0, EnumAction.drink, T, F, F, Potion.moveSpeed				.id, 600, 0, 100).setMilk();
		new FoodStatDrink(UT.Fluids.create("potion.ambrosia"							, "Ambrosia"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC)										, "It's the Bee Movie, but everytime someone says Bee, it will..."	,  2, 0.2F  ,  20, C+37,  0.75F, 30,  0,  0, 40,  0, EnumAction.drink, T, F, F, Potion.regeneration				.id, 150, 0, 100).setMilk();
//		new FoodStatDrink(""	supposedly royal jelly																																																				, "you jelly?"														,  2, 0.2F  ,  20, C+37,  0.75F,  0,  0,  0, 40,  0, EnumAction.drink, T, F, F, Potion.regeneration				.id, 150, 1, 100).setMilk();
		
		
		new FoodStatDrink(UT.Fluids.create("sunfloweroil"								, "Sunflower Oil"							, MT.SunflowerOil		, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.COOKING_OIL)									, ""																,  2, 0.2F  ,  10, C+37,  0.50F,  0,  0, 20,  0, 20, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 1,  70);
		new FoodStatDrink(UT.Fluids.create("nutoil"										, "Nut Oil"									, MT.NutOil				, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.COOKING_OIL)									, ""																,  2, 0.2F  ,  10, C+37,  0.50F,  0,  0, 20,  0, 20, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 1,  70);
		new FoodStatDrink(UT.Fluids.create("binnie.juiceolive"							, "Olive Oil"								, MT.OliveOil			, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.COOKING_OIL)									, ""																,  2, 0.2F  ,  10, C+37,  0.50F,  0,  0, 20,  0, 20, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 1,  70);
		new FoodStatDrink(UT.Fluids.create("seedoil"									, "Seed Oil"								, MT.SeedOil			, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.COOKING_OIL)									, ""																,  2, 0.2F  ,  10, C+37,  0.50F,  0,  0, 20,  0, 20, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 1,  70);
		new FoodStatDrink(UT.Fluids.create("linoil"										, "Lin Oil"									, MT.LinOil				, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.COOKING_OIL)									, ""																,  2, 0.2F  ,  10, C+37,  0.50F,  0,  0, 20,  0, 20, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 1,  70);
		new FoodStatDrink(UT.Fluids.create("hempoil"									, "Hemp Oil"								, MT.HempOil			, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.COOKING_OIL)									, ""																,  2, 0.2F  ,  10, C+37,  0.50F,  0,  0, 20,  0, 20, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 1,  70);
		new FoodStatDrink(UT.Fluids.create("fishoil"									, "Fish Oil"								, MT.FishOil			, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.COOKING_OIL)									, ""																,  2, 0.2F  ,  10, C+37,  0.50F,  0,  0, 20,  0, 20, EnumAction.drink, F, F, F, Potion.hunger					.id, 400, 1,  70);
		
		
		new FoodStatDrink(UT.Fluids.create("mayo"										, "Mayonnaise"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "Tastes like Cardboard"											,  3, 0.5F  ,   5, C+37,  0.25F,  0,  0, 10,  0, 20, EnumAction.eat  , F, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.dressing"							, "Dressing"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ALCOHOLIC)										, "For making yourself a Salad"										,  1, 0.5F  ,   5, C+36,  0.25F, 10,  0,  0,  0, 20, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("grcmilk.cream"								, "Heavy Cream"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD)															, ""																,  2, 0.4F  ,  20, C+37,  0.75F,  0,  0,  0, 20, 20, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("coconutcream"								, "Coconut Cream"							, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD)															, ""																,  2, 0.4F  ,  20, C+37,  0.75F,  0,  0,  0, 15, 15, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("ketchup"									, "Tomato Ketchup"							, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "this tooltip doesn't make sans"									,  4, 0.3F  ,  20, C+37,  0.50F,  0,  0,  0, 30,  0, EnumAction.drink, F, F, F, Potion.heal						.id,   0, 0,  10, Potion.moveSpeed.id, 200, 0,  20);
		new FoodStatDrink(UT.Fluids.create("chocolatecream"								, "Chocolate Cream"							, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD)															, ""																,  4, 0.2F  ,   5, C+37,  0.15F,  0,  0,  0, 30, 20, EnumAction.eat  , F, F, F);
		new FoodStatDrink(UT.Fluids.create("nutella"									, "Nutella"									, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "For Germans: It is 'die' Nutella, not 'der' nor 'das'"			,  8, 0.4F  ,   5, C+37,  0.15F,  0,  0,  0, 20, 30, EnumAction.eat  , F, F, F);
		new FoodStatDrink(UT.Fluids.create("peanutbutter"								, "Peanut Butter"							, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "This is NUTS!!!"													,  8, 0.4F  ,   5, C+37,  0.15F,  0,  0,  0, 20, 30, EnumAction.eat  , F, F, F);
		new FoodStatDrink(UT.Fluids.create("maplesyrup"									, "Maple Syrup"								, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "Etho paused to look at a vintage Beef, then he unpaused"			,  4, 0.2F  ,  20, C+37,  0.30F,  0,  0,  0, 40, 10, EnumAction.drink, F, F, F);
		
		
		new FoodStatDrink(UT.Fluids.create("purpledrink"								, "Purple Drink"							, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "How about Lemonade? Or some Ice Tea? I got Purple Drink!"		,  8, 0.2F  ,  30, C+35,  0.50F,  0,  0,  0, 40,  0, EnumAction.drink, F, F, F, Potion.moveSlowdown				.id,1200, 2,  90);
		new FoodStatDrink(UT.Fluids.create("potion.lemonade"							, "Lemonade"								, null					, 1, 1000, 275, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "Cold and refreshing Lemonade"									,  4, 0.3F  ,  20, C+35,  0.50F,  0,  0,  0, 40,  0, EnumAction.drink, F, F, F, Potion.digSpeed					.id, 900, 1,  90);
		
		
		new FoodStatDrink(UT.Fluids.create("goldencarrotjuice"							, "Golden Carrot Juice"						, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ENCHANTED_EFFECT, FluidsGT.JUICE)							.setLuminosity(15)	, "A golden Carrot in liquid form"							,  4, 0.2F  , 100, C+37,  0.75F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.nightVision				.id,1200, 0,  90);
		new FoodStatDrink(UT.Fluids.create("potion.goldenapplejuice"					, "Golden Apple Juice"						, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ENCHANTED_EFFECT, FluidsGT.FRUIT_JUICE, FluidsGT.JUICE)	.setLuminosity(15)	, "A golden Apple in liquid form"							,  4, 0.2F  , 100, C+37,  0.75F,  0,  0,  5, 30,  0, EnumAction.drink, F, F, F, Potion.field_76444_x			.id,2400, 0, 100, Potion.regeneration		.id, 100, 1, 100);
		new FoodStatDrink(UT.Fluids.create("potion.goldencider"							, "Golden Cider"							, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ENCHANTED_EFFECT, FluidsGT.ALCOHOLIC, FluidsGT.CIDER)		.setLuminosity(15)	, "More Resistance, less Regeneration"						,  4, 0.2F  , 100, C+37,  0.75F, 40,  0,  5, 30,  0, EnumAction.drink, F, F, F, Potion.field_76444_x			.id,2400, 1,  95);
		new FoodStatDrink(UT.Fluids.create("potion.idunsapplejuice"						, "Idun's Apple Juice"						, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ENCHANTED_EFFECT, FluidsGT.FRUIT_JUICE, FluidsGT.JUICE)	.setLuminosity(15)	, "So you got the Idea of using Notch Apples for a drink?"	,  4, 0.2F  , 100, C+37,  0.75F,  0,  0,  5, 30,  0, EnumAction.drink, F, F, F, Potion.regeneration				.id, 600, 4, 100, Potion.field_76444_x		.id,2400, 0, 100, Potion.resistance			.id,6000, 0, 100, Potion.fireResistance	.id,6000, 0, 100);
		new FoodStatDrink(UT.Fluids.create("potion.notchesbrew"							, "Notches Brew"							, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.ENCHANTED_EFFECT, FluidsGT.ALCOHOLIC, FluidsGT.CIDER)		.setLuminosity(15)	, "This is just overpowered"								,  4, 0.2F  , 100, C+37,  0.75F, 60,  0,  5, 30,  0, EnumAction.drink, F, F, F, Potion.regeneration				.id, 700, 4,  95, Potion.field_76444_x		.id,3000, 1,  95, Potion.resistance			.id,7000, 1,  95, Potion.fireResistance	.id,7000, 0,  95);
		
		
		new FoodStatDrink(UT.Fluids.create("potion.cavejohnsonsgrenadejuice"			, "Cave Johnson's Grenade Juice"			, null					, 1, 1000, 300, FluidsGT.SIMPLE)																		, "When life gives you Lemons, make Life take them Lemons back!"	,  0, 0.0F  ,  20, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F).setExplosive();
		new FoodStatDrink(UT.Fluids.create("holywater"									, "Holy Water"								, MT.HolyWater			, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.ENCHANTED_EFFECT)												, "May the holy Planks be with you"									,  0, 0.0F  ,  10, C+30,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F, Potion.poison					.id, 100, 1, 100, PotionsGT.ID_INSANITY, 600, 1, 100).setMilk();
		new FoodStatDrink(UT.Fluids.create("glue"										, "Glue"									, MT.Glue				, 1, 1000, 300, FluidsGT.SIMPLE)																		, "Do not eat!"														,  1, 0.1F  ,   5, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.eat  , T, F, F, Potion.moveSlowdown				.id, 400, 1,  90, Potion.digSlowdown.id, 400, 1,  90);
		new FoodStatDrink(UT.Fluids.create("mercury"									, "Mercury"									, MT.Hg					, 1, L   , 300, FluidsGT.SIMPLE)																		, "Liquid Metal"													,  0, 0.0F  ,   0, C+37,  0.00F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F, Potion.poison					.id,2000, 3, 100);
		new FoodStatDrink(UT.Fluids.create("sluicejuice"								, "Sluice Juice"							, null					, 1, 1000, 300, FluidsGT.SIMPLE)																		, ""																,  0, 0.0F  ,   0, C+37,  0.00F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F, Potion.moveSlowdown				.id,2000, 3, 100, Potion.poison		.id, 100, 1, 100);
		
		new FoodStatDrink(UT.Fluids.create("soymilk"									, "Soy Milk"								, null					, 1, 1000, 275)																							, "Milk Substitute"													,  0, 0.0F  ,  20, C+37,  0.50F,  0,  0,  0, 10,  0, EnumAction.drink, T, F, F).setMilk();
		new FoodStatDrink(UT.Fluids.create("milk"										, "Milk"									, MT.Milk				, 1, 1000, 300, ST.make(Items.milk_bucket,1,0), ST.make(Items.bucket,1,0), 1000)						, "Got Milk?"														,  0, 0.0F  ,  20, C+37,  0.75F,  0,  0,  0,  0, 10, EnumAction.drink, T, F, F).setMilk();
		new FoodStatDrink(UT.Fluids.create("grcmilk.milk"								, "Milk"									, MT.Milk				, 1, 1000, 300)																							, "Got Milk?"														,  0, 0.0F  ,  20, C+37,  0.75F,  0,  0,  0,  0, 10, EnumAction.drink, T, F, F).setMilk();
		new FoodStatDrink(UT.Fluids.create("spoiledmilk"								, "Milk"									, null					, 1, 1000, 300)																							, "Smells a little"													,  0, 0.0F  ,   0, C+37,  0.75F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F, Potion.hunger					.id, 100, 1, 100);
		new FoodStatDrink(UT.Fluids.create("rottendrink"								, "Rotten Drink"							, null					, 1, 1000, 275)																							, "Smells rotten"													,  0, 0.0F  ,   0, C+37,  0.75F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.hunger					.id, 100, 1, 100);
		new FoodStatDrink(UT.Fluids.create("mushroomsoup"								, "Mushroom Stew"							, null					, 1, 1000, 300, ST.make(Items.mushroom_stew,1,0), ST.make(Items.bowl,1,0), 1000)						, ""																,  2, 0.6F  ,   5, C+37,  0.15F,  0,  0, 10, 10,  0, EnumAction.eat  , T, F, F);
		
		
		new FoodStatDrink("pinkslime"																																																								, "Meaty Slime Juice"												,  4, 0.5F  ,  20, C+37,  0.50F,  0,  0,  0, 20,  0, EnumAction.drink, F, F, F, Potion.jump						.id,1200, 1,  75);
		new FoodStatDrink(UT.Fluids.create("slime"										, "Slime"									, null					, 1, 1000, 300)																							, "Green Slime Juice"												,  2, 0.5F  ,  20, C+37,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.jump						.id, 600, 0,  50);
		new FoodStatDrink(UT.Fluids.create("bawls"										, "BAWLS"									, null					, 1, 1000, 275)																							, "Here, take a cold and refreshing sip of my BAWLS"				,  2, 0.5F  ,  20, C+35,  0.50F,  0,  0,  0,  0,  0, EnumAction.drink, F, F, F, Potion.jump						.id,1200, 1,  90);
		
		
		new FoodStatDrink(UT.Fluids.create("potion.darkcoffee"							, "Dark Coffee"								, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.THERMOS)										, "Coffee, dark, without anything else"								,  2, 0.2F  ,   5, C+39,  0.50F,  0, 30, 15,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.darkcafeaulait"						, "Dark Cafe au lait"						, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.THERMOS)										, "Keeping you awake the whole night"								,  2, 0.2F  ,   5, C+39,  0.50F,  0, 30, 15, 20,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.coffee"								, "Coffee"									, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.THERMOS)										, "Just the regular morning Coffee"									,  4, 0.4F  ,   5, C+39,  0.50F,  0, 30, 15,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.cafeaulait"							, "Cafe au lait"							, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.THERMOS)										, "Sweet Coffee"													,  4, 0.4F  ,   5, C+39,  0.50F,  0, 30, 15, 20,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.laitaucafe"							, "Lait au cafe"							, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD, FluidsGT.THERMOS)										, "You want Coffee to your Sugar?"									,  4, 0.4F  ,   5, C+39,  0.50F,  0, 30, 15, 40,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("potion.darkchocolatemilk"					, "Bitter Chocolate Milk"					, null					, 1, 1000, 300, FluidsGT.SIMPLE, FluidsGT.FOOD)															, "A bit bitter, better add a bit Sugar"							,  4, 0.4F  ,  10, C+37,  0.50F,  0,  0,  0, 30,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("chocolatemilk"								, "Chocolate Milk"							, null					, 1, 1000, 300)																							, "Sweet Goodness"													,  4, 0.4F  ,  10, C+37,  0.50F,  0,  0,  0, 40,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("tea"										, "Tea"										, null					, 1, 1000, 300)																							, "Keep calm and carry on"											,  2, 0.2F  ,  20, C+39,  0.50F,  0, 30,  0,  0,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("sweettea"									, "Sweet Tea"								, null					, 1, 1000, 300)																							, "How about a Tea Party? In Boston?"								,  2, 0.2F  ,  20, C+39,  0.50F,  0, 30,  0, 30,  0, EnumAction.drink, F, F, F);
		new FoodStatDrink(UT.Fluids.create("icetea"										, "Ice Tea"									, null					, 1, 1000, 255)																							, "Ice 'T'"															,  6, 0.4F  ,  30, C+35,  0.50F,  0, 10,  0, 30,  0, EnumAction.drink, F, F, F);
		
		
		new FoodStatDrink(UT.Fluids.create("medicine.heal"								, "Medicine"								, null					, 1, 1000, 300)																							, "Heals up to 20 Hearts"											,  0, 0.0F  ,   0, C+37,  0.00F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F, Potion.regeneration				.id, 120, 4, 100);
		new FoodStatDrink(UT.Fluids.create("medicine.laxative"							, "Laxative"								, null					, 1, 1000, 300)																							, "Removes 10 Hunger/Saturation"									,  0, 0.0F  ,   0, C+37,  0.00F,  0,  0,  0,  0,  0, EnumAction.drink, T, F, F, Potion.hunger					.id, 300,10, 100);
		
		
		DYE_FLUIDS[4].add(UT.Fluids.make("blueberryjuice", 250));
		
		for (OreDictMaterial tMaterial : MT.ALL_MATERIALS_REGISTERED_HERE) {
			if (tMaterial.mLiquid == null) {
				if (tMaterial.contains(TD.ItemGenerator.LIQUID)) UT.Fluids.createLiquid(tMaterial); else if (tMaterial.contains(TD.ItemGenerator.MOLTEN)) UT.Fluids.createMolten(tMaterial);
			}
			if (tMaterial.mGas == null) {
				if (tMaterial.contains(TD.ItemGenerator.GASSES)) UT.Fluids.createGas(tMaterial); else if (tMaterial.contains(TD.ItemGenerator.VAPORS)) UT.Fluids.createVapour(tMaterial);
			}
			if (tMaterial.mPlasma == null) {
				if (tMaterial.contains(TD.ItemGenerator.PLASMA)) UT.Fluids.createPlasma(tMaterial);
			}
		}
		
		FL.Air.fluid().setDensity(0);
		
		if (IL.Cell_Air.exists()) {
			FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.Air.make(1000), IL.Cell_Air.get(1), IL.Cell_Empty.get(1), T));
			UT.Fluids.setFluidContainerData(new FluidContainerData(FL.Air			.make(1000), IL.Cell_Air.get(1), IL.Cell_Empty.get(1), F), F, F);
			UT.Fluids.setFluidContainerData(new FluidContainerData(FL.Air_Nether	.make(1000), IL.Cell_Air.get(1), IL.Cell_Empty.get(1), F), F, F);
			UT.Fluids.setFluidContainerData(new FluidContainerData(FL.Air_End		.make(1000), IL.Cell_Air.get(1), IL.Cell_Empty.get(1), F), F, F);
		}
		
		if (IL.FR_Ambrosia				.exists()) FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.Ambrosia			.make(1000), IL.FR_Ambrosia				.get(1), IL.FR_WaxCapsule.get(1), T));
		if (IL.GrC_Honey_Jar			.exists()) FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.Honey			.make(1000), IL.GrC_Honey_Jar			.get(1), ST.make(Items.flower_pot, 1, 0)));
		if (IL.BoP_Jar_Honey			.exists()) FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.Honey			.make( 500), IL.BoP_Jar_Honey			.get(1), IL.BoP_Jar_Empty.get(1, IL.Bottle_Empty.get(1))));
		if (IL.BoP_Jar_Poison			.exists()) FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.Potion_Poison_2	.make( 500), IL.BoP_Jar_Poison			.get(1), IL.BoP_Jar_Empty.get(1, IL.Bottle_Empty.get(1))));
		if (IL.TF_Vial_FieryTears		.exists()) FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.FieryTears		.make(   L), IL.TF_Vial_FieryTears		.get(1), IL.Bottle_Empty.get(1)));
		if (IL.TF_Vial_FieryBlood		.exists()) FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.FieryBlood		.make(   L), IL.TF_Vial_FieryBlood		.get(1), IL.Bottle_Empty.get(1)));
		if (IL.BOTA_Ender_Air_Bottle	.exists()) FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FL.Air_End			.make(1000), IL.BOTA_Ender_Air_Bottle	.get(1), IL.Bottle_Empty.get(1)));
		
		/*
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison"		, 125), IL.Arrow_Head_Glass_Poison				.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison.long"	, 125), IL.Arrow_Head_Glass_Poison_Long			.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison.strong"	, 125), IL.Arrow_Head_Glass_Poison_Strong		.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.slowness"		, 125), IL.Arrow_Head_Glass_Slowness			.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.slowness.long"	, 125), IL.Arrow_Head_Glass_Slowness_Long		.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.weakness"		, 125), IL.Arrow_Head_Glass_Weakness			.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.weakness.long"	, 125), IL.Arrow_Head_Glass_Weakness_Long		.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("holywater"			, 125), IL.Arrow_Head_Glass_Holy_Water			.get(1), IL.Arrow_Head_Glass_Emtpy.get(1)));
		
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison"		, 125), IL.Arrow_Wooden_Glass_Poison			.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison.long"	, 125), IL.Arrow_Wooden_Glass_Poison_Long		.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison.strong"	, 125), IL.Arrow_Wooden_Glass_Poison_Strong		.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.slowness"		, 125), IL.Arrow_Wooden_Glass_Slowness			.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.slowness.long"	, 125), IL.Arrow_Wooden_Glass_Slowness_Long		.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.weakness"		, 125), IL.Arrow_Wooden_Glass_Weakness			.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.weakness.long"	, 125), IL.Arrow_Wooden_Glass_Weakness_Long		.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("holywater"			, 125), IL.Arrow_Wooden_Glass_Holy_Water		.get(1), IL.Arrow_Wooden_Glass_Emtpy.get(1)));
		
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison"		, 125), IL.Arrow_Plastic_Glass_Poison			.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison.long"	, 125), IL.Arrow_Plastic_Glass_Poison_Long		.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.poison.strong"	, 125), IL.Arrow_Plastic_Glass_Poison_Strong	.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.slowness"		, 125), IL.Arrow_Plastic_Glass_Slowness			.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.slowness.long"	, 125), IL.Arrow_Plastic_Glass_Slowness_Long	.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.weakness"		, 125), IL.Arrow_Plastic_Glass_Weakness			.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("potion.weakness.long"	, 125), IL.Arrow_Plastic_Glass_Weakness_Long	.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("holywater"			, 125), IL.Arrow_Plastic_Glass_Holy_Water		.get(1), IL.Arrow_Plastic_Glass_Emtpy.get(1)));
		*/
	}
}
