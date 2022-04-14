import React, { useState } from 'react'
import NavBar from './NavBar'
// import "../styles/Home.css";
import { FormGroup, Input,Label,FormText,Form, Button } from 'reactstrap';
import { toast } from 'react-toastify';
import axios from 'axios';

export default function RegisterItem() {

  const[i_name,setItemName]=useState('')
  const[i_weight,setItemWeight]=useState('')
  const[pickup_date,setPickupDate]=useState('')
  const[pickup_location,setPickupLocation]=useState('')
  const[pickup_state,setPickupState]=useState('')
  const[pickup_city,setPickupCity]=useState('')
  const[delivery_date,setDeliveryDate]=useState('')
  const[delivery_city,setDeliveryCity]=useState('')
  const[delivery_state,setDeliveryState]=useState('')
  const[delivery_status,setDeliveryStatus]=useState('')
  const[delivery_location,setDeliveryLocation]=useState('')
  const[description,setDescription]=useState('')
  const[i_image,setItemImage]=useState('')
  
  const handleClick=(e)=>{
   
    const itemdetail = {i_name,i_weight,description,pickup_location,pickup_state,pickup_city,delivery_location,delivery_state,delivery_city,delivery_status,i_image,delivery_date,pickup_date}
    const c_id = JSON.parse(localStorage.getItem('c_id'));
    // console.log(itemdetail,cust_id);
    axios.post(`http://localhost:8080/customer/itemdetails`,itemdetail,{ params: {
      c_id
    }}).then(
      (response)=>{
         // toast.success('login successfull');
          console.log("success");
          console.log(response);
           window.location.href = "/items";
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
          <h1>Register Item</h1><br/>
  
  
  <FormGroup>
  <Label for="i_name">
      Item Name
    </Label>
    <Input
      id="i_name"
      name="i_name"
      placeholder="Item Name"
      type="text"
      value={i_name}
      onChange={(e)=>setItemName(e.target.value)}
    />
  </FormGroup>
 
  <FormGroup>
  <Label for="i_weight">
      Item Weight ( in kgs)
    </Label>
    <Input
      id="i_weight"
      name="i_weight"
      placeholder="Item Weight"
      type="text"
      value={i_weight}
      onChange={(e)=>setItemWeight(e.target.value)}
    />
  </FormGroup>
  <FormGroup hidden>
    <Label for="pickup_date" >
      Pickup Date
    </Label>
    <Input
      id="pickup_date"
      name="pickup_date"
      placeholder="Pickup Date"
      type="date"
      value={pickup_date}
      onChange={(e)=>setPickupDate(e.target.value)}
    />
  </FormGroup>
  {/* <FormGroup>
    <Label for="exampleTime">
      Pickup Time
    </Label>
    <Input
      id="exampleTime"
      name="Pickup time"
      placeholder="Pickup time "
      type="time"
    />
  </FormGroup> */}
  <FormGroup>
    <Label for="pickup_location">
      Pickup Location
    </Label>
    <Input
      id="pickup_location"
      name="pickup_location"
      placeholder="Pickup Location "
      type="text"
      value={pickup_location}
      onChange={(e)=>setPickupLocation(e.target.value)}
    />
  </FormGroup>

  <FormGroup>
    <Label for="pickup_state">
      Pickup State
    </Label>
    <Input
      id="pickup_state"
      name="pickup_state"
      placeholder="Pickup State "
      type="text"
      value={pickup_state}
      onChange={(e)=>setPickupState(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
    <Label for="pickup_city">
      Pickup City
    </Label>
    <Input
      id="pickup_city"
      name="pickup_city"
      type="select"
      value={pickup_city}
      onChange={(e)=>setPickupCity(e.target.value)}
    >
       <option value="none" selected disabled >
         Select an Option
         </option>
      <option active>
        Pune
      </option>
      <option>
       Mumbai
      </option>
      <option>
       Delhi
      </option>
      <option>
       Kolhapur
      </option>
      <option>
       Nashik
      </option>
      <option>
       Baramati
      </option>
      <option>
       Nagpur
      </option>
    </Input>
  </FormGroup>
  
  
  
  
  <FormGroup hidden>
    <Label for="delivery_date" > 
      Delivery Date
    </Label>
    <Input
      id="delivery_date"
      name="delivery_date"
      placeholder="Delivery Date"
      type="date"
      value={delivery_date}
      onChange={(e)=>setDeliveryDate(e.target.value)}
    />
  </FormGroup>
  {/* <FormGroup>
    <Label for="exampleTime">
     Delivery Time
    </Label>
    <Input
      id="exampleTime"
      name="Delivery time"
      placeholder="Delivery time "
      type="time"
    />
  </FormGroup> */}
  
  


  <FormGroup>
    <Label for="delivery_city">
      Delivery City
    </Label>
    <Input
      id="delivery_city"
      name="delivery_city"
      type="select"
      value={delivery_city}
      onChange={(e)=>setDeliveryCity(e.target.value)}
    >
       <option value="none" selected disabled>
         Select an Option
         </option>
      <option>
        Pune
      </option>
      <option>
       Mumbai
      </option>
      <option>
       Delhi
      </option>
      <option>
       Kolhapur
      </option>
      <option>
       Nashik
      </option>
      <option>
       Baramati
      </option>
      <option>
       Nagpur
      </option>
    </Input>
  </FormGroup>
  <FormGroup>
    <Label for="delivery_state">
      Delivery State
    </Label>
    <Input
      id="delivery_state"
      name="delivery_state"
      placeholder="Delivery State "
      type="text"
      value={delivery_state}
      onChange={(e)=>setDeliveryState(e.target.value)}
    />
  </FormGroup>

  <FormGroup>
    <Label for="delivery_location">
      Delivery Location
    </Label>
    <Input
      id="delivery_location"
      name="delivery_location"
      placeholder="Delivery Location "
      type="text"
      value={delivery_location}
      onChange={(e)=>setDeliveryLocation(e.target.value)}
    />
  </FormGroup>
  <FormGroup>
    <Label for="description">
      Item Description( Enter PinCode)
    </Label>
    <Input
      id="description"
      name="description"
      type="textarea"
      value={description}
      onChange={(e)=>setDescription(e.target.value)}
    />
  </FormGroup>
  {/* <FormGroup>
    <Label for="i_image">
      Item Image( .png , .jpg , .jpeg)
    </Label>
    <Input
      id="i_image"
      name="i_image"
      type="file"
      value={i_image}
      onChange={(e)=>setItemImage(e.target.value)}
    />
   
  </FormGroup>
   */}
  <FormGroup>
  <Label for="i_image">
      Item image
    </Label>
    <Input
      id="i_image"
      name="i_image"
      type="text"
      value={i_image}
      onChange={(e)=>setItemImage(e.target.value)}
    />
  </FormGroup>
  <FormGroup check>
    <Input type="checkbox" />
    <Label check>
      Check me out
    </Label>
  </FormGroup>
  <Button
  onClick={handleClick}
  >
    Submit
  </Button>
</Form>
     
    </div>
  )
}
