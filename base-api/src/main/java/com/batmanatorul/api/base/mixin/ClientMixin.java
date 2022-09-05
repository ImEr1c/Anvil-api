package com.batmanatorul.api.base.mixin;

import com.batmanatorul.api.base.api.events.ClientEvents;
import com.batmanatorul.api.base.impl.Events;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    public void startTick(CallbackInfo ci) {
        Events.getInvoker(ClientEvents.START_TICK).tick((MinecraftClient) (Object) this);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void endTick(CallbackInfo ci) {
        Events.getInvoker(ClientEvents.END_TICK).tick((MinecraftClient) (Object) this);
    }
}
