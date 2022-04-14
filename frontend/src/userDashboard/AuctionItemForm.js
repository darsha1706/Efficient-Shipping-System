import React, { Component ,useState , useEffect} from 'react'
import NavBar from './NavBar'
import "../styles/Home.css";
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import App1 from '../Timer/App1';
// import AuctionItemDetails from './AuctionItemDetails';
import Cookies from 'universal-cookie';

export default function AuctionItemForm(){
  
  const[a_item_comments,setItemComments]=useState('')
  const[a_item_details,setItemDetails]=useState('')
  const[a_end_datetime,setEndDate]=useState('')
  const[highest_bid_price,setHighBid]=useState('')
  const[lowest_bid_price,setLowBid]=useState('')
  const a_start_datetime  = new Date();
  // const date = a_end_date.toString();
  console.log(a_end_datetime);
  console.log(a_start_datetime);
  const cookie = new Cookies();
  cookie.set('a_end_datetime',a_end_datetime);
  cookie.set('a_start_datetime',a_start_datetime);
  localStorage.setItem("a_end_datetime",a_end_datetime);
  localStorage.setItem("a_start_datetime",a_end_datetime);

  const i_id = localStorage.getItem('i_id');
  const c_id = localStorage.getItem('c_id');
  console.log(i_id,c_id);


  const calculateTimeLeft = () => {
    // const start_date = new Date();
    
    let year = new Date().getFullYear();
    // const d1 = AuctionItemForm
    const date1 = new Date('7/13/2010');
    // const date2 = new Date('12/15/2010');
    
    let difference = +new Date(a_end_datetime) - +new Date();
    // console.log(difference);
    let timeLeft = {};
  
    if (difference > 0) {
      timeLeft = {
        days: Math.floor(difference / (1000 * 60 * 60 * 24)),
        hours: Math.floor((difference / (1000 * 60 * 60)) % 24),
        minutes: Math.floor((difference / 1000 / 60) % 60),
        seconds: Math.floor((difference / 1000) % 60)
      };
    }
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
      <span>
        {timeLeft[interval]} {interval}{" "}
      </span>
    );
  });

 

  //   const start_date = new Date(a_start_date);
  //   const end_date = new Date(a_end_date);


    // console.log("start date: "+start_date.toString());
    // console.log("end date: "+end_date.toString());

    //days
  //   const days = Math.abs(end_date - start_date);
  //     const day= days / (1000 * 60 * 60 * 24);
  //     console.log("days is "+day);

  //     //hours
  //     const hours = Math.abs(end_date - start_date);
  //     const hrs = hours / (1000 * 60 * 60);
  //     console.log("hours is "+hrs);

  //     //min
  // const minute = Math.abs(end_date - start_date);
  // const min = minute / (1000 * 60);
  // console.log("minute is "+min);

  // //second
  // const second = Math.abs(end_date - start_date);
  // const sec = second / 1000;
  // console.log("sec is :"+sec)
    // function getDifferenceInDays(a_start_date, a_end_date) {
      
    // }

    // let difference = start_date - end_date;

    // console.log("diff: "+difference);
    // console.log("d :"+date);
    // console.log("T: "+time);
  //   console.log(auction);

  const handleClick=(e)=>{
    e.preventDefault()
    const auction = {a_start_datetime,a_end_datetime,a_item_details,a_item_comments,highest_bid_price,lowest_bid_price}
   
    
  const url = "http://localhost:8080/customer/auctionitem?c_id=" +c_id+ "&i_id=" +i_id;
  console.log(url);
  fetch(url,{
    method:"POST",
    headers:{"Content-Type":"application/json"},
      body:JSON.stringify(auction)
  }
  ).then(()=>{
    window.location.href = "auctionItemDetails";
    console.log("new item added")
  })
    // fetch(`http://localhost:8080/customer/auctionitem?c_id=${c_id}&i_id=${i_id}`,auction,
    // {method:"POST"}
    // // {
    // //   headers:{"Content-Type":"application/json"},
    // //   body:JSON.stringify(auction)
    // // }
    // ).then(()=>{
    //   window.location.href = "/contact";
    //   console.log("new customer added")
    // })
  

  }
    return (
        <div>
        <NavBar/>
        <div className="home" >
     
     <div className="headerContainer">
       <h1 style={{paddingTop:"120px", paddingLeft:"20px" , paddingRight:"20px" }}>Auction Item Form</h1>
       <br></br>
      
       
     </div>
     
     <Form inline>
  
  {' '}
  

  <FormGroup>
    <Label
      for="a_end_datetime"
      
    >
      Auction Item End Date
    </Label>
    <Input
      id="a_end_datetime"
      name="a_end_datetime"
      placeholder="End Date"
      type="date"
      value={a_end_datetime}
      onChange={(e)=>setEndDate(e.target.value)}
    />
  </FormGroup>

  
  <FormGroup>
    <Label
      for="a_item_comments"
      
    >
      Auction Item Comments
    </Label>
    <Input
      id="a_item_comments"
      name="a_item_comments"
      placeholder="Any Comments"
      type="text"
      value={a_item_comments}
      onChange={(e)=>setItemComments(e.target.value)}
    />
  </FormGroup>
  
  <FormGroup>
    <Label
      for="a_item_details"
      
    >
      Auction Item Details
    </Label>
    <Input
      id="a_item_details"
      name="a_item_details"
      placeholder="Item Details"
      type="text"
      value={a_item_details}
      onChange={(e)=>setItemDetails(e.target.value)}
    />
  </FormGroup>
  
  <FormGroup>
    <Label
      for="highest_bid_price"
      
    >
      Highest Bid Price
    </Label>
    <Input
      id="highest_bid_price"
      name="highest_bid_price"
      placeholder="High Bid price"
      type="text"
      value={highest_bid_price}
      onChange={(e)=>setHighBid(e.target.value)}
    />
  </FormGroup>
  
  <FormGroup>
    <Label
      for="lowest_bid_price"
      
    >
     Lowest Bid Price
    </Label>
    <Input
      id="lowest_bid_price"
      name="lowest_bid_price"
      placeholder="Low Bid Price"
      type="text"
      value={lowest_bid_price}
      onChange={(e)=>setLowBid(e.target.value)}
    />
  </FormGroup>
  {' '}
 
 
  <Button
   onClick={handleClick}
  //  href = "/directBookingList"
  >
    Submit
  </Button>
</Form>
     </div>
        
     {/* {timerComponents.length ? timerComponents : <span>Time's up!</span>} */}
      </div>
    )
  }