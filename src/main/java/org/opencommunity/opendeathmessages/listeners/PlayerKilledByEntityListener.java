package org.opencommunity.opendeathmessages.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.opencommunity.opendeathmessages.CustomDeathMessages;

import java.util.List;
import java.util.Random;

public class PlayerKilledByEntityListener implements Listener {

    public CustomDeathMessages plugin;

    public PlayerKilledByEntityListener(CustomDeathMessages plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeathByMob(EntityDamageByEntityEvent event) {
        if (plugin.getConfig().getBoolean("enable-global-messages")) {
            if (event.getEntity() instanceof Player && !(event.getDamager() instanceof Player)) {
                Player victim = (Player) event.getEntity();

                if (victim.getHealth() <= event.getFinalDamage()) {

                    EntityType entity = event.getDamager().getType();
                    String path = "unknown-messages";

                    boolean hasCustomName = event.getDamager().getCustomName() != null;

                    if (entity == EntityType.SLIME) {
                        path = "slime-messages";
                    } else if (entity == EntityType.SKELETON) { 
                        path = "skeleton-messages";
                    } else if (entity == EntityType.MAGMA_CUBE) { 
                        path = "magmacube-messages";
                    } else if (entity == EntityType.SPIDER) { 
                        path = "spider-messages";
                    } else if (entity == EntityType.CAVE_SPIDER) { 
                        path = "cavespider-messages";
                    } else if (entity == EntityType.WITHER) { 
                        path = "witherboss-messages";
                    } else if (entity == EntityType.ENDER_DRAGON) { 
                        path = "dragon-messages";
                    } else if (entity == EntityType.PRIMED_TNT) { 
                        path = "tnt-messages";
                    } else if (entity == EntityType.CREEPER) { 
                        path = "creeper-messages";
                    } else if (entity == EntityType.GHAST) { 
                        path = "ghast-messages";
                    } else if (entity == EntityType.ENDERMAN) { 
                        path = "enderman-messages";
                    } else if (entity == EntityType.SILVERFISH) { 
                        path = "silverfish-messages";
                    } else if (entity == EntityType.WITCH) { 
                        path = "witch-messages";
                    } else if (entity == EntityType.GUARDIAN) { 
                        path = "guardian-messages";
                    } else if (entity == EntityType.IRON_GOLEM) { 
                        path = "golem-messages";
                    } else if (entity == EntityType.ENDERMITE) { 
                        path = "endermite-messages";
                    } else if (entity == EntityType.ZOMBIE) { 
                        path = "zombie-messages";
                    } else if (entity == EntityType.WOLF) { 
                        path = "wolf-messages";
                    } else if (entity == EntityType.BLAZE) { 
                        path = "blaze-messages";
                    } else if (entity == EntityType.FIREWORK) { 
                        path = "firework-messages";
                    } else if (entity == EntityType.ENDER_CRYSTAL) { 
                        path = "ender_crystal-messages";
                    } else if (entity == EntityType.EVOKER_FANGS) { 
                        path = "evoker_fangs-messages";
                    } else if (entity == EntityType.FIREBALL) { 
                        path = "fireball-messages";
                    } else if (entity == EntityType.ARROW) 
                    {
                        if (((Projectile) event.getDamager()).getShooter() instanceof Skeleton) {
                        	path = "skeleton-messages";
                        } else if (((Projectile) event.getDamager()).getShooter() instanceof Stray) {
                        	path = "stray-messages";
                        } else if (((Projectile) event.getDamager()).getShooter() instanceof Pillager) {
                        	path = "pillager-messages";
                        } else {
                        path = "arrow-messages";
                        }
                    } else if (entity == EntityType.LIGHTNING) { // 1.11
                        path = "lightning-messages";
                    } else if (entity.toString().equals("PIG_ZOMBIE")) { // 1.15 and below (must use entity name due to unknown field)
                        path = "pigman-messages";
                    } else if (entity == EntityType.SHULKER) { // 1.9
                        path = "shulker-messages";
                    } else if (entity == EntityType.STRAY) { // 1.10
                        path = "stray-messages";
                    } else if (entity == EntityType.LLAMA) { // 1.11
                        path = "llama-messages";
                    } else if (entity == EntityType.DRAGON_FIREBALL) { // id changed in 1.11
                        path = "dragon-messages";
                    } else if (entity == EntityType.LLAMA_SPIT) { // 1.11
                        path = "llama-messages";
                    } else if (entity == EntityType.WITHER_SKELETON) { // differation of wither skeletons and skeletons added 1.11
                        path = "witherskeleton-messages";
                    } else if (entity == EntityType.ELDER_GUARDIAN) { // differation of elder guardians and guardians added 1.11
                        path = "elderguardian-messages";
                    } else if (entity == EntityType.ZOMBIE_VILLAGER) { // differation of zombies and zombie villagers added 1.11
                        path = "zombievillager-messages";
                    } else if (entity == EntityType.EVOKER) { // 1.11
                        path = "evoker-messages";
                    } else if (entity == EntityType.VEX) { // 1.11
                        path = "vex-messages";
                    } else if (entity == EntityType.VINDICATOR) { // 1.11
                        path = "vindicator-messages";
                    } else if (entity == EntityType.HUSK) { // 1.11
                        path = "husk-messages";
                    } else if (entity == EntityType.ILLUSIONER) { // 1.12
                        path = "illusioner-messages";
                    } else if (entity == EntityType.PHANTOM) { // 1.13
                        path = "phantom-messages";
                    } else if (entity == EntityType.DROWNED) { // 1.13
                        path = "drowned-messages";
                    } else if (entity == EntityType.PUFFERFISH) { // 1.13
                        path = "pufferfish-messages";
                    } else if (entity == EntityType.POLAR_BEAR) { // 1.13
                        path = "polar-bear-messages";
                    } else if (entity == EntityType.DOLPHIN) { // 1.13
                        path = "dolphin-messages";
                    } else if (entity == EntityType.PILLAGER) { // 1.14
                        path = "pillager-messages";
                    } else if (entity == EntityType.RAVAGER) { // 1.14
                        path = "ravager-messages";
                    } else if (entity == EntityType.TRADER_LLAMA) { // 1.14
                        path = "llama-messages";
                    } else if (entity == EntityType.PANDA) { // 1.14
                        path = "panda-messages";
                    } else if (entity == EntityType.BEE) { // 1.15
                        path = "bee-messages";
                    } else if (entity == EntityType.PIGLIN) { // 1.16
                        path = "piglin-messages";
                    } else if (entity == EntityType.ZOGLIN) { // 1.16
                        path = "zoglin-messages";
                    } else if (entity == EntityType.HOGLIN) { // 1.16
                        path = "hoglin-messages";
                    } else if (entity == EntityType.ZOMBIFIED_PIGLIN) { // 1.16
                        path = "zombified-piglin-messages";
                    }

                    if (hasCustomName && plugin.getConfig().getBoolean("enable-custom-name-entity-messages")) {
                        path = "custom-name-entity-messages";
                    }

                    Random rand = new Random();
                    List<String> msgs = plugin.getConfig().getStringList(path);
                    String message = msgs.get(rand.nextInt(msgs.size()))
                            .replace("%victim%", victim.getName())
                            .replace("%victim-nick%", victim.getDisplayName())
                            .replace("%victim-x%", victim.getName())
                            .replace("%victim-y%", victim.getName())
                            .replace("%victim-z%", victim.getName());

                    if (path.equals("custom-name-entity-messages")) {
                        message = message.replace("%entity-name%", event.getDamager().getName());
                    }

                    plugin.deathMessage.clear();
                    plugin.deathMessage.put(victim.getName(), message);

                    if (plugin.getConfig().getBoolean("developer-mode")) {
                        Bukkit.broadcastMessage(plugin.deathMessage.get(victim.getName()));
                        Bukkit.broadcastMessage(entity.toString());
                    }
                }
            }
        }
    }
}
