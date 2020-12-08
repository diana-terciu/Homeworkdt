package com.diana.tema6.command;

public sealed interface Command permits LightCommandOn , LightCommandOff, VolumeCommandUp{

	void run();
}
