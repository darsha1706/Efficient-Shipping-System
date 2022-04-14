import React, { Component } from 'react'
import { Table } from 'reactstrap'

import DirectBookingService from '../components/userService/DirectBookingService'

import NavBar from './NavBar'

export default class ManageCustomers extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            customers: [],
           
        }
      
    }

    //for transporter verification

    onSubmit(c_id)
    {
      console.log(c_id);
     
      const requestOption=
      {
        method:'PUT',
        headers:{
          'Content-Type':'application/json'
        },
        body: JSON.stringify({ title: 'React PUT Request Example' })
        
      }
     
        fetch(`http://localhost:8080/admin/customer/${c_id}`,requestOption).then(
          resp=>resp.text()
          ).then(()=> {
            console.log("status changed successfully");
        window.location.href = "/manageCustomers";
      })
    } 
 
    
   
    componentDidMount(){
       

        DirectBookingService.getCustomers().then((res) => {
            this.setState({ customers: res.data});
            console.log(this.state.customers);
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
                  <th>  First Name  </th>
                  <th>Last Name </th>
                  <th>Email Id</th>
                  <th> Address </th>
                  <th>Phone Number</th>
                  
                  <th>BlackList</th>
                  
                  <th>Block/Clear</th>
                
                </tr>
              </thead>
              <tbody>
              {
                                    this.state.customers.map(
                                        customer => 
                                        <tr key = {customer.c_id}>
                                            <td>{customer.c_id}</td>
                                             <td> { customer.c_first_name} </td>   
                                             <td> {customer.c_last_name}</td>
                                             <td> {customer.c_email_id}</td>
                                             <td> {customer.c_address}</td>
                                             <td> {customer.c_phone_no}</td>
                                           
                                            
                                             <td> {customer.c_blacklist}</td>
                                           
                                               <td>
                                               <button style={{marginLeft: "10px"}} 
                                            onClick={ () => this.onSubmit(customer.c_id)} 
                                            className="btn btn-info"
                                            
                                            >Block/Clear </button>
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
