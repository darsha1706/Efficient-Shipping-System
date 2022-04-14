import axios from "axios";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { Button, Card, CardText, CardTitle, Col, Form, FormGroup, Input, Label, Row } from "reactstrap";
import custLoginImg from "../assets/custLogin.jpg";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import "../styles/Contact.css";

function AdminLogin() {

  const[a_email_id,setEmail]=useState('')
  const[a_password,setPassword]=useState('')

  


  
  const handleClick=()=>{
    const login = {a_email_id,a_password }
    
    axios.post(`http://localhost:8080/home/adminlogin`,login).then(
        (response)=>{
           // toast.success('login successfull');
            console.log("success");
            console.log(response);
             window.location.href = "/manageCustomers";
            // localStorage.setItem('c_id',response.data.c_id)
            
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
        <h1> Login as Admin</h1>

        <Form inline>
  <FormGroup className="mb-2 me-sm-2 mb-sm-0">
    <Label
      className="me-sm-2"
      for="a_email_id"
    >
      Email
    </Label>
    <Input
      id="a_email_id"
      name="a_email_id"
      placeholder="Enter Email id"
      type="email"
      value={a_email_id}
      onChange={(e)=>setEmail(e.target.value)}
    />
  </FormGroup>
  <FormGroup className="mb-2 me-sm-2 mb-sm-0">
    <Label
      className="me-sm-2"
      for="a_password"
    >
      Password
    </Label>
    <Input
      id="a_password"
      name="a_password"
      placeholder="Enter Your Password"
      type="password"
      value={a_password}
      onChange={(e)=>setPassword(e.target.value)}
    />
  </FormGroup>
  <Button
  onClick={handleClick}
  >
    Submit
  </Button>
</Form> 
      </div>
      </div>
      <Footer/>
    </div>
  );
}

export default AdminLogin;
