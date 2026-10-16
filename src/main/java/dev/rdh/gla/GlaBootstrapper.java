package dev.rdh.gla;

import net.neoforged.neoforgespi.earlywindow.GraphicsBootstrapper;

public class GlaBootstrapper implements GraphicsBootstrapper {
	@Override
	public String name() {
		return "gla";
	}

	@Override
	public void bootstrap(String[] arguments) {
		GlaLoader.load();
	}
}
