import axios from "axios";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { Button, Card, CardText, CardTitle, Col, Form, FormGroup, Input, Label, Row } from "reactstrap";
import custLoginImg from "../assets/custLogin.jpg";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import "../styles/Contact.css";

function TransporterLogin() {

  const[t_email_id,setEmail]=useState('')
  const[t_password,setPassword]=useState('')

  
  const handleClick=()=>{
    const login = {t_email_id,t_password }
    
    axios.post(`http://localhost:8080/home/translogin`,login).then(
        (response)=>{
           // toast.success('login successfull');
            console.log("success");
            console.log(response);
             window.location.href = "/estimatedPrice";
            localStorage.setItem('t_id',response.data.t_id)
            
        },
        (error)=>{
         
            alert("Invalid Login Details",error);
            toast.error('invalid login');
            console.log(error);
            console.log("Error");
        }
    );
};

  return (
    <div>
      <Navbar/>
    
    <div className="contact">
      <div
        className="leftSide"
        style={{ backgroundImage: `url(${custLoginImg})` }}
      >
        {/* //leftside */}
        
        </div>
      <div className="rightSide">
        <h1> Login as Transporter</h1>

        <Form inline>
  <FormGroup className="mb-2 me-sm-2 mb-sm-0">
    <Label
      className="me-sm-2"
      for="t_email_id"
    >
      Email
    </Label>
    <Input
      id="t_email_id"
      name="t_email_id"
      placeholder="Enter Email Id"
      type="email"
      value={t_email_id}
      onChange={(e)=>setEmail(e.target.value)}
    />
  </FormGroup>
  <FormGroup className="mb-2 me-sm-2 mb-sm-0">
    <Label
      className="me-sm-2"
      for="t_password"
    >
      Password
    </Label>
    <Input
      id="t_password"
      name="t_password"
      placeholder="Enter Password"
      type="password"
      value={t_password}
      onChange={(e)=>setPassword(e.target.value)}
    />
  </FormGroup>
  <Button onClick={handleClick}>
    Submit
  </Button>
</Form> 
      </div>
      </div>
      <Footer/>
    </div>
  );
}

export default TransporterLogin;
