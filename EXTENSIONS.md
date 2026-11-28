Extensions that gla exposes on top of 4.6, excluding those that Apple already has:

## Shaders

- `GL_ARB_compute_variable_group_size`
- `GL_ARB_gpu_shader_int64`
- `GL_NV_compute_shader_derivatives` (GLSL's `GL_KHR_compute_shader_derivatives` too, in task and mesh shaders)
- `GL_AMD_gpu_shader_int16`
- `GL_AMD_gpu_shader_half_float`
- `GL_AMD_shader_trinary_minmax`
- `GL_INTEL_shader_integer_functions2`
- `GL_KHR_shader_subgroup` (vertex and geometry shaders have one-lane subgroups; not in tessellation or mesh shaders)
- `GL_ARB_shader_ballot`
- `GL_ARB_fragment_shader_interlock`
- `GL_ARB_post_depth_coverage`
- `GL_ARB_shader_stencil_export`
- `GL_ARB_shader_viewport_layer_array`
- `GL_NV_fragment_shader_barycentric`, `GL_EXT_fragment_shader_barycentric` (no `pervertexEXT` inputs; no `interpolateAt*` on the barycentrics; pixel centers only with sample shading)
- `GL_EXT_texture_shadow_lod`
- `GL_EXT_shader_image_load_formatted`
- `GL_EXT_shader_image_load_store` (no multisample images)
- `GL_EXT_shader_framebuffer_fetch`, `GL_EXT_shader_framebuffer_fetch_non_coherent` (`gl_LastFragData` with constant indices only)
- `GL_NV_gpu_shader5`\*

## Atomics

- `GL_NV_shader_atomic_float`
- `GL_INTEL_shader_atomic_float_minmax`

## Mesh shaders

- `GL_NV_mesh_shader`, `GL_EXT_mesh_shader`\* (up to 4 views, each mesh draw made once a view)
- `GL_NV_representative_fragment_test`\*

## Memory and draws

- `GL_NV_shader_buffer_load`, `GL_NV_shader_buffer_store`\* (64-bit atomics are unsigned `atomicMin` and `atomicMax` whose result goes unused)
- `GL_NV_vertex_buffer_unified_memory`\* (addresses only reach the first 4 GB of a buffer)
- `GL_NV_uniform_buffer_unified_memory`\* (addresses only reach the first 4 GB of a buffer)
- `GL_NV_bindless_multi_draw_indirect`\* (addresses only reach the first 4 GB of a buffer)
- `GL_NV_vertex_attrib_integer_64bit`
- `GL_ARB_sparse_buffer`†
- `GL_ARB_sparse_texture`, `GL_ARB_sparse_texture2`, `GL_ARB_sparse_texture_clamp`† (no stencil-only format; no image access to multisample sparse textures)
- `GL_NVX_gpu_memory_info`

## Framebuffers

- `GL_ARB_sample_locations`, `GL_NV_sample_locations` (the pixel grid is 1x1)
- `GL_OVR_multiview`, `GL_OVR_multiview2` (no views for a vertex stage that writes `gl_CullDistance`)

## Textures

- `GL_ARB_bindless_texture` (a gather of alpha through a handle with a (1, 1, 1, 0) border reads 1)
- `GL_ARB_seamless_cubemap_per_texture`, `GL_AMD_seamless_cubemap_per_texture` (a cube that is not seamless and wraps by REPEAT, MIRRORED_REPEAT or CLAMP_TO_BORDER clamps at each face's edge)
- `GL_KHR_texture_compression_astc_ldr`, `GL_KHR_texture_compression_astc_hdr`, `GL_KHR_texture_compression_astc_sliced_3d` (sRGB decoding of 3D textures can't be skipped)

## Blending

- `GL_KHR_blend_equation_advanced`, `GL_KHR_blend_equation_advanced_coherent`

## Other

- `GL_ARB_ES3_2_compatibility`
- `GL_ARB_parallel_shader_compile`, `GL_KHR_parallel_shader_compile`
- `GL_ARB_debug_output`, `GL_EXT_polygon_offset_clamp`, `GL_EXT_shader_integer_mix`

\* M3 or later, on macOS 26.4 or later.<br>
† macOS 26.4 or later.
