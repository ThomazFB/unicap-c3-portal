package org.theorangeteam.portalc3;

import org.greenrobot.eventbus.EventBus;
import org.theorangeteam.portalc3.api.API;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule
{
    private final boolean mockMode;

    public AppModule(boolean injectMock)
    {
        mockMode = injectMock;
    }

    @Singleton
    @Provides
    public EventBus provideEventBus()
    {
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    public API provideAPI()
    {
        return new API();
    }

}
