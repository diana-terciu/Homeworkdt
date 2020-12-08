package com.diana.tema6.command;

public final class LightCommandOn implements Command {
	Light light;

	public LightCommandOn(Light light) {
		this.light = light;
	}

	public void run() {
		light.on();
	}

}
