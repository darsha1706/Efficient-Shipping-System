import React, { Component } from 'react'
import { Table } from 'reactstrap';
import DirectBookingService from '../components/userService/DirectBookingService';
import NavBar from './NavBar'

export default class CheckFeedback extends Component {

  constructor(props) {
    super(props)

    this.state = {
      feedback: [],
      
       
    }
  
}

componentDidMount(){
       

  DirectBookingService.getfeedback().then((res) => {
      this.setState({feedback: res.data});
      console.log(this.state.feedback);
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
                  <th>id</th>
                  <th>Customer  Name  </th>
                  <th>Transporter Name</th>
                  <th>Description </th>
                  
                  
                
                </tr>
              </thead>
              <tbody>
                                {
                                  this.state.feedback.map(
                                        user => 
                                        <tr key = {user.fc_id}>
                                          <td> {user.fc_id}</td>
                                            
                                             <td> { user.c_name} </td> 
                                             <td>{user.t_name}</td>  
                                             <td> {user.description} </td>
                                             
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
