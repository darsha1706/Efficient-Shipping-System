import React, { Component } from 'react'
import { Button, Table } from 'reactstrap'
import NavBar from './NavBar'
import "../styles/Home.css";


const range_200_500 = JSON.parse(localStorage.getItem('range_200_500'));
const range_0_200 = JSON.parse(localStorage.getItem('range_0_200'));
const range_500_above = JSON.parse(localStorage.getItem('range_500_above'));
export default class EstimatedPriceList extends Component {

  
  
  render() {
    
  return (
    
    <div>
    <NavBar/>
    <div style={{paddingTop:"120px", paddingLeft:"20px" , paddingRight:"20px" }}>
    <Table bordered striped>

               <thead>
                   <tr>
                       
                       <th> Rage1</th>
                       <th> Range2</th>
                       <th> Range 3</th>
                       <th> Actions</th>
                   </tr>
               </thead>
               <tbody>
                  
                            <tr>   
                                <td> {range_0_200} </td>   
                                <td> {range_200_500}</td>
                                <td> {range_500_above}</td>
                                <td><Button name="submit" href ="/kilometerRangeForm" style={{marginLeft: "20px"}} className="btn btn-info">Proceed</Button></td>
                               
                           </tr>

                           </tbody>
           </Table>

    </div>

</div>
                       )
                   }
              
  
}

