using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
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
        public ArrayList VE = new ArrayList();
       List<Vehicles> V = new List<Vehicles>();
      Vehicles Vehicle = new Vehicles();

        public AddVehiclesWindow()
        {
            InitializeComponent();
        }


        private void Add_Click(object sender, RoutedEventArgs e)
        {
            
            Vehicle.model = Model.Text;
            Vehicle.manufacturer = Manufacturer.Text;
            Vehicle.makeYear = Convert.ToInt32(makeYear.Text);
            Vehicle.Registration = Registration.Text;
            Vehicle.TotalKm = Convert.ToInt32(TotalKMS.Text);
            Vehicle.totalS = Convert.ToInt32(TServices.Text);
            Vehicle.revenueRecorded = Convert.ToInt32(Revenue.Text);
            Vehicle.totalkmLastS = Convert.ToInt32(KMSLS.Text);
            Vehicle.RequiresS = Convert.ToBoolean(RS.IsChecked);

            V.Add(Vehicle);
            VE.Add(V);
           
        }

        private void Back_Click(object sender, RoutedEventArgs e)
        {
            MainWindow m = new MainWindow();
            m.DataGrid.ItemsSource = VE;
            m.records.Text = VE.Count + "Records";
            m.Show();
            this.Close();
        }

    
    }
}
