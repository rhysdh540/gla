package dev.rdh.gla;

import org.lwjgl.system.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class GlaLoader {
	private static boolean loaded;

	public static synchronized void load() {
		if (loaded) return;
		loaded = true;

		if (!System.getProperty("os.name", "").startsWith("Mac")) {
			System.out.println("gla is only supported on macos");
			return;
		}

		if (!"aarch64".equals(System.getProperty("os.arch"))) {
			System.out.println("gla is only supported on m-series macs");
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

			String p = path.toAbsolutePath().toString();

			if (!Boolean.getBoolean("gla.noPreload")) {
				try {
					System.load(p);
				} catch (UnsatisfiedLinkError e) {
					System.out.println("gla could not be loaded: " + e.getMessage());
					return;
				}
			}

			System.setProperty("org.lwjgl.opengl.libname", p);
			try {
				Configuration.OPENGL_LIBRARY_NAME.set(p);
			} catch (NoClassDefFoundError ignore) {
			}
		} catch (IOException e) {
			throw new UncheckedIOException("failed to load gla", e);
		}
	}
}
