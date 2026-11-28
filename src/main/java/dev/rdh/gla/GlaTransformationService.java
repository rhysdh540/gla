package dev.rdh.gla;

import cpw.mods.modlauncher.api.IEnvironment;
import cpw.mods.modlauncher.api.ITransformationService;
import org.lwjgl.opengl.GL;

import java.util.Collections;
import java.util.List;
import java.util.Set;

// Forge 1.13 to 1.19, which have no early window (and new forge if early window is skipped)
public class GlaTransformationService implements ITransformationService {
	public GlaTransformationService() {
		GlaLoader.load();
		if (GlaLoader.library != null && getClass().getClassLoader().getResource("net/minecraftforge/fml/loading/FMLLoader.class") != null) {
			try {
				GL.destroy();
				GL.create(GlaLoader.library);
			} catch (NoClassDefFoundError ignore) {
			}
		}
	}

	@Override
	public String name() {
		return "gla";
	}

	@Override
	public void initialize(IEnvironment environment) {}

	@Override
	public void beginScanning(IEnvironment environment) {}

	@Override
	public void onLoad(IEnvironment env, Set<String> otherServices) {}

	@Override
	public List transformers() {
		return Collections.emptyList();
	}
}
