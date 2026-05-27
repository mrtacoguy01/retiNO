package retino.mixin;

import com.mojang.blaze3d.opengl.GlBackend;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GlBackend.class)
public abstract class GlBackendMixin {
	@Inject(
		at = @At("HEAD"),
		method = "setWindowHints"
	)
	private void adjustWindowHints(CallbackInfo callbackInfo) {
		GLFW.glfwWindowHint(GLFW.GLFW_COCOA_RETINA_FRAMEBUFFER, GLFW.GLFW_FALSE);
	}
}
