package creational;

/**
 * Created by Orest on 2/20/2017.
 */
public class Builder {

    /* Abstract Builder */
    public abstract class LaptopBuilder {

        protected Laptop laptop;

        public void CreateNewLaptop() {
            laptop = new Laptop();
        }

        public Laptop GetMyLaptop() {
            return laptop;
        }

        public abstract void SetMonitorResolution();

        public abstract void SetProcessor();

        public abstract void SetMemory();

        public abstract void SetHDD();

        public abstract void SetBattery();
    }

    public class Laptop {
        public String MonitorResolution;
        public String Processor;
        public String Memory;
        public String HDD;
        public String Battery;

        public String toString() {
            return String.format("Laptop: %1$s, %2$s, %3$s, %4$s, %5$s,",
                    MonitorResolution, Processor, Memory, HDD, Battery);
        }
    }


    /* Concrete Builder */
    public class TripLaptopBuilder extends LaptopBuilder{

        public void SetMonitorResolution() {
            laptop.MonitorResolution = "1200X800";
        }

        public void SetProcessor() {
            laptop.Processor = "Celeron 2 GHz";
        }

        public void SetMemory() {
            laptop.Memory = "2048 Mb";
        }

        public void SetHDD() {
            laptop.HDD = "250 Gb";
        }

        public void SetBattery() {
            laptop.Battery = "12 lbs";
        }
    }

    /* Concrete Builder */
    public class GamingLaptopBuilder extends LaptopBuilder{

        public void SetMonitorResolution() {
            laptop.MonitorResolution = "1900X1200";
        }

        public void SetProcessor() {
            laptop.Processor = "Core 2 Duo, 3.2 GHz";
        }

        public void SetMemory() {
            laptop.Memory = "6144 Mb";
        }

        public void SetHDD() {
            laptop.HDD = "500 Gb";
        }

        public void SetBattery() {
            laptop.Battery = "6 lbs";
        }
    }

    /* Director */
    public class BuyLaptop{
        private LaptopBuilder laptopBuilder;

        public void SetLaptopBuilder(LaptopBuilder builder){
            laptopBuilder = builder;
        }

        public Laptop GetLaptop(){
            return laptopBuilder.GetMyLaptop();
        }

        public void ConstructLaptop(){
            laptopBuilder.CreateNewLaptop();
            laptopBuilder.SetMonitorResolution();
            laptopBuilder.SetProcessor();
            laptopBuilder.SetMemory();
            laptopBuilder.SetBattery();
            laptopBuilder.SetHDD();
        }
    }

    /* Client Code */
    public static void main(String[] args) {
        Builder builder = new Builder();
        TripLaptopBuilder tripLaptopBuilder = builder.new TripLaptopBuilder();
        GamingLaptopBuilder gamingLaptopBuilder = builder.new GamingLaptopBuilder();
        BuyLaptop shop = builder.new BuyLaptop();

        shop.SetLaptopBuilder(gamingLaptopBuilder);
        shop.ConstructLaptop();
        Laptop laptop = shop.GetLaptop();
        System.out.println(laptop.toString());
    }

}
