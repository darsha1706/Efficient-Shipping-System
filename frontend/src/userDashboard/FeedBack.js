import React, { useState } from 'react'
import NavBar from './NavBar'
import "../styles/Home.css";
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';

export default function FeedBack() {

  
  const[i_id,setIId]=useState('')
  const[t_id,setTId]=useState('')
  const[description,setDescription]=useState('')
  
  const handleClick=(e)=>{
    
    const c_id = JSON.parse(localStorage.getItem('c_id'));

  console.log("c_id is "+c_id);
  // console.log("i_id" +i_id);
    const customer = {description}
    
    const url = "http://localhost:8080/customer/feedback?c_id=" +c_id;
    console.log(url);
    fetch(url,{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(customer)
    }).then(()=>{
      alert("your feedback is successfully submitted")
      window.location.href="/feedback";
      console.log("new feedback added")
    })
  } 

  return (
    <div>
      <NavBar/>
      <div className="home" >
   
      <div className="headerContainer">
        <h1 style={{color:"black"}}>Feedback and Complaint</h1><br></br>
        
        <br></br>
       
        
      </div>
      
      <Form inline>
 
 
  
  {' '}
  {/* <FormGroup>
    <Label
      for="i_id"
      hidden
    >
      Item ID
    </Label>
    <Input
      id="i_id"
      name="i_id"
      placeholder="Item ID"
      type="text"
      // value={i_id}
      value={i_id === null ? '-1' : i_id}

      onChange={(e)=>setIId(e.target.value)}
     
    />
  </FormGroup> */}
  {' '}
  {/* <FormGroup>
    <Label
      for="t_id"
      hidden
    >
      Transporter Id
    </Label>
    <Input
      id="t_id"
      name="t_id"
      placeholder="Transporter ID"
      type="text"
      value={t_id}
      // value={t_id === null ? '' : this.state[row_array[0]]}

      onChange={(e)=>setTId(e.target.value)}
   
    />
  </FormGroup> */}
  {' '}
  <FormGroup>
    <Label
      for="description"
      hidden
    >
      Description
    </Label>
    <Input
      id="description"
      name="description"
      placeholder="Description"
      type="textarea"
      value={description}
      
      onChange={(e)=>setDescription(e.target.value)}
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
  )
}
