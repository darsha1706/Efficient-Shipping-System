import React, { Component } from 'react'
import { Button, Table } from 'reactstrap'
import NavBar from './NavBar'
import DirectBookingService from '../components/userService/DirectBookingService'
import Cookies from 'universal-cookie';

const cookie = new Cookies();
const  a_end_date= cookie.get('a_end_date');
    // console.log(a_end_date);

export default class DirectBookingList extends Component{

  
  constructor(props) {
    super(props)

    this.state = {
        items: []
    }
  
}


getItemsById(i_id)
{
    console.log(i_id);
    localStorage.setItem('i_id',i_id);
    window.location.href = "/directBooking"
   
}

getItemsByIdAuction(i_id)
{
    console.log(i_id);
    localStorage.setItem('i_id',i_id);
   window.location.href = "/auctionItemForm"

   
}



componentDidMount(){
    DirectBookingService.getItems().then((res) => {
        this.setState({ items: res.data});
        // console.log(this.state.items);

    });

    

}
render() {

  return (
    <div>
      <NavBar/>
      <div style={{paddingTop:"120px", paddingLeft:"20px" , paddingRight:"20px" }}>
      <Table bordered striped>
  <thead>
    <tr>
      <th>No</th>
      <th> Item Name </th>
      <th> Item Weight</th>
      <th> Pickup City </th>
      <th>Delivery City</th>
      

      <th> Book Item </th>
    </tr>
  </thead>
  <tbody>
  {
                                    this.state.items.map(
                                        item_details => 
                                        <tr key = {item_details.i_id}>
                                           <td>{item_details.i_id}</td>
                           
                                        <td>{item_details.i_name}</td>
                                        <td>{item_details.i_weight}</td>
                                        <td>{item_details.pickup_city}</td>
                                        <td>{item_details.delivery_city}</td>
                                        
                                             <td>
                                             
                                                 {/* <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.i_id)} className="btn btn-info">View </button> */}
                                                 <button style={{marginLeft: "20px"}}  
                                                  onClick={ () => this.getItemsById(item_details.i_id)} 
                                                 className="btn btn-warning">  Check End Date</button>

                                               
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </Table>

                 </div>

            </div>
        )
    }
}
