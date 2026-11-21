# GLA

GLA is a client-side mod that gives Minecraft modern OpenGL on macOS. It sits on top of Apple's own OpenGL driver,
keeping what works and replacing what's missing, broken or slow. It includes a bespoke shader compiler that's faster
and more correct than Apple's.

## Features

- OpenGL 4.6: compute, geometry/tessellation shaders, SSBOs, indirect multidraw, debug output and a lot more
- Lets mods that need newer OpenGL run on macOS, including advanced Iris shader packs and mods like Voxy and Nvidium
- Loads on Fabric, Forge, NeoForge and older LaunchWrapper-based loaders

## Requirements

- a mac with Apple Silicon (an M-series chip)
- macOS 15.4+
- if you're below 1.17, a mod that makes the game use LWJGL 3 is required, like [Pylon](https://github.com/notdevcody/pylon)

## License

The dylib embedded in the jar is licensed under [All Rights Reserved](/LICENSE)

The code that loads it (source in this repository) is licensed under the [Unlicense](/LICENSE_loader) 
