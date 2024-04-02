/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testing.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

import net.mcreator.testing.TestingMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestingModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, TestingMod.MODID);
	public static final RegistryObject<Attribute> ARMORPENETRATION = ATTRIBUTES.register("armor_penetration", () -> (new RangedAttribute("attribute." + TestingMod.MODID + ".armor_penetration", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> AXEDAMAGE = ATTRIBUTES.register("axe_damage", () -> (new RangedAttribute("attribute." + TestingMod.MODID + ".axe_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> DAMAGEREDUCTION = ATTRIBUTES.register("damage_reduction", () -> (new RangedAttribute("attribute." + TestingMod.MODID + ".damage_reduction", 0, 0, 0)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, ARMORPENETRATION.get());
		event.add(EntityType.PLAYER, AXEDAMAGE.get());
		event.add(EntityType.PLAYER, DAMAGEREDUCTION.get());
	}
}
