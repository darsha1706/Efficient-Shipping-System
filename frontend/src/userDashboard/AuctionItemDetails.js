import React, {useEffect, useState} from 'react';
import { Table } from 'reactstrap';
import Cookies from 'universal-cookie';
import NavBar from './NavBar';



// const a_end_datetime = localStorage.getItem('a_end_datetime');
// const cookie = new Cookies();
// const  a_end_datetime= cookie.get('a_end_datetime');
//     console.log(a_end_datetime);

export default function AuctionItemDetails() {

  function getBiddersById(a_item_id)
  {
    console.log(a_item_id);
    localStorage.setItem("a_item_id",a_item_id);
    window.location.href = "/checkBidder";
  }
 
  function getItemsById(a_end_datetime)
  {
    const cookie = new Cookies();

    cookie.set('a_end_datetime',a_end_datetime);
    const  a_date= cookie.get('a_end_datetime');
    console.log("cookie date"+a_date);

    calculateTimeLeft();
    return a_end_datetime;
   
  }

  
    const calculateTimeLeft= () => {
      const cookie = new Cookies();
      const  a_end_datetime= cookie.get('a_end_datetime');
      console.log("end date"+a_end_datetime);
      let year = new Date().getFullYear();
     
      
      
      let difference = +new Date(a_end_datetime) - +new Date();
      console.log(difference);
      let timeLeft = {};
    
      if (difference > 0) {
        timeLeft = {
          days: Math.floor(difference / (1000 * 60 * 60 * 24)),
          hours: Math.floor((difference / (1000 * 60 * 60)) % 24),
          minutes: Math.floor((difference / 1000 / 60) % 60),
          seconds: Math.floor((difference / 1000) % 60)
        };
      }
      // console.log(difference);
      //  window.location.href = "/estimatedPriceList"
     
      return timeLeft;
    }
    
  
    const [year] = useState(new Date().getFullYear());
    const [timeLeft, setTimeLeft] = useState(calculateTimeLeft());
    useEffect(() => {
     
      const timer = setTimeout(() => {
        setTimeLeft(calculateTimeLeft());
      }, 1000);
    
      return () => clearTimeout(timer);
    });
  
    const timerComponents = [];
  
    Object.keys(timeLeft).forEach((interval) => {
      if (!timeLeft[interval]) {
       
        return;
      }
     
      timerComponents.push(
        // window.alert(timerComponents)
        <span>
         
          {timeLeft[interval]} {interval}{" "}
        </span>
      );
      // window.alert(timerComponents);
    });
  
    // ({timerComponents.length ? timerComponents : <span>Time's up!</span>})



    const cust_id = JSON.parse(localStorage.getItem('c_id'));
const API_HOST = "http://localhost:8080/customer/auctionitem";
const INVENTORY_API_URL = `${API_HOST}/${cust_id}`;
console.log(INVENTORY_API_URL);


    const [data, setData] = useState([]);

    // GET request function to your Mock API
    const fetchInventory = () => {
        fetch(`${INVENTORY_API_URL}`)
            .then(res => res.json())
            .then(json => setData(json));
            // console.log("data is"+data);
            // console.log(data.item_details.i_name);
    }
    const Timer=()=>{
      // window.alert(timerComponents);
      return (
        <> ({<h1>Timer is : </h1>+timerComponents.length ? timerComponents : <span>Time's up!</span>})</>
      )
    }
    
    
    
    // Calling the function on component mount
    useEffect(() => {
        fetchInventory();
    }, []);
    // window.alert(timerComponents);
// console.log(data);
// /alert((timerComponents))
  return (
    <div >
      <NavBar/>
      <div style={{paddingTop:"120px", paddingLeft:"20px" , paddingRight:"20px" }}>
      <Table bordered striped>
  <thead>
    <tr>
      <th>Auction No</th>
      <th>Item name</th>
      <th> Item End Date </th>
     <th>Item Status</th>
      <th> Highest Bid Price </th>
      <th>Lowest Bid Price</th>
      <th> Actions </th>
    </tr>
  </thead>
  <tbody>
  {
                                  
                                   data.map((item) => (
                                        <tr key = {item.a_item_id}>
                                           <td>{item.a_item_id}</td>
                                         <td>{item.item_detail.i_name}</td>
                                        <td>{item.a_end_datetime}</td>
                                        <td>{item.a_item_status}</td>
                                        <td>{item.highest_bid_price}</td>
                                        <td>{item.lowest_bid_price}</td>
                                        <td>
                                        <button style={{marginLeft: "20px"}}  

                                                  // value={a_end_datetime}
                                                  onClick={() => getItemsById(item.a_end_datetime)}
                                                 className="btn btn-warning">Check timer
                                        </button>

                                        <button style={{marginLeft: "20px"}}  

                                                  // value={a_end_datetime}
                                                  onClick={() => getBiddersById(item.a_item_id)}
                                                 className="btn btn-info">Check Bidder
                                        </button>
                                        
                                       
                                        </td>  
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </Table>
                        <h3 style={{color:"red"}}> Timer is :</h3>
                        <Timer/>
                          {/* ({timerComponents.length ? timerComponents : <span>Time's up!</span>}) */}
    </div>
    </div>
  )
};
