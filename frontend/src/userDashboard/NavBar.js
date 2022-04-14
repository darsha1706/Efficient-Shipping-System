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
          <NavLink href="/registerItem">
           Register Items
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="/auctionItemDetails">
           Auction Details
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="/items">
           Manage Items
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="/cHistory">
          History
          </NavLink>
        </NavItem>
        {/* <UncontrolledDropdown
          inNavbar
          nav
        >
          <DropdownToggle
            caret
            nav
          >
            Manage Items
          </DropdownToggle>
          <DropdownMenu right>
            <DropdownItem >
           
               Direct Booking
              
            </DropdownItem>
            <DropdownItem>
             Auction Items
            </DropdownItem>
            {/* <DropdownItem divider />
            <DropdownItem>
              Reset
            </DropdownItem> */}
          {/* </DropdownMenu>
        </UncontrolledDropdown> */} 
        <NavItem>
          <NavLink href="/feedback">
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
