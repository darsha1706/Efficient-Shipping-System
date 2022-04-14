import axios from "axios";
import React ,{ useState }from "react";
import { Link } from "react-router-dom";
import { toast ,ToastContainer} from "react-toastify";
import { Button, Card, CardText, CardTitle, Col, Form, FormGroup, Input, Label, Row } from "reactstrap";
import custLoginImg from "../assets/custLogin.jpg";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import "../styles/Contact.css";

function CustomerLogin() {

  const[c_email_id,setEmail]=useState('')
  const[c_password,setPassword]=useState('')

  


  
  const handleClick=()=>{
    const login = {c_email_id,c_password }
    
    axios.post(`http://localhost:8080/home/custlogin`,login).then(
        (response)=>{
           // toast.success('login successfull');
            console.log("success");
            console.log(response);
             window.location.href = "/items";
            localStorage.setItem('c_id',response.data.c_id)
            
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
 
    <Navbar></Navbar>
    <div className="contact">
      <div
        className="leftSide"
        style={{ backgroundImage: `url(${custLoginImg})` }}
      >
        {/* //leftside */}
        
        </div>
      <div className="rightSide">
        <h1> Login as Customer</h1>

        <Form inline>
  <FormGroup className="mb-2 me-sm-2 mb-sm-0">
    <Label
      className="me-sm-2"
      for="c_email_id"
    >
      Email
    </Label>
    <Input
      id="c_email_id"
      name="c_email_id"
      placeholder="Enter Email"
      type="email"
      value={c_email_id}
      onChange={(e)=>setEmail(e.target.value)}
    />
  </FormGroup>
  <FormGroup className="mb-2 me-sm-2 mb-sm-0">
    <Label
      className="me-sm-2"
      for="examplePassword"
    >
      Password
    </Label>
    <Input
      id="c_password"
      name="c_password"
      placeholder="Enter Password"
      type="password"
      value={c_password}
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

export default CustomerLogin;
