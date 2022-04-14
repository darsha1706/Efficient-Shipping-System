import React, { useState } from 'react'
import { Button, Form, FormGroup, FormText, Input, Label } from 'reactstrap'
import Footer from '../components/Footer'
import Navbar from '../components/Navbar'


export default function CustomerRegister() 
{
  const[c_first_name,setFirstName]=useState('')
  const[c_middle_name,setMiddleName]=useState('')
  const[c_last_name,setLastName]=useState('')
  const[c_email_id,setEmail]=useState('')
  const[c_password,setPassword]=useState('')
  const[Cpassword,setCPassword]=useState('')
  const[c_phone_no,setPhoneNumber]=useState('')
  const[c_address,setAddress]=useState('')
  
  const handleClick=(e)=>{
    e.preventDefault()
    const customer = {c_first_name,c_middle_name,c_last_name,c_email_id,c_password,c_phone_no,c_address}
    console.log(customer);
    fetch("http://localhost:8080/home/customer",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(customer)
    }).then(()=>{
      window.location.href = "/contact";
      console.log("new customer added")
    })
  } 

  return (
    <div>
      <Navbar/>
      <Form>
          <h1>Customer Register</h1>
          <FormGroup>
   
    <Input
      id="c_first_name"
      name="c_first_name"
      placeholder="First Name"
      value={c_first_name}
      onChange={(e)=>setFirstName(e.target.value)}
      
    />
  </FormGroup>
  <FormGroup>
    
    <Input
      id="c_middle_name"
      name="c_middle_name"
      placeholder=" Middle Name"
      value={c_middle_name}
      onChange={(e)=>setMiddleName(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
   
    <Input
      id="c_last_name"
      name="c_last_name"
      placeholder="Last Name"
      value={c_last_name}
      onChange={(e)=>setLastName(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
    
    <Input
      id="c_email_id"
      name="c_email_id"
      placeholder="Email Id"
      type="email"
      value={c_email_id}
      onChange={(e)=>setEmail(e.target.value)}
    />

  </FormGroup>
  <FormGroup>
   
    <Input
      id="c_password"
      name="c_password"
      placeholder="Password"
      type="password"
      value={c_password}
      onChange={(e)=>setPassword(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
    
    <Input
      id="cpassword"
      name="cpassword"
      placeholder="Confirm password"
      type="password"
      // value={Cpassword}
      // onChange={(e)=>setCPassword(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
   
   <Input
     id="c_phone_no"
     name="c_phone_no"
     placeholder="Phone Number"
     value={c_phone_no}
      onChange={(e)=>setPhoneNumber(e.target.value)}
   />
 </FormGroup>
  
  
  <FormGroup>
   
    <Input
      id="c_address"
      name="c_address"
      type="textarea"
      placeholder="Address"
      value={c_address}
      onChange={(e)=>setAddress(e.target.value)}
    />
  </FormGroup>
  
  
    
   
 
  <FormGroup check>
    <Input type="checkbox" />
    {' '}
    <Label check>
     Accept the terms
    </Label>
  </FormGroup>

  <Button 
  onClick={handleClick}
  >
    Submit
  </Button>
</Form>
<Footer/>
    </div>
  )
}
