using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace assignment_2
{
    class Vehicles
    {
        //setter and getter
        public String manufacturer { get; set; }
        public String model { get; set; }
        public int makeYear { get; set; }
       
        public String Registration { get; set; }
        public int TotalKm { get; set; }
        public int totalS { get; set; }
        public int revenueRecorded { get; set; }
        public int totalkmLastS { get; set; }
        public bool RequiresS { get; set; }

        private FuelPurchase FP = new FuelPurchase();


        /// <summary>
        /// TODO Create an addKilometers method which takes a parameter for distance travelled 
        /// and adds it to the odometer reading. 
        /// adds fuel to the car
        /// </summary>
        /// <param name="litres"></param>
        /// <param name="price"></param>
        public void addFuel(double litres, double price)
        {
            FP.purchaseFuel(litres, price);
        }

        public static implicit operator List<object>(Vehicles v)
        {
            throw new NotImplementedException();
        }
    }
}
