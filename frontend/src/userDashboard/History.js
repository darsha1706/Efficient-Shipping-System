import React, { Component } from 'react'
import { Button, Card, CardText, CardTitle, Col, Row, Table } from 'reactstrap'
import DirectBookingService from '../components/userService/DirectBookingService'
import NavBar from './NavBar'

export default class History extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            directhistory: [],
            auctionhistory: [],
            bidders: [],
           
        }
      
    }
    getBiddersById(a_item_id){
      console.log(a_item_id);
      localStorage.setItem("a_item_id",a_item_id);
    
        
          // console.log(this.state.bidders);
            window.location.href = "/checkBidderHistory";
          
        
         
     
  }

    componentDidMount(){
       

        DirectBookingService.getDirectHistory().then((res) => {
            this.setState({ directhistory: res.data});
            console.log(this.state.directhistory);
        });
      
        DirectBookingService.getAuctionItemHistory().then((res) => {
            this.setState({ auctionhistory: res.data});
            console.log(this.state.auctionhistory);
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
        <b>Direct Booking History</b>
      </CardTitle>
      <CardText>
      <Table bordered striped>
              <thead>
                <tr>
                  <th>No</th>
                  <th> Item Name  </th>
                  <th>Item Weight </th>
                  <th>Item Pickup Date</th>
                  <th>Item Delivery Date</th>
                  <th>Transporter Name</th>
                  <th>Transporter Contact No</th>
                  <th>status</th>
                  </tr>
              </thead>
              <tbody>
                  {
                       this.state.directhistory.map(
                        dhistory => 
                        <tr key={dhistory.item_detail[0].i_id}>
                            <td>{dhistory.item_detail[0].i_id}</td>
                           <td>  {dhistory.item_detail[0].i_name} </td> 
                           <td>  {dhistory.item_detail[0].i_weight} </td>  
                           <td> {dhistory.item_detail[0].pickup_date}</td>
                           <td> {dhistory.item_detail[0].delivery_date}</td>
                           <td>  {dhistory.transporter.t_first_name} {dhistory.transporter.t_last_name}</td> 
                           <td> {dhistory.transporter.t_ph_no}</td>
                           <td> {dhistory.item_detail[0].operation_status}</td>

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
  <Col sm="12">
    <Card body>
      <CardTitle tag="h5">
       <b>Auction Item History</b>
      </CardTitle>
      <CardText>
      <Table bordered striped>
              <thead>
                <tr>
                  <th>No</th>
                  <th> Item Name  </th>
                  <th>Lowest Bid Price </th>
                  <th>Highest Bid Price</th>
                  <th>status</th>
                  <th>Timer</th>
                  <th>Check Bidder</th>
                  </tr>
              </thead>
              <tbody>
                  {
                       this.state.auctionhistory.map(
                        ahistory => 
                        <tr key={ahistory.a_item_id}>
                            <td>{ahistory.a_item_id}</td>
                            <td>{ahistory.item_detail.i_name}</td>
                            <td>{ahistory.lowest_bid_price}</td>
                            <td>{ahistory.highest_bid_price}</td>
                           <td>  {ahistory.a_item_status} </td> 
                           <td>{ahistory.timer}</td>
                           <td>
                          
                             <Button 
                             name="submit" 
                             
                             style={{marginLeft: "20px"}} 
                             className="btn btn-info"
                             onClick={ () => this.getBiddersById(ahistory.a_item_id)}
                             >Check Bidder
                            
                             </Button>
                             </td>
                            
                           
                          
                        </tr>
                       )
                  }
              </tbody>
        </Table>
      </CardText>
      
    </Card>
  </Col>
</Row>

        </div>
      </div>
    )
  }
}
