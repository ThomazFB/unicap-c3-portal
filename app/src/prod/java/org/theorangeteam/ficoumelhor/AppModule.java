package org.theorangeteam.portalc3;

import com.firebase.client.Firebase;

import org.greenrobot.eventbus.EventBus;
import org.theorangeteam.portalc3.api.firebase.Path;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule
{
    @Singleton
    @Provides
    public EventBus provideEventBus()
    {
        return EventBus.getDefault();
    }


    @Singleton
    @Provides
    public Firebase provideFirebase()
    {
        return new Firebase(Path.MAIN);
    }
}
