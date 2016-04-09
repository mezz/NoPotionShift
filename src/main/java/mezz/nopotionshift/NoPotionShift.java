package mezz.nopotionshift;

import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
		modid = "NoPotionShift",
		version = "@VERSION@",
		acceptedMinecraftVersions = "[1.9,1.10)",
		dependencies = "required-after:Forge@[12.16.0.1859,);",
		clientSideOnly = true
)
public class NoPotionShift {
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onPotionShiftEvent(GuiScreenEvent.PotionShiftEvent event) {
		event.setCanceled(true);
	}
}
