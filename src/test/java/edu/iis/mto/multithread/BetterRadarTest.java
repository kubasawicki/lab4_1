package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import java.util.concurrent.Executor;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {
	
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Repeat(times = 1000)
    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, new Executor() {
        	
	        @Override
	        public void execute(Runnable arg0) {
	            arg0.run();
	        }
    	});
        
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
}