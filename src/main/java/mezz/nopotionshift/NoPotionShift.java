package mezz.nopotionshift;

import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("nopotionshift")
public class NoPotionShift {
	public NoPotionShift() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onPotionShiftEvent(GuiScreenEvent.PotionShiftEvent event) {
		event.setCanceled(true);
	}
}
