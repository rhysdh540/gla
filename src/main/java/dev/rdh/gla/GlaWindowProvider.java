package dev.rdh.gla;

import net.minecraftforge.fml.loading.ImmediateWindowProvider;

// Forge 1.20.x looks for its early window provider in the service layer first, so this is made before the window
public class GlaWindowProvider implements ImmediateWindowProvider {
	public GlaWindowProvider() {
		GlaLoader.load();
	}

	@Override
	public String name() {
		return "gla";
	}
}
