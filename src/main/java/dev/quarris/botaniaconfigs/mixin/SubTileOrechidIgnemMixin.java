package dev.quarris.botaniaconfigs.mixin;

import dev.quarris.botaniaconfigs.ModConfigs;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.block.subtile.functional.SubTileOrechid;
import vazkii.botania.common.block.subtile.functional.SubTileOrechidIgnem;

@Mixin(value = SubTileOrechidIgnem.class, remap = false)
public class SubTileOrechidIgnemMixin extends SubTileOrechid {

    public SubTileOrechidIgnemMixin(TileEntityType<?> type) {
        super(type);
    }

    @Override
    public int getDelay() {
        int delay = ModConfigs.orechidIgnemDelay.get();
        if (delay > 0) {
            return delay;
        }
        return super.getDelay();
    }

    @Inject(method = "getCost", at = @At(value = "HEAD"), cancellable = true)
    public void getConfigCost(CallbackInfoReturnable<Integer> cir) {
        int cost = ModConfigs.orechidIgnemCost.get();
        if (cost >= 0) {
            cir.setReturnValue(cost);
        }
    }
}
