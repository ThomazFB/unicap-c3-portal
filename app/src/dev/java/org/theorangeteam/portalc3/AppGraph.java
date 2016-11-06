package org.theorangeteam.portalc3;

import org.theorangeteam.portalc3.android.activity.HomeActivity;
import org.theorangeteam.portalc3.android.activity.TeacherProfileActivity;
import org.theorangeteam.portalc3.android.fragment.DisciplinesFragment;
import org.theorangeteam.portalc3.android.fragment.EventsFragment;
import org.theorangeteam.portalc3.android.fragment.PostPaginationFragment;
import org.theorangeteam.portalc3.android.fragment.TeacherFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppGraph
{
    void inject(HomeActivity homeActivity);

    void inject(TeacherProfileActivity teacherProfileActivity);

    void inject(DisciplinesFragment disciplinesFragment);

    void inject(TeacherFragment teacherFragment);

    void inject(PostPaginationFragment postPaginationFragment);

    void inject(EventsFragment eventsFragment);

    final class Initializer
    {
        public static AppGraph init(boolean injectMock)
        {
            return DaggerAppGraph.builder()
                    .appModule(new AppModule(injectMock))
                    .build();
        }
    }
}
