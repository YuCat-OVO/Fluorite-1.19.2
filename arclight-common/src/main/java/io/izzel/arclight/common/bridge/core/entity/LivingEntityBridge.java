package io.izzel.arclight.common.bridge.core.entity;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.bukkit.craftbukkit.v.entity.CraftLivingEntity;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

import java.util.Optional;

public interface LivingEntityBridge extends EntityBridge {
    HitResult bridge$getRayTrace(int maxDistance);

    HitResult bridge$getRayTrace(int maxDistance, ClipContext.Fluid fluidCollisionOption);

    EntityHitResult bridge$getTargetEntity(int maxDistance);

    void bridge$dropExperience();

    void bridge$setSlot(EquipmentSlot slotIn, ItemStack stack, boolean silent);

    void bridge$playEquipSound(EquipmentSlot slot, ItemStack oldItem, ItemStack newItem, boolean silent);

    boolean bridge$canPickUpLoot();

    boolean bridge$isForceDrops();

    int bridge$getExpReward();

    void bridge$setExpToDrop(int amount);

    int bridge$getExpToDrop();

    void bridge$pushHealReason(EntityRegainHealthEvent.RegainReason regainReason);

    void bridge$heal(float healAmount, EntityRegainHealthEvent.RegainReason regainReason);

    void bridge$pushEffectCause(EntityPotionEffectEvent.Cause cause);

    boolean bridge$addEffect(MobEffectInstance effect, EntityPotionEffectEvent.Cause cause);

    boolean bridge$removeEffect(MobEffect effect, EntityPotionEffectEvent.Cause cause);

    boolean bridge$removeAllEffects(EntityPotionEffectEvent.Cause cause);

    Optional<EntityPotionEffectEvent.Cause> bridge$getEffectCause();

    EntityPotionEffectEvent.Action bridge$getAndResetAction();

    @Override
    CraftLivingEntity bridge$getBukkitEntity();
}
