import React, { Component } from 'react'
import EmployeeService from '../components/userService/DirectBookingService'

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            t_id: this.props.match.params.t_id,
            employee: {}
        }
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.t_id).then( res => {
            this.setState({employee: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Transporter Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Transporter First Name: </label>
                            <div> { this.state.employee.t_first_name }</div>
                        </div>
                        <div className = "row">
                            <label> Transporter Last Name: </label>
                            <div> { this.state.employee.t_first_name }</div>
                        </div>
                        <div className = "row">
                            <label> Addree : </label>
                            <div> { this.state.employee.t_address }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewEmployeeComponent