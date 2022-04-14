import React ,{ useState } from 'react'
import { Button, Form, FormGroup, FormText, Input, Label } from 'reactstrap'
import Footer from '../components/Footer'
import Navbar from '../components/Navbar'

export default function TransporterRegister() {

  const[t_first_name,setFirstName]=useState('')
  const[t_middle_name,setMiddleName]=useState('')
  const[t_last_name,setLastName]=useState('')
  const[t_email_id,setEmail]=useState('')
  const[t_password,setPassword]=useState('')
  const[t_aadhar_no,setAadhar]=useState('')
  const[t_ph_no,setPhoneNumber]=useState('')
  const[t_address,setAddress]=useState('')
  
  const handleClick=(e)=>{
    e.preventDefault()
    const transporter = {t_first_name,t_middle_name,t_last_name,t_email_id,t_password,t_aadhar_no,t_ph_no,t_address}
    console.log(transporter);
    fetch("http://localhost:8080/home/transporter",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(transporter)
    }).then(()=>{
      window.location.href = "contact";
      console.log("new transporter added")
    })
  } 
  return (
    <div>
     <Navbar/>
     <Form>
          <h1>Transporter Register</h1>
          <FormGroup>
   
    <Input
      id="t_first_name"
      name="t_first_name"
      placeholder="First Name"
      value={t_first_name}
      onChange={(e)=>setFirstName(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
    
    <Input
      id="t_middle_name"
      name="t_middle_name"
      placeholder=" Middle Name"
      value={t_middle_name}
      onChange={(e)=>setMiddleName(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
   
    <Input
      id="t_last_name"
      name="t_last_name"
      placeholder="Last Name"
      value={t_last_name}
      onChange={(e)=>setLastName(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
    
    <Input
      id="t_email_id"
      name="t_email_id"
      placeholder="Email Id"
      type="email"
      value={t_email_id}
      onChange={(e)=>setEmail(e.target.value)}
    />

  </FormGroup>
  <FormGroup>
   
    <Input
      id="t_password"
      name="t_password"
      placeholder="Password"
      type="password"
      value={t_password}
      onChange={(e)=>setPassword(e.target.value)}
    />
  </FormGroup>

  <FormGroup>
    
    <Input
      id="exampleCPassword"
      name="cpassword"
      placeholder="Confirm password"
      type="password"
    />
  </FormGroup>
  <FormGroup>
   
   <Input
     id="t_ph_no"
     name="t_ph_no"
     placeholder="Phone Number"
     value={t_ph_no}
     onChange={(e)=>setPhoneNumber(e.target.value)}
   />
 </FormGroup>
 <FormGroup>
   
   <Input
     id="t_aadhar_no"
     name="t_aadhar_no"
     placeholder="Aadhar Number"
     value={t_aadhar_no}
     onChange={(e)=>setAadhar(e.target.value)}
   />
 </FormGroup>
  <FormGroup>
   
    <Input
      id="t_address"
      name="t_address"
      type="textarea"
      placeholder="Address"
      value={t_address}
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
