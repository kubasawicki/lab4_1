package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.Test;

public class BetterRadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock);
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
    
}