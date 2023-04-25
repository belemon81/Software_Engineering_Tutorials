package Tut9.bridge;

import Tut9.bridge.devices.Device;
import Tut9.bridge.devices.Radio;
import Tut9.bridge.devices.Tv;
import Tut9.bridge.remotes.AdvancedRemote;
import Tut9.bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    //TODO: Implement the method testDevice()
    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        //Create the new BasicRemote instance
        BasicRemote basicRemote = new BasicRemote(device);
        //Power on the device
        basicRemote.power();
        //Display the status of device
        basicRemote.channelDown(); //0
        basicRemote.volumeUp(); //40
        device.printStatus();
        basicRemote.power();
        device.printStatus();
        System.out.println("-----------------------------------");

        System.out.println("Tests with advanced remote.");
        //Create the new AdvancedRemote instance
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        //Power on the device
        advancedRemote.power();
        //Mute the device
        advancedRemote.mute();
        //Display the status of device
        device.printStatus();
        System.out.println("-----------------------------------");

    }
}
