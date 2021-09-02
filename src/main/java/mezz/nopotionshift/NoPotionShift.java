package mezz.nopotionshift;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod("nopotionshift")
public class NoPotionShift {
	public NoPotionShift() {
		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> PotionShiftHandler::registerClientEvent);
		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "ANY", (remote, side) -> side));
	}
}

class PotionShiftHandler {
	public static void registerClientEvent() {
		MinecraftForge.EVENT_BUS.addListener(
				EventPriority.NORMAL,
				false,
				GuiScreenEvent.PotionShiftEvent.class,
				e -> e.setCanceled(true)
		);
	}
}