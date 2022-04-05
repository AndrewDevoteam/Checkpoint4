package domain;

public class VehicleService {

//    By taking a closer look, you will notice that the methods in the VehicleService are still returning Vehicle, even though you are working with Car now, can you explain why it works fine?
//    It works because the Car class inherits all its properties from the parent class Vehicle.

    private final VehicleRepository vehicleRepository = new VehicleRepository();

    public void searchByAutomaker(String manufacturerName) {
        boolean result = false;
        if(manufacturerName == null){
            System.out.println("Please enter a valid option");
        }
        for (int i = 0; i < vehicleRepository.getVehicleList().length; i++) {
            if (vehicleRepository.getVehicleList()[i].getAutoMaker().getName().equalsIgnoreCase(manufacturerName)) {
                result = true;
                vehicleRepository.getVehicleList()[i].prettyPrint();
            }
        }
        if (!result) {
            System.out.println("Invalid automaker option");
        }
    }

    public void searchByModel(String modelName) {
        boolean result = false;
        if(modelName == null){
            System.out.println("Please enter a valid option");
        }
        for (int i = 0; i < vehicleRepository.getVehicleList().length; i++) {
            if (vehicleRepository.getVehicleList()[i].getModel().equalsIgnoreCase(modelName)) {
                result = true;
                vehicleRepository.getVehicleList()[i].prettyPrint();
            }
        }
        if (!result) {
            System.out.println("Invalid vehicle option");
        }
    }

    public void createVehicle(String model, String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum){
        if(model == null || color == null ||year == null ||automaker == null ||vehicleTypeEnum == null){
            System.out.println("please input a valid option");
        }
        Vehicle vehicle = addVehicle(model, color, year, automaker, vehicleTypeEnum);
        vehicleRepository.addVehicleToRepository(vehicle);
    }

    public Vehicle addVehicle(String model, String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {

        return switch (vehicleTypeEnum) {
            case CAR -> new Car(model, color, year, automaker, vehicleTypeEnum);
            case MOTORCYCLE -> new Motorcycle(model, color, year, automaker, vehicleTypeEnum);
            case VAN -> new Van(model, color, year, automaker, vehicleTypeEnum);
            case TRUCK -> new Truck(model, color, year, automaker, vehicleTypeEnum);
            case PICKUP -> new PickUp(model, color, year, automaker, vehicleTypeEnum);
            case OTHERS -> new Others(model, color, year, automaker, vehicleTypeEnum);
        };
    }

    public void getVehicle(String vehicleName, Vehicle newVehicle){

        boolean result = false;
        for (Vehicle vehicle : vehicleRepository.getVehicleList()) {
            if(vehicle.getModel().equalsIgnoreCase(vehicleName)){
                result = true;
                updateVehicle(vehicle, newVehicle);
            }
        }
        if (!result) {
            System.out.println("Invalid vehicle option");
        }
    }


    public void updateVehicle(Vehicle carOld, Vehicle carNew) {
        for (int i = 0; i < vehicleRepository.getVehicleList().length; i++) {
            if(vehicleRepository.getVehicleList()[i].getModel().equalsIgnoreCase(carOld.getModel())){
                vehicleRepository.getVehicleList()[i] = carNew;
            }
        }
    }

    public void deleteVehicleByModel(String deleteVehicle) {
        boolean result = false;
        for (Vehicle car : vehicleRepository.getVehicleList()) {
            if (car.getModel().equalsIgnoreCase(deleteVehicle)) {
                result = true;
                vehicleRepository.updatedVehicleRepository(car);
                System.out.println("Vehicle was successfully deleted");
            }
        }
        if (!result) {
            System.out.println("Invalid vehicle option");
        }
    }
}
