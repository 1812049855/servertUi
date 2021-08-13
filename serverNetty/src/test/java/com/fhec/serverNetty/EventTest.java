package com.fhec.serverNetty;

import org.junit.Test;

import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.eqp.TeradyneEquipment;

public class EventTest {
	@Test
	public   void a() {
		TeradyneEvent en = new TeradyneEvent();
		TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		teradyneInstantia.Event(en);
		teradyneInstantia.SelectDriver("DeltaEclipse");
		teradyneInstantia.EnableSite(0);
//		teradyneInstantia.DisableSite(0);
		teradyneInstantia.EnableSite(1);
		teradyneInstantia.EnableSite(2);
		teradyneInstantia.EnableSite(3);
		teradyneInstantia.EnableSite(4);
		teradyneInstantia.EnableSite(5);
		teradyneInstantia.EnableSite(6);
//		teradyneInstantia.SetSimVisible(true);
//		teradyneInstantia.Connection();
//		teradyneInstantia.StartPolling();
		TeradyneEvent.MaxSite = 6;
		teradyneInstantia.StartTest();
	}
}
