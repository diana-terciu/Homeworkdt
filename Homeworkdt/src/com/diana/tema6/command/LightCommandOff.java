package com.diana.tema6.command;

public final class LightCommandOff implements Command {
	Light light;

	public LightCommandOff(Light light) {
		this.light = light;
	}

	public void run() {
		light.off();
	}

}
