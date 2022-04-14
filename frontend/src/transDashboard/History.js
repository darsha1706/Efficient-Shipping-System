import React, { Component } from 'react'
import { Button, Card, CardText, CardTitle, Col, Row, Table } from 'reactstrap'
import DirectBookingService from '../components/userService/DirectBookingService'
import NavBar from './NavBar'

export default class History extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            history: [],
          
           
        }
      
    }

    componentDidMount(){
       

        DirectBookingService.getHistory().then((res) => {
            this.setState({ history: res.data});
            console.log(this.state.history);
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
        <b>Transporter History</b>
      </CardTitle>
      <CardText>
      <Table bordered striped>
              <thead>
                <tr>
                  <th>No</th>
                  <th> Item Name  </th>
                  <th>Item Weight </th>
                  <th>Item Pickup City</th>
                  <th>Item Delivery City</th>
                  <th>Bidding Price</th>
                  <th>Customer Name</th>
                  <th>Customer Contact No</th>
                 
                  <th>Bidding Selection status</th>
                  </tr>
              </thead>
              <tbody>
                  {
                       this.state.history.map(
                        dhistory => 
                        <tr key={dhistory.b_id}>
                            <td>{dhistory.b_id}</td>
                           <td>  {dhistory.item_detail[0].i_name} </td> 
                           <td>  {dhistory.item_detail[0].i_weight} </td>  
                           <td>  {dhistory.item_detail[0].pickup_city} </td>  
                           <td>  {dhistory.item_detail[0].delivery_city} </td>  
                           
                           <td>  {dhistory.b_price} </td> 
                           <td>{dhistory.customer[0].c_first_name} {dhistory.customer[0].c_last_name}</td>
                           <td>{dhistory.customer[0].c_phone_no}</td>
                           <td> {dhistory.b_selection_status}</td>

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
