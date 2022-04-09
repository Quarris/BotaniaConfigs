package dev.quarris.botaniaconfigs.mixin;

import dev.quarris.botaniaconfigs.ModConfigs;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.api.subtile.TileEntityFunctionalFlower;
import vazkii.botania.common.block.subtile.functional.SubTileOrechid;

@Mixin(value = SubTileOrechid.class, remap = false)
public class SubTileOrechidMixin extends TileEntityFunctionalFlower {

    public SubTileOrechidMixin(TileEntityType<?> type) {
        super(type);
    }

    @Inject(method = "getDelay", at = @At(value = "HEAD"), cancellable = true)
    public void getConfigDelay(CallbackInfoReturnable<Integer> cir) {
        int delay = ModConfigs.orechidDelay.get();
        if (delay > 0) {
            cir.setReturnValue(delay);
        }
    }

    @Inject(method = "getCost", at = @At(value = "HEAD"), cancellable = true)
    public void getConfigCost(CallbackInfoReturnable<Integer> cir) {
        int cost = ModConfigs.orechidCost.get();
        if (cost >= 0) {
            cir.setReturnValue(cost);
        }
    }
}
