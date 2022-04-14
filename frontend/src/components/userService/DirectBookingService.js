import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/customer/transporter";

const API = "http://localhost:8080/transporter/estimatedprice";

const ITEM_LIST_API = "http://localhost:8080/customer/itemdetails";
const API2 = "http://localhost:8080/admin/transporter";

const API3 = "http://localhost:8080/transporter/auctionitem";

const API4 = "http://localhost:8080/customer/auctionitembidder";

const API5 = "http://localhost:8080/customer/directhistory";

const API6 = "http://localhost:8080/customer/historyauctionitem";

const API7 = "http://localhost:8080/transporter/selectedBidders";

// const API8 = "http://localhost:8080/transporter/estimatedprice";
const API8 = "http://localhost:8080/admin/feedback";

const API9 = "http://localhost:8080/transporter/payment";

const API10 = "http://localhost:8080/admin/payment";

const API11 = "http://localhost:8080/admin/customer";

const API12 = "http://localhost:8080/transporter/selectedBidders";

 class DirectBookingService {
 
    //Transporets List
    getTransporters(){
        const emp = axios.get(EMPLOYEE_API_BASE_URL);
        console.log(emp);
        return emp;
    }

    getTransporters1(){
        const emp = axios.get(API2);
        console.log(emp);
        return emp;
    }

   // get estimate price by transported Id

    getTransporterById(t_id){
        console.log(t_id);
        console.log(API);
        let url = API +"/"+t_id;
        console.log(url);
        const esti = axios.get(url);
        console.log(esti);
    
        return esti;
       
    }

    // verfication of transporter
    
    getTransporterById1(t_id){
        console.log(t_id);
        console.log(API2);
        let url = API2 +"/"+t_id;
        console.log(url);
        const esti = axios.put(url);
        console.log(esti);
    
        return esti;
       
    }

    getItems(){
        const cust_id = JSON.parse(localStorage.getItem('c_id'));
        let url = ITEM_LIST_API +"/"+cust_id;
        const item = axios.get(url);
        console.log(item);
        return item;
    }

    getItemsById(i_id){
        console.log(i_id);
        return i_id;
       
    }
    getItemsByIdAuction(i_id){
        console.log(i_id);
        return i_id;
       
    }

    //for auction
    getItemsByAuctionId(i_id){
        console.log(i_id);
        return i_id;
       
    }

    // transporter dashboard => auction details


    getAuctionItems(){

        const item = axios.get(API3);
        console.log(item);
        return item;
    }
    getAuctionItemsById(a_item_id,c_id)
    {
        console.log("a_item_id : "+a_item_id+"c_id: "+c_id);
        return a_item_id,c_id;
    }

   // customer aution items to check bidder
   getBiddersById(a_item_id)
   {

       console.log("auction id: "+a_item_id);
       
   }

   getBidders()
   {

    const a_item_id = JSON.parse(localStorage.getItem('a_item_id'));
        let url = API4 +"/"+a_item_id;
        const item = axios.get(url);
        console.log(item);
        return item;
   }
  

   // customer = direct booking history

   getDirectHistory()
   {
    const emp = axios.get(API5);
    console.log(emp);
    return emp;
   }
    
   //customer = aution item history

   getAuctionItemHistory()
   {
    const cust_id = JSON.parse(localStorage.getItem('c_id'));
    let url = API6 +"/"+cust_id;
    const ahistory = axios.get(url);
    console.log(ahistory);
    return ahistory;
   }

   //transporter = history

   getHistory()
   {
    const t_id = JSON.parse(localStorage.getItem('t_id'));
    
    let url = API7 +"/"+t_id;
    const thistory = axios.get(url);
    console.log(thistory);
    return thistory;

   }

   //get feedback
   getfeedback()
   {
    // const a_id = JSON.parse(localStorage.getItem('a_id'));
    
    const feedback = axios.get("http://localhost:8080/admin/feedback");
    console.log(feedback);
    return feedback;
   }
      
    // get transporter = paymet lists
    getPayments()
    {
        const t_id = JSON.parse(localStorage.getItem('t_id'));
    
        let url = API9 +"/"+t_id;
        const tpayments = axios.get(url);
        console.log(tpayments);
        return tpayments;
    }
  
    //get payments = admin

    Payments(){
        const payment = axios.get(API10);
        console.log(payment);
        return payment;
    }

    //get customerlist for admin

    getCustomers()
    {
        const customer = axios.get(API11);
        console.log(customer);
        return customer;
    }


    //get selected bidder list in pickup and delivery management

    getSelectedBidders()
    {
        const t_id = JSON.parse(localStorage.getItem('t_id'));
    
        let url = API12 +"/"+t_id;
           
        const sbidders = axios.get(url);
        console.log(sbidders);
        return sbidders;
    }
}
export default new DirectBookingService()