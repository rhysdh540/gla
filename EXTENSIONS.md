Extensions that gla exposes on top of 4.6, excluding those that Apple already has:

## Shaders

- `GL_ARB_gpu_shader_int64`
- `GL_AMD_gpu_shader_int16`
- `GL_AMD_gpu_shader_half_float`
- `GL_AMD_shader_trinary_minmax`
- `GL_INTEL_shader_integer_functions2`
- `GL_KHR_shader_subgroup` (no doubles; vertex and geometry shaders have one-lane subgroups; not in tessellation or mesh shaders)
- `GL_ARB_shader_ballot`
- `GL_ARB_fragment_shader_interlock`
- `GL_ARB_post_depth_coverage`
- `GL_ARB_shader_stencil_export`
- `GL_ARB_shader_viewport_layer_array`
- `GL_NV_fragment_shader_barycentric`, `GL_EXT_fragment_shader_barycentric` (no `pervertexEXT` inputs; no `interpolateAt*` on the barycentrics; pixel centers only with sample shading)
- `GL_EXT_texture_shadow_lod`
- `GL_EXT_shader_image_load_formatted`
- `GL_EXT_shader_image_load_store` (no `imageAtomic[Inc/Dec]Wrap` and no multisample images)
- `GL_EXT_shader_framebuffer_fetch`, `GL_EXT_shader_framebuffer_fetch_non_coherent` (no `gl_LastFragData`)
- `GL_NV_gpu_shader5`\* (no patches from a tessellation control shader into a geometry shader)

## Atomics

- `GL_NV_shader_atomic_float`
- `GL_INTEL_shader_atomic_float_minmax`

## Mesh shaders

- `GL_NV_mesh_shader`, `GL_EXT_mesh_shader`\* (no multiview, SPIR-V, or invocation or primitive queries)
- `GL_NV_representative_fragment_test`\*

## Memory and draws

- `GL_NV_shader_buffer_load`, `GL_NV_shader_buffer_store`\* (no 64-bit `atomicAdd`, `atomicExchange`, `atomicCompSwap` or `atomic[Inc/Dec]Wrap`)
- `GL_NV_vertex_buffer_unified_memory`\* (no fixed-function formats such as `glVertexFormatNV`; addresses only reach the first 4 GB of a buffer)
- `GL_NV_uniform_buffer_unified_memory`\* (addresses only reach the first 4 GB of a buffer)
- `GL_NV_bindless_multi_draw_indirect`\* (addresses only reach the first 4 GB of a buffer)
- `GL_NV_vertex_attrib_integer_64bit`
- `GL_ARB_sparse_buffer`†
- `GL_ARB_sparse_texture`, `GL_ARB_sparse_texture2`, `GL_ARB_sparse_texture_clamp`† (no depth formats; views of sparse textures aren't sparse; image atomics on uncommitted texels still write)
- `GL_NVX_gpu_memory_info`

## Blending

- `GL_KHR_blend_equation_advanced`, `GL_KHR_blend_equation_advanced_coherent`

## Other

- `GL_ARB_ES3_2_compatibility`
- `GL_ARB_parallel_shader_compile`, `GL_KHR_parallel_shader_compile`
- `GL_ARB_debug_output`, `GL_EXT_polygon_offset_clamp`, `GL_EXT_shader_integer_mix`

\* M3 or later, on macOS 26.4 or later.<br>
† macOS 26.4 or later.
