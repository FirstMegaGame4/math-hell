package fr.firstmegagame4.mh.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MatrixStack.class)
public class MatrixStackMixin {

	@WrapMethod(method = "translate(FFF)V")
	private void wrapTranslation(float x, float y, float z, Operation<Void> original) {
		float factor = this.getFactor();
		original.call(factor * x, factor * y, factor * z);
	}

	@WrapMethod(method = "scale")
	private void wrapScaling(float x, float y, float z, Operation<Void> original) {
		float factor = this.getFactor();
		original.call(factor * x, factor * y, factor * z);
	}

	@WrapMethod(method = "multiply(Lorg/joml/Quaternionfc;FFF)V")
	private void wrapMultiplication(Quaternionfc quaternion, float originX, float originY, float originZ, Operation<Void> original) {
		float factor = this.getFactor();
		original.call(quaternion, factor * originX, factor * originY, factor * originZ);
	}

	@Unique
	private float getFactor() {
		return (((int) System.currentTimeMillis()) % 10000) / 10000.0f + 1.5f;
	}
}
