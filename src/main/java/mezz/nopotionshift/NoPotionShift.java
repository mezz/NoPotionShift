package mezz.nopotionshift;

import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;

@Mod("nopotionshift")
public class NoPotionShift {
	public NoPotionShift() {
		MinecraftForge.EVENT_BUS.addListener(
				EventPriority.NORMAL,
				false,
				GuiScreenEvent.PotionShiftEvent.class,
				e -> e.setCanceled(true)
		);
	}
}
