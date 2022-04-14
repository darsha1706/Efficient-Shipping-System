import React, { Component, useState } from 'react'
import NavBar from './NavBar'
import "../styles/Home.css";
import { Button, Col, Form, FormGroup, Input, Label, Row } from 'reactstrap';

export default function CPayment() {

  const[account_number,setAccountNumber]=useState('')
  // const[c_payment,setPayment]=useState('')

  const c_payment = JSON.parse(localStorage.getItem('b_price'));


const submitForm = (e) => {
 const i_id = JSON.parse(localStorage.getItem('i_id'));
  const c_id =JSON.parse(localStorage.getItem('c_id'));
  const c_payment = JSON.parse(localStorage.getItem('b_price'));

  console.log(c_payment,i_id,c_id,account_number);
    const url = "http://localhost:8080/customer/payment?c_id=" + c_id + "&i_id=" + i_id;
    const paymentdetails = {account_number,c_payment};
    fetch(url,
      {
       
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(paymentdetails)
    }
    ).then(response => response.json())
            .then(data => 
                {
                        // console.log(url);
                        
                        console.log(data);       
            });
            alert("Payment Done SuccessFully");
            window.location.href="/items";

}

  
    return (
      <div>
        <NavBar/>
        <div style={{paddingTop:"120px", paddingLeft:"20px" , paddingRight:"20px" }}>

        <Form style={{paddingTop:"120px"}}>
      <h3>Enter Account Number</h3><br/>

  <Row form>
    <Col md={6}>
      <FormGroup>
          <Input
          id="account_number"
          name="account_number"
          placeholder="Enter your Account No"
          type="text"
          value={account_number}
          onChange={(e)=>setAccountNumber(e.target.value)}
        />
      </FormGroup>
      <FormGroup>
          <Input
          id="c_payment"
          name="c_payment"
          // placeholder="Enter your Account No"
          // type="text"
          value={c_payment}
          // value={this.state.b_price}
          readOnly= {true}
          // onChange={this.handleChange1}
        />
      </FormGroup>


      <FormGroup check>
    <Input type="checkbox"
        />
    
    <Label check>
     Terms & Conditions : Your Kilometer Range should be accurate if not then I will add penalty to your payment
    </Label>
  </FormGroup>
    </Col>
    </Row>
    <Button
   onClick={submitForm}
    > 
    Submit
  </Button>
</Form>
            </div> 
      </div>
    )
  }

