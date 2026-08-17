package retino.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "com.mojang.blaze3d.platform.Window")
public abstract class GlBackendMixin {
	@ModifyConstant(
		method = "createWindow",
		constant = @Constant(longValue = 8192L)
	)
	private long disableHighPixelDensity(long constant) {
		return 0L;
	}
}