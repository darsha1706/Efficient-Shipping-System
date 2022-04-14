import React from 'react';
import Logo from "../assets/trucklogo.png";
import { Collapse, DropdownItem, DropdownMenu, DropdownToggle, Nav, Navbar, NavbarBrand,  NavbarToggler, NavItem, NavLink, UncontrolledDropdown } from 'reactstrap';
import "../styles/Navbar.css";
import { Link } from "react-router-dom";
export default function NavBar() {
    const logo={
        height: "70px",
        width: "auto",
    }

    const onLogOutClick = () => {
      window.localStorage.clear();
  }

   
    
  return (
    <div>
      <div>
  <Navbar
    color="dark"
    dark
    expand="sm"
    fixed="top"
    full
  >
    <NavbarBrand href="/">
    <img src={Logo} style={logo}/>
    </NavbarBrand>
    <NavbarToggler onClick={function noRefCheck(){}} />
    <Collapse navbar>
      <Nav
        className="me-auto"
        navbar
      >
       
       <NavItem>
          <NavLink href="estimatedPrice">
           Estimated Price
          </NavLink>
        </NavItem>
       
        <NavItem>
          <NavLink href="auctiondetails">
        Check Auction Details
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="transHistory">
          History
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="checkPayment">
          Check Payments
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="pickupDelivery">
        PickuP & Delivery Management
          </NavLink>
        </NavItem>
       
        <NavItem>
          <NavLink href="/transFeedback">
           Feedback & Complaint
          </NavLink>
        </NavItem>
        
      </Nav>
      <NavItem>
      <NavLink onClick={onLogOutClick} href="/contact">
       Logout
      </NavLink>
      </NavItem>
    </Collapse>
  </Navbar>
</div>
    </div>
  )
}
