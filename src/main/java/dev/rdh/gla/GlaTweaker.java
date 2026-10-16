package dev.rdh.gla;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.util.List;

// Forge 1.12 and older; LaunchWrapper makes every tweaker of a round before it injects any, so this runs before Pylon starts SDL
public class GlaTweaker implements ITweaker {
	public GlaTweaker() {
		GlaLoader.load();
	}

	@Override
	public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {}

	@Override
	public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

	@Override
	public String getLaunchTarget() {
		return "";
	}

	@Override
	public String[] getLaunchArguments() {
		return new String[0];
	}
}
