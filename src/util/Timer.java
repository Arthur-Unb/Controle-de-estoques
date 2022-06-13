package util;

import java.util.TimerTask;

import javafx.scene.text.Text;

public class Timer {

	Timer timer = new Timer();

	public void LimparTexto(Text t) {
		int delay = 2000; // delay de 2 seg.
		int interval = 15000; // intervalo de 15 seg.

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				t.setText("");
			}
		}, delay, interval);
	}

}
