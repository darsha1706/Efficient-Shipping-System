// import React from 'react';
import React, { useEffect, useState } from "react";
import AuctionItemForm from "../userDashboard/AuctionItemForm";
// import logo from './logo.svg';
// import './App.css';

function App1() {
  const calculateTimeLeft = () => {
    // const start_date = new Date();
    
    let year = new Date().getFullYear();
    // const d1 = AuctionItemForm
    const date1 = new Date('7/13/2010');
    // const date2 = new Date('12/15/2010');
    
    let difference = +new Date('7/20/2022') - +new Date();
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
  return (
    <div>
       {timerComponents.length ? timerComponents : <span>Time's up!</span>}
    </div>
  )
}

export default App1;