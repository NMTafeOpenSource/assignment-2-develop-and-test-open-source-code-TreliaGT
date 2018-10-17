using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;


namespace assignment_2
{
    /// <summary>
    /// Interaction logic for AddVehiclesWindow.xaml
    /// </summary>
    public partial class AddVehiclesWindow : Window
    {
        MainWindow M;

        Vehicles Vs;
        Vehicles Vehicle;



        List<Vehicles> V = new List<Vehicles>();
        public AddVehiclesWindow()
        {
            InitializeComponent();
        }


        private void Add_Click(object sender, RoutedEventArgs e)
        {
            
            Vs.model = Model.Text;
            Vs.manufacturer = Manufacturer.Text;
            Vs.makeYear = Convert.ToInt32( makeYear.Text);

         

            Vehicle.Vehicle = Vs.GetVehicle();
            Vehicle.Registration = Registration.Text;
            Vehicle.TotalKm = Convert.ToInt32(TotalKMS.Text);
            Vehicle.totalS = Convert.ToInt32(TServices.Text);
            Vehicle.revenueRecorded = Convert.ToInt32(Revenue.Text);
            Vehicle.totalkmLastS = Convert.ToInt32(KMSLS.Text);
            Vehicle.RequiresS = Convert.ToBoolean(RS.Text);

            V.Add(Vehicle);

          
            Vehicle.Cars.Add(V);

        }

        private void Back_Click(object sender, RoutedEventArgs e)
        {
            MainWindow m = new MainWindow();
            m.Show();
            this.Close();
        }
    }
}
