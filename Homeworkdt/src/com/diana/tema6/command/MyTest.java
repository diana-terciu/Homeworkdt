package com.diana.tema6.command;

public class MyTest {
	public static void main(String[] args) {
		Light light = new Light();
		var commandExecutor = new CommandExecutor();
		commandExecutor.executeCommand(new LightCommandOn(light));

	}

	/*
	 * public void commandDevice(String operation) { if
	 * (operation.equals("turnOffLights")) {
	 * System.out.println("The lights are off"); } else if
	 * (operation.equals("turnOnLights")) { System.out.println("The lights are on");
	 * } else if (operation.equals("turnVolumeUp")) {
	 * System.out.println("The volume has been turned up"); } }
	 */
}
