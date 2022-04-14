import React, { Component } from 'react'
import { Table } from 'reactstrap';
import DirectBookingService from '../components/userService/DirectBookingService';
import NavBar from './NavBar';

export default class CheckBidder extends Component {

  constructor(props) {
    super(props)

    this.state = {
        bidders: [],
       
    }
  
}

onSubmit(b_id)
    {
      console.log("b_id is: "+b_id);
      const a_item_id = JSON.parse(localStorage.getItem('a_item_id'));
      console.log("auction item id is: "+a_item_id);
      const requestOption=
      {
        method:'PUT',
        headers:{
          'Content-Type':'application/json'
        },
        body: JSON.stringify({ title: 'React PUT Request Example' })
        
      }
     
        fetch(`http://localhost:8080/customer/bidder/${b_id}/${a_item_id}`,requestOption).then(
          response => response.json()
          ).then((data)=> {
           localStorage.setItem('b_price',data.b_price)
            alert("bidder selected successfully")
            console.log("Bidder selected sucessfully");
        window.location.href = "/cPayment";
      })
    } 

componentDidMount(){
       

  DirectBookingService.getBidders().then((res) => {
      this.setState({ bidders: res.data});
      console.log(this.state.bidders);
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
                  <th>  bidder Name  </th>
                  <th>bidder price </th>
                  <th>Selection Status</th>
                  
                 
                
                </tr>
              </thead>
              <tbody>
              {
                                    this.state.bidders.map(
                                        bidder => 
                                        <tr key = {bidder.b_id}>
                                            <td>{bidder.b_id}</td>
                                             <td> { bidder.b_name} </td>   
                                             <td> {bidder.b_price}</td>
                                             
                                             <td>
                                            {bidder.b_selection_status}
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
