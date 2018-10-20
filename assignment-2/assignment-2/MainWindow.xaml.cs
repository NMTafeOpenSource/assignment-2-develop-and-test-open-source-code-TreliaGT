using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;

namespace assignment_2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        const char delimter = ',';
        Vehicles Vehicle= new Vehicles();
        List<Vehicles> V = new List<Vehicles>();
        

        public MainWindow()
        {
            InitializeComponent();
            gridDetails.Visibility = Visibility.Hidden;
        }
   

        private void Add_Click(object sender, RoutedEventArgs e)
        {
            gridDetails.Visibility = Visibility.Visible;
            grid1.Visibility = Visibility.Hidden;
            addlabals.Visibility = Visibility.Visible;
        }

        private void Details_Click(object sender, RoutedEventArgs e)
        {
            gridDetails.Visibility = Visibility.Visible;
            grid1.Visibility = Visibility.Hidden;
            addlabals.Visibility = Visibility.Hidden;
            AddItem.IsEnabled = false;
        }

        private void DataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e) //to show what record the user is on
        {
            message.Text = DataGrid.SelectedIndex.ToString();

        }

        private void AddItem_Click(object sender, RoutedEventArgs e)
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
            DataGrid.ItemsSource = V;
            records.Text = V.Count + "Records";
        }

        private void Back_Click(object sender, RoutedEventArgs e)
        {
            gridDetails.Visibility = Visibility.Hidden;
            grid1.Visibility = Visibility.Visible;
            AddItem.IsEnabled = true;
        }

        public void viewDetails()
        {
            Vehicles theVehicle = new Vehicles();
            int selected = DataGrid.SelectedIndex;
            theVehicle = V.ElementAt(selected);

            Model.Text = theVehicle.model;
            Manufacturer.Text = theVehicle.manufacturer;
            makeYear.Text = theVehicle.makeYear.ToString();
            Registration.Text = theVehicle.Registration;
            TotalKMS.Text = theVehicle.TotalKm.ToString();
            TServices.Text = theVehicle.totalS.ToString();
            Revenue.Text = theVehicle.revenueRecorded.ToString();
            KMSLS.Text = theVehicle.totalkmLastS.ToString();
           RS.IsChecked = theVehicle.RequiresS;
        }
    }
}
