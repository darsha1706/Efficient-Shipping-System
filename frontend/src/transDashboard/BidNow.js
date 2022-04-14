import React, { Component } from 'react'
import NavBar from './NavBar'
import "../styles/Home.css";
import { Button, Col, Form, FormGroup, Input, Label, Row } from 'reactstrap';

export default class BidNow extends Component {

    constructor(props) {
        super(props);
        this.state = {
            price: "",
            t_id: JSON.parse(localStorage.getItem('t_id')),
            a_item_id: JSON.parse(localStorage.getItem('a_item_id')),
            c_id: JSON.parse(localStorage.getItem('c_id')),
          
        }
      }
      handleChange1 = (a) => {
        this.setState({ price: a.target.value });
        console.log(this.state.price);
    
    }
    
    submitForm = (e) => {
      
      console.log(this.state.t_id,this.state.a_item_id,this.state.c_id,this.state.price);
        const url = "http://localhost:8080/transporter/bidder?t_id=" + this.state.t_id + "&a_item_id=" + this.state.a_item_id + "&c_id=" + this.state.c_id + "&price=" + this.state.price;
        fetch(url,{method:"POST"}
        ).then(response => response.json())
                .then(data => 
                    {
                            // console.log(url);
                            console.log(data);       
                });
                alert("Bid Done Successfully");
                window.location.href="/auctionDetails";
    
    }
    
  render() {
    return (
        <div>
        
        <NavBar/>
        <Form style={{paddingTop:"120px"}}>
        <b><h3>Enter Your Bidding Amount</h3></b><br/>
  
    <Row form>
      <Col md={6}>
        <FormGroup>
            <Input
            id="price"
            name="price"
            placeholder="Enter your Bidding Price"
            type="text"
            value={this.state.price}
            onChange={this.handleChange1}
          />
        </FormGroup>
        <FormGroup check>
      <Input type="checkbox"
          />
      {/* {' '} */}
      <Label check>
       Terms & Conditions : Confirm Your Bidding Price
      </Label>
    </FormGroup>
      </Col>
      </Row>
      <Button
     onClick={this.submitForm}
      > 
      Submit
    </Button>
  </Form>
       </div>
      
      )
    }
  }