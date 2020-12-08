package com.diana.tema6.command;

public final class VolumeCommandUp implements Command {
	Volume volume;

	public VolumeCommandUp(Volume Volume) {
		this.volume = Volume;
	}

	public void run() {
		volume.up();
	}

}
