package com.example.demo.parkingLot;

public class ParkingDirector {

    private  ParkingManager parkingManager;

    public ParkingDirector(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public String printStringAllParkingLotInfo() {
        String result = "";
        result += this.parkingManager.parkingLotInfo() + "\n";
        result = printParkingLotInfo(result, this.parkingManager, " ");
        result = printParkingBoyParkingLotInfo(result, " ");
        return result;
    }

    public String printMarkdownAllParkingLotInfo() {
        String result = "";
        result += "#" + this.parkingManager.parkingLotInfo() + "\n";
        result = printParkingLotInfo(result, this.parkingManager, "##");
        result = printParkingBoyParkingLotInfo(result, "##");
        return result;
    }

    private String printParkingBoyParkingLotInfo(String result, String prefix) {
        for (ParkingBoy parkingBoy : this.parkingManager.getParkingBoys()) {
            result += prefix + parkingBoy.parkingLotInfo() + "\n";
            result = printParkingLotInfo(result, parkingBoy, prefix + prefix.substring(0, 1));
        }
        return result;
    }

    private String printParkingLotInfo(String result, ParkingBoy parkingBoy, String prefix) {
        for (ParkingLot parkingLot : parkingBoy.getParkingLots()) {
            result += prefix + parkingLot.parkingLotInfo() + "\n";
        }
        return result;
    }
}
