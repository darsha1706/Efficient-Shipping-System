import React, { useState } from 'react'
import axios from 'axios'
// import React, { useState } from 'react'
import { toast } from 'react-toastify'
import { Button, Form, FormGroup, Input, Label } from 'reactstrap'
import NavBar from './NavBar'
export default function EstimatedPrice() {

    
  const[range_0_200,setRange1]=useState('')
  const[range_200_500,setRange2]=useState('')
  const[range_500_above,setRange3]=useState('')

  const handleClick=(e)=>{
   
    const itemdetail = {range_0_200,range_200_500,range_500_above}
    const t_id = JSON.parse(localStorage.getItem('t_id'));
    // console.log(itemdetail,cust_id);
    axios.post(`http://localhost:8080/transporter/estimatedprice`,itemdetail,{ params: {
      t_id
    }}).then(
      (response)=>{
         // toast.success('login successfull');
          console.log("success");
          console.log(response);
           window.location.href = "/transSetting";
          //localStorage.setItem('c_id',response.data.c_id)
          
      },
      (error)=>{
       
          // alert("Invalid Login Details",error);
          toast.error('invalid login');
          console.log(error);
          console.log("Error");
      }
  );
  } 


  return (
    <div>
    <NavBar/>
    <Form style={{paddingTop:"120px"}}>
        <h1>Estimated Price</h1>
        <h5>Fill your estimated price as per the weight of item per kg</h5>

        <FormGroup>
  <Label for="range_0_200">
   Range (0-200)Kms
  </Label>
  <Input
    id="range_0_200"
    name="range_0_200"
    type="text"
    value={range_0_200 }
    // value={this.state.range_0_200}
    onChange={(e)=>setRange1(e.target.value)}
  >
    
  </Input>
</FormGroup>

<FormGroup>
  <Label for="range_200_500">
   Range (200-500)Kms
  </Label>
  <Input
    id="range_200_500"
    name="range_200_500"
    type="text"
    value={range_200_500}
    onChange={(e)=>setRange2(e.target.value)}
  >
    
    
  </Input>
</FormGroup>

<FormGroup>
  <Label for="range_500_above">
   Range (500 & Above)Kms
  </Label>
  <Input
    id="range_500_above"
    name="range_500_above"
    type="text"
    value={range_500_above}
    onChange={(e)=>setRange3(e.target.value)}
  >
   
  </Input>
</FormGroup>

<div>
<Button
onClick={handleClick}
>
submit</Button>
</div>
        </Form>
  </div>
)
}
