package net.mcreator.testing.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.testing.init.TestingModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AxeDamageProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double damage = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + (amount * ((LivingEntity) sourceentity).getAttribute(TestingModAttributes.AXEDAMAGE.get()).getBaseValue()) / 100;
			event2.setAmount((float) damage);
		}
	}
}
