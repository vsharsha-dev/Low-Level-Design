import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static class Vehicle {
        int vehicleNo;
        VehicleType vehicleType;
        ParkingSpot parkingSpot;
        Ticket ticket;

        public Vehicle(int vehicleNo, VehicleType vehicleType){
            this.vehicleNo = vehicleNo;
            this.vehicleType = vehicleType;
            parkingSpot = null;
        }

        public void assignTicket(Ticket ticket){
            this.ticket = ticket;
        }
    }

    static class ParkingLot {
        List<ParkingFloor> parkingFloors;

        public ParkingLot(){
            parkingFloors = new ArrayList<>();
        }
        public void addFloor(ParkingFloor parkingFloor) {
            parkingFloors.add(parkingFloor);
        }

        public void assignParkingSpot(Vehicle vehicle){
            List<ParkingSpot> parkingSpotsWithSameType;
            for(ParkingFloor floor : parkingFloors){
                if(vehicle.vehicleType == VehicleType.LARGE){
                    parkingSpotsWithSameType = floor.getParkingSpotsWithType(ParkingSpotType.LARGE);
                    parkVehicleInFloor(parkingSpotsWithSameType, vehicle);
                    if(vehicle.parkingSpot != null) break;
                }
                else if(vehicle.vehicleType == VehicleType.COMPACT){
                    parkingSpotsWithSameType = floor.getParkingSpotsWithType(ParkingSpotType.COMPACT);
                    parkVehicleInFloor(parkingSpotsWithSameType, vehicle);
                    if(vehicle.parkingSpot != null) break;
                }
                else if(vehicle.vehicleType == VehicleType.TWO_WHEELER){
                    parkingSpotsWithSameType = floor.getParkingSpotsWithType(ParkingSpotType.TWO_WHEELER);
                    parkVehicleInFloor(parkingSpotsWithSameType, vehicle);
                    if(vehicle.parkingSpot != null) break;
                }
            }
            if(vehicle.parkingSpot == null) {
                System.out.println("No parking spots available for vehicle "+vehicle.vehicleNo);
            }

        }

        public void parkVehicleInFloor(List<ParkingSpot> parkingSpotsWithSameType, Vehicle vehicle){
            if(parkingSpotsWithSameType != null){
                for(ParkingSpot spot : parkingSpotsWithSameType){
                    if(spot.isEmpty){
                        spot.parkVehicle(vehicle);
                        System.out.println("Parked vehicle "+vehicle.vehicleNo+" in spot "+spot.parkingSpotId);
                        vehicle.assignTicket(new Ticket(vehicle.vehicleType));
                        vehicle.parkingSpot = spot;
                        return;
                    }
                }
            }
        }
    }

    static class ParkingFloor {
        int floorId;
        Map<ParkingSpotType, List<ParkingSpot>> parkingFloorSpots;

        public ParkingFloor(int floorId){
            this.floorId = floorId;
            this.parkingFloorSpots = new HashMap<>();
        }

        public List<ParkingSpot> getParkingSpotsWithType(ParkingSpotType spotType){
            return parkingFloorSpots.get(spotType);
        }

        public void addSpot(ParkingSpot spot){
            parkingFloorSpots.putIfAbsent(spot.parkingSpotType, new ArrayList<>());
            parkingFloorSpots.get(spot.parkingSpotType).add(spot);
        }
    }

    static class ParkingSpot {
        int parkingSpotId;
        Vehicle vehicle;
        ParkingSpotType parkingSpotType;
        boolean isEmpty;

        public ParkingSpot(int parkingSpotId, ParkingSpotType parkingSpotType){
            this.parkingSpotId = parkingSpotId;
            this.parkingSpotType = parkingSpotType;
            this.vehicle = null;
            isEmpty = true;
        }

        public void parkVehicle(Vehicle vehicle){
            this.vehicle = vehicle;
            this.isEmpty = false;
        }

        public void removeVehicle(Vehicle vehicle){
            this.vehicle = null;
            this.isEmpty = true;
        }
    }

    enum ParkingSpotType {
        TWO_WHEELER, COMPACT, LARGE;
    }
    enum VehicleType {
        TWO_WHEELER, COMPACT, LARGE;
    }

    static class Ticket {
        Long inTime;
        Long outTime;
        VehicleType vehicleType;

        public Ticket(VehicleType vehicleType){
            inTime = System.currentTimeMillis();
            this.vehicleType = vehicleType;
        }

        public double calculateTotal(){
            if(vehicleType == VehicleType.TWO_WHEELER){
                return (((double)(System.currentTimeMillis() - inTime)/1000.0)/3600.0) * 10;
            }
            else if(vehicleType == VehicleType.COMPACT){
                return (((double)(System.currentTimeMillis() - inTime)/1000.0)/3600.0) * 20.0;
            }
            else if(vehicleType == VehicleType.LARGE){
                return (((double)(System.currentTimeMillis() - inTime)/1000.0)/3600.0) * 30;
            }

            return (((double)(System.currentTimeMillis() - inTime)/1000.0)/3600.0) * 5;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");

        ParkingLot parkingLot = new ParkingLot();

        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingSpot spot1 = new ParkingSpot(1, ParkingSpotType.TWO_WHEELER);
        ParkingSpot spot2 = new ParkingSpot(2, ParkingSpotType.TWO_WHEELER);
        ParkingSpot spot3 = new ParkingSpot(3, ParkingSpotType.TWO_WHEELER);
        floor1.addSpot(spot1);
        floor1.addSpot(spot2);
        floor1.addSpot(spot3);

        parkingLot.addFloor(floor1);

        ParkingFloor floor2 = new ParkingFloor(2);
        ParkingSpot spot4 = new ParkingSpot(4, ParkingSpotType.COMPACT);
        ParkingSpot spot5 = new ParkingSpot(5, ParkingSpotType.COMPACT);
        ParkingSpot spot6 = new ParkingSpot(6, ParkingSpotType.COMPACT);
        floor2.addSpot(spot4);
        floor2.addSpot(spot5);
        floor2.addSpot(spot6);

        parkingLot.addFloor(floor2);

        Vehicle vehicle = new Vehicle(9999, VehicleType.COMPACT);
        Vehicle vehicle1 = new Vehicle(1234, VehicleType.TWO_WHEELER);
        Vehicle vehicle2 = new Vehicle(2222, VehicleType.TWO_WHEELER);
        Vehicle vehicle3 = new Vehicle(1, VehicleType.TWO_WHEELER);
        Vehicle vehicle4 = new Vehicle(9, VehicleType.TWO_WHEELER);

        parkingLot.assignParkingSpot(vehicle);
        parkingLot.assignParkingSpot(vehicle1);
        parkingLot.assignParkingSpot(vehicle2);
        parkingLot.assignParkingSpot(vehicle3);
        parkingLot.assignParkingSpot(vehicle4);

        Thread.sleep(5000);

        vehicle.parkingSpot.removeVehicle(vehicle);

        System.out.println("Total amount: "+vehicle.ticket.calculateTotal());

        Thread.sleep(5000);

        vehicle1.parkingSpot.removeVehicle(vehicle1);

        System.out.println("Total amount: "+vehicle1.ticket.calculateTotal());

        vehicle1.parkingSpot.removeVehicle(vehicle2);
        vehicle1.parkingSpot.removeVehicle(vehicle3);
        vehicle1.parkingSpot.removeVehicle(vehicle4);
    }
}
