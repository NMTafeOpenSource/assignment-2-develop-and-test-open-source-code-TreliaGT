using System.Collections;
using System.Windows;
using System.Windows.Controls;

namespace assignment_2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
      

        public MainWindow()
        {
            InitializeComponent();
        }

        private void Load_Click(object sender, RoutedEventArgs e)
        {
       

            DataGrid.ItemsSource = V.Cars;
        }

        private void Add_Click(object sender, RoutedEventArgs e)
        {
            AddVehiclesWindow Add = new AddVehiclesWindow();
            Add.Show();
            this.Hide();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}
