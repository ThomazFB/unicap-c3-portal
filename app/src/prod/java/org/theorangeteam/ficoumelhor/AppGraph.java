package org.theorangeteam.portalc3;

import org.theorangeteam.portalc3.android.activity.HomeActivity;
import org.theorangeteam.portalc3.android.activity.LoginActivity;
import org.theorangeteam.portalc3.android.activity.NewsActivity;
import org.theorangeteam.portalc3.api.firebase.FirebaseTask;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppGraph
{
    void inject(LoginActivity loginActivity);

    void inject(HomeActivity homeActivity);

    void inject(NewsActivity newsActivity);

    void inject(DashboardFragment dashboardFragment);

    void inject(FirebaseTask firebaseTask);

    final class Initializer
    {
        public static AppGraph init(boolean injectMock)
        {
            return DaggerAppGraph.builder()
                    .appModule(new AppModule())
                    .build();
        }
    }
}
