import "./App.css";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import Menu from "./pages/Menu";
import About from "./pages/About";
import Contact from "./pages/Contact";
import CustomerLogin from "./pages/CustomerLogin";
import TransporterLogin from "./pages/TransporterLogin";
import CustomerRegister from "./pages/CustomerRegister";
import TransporterRegister from "./pages/TransporterRegister";
import Register from "./pages/Register";
import AdminLogin from "./pages/AdminLogin";
import UserHome from "./userDashboard/Home";
import KilometerRangeForm from "./userDashboard/KilometerRangeForm"
import {Route,Routes,Link} from 'react-router-dom';
import {ToastContainer} from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import RegisterItem from "./userDashboard/RegisterItem";
import DirectBooking from "./userDashboard/DirectBooking";
import FeedBack from "./userDashboard/FeedBack";
import AuctionItems from "./userDashboard/AuctionItemDetails";
import Settings from "./userDashboard/Settings";
import Items from "./userDashboard/Items";
import AuctionDetails from "./transDashboard/AuctionDetails"
import CheckPayments from "./transDashboard/CheckPayments"
import EstimatedPrice from "./transDashboard/EstimatedPrice"
import TransFeedBack from "./transDashboard/Feedback"
import TransHistory from "./transDashboard/History"
import ManageVehicleDriver from "./transDashboard/ManageVehicleDriver"
import TransSetting from "./transDashboard/Setting"
import EstimatedPriceList from "./userDashboard/EstimatedPriceList";
import DirectBookingList from "./userDashboard/DirectBookingList";
import ViewEmployeeComponent from "./userDashboard/ViewEmployeeComponent"
import AuctionItemForm from "./userDashboard/AuctionItemForm";
import App1 from "./Timer/App1";
import ManageCustomers from "./adminDashboard/ManageCustomers";
import ManageTransporters from "./adminDashboard/ManageTransporters"
import AuctionItemDetails from "./userDashboard/AuctionItemDetails";
import BidNow from "./transDashboard/BidNow";
import CheckBidder from "./userDashboard/CheckBidder";
import History from "./userDashboard/History";
import CheckFeedback from "./adminDashboard/CheckFeedback"
import CPayment from "./userDashboard/CPayment";
import Payments from "./adminDashboard/Payments";
import PickupDeliveryMgmt from "./transDashboard/PickupDeliveryMgmt";
import PickupDeliveryForm from "./transDashboard/PickupDeliveryForm";
import CheckBidderHistory from "./userDashboard/CheckBidderHistory";
// import DirectBooking from "./userDashboard/DirectBooking";
// import { RadioButtonCheckedSharp } from "@material-ui/icons";

function App() {
  return (
    <div className="App">
      <Routes>
      
        <Route exact path='/' element={<Home/>}/>

         {/* Introduction site */}

          {/* <Route exact path="/"  component={Home} /> */}
          <Route exact path="/menu"  element={<Menu/>} />
          <Route exact path="/about"  element={<About/>} />
          <Route exact path="/contact"  element={<Contact/>} />
          <Route exact path="/register"  element={<Register/>} />
          <Route exact path="/custLogin"  element={<CustomerLogin/>} />
          <Route exact path="/adminLogin"  element={<AdminLogin/>} />
          <Route exact path="/transLogin"  element={<TransporterLogin/>} />
          <Route exact path="/transRegister"  element={<TransporterRegister/>} />
          <Route exact path="/custRegister"  element={<CustomerRegister/>} />

         {/* User Dashboard Route */}
        <Route exact path="/userHome"  element={<UserHome/>} />
        <Route exact path="/registerItem"  element={<RegisterItem/>} />
        <Route exact path="/directBooking"  element={<DirectBooking/>} />
        <Route exact path="/feedback"  element={<FeedBack/>} />
        <Route exact path="/auctionItemDetails"  element={<AuctionItemDetails/>} />
        <Route exact path="/settings"  element={<Settings/>} />
        <Route exact path="/items"  element={<Items/>} />
        <Route exact path="/estimatedPriceList"  element={<EstimatedPriceList/>} /> 
        <Route exact path="/auctionItemForm" element={<AuctionItemForm/>} />
        <Route exact path="/kilometerRangeForm" element={<KilometerRangeForm />} />
        <Route exact path="/checkBidder" element={<CheckBidder/>}/>
        <Route exact path="/cHistory" element={<History/>}/>
        <Route exact path="/cPayment" element={<CPayment/>}/>
        <Route exact path="/checkBidderHistory" element={<CheckBidderHistory/>}/>
        {/* for trial */}

        <Route exact path="/directBookingList"  element={<DirectBookingList/>} /> 
        <Route exact path = "/view-employee/:id" element = {<ViewEmployeeComponent/>}></Route>
        <Route exact path = "/timer" element ={<App1/>}/>        
        {/* <ToastContainer position="top-center" hideProgressBar={false} autoClose={5000}  /> */}
       
       {/* Transporter Dashboard Routes */}
       <Route exact path="/auctiondetails"  element={<AuctionDetails/>} />
       <Route exact path="/checkPayment"  element={<CheckPayments/>} />
       <Route exact path="/transFeedback"  element={<TransFeedBack/>} />
       <Route exact path="/estimatedPrice"  element={<EstimatedPrice/>} />
       <Route exact path="/transHistory"  element={<TransHistory/>} />
       <Route exact path="/manageVehicleDriver"  element={<ManageVehicleDriver/>} />
       <Route exact path="/transSetting"  element={<TransSetting/>} />
        <Route exact path="/bidNow" element={<BidNow/>} />
        <Route exact path="/pickupDelivery" element={<PickupDeliveryMgmt/>}/>
        <Route exact path="/pickupDeliveryForm" element={<PickupDeliveryForm/>}/>

      {/* Admin Dashboard */}
      <Route exact path="/manageTransporters"  element={<ManageTransporters/>} />
       <Route exact path="/manageCustomers"  element={<ManageCustomers/>} />
       <Route exact path="/checkFeedback" element={<CheckFeedback/>}/>
       <Route exact path="/checkPayments" element={<Payments/>}/>

      </Routes>
    </div>
  );
}

export default App;
