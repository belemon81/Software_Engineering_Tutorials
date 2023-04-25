package Tut9.bridge.remotes;

import Tut9.bridge.devices.Device;

public class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote() {
    }

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    //TODO: Implement the volumeDown() method
    @Override
    public void volumeDown() {
        //Display the current status is 'volume down'
        System.out.println("Current status: volume down");
        //Decrease the current volume for 10
        int volume = device.getVolume() - 10 >= 0 ? device.getVolume() - 10 : 0;
        device.setVolume(volume);

    }

    //TODO: Implement the volumeUp() method
    @Override
    public void volumeUp() {
        //Display the current status is 'volume up'
        System.out.println("Current status: volume up");
        //Increase the current volume for 10
        int volume = device.getVolume() + 10 <= 100 ? device.getVolume() + 10 : 100;
        device.setVolume(volume);
    }

    //TODO: Implement the channelDown() method
    @Override
    public void channelDown() {
        //Display the current status is 'channel down'
        System.out.println("Current status: channel down");
        //Decrease the current channel for 1
        device.setChannel(device.getChannel() - 1);

    }

    //TODO: Implement the channelUp() method
    @Override
    public void channelUp() {
        //Display the current status is 'channel up'
        System.out.println("Current status: channel up");
        //Increase the current channel for 1
        device.setChannel(device.getChannel() + 1);

    }
}
