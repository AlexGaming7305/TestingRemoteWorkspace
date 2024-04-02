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
public class DamageReductionProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		double damage = 0;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(TestingModAttributes.DAMAGEREDUCTION.get()) != null) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount - (amount * ((LivingEntity) entity).getAttribute(TestingModAttributes.DAMAGEREDUCTION.get()).getBaseValue()) / 100;
			event2.setAmount((float) damage);
		}
	}
}
