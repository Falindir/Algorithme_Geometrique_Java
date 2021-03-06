package tp.tp2;

import tp.tools.visualisation.FrameGeometric;

public class MainTp2 {

	public static void main(String[] args) {
		FrameGeometric frame = new FrameGeometric ("TP2 - Géométrie algorithmique");
		
		int width = 612;
		int height = 792;

		ControllerTP2 controllerTP2 = new ControllerTP2();
		
		ViewEnveloppeConvexe vRP1 = new ViewEnveloppeConvexe(width, height, controllerTP2);
		controllerTP2.addView(vRP1);
		vRP1.drawListRandomPoint(50);
		vRP1.drawEnvConvJarvis();
		frame.addView(vRP1, "Jarvis");

		ViewEnveloppeConvexe vRP2 = new ViewEnveloppeConvexe(width, height, controllerTP2);
		controllerTP2.addView(vRP2);
		vRP2.drawListRandomPoint(50);
		vRP2.drawEnvConvGraham();
		frame.addView(vRP2, "Graham");

		ViewEnveloppeConvexe vRP3 = new ViewEnveloppeConvexe(width, height, controllerTP2);
		controllerTP2.addView(vRP3);
		vRP3.drawListRandomPoint(50);
		vRP3.drawEnvConvOnionSkin();
		frame.addView(vRP3, "Onion");

		frame.setFrame();
	}

}
