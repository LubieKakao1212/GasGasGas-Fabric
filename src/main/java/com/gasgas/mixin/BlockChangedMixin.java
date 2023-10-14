package com.gasgas.mixin;

import com.gasgas.GasGas;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public abstract class BlockChangedMixin {

	@Inject(at = @At("RETURN"), method = "onBlockChanged")
	private void sendBlockChanged(BlockPos pos, BlockState oldBlock, BlockState newBlock, CallbackInfo info) {
		World world = (World) (Object) this;
		GasGas.LOGGER.info("Block Broken at: " + pos + ", " + world.isClient);
	}
}