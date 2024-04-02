package net.mcreator.testing.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.testing.init.TestingModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ArmorPenetrationProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double amount) {
		execute(null, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > ((LivingEntity) sourceentity).getAttribute(TestingModAttributes.ARMORPENETRATION.get()).getBaseValue()) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + ((LivingEntity) sourceentity).getAttribute(TestingModAttributes.ARMORPENETRATION.get()).getBaseValue() / 2;
			event2.setAmount((float) damage);
		} else {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 2;
			event2.setAmount((float) damage);
		}
	}
}
