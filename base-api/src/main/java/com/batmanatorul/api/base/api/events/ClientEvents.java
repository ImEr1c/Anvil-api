package com.batmanatorul.api.base.api.events;

import com.batmanatorul.api.base.impl.EventKey;
import com.batmanatorul.api.base.impl.Events;
import net.minecraft.client.MinecraftClient;

public interface ClientEvents {

    EventKey<StartTick> START_TICK = Events.create(StartTick.class, startTicks -> client -> {
        for (StartTick startTick : startTicks) {
            startTick.tick(client);
        }
    });

    EventKey<EndTick> END_TICK = Events.create(EndTick.class, endTicks -> client -> {
        for (EndTick endTick : endTicks) {
            endTick.tick(client);
        }
    });

    interface StartTick {
        void tick(MinecraftClient client);
    }

    interface EndTick {
        void tick(MinecraftClient client);
    }

}
