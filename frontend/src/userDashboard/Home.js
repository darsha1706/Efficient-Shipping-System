import React from "react";
import { Link } from "react-router-dom";

import "../styles/Home.css";
import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';
import NavBar from "./NavBar";
import SideBar from "./SideBar";
import App1 from "../Timer/App1";
import '../styles/timer.css';

function Home() {

  

  return (
    <div>
       <NavBar/>
      <App1/>
    <div className="home" >
    <SideBar/>
      <div className="headerContainer">
        <h1 style={{color:"black"}}>welcome to user dashboard</h1>
        <br></br>
       
        
      </div>
      

      </div>
      </div>
   
  );
}

export default Home;
