import React, { Component } from 'react'
import DirectBookingService from '../components/userService/DirectBookingService'
import { Button, Card, CardText, CardTitle, Col, Row, Table } from 'reactstrap'
import NavBar from './NavBar'

export default class CheckPayments extends  Component {

  constructor(props) {
    super(props)

    this.state = {
        payments: [],
      
       
    }
  
}
componentDidMount(){
       

  DirectBookingService.getPayments().then((res) => {
      this.setState({ payments: res.data});
      console.log(this.state.payments);
  });

 
}
render() {
  return (
    <div>
      <NavBar/>
      <div style={{paddingTop:"120px", paddingLeft:"20px" , paddingRight:"20px" }}>

      <Row>
<Col sm="12">
  <Card body>
    <CardTitle tag="h5">
      <b>Transporter Payment History</b>
    </CardTitle>
    <CardText>
    <Table bordered striped>
            <thead>
              <tr>
                <th>No</th>
                <th> Item Name  </th>
                <th>Item Weight </th>
               
                <th>Customer Name</th>
                <th>Item Booking Status</th>
                <th>Payment </th>
                
                </tr>
            </thead>
            <tbody>
                {
                     this.state.payments.map(
                      payment => 
                      <tr key={payment.transaction_id}>
                          <td>{payment.transaction_id}</td>
                         <td>  {payment.item_detail.i_name} </td> 
                         <td>  {payment.item_detail.i_weight} </td> 
                         <td>{payment.c_name}</td>
                         <td>{payment.item_detail.operation_status}</td>
                         <td>  {payment.t_payment} </td>  
                         
                        

                      </tr>
                     )
                }
            </tbody>
      </Table>
    </CardText>
    
  </Card>

</Col>
<br></br>
  <Row></Row>                 

</Row>

      </div>
    </div>
  )
}
}
