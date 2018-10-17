using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace assignment_2
{
    class Service
    {
        // Constant to indicate that the vehicle needs to be serviced every 10,000km
        public static double SERVICE_KILOMETER_LIMIT = 10000;

        private double lastServiceOdometerKm = 0;
        private double serviceCount = 0;
        // TODO add lastServiceDate

        // return the last service
        public double getLastServiceOdometerKm()
        {
            return this.lastServiceOdometerKm;
        }

        /**
         * The function recordService expects the total distance traveled by the car, 
         * saves it and increase serviceCount.
         * @param distance 
         */
        public void recordService(double distance)
        {
            this.lastServiceOdometerKm = distance;
            this.serviceCount++;
        }

        // return how many services the car has had
        public double getServiceCount()
        {
            return this.serviceCount;
        }

        /**
         * Calculates the total services by dividing kilometers by
         * {@link #SERVICE_KILOMETER_LIMIT} and floors the value. 
         * 
         * @return the number of services needed per SERVICE_KILOMETER_LIMIT
         */
        public double getTotalScheduledServices()
        {
            return Math.Floor(lastServiceOdometerKm / SERVICE_KILOMETER_LIMIT);
        }
    }
}
