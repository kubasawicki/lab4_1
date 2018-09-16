package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BetterRadar {
    
    private PatriotBattery battery;
    private Executor executor;
    
    public BetterRadar(PatriotBattery missle, Executor executor) {
        this.battery = missle;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

	    private void launchPatriot() {
	        executor.execute(new Runnable() {
	        
	        	@Override
	        	public void run() {
	                for (int i = 0; i < 10; i++) {
	                    battery.launchPatriot();
	                }
	        	}
	        	
	        }); 
	    }
}