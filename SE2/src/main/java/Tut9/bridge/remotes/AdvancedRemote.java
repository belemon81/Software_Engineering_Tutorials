package Tut9.bridge.remotes;

import Tut9.bridge.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    //TODO: Implement the mute() method
    public void mute() {
        //Display the current volume status is 'mute'
        System.out.println("Current volume status: mute");
        //Set the volume to 0
        device.setVolume(0);

    }
}
