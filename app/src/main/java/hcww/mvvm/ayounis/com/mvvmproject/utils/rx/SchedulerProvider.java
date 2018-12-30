package hcww.mvvm.ayounis.com.mvvmproject.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Ahmed Younis on 12/30/2018.
 */
public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();

}
