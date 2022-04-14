import React, { Component } from 'react'
import { Table } from 'reactstrap'

import DirectBookingService from '../components/userService/DirectBookingService'

import NavBar from './NavBar'

export default class ManageTransporters extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            transporters: [],
           
        }
      
    }

    //for transporter verification

    onSubmit(t_id)
    {
      console.log(t_id);
     
      const requestOption=
      {
        method:'PUT',
        headers:{
          'Content-Type':'application/json'
        },
        body: JSON.stringify({ title: 'React PUT Request Example' })
        
      }
     
        fetch(`http://localhost:8080/admin/transverification/${t_id}`,requestOption).then(
          resp=>resp.text()
          ).then(()=> {
            console.log("status changed successfully");
        window.location.href = "/manageTransporters";
      })
    } 
 
    onSubmit1(t_id)
    {
      console.log(t_id);
     
      const requestOption=
      {
        method:'PUT',
        headers:{
          'Content-Type':'application/json'
        },
        body: JSON.stringify({ title: 'React PUT Request Example' })
        
      }
     
        fetch(`http://localhost:8080/admin/transblacklist/${t_id}`,requestOption).then(
          resp=>resp.text()
          ).then(()=> {
            console.log("status changed successfully");
        window.location.href = "/manageTransporters";
      })
    } 
   
    
   
    componentDidMount(){
       

        DirectBookingService.getTransporters1().then((res) => {
            this.setState({ transporters: res.data});
            console.log(this.state.transporters);
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
                  <th>Adhaar Number</th>
                  <th> Verification</th>
                  <th>BlackList</th>
                  <th>Verify</th>
                  <th>Block/Clear</th>
                
                </tr>
              </thead>
              <tbody>
              {
                                    this.state.transporters.map(
                                        transporter => 
                                        <tr key = {transporter.t_id}>
                                            <td>{transporter.t_id}</td>
                                             <td> { transporter.t_first_name} </td>   
                                             <td> {transporter.t_last_name}</td>
                                             <td> {transporter.t_email_id}</td>
                                             <td> {transporter.t_address}</td>
                                             <td> {transporter.t_ph_no}</td>
                                             <td> {transporter.t_aadhar_no}</td>
                                             <td> {transporter.t_verification}</td>
                                             <td> {transporter.t_blacklist}</td>
                                             <td>
                                            <button style={{marginLeft: "10px"}} 
                                            onClick={ () => this.onSubmit(transporter.t_id)} 
                                            className="btn btn-warning"
                                            
                                            >Verify </button>
                                               </td>
                                               <td>
                                               <button style={{marginLeft: "10px"}} 
                                            onClick={ () => this.onSubmit1(transporter.t_id)} 
                                            className="btn btn-info"
                                            
                                            >Block/Clear </button>
                                               </td>
                                             {/* <button style={{marginLeft: "20px"}}  
                                             onClick={ () => this.onSubmit(transporter.t_id)} 
                                             className="btn btn-info">Block / Clear </button> */}
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
