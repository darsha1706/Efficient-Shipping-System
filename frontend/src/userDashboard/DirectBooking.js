import React, { Component } from 'react'
import DirectBookingService from '../components/userService/DirectBookingService'
import { Button, Table } from 'reactstrap'
import NavBar from './NavBar'
import "../styles/Home.css";

export default class DirectBooking extends Component {

  
  constructor(props) {
    super(props)

    this.state = {
        transporters: [],
            estimated:[]
    }
    // this.addEmployee = this.addEmployee.bind(this);
    
}


getTransporterById(t_id){
    console.log(t_id);
   
    DirectBookingService.getTransporterById(t_id).then(res =>{
             
        this.setState({ estimated: res.data});
        localStorage.setItem('t_id',res.data.transporter.t_id)
        localStorage.setItem('range_0_200',res.data.range_0_200)
    localStorage.setItem('range_200_500',res.data.range_200_500)
    localStorage.setItem('range_500_above',res.data.range_500_above)
        console.log(this.state.estimated);
        
        window.location.href = "/estimatedPriceList"
        // this.setState({employees: this.state.estimated.filter(estimated => estimated.t_id == t_id)});
    });
}



componentDidMount(){
    DirectBookingService.getTransporters().then((res) => {
        this.setState({ transporters: res.data});
        console.log(this.state.transporters);
    });

    DirectBookingService.getTransporterById().then((res) => {
        this.setState({ estimated: res.data});
        console.log(this.state.estimated);
        localStorage.setItem('range_0_200',res.data.range_0_200)
    localStorage.setItem('range_200_500',res.data.range_200_500)
    localStorage.setItem('range_500_above',res.data.range_500_above)
    window.location.href = "/estimatedPriceList";
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
                  <th> Transporter First Name  </th>
                  <th>Transporter Last Name </th>
                  <th>Transporter Address </th>
                  <th>Estimated Price</th>

                
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
                                             <td> {transporter.t_address}</td>
                                             <td>
                                             
                                                 {/* <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.t_id)} className="btn btn-info">View </button> */}
                                                 <button style={{marginLeft: "20px"}} 
                                                  onClick={ () => this.getTransporterById(transporter.t_id)} 
                                                  className="btn btn-info">View estimated Price </button>
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

