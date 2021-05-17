package mezz.nopotionshift;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;

@Mod("nopotionshift")
public class NoPotionShift {
	public NoPotionShift() {
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> this::registerClientEvent);
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
	}

	public void registerClientEvent() {
		MinecraftForge.EVENT_BUS.addListener(
				EventPriority.NORMAL,
				false,
				GuiScreenEvent.PotionShiftEvent.class,
				e -> e.setCanceled(true)
		);
	}
}