package dev.rdh.gla;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class GlaLoader implements PreLaunchEntrypoint {
	@Override
	public void onPreLaunch() {
		if (Platform.get() != Platform.MACOSX) {
			System.out.println("gla is only supported on macos");
			return;
		}

		try {
			InputStream is = GlaLoader.class.getClassLoader().getResourceAsStream("libgla.dylib");
			if (is == null) {
				throw new RuntimeException("no libgla.dylib found in gla jar?");
			}

			Path path = Files.createTempFile("libgla", ".dylib");
			path.toFile().deleteOnExit();
			Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);

			Configuration.OPENGL_LIBRARY_NAME.set(path.toAbsolutePath().toString());
		} catch (IOException e) {
			throw new UncheckedIOException("failed to load gla", e);
		}
	}
}
