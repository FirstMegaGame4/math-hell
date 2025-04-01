package fr.firstmegagame4.mh;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathHell implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("math-hell");

	@Override
	public void onInitialize() {
		MathHell.LOGGER.info("Wdym there's a moving factor?");
	}
}
